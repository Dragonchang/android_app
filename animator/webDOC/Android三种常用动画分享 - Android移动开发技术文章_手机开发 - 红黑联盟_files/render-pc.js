!function(){if("function"==typeof window.changyanDSP){var t=function(t){var e=(a.parseJSON(t.advertContent),'            <a class="cy-flash-ad-press"                style="background: url(about:blank);display:block;width: '+t.advertWidth+"px; line-height: "+t.advertHeight+"px; height: "+t.advertHeight+'px; position: absolute; top: 0; left: 0; z-index: 2;"></a>            <div                 style="background: url(about:blank);display:block;width: '+t.advertWidth+"px; height: "+t.advertHeight+'px; position: absolute; top: 0; left: 0; z-index: 1;"></div>        ');return e},e=function(t){var e,i=a.parseJSON(t.advertContent),n=!!window.ActiveXObject;return e=n?'                <embed                    height="'+t.advertHeight+'"                    width="'+t.advertWidth+'"                    type="application/x-shockwave-flash"                    wmode="transparent"                    src="'+i.mediaUrl+'"                >':'                <embed autostart="true" loop="true" id="'+i.rtbAdId+'" src="'+i.mediaUrl+'" allowNetworking="all" wmode="transparent"                    quality="high" type="application/x-shockwave-flash" width="'+t.advertWidth+'" height="'+t.advertHeight+'" menu="true"                    allowFullScreen="false"  pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"></embed>'},i=window.changyanDSP,a=window.changyanjQuery||window.jQuery;i.on("advertLoad",function(i){var n=function(n){var r=a("#SOHUCS").width();n.advertWidth>r&&(n.advertWidth=r);var s='                <div style="background-color: rgb(228, 228, 228); margin: 0 auto;                    width: '+n.advertWidth+"px; height: "+n.advertHeight+'px; cursor: pointer;position: relative; overflow: hidden;">                    [[content]]                </div>            ';if("IFRAME"===n.advertType&&(s=s.replace("[[content]]",'                    <iframe src="'+n.advertContent+'" style="width: '+n.advertWidth+"px; height: "+n.advertHeight+'px;"                        marginwidth="0" marginheight="0" frameborder="0" scrolling="no" allowtransparency="true"></iframe>')),"JS"===n.advertType&&(s=s.replace("[[content]]",n.advertContent)),"IMAGE"===n.advertType&&!function(){var t=a.parseJSON(n.advertContent);s=s.replace("[[content]]",'<a href="javascript:void(0);" target="_blank" style="width: 100%; height: 100%; display: block;"><img src="'+t.mediaUrl+'" style="width: 100%; height: 100%;"></a>')}(),"FLASH"===n.advertType){var o=t(n),d=e(n);s=s.replace("[[content]]",o+d)}var A;if(a("#SOHUCS").prepend(A=a(s)),"IMAGE"===n.advertType&&A.find("a").click(function(t){t.preventDefault(),i.sendClickLog()}),"FLASH"===n.advertType){{a.parseJSON(n.advertContent)}A.find(".cy-flash-ad-press").click(function(t){t.preventDefault(),i.sendClickLog()})}!function(){"cyqQwkOU4"===i.params.appId&&a("head").append('<script src="http://s11.cnzz.com/z_stat.php?id=1255562914&web_id=1255562914" language="JavaScript"></script>'),"cyqQexYeg"===i.params.appId&&a("head").append('<script src="http://s11.cnzz.com/z_stat.php?id=1256065508&web_id=1256065508" language="JavaScript"></script>')}(),n.statVisibility(A)},r=function(n){var r="data:img/jpg;base64,iVBORw0KGgoAAAANSUhEUgAAACwAAAAPCAYAAACfvC2ZAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAAIGNIUk0AAHolAACAgwAA+f8AAIDpAAB1MAAA6mAAADqYAAAXb5JfxUYAAADqSURBVHja7JZLCsMwDERHpZ99z9NcIQdp7t3uvChk0ZQy3ThghPxL7UWhAhMsj8yzLCILSfyS7TrsyUL/pkztDd8LwBPAkog7AjgBOBhr4mFEwUlGFzuA5DK8AHgAGAGcjTH69dSBJDO3/GIM455IPRzJC8mb/4Zrq3/wOh1bYqHWik/No8AwoENYRIBzAOgJHEJeFWxL4NRNVAPDw75JThldjXXP8ETyrmq6dUmwVQ0PwTyEdoWwLADmtxlO/SVWaFeZvZIDbQKeI7Aaeq4sA7YoCTHeEls7HTNNQmuY0DLWdOT/+OlsnwEAHn+cEcizBxkAAAAASUVORK5CYII=",s='                <div style="position: fixed; bottom: 0; overflow: visible; left: 0; background-color: rgb(228, 228, 228);z-index:2147483647;                    width: '+n.advertWidth+"px; height: "+n.advertHeight+'px; cursor: pointer;">                    <span style="position: absolute; top: -15px; right: 0; height: 15px; width: 44px; cursor: pointer;                        background: #CCC url('+r+') no-repeat"></span>                    [[content]]                </div>            ';if("IFRAME"===n.advertType&&(s=s.replace("[[content]]",'                    <iframe src="'+n.advertContent+'" style="width: '+n.advertWidth+"px; height: "+n.advertHeight+'px;"                        marginwidth="0" marginheight="0" frameborder="0" scrolling="no" allowtransparency="true"></iframe>')),"JS"===n.advertType&&(s=s.replace("[[content]]",n.advertContent)),"IMAGE"===n.advertType&&!function(){var t=a.parseJSON(n.advertContent);s=s.replace("[[content]]",'<a href="javascript:void(0);" target="_blank" style="width: 100%; height: 100%; display: block;"><img src="'+t.mediaUrl+'" style="width: 100%; height: 100%;"></a>')}(),"FLASH"===n.advertType){var o=t(n),d=e(n);s=s.replace("[[content]]",o+d)}var A;if(a("body").append(A=a(s)),n.params.isLeft===!1&&(A.css("left","auto"),A.css("right",0)),A.children().eq(0).click(function(){A.hide()}),"IMAGE"===n.advertType&&A.find("a").click(function(t){t.preventDefault(),i.sendClickLog()}),"FLASH"===n.advertType){{a.parseJSON(n.advertContent)}A.find(".cy-flash-ad-press").click(function(t){t.preventDefault(),i.sendClickLog()})}n.statVisibility(A)},s=function(t){!function(){var e=a("#SOHUCS #SOHU_MAIN .list-newest-w").width()-62,i=t.advertHeight/t.advertWidth;e>t.advertWidth&&(e=t.advertWidth);var n=e*i;t.advertWidth=e,t.advertHeight=n}();var e,n="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADcAAAAUCAMAAAAePVXsAAAAZlBMVEUAAADmAADmAADmAADmAADmAADmAADmAADmAADmAADmAADmAAAAAAAAAAAAAAAAAAAAAADmAADmAADmAADmAADmAADmAADmAADmAADmAADmAADmAADmAADmAAAAAABzAACAAADmAACOlsNNAAAAHnRSTlMAAAMEExQnKCowM1NzdXd5fImMj5KT3d7f4OPk/P1QqS2HAAAA6ElEQVQ4y52U6xqCIAyGt9Sy7KRZZhm1+7/JRNmY6I8IFQR8t29jj4CYVU1HsQ1w+6g3K4xsBGlbYHwjKK/4F3fPh1E6HkgvLXCUuH2yF7mBvA0aZ5IR5tw+ob6HOSOsQPcg+9ofc2IP3VfyPvc340SyCyHgyKua6OR10tkTjnQiQ3+il9DnBQBs3ZAPcpGbnQPY1tebiPDZEFMYHgTBmzkVgEustiDnw/GZM3OifaJUHs0lHRhzsgGCKwr2JDbGWZDb/NZz5mg9RpV1XVrOHCK5ok0HzuwjuNX68tzhyJnP73+IV1NliF/LSzTYZiHHdwAAAABJRU5ErkJggg==",r='            <div style="cursor: pointer;" node-type="feed-list-ad" class="clear-g block-cont-gw block-cont-bg" datatype="time" cmtnum="0">                <div class="cont-head-gw">                    <div class="head-img-gw">                        <a href="javascript:void(0)" commhref="javascript:void(0)">                            <img src="{{flowIcon}}" onerror="SOHUCS.isImgErr(this)" width="42" height="42" alt="">                        </a>                    </div>                </div>                <div class="cont-msg-gw">                    <div class="msg-wrap-gw">                        <div class="wrap-user-gw global-clear-spacing">                            <span class="user-spread-gw user-spread-bg"><i style="background: url('+n+')!important;width: 55px;height: 20px;">畅盈推广</i></span>                            <span class="user-name-gw">                                <a href="javascript:void(0)" commhref="javascript:void(0)">{{flowNick}}</a>                            </span>                        </div>                        <div class="wrap-issue-gw">                            <p class="issue-wrap-gw adTxt"><span class="wrap-word-bg">{{flowContent}}</span></p>                            <img style="max-width: 100%;max-height: none;" class="adImage" src="{{mediaUrl}}">                        </div>                        <div class="clear-g wrap-action-gw">                            <div class="action-click-gw">                                <span class="click-reply-gw click-reply-eg"><a href="javascript:void(0)" class="">查看详情></a></span>                            </div>                        </div>                    </div>                </div>            </div>            ';if("IMAGE"===t.advertType){var s,o=a.parseJSON(t.advertContent);for(s in o)r=r.replace("{{"+s+"}}",o[s]);var d=a("#SOHUCS #SOHU_MAIN .list-newest-w"),e=a(r);if(o.mediaUrl||e.find(".adImage").remove(),d.length){var A=d.find(".block-cont-gw");A.length&&A.length>=5&&(A.eq(1).after(e),e.on("click",function(){i.sendClickLog()}))}}t.statVisibility(e)},o=function(t){var e=a("#SOHUCS #SOHU_MAIN");e.find(".title-link-w").length&&e.find(".title-link-w").hide();var i=a.parseJSON(t.advertContent),n=function(){e.find(".section-title-w, .wrap-action-w").css("position","relative").children().css({position:"relative","z-index":2}),e.find(".section-cbox-w").css({position:"relative","z-index":1})};if(n(),i.skinHeaderImg){var r=a('<img src="'+i.skinHeaderImg+'"/>');r.css({position:"absolute",top:0,right:0}),i.landingUrl&&(r.css("cursor","pointer"),r.on("click",function(){window.open(i.landingUrl)})),a("#SOHUCS #SOHU_MAIN .title-join-w").after(r),t.statVisibility(r)}if(i.skinBottomImg&&!a(".issue-grade-w").length){var s=a('<img src="'+i.skinBottomImg+'"/>');s.css({position:"absolute",top:0,right:88,height:39}),i.landingUrl&&(s.css("cursor","pointer"),s.on("click",function(){window.open(i.landingUrl)})),a("#SOHUCS #SOHU_MAIN .wrap-action-w").append(s)}if(i.skinButtonImg&&i.skinHoverButtonImg){!function(){var t=new Image;t.src=i.skinHoverButtonImg}();var o=a("#SOHUCS #SOHU_MAIN .btn-fw");o.hasClass("btn-bf")&&o.removeClass("btn-bf"),o.css({background:'url("'+i.skinButtonImg+'")'}),o.hover(function(){a(this).css("background",'url("'+i.skinHoverButtonImg+'")')},function(){a(this).css("background",'url("'+i.skinButtonImg+'")')})}};1530===i.params.position&&n(i),1607===i.params.position&&r(i),1103===i.params.position&&s(i),1105===i.params.position&&o(i)})}}();