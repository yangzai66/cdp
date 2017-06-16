     $(document).ready(function(){
     		stock_details_load();
     });
     	var stock_details_load = function(){
     	   Public.ajaxGet("/stock/view/"+$.getUrlParam("n"), null, function(msg) {
//     	   	alert(JSON.stringify(msg));
     	   })
     	}
     	 var randomScalingFactor = function() {
             return (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100);
         };
         var randomColorFactor = function() {
             return Math.round(Math.random() * 255);
         };
         var randomColor = function() {
             return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',.7)';
         };
        var barChartData = {
                labels: ["January", "February", "March", "April", "May", "June", "July"],
                datasets: [{
                    label: 'Dataset 1',
                    backgroundColor: "rgba(220,220,220,0.5)",
                    data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
                }, {
                    hidden: true,
                    label: 'Dataset 2',
                    backgroundColor: "rgba(151,187,205,0.5)",
                    data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
                }, {
                    label: 'Dataset 3',
                    backgroundColor: "rgba(151,187,205,0.5)",
                    data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
                }]

            };
        var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

       
        window.onload = function() {
            var ctx = document.getElementById("canvas").getContext("2d");
            window.myBar = new Chart(ctx, {
                type: 'bar',
                data: barChartData,
                options: {
                    // Elements options apply to all of the options unless overridden in a dataset
                    // In this case, we are setting the border of each bar to be 2px wide and green
                    elements: {
                        rectangle: {
                            borderWidth: 1,
                            borderColor: 'rgb(0, 255, 0)',
                            borderSkipped: 'bottom'
                        }
                    },
                    responsive: true,
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Chart.js Bar Chart'
                    }
                }
            });

        };