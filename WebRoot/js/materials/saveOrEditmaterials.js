
//初始化
$(function(){
	$("#materialsdataForm").validate({
	   rules: {
		   name:{
			   required:true
		   },
		   surplus:{
			   required:true,
			   number:true
		   },
	  },
	   messages: {
		   name:{
			   required:"请录入原料名",
		   },
		   surplus:{
			   required:"请录入库存",
			   number:"库存只能是数字"
		   },
	  }
	 });
});
