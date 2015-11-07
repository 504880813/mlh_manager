
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