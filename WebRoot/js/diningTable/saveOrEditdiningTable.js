
//初始化
$(function(){
	$("#diningTabledataForm").validate({
	   rules: {
		   seatnumber:{
			   required:true,
		   },
		   freeimageFile:{
			   required:true,
		   },
		   busyimageFile:{
			   required:true,
		   },
	  },
	   messages: {
		   seatnumber:{
			   required:"请录入餐桌名",
		   },
		   freeimageFile:{
			   required:"请选择餐桌空闲时展示图片",
		   },
		   busyimageFile:{
			   required:"请选择餐桌忙碌时展示图片",
		   },
	   }
	 });
});
