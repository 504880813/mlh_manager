
var htmltrtdTemplateStart="<tr><td align='right' bgcolor='#f1f1f1' >";
var htmltrtdTemplatend="</td>";




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
	
	var htmloldcode="";
	htmloldcode+=htmltrtdTemplateStart;
	htmloldcode+="会员卡类型";
	htmloldcode+=htmltrtdTemplatend;
	htmloldcode+="<td>";
	
	htmloldcode+="<input type='radio' onclick=";
	htmloldcode+="showInputdiv(";
	htmloldcode+="'true','"; 
	htmloldcode+=cardid;
	htmloldcode+="','"; 
	htmloldcode+=belongsCardid;
	htmloldcode+="','"; 
	htmloldcode+=username;
	htmloldcode+="','"; 
	htmloldcode+=phone;
	htmloldcode+="','"; 
	htmloldcode+=money;
	htmloldcode+="','"; 
	htmloldcode+=cardLevel;
	htmloldcode+="','"; 
	htmloldcode+=isedit;
	htmloldcode+="') /> 主卡"; 
	
	htmloldcode+="<input type='radio' onclick=";
	htmloldcode+="showInputdiv(";
	htmloldcode+="'false','"; 
	htmloldcode+=cardid;
	htmloldcode+="','"; 
	htmloldcode+=belongsCardid;
	htmloldcode+="','"; 
	htmloldcode+=username;
	htmloldcode+="','"; 
	htmloldcode+=phone;
	htmloldcode+="','"; 
	htmloldcode+=money;
	htmloldcode+="','"; 
	htmloldcode+=cardLevel;
	htmloldcode+="','"; 
	htmloldcode+=isedit;
	htmloldcode+="') /> 副卡"; 
	
	htmloldcode+="</td></tr>";
	
	alert(htmloldcode);
	if(cardManagerisconnect==false){
		timeFlagid=setInterval(ConnectUsb,2000);
	}
	//主卡
	if("true"==ismain){
		addMaincardInput(cardid,belongsCardid,username,phone,money,cardLevel,isedit,htmloldcode);
	}
	//副卡
	if("false"==ismain){
		addVicecardInput(cardid,belongsCardid,username,phone,money,cardLevel,isedit,htmloldcode);
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
function addMaincardInput(cardid,belongsCardid,username,phone,money,cardLevel,isedit,htmloldcode){
	
	/**
	 *  <tr>
       <td align="right" bgcolor="#f1f1f1" >会员卡类型：</td>
       <td>
	       <input type="radio" onclick="showInputdiv('true','${card.cardid }','${card.belongsCardid}','${card.username}','${card.phone}','${card.money}','${card.level }','${card.id!=null}')"/>主卡 
		   <input type="radio" onclick="showInputdiv('false','${card.cardid }','${card.belongsCardid}','${card.username}','${card.phone}','${card.money}','${card.id!=null}')"/>副卡 
	   </td>
     </tr>
	 */
	
	//将原数据节点移除
	var messagediv=$("#cardMessage");
//	messagediv.children().remove();
	messagediv.empty();
	
	
	var html="";
	html+=htmloldcode;
	
	html+=htmltrtdTemplateStart;
	html+="读卡器链接状态";
	html+=htmltrtdTemplatend;
	html+="<td>";
	if(cardManagerisconnect==false){
		html+="<span id='message'>";
		html+="正在连接刷卡器";
		html+="</span>";
	}else{
		html+="<span id='message'>";
		html+="读卡器接入成功";
		html+="</span> ";
		html+="<input type=";
		html+="button id=";
		html+="checkcard  value=";
		html+="读卡  onclick=";
		html+="checkCard() />";
	}
	html+="</td></tr>";
	
	
	html+=htmltrtdTemplateStart;
	html+="卡号";
	html+=htmltrtdTemplatend;
	html+="<td>";
	html+="<input type='text' name='cardid'";
	html+=cardid==''?'':"value= "+cardid;
	if(isedit=="true"){
	html+="  readonly=readonly";
	}
	html+=" />";
	html+="</td></tr>";
	
	html+=htmltrtdTemplateStart;
	html+="用户名";
	html+=htmltrtdTemplatend;
	html+="<td>";
	html+="<input type='text' name='username' ";
	html+=username==''?'':"value= "+username;
	html+=" />";
	html+="</td></tr>";
	
	html+=htmltrtdTemplateStart;
	html+="电话";
	html+=htmltrtdTemplatend;
	html+="<td>";
	html+="<input type='text' name='phone' ";
	html+=phone==''?'':"value= "+phone;
	html+=" />";
	html+="</td></tr>";
	
	html+=htmltrtdTemplateStart;
	html+="开通金额";
	html+=htmltrtdTemplatend;
	html+="<td>";
	html+="<input type='text' name='money' ";
	html+=money==''?'':"value= "+money;
	if(isedit=="true"){
		html+="  readonly=readonly";
	}
	html+=" />";
	html+="</td></tr>";
	
	//获取卡片分类并添加入主卡选项
	
	var cardlevelSpan=$("#levelSpan").text().trim();
//	alert("cardlevelSpan---->"+cardlevelSpan);
	
	var cardlevelSpans= new Array(); //定义一数组 
	cardlevelSpans=cardlevelSpan.split(",");
	
	
	html+=htmltrtdTemplateStart;
	html+="会员卡等级";
	html+=htmltrtdTemplatend;
	html+="<td>";
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
	html+="</td></tr>";
	
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
function addVicecardInput(cardid,belongsCardid,username,phone,money,cardLevel,isedit,htmloldcode){
	var messagediv=$("#cardMessage");
	messagediv.empty();
	var html="";
	html+=htmloldcode;
	
	html+=htmltrtdTemplateStart;
	html+="读卡器链接状态";
	html+=htmltrtdTemplatend;
	html+="<td>";
	
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
	html+="</td></tr>";
	
	html+=htmltrtdTemplateStart;
	html+="卡号";
	html+=htmltrtdTemplatend;
	html+="<td>";
	html+="<input type='text' name='cardid' ";
	html+=cardid==''?'':"value= "+cardid;
	if(isedit=="true"){
	html+="  readonly=readonly";
	}
	html+=" />";
	html+="</td></tr>";
	
	html+=htmltrtdTemplateStart;
	html+="主卡号";
	html+=htmltrtdTemplatend;
	html+="<td>";
	html+="<input type='text' name='belongsCardid' ";
	html+=belongsCardid==''?'':"value= "+belongsCardid;
	if(isedit=="true"){
	html+="  readonly=readonly";
	}
	html+=" />";
	html+="</td></tr>";
	
	html+=htmltrtdTemplateStart;
	html+="用户名";
	html+=htmltrtdTemplatend;
	html+="<td>";
	html+="<input type='text' name='username' ";
	html+=username==''?'':"value= "+username;
	html+=" />";
	html+="</td></tr>";
	
	html+=htmltrtdTemplateStart;
	html+="电话";
	html+=htmltrtdTemplatend;
	html+="<td>";
	html+="<input type='text' name='phone' ";
	html+=phone==''?'':"value= "+phone;
	html+=" />";
	html+="<input type='hidden' name='money' ";
	html+="value=0";
	html+=" />";
	html+="<input type='hidden' name='level' ";
	html+="value=";
	html+=cardLevel;
	html+=" />";
	html+="</td></tr>";
	
	//等级为副卡 副卡默认维护
	messagediv.append(html);
}