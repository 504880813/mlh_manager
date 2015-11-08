

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
		   }
	  },
	   messages: {
		   name:{
			   required:"请选择要进货的原料",
		   },
		   surplus:{
			   required:"必须录入进货数量",
			   number:"进货数量必须为数字"
		   }
	  },
	});
});

/**
 * 显示原料列表
 */
function showmaterials(){
	$("#materialsList").show();
}
/**
 * 选中原料后触发事件
 * @param id
 * @param name
 */
function Selectthis(id,name){
	$("input[name=name]").val(name);
	$("#materialsList").hide();
}