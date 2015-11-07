

var adddishsname= new Array();
var retreatdishsname= new Array();
//添加的菜品数量
var adddishsMap={};
//删除的菜品数量
var retreatdishsMap={};
//正常的菜品数量
var normaldishsMap={};


/**
 * 在页面dom加载完毕后，初始化加菜，退菜数组数据
 */

$(function(){
	//初始化正常菜品数据
	var normaldishname=$("table:first").find(".dishname");
	$.each(normaldishname,function(key,val){
		var currentdishnumber=$(val).next().text();
		normaldishsMap[val.innerHTML]=currentdishnumber;
//		alert("text-->"+val.innerHTML);
//		alert(normaldishsMap[val.innerHTML]);
	});
	//初始化添加菜品数组数据
	var adddishname=$("#alldish").next("table").find(".dishname");
	$.each(adddishname,function(key,val){
		adddishsname.push(val.innerHTML);
		var currentdishnumber=$(val).next().text();
		adddishsMap[val.innerHTML]=currentdishnumber;
	});
	//初始化删除菜品数组数据 
	var retreatdishname=$("#orderdish").next("table").find(".dishname");
	$.each(retreatdishname,function(key,val){
		retreatdishsname.push(val.innerHTML);
		var currentdishnumber=$(val).next().text();
		retreatdishsMap[val.innerHTML]=currentdishnumber;
	});
});

/**
 * 表单提交
 */
function formsubmit(){
	
	//分别获取对应的table
	var adddishData=$("#alldish").next();
	var retreatdishData=$("#orderdish").next();
	
	//查询添加的菜品的菜品ID
	var adddishidList=adddishData.find("input[name=adddishList.rdishid]");
	//查询添加的菜品的菜品类型
	var addechelonList=adddishData.find("input[name=adddishList.echelon]");
	//查询添加的菜品的价格
	var addpriceList=adddishData.find("input[name=adddishList.price]");
	//查询添加的菜品的数量
	var adddishnumberList=adddishData.find("input[name=adddishList.dishnumber]");
	
	//查询要退的菜品的菜品ID
	var retreatdishidList=retreatdishData.find("input[name=retreatdishList.rdishid]");
	//查询要退的菜品的菜品类型
	var retreatechelonList=retreatdishData.find("input[name=retreatdishList.echelon]");
	//查询要退的菜品的价格
	var retreatpriceList=retreatdishData.find("input[name=retreatdishList.price]");
	//查询要退的菜品的数量
	var retreatdishnumberList=retreatdishData.find("input[name=retreatdishList.dishnumber]");
	initAddDishIndex(adddishidList,addechelonList,addpriceList,adddishnumberList);
	initRetreatDishIndex(retreatdishidList,retreatechelonList,retreatpriceList,retreatdishnumberList);
	$("#editform").submit();
}
/**
 * 初始化添加菜品的下标
 * @param adddishidList
 * @param addechelonList
 * @param addpriceList
 * @param adddishnumberList
 */
function initAddDishIndex(adddishidList,addechelonList,addpriceList,adddishnumberList){
	$.each(adddishidList,function(k,v){
		v.name="adddishList["+k+"].rdishid";
	});
	$.each(addechelonList,function(k,v){
		v.name="adddishList["+k+"].echelon";	
	});
	$.each(addpriceList,function(k,v){
		v.name="adddishList["+k+"].price";
	});
	$.each(adddishnumberList,function(k,v){
		v.name="adddishList["+k+"].dishnumber";
	});
}
/**
 * 初始化删除菜品的下标
 * @param retreatdishidList
 * @param retreatechelonList
 * @param retreatpriceList
 * @param retreatdishnumberList
 */
function initRetreatDishIndex(retreatdishidList,retreatechelonList,retreatpriceList,retreatdishnumberList){
	$.each(retreatdishidList,function(k,v){
		v.name="retreatdishList["+k+"].rdishid";
	});
	$.each(retreatechelonList,function(k,v){
		v.name="retreatdishList["+k+"].echelon";	
	});
	$.each(retreatpriceList,function(k,v){
		v.name="retreatdishList["+k+"].price";
	});
	$.each(retreatdishnumberList,function(k,v){
		v.name="retreatdishList["+k+"].dishnumber";
	});
}

/**
 * 为添加菜品准备资源
 */
function adddishofMessage(Rootpath){
	finddishs(Rootpath);
}
/**
 * 为退菜准备资源
 */
function RetreatdishofMessage(self){
	findorderdishs(self);
}
/**
 * 利用ajax查询所有菜品
 */
function finddishs(Rootpath){
	$("#alldish table:first tr:not(tr:first)").remove();
	
	$.ajax({ //一个Ajax过程 
		type: "post", //以post方式与后台沟通 
		url : Rootpath+"/dish/findAllDishRetrunJson.action", 
		dataType:'json',
		success: function(json){//如果调用成功 
		//	alert(json[0].name);
			adddishsfromAJaxBycategory(json);
		},
		error : function(data) {  
			$("#alldish table:first").append("请求失败");
		}  
	}); 
}

/**
 * 将查询到的菜品信息，放入菜品模块页面中
 * 
 */
function adddishsfromAJaxBycategory(json){
	$.each(json, function(key, val) { 
		var id=json[key].id;
	   	var name=json[key].name;
	    var price=json[key].price;
//	    if(!ArrayContain(orderdishsId,id)){
	    	adddishsofhtml(id,name,price,"true");
//	    }
	});
}


/**
 * 向菜品模块的添加html
 */
function adddishsofhtml(id,name,price,isadd){
	var html="<tr>";
//	html+="<td>";
//	html+=id;
//	html+="</td>";
	html+="<td>";
	html+=name;
	html+="</td>";
	html+="<td>";
	html+=price;
	html+="</td>";
//	<td>操作</td>
	html+="<td>";
	html+="<input type='button' value='add' onclick=";
	html+="adddishToListofuser";
	html+="('" +id;
	html+="','" +name;
	html+="','" +price;
	html+="','" +isadd;
	html+="',this)>";
	html+="</td>";
	html+="</tr>";
	
	
	if(isadd=="true"){
		$("#alldish").css("display","");
		$("#alldish table:first").append(html);
	}else{
		$("#orderdish").css("display","");
		$("#orderdish table:first").append(html);
	}
	
}

/**
 * 查询所有可以退的菜
 */
function findorderdishs(self){
	//移除旧数据
	$(self).next().find("table tr:not(first)").remove();
	
	//添加新数据
	var orderdishList=$(".orderdish");
	
	$.each(orderdishList,function(key,val){
		var dishname=$(val).find(".dishname").text();
		var dishid=$(val).find("input:first").val();
		var price=$(val).find(".price").text();
		price=$.trim(price);
//		var dishname=$(val).find(".dishname");
		adddishsofhtml(dishid,dishname,price,"false");
	});
	
}

/**
 * 根据用户的操作，判断，加菜/退菜操作
 */
function adddishToListofuser(id,name,price,isadd,self){
	//判断是加菜还是退菜
	if(isadd=="true"){
		//判断是叠加还是新增
		//叠加
		if(ArrayContain(adddishsname,name)){
			changedishToList(id,name,price,isadd,self);
		}else{
			//新增
			adddishToList(id,name,1,price,price,isadd,self);
		}
	}else{
		//判断是叠加还是新增
		//叠加
		if(ArrayContain(retreatdishsname,name)){
			changedishToList(id,name,price,isadd,self);
		}else{
			//新增
			adddishToList(id,name,1,price,price,isadd,self);
		}
	}
	
	//改变总价
	changeAllprice();
}
/**
 * 将商品放到指定的目录下，并修改总价
 * @param id
 * @param name
 * @param price
 */
function adddishToList(id,name,dishnumber,price,allprice,isadd,self){
	
//	orderdishsId.push(id);
	
//	var jqs=$(self);
//	jqs.parent().parent().remove();
	if(isadd=="true"){
		if(!ArrayContain(adddishsname, name)){
			adddishsname.push(name);
		}
//		adddishsMap[name]=dishnumber;
	}else{
		if(!ArrayContain(retreatdishsname, name)){
			retreatdishsname.push(name);
		}
	}
	
	
	
	var html="<tr class='orderdish'>";
	
	if("true"==isadd){
			html+="<input type='hidden' name=adddishList";
			html+=".rdishid value=" ;
			html+=id;
			html+=">";
			
			html+="<input type='hidden' name=adddishList";
			html+=".echelon value=" ;
			html+=2;
			html+=">";
			
			html+="<input type='hidden' name=adddishList";
			html+=".price class='orderdetailPrice' value=";
			html+=price;
			html+=">";
			
		//	html+="<td>";
		//	html+=id;
		//	html+="</td>";
			
			
			html+="<td class='dishname' >";
			html+=name;
			html+="</td>";
			
		//	
		//	html+="<td>";
		//	html+=price;
		//	html+="</td>";
			
			/*<td>数量</td>*/
			html+="<td class='dishnumber'>";
			html+="<input type='text' value='";
			html+=dishnumber;
			html+="' name='adddishList";
			html+=".dishnumber' class='dishnumberInput' readonly=‘readonly’ />";
			html+="</td>";
	}else{
		
			html+="<input type='hidden' name=retreatdishList";
			html+=".rdishid value=" ;
			html+=id;
			html+=">";
			
			html+="<input type='hidden' name=retreatdishList";
			html+=".echelon value=" ;
			html+=0;
			html+=">";
			
			html+="<input type='hidden' name=retreatdishList";
			html+=".price class='orderdetailPrice' value=";
			html+=price;
			html+=">";
			
		//	html+="<td>";
		//	html+=id;
		//	html+="</td>";
			
			
			html+="<td class='dishname'>";
			html+=name;
			html+="</td>";
			
			html+="<td class='dishnumber'>";
			html+="<input type='text' value='";
			html+=dishnumber;
			html+="' name='retreatdishList";
			html+=".dishnumber' class='dishnumberInput' readonly=‘readonly’ />";
			html+="</td>";
	}
	
	html+="<td class='price'> ";
	html+=price;
	html+="</td>";
	
//	<td>价格</td>
	if(isadd=="true"){
		html+="<td class='addtotalprice'> ";
		html+=allprice;
		html+="</td>";
	}else{
		html+="<td class='reducetotalprice'> ";
		html+=allprice;
		html+="</td>";
	}
	
	
//	<td>操作</td>
	html+="<td>";
	html+="<input type='button' value='Reduce' onclick=";
	html+="reducethisself";
	html+="(this";
//	html+=",'" +id;
//	html+="','" +name;
	html+=",'" +isadd;
	html+="')>";
	html+="</td>";
	html+="</tr>";
//	alert(html);
	if(isadd=="true"){
		$("#alldish").append(html);
	}else{
		$("#orderdish").append(html);
	}
	
//	changeprice(dishnameList, isadd);
//	changeAllprice();
}
/**
 * 将自身的数量减1，并改变价格
 */
function reducethisself(self,isadd){
	
	var dishname=$(self).parent().siblings(".dishname").text();
	var dishnumberObject=$(self).parent().siblings(".dishnumber").find("input");
	var container=$(self).parent().parent().parent();
	var dishnameList=container.find(".dishname");
	
	var dishnumber=parseFloat(dishnumberObject.val())-1;
	if(dishnumber==0){
		$(self).parent().parent().remove();
		if(isadd=="true"){
			adddishsname.splice($.inArray(dishname,adddishsname),1);
		}else{
			retreatdishsname.splice($.inArray(dishname,retreatdishsname),1);
		}
		
	}
	if(isadd=="true"){
		if(adddishsMap[dishname]>dishnumber){
			dishnumber=adddishsMap[dishname];
			alert("已经减少到最低值");
		}
		else if(dishnumber<0){
			adddishsMap[dishname]=0;
		}
	}else{
		if(retreatdishsMap[dishname]>dishnumber){
			dishnumber=retreatdishsMap[dishname];
			alert("已经减少到最低值");
		}
		else if(dishnumber<0){
			retreatdishsMap[dishname]=0;
		}
	}
	dishnumberObject.val(dishnumber);
	
	//改变单个条目价格
	changeprice(dishnameList,isadd);
	//改变总价
	changeAllprice();
	
}
/**
 * 改变指定菜品的菜品数量和总价
 */
function changedishToList(id,name,price,isadd,self){
	var jqs=$(self);
	
	var container=jqs.parent().parent().parent().parent().parent();
	
/*	var container=$("#mainFrame");*/
	
	var dishnameList=container.find(".dishname");
	
	$.each(dishnameList,function(key,val){
		var text=val.innerHTML;
		if(name==text){
			var currentdish=$(val);
			var currentdishnumber=currentdish.parent().find(".dishnumber").find("input");
			var currentnumber=0;
			if(currentdishnumber.length==0){
				currentnumber=currentdish.parent().find(".dishnumber").text();
			}else{
				currentnumber=currentdishnumber.val();
			}

//			var currentnumber=currentdishnumber.val();
			var addnumber=parseFloat(currentnumber)+1;
			if("true"==isadd){
				var allprice;
				if(currentdishnumber.length==0){
					allprice=currentdish.parent().find(".addtotalprice").text();
				}else{
					allprice=currentdish.parent().find(".addtotalprice").val();
				}
			
				currentdish.parent().remove();
				adddishToList(id, name,addnumber,price,allprice, "true",currentdish.parent());

			}else{
//				alert("add-->"+text);
				var allnumber=0;
				if(typeof(normaldishsMap[text])!="undefined"){
					allnumber+=parseFloat(normaldishsMap[text]);
//					alert("normaldishsMap"+allnumber);
				}
				if(typeof(adddishsMap[text])!="undefined"){
					allnumber+=parseFloat(adddishsMap[text]);	
//					alert("adddishsMap"+allnumber);
				}
//				if(typeof(retreatdishsMap[text])!="undefined"){
//					allnumber-=parseFloat(retreatdishsMap[text]);
//					alert("retreatdishsMap"+allnumber);
//				}
//				alert("all"+allnumber);
				if(addnumber>allnumber){
					alert("已经无法退菜了");
				}else{
					var allprice;
					if(currentdishnumber.length==0){
						allprice=currentdish.parent().find(".reducetotalprice").text();
					}else{
						allprice=currentdish.parent().find(".reducetotalprice").val();
					}
					currentdish.parent().remove();
					adddishToList(id, name,addnumber,price,allprice, "false",currentdish.parent());
				}
			}
		}
	});
	
	//改变价格
	changeprice(jqs.parent().parent().parent().parent().parent().find(".dishname"),isadd);
	//改变总价
	changeAllprice();
}

/**
 * 改变价格以及总价
 * @param dishnameList
 */
function changeprice(dishnameList,isadd){
	
	$.each(dishnameList,function(key,val){
		var currentdish=$(val);
		var currentdishDom=currentdish.parent().find(".dishnumber").find("input");
		var currentdishnumber;
		if(currentdishDom.length==0){
			currentdishnumber=currentdish.parent().find(".dishnumber").text();
		}else{
			currentdishnumber=currentdish.parent().find(".dishnumber").find("input").val();
		}
		var currentdishprice=currentdish.parent().find(".price");
		var currentdishaddtotalpriceInput;
		var currentdishaddtotalprice;
		if(isadd=="true"){
			currentdishaddtotalprice=currentdish.parent().find(".addtotalprice");
//			currentdishaddtotalpriceInput=currentdish.parent().find(".orderdetailPrice");
		}else{
			currentdishaddtotalprice=currentdish.parent().find(".reducetotalprice");
		}
		currentdishaddtotalpriceInput=currentdish.parent().find(".orderdetailPrice");
//		alert("currentdishprice.text()-->"+currentdishprice.text().trim());
//		alert("currentdishnumber-->"+currentdishnumber);
//		alert("all"+parseFloat($.trim(currentdishprice.text()))*parseFloat(currentdishnumber));
		currentdishaddtotalprice.text(parseFloat($.trim(currentdishprice.text()))*parseFloat(currentdishnumber));
//		alert(currentdishaddtotalpriceInput.val());
		currentdishaddtotalpriceInput.val(parseFloat($.trim(currentdishprice.text()))*parseFloat(currentdishnumber));
	});
}
/**
 * 改变总价
 */
function changeAllprice(){
	//normaltotalprice
	//addtotalprice
	//reducetotalprice
	var normaltotalpriceList=$(".normaltotalprice");
	var addtotalpriceList=$(".addtotalprice");
	var reducetotalpriceList=$(".reducetotalprice");
	
	var allprice=0;
	
	$.each(normaltotalpriceList,function(key,val){
		allprice=allprice+parseFloat(val.innerHTML);
	});
	$.each(addtotalpriceList,function(key,val){
		allprice=allprice+parseFloat(val.innerHTML);
	});
	$.each(reducetotalpriceList,function(key,val){
		allprice=allprice-parseFloat(val.innerHTML);
	});
//	alert(allprice);
	$("#allprice").text(allprice);
	$("#allprice").next().val(allprice);
}

/**
 * 判断数组中是否包含指定元素
 * @param array
 * @param context
 * @returns {Boolean}
 */
function ArrayContain(array,context){
	for(var i=0;i<array.length;i++){
		if(array[i]==context){
			return true;
		}
	}
	return false;
}
/**
 * 将页面跳转到指定url上
 * @param url
 */
function PageToUrl(url){
	window.location.href=url;
}