
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
	
	html+="<tr align='center'><td><strong>卡号</strong></td><td><strong>消费金额</strong></td><td><strong>消费时间</strong></td><td><strong> </strong></td></tr>";
	
	if(json==null||json.length<=0){
		html+="暂无数据";
	}
	
	
	$.each(json,function(key,val){
		html+="<tr align='center'>";
		html+="<td>";
		html+=val.cardId;
		html+="</td>";
		html+="<td>";
		html+=val.expense;
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


