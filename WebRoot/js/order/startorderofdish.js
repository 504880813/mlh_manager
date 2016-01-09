
//初始化

var orderdishsId= new Array();

//当前类型id 如果是查询所有，则为-1
var currentFindTypeId=-1;

/**
 * 
 * @param id 过时
 * @param name
 * @param price
 * @param self

 */
function adddishToorderOfsetMeal(id,name,price,self,Rootpath,TypeId){
//		finddishBysetMealId(Rootpath,id);
//		if(!ArrayContain(orderdishsId,id)){
		adddishToorder(id,name,price,self,Rootpath,TypeId);
		changePriceBydishId(id,1);
}


/**
 * 将菜品列表的菜品加入订单菜品列表，并且在菜品列表删除该菜品
 * @param id
 * @param name
 * @param price
 */
function adddishToorder(id,name,price,self,Rootpath,TypeId){
	
	orderdishsId.push(id);
	var jqs=$(self);
	
	jqs.parent().parent().remove();
	
	var html="<tr>";
	
	html+="<input type='hidden' name=orderdetailList[";
	html+=orderdishsId.length-1;
	html+="].rdishname value=" ;
	html+=name;
	html+=">";
	
	html+="<input type='hidden' name=orderdetailList[";
	html+=orderdishsId.length-1;
	html+="].price class='orderdetailPrice' value=";
	html+=price;
	html+=">";
	
	html+="<td>";
	html+=id;
	html+="</td>";
	
	
	html+="<td>";
	html+=name;
	html+="</td>";
	
	
	html+="<td>";
	html+=price;
	html+="</td>";
	
	/*<td>数量</td>*/
	html+="<td>";
	html+="<input type='text' value='1' name='orderdetailList[";
	html+=orderdishsId.length-1;
	html+="].dishnumber' class='dishnumberInput' onchange='dishNumberchange(this)' />";
	html+="</td>";
	
//	<td>价格</td>
	html+="<td>";
	html+="<p>" ;
	html+=price;
	html+="</p>";
	
	html+="</td>";
//	<td>操作</td>
	html+="<td>";
	html+="<input type='button' value='delete' onclick=";
	html+="deletethisself";
	html+="(this";
	html+=",'" +id;
	html+="','" +name;
	html+="','" +price;
	html+="','" +Rootpath;
	html+="','" +TypeId;
	html+="')>";
	html+="</td>";
	html+="</tr>";
//	alert(html);
	$("#orderdishs").append(html);
	
	$("input[name=submit]").show();
	
	changeAllprice();
}
/**
 * 删除指定元素,将删除的元素添加到菜单列表
 */
function deletethisself(self,id,name,price,RootPath,TypeId){
	//alert(self);
	var jqs=$(self);
	jqs.parent().parent().remove();
	if(TypeId==currentFindTypeId || currentFindTypeId==-1){
		adddishsofhtml(id,name,price,RootPath,TypeId);
	}
	for(var i=0;i<orderdishsId.length;i++){
		if(orderdishsId[i]==id){
			Arrayremove(orderdishsId,i);
			break;
		}
	}
	if(orderdishsId.length<=0){
		$("input[name=submit]").hide();
	}
	
	changeAllprice();
}
/**
 * 利用ajax根据分类查询菜品
 */
function finddishBycategory(Rootpath,id){
	$("#categorydishs table:first tr:not(tr:first)").remove();
	$.ajax({ //一个Ajax过程 
		type: "post", //以post方式与后台沟通 
		url : Rootpath+"/dish/findDishsByTypeRetrunJson.action", 
		dataType:'json', 
		data: 'categoryId='+id, 
		success: function(json){//如果调用成功 
//			alert("succes");
			currentFindTypeId=id;
			adddishsfromAJaxBycategory(json,Rootpath,id);
		},
		error : function(data) {  
			$("#categorydishs table:first").append("请求失败");
		}  
	}); 
}
/**
 * 利用ajax查询所有菜品
 */
function finddishs(Rootpath){
	$("#categorydishs table:first tr:not(tr:first)").remove();
	$.ajax({ //一个Ajax过程 
		type: "post", //以post方式与后台沟通 
		url : Rootpath+"/dish/findAllDishRetrunJson.action", 
		dataType:'json', 
		success: function(json){//如果调用成功 
			currentFindTypeId=-1;
			adddishsfromAJaxBycategory(json,Rootpath,-1);
		},
		error : function(data) {  
			$("#categorydishs table:first").append("请求失败");
		}  
	}); 
}
/**
 * 根据套餐id查询套餐下的单菜，并返回json数组 （过时）
 * @param Rootpath
 * @param id
 */
/*function finddishBysetMealId(Rootpath,id){
	$.ajax({ //一个Ajax过程 
		type: "post", //以post方式与后台沟通 
		url : Rootpath+"/dish/finddishBysetMealIdRetrunJson.action", 
		dataType:'json', 
		data: 'setMealId='+id, 
		success: function(json){//如果调用成功 
			 adddishsfromAJaxBysetMeal(json,Rootpath);
		},
		error : function(data) {  
			$("#categorydishs table:first").html("请求失败");
		}  
	}); 
}*/
/**
 * 将查询到的菜品信息，放入菜品模块页面中
 * 
 */
function adddishsfromAJaxBycategory(json,Rootpath,TypeId){
	$.each(json, function(key, val) { 
		var id=val.id;
	   	var name=val.name;
	    var price=val.price;
	    if(!ArrayContain(orderdishsId,id)){
	    	if(TypeId==-1){
	    		var categoryid=val.rcategoryid;
	    		adddishsofhtml(id,name,price,Rootpath,categoryid);
	    	}else{
	    		adddishsofhtml(id,name,price,Rootpath,TypeId);
	    	}
	    	
	    }
	});
}
/**
 * 根据分类添加菜品 (过时)
 */
/*function adddishsfromAJaxBysetMeal(json,Rootpath){
	$.each(json.sub_customdish,function(key, val){
		var id=json.sub_customdish[key].id;
		var name=json.sub_customdish[key].name;
		var price=json.sub_customdish[key].price;
		var quantity=json.sub_customdish[key].sub_customdish_quantity;
		
		if(!ArrayContain(orderdishsId,id)){
			adddishsofhtml(id,name,price,Rootpath);
		}
		  changePriceBydishId(id,quantity);
	});
}*/
/**
 * 相应菜品数量变化时事件
 * @param source
 */
function dishNumberchange(source){
	var jqs=$(source);
	
	//TODO  验证是否为数字
	var dishNumber=jqs.val();
//	alert(dishNumber);
	//改变显示价格
	var price=jqs.parent().prev().text();
	var allprice=dishNumber*price;
	jqs.parent().next().find("p").text(allprice);
	//改变提交价格
	jqs.parent().parent().find(".orderdetailPrice").val(allprice);
	
	changeAllprice();
}
/**
 * 改变指定菜品的数量
 * @param id
 */
function changePriceBydishId(id,quantity){
	var index=$("tr").parent("tr").find(".dishName").text();
//	alert(orderdishsId.length-1);
	var oldquantity=$("input[name='orderdetailList["+index+"].dishnumber']").val();
	if(oldquantity==1){
		$("input[name='orderdetailList["+index+"].dishnumber']").val(quantity);
	}else{
		var newquantity=parseFloat(oldquantity)+parseFloat(quantity);
		$("input[name='orderdetailList["+index+"].dishnumber']").val(newquantity);
	}
	//改变价格
	dishNumberchange($("input[name='orderdetailList["+index+"].dishnumber']"));
}

/**
 * 向菜品模块的添加html
 */
function adddishsofhtml(id,name,price,RootPath,TypeId){
	var html="<tr>";
	html+="<td>";
	html+=id;
	html+="</td>";
	html+="<td>";
	html+=name;
	html+="</td>";
	html+="<td>";
	html+=price;
	html+="</td>";
//	<td>操作</td>
	html+="<td colspan='2'>";
	html+="<input type='button' value='add' onclick=";
	html+="adddishToorder";
	html+="('" +id;
	html+="','" +name;
	html+="','" +price;
	html+="',this,'"; 
	html+=RootPath;
	html+="','";
	html+=TypeId;
	html+="')>";
	
	var url=RootPath+"/dish/findDishdetails.action";
	
	html+="<input type='button' value='查看详情' onclick=";
	html+="OpenDishDetails";
	html+="('"+url;
	html+="','"+id;
	html+="') >";
	
	
	html+="</td>";
	html+="</tr>";
	
	$("#categorydishs table:first").append(html);
}



/**
 * 改变订单总价
 */
function changeAllprice(){
	var sum=0;
	$(".orderdetailPrice").each(function(){
		var tempInt=parseFloat($(this).val());
		sum+=tempInt;
//	    alert($(this).val());
	 });
	$("#allprice").text(sum);
	$("input[name=price]").val(sum);
}


/**
 * 将数组中指定下标元素移除
 * @param array
 * @param index
 */
function Arrayremove(array,index){
      array=array.splice(index,1);
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

function OpenDishDetails(url,id){
	var keys=new Array();
	var values=new Array();
	keys[0]="id";
	values[0]=id;
	
	openWindowWithPost(url, "testOpen", keys, values);

}
function openWindowWithPost(url, name, keys, values) {
    var newWindow = window.open(url, name);
    if (!newWindow){
        return false;
    }
    
    var html = "";
    html += "<html><head></head><body><form id='formid' method='post' action='"    + url + "'>";
    if (keys && values && (keys.length == values.length)){
        for ( var i = 0; i < keys.length; i++){
            html += "<input type='hidden' name='" + keys[i] + "' value='" + values[i] + "'/>";
        }
    }
    html += "</form><script type='text/javascript'>document.getElementById(\"formid\").submit()</script></body></html>";
    newWindow.document.write(html);
    return newWindow;
}








