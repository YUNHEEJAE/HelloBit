<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>


<div class="content-wrapper" style="min-height: 943px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			ChartJS <small>Preview sample</small>
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
			<div class="col-md-6">
				<!-- AREA CHART -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">Area Chart</h3>

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
							<canvas id="areaChart" style="height: 189px; width: 263px;"
								height="189" width="263"></canvas>
						</div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->

				<!-- DONUT CHART -->
				<div class="box box-danger">
					<div class="box-header with-border">
						<h3 class="box-title">Donut Chart</h3>

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
						<canvas id="pieChart" style="height: 131px; width: 263px;"
							height="131" width="263"></canvas>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->

			</div>
			<!-- /.col (LEFT) -->
			<div class="col-md-6">
				<!-- LINE CHART -->
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">Line Chart</h3>

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
							<canvas id="lineChart" style="height: 189px; width: 263px;"></canvas>
						</div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->

				<!-- BAR CHART -->
				<div class="box box-success">
					<div class="box-header with-border">
						<h3 class="box-title">Bar Chart</h3>

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
							<canvas id="barChart" height="174" width="263"></canvas>
						</div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
			<!-- /.col (RIGHT) -->
		</div>
		<!-- /.row -->
		<!-- 달력 TEST 부분 -->
		<div class="box box-primary">
			<div class="box-body no-padding">

				<div id="calendar" class="fc fc-ltr fc-unthemed"></div>
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>
<script src="../resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="../resources/plugins/chartjs/Chart.min.js"></script>
<script src="../resources/plugins/util/utils.js"></script>


<script>
	//BAR CHART//
	var barChart = null;
	var barChartData = {
		labels : [ "Mon", "Tue", "Wed", "Thu", "Fri" ],
		datasets : [ {
			//색 채우기
			fillColor : "rgba(215, 40, 40, 0.9)",
			//차트 테두리 색
			strokeColor : "rgba(220,220,220,0.8)",
			//커서 올렸을 때 색깔
			highlightFill : "rgba(215, 40, 40, 0.9)",
			//커서 올렸을 때 테두리 색깔
			highlightStroke : "rgba(220,220,220,1)",
			//값
			data : [ 40, 30, 50, 70, 20 ]
		}, {
			fillColor : "rgba(151,187,205,0.5)",
			strokeColor : "rgba(151,187,205,0.8)",
			highlightFill : "rgba(151,187,205,0.75)",
			highlightStroke : "rgba(151,187,205,1)",
			data : [ 20, 20, 20, 20, 20 ]
		} ]
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
			scaleGridLineColor : "rgba(0,0,0,0.3)",
			// 눈금 선 굵기
			scaleGridLineWidth : 1,
			//막대 테두리 보여줄거야?
			barShowStroke : false,
			//막대 너비
			barStrokeWidth : 1,
			//x축 간격...인데 이거 조정하면 바 너비가 바뀜
			barValueSpacing : 5,
			//막대들 간의 간격
			barDatasetSpacing : 10,
			responsive : true,
			onAnimationProgress : function() {
				console.log("onAnimationProgress");
			},
			onAnimationComplete : function() {
				console.log("onAnimationComplete");
			}
		});
	});

	//PIE CHART//
</script>


<%@include file="footer.jsp"%>
