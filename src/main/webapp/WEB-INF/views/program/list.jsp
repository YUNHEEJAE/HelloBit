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
					<li class="active"><a href="#java" data-toggle="tab"
						name='java'> <span class="glyphicon glyphicon-th-list"></span>JavaDB
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

<!-- 					Java Data -->
<!-- 					<div class="tab-pane fade in active" id="java"> -->
<!-- 						<div class="list-group"> -->
<!-- 							<a href="#" class="list-group-item"> <span -->
<!-- 								class="glyphicon glyphicon-star-empty"></span> <span -->
<!-- 								class="name" style="min-width: 120px; display: inline-block;">JAVA -->
<!-- 									88</span> <span class="">JAVA 88기 고급 Web Developer</span> <span -->
<!-- 								class="text-muted" style="font-size: 11px;">- 잘 배우는 방법</span> <span -->
<!-- 								class="badge">12:10 AM</span> <span class="pull-right"> <span -->
<!-- 									class="glyphicon glyphicon-paperclip"></span> -->
<!-- 							</span> -->
<!-- 							</a> <a href="#" class="list-group-item"> <span -->
<!-- 								class="glyphicon glyphicon-star-empty"></span> <span -->
<!-- 								class="name" style="min-width: 120px; display: inline-block;">JAVA -->
<!-- 									88</span> <span class="">JAVA 88기 중급 Web Developer</span> <span -->
<!-- 								class="text-muted" style="font-size: 11px;">- 잘 못 배우는 방법</span> -->
<!-- 								<span class="badge">12:10 AM</span> <span class="pull-right"> -->
<!-- 									<span class="glyphicon glyphicon-paperclip"></span> -->
<!-- 							</span> -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 					</div> -->


					<div class="tab-pane fade in programlist" id="java" >
<!-- 						<div class="list-group"> -->
<!-- 							<a href="#" class="list-group-item"> <span -->
<!-- 								class="glyphicon glyphicon-star-empty"></span> <span -->
<!-- 								class="name" style="min-width: 120px; display: inline-block;">JAVA -->
<!-- 									88</span> <span class="">SW 입문자 2기 </span> <span class="text-muted" -->
<!-- 								style="font-size: 11px;">- 시작하기다</span> <span class="badge">12:10 -->
<!-- 									AM</span> <span class="pull-right"> <span -->
<!-- 									class="glyphicon glyphicon-paperclip"></span> -->
<!-- 							</span> -->
<!-- 							</a> -->
<!-- 						</div> -->
					</div>

<!-- 					Windows -->
<!-- 					<div class="tab-pane fade in" id="windows">...</div> -->

<!-- 					Embedded -->
<!-- 					<div class="tab-pane fade in" id="embedded">This tab is -->
<!-- 						empty.</div> -->

<!-- 					Big Data -->
<!-- 					<div class="tab-pane fade in" id="bigdata">This tab is -->
<!-- 						empt2y.</div> -->
				</div>
			</div>
		</div>
		</section>
	</div>


</body>

<%@include file="footer.jsp"%>



<script>

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
				var str = "";
				$(data).each(function() { // foreach 개념으로 길이만큼 돈다.
					str += "'<a href=" + this.pno +" class='list-group-item'> <span class='glyphicon glyphicon-star-empty'></span>"
						+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.category+"</span>"
						+ "<span class=''>"+this.pcourse+"</span>"
						+ "<span class='text-muted' style='font-size: 11px;'>--" +this.opendate+"</span>"
						+ "<span class='badge'>"+this.maximum+"</span> <span class='pull-right'>"
						+ "<span class='glyphicon glyphicon-paperclip'></span> </span>'";
				});
				$("#"+targetCategory).html(str);
			});
		}
		
		getCategoryList("java");
		
		$(".subjectTab li").on("click", function(event) {
			console.log(event.target.name);
			var targetCategory = event.target.name;
// 			getCategoryList(targetCategory);
		});

</script>

</html>