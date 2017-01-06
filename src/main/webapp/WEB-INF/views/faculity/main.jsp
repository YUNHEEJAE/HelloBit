<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>jQuery cssbipolarchart Plugin Demos</title>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.2.3/foundation.min.css">
<link rel="stylesheet" href="../resources/dist/css/cssBipolarChart.css">
<link rel="stylesheet"
	href="../resources/dist/css/skins/_all-skins.min.css">
</head>
<body>
	<div class="content-wrapper" style="min-height: 976px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			${program.pcourse} <small>${program.torder }기 - ${program.roomname }호</small>
		</h1>
		</section>

		<!-- Main content -->
		<section class="content">
		<div class="row">


			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="info-box">
					<span class="info-box-icon bg-aqua"><i
						class="ion ion-happy"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">출석한 인원</span> <span
							class="info-box-number">${check} 명</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->


			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="info-box">
					<span class="info-box-icon bg-red"><i
						class="ion ion-sad"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">지각한 인원</span> <span
							class="info-box-number">${late} 명</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->

 			<!-- fix for small devices only --> 
<!-- 			<div class="clearfix visible-sm-block"></div> -->

			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="info-box">
					<span class="info-box-icon bg-green"><i
						class="ion ion-bowtie"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">결석한 인원</span> <span
							class="info-box-number">${absent} 명</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->


			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="info-box">
					<span class="info-box-icon bg-yellow"><i
						class="ion ion-person-stalker"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">총인원</span> <span
							class="info-box-number">${total} 명</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->

		</div>
		<br>

<!-- 		<div class="row row-eq-height"> -->
		<div class="col-md-6">
			<!-- BAR CHART -->
			<div class="box box-success">
				<div class="box-header with-border">
					<h3 class="box-title">
						<b>이번주 출석 현황</b>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn btn-box-tool"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<div class="box-body">
					<div class="chart">
						<canvas id="barChart" style="height:230px"></canvas>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
			
				 <!-- DONUT CHART -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title"><b>기분 도너츠</b></h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body">
              <canvas id="pieChart" style="height:250px"></canvas>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
			
		
		</div>

		<div class="col-md-6">
		
			
			<!-- Table -->
			<div class="box box-danger">
				<div class="box-header with-border">
					<h3 class="box-title">
					<b>지각자 명단</b>
					</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table class="table table-bordered">

						<tr>
							<th style="width: 40px"><small>순위</small></th>
							<th>이름</th>
							<th>지각률 %</th>
							<th style="width: 40px"><small>횟수</small></th>
						</tr>

						<c:forEach items="${lateManList }" var="checkLateManVO"
							varStatus="i">

							<tr>
								<td>${i.count }.</td>
								<td>${checkLateManVO.sid}</td>
								<td>
									<div class="progress progress-xs progress-striped">
										<div
											class="progress-bar progress-bar-${i.count == 1 ? 'danger' : 'warning' }"
											style="width: ${checkLateManVO.delaycnt / attendanceCnt * 100}%"></div>
									</div>
								</td>
								<td><span
									class="badge bg-${i.count == 1 ? 'red' : 'yellow' }">${checkLateManVO.delaycnt}</span></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- /.box-body -->

			</div>
			
		<div class="box box-default color-palette-box">
        <div class="box-header with-border">
          <h3 class="box-title"><b>수강생 출석 로그</b></h3>
        </div>
        <div class="box-body">
          <div class="row">
          
			<div id="chatMessage" style="width:200px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;"></div>
					
          </div>
          <!-- /.row -->
          <div class="row">

          </div>
          <!-- /.row -->
        </div>
        <!-- /.box-body -->
      </div>
			
		
			
			

		</div>
<!-- 		</div> -->
		</section>
	</div>

</body>

<%@include file="footer.jsp"%>
<!-- ChartJS 1.0.1 -->
<script src="../resources/plugins/chartjs/Chart.min.js"></script>
<!-- FastClick -->
<script src="../resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../resources/dist/js/demo.js"></script>
<script src="../resources/js/sockjs-1.1.1.min.js"></script>
<!-- page script -->
<script>
$(document).ready(function() {
	
	
	
	
	$("#faculity_1").attr("class", "active");
	$("#pno_37").attr("class", "active");

	
	sock = new SockJS("/web/logWebsocket");
	sock.onopen = function(event) {
			console.log(event);
			
			sock.onmessage = function(event) {
				console.log(event.data);
				$("#chatMessage").after(event.data+"<br>");
			};
	};
	// This will get the first returned node in the jQuery collection.
	var areaChartData = null;

	$.getJSON("/web/check/checkWeek/${param.pno}", function(data) {
		console.log(data);

		areaChartData = {
			labels : [ "Mon", "Tue", "Wed", "Thu", "Fri"],
			datasets : [ {
				label : "출석한 인원",
				fillColor : "rgba(60,141,188,0.9)",
				strokeColor : "rgba(60,141,188,0.8)",
				pointColor : "#3b8bba",
				pointStrokeColor : "rgba(60,141,188,1)",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(60,141,188,1)",
				data : [ data.mon, data.tue, data.wed,
						data.thu, data.fri ]
			} ]
		};

		//-------------
		//- BAR CHART -
		//-------------
		var barChartCanvas = $("#barChart").get(0).getContext("2d");
		var barChart = new Chart(barChartCanvas);
		var barChartData = areaChartData;
		barChartData.datasets[0].fillColor = "#00a65a";
		barChartData.datasets[0].strokeColor = "#00a65a";
		barChartData.datasets[0].pointColor = "#00a65a";
		var barChartOptions = {
			//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
			scaleBeginAtZero : true,
			//Boolean - Whether grid lines are shown across the chart
			scaleShowGridLines : true,
			//String - Colour of the grid lines
			scaleGridLineColor : "rgba(0,0,0,.05)",
			//Number - Width of the grid lines
			scaleGridLineWidth : 1,
			//Boolean - Whether to show horizontal lines (except X axis)
			scaleShowHorizontalLines : true,
			//Boolean - Whether to show vertical lines (except Y axis)
			scaleShowVerticalLines : true,
			//Boolean - If there is a stroke on each bar
			barShowStroke : true,
			//Number - Pixel width of the bar stroke
			barStrokeWidth : 2,
			//Number - Spacing between each of the X value sets
			barValueSpacing : 30,
			//Number - Spacing between data sets within X values
			barDatasetSpacing : 1,
			//String - A legend template
			//Boolean - whether to make the chart responsive
			responsive : true,
			maintainAspectRatio : true
		};

		barChartOptions.datasetFill = false;
		barChart.Bar(barChartData, barChartOptions);

	});
	
	//-------------
    //- PIE CHART -
    //-------------
    // Get context with jQuery - using jQuery's .get() method.
    var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
    var pieChart = new Chart(pieChartCanvas);
    //  String[] keys = { "happiness", "neutral", "sadness", "anger", "fear","surprise"};
    var pieColor = ["#f56954","#00a65a","#f39c12","#00c0ef","#3c8dbc","#d2d6de"];
//     var pieColor = ["#00c0ef", "#d2d6de","#f39c12","#f56954","#00a65a","#3c8dbc"];
// sad anger fear = red, surprise, 
    var PieData = [
		{ value: ${emotionList["anger"]}, 		color: "#f56954", highlight: "#f56954", label: "화나요" },
		{ value: ${emotionList["happiness"]}, 	color: "#3c8dbc", highlight: "#3c8dbc", label: "행복해요" },
		{ value: ${emotionList["neutral"]}, 	color: "#d2d6de", highlight: "#d2d6de", label: "편안해요" },
		{ value: ${emotionList["sadness"]}, 	color: "#f39c12", highlight: "#f39c12", label: "슬퍼요" },
		{ value: ${emotionList["surprise"]}, 	color: "#00a65a", highlight: "#00a65a", label: "놀라워요" },
		{ value: ${emotionList["fear"]}, 		color: "#00c0ef", highlight: "#00c0ef", label: "두려워요" }
    ];
    var pieOptions = {
      //Boolean - Whether we should show a stroke on each segment
      segmentShowStroke: true,
      //String - The colour of each segment stroke
      segmentStrokeColor: "#fff",
      //Number - The width of each segment stroke
      segmentStrokeWidth: 2,
      //Number - The percentage of the chart that we cut out of the middle
      percentageInnerCutout: 50, // This is 0 for Pie charts
      //Number - Amount of animation steps
      animationSteps: 100,
      //String - Animation easing effect
      animationEasing: "easeOutBounce",
      //Boolean - Whether we animate the rotation of the Doughnut
      animateRotate: true,
      //Boolean - Whether we animate scaling the Doughnut from the centre
      animateScale: false,
      //Boolean - whether to make the chart responsive to window resizing
      responsive: true,
      // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
      maintainAspectRatio: true
      //String - A legend template
    };
    //Create pie or douhnut chart
    // You can switch between pie and douhnut using the method below.
    pieChart.Doughnut(PieData, pieOptions);
	
	

});
</script>



</html>
