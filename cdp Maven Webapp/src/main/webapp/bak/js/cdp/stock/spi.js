$(document).ready(function(){
    	var where= " AND SPI_LXFL_3='1'";
    		load_market();
    		load_industry_plate();
    	});
    	var load_market = function(){
    		Public.ajaxPost("/market/list", {}, function(msg) {
    		$.each(msg, function(i,model){
    			var rate_css = "bz pd";
    			if(model.UPS_DOWNS_RATE>0){
    				rate_css = "bz pg";
    			}
    			$("#market_div").append('<div class="gq gf ala" ><div class="apu"><div class="alz" style="padding:0px !important;"><span class="anj">'+model.STOCK_NAME+'</span><h2 class="ani">'+model.CUR_PRICE+'<small class="'+rate_css+'" style="margin-left:8px">'+model.UPS_DOWNS_RATE+'%</small></h2></div></div></div>');
    		});
    		});
    	}
    	var load_industry_plate = function(){
    	var params = new Map();
    	params.put("order", order());
    	params.put("where", where);
    	$(".cl tbody").html("");
    	Public.ajaxPost("/stockSpi/list", params.toParamsJSON(), function(msg) {
    		var st_css="";
    		$.each(msg.data,function(i,model){
    			if(model.UPS_DOWNS_RATE<0){
    				st_css='stock_down_rate';
    	  		}else{
    	  			st_css='stock_up_rate';
    	  		}
    			$(".cl tbody").append("<tr class='"+st_css+"'><td>"+model.STOCK_NO+"</td><td>"+model.STOCK_NAME+"</td><td>"+model.SPI_RATE_3+"% / "+model.SPI_RATE_5+"%</td><td>"+model.SPI_AVG_AMPLITUDE_3+"% / "+model.SPI_AVG_AMPLITUDE_5+"%</td><td>"+model.SPI_AVG_TURNOVER_3+"% / "+model.SPI_AVG_TURNOVER_5+"%</td><td>"+model.SPI_HIGH_PRICE_3+" / "+model.SPI_HIGH_PRICE_5+"</td><td>"+model.SPI_LOW_PRICE_3+" / "+model.SPI_LOW_PRICE_5+"</td><td>"+model.UPS_DOWNS_RATE+"% / "+model.CUR_PRICE+"</td><td>"+spi_tags(model)+"</td></tr>");
    			
    		});
    	});
    	
//    		Public.ajaxPost("/plate/list", params.toParamsJSON(), function(msg) {
//    			var content = "";
//		  		$.each(msg.data,function(i,stock){
//					if(stock.UPS_DOWNS_RATE<0){
//  			content+="<tr class='stock_down_rate'>";
//  		}else{
//  			content+="<tr class='stock_up_rate'>";
//  		}
//  		content+="<td><a href='/st/view/plate/stocklist.jsp?plate_no="+stock.PLATE_NO+"'>"+stock.PLATE_NO+"</a></td><td>"+stock.PLATE_NAME+"</td><td>"+stock.UPS_DOWNS_RATE+"</td><td>"+stock.UPS_DOWNS_PRICE+"</td><td>"+stock.AVG_PRICE+"</td><td>"+stock.TRADE_NUM+"</td><td>"+stock.TRADE_MONEY+"</td></tr>";
//  		
//		  		});
//		  		$(".cl tbody").html(content);
//    		});
    	}
    	function spi_tags(v){
    		var tags = "";
    		
    		
    		if(v.SPI_LXFL_4=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>LXFL_4</small>";
    		}else{
    			if(v.SPI_LXFL_3=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>LXFL_3</small>";
        		}else{
        			if(v.SPI_LXFL_2=="1"){
            			tags+="<small class='bz pg' style='margin-left:8px'>LXFL_2</small>";
            		}
        		}
    		}
    		
    		
    		if(v.SPI_LXSZ_4=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>LXSZ_4</small>";
    		}else{
    			if(v.SPI_LXSZ_3=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>LXSZ_3</small>";
        		}else{
        			if(v.SPI_LXSZ_2=="1"){
            			tags+="<small class='bz pg' style='margin-left:8px'>LXSZ_2</small>";
            		}
        		}
    		}
    		
    		
    		if(v.SPI_LXXD_4=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>LXXD_4</small>";
    		}else{
    			if(v.SPI_LXXD_3=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>LXXD_3</small>";
        		}else{
        			if(v.SPI_LXXD_2=="1"){
            			tags+="<small class='bz pg' style='margin-left:8px'>LXXD_2</small>";
            		}
        		}
    		}
    		
    		if(v.SPI_LXJLR_3=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXJLR_3</small>";
    		}else{
    			if(v.SPI_LXJLR_2=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXJLR_2</small>";
        		}
    		}
    		
    		if(v.SPI_LXJLC_3=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXJLC_3</small>";
    		}else{
    			if(v.SPI_LXJLC_2=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXJLC_2</small>";
        		}
    		}
    		
    		if(v.SPI_LXDD_3=="1"){
    			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXJLC_3</small>";
    		}else{
    			if(v.SPI_LXDD_2=="1"){
        			tags+="<small class='bz pg' style='margin-left:8px'>SPI_LXDD_2</small>";
        		}
    		}
    		return tags;
    	}
    	function order(){
		  	var query_order="order by ";
		  	var headers=$("th[class*=header]");
			 for(var i=0;i<headers.length;i++){
			 var bb= headers.get(i);
				if(headers.get(i).className.indexOf('headerSortDown')>0){
				query_order+=headers.get(i).dataset.sort+" asc";
					 break;
				}
				if(headers.get(i).className.indexOf('headerSortUp')>0){
				query_order+=headers.get(i).dataset.sort+" desc";
					 break;
				}
			 }
			 return query_order;
  	}
    	var spi_where = function(v){
    		where = " AND " +v +"='1'";
    		load_industry_plate();
    	}