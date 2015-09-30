
//$(function(){
//	$("input[name=expense]").blur(function(){
//		expenseChange();
//	});
//});

/**
 * 消费金额改变时，计算要付的现金
 */
function expenseChange(){
	//获取当前消费金额
	var expenseValue=$("input[name=expense]").val();
	//获取会员卡余额
	var cardMoneyValue=$("#cardMoney").text();
	
	//判断当前是否要付现金
	if(cardMoneyValue>=expenseValue){
		$("#otherMoney").text("0元");
	}else{
		//计算要付的现金
		var currentMoeny=expenseValue-cardMoneyValue;
		currentMoeny+="元";
		$("#otherMoney").text(currentMoeny);
	}
}
/**
 * 提交页面
 * @param submitButton
 */
function submitPage(submitButton){
	
	var message="\n";
	
	message+="需要缴纳现金";
	message+=$("#otherMoney").text();
	message+="\n\n";
	message+="请确认是否缴费完成";
	message+="\n\n";
	
	
	 jDialog.confirm(message,{
           handler : function(button,dialog) {
        	   $("#paypageForm").submit();
               dialog.close();
           }
       },{
           handler : function(button,dialog) {
               dialog.close();
           }
       });
}