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
				<div class="box box-primary">
					<div class="box-body no-padding">
						<div class="notice-controls">
							<ul class="noticeMenu">
								<li class="noticeItem">
									<div class="nno">번호</div>
									<div class="ntitle">글제목</div>
									<div class="nwriter">글쓴이</div>
									<div class="nregdate">작성일</div>
								</li>
							</ul>
						</div>
						<div class="noticeListCont">
							<ul class="noticeList">
							</ul>
						</div>
						<!-- /.mail-box-messages -->
					</div>
					<!-- /.box-body -->
				</div>
				<div class="row">
				<button class="writeBtn btn btn-primary pull-right">글쓰기</button> 
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-12">
								<div class="box-tools ">
									<div class="has-feedback"> 
										<input type="text" name="keyword" id="keywordInput" value="${cri.keyword }" class=""
											placeholder="Search" style="width: 160px; border: none">
											<button class="glyphicon glyphicon-search feedback" id="searchBtn" style="line-height:inherit;" ></button>
									</div>
								</div>
							</div>
						</div>
						<!-- Pagination Start -->
						<div class="paging text-center">
							<nav>
							<ul class="pagination">
								<c:if test="${pageMaker.prev}">
									<li><a href="notice?page=${pageMaker.startPage-1}" aria-label="Previous"> <span
											aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								
								<c:forEach begin = "${pageMaker.startPage }"
								end="${pageMaker.endPage }" var = "idx">
								<li 
								<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
								<a href="notice?page=${idx}">${idx}</a>
								</li>
								</c:forEach>
								
								<c:if test="${pageMaker.next && pageMaker.endPage>0}">
								<li><a href="notice?page=${pageMaker.endPage+1 }" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
								</c:if>
								

							</ul>
							</nav>
						</div>
						<!-- Pagination End -->
					</div>
				</div>
			</div>
		</div>
		</section>
	</div>
</body>
<%@include file="footer.jsp"%>
<script>


	var str="";
	<c:forEach items="${notice}" var="notice">

		str +='<li class="noticeItem">'+
			'<div class="nno" data-nno="${notice.nno}">${notice.nno}</div> <a class="ntitle" href="#"' +
			'title="${notice.ntitle}">${notice.ntitle}</a>'+
			'<div class="nwriter">${notice.nwriter}</div>'+
			'<div class="nregdate"><fmt:formatDate pattern="yyyy/MM/dd" value="${notice.nregdate}"/></div></li>';
	 
	</c:forEach>
	$(".noticeList").append(str);


	
	
	
$(".has-feedback").on("click", "#searchBtn",function(event) {
	console.log(event); 
});
	
	
	
	
	
</script>
</html>