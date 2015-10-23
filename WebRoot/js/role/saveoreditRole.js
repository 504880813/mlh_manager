$(function(){
	$('#one1').click(function(){
		var size = $('#left>option:selected').size();
		if(size != 0){
			$('#left > option:selected').appendTo($('#right'));
		}
		else{
			$('#left>option:first-child').appendTo($('#right'));
		}
	});	
	$('#all1').click(function(){
		$('#left > option').appendTo($('#right'));
	});	
	$('#one2').click(function(){
		var size = $('#right>option:selected').size();
		if(size != 0){
			$('#right > option:selected').appendTo($('#left'));
		}
		else{
			$('#right>option:first-child').appendTo($('#left'));
		}
	});	
	$('#all2').click(function(){
		$('#right > option').appendTo($('#left'));
	});	
});

function submitForm1(){
	$('#left > option').attr('selected','selected');
	return true ;
}