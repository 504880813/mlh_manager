
//初始化
$(function(){
	$("#categorydataForm").validate({
	   rules: {
		   name:{
			   required:true,
		   }
	  },
	   messages: {
		   name:{
			   required:"请录入分类名",
		   }
	   }
	 });
});
