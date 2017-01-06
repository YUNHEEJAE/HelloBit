<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../faculity/header.jsp"%>
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
			강의 수정 <small>강의를 수정합니다.</small>
		</h1>
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
					<span class="help-block">강의의 종류를 선택하세요</span>  
				    
				</div>
				<div class="form-group">
				  <label class=" control-label" >과정명</label>  
				  <input id="pcourse" name="pcourse" type="text" placeholder="과정명" class="form-control">
					<span class="help-block">강의의 정식 명칭을 입력하세요</span>  
				</div>
				<div class="form-group">
				  <label class=" control-label" >과정 설명</label>  
						<textarea rows="10" name="pcontent" id="pcontent" class="form-control"></textarea>
				</div>
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >교실명</label>  
				  <select id="roomname" name="roomname" class="form-control">
				  		<c:forEach items= "${classroomList }" var="vo" >
				  			<option value="${vo.roomname }">${vo.roomname }호 ${vo.rempty==true ? '비어있음' : ' 사용 중'}</option>
				</c:forEach>
				    </select>
				</div>
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >기수</label>  
				  <input id="torder" name="torder" type="text" placeholder="00" class="form-control" required="">
				</div>
				<div class="form-group">
				 	<label class="control-label" >상세 과정</label>  
					<div>
						<div class="col-md-10">
					     	<select id="curriculum" name="curriculum" class="form-control">
					     		<c:forEach items= "${joinAllList }" var="vo" >
						  			<option value="${vo.tsno }">${vo.subname } - ${vo.subgrade} - ${vo.tname}</option>
					  			</c:forEach>
					    	</select>
					    </div>
					    
					    <div class="col-md-2">
					   		<button type="button" class="btn btn-info" id="addCurriculum">추가</button>
					   		<button type="button" class="btn btn-warning" id="delCurriculum">삭제</button>
				    	</div>
					</div>
				    <span class="help-block">강의의 상세 과정 및 강사를 선택하세요. 추가 버튼을 눌러야 등록됩니다. 여러개 등록 가능합니다.</span>
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
				  <label class=" control-label">개강 일자</label>  
				  <input id="opendate" name="opendate" type="text" placeholder="2011-01-01" class="form-control" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >종강 일자</label>  
				  <input id="closedate" name="closedate" type="text" placeholder="2011-01-01" class="form-control" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				<div class="form-group">
				  <label class=" control-label" >정원</label>  
				  <input id="maximum" name="maximum" type="text" placeholder="00" class="form-control" required="">
				    <span class="help-block">It identify how many days it takes for deliver</span>  
				</div>
				<div class="form-group">
					<label class=" control-label" for="persongroupid" >Person Group ID</label>  
					<div>
					<div class="col-md-11">
						<input id="persongroupid" name="persongroupid" placeholder="person_group_id" class="form-control"   required="">
					</div>
					<div class="col-md-1">
				   		<button type="button" class="btn btn-info" id="getPersonGroupId">생성</button>
			    	</div>
					</div>
				   <span class="help-block">버튼을 누르면 카테고리와 기수에 따라 자동으로 생성됩니다.</span>  
				</div>
				</form>
				<button type="button" class="btn btn-success" id="btnModify">Modify</button>

				<a href="view?pno=${param.pno}"><button type="button" class="btn btn-warning" id="btnCancel" >Cancel</button></a>

			</div>
		</div>
		</section>
	</div>
</body>
<%@include file="../faculity/footer.jsp"%>
<script>

$(document).ready(function () {
	
	$("#faculity_2").attr("class", "active");	
	$("#program_list").attr("class", "active");
	
	// 수정 위해 초기 값 세팅하기.
	(function(){
		
		console.log("this is running");
		$("#category > option[value=${currdata.category}]").attr("selected", "selected");
		
		$("#pcourse").attr("value", "${currdata.pcourse}");
		
		var currPcontent = "${currdata.pcontent}";
		
		$("#pcontent").val(currPcontent.replace(/<br>/gi, "\r\n"));
		
		$("#roomname > option[value=${currdata.roomname}]").attr("selected", "selected");
		
		$("#torder").attr("value", "${currdata.torder}");
		$("#maximum").attr("value", "${currdata.maximum}");
		$("#persongroupid").attr("value", "${currdata.persongroupid}");
		
		
		$("#opendate").attr("value", '<fmt:formatDate pattern="yyyy-MM-dd" value="${currdata.opendate}"/>');
		$("#closedate").attr("value", '<fmt:formatDate pattern="yyyy-MM-dd" value="${currdata.closedate}"/>');
		
		
		$.getJSON("../faculity/teachersubjectlist/${param.pno}" , function (data) {
			
			var str = "";
			$(data).each(function() {
				str += "<tr><td>"+this.subname+"</td><td>"+this.subgrade+"</td><td>"+this.tname+"</td></tr>";
				$("#inputForm").append("<input type='hidden' name='curriculums' value="+this.tsno+">");
			});
			
			
			$("#addedCurriculum").append(str);
		});
		
		
	})();
	
	$("#btnModify").on("click", function () {
		event.preventDefault();
		$("#pcontent").val($("#pcontent").val().replace(/\n/g, "<br>"));
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
	
	$("#getPersonGroupId").on("click", function () {
		event.preventDefault();
		var makeId = $("#category").val() + "_" + $("#torder").val();
		
		$("#persongroupid").val(makeId);
		
	});
	
	
});


</script>

</html>
