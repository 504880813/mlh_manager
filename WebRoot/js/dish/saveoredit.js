
	function showDishes(){
		document.getElementById("Dishes").setAttribute("style","display:block");
		document.getElementById("Materials").setAttribute("style","display:none");
	}
	function showMaterials(){
		document.getElementById("Dishes").setAttribute("style","display:none");
		document.getElementById("Materials").setAttribute("style","display:block");
	}
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
		var arryQuantity=$(".auxiliaryDish");
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