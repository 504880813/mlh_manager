//用于读卡操作获取数值

var timeFlag=true; //定时器falg
var isexitCard=false; //是否寻到卡阀门

//初始化
$(function(){
/*	var flag=true;
	//阀门
	while(flag){
		var isconnect=Connect();
		if(isconnect){
			$("#message").text("读卡器接入成功");
			
			var cardId=Findcard();
			if(cardId!=""){
				$("#message").text("卡片接入成功");
				$("#cardid").val(cardId);
			}else{
				$("#message").text("等待卡片接入");
			}
		}else{
			$("#message").text("读卡器接入失败");
		}
	}*/
	setTimeout(ConnectUsb,2000);
});
function ConnectUsb(){
	
	var flag=true;
	//链接读卡器，并循环寻卡
/*	while(flag){
		var isconnect=Connect();
		if(isconnect){
			$("#message").text("读卡器接入成功");
			timeid=setInterval(checkCard(), 1000);
			flag=false;
		}
	}
	while(timeFlag){
		if(isexitCard){
			clearInterval(timeid);
			timeFlag=false;
		}
	}
*/
	//链接读卡器，并显示读卡按钮
	while(flag){
			var isconnect=Connect();
			if(isconnect){
				$("#message").text("读卡器接入成功");
//				timeid=setInterval(checkCard(), 1000);
				
				var html="";
				html+="<input type=";
				html+="button id=";
				html+="checkcard  value=";
				html+="读卡  onclick=";
				html+="checkCard() />";
				
				$("#message").append(html);
				flag=false;
			}
	}
}
function checkCard(){
	var cardId=Findcard();
	if(cardId!=""){
			$("#message").text("卡片接入成功");
//			alert(cardId);
			$("input[name=cardid]").val(cardId);
//			isexitCard=true;
	}
}