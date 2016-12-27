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

<h1></h1>
<div class="row">
	<div id="programList"></div>
</div>
<body>
	<div class="content-wrapper" style="min-height: 976px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Program List <small>Blank example to the boxed layout</small>
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
			<div class="col-sm-9 col-md-12">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs subjectTab">
					<li class="active"><a href="#java" data-toggle="tab" name='java'> <span class="glyphicon glyphicon-th-list"></span>JavaDB
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
				<!-- Tab panes -->
				<div class="tab-content">
					<div class="tab-pane programlist active in" id="java" ></div>

				</div>
			</div>
		</div>

		<div class="row state" style="visibility: hidden">	
					<div class="col-sm-9 col-md-12">
<<<<<<< HEAD
						<ul class="nav nav-tabs subjectTab">
							<li class="active"><a href="#false" data-toggle="tab" id='falseList'><span class="glyphicon glyphicon-th-list"></span> 수강 신청 리스트 </a></li>
							<li><a href="#true" data-toggle="tab" id="successList"><span class="glyphicon glyphicon-th-list"></span> 수강 신청 완료 리스트</a></li>
=======
						<ul class="nav nav-tabs enrolmentTab">
							<li class="active"><a href="#beginner" data-toggle="tab" ><span class="glyphicon glyphicon-th-list"></span> 수강 신청 리스트 </a></li>
							<li><a href="#true" data-toggle="tab"><span class="glyphicon glyphicon-th-list"></span> 수강 신청 완료 리스트</a></li>
>>>>>>> branch 'master' of https://github.com/YUNHEEJAE/HelloBit.git
						</ul>
							<div class="tab-content">
								<div class="tab-pane programlist active in" id="java" ></div>
							</div>
					</div>
		</div>
		<ul class="stateList"></ul>
			<button id="trueBtn" class="btn btn-block btn-success btn-lg" style="visibility: hidden">승 인 </button>
			<form id='admission' action="../faculity/admission" method="post">
<<<<<<< HEAD
			<!-- 	<input type="hidden" name="state" value="false"> -->
			</form>
			<form id='cancel' action="../faculity/cancel" method="post">
		<!-- 		<input type="hidden" name="state" value="true"> -->
=======
>>>>>>> branch 'master' of https://github.com/YUNHEEJAE/HelloBit.git
			</form>
		</section>
	</div>


</body>

<%@include file="footer.jsp"%>



<script>


$(document).ready(function() {
	
		var result = '${result}';
	
			if(result == "success"){alert("수강신청완료");}

				
				function getFalseList(formData){				
					$.getJSON("stateList/"+formData.get("state")+"&&" + formData.get("pno"), function(data){
						console.log(data);
							showList(data);
						
					});		
				}	
				function getTrueList(pno) {
					$.getJSON("stateList/true&&" + pno , function (data) {
						console.log(data);
						showList(data);
					});	
				}
			
			function showList(data){
				var resultStr = "";
				$(data).each(function(){												
					resultStr += "<a href=#" + this.pno +" class='list-group-item takeprogramlist'> <span class='glyphicon glyphicon-star-empty'></span>"
					+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.sid+"</span>"
					+ "<span class='text-muted' style='font-size: 11px;'>--" +this.tregdate+"</span>"			
				    + "<span class='pull-right'><input type='checkbox' class='check' value='"+this.sid+"'></span>"; 
					
				});
				$('.stateList').html(resultStr);

			}
			
			
			
			
			
			
			
		function getProgramList() {
			$.getJSON("/web/program/allList", function(data) {
				console.log(data);
				console.log(data.length);
				var str = "";
				$(data).each(function() { // foreach 개념으로 길이만큼 돈다.
					str += ""
// 					this.pno + this.pcourse + this.roomname + this.torder;
					console.log("str : " + str);
// 					$("#programList").html(str);
					$(".threadTable").append(str);
				});
			});
		}

		getProgramList();

		function getCategoryList(targetCategory) {

			console.log("getCategoryList is called..")
			console.log(targetCategory);
			$(".programlist").attr("id", targetCategory);
			
			$.getJSON("/web/program/categoryList/" + targetCategory , function(data) {
				console.log(data);

				$(document).ready(function () {
					var str = "";
					$(data).each(function() { // foreach 개념으로 길이만큼 돈다.
						
						var openDateNum = new Date(this.opendate);
						var openyear = openDateNum.getFullYear();
						var openmonth =openDateNum.getMonth();
						var opendate =  openDateNum.getDate();
						var openDate = openyear + "/" + openmonth + "/" + opendate;
						
						var closeDateNum = new Date(this.closedate);
						var closeyear = closeDateNum.getFullYear();
						var closemonth =closeDateNum.getMonth();
						var closedate =  closeDateNum.getDate();
						var closeDate = closeyear + "/" + closemonth + "/" + closedate;

						str += "<a href='#" + this.pno +"' class='list-group-item takeprogramlist'> <span class='glyphicon glyphicon-star-empty'></span>"
							+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.category+"</span>"
							+ "<span class=''>"+this.pcourse+"</span>"
							+ "<span class='text-muted' style='font-size: 11px;'>--" +openDate+"</span>"
							+"<span class='text-muted' style='font-size: 11px;'> ~ " +closeDate+"</span>"
							+ "<span class='badge'>"+this.maximum+"</span> <span class='pull-right'>"
							+ " </span>";
					});
					$("#"+targetCategory).html(str);
					
					
<<<<<<< HEAD
									$("a").on("click" , function(event){
=======
					$("a").on("click" , function(event){	
						console.log(event);
						
						var hash = event.currentTarget.hash;
						var pno =	hash.split("#");
						
						var formdata = new FormData();
						
							formdata.append("pno",pno);
							formdata.append("state","false");
							console.log(formdata);
						
						
						$.ajax({
							url:"http://localhost:8081/web/faculity/statelist",
							type:"get",
							data:formdata,
							datatype:"json",
							success:function(result){
								console.log(result);
								$('.state').css('visibility' , 'visible');
								$('#trueBtn').css('visibility' , 'visible');
										resultStr = "";
											$(result).each(function(){												
												resultStr += "<a href=#" + this.pno +" class='list-group-item takeprogramlist'> <span class='glyphicon glyphicon-star-empty'></span>"
												+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.sid+"</span>"
												+ "<span class=''>"+this.state+"</span>"
												+ "<span class='text-muted' style='font-size: 11px;'>--" +this.tregdate+"</span>"			
											    + "<span class='pull-right'><input type='checkbox' class='check' value='"+this.sid+"'></span>"; 
												
											});
											$('.stateList').html(resultStr);
>>>>>>> branch 'master' of https://github.com/YUNHEEJAE/HelloBit.git
										
<<<<<<< HEAD
										var hash = event.currentTarget.hash;	
										var hashPno =	hash.split("#");	
										var pno = hashPno[1];	
										console.log(pno);
										
										var obj = {"pno" : pno , "state" : "false"};
										
										$('.state').css('visibility' , 'visible');
										$('#trueBtn').css('visibility' , 'visible');
										
												getFalseList(obj);
									
											$('#falseList').on('click' , function(){
												console.log(pno);
												
												console.log(event.target.name);
												console.log($('#trueBtn')[0]);
												var btn = $('#trueBtn');
												btn.html('승인');
												
													getFalseList(pno);
												// 승인 버튼 
												$('#trueBtn').on('click' , function(event){
=======
											$('#trueBtn').on('click' , function(event){			
												var result = $('.check:checked');												
												console.log(result[0].attributes.value.value);
												var sid = new Array();
												 $('#admission').append("<input type='hidden' name='pno' value='"+pno[1]+"'>") 
												for(var  i = 0 ; i < result.length ; i++){
													sid[i] = result[i].attributes.value.value;
													$('#admission').append("<input type='hidden' name='sid' value='"+sid[i]+"'>");
>>>>>>> branch 'master' of https://github.com/YUNHEEJAE/HelloBit.git
													
<<<<<<< HEAD
													var result = $('.check:checked');												
													console.log(result[0].attributes.value.value);
													var sid = new Array();
													 $('#admission').append("<input type='hidden' name='pno' value='"+pno[1]+"'>") 
													for(var  i = 0 ; i < result.length ; i++){
														sid[i] = result[i].attributes.value.value;
														$('#admission').append("<input type='hidden' name='sid' value='"+sid[i]+"'>");			
													}
													 $('#admission').submit(); 
												});
											});
=======
												}
												 $('#admission').submit(); 
											});
							}
							
						});
>>>>>>> branch 'master' of https://github.com/YUNHEEJAE/HelloBit.git
						
<<<<<<< HEAD
								// 취소 버튼 
												 $("#successList").on("click" , function(event){
													 $('#successList').attr('href' , pno);
														console.log(event.target.name);
														console.log($('#trueBtn')[0]);
														var btn = $('#trueBtn');
														btn.html('취소');
														
															getTrueList(pno);
																
															$('#trueBtn').on('click' , function(event){			
																var result = $('.check:checked');												
																console.log(result[0].attributes.value.value);
																var sid = new Array();
																 $('#cancel').append("<input type='hidden' name='pno' value='"+pno[1]+"'>") 
																for(var  i = 0 ; i < result.length ; i++){
																	sid[i] = result[i].attributes.value.value;
																	$('#cancel').append("<input type='hidden' name='sid' value='"+sid[i]+"'>");
																	
																}
																 $('#cancel').submit(); 
															}); //end true btn
														}); // end successList				
													}); // end a click
						});  // end docs
					});  // end getJson
			} // end category list
=======
					});
					
					
					
				});
			});
		}
		
		
>>>>>>> branch 'master' of https://github.com/YUNHEEJAE/HelloBit.git
		getCategoryList("java");
		
		$(".subjectTab li").on("click", function(event) {
			console.log(event.target.name);
			var targetCategory = event.target.name;
			getCategoryList(targetCategory);
		});

	
		$(".list-group-item takeprogramlist").on("click", function(event){
				console.log(event);
		});
		

		
		/* $(".enrolmentTab li").on("click" , function(event){
			console.log(event.target.name);
			$.getJson("web/faculity/stateList/"+"true" + "&&" +"1" , function (data) {
				console.log(data);
			});
			
		}); */
		
});
</script>

</html>
