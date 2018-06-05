package com.example.testfl;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.util.Log;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.View;
import android.os.SystemClock;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.AsyncTask;
import android.util.AndroidRuntimeException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.Surface;
import TestService.*;
import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.NotificationManager;
//import android.view.SurfaceControl;
import android.app.PendingIntent;

import android.widget.Toast;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;

import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiConfiguration.KeyMgmt;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiEnterpriseConfig.Eap;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.io.IOException;
import java.text.Collator;

import android.database.DatabaseUtils;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.os.Environment;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.TypedValue;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import java.util.ArrayList;
import java.util.HashSet;


public class MainActivity extends Activity {
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    //private final ArrayList<Animator> mTmpArray = new ArrayList<>();
    private final SimpleConnection mLocalServiceConn = new SimpleConnection();
	int i;
	private Bitmap mScreenBitmap;
	public boolean StartserviceStatus = false; 
	public boolean BindserviceStatus = false; 
    HandlerThread mToastThread;
    Handler mToastThreadHandler;
//***********************************************************************************
	public class Myexception extends Exception
	{
		
		
	}
	private void test1()
	{
		try {
		    throw new Myexception();
		} catch(Exception e)
		{
			throw new AndroidRuntimeException(e);
		}
		//Log.i("testzfl","test1 end");
	}
	private void test2() 
	{
		Log.i("testzfl","test2 Begin");
		test1();
		Log.i("testzfl","test2 end");
	}
	private void Test3() {
        try{
			test2();
			//return;
        } catch(RuntimeException e)
        {
        	Log.i("testzfl","onCreate catch RuntimeException");
        } catch(Exception e)
        {
        	Log.i("testzfl","onCreate catch Exception");
        	return;
        	
        } finally {
        	Log.i("testzfl","onCreate finally");
        }		
	}
	 //********************************************************************	
	public class Test1 implements Cloneable {
		public int mValue1;
		public String mValue2;
		
		public Test1(int value1, String value2) {
			mValue1 = value1;
			mValue2 = value2;
		}
		public Test1 clone() { 
			try {
		        return (Test1) super.clone();
			} catch(CloneNotSupportedException e) {
				return null;
			}
		}
		public void setValue(int value1, String value2) {
			mValue1 = value1;
			mValue2 = value2;
		}
	}
	private void testCopyT1() {
		Test1 t1 = new	Test1(1,"test1");
		Test1 t2 = t1;//浅拷贝
		Log.i("testzfl","t2.mValue1 ="+t2.mValue1+" t2.mValue2 = "+t2.mValue2);
		Test1 t3 = t1.clone();//深拷贝
		Log.i("testzfl","t3.mValue1 ="+t3.mValue1+" t3.mValue2 = "+t3.mValue2);
		Log.i("testzfl","**************************after change t1");
		t1.setValue(2, "change value");
		Log.i("testzfl","t2.mValue1 ="+t2.mValue1+" t2.mValue2 = "+t2.mValue2);
		Log.i("testzfl","t3.mValue1 ="+t3.mValue1+" t3.mValue2 = "+t3.mValue2);
	}
	public class Test2 implements Cloneable {
		
	}
	 //********************************************************************	
	public class TestFinalize {
		
	    protected void finalize() throws Throwable {
	    	 Log.i("testzfl","TestFinalize finalize");
	    	 //Log.i("testzfl", "TestFinalize finalize callstack = " ,new Throwable("finalize"));
	        super.finalize();
	    }
		
	}
	
    public TestFinalize TestFinalizeFun(int i) {
    	TestFinalize testF = new TestFinalize();
    	return testF;
    }
    public void TestFinalizeFun(String str) {
    	TestFinalize testF = new TestFinalize();
    }
 //********************************************************************
    public  class testDestruct {
    	public testDestruct() {
    		//Log.i("testzfl", "testDestruct  callstack = " ,new Throwable("testDestruct"));
    	}
    }
    public class testDestruct2 {
    	 testDestruct test = new testDestruct();

    	 //static  final testDestruct2 test_4 = null;//new testDestruct2();
    	
    }
    static testDestruct2 test_3 ;//= new testDestruct2();
    static testClass mTestclass = new testClass();    
    static {
    	//test_3 = new testDestruct2();//null;
    }
 
    private void testFunDest() {
    	testDestruct2 t2 = new testDestruct2();
    }
	 public static void  tFun() {
		 System.out.println(System.class.getClassLoader());
	 }
    //**************************************************************************
	 //URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
	   //for (int j = 0; j < urls.length; j++) {
	     //System.out.println(urls.toExternalform());
	  // }
	 
    //****************************************************************************************************
	private static byte[] getCollationKeyInBytes(String name) {
	        if (mColl == null) {
	            mColl = Collator.getInstance();
	            mColl.setStrength(Collator.PRIMARY);
	        }
	        return mColl.getCollationKey(name).toByteArray();
	}

	private static Collator mColl = null;
    private static int getKeyLen(byte[] arr) {
        if (arr[arr.length - 1] != 0) {
            return arr.length;
        } else {
            // remove zero "termination"
            return arr.length-1;
        }
    }
    public static String getCollationKey(String name) {
    	Log.i("testzfl","getCollationKey****");
        byte [] arr = getCollationKeyInBytes(name);
        Log.i("testzfl","getCollationKey**** getKeyLen(arr) = "+ getKeyLen(arr));
        for (int l =0;l<getKeyLen(arr);l++) {
        	Log.i("testzfl","getCollationKey**** arr[] = "+ arr[l]);
        }
       
        try {
            return new String(arr, 0, getKeyLen(arr), "ISO8859_1");
        } catch (Exception ex) {
            return "";
        }
    }
	 int NtRequestCount = 0;
	 void test(int i) {
		 i =100;
	 }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		i++;
		test_3 = new testDestruct2();
		Log.i("testzfl","onCreate****");
		//testCopyT1();
		//int[] a=new int[3]; int b=a[3];
		//test3();
		//TestFinalizeFun();
		testFunDest();
        //Log.i("testzfl", " callstack = " ,new Throwable("onCreate"));
		
        mButton1 = (Button)findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Log.i("testzfl","onClick111");
            	//SystemClock.sleep(20000);
            	addNotification();
            	//testToast();
            	//mToastThreadHandler.sendEmptyMessage(1);
            	//onhanleNet();
            	//NtRequestCount = 0;
            	//new DataConnection().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            	//NtRequestCount = 1;
            	//new SecDataConnection().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            	//String 
            	
                //Log.e(TAG, "[fengjen] ----- name = " + name);
                //String key = DatabaseUtils.getCollationKey(".e.l.t.o.n. .j.o.h.n.");
                //Log.e(TAG, "[fengjen] ----- key = " + key);
                //Log.i("testzfl","***************************************");
            	  //Log.i("testzfl","DatabaseUtils.getCollationKey+ key = "+key);
            	  //key = getCollationKey(".e.l.t.o.n. .j.o.h.n.");
            	  //Log.i("testzfl","getCollationKey key = "+key);
            	//int i =2;
            	//test(i);
            	//Log.i("testzfl","onClick i = "+i); 
         	    //Intent intent = new Intent();
              //ComponentName mPlatLogoActivity = new ComponentName("com.example.testfl",
                       //"com.example.testfl.MydbActivity");
               //intent.setComponent(mPlatLogoActivity);
               //intent.setData(Uri.parse("newsrepublic://news?regionid=3&articleid=59579871&tagid=-1001&tagname=All my topics&source=blinkfeed"));
               //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               //intent.setAction(Intent.ACTION_VIEW);
           	// startActivity(intent);
              }
          });
        mButton2 = (Button)findViewById(R.id.button2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //TypedValue outValue = new TypedValue();
              //getTheme().resolveAttribute(
                        //android.R.attr.selectableItemBackground, outValue, true);
            	//mToastThreadHandler.sendEmptyMessage(2);
            	//System.exit(1);
            	//moveNoification();
                
         	    Intent intent = new Intent();
              ComponentName mPlatLogoActivity = new ComponentName("com.example.testfl",
                       "com.example.testfl.AnimatorTestActivity");
               intent.setComponent(mPlatLogoActivity);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.setAction(Intent.ACTION_VIEW);
           	 startActivity(intent);
            }
          });
        
        mButton3 = (Button)findViewById(R.id.button3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	onClick3();
            }
          });
        mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mToastThread = new HandlerThread("testtoast");
        mToastThread.start();
        mToastThreadHandler = new Handler(mToastThread.getLooper()) {
        	public void handleMessage(final Message msg) {
        		Log.i("testzfl","mToastThreadHandler handleMessage");
        		switch(msg.what){
        		case 1:
            		Log.i("testzfl","mToastThreadHandler handleMessage 111");
            		//testToast();
            		//while(true) {
            		addNotification();
            		//}
            		break;
        		case 2:
            		Log.i("testzfl","mToastThreadHandler handleMessage 222");
            		mToastThread.quit();
            		break;
        		
        		}

        	}
        };
		int j =0;
		while(j<2) {
			//addNotification();
			j++;
		}
		//addNotification();
	}
	
	public void testToast() {
		Log.i("testzfl","testToast");
		 //finish();
		 
        Toast.makeText(MainActivity.this, "fffffffffffffff", Toast.LENGTH_LONG).show();
        //SystemClock.sleep(2000);
        
        Log.i("testzfl","testToast");
        
	}
    private  NotificationManager mNotificationManager;
    private  Notification.Builder mNotificationBuilder;
    int id= 100;
    int tid = 1;
	@SuppressWarnings("deprecation")
	public void addNotification() {
		tid ++;
		Log.i("testzfl","addNotification tid = "+tid);
		//addNotification();
		

		Intent fullScreenIntent = new Intent(this, MydbActivity.class);
		fullScreenIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pi = PendingIntent.getActivity(
                this, 22, fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		//while(true) {
        //if (id == 100) {
        Notification.Builder  notificationBuilder = new Notification.Builder(this)
        .setPriority(0)
        //.setTicker("dddddd")
        .setContentTitle("ttttt")
        .setContentText("ffffff")
        .setSmallIcon(R.drawable.ic_launcher)
        //.setOngoing(true)
        .setFullScreenIntent(pi, true)
        .setContentIntent(pi)
        //.setLights(0xffff0000,500,500);
         .setDefaults(Notification.DEFAULT_LIGHTS)
        //.setCategory(Notification.CATEGORY_SYSTEM)
        //.setWhen(System.currentTimeMillis());
         .setLights(0xff0000ff, 50, 500);
        Notification n1 = notificationBuilder.build();
        
		Log.i("testzfl","addNotification");
        mNotificationBuilder = new Notification.Builder(this)
        .setPriority(1)
        //.setTicker("dddddd")
        .setContentTitle("ttttt")
        .setContentText("ffffff")
        .setSmallIcon(R.drawable.ic_launcher)
        //.setOngoing(true)
        .setFullScreenIntent(pi, true)
        .setContentIntent(pi)
        //.setLights(0xffff0000,500,500);
         .setDefaults(Notification.DEFAULT_LIGHTS)
        //.setCategory(Notification.CATEGORY_SYSTEM)
        //.setWhen(System.currentTimeMillis());
         .setLights(0xff0000ff, 50, 500);
         //.setDefaults(Notification.DEFAULT_LIGHTS);
        Notification n = mNotificationBuilder.build();
        //n.flags = Notification.FLAG_ONGOING_EVENT|Notification.FLAG_SHOW_LIGHTS;
        mNotificationManager.notify(10000, n);
        id ++;
  
		//} else if (id == 101) {
			//Log.i("testzfl","addNotification");
	        //mNotificationBuilder = new Notification.Builder(this)
	        //.setPriority(12)
	        //.setTicker("dddddd")
	       // .setContentTitle("ttttt")
	        //.setContentText("ffffff")
	       // .setSmallIcon(R.drawable.ic_launcher)
	      //  .setFullScreenIntent(pi, true)
	       // .setContentIntent(pi)
	        //.setOngoing(true)
	        //.setLights(0xffff0000,1,1);
	         //.setDefaults(Notification.DEFAULT_LIGHTS)
	        //.setCategory(Notification.CATEGORY_SYSTEM)
	        //.setWhen(System.currentTimeMillis());
	        // .setLights(0xff0000ff, 50, 500);
	         //.setDefaults(Notification.DEFAULT_LIGHTS);
	        //Notification n = mNotificationBuilder.build();
	        //n.flags = Notification.FLAG_ONGOING_EVENT|Notification.FLAG_SHOW_LIGHTS;
	        //mNotificationManager.notify(tid, n);	
	        //id++;
		//}
		
	}
	public void moveNoification() {
		Log.i("testzfl","moveNoification");
		mNotificationManager.cancel(100);
	}
    public void onClick1() {
    	String test;
    	//test.contains("dd");
    	if (stub != null ) {
    		Log.i("testzfl","onClick1:BindserviceStatus");
    		try {
				stub.test();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		return;
    	}

    	Log.i("testzfl","onCreate input button1 onClick");
    	  //SystemClock.sleep(20000);
    	  /*
    	   //start activity case
    	   Intent intent = new Intent();
        ComponentName mPlatLogoActivity = new ComponentName("com.example.testfl2",
                "com.example.testfl2.Test2Activity");
        intent.setComponent(mPlatLogoActivity);
    	  startActivity(intent );
    	
    	  //start service case
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.testfl2",
                    "com.example.testfl2.SystemUIService"));
        startService(intent);*/
          
    	  //create AsyncTask case
    	for(int i =0; i<10;i++) {
    		Log.i("testzfl","AsyncTask doInBackground i = "+i);
        new AsyncTask<Void,Void,Void>()
          {
            protected Void doInBackground(Void... args)
               {
        		     Log.i("testzfl", "AsyncTask::doInBackground callstack = " ,
        		        new Throwable("doInBackground"));
            	     Log.i("testzfl","AsyncTask doInBackground");
            	     publishProgress();
            	     //TestFinalize t = TestFinalizeFun(1);
            	     //t = null;
            	     TestFinalizeFun("test");
            	     TestFinalizeFun("test");
            	     TestFinalizeFun("test");
            	     SystemClock.sleep(5000);
            	     Log.i("testzfl","AsyncTask begin gc");
            	     System.gc();//假如不掉用该函数以上的对象在什么时候被释放
            	     SystemClock.sleep(50000);
            	     Log.i("testzfl","AsyncTask doInBackground ***end");
                  return null;
               }
            protected void onProgressUpdate(Void... args) {
      		     Log.i("testzfl", "AsyncTask::onProgressUpdate callstack = " ,
          		        new Throwable("onProgressUpdate"));                    	
               }                    
            private void finish(Void result) {
   		     Log.i("testzfl", "AsyncTask::finish callstack = " ,
     		        new Throwable("finish"));
               }                    
        }.execute();
    	}
        Toast.makeText(MainActivity.this,"button1 onClick end",Toast.LENGTH_LONG).show();
        	
    }
    public void onClick2() {
    	Log.i("testzfl","onCreate input button2 onClick");
    	//SystemClock.sleep(20000);
      //String action = "com.android.test.broadcast";
      //Intent intent1 = new Intent();
      //intent1.setAction(action);
      //sendBroadcast(intent1);
    	
      //float[] dims = {mDisplayMetrics.widthPixels, mDisplayMetrics.heightPixels};
      //mScreenBitmap = SurfaceControl.screenshot((int) dims[0], (int) dims[1]);
    	
    	
	  //start service case
      Intent intent = new Intent();
      intent.setComponent(new ComponentName("com.example.testfl2",
                  "com.example.testfl2.SystemUIService"));
      if (!StartserviceStatus) {
          startService(intent);
          StartserviceStatus = true;
       } else {
           stopService(intent);
           StartserviceStatus = false;
        }
      
      Toast.makeText(MainActivity.this,"button2 onClick end",Toast.LENGTH_LONG).show();
        	
    }    
    public ITestService stub = null;
    private final  class SimpleConnection implements ServiceConnection {

        public void onServiceConnected(ComponentName name, IBinder service) {
            stub = ITestService.Stub.asInterface(service);
            Log.i("testzfl", "Service connected: " + name);
        }
        public void onServiceDisconnected(ComponentName name) {
            stub = null;
            Log.i("testzfl", "Service disconnected: " + name);
        }
    }
    public void onClick3() {
      Log.i("testzfl","onCreate input button3 onClick");
      //Intent intent = new Intent();
      //intent.setComponent(new ComponentName("com.htc.captiveportallogin",
              //"com.htc.captiveportallogin.CaptivePortalPoolingService"));
      //intent.putExtra("wisprservice_mode", 0);
      //startService(intent);
     /* intent.setComponent(new ComponentName("com.example.testfl2",
                  "com.example.testfl2.SystemUIService"));
      if (!BindserviceStatus) {
          bindService(intent,mLocalServiceConn, Context.BIND_AUTO_CREATE);
          BindserviceStatus = true;
       } else {
    	    unbindService(mLocalServiceConn);
           BindserviceStatus = false;
         }   */   

      DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse("http://azureblob.htc.com/language-pack/cy-zhtw/zhtw_1_03.zip"));
      localRequest.setDestinationInExternalPublicDir("download" +"/"+ "Test", "test");
      Toast.makeText(MainActivity.this,"button3 onClick end",Toast.LENGTH_LONG).show();
        	
    }   
    
    private InetAddress lookupHost(String hostname) {
        InetAddress inetAddress[];
        try {
            inetAddress = InetAddress.getAllByName(hostname);
        } catch (UnknownHostException e) {
            return null;
        }

        for (InetAddress a : inetAddress) {
            if (a instanceof Inet4Address) return a;
        }

        return null;
    }
    public void onhanleNet(){
    	//InetAddress server = lookupHost("www.baidu.com");
    	String mUrl = "http://www.baidu.com";//"http://clients3.google.com/generate_204";//(server != null)? "http://" + server.getHostAddress();
    	HttpURLConnection urlConnection = null;
    	int httpResponseCode = 404;
        try {
        	URL url = new URL(mUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("User-Agent", "Android-Wifi/0.1");
            urlConnection.setConnectTimeout(30000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setUseCaches(false);
            urlConnection.setDoInput(true);
            urlConnection.setInstanceFollowRedirects(false);
            urlConnection.connect();
           //if (urlConnection != null) urlConnection.disconnect();
        	httpResponseCode = urlConnection.getResponseCode();
        	Log.d("testzfl", "DataConnection: httpResponseCode1: " + httpResponseCode);
        	int i = 0;
        	// Get Content headers
            Map<String, List<String>> header_map = urlConnection.getHeaderFields();
        	for (Map.Entry<String, List<String>> entry : header_map.entrySet()) {
                Log.d("testzfl", "header_" + i + " name:" + entry.getKey());
                Log.d("testzfl", "header_" + i + " value:" + entry.getValue());
                i ++;
            }
        }catch (java.net.UnknownHostException e) {
        	Log.d("testzfl", "DataConnection: UnknownHostException: " + e);
        	e.printStackTrace();
        }catch (java.net.UnknownServiceException e) {
        	Log.d("testzfl", "DataConnection: UnknownServiceException: " + e.getStackTrace());
        	e.printStackTrace();

        }catch (IOException localIOException1) {
        	Log.d("testzfl", "DataConnection: Exception: localIOException1");
        	//e.printStackTrace();
        }finally {
        	SystemClock.sleep(30000);
        	if (urlConnection != null) urlConnection.disconnect();
        }
    	
    }
    private class DataConnection extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
        	//if (NtRequestCount == 1) SystemClock.sleep(10000);
        	onhanleNet();
        	return null;
        }
    }
    private class SecDataConnection extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
        	onhanleNet();
        	return null;
        }
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    public final DataSetObserver mDataSetObserver = new DataSetObserver() {
        @Override
        public void onChanged() {

        }
    };
	

}
