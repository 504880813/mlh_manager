/*
 *通过电话号码，获取会员卡号
 */


//查询会员卡，根据电话号码
function selectcardByphoneNumber(Rootpath){
	
	var phoneNumber=$("input[name=phoneNumber]").val().trim();
	
	$.ajax({ //一个Ajax过程 
		type: "post", //以post方式与后台沟通 
		url : Rootpath+"/order/findcardByPhoneNumberRetrunJson.action", 
		dataType:'json', 
		data: 'phoneNumber='+phoneNumber,
		success: function(json){//如果调用成功 
			addcardTocardDiv(Rootpath,json);
		},
		error : function(data) {  
			alert("网络异常！"+data);
		}  
	}); 
	
}
/**
 * 向卡号发送验证码
 * @param Rootpath
 * @param cardid
 */
function sendVerificationCode(Rootpath,cardid){
	
	alert(cardid);
	$.ajax({ //一个Ajax过程 
		type: "post", //以post方式与后台沟通 
		url : Rootpath+"/card/sendVerificationCodeofajax.action", 
		dataType:'text', 
		data: 'cardid='+cardid,
		success: function(text){//如果调用成功 
			ReadySubmit(text);
		},
		error : function(data,message) {  
			alert("网络异常！"+data);
			alert(message);
		}  
	}); 
	
	
}

/**
 * 准备提交表单
 * @param json
 */
function ReadySubmit(text){
	alert("text------>"+text);
	var cardid=text;
//	alert(cardid);
	
	$("input[name=cardid]").val(cardid);
	
	$("#validationCodeDiv").show();
}

/**
 *	将json数据封装到cardDiv里面去
 * @param Rootpath
 * @param json
 */
function addcardTocardDiv(Rootpath,json){
	var html="";
	html+="<table>";
	html+="<tr>";
	html+="<td>";
	html+="用户名";
	html+="</td>";
	html+="<td>";
	html+="卡片类型";
	html+="</td>";
	html+="<td>";
	html+="是否关联微信";
	html+="</td>";
	html+="<td>";
	html+="操作";
	html+="</td>";
	html+="</tr>";
	if(json==null){
		html+="<tr>";
		html+="<td colspan=4>";
		html+="没有电话号码对应的会员卡";
		html+="</td>";
		html+="</tr>";
	}else{
		$.each(json,function(key,val){
			html+="<tr>";
			html+="<td>";
			html+=val.username;
			html+="</td>";
			html+="<td>";
			html+=val.level;
			html+="</td>";
			html+="<td>";
			html+=(val.wechatOpenid==null||val.wechatOpenid.trim()=="")?"未关联":"关联";
			html+="</td>";
			html+="<td>";
			html+="操作";
			html+="<input type='button' value='确认卡号' onclick=";
			html+="sendVerificationCode(";
			html+="'";
			html+=Rootpath;
			html+="','";
			html+=val.cardid;
			html+="') /> " ;
			html+="</td>";
			html+="</tr>";
		});	
	}

	html+="</table>";
	$("#cardDiv").html(html);
}