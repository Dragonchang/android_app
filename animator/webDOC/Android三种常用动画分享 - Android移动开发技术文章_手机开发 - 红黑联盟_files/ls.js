if(!window.BAIDU_SS_HHRUN){(function(self,$){var $window=$(window);var SS={cache:{},total:0,init:function(notry){var script=$("script"),mods=[];script.each(function(){var that=$(this),type=(that.attr("type")+"").toUpperCase();if(type=="BAIDU_HH"&&!that.attr("runed")){mods.push(SS.getConfig(that));that.attr("runed","true")}});if(mods.length){this.run(mods)}if(!notry){this.tryagain()}},tryagain:function(){setTimeout(function(){SS.init(true)},1000)},getConfig:function(script){var text=script.html();text=text.replace(/:\/\//ig,"|&|").replace(/\/\/[^\n]*/g,"").replace(/[\s\n]/g,"").replace(/\/\*[^\/]*\*\//g,"").replace(/,}/g,"}").replace(/[<>]/g,"").replace(/(eval|window|document|script|this|function|\(|\)|\[|\])/ig,"").replace(/\|&\|/g,"://");try{var data=eval("("+text+")");data.title=data.title||document.title;data.ltu=data.ltu||window.location+"";data.ref=data.ref||document.referrer;data.pageWidth=$window.width();data.pageHeight=$window.height()}catch(e){}return{target:script,data:data||{}}},run:function(mods,data){for(var i=0,l=mods.length;i<l;i++){(function(item){var data=item.data;if(data.type){SS.load(data.type,item)}})(mods[i])}},loadJS:function(url,callback){var head=document.getElementsByTagName("head")[0]||document.body,script=document.createElement("script");script.onload=script.onreadystatechange=script.onerror=function(){if(!(script&&script.readyState&&/^(?!(?:loaded|complete)$)/.test(script.readyState))){script.onload=script.onreadystatechange=script.onerror=null;script.src="";script.parentNode.removeChild(script);callback&&callback(script=null)}};script.charset=document.charset||document.characterSet||"gb2312";script.src=url;try{head.appendChild(script)}catch(e){}},load:function(type,item){if(this.total++<40){if(this.cache[type]){if(typeof this.cache[type]=="function"){this.cache[type](type,item)}}else{this.loadJS((window.DSPUISTATICURI||"http://su.bdimg.com/static/dspui/js/")+"ls_"+type+".js?dv="+~(-new Date()/64600000),function(){try{SS.cache[type]=BAIDU_SS_HHRUN[type];SS.load(type,item)}catch(e){setTimeout(function(){SS.cache[type]=BAIDU_SS_HHRUN[type];SS.load(type,item)},10)}})}}}};SS.init();window.BAIDU_SS_HHRUN=function(){SS.init()}})(window,jQueryDSPUI)}else{};