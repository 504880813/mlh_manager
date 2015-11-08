/*
 * 原料存取记录列表相关js
 */

/*//提交查询
function submitQuery(){
	
	//先给name赋值
	var name=$($(".materialsName")[0]).text().trim();
	$("input[name=name]").val(name);
	alert(name);
	$("#queryform").submit();
	
}
*/

//初始化
$(function(){
	
	$("#selectRecordForm").validate({
		onkeyup  : false,
        onclick  : false,
        onfocusout : false,
	   rules: {
		   name:{
			   required:true
		   },
		   startTime:{
			   required:true,
		   },
		   endTime:{
			   required:true,
		   }
	  },
	   messages: {
		   name:{
			   required:"请选择要查询的原料",
		   },
		   startTime:{
			   required:"请选择起始时间",
		   },
		   endTime:{
			   required:"请选择结束时间",
		   },
	  },
	  submitHandler: function(form) {  //通过之后回调
		  selectRecordSubmit();
		  return false;
	  },
	  invalidHandler: function(form, validator) {  //不通过回调
	      return false;
	  } 
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

//响应表单提交按钮
function selectRecordSubmit(){
	ajaxSubmit($("#selectRecordForm"));
}
/**
* 处理响应数据
* @param json
*/
function processMessage(json){
	
	//清除原来的数据
	$("#recordMessage").empty();
	html="";
	
	html+="<tr align='center'><td><strong>原料名</strong></td><td><strong>存取量</strong></td><td><strong>存/取</strong></td><td><strong>存取时间</strong></td></tr>";
	
	if(json==null){
		html+="暂无数据";
	}
	$.each(json,function(key,val){
		html+="<tr align='center'>";
		
		html+="<td>";
		html+=$("input[name=name]").val();
		html+="</td>";
		
		html+="<td>";
		html+=val.materialsSurplus;
		html+=val.materialsUnit;
		html+="</td>";
		html+="<td>";
		if(val.save=="true"){
			html+="存";	
		}else{
			html+="取";
		}
		html+="</td>";
		html+="<td>";
		var d=new Date();
		d.setTime(val.time);
		html+=d.format("yyyy-MM-dd HH:mm:ss");
		html+="</td>";
		html+="</tr>";
	});
	
	$("#recordMessage").html(html);
}

//将form转为AJAX提交
function ajaxSubmit(frm, fn) {
	
  $.ajax({
      url: frm[0].action,
      type: frm[0].method,
      data: frm.serialize(),
      success: function(json) {
      	processMessage(json);
	}
  });
  
}


