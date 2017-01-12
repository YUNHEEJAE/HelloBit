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
       	<div class="box box-solid">
			<div class="row">
	       		<div class="col-md-8 col-md-offset-2">
	                <hr>
	       		
	                <h1>${noticeVO.ntitle }</h1>
	                <!-- Author -->
	                <p class="lead">by ${noticeVO.nwriter }</p>
	
	                <hr>
	
	                <!-- Date/Time -->
	                <p><span class="glyphicon glyphicon-time"></span> Posted on <fmt:formatDate pattern="yyyy년 MM월 dd일" value="${noticeVO.nregdate}"/></p>
	
	                <hr>
	
	                <!-- Post Content -->
	                <p class="lead">${noticeVO.ncontent}</p>
	                <hr>
	             <div class="row">
                 	<div class = "pull-right"><button type="button" class="btn btn-block btn-danger" id='delBtn'>삭제</button></div>
                 	<div class = "pull-right" style="margin-left: 10px; margin-right: 10px">
                 	<button type="button" class="btn btn-block btn-info" id='modiBtn'>수정</button></div>
                 	<div class = "pull-right"><button type="button" class="btn btn-block btn-default" id='backBtn'>돌아가기</button></div>
	             </div>
	               <hr>
				</div>
            </div>
		</div>
		</section>
				<form method="post" id="nnoform" action="noticeremove">
					<input type="hidden" value ="${noticeVO.nno}" name="nno">
				</form>	
	</div>
</body>
<%@include file="footer.jsp"%>

<script>
$(document).ready(function () {

$("#delBtn").on("click", function() {

	if (confirm("정말 삭제하시겠습니까?") == true) {
		$("#nnoform").submit();
	} else {
		return;
	}
});

$("#modiBtn").on("click",function(){

	location.href='noticemodify?nno=' + ${noticeVO.nno};
});

$("#backBtn").on("click", function() {
	history.back(1);
});

});
	
	
</script>
</html>