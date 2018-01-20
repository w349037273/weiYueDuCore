// $(function() {
// 	$("#sina-login").click(function(){
// 		openWindow("/account/openConnect/sina/", "open-链接  悦旅新");
// 	});
// 	$("#qq-login").click(function(){
// 		openWindow("/account/openConnect/qq/", "open-链接  悦旅新");
// 	});
// 	$("#douban-login").click(function(){
// 		openWindow("/account/openConnect/douban/", "open-链接  悦旅新");
// 	});
// 	$("#renren-login").click(function(){
// 		openWindow("/account/openConnect/renren/", "open-链接  悦旅新");
// 	});
//
// 	$("#sina-login2").click(function(){
// 		openWindow("/account/openConnect/sina/", "open-链接  悦旅新");
// 	});
// 	$("#qq-login2").click(function(){
// 		openWindow("/account/openConnect/qq/", "open-链接  悦旅新");
// 	});
// });

function openWindow(url, title) {
	var width = window.screen.availWidth/2;
	var height = window.screen.availHeight/2;
	var top = window.screen.availHeight/2 - height/2;  
	var left = window.screen.availWidth/2 - width/2; 
	window.open(url, title, "width="+width+",height="+height+",top="+top+",left="+left);
}