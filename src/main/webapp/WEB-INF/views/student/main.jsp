<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<body>
	<div class="content-wrapper" style="min-height: 943px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				My Page <small>Preview sample</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="#">Charts</a></li>
				<li class="active">ChartJS</li>
			</ol>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="row row-eq-height">
						<div class="col-md-3">
							<div class="box box-primary ">
								<div class="box-body box-profile" style="text-align: center;">
									<div class="profileStudent">
										<img id="profileImg" class="img-responsive"
											src="http://pds26.egloos.com/pds/201212/24/34/a0085634_50d858d263333.jpg">

										<div class="studentInfo">
											<h3 class="profile-username text-center">${studentVO.sname }</h3>
											<p class="text-muted">${studentVO.semail}</p>
										</div>
										<p>수강중인 강의</p>
										<p>${programVO.pcourse }</p>
									</div>
								</div>
							</div>
						</div>
						<!-- 				<div class="col-md-9"> -->
						<!-- 					<div class="row"> -->
						<div class="col-md-3 checkedBoxOuter">
							<div class="box box-success checkedBox">
								<div class="box-header with-border">
									<h3 class="box-title" style="font-size: 20px">Attend</h3>
								</div>
								<div class="checkedBoxBody">
									<div class="box-body"
										style="color: #00A65A; font-weight: 700; font-size: 90px; text-align: center; vertical-align: middle;">${CheckDateVO.attend}</div>
								</div>
							</div>
						</div>
						<div class="col-md-3 checkedBoxOuter">
							<div class="box box-warning checkedBox">
								<div class="box-header with-border">
									<h3 class="box-title" style="font-size: 20px">Late</h3>
								</div>
								<div class="checkedBoxBody">
									<div class="box-body"
										style="color: #F39C12; font-weight: 700; font-size: 90px; text-align: center; vertical-align: middle;">
										${CheckDateVO.late}</div>
								</div>
							</div>
						</div>
						<div class="col-md-3 checkedBoxOuter">
							<div class="box box-danger checkedBox ">
								<div class="box-header with-border">
									<h3 class="box-title" style="font-size: 20px">Absent</h3>
								</div>
								<div class="checkedBoxBody">
									<div class="box-body "
										style="color: #DD4B39; font-weight: 700; font-size: 90px; text-align: center; vertical-align: middle;">
										${CheckDateVO.absent}</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row row-eq-height">
						<div class="col-md-6 checkedBoxOuter">
							<div class="box box-default checkedBox">
								<div class="box-body no-padding chartContent">
									<canvas id="barChart" width="90%" height="70%"></canvas>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="box box-default">
								<div class="box-body no-padding" style="">
									<div id="calendar" class="fc fc-ltr fc-unthemed"></div>
								</div>
							</div>
						</div>
						<!-- 					</div> -->
						<!-- 				</div> -->
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
<%@include file="footer.jsp"%>
<script>
	//BAR CHART//
	// 	var barChart = null;
	// 	var ctx = document.getElementById("barChart").getContext("2d");
	// 	var barChartData = {
	// 		type : 'bar',
	// 		data : {
	// 			labels : [ "1", "2", "3", "4", "5" ],
	// 			datasets : [ {
	// 				label : 'test',
	// 				data : [ 40, 30, 50, 70, 20 ],
	// 				fillColor : "rgba(215, 40, 40, 0.9)",
	// 				strokeColor : "rgba(220,220,220,0.8)",
	// 				highlightFill : "rgba(215, 40, 40, 0.9)",
	// 				highlightStroke : "rgba(220,220,220,1)"
	// 			} ]
	// 		},
	// 		options : {
	// 			scales : {
	// 				yAxes : [{
	// 					display : true,
	// 					ticks : {
	// 						beginAtZero : true,
	// 						steps : 10,
	// 						stepValue : 5,
	// 						max : 100
	// 					}
	// 				}]
	// 			}
	// 		}
	// 	}
	// 	varChart = new Chart(ctx, barChartData);

	var barChart = null;
	var barChartData = {
		labels : [ "Mon", "Tue", "Wed", "Thu", "Fri" ],
		datasets : [ {
			//색 채우기
			fillColor : "rgba(0, 166, 90, 0.8)",
			//차트 테두리 색
			strokeColor : "rgba(220,220,220,0.8)",
			//커서 올렸을 때 색깔
			highlightFill : "rgba(0, 166, 90, 1.0)",
			//커서 올렸을 때 테두리 색깔
			highlightStroke : "rgba(220,220,220,1)",
			//값
			data : [ 40, 30, 50, 70, 20 ]
		}

		// 		,{
		// 			fillColor : "rgba(151,187,205,0.5)",
		// 			strokeColor : "rgba(151,187,205,0.8)",
		// 			highlightFill : "rgba(151,187,205,0.75)",
		// 			highlightStroke : "rgba(151,187,205,1)",
		// 			data : [ 20, 20, 20, 20, 20 ]
		// 		} 
		]
	};

	$(function() {
		//canvas를 2d용으로 사용하겠다.
		var ctx = document.getElementById("barChart").getContext("2d");
		barChart = new Chart(ctx).Bar(barChartData, {
			//차트 x축 시작 값을 0으로 할래?
			scaleBeginAtZero : true,
			//차트 눈금 표시 할래?
			scaleShowGridLines : true,
			//눈금 색깔 뭐로 할래?
			scaleGridLineColor : "rgba(0,0,0,0.1)",
			// 눈금 선 굵기
			scaleGridLineWidth : 1,
			//막대 테두리 보여줄거야?
			barShowStroke : false,
			//막대 너비
			barStrokeWidth : 1,
			//x축 간격...인데 이거 조정하면 바 너비가 바뀜
			barValueSpacing : 20,
			//막대들 간의 간격
			barDatasetSpacing : 10,
			responsive : true,
			onAnimationProgress : function() {
				console.log("onAnimationProgress");
			},
			onAnimationComplete : function() {
				console.log("onAnimationComplete");
			},
			scaleOverride : true,
			scaleSteps : 10,
			scaleStepWidth : 10,
			scaleStartValue : 0,
			maintainAspectRatio : true,

		});
	});
</script>