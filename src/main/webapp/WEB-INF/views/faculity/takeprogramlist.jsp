<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<h1></h1>
<div class="row">
	<div id="programList"></div>
</div>
<body>
	<div class="content-wrapper" style="min-height: 976px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Program List <small>Blank example to the boxed layout</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Layout</a></li>
			<li class="active">Boxed</li>
		</ol>
		</section>

		<!-- Main content -->
		<section class="content">
		<hr />
		<div class="row">
			<div class="col-sm-9 col-md-12">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs subjectTab">
					<li class="active"><a href="#java" data-toggle="tab" name='java'> <span class="glyphicon glyphicon-th-list"></span>JavaDB
					</a></li>
					<li><a href="#beginner" data-toggle="tab" name='beginner'><span
							class="glyphicon glyphicon-th-list"></span> SW Beginner</a></li>
					<li><a href="#windows" data-toggle="tab" name='windows'><span
							class="glyphicon glyphicon-th-list"></span> C / Windows</a></li>
					<li><a href="#embedded" data-toggle="tab" name='embedded'><span
							class="glyphicon glyphicon-th-list"></span> Embedded</a></li>
					<li><a href="#bigdata" data-toggle="tab" name='bigdata'><span
							class="glyphicon glyphicon-th-list"></span> Big Data & IoT</a></li>
				</ul>
				<!-- Tab panes -->
				<div class="tab-content">
					<div class="tab-pane programlist active in" id="java" ></div>

				</div>
			</div>
		</div>

		<div class="row state" style="visibility: hidden">	
					<div class="col-sm-9 col-md-12">
						<ul class="nav nav-tabs subjectTab">
							<li class="active"><a href="#beginner" data-toggle="tab" ><span class="glyphicon glyphicon-th-list"></span> 수강 신청 리스트 </a></li>
							<li><a href="#windows" data-toggle="tab"><span class="glyphicon glyphicon-th-list"></span> 수강 신청 완료 리스트</a></li>
						</ul>
							<div class="tab-content">
								<div class="tab-pane programlist active in" id="java" ></div>
							</div>
					</div>
		</div>
		<ul class="stateList"></ul>
			<button id="trueBtn" class="btn btn-block btn-success btn-lg" style="visibility: hidden">승 인 </button>

		</section>
	</div>


</body>

<%@include file="footer.jsp"%>



<script>


$(document).ready(function() {
		function getProgramList() {
			$.getJSON("/web/program/allList", function(data) {
				console.log(data);
				console.log(data.length);
				var str = "";
				$(data).each(function() { // foreach 개념으로 길이만큼 돈다.
					str += ""
// 					this.pno + this.pcourse + this.roomname + this.torder;
					console.log("str : " + str);
// 					$("#programList").html(str);
					$(".threadTable").append(str);
				});
			});
		}

		getProgramList();

		function getCategoryList(targetCategory) {
			

			
			console.log("getCategoryList is called..")
			console.log(targetCategory);
			$(".programlist").attr("id", targetCategory);
			
			$.getJSON("/web/program/categoryList/" + targetCategory , function(data) {
				console.log(data);

				$(document).ready(function () {
					var str = "";
					$(data).each(function() { // foreach 개념으로 길이만큼 돈다.
						
						var openDateNum = new Date(this.opendate);
						var openyear = openDateNum.getFullYear();
						var openmonth =openDateNum.getMonth();
						var opendate =  openDateNum.getDate();
						var openDate = openyear + "/" + openmonth + "/" + opendate;
						
						var closeDateNum = new Date(this.closedate);
						var closeyear = closeDateNum.getFullYear();
						var closemonth =closeDateNum.getMonth();
						var closedate =  closeDateNum.getDate();
						var closeDate = closeyear + "/" + closemonth + "/" + closedate;
						
						
						str += "<a href=#" + this.pno +" class='list-group-item takeprogramlist'> <span class='glyphicon glyphicon-star-empty'></span>"
							+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.category+"</span>"
							+ "<span class=''>"+this.pcourse+"</span>"
							+ "<span class='text-muted' style='font-size: 11px;'>--" +openDate+"</span>"
							+"<span class='text-muted' style='font-size: 11px;'> ~ " +closeDate+"</span>"
							+ "<span class='badge'>"+this.maximum+"</span> <span class='pull-right'>"
							+ " </span>";
					});
					$("#"+targetCategory).html(str);
					
					
					$("a").on("click" , function(event){
						
						console.log(event.currentTarget.hash);
						
						var hash = event.currentTarget.hash;
						
						var pno =	hash.split("#");
						
						console.log(pno[1]);
						

						var formdata = new FormData();
						formdata.append("pno",pno);
						formdata.append("state","false");
						
						
						$.ajax({
							url:"http://localhost:8081/web/faculity/statelist",
							type:"get",
							data:formdata,
							datatype:"json",
							success:function(result){

								console.log(result);

								$('.state').css('visibility' , 'visible');
								$('#trueBtn').css('visibility' , 'visible');
										resultStr = "";
											$(result).each(function(){
												
												resultStr += "<a href=#" + this.pno +" class='list-group-item takeprogramlist'> <span class='glyphicon glyphicon-star-empty'></span>"
												+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.sid+"</span>"
												+ "<span class=''>"+this.state+"</span>"
												+ "<span class='text-muted' style='font-size: 11px;'>--" +this.tregdate+"</span>"			
											    + "<span class='pull-right'><input type='checkbox' id='check'></span>"; 
												
											});
											$('.stateList').html(resultStr);
							
											$('#trueBtn').on('click' , function(event){
												
												
												var result = $('#check:checked');
												
												console.log(result);
												
												
											});
											
								
										

							}
							
						})
						
					});
				});
			});
		}
		
		
		getCategoryList("java");
		
		$(".subjectTab li").on("click", function(event) {
			console.log(event.target.name);
			var targetCategory = event.target.name;
			getCategoryList(targetCategory);
		});
		
		$(".list-group-item takeprogramlist").on("click", function(event){
				console.log(event);
		})
		
});
</script>

</html>
