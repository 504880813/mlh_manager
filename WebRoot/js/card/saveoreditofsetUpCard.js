//用于读卡操作获取数值

var timeFlagid; //定时器falg
var cardManagerisconnect=false; //判断读卡器是否连接

function ConnectUsb(){
	//链接读卡器，并显示读卡按钮
	cardManagerisconnect=Connect();
//	alert(cardManagerisconnect);
	if(cardManagerisconnect){
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
			
			$("input[name=cardid]").val(cardId);
	}
}