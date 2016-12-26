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
			
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >종류</label>  
				  <select id="category" name="category" class="form-control">
				      <option value="beginner">SW 입문자를 위한 과정</option>
				      <option value="java">Java Web 개발자 과정</option>
				      <option value="windows">C / Windows</option>
				      <option value="bigdata">Big Data 입문</option>
				      <option value="embedded">IoT / Embedded</option>
				    </select>
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
			
				<div class="form-group">
				  <label class=" control-label" >과정명</label>  
				  <input id="pcontent" name="pcontent" type="text" placeholder="과정명" class="form-control">
					<span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >교실명</label>  
				  <select id="roomname" name="roomname" class="form-control">
				  		<c:forEach items= "${classroomList }" var="vo" >
				  			<option value="${vo.roomname }">${vo.roomname } ${vo.rempty}</option>					  		
				  		</c:forEach>
				    </select>
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >기수</label>  
				  <input id="torder" name="torder" type="text" placeholder="기수" class="form-control" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				<table class="table table-striped">
		            <thead>
		            <tr>
		              <th>과 목</th>
		              <th>등 급</th>
		              <th>강 사 명</th>
		            </tr>
		            </thead>
		            <tbody>
		             <tr>
		              <td>등록된 항목</td>
		            </tr>
		            </tbody>
		          </table>
		          
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >상세 과정</label>  
				     <select id="curriculum" name="curriculum" class="form-control">
				      <c:forEach items= "${joinAllList }" var="vo" >
				  			<option value="${vo.tsno }">${vo.subname } - ${vo.subgrade} - ${vo.tname}</option>					  		
				  		</c:forEach>
				    </select>
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label">열리는 시간</label>  
				  <input id="closedate" name="closedate" type="text" placeholder="2011-01-01" class="form-control" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >닫히는 시간</label>  
				  <input id="closedate" name="closedate" type="text" placeholder="2011-01-01" class="form-control" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				<div class="form-group">
				  <label class=" control-label" >정원</label>  
				  <input id="maximum" name="maximum" type="text" placeholder="정원" class="form-control" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				
				<div class="form-group">
				  <label class=" control-label" for="persongroupid" >Person Group ID</label>  
				  <input id="persongroupid" name="persongroupid" placeholder="person_group_id" disabled class="form-control" required="">
				   <span class="help-block">자동으로 생성됩니다.</span>  
				</div>
				
				
				<!-- Appended checkbox -->
				<div class="form-group">
				  <label class=" control-label" for="giftPic">Gift Picture</label>
				    <div class="input-group">
				      <input id="giftPic" name="giftPic" class="form-control" type="text" placeholder="Gift Picture">
				            <span class="input-group-addon">     
				          <input type="checkbox">     
				      </span>
				    </div>
				    <p class="help-block">Please upload the picture of the gift</p>
				</div>
				<div class=""></div>
				<button type="button" class="btn btn-success">Register</button>
				<button type="button" class="btn btn-warning">Cancel</button>
			</div>
		</div>
		</section>
	</div>


</body>

<%@include file="footer.jsp"%>


<script>

$(document).ready(function() {
	
	
});



</script>

</html>
