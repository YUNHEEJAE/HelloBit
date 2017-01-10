<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<body>
	<div class="content-wrapper" style="min-height: 976px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				Faculity List <small>수 강 현황 관리 페이지 입니다.</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="list"><i class="fa fa-dashboard active"></i>Home</a></li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<hr />
			<div class="row">
				<div class="col-md-6">
					<!-- Tab 메뉴  -->
					<ul class="nav nav-tabs subjectTab" id="subjectTab">
						<li class="active"><a href="#java" data-toggle="tab"
							name='java'> <span class="glyphicon glyphicon-th-list"></span>JavaDB
						</a></li>
						<li><a href="#beginner" data-toggle="tab" name='beginner'><span
								class="glyphicon glyphicon-th-list"></span> SW Beginner</a></li>
						<li><a href="#windows" data-toggle="tab" name='windows'><span
								class="glyphicon glyphicon-th-list"></span> C / Windows</a></li>
						<li><a href="#embedded" data-toggle="tab" name='embedded'><span
								class="glyphicon glyphicon-th-list"></span> Embedded</a></li>
						<li><a href="#bigdata" data-toggle="tab" name='bigdata'><span
								class="glyphicon glyphicon-th-list"></span> Big Data & IoT</a></li>
					</ul>
					<!-- Tab 내용 -->
					<div class="tab-content">
						<div class="tab-pane programlist active in" id="java"></div>
					</div>
				</div>

				<!-- 수강신청 목록 -->
				<div class="col-md-6" id="application" style="visibility: hidden">
					<div class="row">
						<div class="col-sm-9 col-md-12">
						<!-- 수강신청 탭 -->
							<ul class="nav nav-tabs" id="selectstate">
								<li class="active" id='waitingList'><a href="#false"
									data-toggle="tab"><span class="glyphicon glyphicon-th-list"></span>
										수강 신청 리스트 </a></li>
								<li id="successList"><a href="#true" data-toggle="tab"><span
										class="glyphicon glyphicon-th-list"></span> 수강 신청 완료 리스트</a></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane studentList active in" id="java"></div>
							</div>
						</div>
					</div>
					<ul class="stateList"></ul>
					<div class="col-md-3 pull-right">
						<button id="approvalBtn" class="btn btn-block btn-success">승
							인</button>
						<button id="cancelBtn" class="btn btn-block btn-success"
							style="display: none;">취 소</button>
					</div>
					<form id='admission' action="../faculity/admission" method="post">
						<input type="hidden" id="admissionPno" name="pno" value=""> 
							<input type="hidden" id="persongroupid"
							name="groupid" value="">
					</form>
					<form id='cancel' action="../faculity/cancel" method="post">
						<input type="hidden" name="pno" id="canclePno" value="">
						<input type="hidden" id="persongroupid"
							name="groupid" value="">
					</form>
				</div>
			</div>
		</section>
	</div>
</body>

<%@include file="footer.jsp"%>



<script>


$(document).ready(function() {
	
function getCategoryList(targetCategory) {
		
	//Call ProgramList
// 		console.log("getCategoryList is called..");
// 		console.log(targetCategory); 
		$(".programlist").attr("id", targetCategory);
		
		$.getJSON("/web/program/categoryList/" + targetCategory , function(data) {
// 			console.log(data);
			var str = "";
			$(data).each(function() { // foreach 개념으로 길이만큼 돈다.
					
			var openDateNum = new Date(this.opendate);
			var openDate = getFormatDate(openDateNum);
			
			var closeDateNum = new Date(this.closedate);
			var closeDate = getFormatDate(closeDateNum);

			str += "<li class='list-group-item takeprogramlist' data-pno='"+this.pno+"' data-groupid='"+this.persongroupid+"' style='cursor:pointer'><span class='glyphicon glyphicon-star-empty'></span>"
				+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.category+"</span>"
				+ "<span class=''>"+this.pcourse+"</span>"
				+ "<span class='text-muted' style='font-size: 11px;'>--" +openDate+"</span>"
				+"<span class='text-muted' style='font-size: 11px;'> ~ " +closeDate+"</span>"
				+ "<span class='badge'>"+this.maximum+"</span> <span class='pull-right'>" 
				+ "</span></li>";
			});
			$("#"+targetCategory).html(str);
		});
	};
	//End Call ProgramList
	
	//화면에 처음 들어오면 java탭의 ProgramList 나오기
	getCategoryList("java");
	
	
	//Tab을 클릭하면 맞는 리스트를 보여준다
	$(".subjectTab li").on("click", function(event) {
		event.preventDefault();
// 		console.log(event.target.name);
		var targetCategory = event.target.name;
		getCategoryList(targetCategory);
		$('#application').css('visibility' , 'hidden');
	});
	 
// 	//ProgramList에서 원하는 강좌를 클릭하면, 수강현황 DIV가 나옴
	$(".tab-content").on("click",".programlist .takeprogramlist", function (event) {
		event.preventDefault();
		console.log("click li");
		var takeProgram = event.currentTarget;
		var pno = takeProgram.dataset.pno;
		var groupid = takeProgram.dataset.groupid;
// 		console.log(takeProgram);
// 		console.log(pno); 
// 		console.log(groupid);
		$('#application').css('visibility' , 'visible');
		$('#selectstate').attr('data-pno',pno);
		$('#selectstate').attr('data-groupid',groupid);
		
		$("#admissionPno").attr('value', pno);
		$("#canclePno").attr('value',pno);
		$("#persongroupid").attr('value', groupid);
		$("#successList").attr('class','');
		$("#waitingList").attr('class','active');
		
		getWaitingList(pno); 
	});
	
	//대기자 명단 호출 함수
	function getWaitingList(pno){				
		$.getJSON("stateList/"+pno +"&&false", function(data){
			console.log("getWaitingList"+pno);
			console.log(data);
			showApplicationList(data);
		});		
	}
	
	//신청완료 명단 호출 함수
	function getCompletionList(pno) {
		$.getJSON("stateList/"+pno+"&&true" , function (data) {
			console.log(data);
			showApplicationList(data);
		});	
	} 

	
	// 신청 완료 리스트 버튼을 누르면
	$("#successList").on("click" , function(event){
		event.preventDefault();
		console.log("완료리스트 클릭");
		var pno = event.currentTarget.parentElement.dataset.pno;
		console.log(pno);
// 		console.log("groupid : " + groupid);

		
		var cancelBtn = $('#cancelBtn');
		cancelBtn.css('display','block');
		 
		var approvalBtn = $('#approvalBtn');
		approvalBtn.css('display','none');
		
		
		getCompletionList(pno);
	});
	
	//신청 리스트 버튼을 누르면
	$('#waitingList').on('click' , function(event){
		event.preventDefault();
		var pno = event.currentTarget.parentElement.dataset.pno;
		var cancelBtn = $('#cancelBtn');
		cancelBtn.css('display','none');
		 
		var approvalBtn = $('#approvalBtn');
		approvalBtn.css('display','block');
		getWaitingList(pno);
	});
	
	
	var result = '${result}';
	if(result =="success"){alert("변경 완료");}
	
	//수강신청 리스트 목록
	function showApplicationList(data){
		var resultStr = "";
		$(data).each(function(){
			 
			var tregDateStr = new Date(this.tregdate);
			var tregDate = getFormatDate(tregDateStr);
// 			console.log(tregDate);
		
			
			resultStr += "<a href=#" + this.pno +" class='list-group-item takeStudentList'> <span class='glyphicon glyphicon-star-empty'></span>"
			+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.sid+"</span>"
			+ "<span class='text-muted' style='font-size: 11px;'>--" +tregDate+"</span>"			
		    + "<span class='pull-right'><input type='checkbox' class='studentCheckBox' value='"+this.sid+"'></span>"; 
		});
		$('.studentList').html(resultStr);
	}
		
	//날짜 만들어주는거 yyyy/MM/dd
	function getFormatDate(date) {
		var year = date.getFullYear();
		var month = (1+date.getMonth());
		month = month >= 10 ? month : '0' + month;
		var day = date.getDate();
		day = day >=10 ? day : '0' + day;
		return year +"/"+month+"/"+day;
	}
	
	
	$("#approvalBtn").on("click", function (event) {
		var result = $('.studentCheckBox:checked');
		console.log(result[0].value);
		
		var sid = new Array();
		for(var  i = 0 ; i < result.length ; i++){
			sid[i] = result[i].value;
			$('#admission').append("<input type='hidden' name='sid' value='"+sid[i]+"'>");
		}
		
		$('#admission').submit();
	});
	
	$("#cancelBtn").on("click", function (event) {
		var result = $('.studentCheckBox:checked');
		console.log(result[0].value);
		
		var sid = new Array();
		for(var  i = 0 ; i < result.length ; i++){
			sid[i] = result[i].value;
			$('#cancel').append("<input type='hidden' name='sid' value='"+sid[i]+"'>");
		}
		
		$('#cancel').submit();
	});
		
});
</script>

</html>
