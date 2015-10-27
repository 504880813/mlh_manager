

function backOrColse(){
	if(window.history.length<=1){
		window.opener=null;
		window.open('','_self');
		window.close();
	}else{
		history.back(-1);
	}
}

