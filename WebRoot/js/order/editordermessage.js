

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
		var currentdishnumber=$(val).next().find("input").val();
		adddishsMap[val.innerHTML]=currentdishnumber;
	});
	//初始化删除菜品数组数据 
	var retreatdishname=$("#orderdish").next("table").find(".dishname");
	$.each(retreatdishname,function(key,val){
		retreatdishsname.push(val.innerHTML);
		var currentdishnumber=$(val).next().find("input").val();
		retreatdishsMap[val.innerHTML]=currentdishnumber;
	});
});

/**
 * 为添加菜品准备资源
 */
function adddishofMessage(Rootpath){
	finddishs(Rootpath);
}
/**
 * 为退菜准备资源
 */
function RetreatdishofMessage(){
	findorderdishs();
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
			changedishToList(name,price,isadd,self);
		}else{
			//新增
			adddishToList(id,name,price,isadd,self);
		}
	}else{
		//判断是叠加还是新增
		//叠加
		if(ArrayContain(retreatdishsname,name)){
			changedishToList(name,price,isadd,self);
		}else{
			//新增
			adddishToList(id,name,price,isadd,self);
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
function adddishToList(id,name,price,isadd,self){
	
//	orderdishsId.push(id);
	
//	var jqs=$(self);
//	jqs.parent().parent().remove();
	if(isadd=="true"){
		adddishsname.push(name);
	}else{
		retreatdishsname.push(name);	
	}
	
	var html="<tr class='orderdish'>";
	
	if("true"==isadd){
			html+="<input type='hidden' name=adddishsList[";
			html+=adddishsname.length-1;
			html+="].rdishid value=" ;
			html+=id;
			html+=">";
			
			html+="<input type='hidden' name=adddishsList[";
			html+=adddishsname.length-1;
			html+="].echelon value=" ;
			html+=2;
			html+=">";
			
			html+="<input type='hidden' name=adddishsList[";
			html+=adddishsname.length-1;
			html+="].price class='orderdetailPrice' value=";
			html+=price;
			html+=">";
			
		//	html+="<td>";
		//	html+=id;
		//	html+="</td>";
			
			
			html+="<td class='dishname'>";
			html+=name;
			html+="</td>";
			
		//	
		//	html+="<td>";
		//	html+=price;
		//	html+="</td>";
			
			/*<td>数量</td>*/
			html+="<td class='dishnumber'>";
			html+="<input type='text' value='1' name='adddishList[";
			html+=adddishsname.length-1;
			html+="].dishnumber' class='dishnumberInput' readonly=‘readonly’ />";
			html+="</td>";
	}else{
		
			html+="<input type='hidden' name=retreatdishList[";
			html+=retreatdishsname.length-1;
			html+="].rdishid value=" ;
			html+=id;
			html+=">";
			
			html+="<input type='hidden' name=retreatdishList[";
			html+=retreatdishsname.length-1;
			html+="].echelon value=" ;
			html+=0;
			html+=">";
			
			html+="<input type='hidden' name=retreatdishList[";
			html+=retreatdishsname.length-1;
			html+="].price class='orderdetailPrice' value=";
			html+=price;
			html+=">";
			
		//	html+="<td>";
		//	html+=id;
		//	html+="</td>";
			
			
			html+="<td class='dishname'>";
			html+=name;
			html+="</td>";
			
		//	
		//	html+="<td>";
		//	html+=price;
		//	html+="</td>";
			
			/*<td>数量</td>*/
			html+="<td class='dishnumber'>";
			html+="<input type='text' value='1' name='retreatdishList[";
			html+=retreatdishsname.length-1;
			html+="].dishnumber' class='dishnumberInput' readonly=‘readonly’ />";
			html+="</td>";
	}
	
	html+="<td class='price'> ";
	html+=price;
	html+="</td>";
	
//	<td>价格</td>
	if(isadd=="true"){
		html+="<td class='addtotalprice'> ";
	}else{
		html+="<td class='reducetotalprice'> ";
	}
	html+=price;
	html+="</td>";
	
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
		$("#alldish").next().append(html);
	}else{
		$("#orderdish").next().append(html);
	}
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
	
	var dishnumber=parseInt(dishnumberObject.val())-1;
	if(dishnumber==0){
		$(self).parent().parent().remove();
		if(isadd=="true"){
			adddishsname.splice($.inArray(dishname,adddishsname),1);
		}else{
			retreatdishsname.splice($.inArray(dishname,retreatdishsname),1);
		}
		
	}
	if(isadd=="true"){
		if(adddishsMap[dishname]<dishnumber){
			dishnumber=adddishsMap[dishname];
			alert("已经减少到最低值");
		}
		if(dishnumber<0){
			adddishsMap[dishname]=0;
		}
	}else{
		if(retreatdishsMap[dishname]<dishnumber){
			dishnumber=retreatdishsMap[dishname];
			alert("已经减少到最低值");
		}
		if(dishnumber<0){
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
 * 改变指定菜品的菜品数量和总价 TODO bug
 */
function changedishToList(name,price,isadd,self){
	var jqs=$(self);
	
	var container=jqs.parent().parent().parent().parent().parent().next();
	
	var dishnameList=container.find(".dishname");
	
	$.each(dishnameList,function(key,val){
		var text=val.innerHTML;
		if(name==text){
			var currentdish=$(val);
			var currentdishnumber=currentdish.parent().find(".dishnumber").find("input");
			var currentnumber=currentdishnumber.val();
			var addnumber=parseInt(currentnumber)+1;
			if("true"==isadd){
				currentdishnumber.val(addnumber);
			}else{
				alert("add-->"+text);
				alert("adddishsMap[text]-->"+normaldishsMap[text]);
				if(addnumber>normaldishsMap[text]){
					alert("已经无法退菜了");
				}else{
					currentdishnumber.val(addnumber);
				}
			}
		}
	});
	//改变价格
	changeprice(dishnameList,isadd);
}

/**
 * 改变价格以及总价
 * @param dishnameList
 */
function changeprice(dishnameList,isadd){
	
	$.each(dishnameList,function(key,val){
		var currentdish=$(val);
		var currentdishnumber=currentdish.parent().find(".dishnumber").find("input").val();
		var currentdishprice=currentdish.parent().find(".price");
		var currentdishaddtotalprice;
		if(isadd=="true"){
			currentdishaddtotalprice=currentdish.parent().find(".addtotalprice");
		}else{
			currentdishaddtotalprice=currentdish.parent().find(".reducetotalprice");
		}
		currentdishaddtotalprice.text(parseInt(currentdishprice.text())*parseInt(currentdishnumber));
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
		allprice=allprice+parseInt(val.innerHTML);
	});
	$.each(addtotalpriceList,function(key,val){
		allprice=allprice+parseInt(val.innerHTML);
	});
	$.each(reducetotalpriceList,function(key,val){
		allprice=allprice-parseInt(val.innerHTML);
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