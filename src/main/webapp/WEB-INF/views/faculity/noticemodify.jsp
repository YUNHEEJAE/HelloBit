<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:forEach items="${list}" var="noticeVO"> --%>
	<%-- 	<p>${noticeVO.nno} ${noticeVO.nwriter} ${noticeVO.ntitle} ${noticeVO.ncontent} ${noticeVO.nregdate}</p>  --%>
	<%-- </c:forEach> --%>
	<div class="content-wrapper" style="min-height: 976px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Notice <small>공지사항</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="list"><i class="fa fa-dashboard active"></i>Home</a></li>
		</ol>
		</section>
		<section class="content">
		<div class="row">
			<div class="col-md-10">
				<div class="box box-info">
				
		            <div class="box-header with-border">
		              <h3 class="box-title">공지사항 수정</h3>
		            </div>
		            
		            <div class="box-body">
		              <form role="form" method="post" id="inputForm">
		                <!-- text input -->
			                <div class="form-group">
			                  <label>제목</label>
			                  <input class="form-control" placeholder="제목..." type="text" name="ntitle" id="ntitle" value="${NoticeVO.ntitle }">
		                  	</div>
			                <div class="form-group">
			                  <label>글쓴이</label>
			                  <input class="form-control" placeholder="Enter ..." type="text" value="${cookie.LOGIN_ID.value }" readonly="readonly" name="nwriter">
		                  	</div>
			                <div class="form-group">
			                <!-- textarea -->
			                  <label>내용</label>
			                  <textarea class="form-control" rows="10" placeholder="내용..." name="ncontent" id="ncontent" ></textarea>
			                </div>
		                </form>
			                <div class="box-footer">
				                <button class="btn btn-default" id="btnCancel">Cancel</button>
				                <button class="btn btn-info pull-right" id="btnRegister">Register</button>
				           	</div>
		            </div>
            <!-- /.box-body -->
          </div>
			
			
			
			</div>


		</div>
		</section>
	</div>
</body>
<%@include file="footer.jsp"%>
<script>

$(document).ready(function() {
	
	var currNcontent = "${NoticeVO.ncontent}";
	
	$("#ncontent").val(currNcontent.replace(/<br>/gi, "\r\n"));
	
	
	$("#btnRegister").on("click", function () {
		event.preventDefault();
		$("#ncontent").val($("#ncontent").val().replace(/\n/g, "<br>"));
		$("#inputForm").submit();		
	});
	
	$("#btnCancel").on("click", function () {
		event.preventDefault();
		location.href='/noticeview?nno=' + ${NoticeVO.nno};
	});
	
	
	
});
	
	
</script>
</html>