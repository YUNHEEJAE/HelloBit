<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>faculity view here</title>
</head>


<body>
	<div class="content-wrapper" style="min-height: 976px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Faculity View <small> 교직원 관리 페이지 입니다. </small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="list"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">faculity</li>
		</ol>
		</section>

		<!-- Main content -->
		<section class="content">
		<hr />
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form method="post" id="inputForm">
					<!-- Text input-->



					<div class="form-group">
						<label class=" control-label">교직원아이디</label> <input id="pcourse" name="fid" type="text" placeholder="교직원아이디"
							value="${faculityVO.fid}" class="form-control"
							readonly="readonly">
					</div>

					<div class="form-group">
						<label class=" control-label">교직원 이름</label> <input id="pcourse"
							name="fname" type="text" placeholder="교직원이름"
							value="${faculityVO.fname}" class="form-control" readonly="">
				
					</div>

					<div class="form-group">
						<label class=" control-label">교직원 비밀번호</label> <input
							id="pcontent" name="fpw" type="text" placeholder="교직원비밀번호"
							value="${faculityVO.fpw}" class="form-control" readonly="">
		
					</div>

					<div class="pull-right">
						<button type="button" class="btn btn-success" id="btnSuccess">수정 완료</button>
						<button type="button" class="btn btn-success" id="btnModify">수정</button>
						<button type="button" class="btn btn-danger" id="btnRemove">삭제</button>
						<button type="button" class="btn btn-warning" id="btnCancel">취소</button>
					</div>
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
