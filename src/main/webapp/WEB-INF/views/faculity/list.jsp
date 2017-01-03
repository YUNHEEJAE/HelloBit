<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
				<form class="createBtn">
				<input type="submit" class='btn btn-block btn-primary' value='create' id='createBtn'></form>

				
			<div class="col-sm-9 col-md-12">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs subjectTab">
					<li class="active"><a href="#student" data-toggle="tab"
						name='student'> <span class="glyphicon glyphicon-th-list"></span> Student
					</a></li>
					<li><a href="#teacher" data-toggle="tab" name='teacher'><span
							class="glyphicon glyphicon-th-list"></span> Teacher</a></li>
					<li><a href="#faculity" data-toggle="tab" name='faculity'><span
							class="glyphicon glyphicon-th-list"></span> Faculity</a></li>
					<li><a href="#classroom" data-toggle="tab" name='classroom'><span
							class="glyphicon glyphicon-th-list"></span> Classroom</a></li>
					<li><a href="#subject" data-toggle="tab" name='subject'><span
							class="glyphicon glyphicon-th-list"></span> Subject</a></li>
					<li><a href="#teachersubject" data-toggle="tab" name='teachersubject'><span
							class="glyphicon glyphicon-th-list"></span> TeacherSubject</a></li>					
					<input type='hidden' class='saveid'>
											
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div class="tab-pane programlist active in" id="java" ></div>

				</div>
			</div>
		</div>
		</section>
	</div>


</body>

<%@include file="footer.jsp"%>



<script>


$(document).ready(function() {
	
		$("#faculity_2").attr("class", "active");	
		$("#faculity_list").attr("class", "active");	
	
	
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
			if(targetCategory == "student"){
				$("#createBtn").hide();
			}else{
				$("#createBtn").show();
			}
			$(".programlist").attr("id", targetCategory);
			
			$.getJSON("/web/faculity/"+ targetCategory +"list/" , function(data) {
				console.log(data);
				$(document).ready(function () {
					var str = "";
						$(data).each(function() { // foreach 개념으로 길이만큼 돈다.
							console.log("choose execute.................")
							
							switch(targetCategory){
								
							case 'student' : 	str += "<a href=studentview?sid=" + this.sid +" class='list-group-item'> <span class='glyphicon glyphicon-star-empty'></span>"
							+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.sname+"</span>"
							+ "<span class=''>"+this.semail+"</span>"
							break;

							case 'teacher' : 	str += "<a href= teacherview?tid="+this.tid+" class='list-group-item'> <span class='glyphicon glyphicon-star-empty'></span>"
							+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.tname+"</span>"
							break;
							
							case 'faculity' : 	str += "<a href=faculityview?fid=" + this.fid +" class='list-group-item'> <span class='glyphicon glyphicon-star-empty'></span>"
							+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.fname+"</span>"
							break;
							
							case 'classroom' : 	str += "<a href=classroomview?roomname=" + this.roomname +" class='list-group-item'> <span class='glyphicon glyphicon-star-empty'></span>"
							+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.roomname+"</span>"
							+ "<span class=''>"+this.rempty+"</span>"
							break;
							
							case 'subject' : 	str += "<a href=subjectview?subno=" + this.subno +" class='list-group-item'> <span class='glyphicon glyphicon-star-empty'></span>"
							+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.subno+"</span>"
							+ "<span class=''>"+this.subname +" "+ this.subgrade+"</span>"
							break;
							
							case 'teachersubject' : str += "<a href=teachersubjectview?tsno=" + this.tsno +" class='list-group-item'> <span class='glyphicon glyphicon-star-empty'></span>"
							+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.tname+"</span>"
							+ "<span class=''>"+this.subname + " " + this.subgrade+"</span>"
							break;
							}

					});
					$("#"+targetCategory).html(str);
					$(".saveid").attr("value",targetCategory);
					console.log();
				});
			});
		}
		
		getCategoryList("student");
		
		$(".subjectTab li").on("click", function(event) {
			
			console.log(event.target.name);
			var targetCategory = event.target.name;
			getCategoryList(targetCategory);
		});
		
 		$("#createBtn").on("click",function(event){
			
			console.log(event);
			var domain = $(".saveid").val();
			
			console.log(domain);
			
			$(".createBtn").attr("action",domain+"register").submit();			
			
		}) ;
 		

 		$("#updateBtn").on("click",function(event){
			
			console.log(event);
			var domain = $(".saveid").val();
			
			console.log(domain);
			
			$(".updateBtn").attr("action",domain+"modify").submit();			
			
		}) ;
 		
 		$("#deleteBtn").on("click",function(event){
			
			console.log(event);
			var domain = $(".saveid").val();
			
			console.log(domain);
			
			$(".deleteBtn").attr("action",domain+"remove").submit();			
			
		});
 		
 		$(".programlist span").on("click", function(event){
 			event.preventDefault();
 			console.log(event);
 		});
 		
 		

});	
</script>

</html>