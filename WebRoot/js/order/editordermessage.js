

var adddishsname= new Array();
var retreatdishsname= new Array();

/**
 * 在页面dom加载完毕后，初始化加菜，退菜数组数据
 */

$(function(){
	//初始化添加菜品数组数据
	var adddishname=$("#alldish").next("table").find(".dishname");
	$.each(adddishname,function(key,val){
		adddishsname.push(val.innerHTML);
	});
	//初始化删除菜品数组数据 
	var retreatdishname=$("#orderdish").next("table").find(".dishname");
	$.each(retreatdishname,function(key,val){
		retreatdishsname.push(val.innerHTML);
	});
});


/**
 * 根据用户不同需求加菜
 * @param method
 * @param self 
 */
function adddish(method,self){
	//点 初点菜 
	if("initial"==method){
		var jqs=$(self);
		var orderdish=jqs.parents(".orderdish");
		alert(orderdish.length);
		//查询
		var currentname=orderdish.find(".dishname").text().trim();
		var currentprice=orderdish.find(".price").text().trim();
		alert(currentname);
		alert(currentprice);
		//向加菜栏加入初点菜
		adddishToListofuser(currentname, currentprice, "true", self);
	}
}
/**
 * 
 * @param method
 * @param self
 */
function retreatdish(method,self){
	//退初点菜
	if("initial"==method){
		
	}
}














/**
 * 表单提交
 */
function formsubmit(){
	
	//分别获取对应的table
	var adddishData=$("#alldish").next();
	var retreatdishData=$("#orderdish").next();
	
	//查询添加的菜品的菜品Name  adddishList.rdishname  adddishList.rdishname
	var adddishNameList=adddishData.find("input[name=adddishList.rdishname]");
	//查询添加的菜品的菜品类型
	var addechelonList=adddishData.find("input[name=adddishList.echelon]");
	//查询添加的菜品的价格
	var addpriceList=adddishData.find("input[name=adddishList.price]");
	//查询添加的菜品的数量
	var adddishnumberList=adddishData.find("input[name=adddishList.dishnumber]");
	
	//查询要退的菜品的菜品Name
	var retreatdishNameList=retreatdishData.find("input[name=retreatdishList.rdishname]");
	//查询要退的菜品的菜品类型
	var retreatechelonList=retreatdishData.find("input[name=retreatdishList.echelon]");
	//查询要退的菜品的价格
	var retreatpriceList=retreatdishData.find("input[name=retreatdishList.price]");
	//查询要退的菜品的数量
	var retreatdishnumberList=retreatdishData.find("input[name=retreatdishList.dishnumber]");
	alert("add"+adddishNameList.length);
	alert("retreat"+retreatdishNameList.length);
	initAddDishIndex(adddishNameList,addechelonList,addpriceList,adddishnumberList);
	initRetreatDishIndex(retreatdishNameList,retreatechelonList,retreatpriceList,retreatdishnumberList);
//	$("#editform").submit();
}
/**
 * 初始化添加菜品的下标
 * @param adddishidList
 * @param addechelonList
 * @param addpriceList
 * @param adddishnumberList
 */
function initAddDishIndex(adddishNameList,addechelonList,addpriceList,adddishnumberList){
	$.each(adddishNameList,function(k,v){
		v.name="adddishList["+k+"].rdishname";
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
		v.name="retreatdishList["+k+"].rdishname";
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
 * 根据用户的操作，判断，加菜/退菜操作
 */
function adddishToListofuser(name,price,isadd,self){
	//判断是加菜还是退菜
	if(isadd=="true"){
		//判断是叠加还是新增
		//叠加
		if(ArrayContain(adddishsname,name)){
			changedishToList(name,price,isadd,self);
		}else{
			//新增
			adddishToList(name,1,price,price,isadd,self);
		}
	}else{
		//判断是叠加还是新增
		//叠加
		if(ArrayContain(retreatdishsname,name)){
			changedishToList(name,price,isadd,self);
		}else{
			//新增
			adddishToList(name,1,price,price,isadd,self);
		}
	}
	//改变总价
	changeAllprice();
}
/**
 * 将商品放到指定的目录下，并修改总价
 * @param name
 * @param price
 */
function adddishToList(name,dishnumber,price,allprice,isadd,self){

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
			html+=".rdishname value=" ;
			html+=name;
			html+=">";
			
			html+="<input type='hidden' name=adddishList";
			html+=".echelon value=" ;
			html+=2;
			html+=">";
			
			html+="<input type='hidden' name=adddishList";
			html+=".price class='orderdetailPrice' value=";
			html+=price;
			html+=">";
			
			html+="<td class='dishname' nowrap='nowrap' align='right' bgcolor='#f1f1f1' colspan='2'>";
			html+=name;
			html+="</td>";
			
		//	
		//	html+="<td>";
		//	html+=price;
		//	html+="</td>";
			
			/*<td>数量</td>*/
			html+="<td class='dishnumber' nowrap='nowrap' align='right' bgcolor='#f1f1f1'>";
			html+="<input type='hidden' value='";
			html+=dishnumber;
			html+="' name='adddishList";
			html+=".dishnumber' class='dishnumberInput' readonly=‘readonly’ />";
			html+="<span class='showNumber'>";
			html+=dishnumber;
			html+="</span>";
			html+="</td>";
	}else{
		
			html+="<input type='hidden' name=retreatdishList";
			html+=".rdishname value=" ;
			html+=name;
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
			
			
			html+="<td class='dishname'nowrap='nowrap' align='right' bgcolor='#f1f1f1' colspan='2'>";
			html+=name;
			html+="</td>";
			
			html+="<td class='dishnumber' nowrap='nowrap' align='right' bgcolor='#f1f1f1'>";
			html+="<input type='text' value='";
			html+=dishnumber;
			html+="' name='retreatdishList";
			html+=".dishnumber' class='dishnumberInput' readonly=‘readonly’ />";
			html+="</td>";
	}
	
	html+="<td class='price' nowrap='nowrap' align='right' bgcolor='#f1f1f1'> ";
	html+=price;
	html+="</td>";
	
//	<td>价格</td>
	if(isadd=="true"){
		html+="<td class='addtotalprice' nowrap='nowrap' align='right' bgcolor='#f1f1f1'> ";
		html+=allprice;
		html+="</td>";
	}else{
		html+="<td class='reducetotalprice' nowrap='nowrap' align='right' bgcolor='#f1f1f1'> ";
		html+=allprice;
		html+="</td>";
	}
	
	
//	<td>操作</td>
	html+="<td nowrap='nowrap' align='right' bgcolor='#f1f1f1'>";
	html+="<input value='+1' name='add' class='btn btn-info' style='width:80px;' type='button' onclick=";
	html+="adddish";
	html+="(add,this) >";
	html+="<input value='-1' name='retreat' class='btn btn-info' style='width:80px;' type='button' onclick=";
	html+="retreatdish";
	html+="(add,this) >";
	html+="</td>";
	html+="</tr>";
	
//	<input value="+1" name="add" class="btn btn-info" style="width:80px;" type="button" onclick="adddish('add',this)">
//	<input value="-1" name="retreat" class="btn btn-info" style="width:80px;" type="button" onclick="retreatdish('add',this)">
//	
//	</td>
	
	
//	alert(html);
	if(isadd=="true"){
		$("#adddishtr").after(html);
	}else{
		$("#orderdish").after(html);
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
 * todo    改动。。
 * 改变指定菜品的菜品数量和总价
 */
function changedishToList(name,price,isadd,self){
	
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
				adddishToList(name,addnumber,price,allprice, "true",currentdish.parent());

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
					adddishToList(name,addnumber,price,allprice, "false",currentdish.parent());
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