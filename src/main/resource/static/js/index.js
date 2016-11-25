/**
 * 
 */
jQuery(document).ready(function() {
	App.init();
	jQuery('#promo_carousel').carousel({
		interval: 10000,
		pause: 'hover'
	});
});

function change_language(value){
	var url="/setLanguage";
	var param={lang:value};
	var success=function(res){
		if(!res||!res.success){
			alert("语言切换失败！");
		}else{
			location.reload();
		}
	};
	$.post(url,param,success);
}