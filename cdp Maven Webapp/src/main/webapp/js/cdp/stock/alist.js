var stock_order = "UPS_DOWNS_RATE DESC";
$(document).ready(function(){
	load_data(1);
	$("#stock_list thead th").click(function(){
		var curr_css = $(this).attr("class");
		$("th").removeClass();
		if(curr_css==null || curr_css=='undefined' || curr_css==""){
			$(this).attr("class","sorting_desc");
		}else if(curr_css.indexOf("desc")>0){
			$(this).attr("class","sorting_asc");
			stock_order=this.dataset.sort+ " ASC";
		}else{
			$(this).attr("class","sorting_desc");
			stock_order=this.dataset.sort +" DESC";
		}
		load_data(1);
//		alert(this.dataset.sort);
//		alert($(this).attr("class"));
	});
	
});

function load_data(page_no){
	if(page_no==null || page_no=='undefined' || page_no==""){
		page_no=1;
	}
	var params = new Map();
	params.put("order", "ORDER BY "+stock_order);
	params.put("page_no", page_no);
	params.put("page_size", 30);
	$("#stock_list tbody").html("");
	Public.ajaxPost("/stock/list", params.toParamsJSON(), function(msg) {
//		alert(JSON.stringify(msg))
		var st_css="";
		$.each(msg.data,function(i,model){
//			$("#stock_list tbody").add(r, i)
//alert(model.i);
			if(model.UPS_DOWNS_RATE<0){
				st_css='stock_down_rate';
	  		}else{
	  			st_css='stock_up_rate';
	  		}
			$("#stock_list tbody").append("<tr class="+st_css+"><td>"+model.STOCK_NO+"</td><td>"+model.STOCK_NAME+"</td><td>"+model.UPS_DOWNS_RATE+"%</td><td>"+model.UPS_DOWNS_PRICE+"</td><td>"+model.CUR_PRICE+"</td><td>"+model.HIGH_PRICE+"</td><td>"+model.LOW_PRICE+"</td><td>"+model.FUND_MAIN_PURE+"</td></tr>");
			
		});
		var options = {
				currentPage: msg.page_no,
				totalPages: msg.count,
				numberOfPages:5,
				onPageClicked:function(event,originalEvent,type,page){
					load_data(page);
				}
		}
		$('#page_div').bootstrapPaginator(options);
	})
}