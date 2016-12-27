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
				  <label class=" control-label" >종류</label>  
				  <select id="category" name="category" class="form-control">
				      <option value="beginner" >SW 입문자를 위한 과정</option>
				      <option value="java">Java Web 개발자 과정</option>
				      <option value="windows">C / Windows</option>
				      <option value="bigdata">Big Data 입문</option>
				      <option value="embedded">IoT / Embedded</option>
				    </select>
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
			
				<div class="form-group">
				  <label class=" control-label" >과정명</label>  
				  <input id="pcourse" name="pcourse" type="text" placeholder="과정명" value="TEST 74" class="form-control">
					<span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				
				
				<div class="form-group">
				  <label class=" control-label" >과정 설명</label>  
<%-- 				  <input id="pcontent" name="pcontent" type="text" placeholder="과정 설명" value="${currdata.pcontent}" class="form-control" style="height: 300px" wrap="virtual"> --%>
						<textarea rows="10" name="pcontent" id="pcontent" class="form-control" value="TEST CONTENT 74 2"></textarea>		
					<span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >교실명</label>  
				  <select id="roomname" name="roomname" class="form-control">
<%-- 				  		<c:forEach items= "${classroomList }" var="vo" > --%>
<%-- 				  			<option value="${vo.roomname }">${vo.roomname } ${vo.rempty}</option>					  		 --%>
<%-- 				  		</c:forEach> --%>
				    </select>
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >기수</label>  
				  <input id="torder" name="torder" type="text" placeholder="99" value="74" class="form-control" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				
		          
				<div class="form-group">
				 	<label class="control-label" >상세 과정</label>  
					<div>
						<div class="col-md-10">
					     	<select id="curriculum" name="curriculum" class="form-control">
<%-- 					     		<c:forEach items= "${joinAllList }" var="vo" > --%>
<%-- 						  			<option value="${vo.tsno }">${vo.subname } - ${vo.subgrade} - ${vo.tname}</option> --%>
<%-- 					  			</c:forEach> --%>
					    	</select>
					    </div>
					    
					    <div class="col-md-2">
					   		<button type="button" class="btn btn-info" id="addCurriculum">추가</button>
					   		<button type="button" class="btn btn-warning" id="delCurriculum">삭제</button>
				    	</div>
					</div>
				    <span class="help-block">It identify how many days it takes for deliver</span>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>과 목</th>
									<th>등 급</th>
									<th>강 사 명</th>
								</tr>
							</thead>
							<tbody id="addedCurriculum">
							</tbody>
						</table>
					</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label">열리는 시간</label>  
				  <input id="opendate" name="opendate" type="text" placeholder="2011-01-01" value="2014-04-16" class="form-control" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >닫히는 시간</label>  
				  <input id="closedate" name="closedate" type="text" placeholder="2011-01-01" value="2014-04-16" class="form-control" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				<div class="form-group">
				  <label class=" control-label" >정원</label>  
				  <input id="maximum" name="maximum" type="text" placeholder="30" class="form-control" value="30" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				
				
				<div class="form-group">
				  <label class=" control-label" for="persongroupid" >Person Group ID</label>  
				  <input id="persongroupid" name="persongroupid" placeholder="person_group_id" readonly="readonly" class="form-control" value="remember_0416" required="">
				   <span class="help-block">자동으로 생성됩니다.</span>  
				</div>
				
				</form>
				<button type="button" class="btn btn-success" id="btnModify">Modify</button>
				<button type="button" class="btn btn-warning" id="btnCancel">Cancel</button>
				
				
			</div>
		</div>
		</section>
	</div>


</body>

<%@include file="footer.jsp"%>


<script>

$(document).ready(function () {
	
	function setClassroomList() {
		$.getJSON("../faculity/classroomlist", function(data){
			console.log(data);
			
			var str = "";
			$(data).each(function() {
				str += "<option value=" + this.roomname + "> " +this.roomname + " " + this.rempty + "</option>"	
			});
			
			$("#roomname").html(str);
		});
	}
	
	function setJoinAllList() {
		$.getJSON("../faculity/joinalllist", function(data){
			console.log(data);
			
			var str = "";
			$(data).each(function() {
				str += "<option value=" + this.tsno + ">" + this.subname +" - " + this.subgrade + " - " + this.tname + "</option>";
			});
			
			$("#curriculum").html(str);
		});
	}
	
	
	// 수정 위해 초기 값 세팅하기.
	(function(){
		
		console.log("this is running");

		$("#category > option[value=${currdata.category}]").attr("selected", "selected");
		
		$("#pcourse").attr("value", "${currdata.pcourse}");
		
		var currPcontent = "${currdata.pcontent}";
		
		$("#pcontent").val(currPcontent.replace(/<br>/gi, "\r\n"));
		
		$("#roomname > option[value=${currdata.roomname}]").attr("selected", "selected");
		
		$("#torder").attr("value", ${currdata.torder});
		$("#maximum").attr("value", ${currdata.maximum});
		$("#persongroupid").attr("value", "${currdata.persongroupid}");
		
		
		
		$.getJSON("../faculity/teachersubjectlist/${param.pno}" , function (data) {
			
			var str = "";
			$(data).each(function() {
				str += "<tr><td>"+this.subname+"</td><td>"+this.subgrade+"</td><td>"+this.tname+"</td></tr>";
			});
			
			
			$("#addedCurriculum").append(str);
		});
		
		
	})();
	
	
	
	setClassroomList();
	
	setJoinAllList();
	
	
	$("#btnModify").on("click", function () {
		event.preventDefault();
		$("#inputForm").submit();		
		
	});
	
	
	$("#addCurriculum").on("click", function () {
		event.preventDefault();
		var current = $("#curriculum option:selected");
		$("#inputForm").append("<input type='hidden' name='curriculums' value="+current.val()+">");
		var splitData = current.text().split(' - ');
		
		$("#addedCurriculum").append("<tr><td>"+splitData[0]+"</td><td>"+splitData[1]+"</td><td>"+splitData[2]+"</td></tr>");
	});
	
	$("#delCurriculum").on("click", function () {
		event.preventDefault();
		$("#addedCurriculum > tr:last").remove();
		$("#inputForm > input:last").remove();
	});
	
});


</script>

</html>
