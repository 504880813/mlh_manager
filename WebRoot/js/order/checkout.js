//初始化
$(function(){
	$("#chenckForm").validate({
	   rules: {
		   discountamountPercent:{
			   number:true
		   },
		   couponamount:{
			   number:true
		   },
	  },
	   messages: {
		   discountamountPercent:{
			   number:"折扣只能是数字",
		   },
		   couponamount:{
			   number:"优惠金额只能是数字"
		   },
	  }
	 });
});


/**
 * 计算折扣金额
 * @param self
 */
function CalculatingDiscount(self){
	
	var discount=self.value;
	var allprice=$("input[name=price]").val();
	var discountMoney=parseFloat(allprice)-((parseFloat(discount)*0.1)*parseFloat(allprice));
	
	if(isNaN(discountMoney)){
		discountMoney=0;
	}
	
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
	
	
	if(couponamount<0){
		alert("优惠券金额必须大于0");
		return;
	}
	
	
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
	/*var html="<input type='hidden'";
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
	
	$("form")[0].submit();*/
	
	//打印小票
//	printdiv("table_print");
	print();
	
}
/**
 * 打印小票
 * @param printpage
 * @returns {Boolean}
 */
function printdiv(printpage)  
{  
	var headstr = "<html><head><title></title></head><body>";  
	var footstr = "</body>";  
	var newstr = document.all.item(printpage).innerHTML;  
	var oldstr = document.body.innerHTML;  
	document.body.innerHTML = headstr+newstr+footstr;  
	w=window.open("","_blank","k");  
	w.document.write(headstr+newstr+footstr);  
	w.print();  
	document.body.innerHTML = oldstr; 
//	HKEY_Root="HKEY_CURRENT_USER";
//	HKEY_Path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	return false;  
} 
/*function print()  
{  
    var headstr = "<html><head><title></title></head><body>";  
    var footstr = "</body>";  
    var newstr = document.getElementById('table_print').innerHTML;  
    var oldstr = document.body.innerHTML;  
    document.body.innerHTML=headstr+newstr+footstr;  
    w=window.open("","_blank","k");  
    w.document.write(headstr+newstr+footstr);  
    if (navigator.appName == 'Microsoft Internet Explorer') window.print();  
    else w.print();  
    w.close();  
    document.body.innerHTML = oldstr;     
    return false;     
} */
function print()  
{  
	CreateOneFormPage();	
	LODOP.PREVIEW();	
} 
function CreateOneFormPage(){
	LODOP=getLodop(document.getElementById('LODOP'),document.getElementById('LODOP_EM'));  
	LODOP.PRINT_INIT("init");
//	LODOP.SET_PRINT_PAGESIZE(3,);
	LODOP.SET_PRINT_STYLE("FontSize",10);
//	LODOP.SET_PRINT_STYLE("Bold",1);
	LODOP.ADD_PRINT_TEXT(0,40,110,40,"消费小票");
	//50,231,260,39  88,200,350,600
	//桌号 
	LODOP.ADD_PRINT_TEXT(50,30,50,40,"桌号 ");
	LODOP.ADD_PRINT_TEXT(50,80,50,40,$("#diningTableName").text().trim());
	//服务员
	LODOP.ADD_PRINT_TEXT(100,30,50,40,"服务员");
	LODOP.ADD_PRINT_TEXT(100,80,50,40,$("input[name=waiter]").val());
	//时间
	LODOP.ADD_PRINT_TEXT(150,30,50,40,"时间");
	LODOP.ADD_PRINT_TEXT(150,80,100,40,$("input[name=createtime]").val());
	
	//
	
//	LODOP.ADD_PRINT_HTM(40,0,100,48,document.getElementById("chenckForm").innerHTML);
};
/**
 * 返回
 */
function back(){
//	alert(parseFloat(8.2));
	history.back(-1);
}