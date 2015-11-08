
//页面初始化
$(function(){ 
	 $("#submit_validation").click(function(){
		 $("form")[0].method="post";
		 $("form")[0].action=basepath+"/wechat_js.do?method=ValidationMember";
		 $("form")[0].submit();
	 });
	 $("#close").click(function(){
	        wx.closeWindow();
	  });
	 
	 
	 
});  
