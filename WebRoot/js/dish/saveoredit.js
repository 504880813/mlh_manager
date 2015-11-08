

//初始化
$(function(){
	$("#dishdataForm").validate({
	   rules: {
		   name:{
			   required:true
		   },
		   price:{
			   required:true,
			   number:true
		   },
		   rcategoryid:{
			   required:true
		   }
	  },
	   messages: {
		   name:{
			   required:"请录入菜品名",
		   },
		   price:{
			   required:"请录入价格",
			   number:"价格只能是数字"
		   },
		   rcategoryid:{
			   required:"请选择菜品分类",
		   }
	  }
	 });
});

	/**
	 * 显示所有菜品
	
	function showDishes(){
		document.getElementById("Dishes").setAttribute("style","display:block");
		document.getElementById("Materials").setAttribute("style","display:none");
	}
	/**
	 * 显示所有原料
	 
	function showMaterials(){
		document.getElementById("Dishes").setAttribute("style","display:none");
		document.getElementById("Maeterials").setAttribute("style","display:block");
	}
	 */
	/**
	 * 显示菜品和菜品数量
	 * @param dishes
	 * @param dishQuantitys
	 */
	function showDishes(dishes,dishQuantitys){
		
		var Quantitys= new Array();
		if(dishQuantitys.indexOf(",") > 0){
			Quantitys=dishQuantitys.split(",");
		}else{
			Quantitys.push(dishQuantitys);
		}
		var ids= new Array();
		if(dishes.indexOf(",") > 0){
			ids=dishes.split(",");
		}else{
			ids.push(dishes);
		}
		
		var arryid=$(".auxiliaryDish");
		var arryQuantity=$(".subDishQuantity");
		for(var k=0;k<arryid.length;k++){
			for(var i=0;i<ids.length;i++){
				if(arryid[k].value==ids[i]){
					arryid[k].setAttribute("checked","checked");
					arryQuantity[k].setAttribute("value",Quantitys[i]);
				}
			}
		}
		
		document.getElementById("Dishes").setAttribute("style","display:block");
		document.getElementById("Materials").setAttribute("style","display:none");
	}
	/**
	 * 显示分类和分类数量
	 * @param materialsIds
	 * @param MaterialsQuantitys
	 */
	function showMaterials(materialsIds,MaterialsQuantitys){
		var Quantitys= new Array();
		if(MaterialsQuantitys.indexOf(",") > 0){
			Quantitys=MaterialsQuantitys.split(",");
		}else{
			Quantitys.push(MaterialsQuantitys);
		}
		var ids= new Array();
		if(MaterialsQuantitys.indexOf(",") > 0){
			ids=materialsIds.split(",");
		}else{
			ids.push(materialsIds);
		}
		
		var arryid=$(".MaterialsId");
		var arryQuantity=$(".MaterialsQuantity");
		for(var k=0;k<arryid.length;k++){
			for(var i=0;i<ids.length;i++){
				if(arryid[k].value==ids[i]){
					arryid[k].setAttribute("checked","checked");
					arryQuantity[k].setAttribute("value",Quantitys[i]);
				}
			}
		} 
		document.getElementById("Dishes").setAttribute("style","display:none");
		document.getElementById("Materials").setAttribute("style","display:block");
	}
	/**
	 * 根据节点ID克隆节点，并放到指定父节点下
	 * @param Nodeid
	 * @param parentNodeid
	 */
	function CloneNodeByid(Nodeid,parentNodeid){
		//将克隆 的元素添加到父节点
		$("#"+parentNodeid).append($("#"+Nodeid).clone());
		$("#"+parentNodeid).append("<br>");
	}
	/**
	 * 根据节点名称删除最后一个节点，以及节点下方的<br>
	 * @param NodeName
	 * 
	 */
	function removeNodeByid(NodeName){
		var selectd="input[name="+NodeName+"]:last";
		var rootselectd="input[name="+NodeName+"]";
		if($(rootselectd).length!=1){
			$(selectd).next("br").remove();
			$(selectd).remove();
		}else{
			alert("至少需要一张图片");
		}
//		$("#"+Nodeid+":last").next().remove();
//		$("#"+Nodeid+":last").remove();
//		$("#"+Nodeid).parent().remove("br:last");
	}
	
	
	