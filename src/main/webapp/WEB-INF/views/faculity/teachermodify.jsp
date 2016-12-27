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
				  <label class=" control-label" >강사이름</label>  
				  <input id="pcourse" name="tname" type="text" placeholder="강사이름" value="이종필" class="form-control">
					<span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
			
				  <input id="pcourse" name="tid" type="hidden" placeholder="강사아이디" value="user01" class="form-control">
				
				<div class="form-group">
				  <label class=" control-label" >강사비밀번호</label>  
				  <input id="pcontent" name="tpw" type="text" placeholder="강사비밀번호" value="user01" class="form-control">
					<span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				<button type="button" class="btn btn-success" id="btnRegister">Register</button>
				<button type="button" class="btn btn-warning" id="btnCancel">Cancel</button>
				
				</form>
				
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
		$("#inputForm").submit();		
		
	});
	
		
});


</script>

</html>
