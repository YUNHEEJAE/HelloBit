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
						<label class=" control-label">교직원아이디</label> <input id="pcourse" name="fid" type="text" placeholder="교직원아이디"
							value="${faculityVO.fid}" class="form-control"
							readonly="readonly"> <span class="help-block">It
							identify how many days it takes for deliver</span>
					</div>

					<div class="form-group">
						<label class=" control-label">교직원 이름</label> <input id="pcourse"
							name="fname" type="text" placeholder="교직원이름"
							value="${faculityVO.fname}" class="form-control" readonly="">
						<span class="help-block">It identify how many days it takes
							for deliver</span>
					</div>

					<div class="form-group">
						<label class=" control-label">교직원 비밀번호</label> <input
							id="pcontent" name="fpw" type="text" placeholder="교직원비밀번호"
							value="${faculityVO.fpw}" class="form-control" readonly="">
						<span class="help-block">It identify how many days it takes
							for deliver</span>
					</div>

		

					<button type="button" class="btn btn-success" id="btnSuccess">success</button>
					<button type="button" class="btn btn-success" id="btnModify">Modify</button>
					<button type="button" class="btn btn-danger" id="btnRemove">Remove</button>
					<button type="button" class="btn btn-warning" id="btnCancel">Cancel</button>
				</form>

			</div>
		</div>
		</section>
	</div>


</body>

<%@include file="footer.jsp"%>



<script>
	$(document).ready(function() {
		$("#btnSuccess").hide();
		
		
		$("#btnModify").on("click", function() {
			console.log("변경잼");
			$("#btnSuccess").show();
			$("#btnModify").hide();
			$("#btnRemove").hide();
			$("#inputForm div input").attr("readonly", false).submit();
			$("#pcourse").attr("readonly", true).submit();
		});

		$("#btnSuccess").on("click", function() {
			$("#inputForm").attr("action", "faculitymodify").submit();
		});

		$("#btnRemove").on("click", function() {
			if (confirm("정말삭제하시겠습니까?") == true) {

				$("#inputForm").attr("action", "faculityremove").submit();
			} else {
				return;
			}
		});

		$("#btnCancel").on("click", function() {
			event.preventDefault();
			history.back(1);
		});

	});
</script>

</html>