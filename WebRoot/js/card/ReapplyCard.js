//用于读卡操作获取数值

var timeFlagid; //定时器falg

var isconnect=false; //判断读卡器是否连接

//初始化
$(function(){
	timeFlagid=setInterval(ConnectUsb,2000);
});
function ConnectUsb(){
	//链接读卡器，并显示读卡按钮
	isconnect=Connect();
	if(isconnect){
		$("#message").text("读卡器接入成功");
		var html="";
		html+="<input type=";
		html+="button id=";
		html+="checkcard  value=";
		html+="读卡  onclick=";
		html+="checkCard() />";
		$("#message").append(html);
		
		clearInterval(timeFlagid);
	}
}
function checkCard(){
	var cardId=Findcard();
	if(cardId!=""){
//			$("#message").text("卡片接入成功");
//			alert(cardId);
			$("input[name=newid]").val(cardId);
//			isexitCard=true;
	}
}