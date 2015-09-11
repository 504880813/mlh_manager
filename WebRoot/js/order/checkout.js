


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
//	alert("--->"+temp);
	$("#showpayprice").text(temp);
	
//	$("input[name=price]").val(temp);
	
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
	
	$("form").append(html);
	
	$("form")[0].submit();
}
/**
 * 返回
 */
function back(){
//	alert(parseFloat(8.2));
	history.back(-1);
}