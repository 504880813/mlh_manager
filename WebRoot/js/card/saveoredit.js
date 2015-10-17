/**
 * 添加卡片信息输入框节点
 * @param ismain
 * @param cardid
 * @param belongsCardid
 * @param username
 * @param phone
 * @param money
 * @param isedit
 */
function showInputdiv(ismain,cardid,belongsCardid,username,phone,money,cardLevel,isedit){
	
	if(cardManagerisconnect==false){
		timeFlagid=setInterval(ConnectUsb,2000);
	}
	//主卡
	if("true"==ismain){
		addMaincardInput(cardid,belongsCardid,username,phone,money,cardLevel,isedit);
	}
	//副卡
	if("false"==ismain){
		addVicecardInput(cardid,belongsCardid,username,phone,money,isedit);
	}
}
/**
 * 添加主卡信息框
 * @param cardid
 * @param belongsCardid
 * @param username
 * @param phone
 * @param money
 * @param cardLevel
 * @param isedit
 */
function addMaincardInput(cardid,belongsCardid,username,phone,money,cardLevel,isedit){
	//将原数据节点移除
	var messagediv=$("#cardMessage");
//	messagediv.children().remove();
	messagediv.empty();
	var html="";
	if(cardManagerisconnect==false){
		html+="<span id='message'>";
		html+="正在连接刷卡器";
		html+="</span> <br /> ";
	}else{
		html+="<span id='message'>";
		html+="读卡器接入成功";
		html+="</span> ";
		html+="<input type=";
		html+="button id=";
		html+="checkcard  value=";
		html+="读卡  onclick=";
		html+="checkCard() /> <br /> ";
	}
	html+="卡号<input type='text' name='cardid'";
	html+=cardid==''?'':"value= "+cardid;
	if(isedit=="true"){
	html+="  readonly=readonly";
	}
	html+=" />";
	html+="用户名<input type='text' name='username' ";
	html+=username==''?'':"value= "+username;
	html+=" />";
	html+="电话<input type='text' name='phone' ";
	html+=phone==''?'':"value= "+phone;
	html+=" />";
	html+="开通金额<input type='text' name='money' ";
	html+=money==''?'':"value= "+money;
	html+=" />";
	
	//获取卡片分类并添加入主卡选项
	
	var cardlevelSpan=$("#levelSpan").text().trim();
//	alert("cardlevelSpan---->"+cardlevelSpan);
	
	var cardlevelSpans= new Array(); //定义一数组 
	cardlevelSpans=cardlevelSpan.split(",");
	
	for(var i=0;i<cardlevelSpans.length;i++){
		if(cardlevelSpans[i].trim()==-1){
			continue;
		}
		if(cardlevelSpans[i].trim()==cardLevel){
			html+="<input type='radio' name='level' ";
			html+="value= "+cardlevelSpans[i].trim();
			html+=" checked />";
			html+=cardlevelSpans[i].trim();
		}else{
			html+="<input type='radio' name='level' ";
			html+="value= "+cardlevelSpans[i].trim();
			html+=" />";
			html+=cardlevelSpans[i].trim();
		}
		
	}
	
	messagediv.append(html);
}
/**
 * 添加副卡信息框
 * @param cardid
 * @param belongsCardid
 * @param username
 * @param phone
 * @param money
 * @param isedit
 */
function addVicecardInput(cardid,belongsCardid,username,phone,money,isedit){
	var messagediv=$("#cardMessage");
	messagediv.empty();
	var html="";
	if(cardManagerisconnect==false){
		html+="<span id='message'>";
		html+="正在连接刷卡器";
		html+="</span> <br /> ";
	}else{
		html+="<span id='message'>";
		html+="读卡器接入成功";
		html+="</span> ";
		html+="<input type=";
		html+="button id=";
		html+="checkcard  value=";
		html+="读卡  onclick=";
		html+="checkCard() /> <br /> ";
	}
	html+="卡号<input type='text' name='cardid' ";
	html+=cardid==''?'':"value= "+cardid;
	if(isedit=="true"){
	html+="  readonly=readonly";
	}
	html+=" />";
	html+="主卡号<input type='text' name='belongsCardid' ";
	html+=belongsCardid==''?'':"value= "+belongsCardid;
	if(isedit=="true"){
	html+="  readonly=readonly";
	}
	html+=" />";
	html+="用户名<input type='text' name='username' ";
	html+=username==''?'':"value= "+username;
	html+=" />";
	html+="电话<input type='text' name='phone' ";
	html+=phone==''?'':"value= "+phone;
	html+=" />";
	
	//等级为副卡 副卡默认维护
	messagediv.append(html);
}