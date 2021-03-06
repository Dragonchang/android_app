#include <iostream>
#include <sys/epoll.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>

pthread_t tid;
int sendMessageCount = 200;

int mWakeReadPipeFd;  // immutable
int mWakeWritePipeFd; // immutable
int mEpollFd; // immutable
volatile bool stop = false;
// Hint for number of file descriptors to be associated with the epoll instance.
static const int EPOLL_SIZE_HINT = 8;
// Maximum number of file descriptors for which to retrieve poll events each iteration.
static const int EPOLL_MAX_EVENTS = 16;

void sendMessage(int i) {
    printf("sendMessage begin tid:%d i= %d\n",(unsigned)pthread_self(), i);
    int nWrite;
    do {
        nWrite = write(mWakeWritePipeFd, "W", 1);
    } while (nWrite == -1 && errno == EINTR);

    if (nWrite != 1) {
        if (errno != EAGAIN) {
            printf("Could not write wake signal, errno=%d\n",errno);
        }
    }
    printf("sendMessage end tid:%d i= %d\n",(unsigned)pthread_self(), i);

}

void * run(void *arg)
{
    printf("run tid:%d\n",(unsigned)pthread_self());
    for (int i = 0;i < sendMessageCount;i++) {
      printf("run tid:%d send %d message\n",(unsigned)pthread_self(), i);
      sendMessage(i);
    }

   //sleep(60);
   printf("sendMessage end\n");
}


int main()
{
    int wakeFds[2];
    int result = pipe(wakeFds);
    if (result != 0) {
        printf("Could not make wake read pipe non-blocking!\n");
        return 0;
    }
    mWakeReadPipeFd = wakeFds[0];
    mWakeWritePipeFd = wakeFds[1];

    result = fcntl(mWakeReadPipeFd, F_SETFL, O_NONBLOCK);
    if (result != 0) {
        printf("Could not make wake read pipe non-blocking!\n");
        return 0;
    }

    result = fcntl(mWakeWritePipeFd, F_SETFL, O_NONBLOCK);
    if (result != 0) {
        printf("Could not make wake write pipe non-blocking!\n");
        return 0;
    }

    // Allocate the epoll instance and register the wake pipe.
    mEpollFd = epoll_create(EPOLL_SIZE_HINT);
    if (result != 0) {
        printf("Could not create epoll instance!\n");
        return 0;
    }

    struct epoll_event eventItem;
    memset(& eventItem, 0, sizeof(epoll_event)); // zero out unused members of data field union
    eventItem.events = EPOLLIN;
    eventItem.data.fd = mWakeReadPipeFd;
    result = epoll_ctl(mEpollFd, EPOLL_CTL_ADD, mWakeReadPipeFd, & eventItem);
    if (result != 0) {
        printf("Could not add wake read pipe to epoll instance!\n");
        return 0;
    }

    printf("main thread  tid:%d\n",(unsigned)pthread_self());
    int resut = pthread_create(&tid,0,run,0);
    if(resut != 0) {
        printf("thread create failed!\n");
        return 0;
    }
    int sleepcount = 0;
    while (!stop)
    {
        struct epoll_event eventItems[EPOLL_MAX_EVENTS];
        printf("epoll_wait begin\n");
        int eventCount = epoll_wait(mEpollFd, eventItems, EPOLL_MAX_EVENTS, -1);
        sleepcount ++;
        printf("epoll_wait end sleepcount = %d\n",sleepcount);
        printf("main thread handle message begin\n");
        sleep(1);
        printf("main thread handle message end\n");
    }
}



















