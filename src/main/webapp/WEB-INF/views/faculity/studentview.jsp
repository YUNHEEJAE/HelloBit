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
						<label class=" control-label">학생 아이디</label> <input id="pcourse" name="sid" type="text" placeholder="학생아이디"
							value="${studentVO.sid}" class="form-control"
							readonly="readonly"> <span class="help-block">It
							identify how many days it takes for deliver</span>
					</div>

					<div class="form-group">
						<label class=" control-label">학생 이름</label> <input id="pcourse"
							name="sname" type="text" placeholder="학생이름"
							value="${studentVO.sname}" class="form-control" readonly="">
						<span class="help-block">It identify how many days it takes
							for deliver</span>
					</div>

					<div class="form-group">
						<label class=" control-label">학생 비밀번호</label> <input
							id="pcontent" name="spw" type="text" placeholder="학생비밀번호"
							value="${studentVO.spw}" class="form-control" readonly="">
						<span class="help-block">It identify how many days it takes
							for deliver</span>
					</div>

					<div class="form-group">
						<label class=" control-label">학생 이메일</label> <input id="pcontent"
							name="semail" type="text" placeholder="학생이메일"
							value="${studentVO.semail}" class="form-control" readonly="">
						<span class="help-block">It identify how many days it takes
							for deliver</span>
					</div>

					<button type="button" class="btn btn-success" id="btnModify">Modify</button>
					<button type="button" class="btn btn-danger" id="btnRemove">Remove</button>
					<button type="button" class="btn btn-warning" id="btnCancel">Cancel</button>
					<button type="button" class="btn btn-success" id="btnSuccess">success</button>
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
			$("#inputForm div input").attr("readonly", false).submit();
			$("#pcourse").attr("readonly", true).submit();
		});

		$("#btnSuccess").on("click", function() {
			$("#inputForm").attr("action", "studentmodify").submit();
		});

		$("#btnRemove").on("click", function() {
			if (confirm("정말삭제하시겠습니까?") == true) {

				$("#inputForm").attr("action", "studentRemove").submit();
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
