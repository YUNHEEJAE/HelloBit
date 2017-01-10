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
			<div class="col-md-2">

        	</div>
        
        
        <!-- ./col -->
        <div class="col-md-8">
          <div class="box box-solid">
            <div class="box-header with-border">
              <i class="fa fa-text-width"></i>

              <h3 class="box-title">${noticeVO.ntitle }</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <dl class="dl-horizontal">
              	<br><br>
              	
                <dt>${noticeVO.nwriter }</dt>
                <dd>${noticeVO.ncontent }</dd>
                <dt><br></dt>
                <dd><br></dd>
                <dd><br></dd>
                <dt><br></dt>
                <dd><br></dd>
                <dt><br></dt>
                <dd><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${noticeVO.nregdate}"/></dd>
         
			   </dl>
			 <br>
			 
			 <div class="row pull-right">
	              <div class="col-md-3"><button type="button" class="btn btn-block btn-warning" id="modisucBtn">수정완료</button></div>
				  <div class="col-md-3"><button type="button" class="btn btn-block btn-default">돌아가기</button></div>
	              <div class="col-md-3"><button type="button" class="btn btn-block btn-info">수정</button></div>
	              <div class="col-md-3"><button type="button" class="btn btn-block btn-danger">삭제</button></div>
             </div>
			              
			             

			              
			              
			              
			            </div>
			            <!-- /.box-body -->
			          </div>
			          <!-- /.box -->
			        </div>
			        <!-- ./col -->
						
					


		</div>
		</section>
	</div>
</body>
<%@include file="footer.jsp"%>

<script>
	
	$("#modisucBtn").hide();
var str="";
<c:forEach items="${notice}" var="notice">

	str +='<li class="noticeItem">'+
		'<div class="nno" data-nno="${notice.nno}">${notice.nno}</div> <a class="ntitle" href="#"' +
		'title="${notice.ntitle}">${notice.ntitle}</a>'+
		'<div class="nwriter">${notice.nwriter}</div>'+
		'<div class="nregdate"><fmt:formatDate pattern="yyyy/MM/dd" value="${notice.nregdate}"/></div></li>';
 
</c:forEach>
$(".noticeList").append(str);
	
	
	
	
	
function getFormatDate(date){
	var stringDate = new Date(date);
	var year = stringDate.getFullYear();
	var month= (1+stringDate.getMonth());
	month = month >=10?month:'0' + month;
	var day = stringDate.getDate();
	day=day>=10?day:'0'+day;
	return year+"-"+month+"-"+day;
}
	
	
	
	
</script>
</html>