
/**
 * 计算折扣金额
 * @param self
 */
function CalculatingDiscount(self){
	var discount=self.value;
	var allprice=$("input[name=price]").val();
	var discountMoney=parseFloat(allprice)-((parseFloat(discount)*0.1)*parseFloat(allprice));
	
	$("#discountamountValue").text(discountMoney);
	$("input[name=discountamount]").val(discountMoney);
	
	changeAllprice();
}
/**
 * 改变总价
 */
function changeAllprice(){
	var allprice=parseFloat($("input[name=price]").val());
	
	var discountamount=parseFloat($("input[name=discountamount]").val());
	
	var couponamount=parseFloat($("input[name=couponamount]").val());
	
	
	var temp;
	if(!isNaN(allprice)){
		temp=allprice;
	}
	if(!isNaN(discountamount)){
		temp=temp-discountamount;
	}
	if(!isNaN(couponamount))
	{
		temp=temp-couponamount;
	}
	
	$("#showpayprice").text(temp);
	
	
}




/**
 * 付款或者签单
 */
function pay(ispayment){
	var html="<input type='hidden'";
	html+="name=isbalance";
	html+="  value=";
	html+="true >";
	
	html+="<input type='hidden'";
	html+="name=ispayment";
	html+="  value=";
	html+=ispayment;
	html+=">";
	
	$("input[name=price]").val($("#showpayprice").text());
	
	$("input[name=expense]").val($("#showpayprice").text());
	
	$("form").append(html);
	//计算应付现金
	expenseChange();
	
	submitPage();
	
//	$("form")[0].submit();
}
/**
 * 返回
 */
function back(){
	history.back(-1);
}

/**
* 消费金额改变时，计算要付的现金
*/
function expenseChange(){
	//获取当前折后金额
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

function CalculatingDiscount(){
	//获取当前消费金额
	var NowexpenseValue=$("input[name=Nowexpense]").val();
	//获取折扣
	var discountText=$("#nowDiscount").text().trim();
	
	//计算折后金额
	
	var discount=discountText*0.1;
	
	var money=NowexpenseValue*discount;
	
	//赋值折后金额
	$("input[name=expense]").val(money);
	
	//计算是否需要现金
	expenseChange();
}

/**
* 提交页面
* 
*/
function submitPage(){
	
	var message="\n";
	
	message+="需要缴纳现金";
	message+=$("#otherMoney").text();
	message+="\n\n";
	message+="请确认是否缴费完成";
	message+="\n\n";
	
	
	 jDialog.confirm(message,{
         handler : function(button,dialog) {
      	     $("form")[0].submit();
             dialog.close();
         }
     },{
         handler : function(button,dialog) {
             dialog.close();
         }
     });
}