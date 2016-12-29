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

<body>
	<div class="content-wrapper" style="min-height: 976px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Program Register <small>Blank example to the boxed layout</small>
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
			<div class="col-md-12"> 
				<form method="post" id="inputForm">

				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >선생님</label>  
				  <select id="teacher" name="tid" class="form-control">
				   	<c:forEach items="${teacherVO}" var="teacherVO">
				  		<option value="${teacherVO.tid}"> ${teacherVO.tname }  </option>
				  	</c:forEach>
				    </select>
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >과목</label>  
				  <select id="subject" name="subno" class="form-control">
				  	<c:forEach items="${subjectVO}" var="subjectVO">
				  		<option value="${subjectVO.subno}"> ${subjectVO.subname } -  ${subjectVO.subgrade } </option>
				  	</c:forEach>
				    </select>
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				

				
				</form>
				<button type="button" class="btn btn-success" id="btnRegister">Register</button>
				<button type="button" class="btn btn-warning" id="btnCancel">Cancel</button>
				
				
			</div>
		</div>
		</section>
	</div>


</body>

<%@include file="footer.jsp"%>


<script>

$(document).ready(function () {
	
	$("#btnRegister").on("click", function () {
		event.preventDefault();
		var selecttid = $('#teacher option').val();  
		console.log(selecttid);
		//var selectsubno = 
		var selectsubno = $('#subject option').val();  
		console.log(selectsubno);
		 $("#inputForm").submit();
		
	});
	
	

	
});


</script>

</html>
