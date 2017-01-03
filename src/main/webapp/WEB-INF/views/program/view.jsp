<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>​
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../faculity/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 <style>

 </style>
<body>


<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">

     
    </section>

    <div class="pad margin no-print">
 
    </div>

    <!-- Main content -->
    <section class="invoice">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header">
            <i class="glyphicon glyphicon-blackboard"></i> ${view.pcourse}
            <small class="pull-right glyphicon glyphicon-tag" ><b>${view.category}</b></small>
           
          </h2>
        </div>
        <!-- /.col -->
      </div>
      <!-- info row -->
      <div class="row invoice-info">
        <div class="col-sm-4 invoice-col">
          <address>
            <strong>${view.pcourse}</strong><br>
            기수 : ${view.torder} 기<br>
            교실 : ${view.roomname} 호 <br>
            총정원 : ${view.maximum} 명<br>
          </address>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col">

          <address>
            <strong>OpenDate</strong><br>
         <fmt:formatDate value="${view.opendate}" type="both" pattern="yyyy년MM월dd일  E요일"/>   
           		<br>
            <strong>CloseDate</strong><br>
            <fmt:formatDate value="${view.closedate}" type="both" pattern="yyyy년MM월dd일  E요일"/>
           	<br>

          </address>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col">
	       
	        	<div class="info-box">
            <span class="info-box-icon bg-aqua">${view.maximum}</span>
            <div class="info-box-content">
              <span class="info-box-text"><h1>총정원</h1></span>
            </div>
            <!-- /.info-box-content -->
          </div>
	          	<div class="info-box">
            <span class="info-box-icon bg-yellow">${stateCount}</span>
            <div class="info-box-content">
              <span class="info-box-text"><h1>남은 인원</h1></span>
             
            </div>
            <!-- /.info-box-content -->
          </div>
	        
	        

        
        <!-- /.col -->
      </div>
      <!-- /.row -->

	      <div class="row">
        <!-- accepted payments column -->
      
        <!-- /.col -->
        <div class="col-xs-10">
          <p class="lead">강의 내용</p>

          <div class="table-responsive">
          	${view.pcontent }
          </div>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
		<br>
		<br>

      <!-- Table row -->
      <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
            <thead>
            <tr>

              <th>과 목</th>
              <th>등 급</th>
              <th>강 사 명</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="joinList" items="${joinList}">
             <tr>
              <td>${joinList.subname}</td>
              <td>${joinList.subgrade }</td>
              <td>${joinList.tname }</td>
            </tr>
          </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->



      <div class="row no-print">
        <div class="col-xs-12">
          <form action="../student/enrolment" method="post" id="enrolform">
          <button type="button" class="btn btn-success pull-right" id="enrolBtn"><i class="glyphicon glyphicon-ok"></i> 수강 신청
          </button>
          <input type="hidden" value="hhkb" name="sid">
          <input type="hidden" value="${view.pno}" name="pno">
          </form>
          <a href ="http://localhost:8081/web/program/list"><button type="button" class="btn btn-primary pull-right" style="margin-right: 5px;">
            <i class="glyphicon glyphicon-arrow-left"></i> 돌아가기
          </button></a>
        </div>
      </div><!-- this row will not appear when printing -->
      
      
      
   
    </section>

		</div>
	</div>

  
  <%@include file="../faculity/footer.jsp"%>
  
<script>

	
	$("#enrolBtn").on("click",function(){
		console.log("클릭됬다!!!!!!!!");
		$("#enrolform").submit();
		
	});


</script>






</body>
</html>