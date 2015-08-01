
//初始化
//$(function () {
//	//input[name=dishnumber]
//	$(".dishnumberInput").change(function() {
//		alert("aabb");
//		var s=$(this).val();
//		alert(s);
//	});
//	$(".dishnumberInput")[0].onchange
////	alert($(".dishnumberInput").val());
//});



var orderdishsId= new Array();
/**
 * 将菜品列表的菜品加入订单菜品列表，并且在菜品列表删除该菜品
 * @param id
 * @param name
 * @param price
 */
function adddishToorder(id,name,price,self){
	orderdishsId.push(id);
	var jqs=$(self);
	jqs.parent().parent().remove();
	var html="<tr>";
	
	html+="<input type='hidden' name=orderdetailList[";
	html+=orderdishsId.length-1;
	html+="].rdishid value=" ;
	html+=id;
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
	html+="')>";
	html+="</td>";
	html+="</tr>";
//	alert(html);
	$("#orderdishs table:first").append(html);
	$("input[name=submit]").show();
	
	changeAllprice();
}
/**
 * 删除指定元素,将删除的元素添加到菜单列表
 */
function deletethisself(self,id,name,price){
	//alert(self);
	var jqs=$(self);
	jqs.parent().parent().remove();
	adddishsofhtml(id,name,price);
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
			adddishsfromAJaxBycategory(json);
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
//			alert("succes");
			adddishsfromAJaxBycategory(json);
		},
		error : function(data) {  
			$("#categorydishs table:first").append("请求失败");
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
	    if(!ArrayContain(orderdishsId,id)){
	    	adddishsofhtml(id,name,price);
	    }
	});
}
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
 * 向菜品模块的添加html
 */
function adddishsofhtml(id,name,price){
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
	html+="<td>";
	html+="<input type='button' value='add' onclick=";
	html+="adddishToorder";
	html+="('" +id;
	html+="','" +name;
	html+="','" +price;
	html+="',this)>";
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
		var tempInt=parseInt($(this).val());
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








