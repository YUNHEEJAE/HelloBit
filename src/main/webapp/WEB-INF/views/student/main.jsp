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
				My Page <small>개인페이지입니다.</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="main"><i class="fa fa-dashboard"></i> Home</a></li>
			
			</ol>
		</section>
		<!-- Main content -->
		<section class="content">
		<input type ='hidden' id ='firesid' value = '${studentVO.sid}'>
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="row row-eq-height">
						<div class="col-md-3">
							<div class="box box-primary ">
								<div class="box-body box-profile" style="text-align: center;">
									<div class="profileStudent">
										<img id="profileImg" class="img-responsive" src="http://pds26.egloos.com/pds/201212/24/34/a0085634_50d858d263333.jpg">
												
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
									<h3 class="box-title" style="font-size: 20px;color: #00A65A;">출 석</h3>
								</div>
								<div class="checkedBoxBody">
									<div class="box-body"
										style="color: #00A65A; font-weight: 700; font-size: 90px; text-align: center; vertical-align: middle;">${CheckDateVO.attend}</div>
								</div>
								<p style="color: #00A65A; font-size: 20px; text-align: center; vertical-align: middle;">
										오예~!</p>
							</div>
						</div>
						<div class="col-md-3 checkedBoxOuter">
							<div class="box box-warning checkedBox">
								<div class="box-header with-border">
									<h3 class="box-title" style="font-size: 20px;color: #F39C12;">지 각</h3>
								</div>
								<div class="checkedBoxBody">
									<div class="box-body"
										style="color: #F39C12; font-weight: 700; font-size: 90px; text-align: center; vertical-align: middle;">
										${CheckDateVO.late}</div>
										
								</div>
								<p style="color: #F39C12; font-size: 20px; text-align: center; vertical-align: middle;">
										헐레벌떡!</p>
							</div>
						</div>
						<div class="col-md-3 checkedBoxOuter">
							<div class="box box-danger checkedBox ">
								<div class="box-header with-border">
									<h3 class="box-title" style="font-size: 20px;color: #DD4B39">결 석</h3>
								</div>
								<div class="checkedBoxBody">
									<div class="box-body "
										style="color: #DD4B39; font-weight: 700; font-size: 90px; text-align: center; vertical-align: middle;">
										${CheckDateVO.absent}</div>
								</div>
								<p style="color: #DD4B39; font-size: 20px; text-align: center; vertical-align: middle;">
										피치 못할 사정이...</p>
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
  <script src="https://www.gstatic.com/firebasejs/3.6.2/firebase.js"></script>
<script>
$(document).ready(function () {
	
	var config = {
	        apiKey: "AIzaSyD8Qs39vkxQw8pdWiXlkcMug3PL1YJeS0Q",
	        authDomain: "hhkbex.firebaseapp.com",
	        databaseURL: "https://hhkbex.firebaseio.com",
	        storageBucket: "hhkbex.appspot.com",
	        messagingSenderId: "1050382686499"
	    };
	    firebase.initializeApp(config);
	
	    
	    // Get a reference to the storage service, which is used to create references in your storage bucket
	    var storage = firebase.storage();
	//Create a storage reference from our storage service
	/* 	var storageRef = storage.ref();
	 */	var uid = "jk3a0123@gmail.com";
	    var upw = "wjdwndud08";
	 	var storageRef = storage.refFromURL("gs://hhkbex.appspot.com/");
	    firebase.auth().signInWithEmailAndPassword(uid , upw).catch(function (error) {
	       
	        console.log('error sign');
	        var errorCode = error.code;
	        var errorMessage = error.message;
	    }); // end login  
			var sid = $("#firesid").val();
	 // Create a reference to the file we want to download
	//    var starsRef = storageRef.child("member/"+sid+"_0.jpg");
		var starsRef = storageRef.child("member/"+sid+"_0.jpg");
	    // Get the download URL
	    starsRef.getDownloadURL().then(function(url) {
	    	$("#profileImg").attr("src",url);
	   		$("#headerimg").attr("src",url);	    }).catch(function(error) {
		switch (error.code) {
	        case 'storage/object_not_found':
	          // File doesn't exist
	          break;
	
	        case 'storage/unauthorized':
	          // User doesn't have permission to access the object
	          break;
	
	        case 'storage/canceled':
	          // User canceled the upload
	          break;
	
	        case 'storage/unknown':
	          // Unknown error occurred, inspect the server response
	          break;
	      }
	    });


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
});		
	
</script>

