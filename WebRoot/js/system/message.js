$(function() {
	var message = $("#message").text();
	var rootPath=$("#rootPath").text();
	// 通过options参数，控制dialog
	var dialog = jDialog.dialog({
		title : '系统消息',
		content : message,
		buttons : [
			{
				type : 'highlight',
				text : '返回',
				handler:function(button,dialog)
				{
					dialog.close();
					window.history.back(-1);
				}
			},
			{
				type : 'highlight',
				text : '去首页',
				handler:function(button,dialog)
				{
					window.location.href=rootPath+"/index.jsp";
				}
			}
		]
	});
});
