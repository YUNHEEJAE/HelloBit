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


						<ul class="nav nav-tabs selectstate">
							<li class="active" id='falseList'><a href="#false" data-toggle="tab" ><span class="glyphicon glyphicon-th-list"></span> 수강 신청 리스트 </a></li>
							<li id="successList"><a href="#true" data-toggle="tab" ><span class="glyphicon glyphicon-th-list"></span> 수강 신청 완료 리스트</a></li>

						</ul>
							<div class="tab-content">
								<div class="tab-pane programlist active in" id="java" ></div>
							</div>
					</div>
		</div>
		<ul class="stateList"></ul>
			<button id="trueBtn" class="btn btn-block btn-success btn-lg" style="visibility: hidden">승 인 </button>
			<form id='admission' action="../faculity/admission" method="post">

			<!-- 	<input type="hidden" name="state" value="false"> -->
			</form>
			<form id='cancel' action="../faculity/cancel" method="post">
		<!-- 		<input type="hidden" name="state" value="true"> -->

			</form>
		</section>
	</div>


</body>

<%@include file="footer.jsp"%>



<script>


$(document).ready(function() {
	
		var result = '${result}';

			if(result =="success"){alert("변경 완료");}

				function getFalseList(obj){				
					$.getJSON("stateList/"+obj.pno +"&&false", function(data){
						console.log(data);
							showList(data);
						
					});		
				}	
				function getTrueList(obj) {
					$.getJSON("stateList/"+obj.pno+"&&true" , function (data) {
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

						str += "<a href='#" + this.pno +"' class='list-group-item takeprogramlist' value='"+this.persongroupid+"'> <span class='glyphicon glyphicon-star-empty'></span>"
							+ " <span class='name' style='min-width: 120px; display: inline-block;'>"+this.category+"</span>"
							+ "<span class=''>"+this.pcourse+"</span>"
							+ "<span class='text-muted' style='font-size: 11px;'>--" +openDate+"</span>"
							+"<span class='text-muted' style='font-size: 11px;'> ~ " +closeDate+"</span>"
							+ "<span class='badge'>"+this.maximum+"</span> <span class='pull-right'>"
							+ " </span>";
					});
					$("#"+targetCategory).html(str);
					
					
					$(".programlist > .takeprogramlist").on("click" , function(event){	
						console.log(event);
						console.log(event.currentTarget.attributes.value.value);
						$('.state').css('visibility' , 'visible');
						$('#trueBtn').css('visibility' , 'visible');

								var groupid = event.currentTarget.attributes.value.value;
								var hash = event.currentTarget.hash;	
								var hashPno =	hash.split("#");	
								var pno = hashPno[1];
								var obj = {"pno" : pno}; 
									console.log(pno);
									getFalseList(obj);  
									trueButton(pno , groupid);	
										$('#falseList').on('click' , function(){
													console.log(pno);
														
													console.log(event.target.name);
													console.log($('#trueBtn')[0]);
													var btn = $('#trueBtn');
													btn.html('승인');
													console.log("groupid : " + groupid);	
													getFalseList(pno);
														// 승인 버튼 
													trueButton(pno , groupid);
												});
								
										$('#falseList').on('click' , function(event){
											console.log("groupid : " + groupid);	
											event.preventDefault();
											console.log(event);
											$('#falseList >  a').attr("href" , pno);
											var btn = $('#trueBtn');
											btn.html('승인');
												
											getFalseList(obj);
											
											trueButton(pno , groupid);
				
													// 취소 버튼 
											$("#successList").on("click" , function(event){
												console.log("groupid : " + groupid);	
												event.preventDefault();
												var btn = $('#trueBtn');
												btn.html('취소');
												
												getTrueList(obj);
														
													$('#trueBtn').on('click' , function(event){	
														event.preventDefault();
														var result = $('.check:checked');												
														console.log(result[0].attributes.value.value);
														var sid = new Array();
														 $('#cancel').append("<input type='hidden' name='pno' value='"+pno+"'>") 
														for(var  i = 0 ; i < result.length ; i++){
															sid[i] = result[i].attributes.value.value;
															$('#cancel').append("<input type='hidden' name='sid' value='"+sid[i]+"'>");
															
														}
														 $('#cancel').submit(); 
														 });
												}); // end a click
										});  // end docs
					
									}); // end 
															
					
					
					
					
				});  
				
			});
		}
		getCategoryList("java");

/* 
				$("takeprogramlist").on("click" , function(event){	
					console.log(event.currentTarget.attributes.value.value);

					$('.state').css('visibility' , 'visible');
					$('#trueBtn').css('visibility' , 'visible');

							var groupid = event.currentTarget.attributes.value.value;
							var hash = event.currentTarget.hash;	
							var hashPno =	hash.split("#");	
							var pno = hashPno[1];
							var obj = {"pno" : pno}; 
								console.log(pno);
								getFalseList(obj);  
								trueButton(pno , groupid);	
									$('#falseList').on('click' , function(){
												console.log(pno);
													
												console.log(event.target.name);
												console.log($('#trueBtn')[0]);
												var btn = $('#trueBtn');
												btn.html('승인');
												console.log("groupid : " + groupid);	
												getFalseList(pno);
													// 승인 버튼 
												trueButton(pno , groupid);
											});
							
									$('#falseList').on('click' , function(event){
										console.log("groupid : " + groupid);	
										event.preventDefault();
										console.log(event);
										$('#falseList >  a').attr("href" , pno);
										var btn = $('#trueBtn');
										btn.html('승인');
											
										getFalseList(obj);
										
										trueButton(pno , groupid);
			
												// 취소 버튼 
										$("#successList").on("click" , function(event){
											console.log("groupid : " + groupid);	
											event.preventDefault();
											var btn = $('#trueBtn');
											btn.html('취소');
											
											getTrueList(obj);
													
												$('#trueBtn').on('click' , function(event){	
													event.preventDefault();
													var result = $('.check:checked');												
													console.log(result[0].attributes.value.value);
													var sid = new Array();
													 $('#cancel').append("<input type='hidden' name='pno' value='"+pno+"'>") 
													for(var  i = 0 ; i < result.length ; i++){
														sid[i] = result[i].attributes.value.value;
														$('#cancel').append("<input type='hidden' name='sid' value='"+sid[i]+"'>");
														
													}
													 $('#cancel').submit(); 
													 });
											}); // end a click
									});  // end docs
				
								}); // end 
															
										
					// end getJson
				
			// end category list */

		
		
			
		function trueButton(pno , groupid){
			
			$('#trueBtn').on('click' , function(event){		
				event.preventDefault();
				console.log(event);
				var result = $('.check:checked');												
				console.log(result[0].attributes.value.value);
				var sid = new Array();
							
				$('#admission').append("<input type='hidden' name='pno' value='"+pno+"'>") 
				$('#admission').append("<input type='hidden' name='groupid' value='"+groupid+"'>")
					for(var  i = 0 ; i < result.length ; i++){
						sid[i] = result[i].attributes.value.value;
						$('#admission').append("<input type='hidden' name='sid' value='"+sid[i]+"'>");			
					}
					$('#admission').submit(); 
				});
			}
	
		$(".subjectTab li").on("click", function(event) {
			event.preventDefault();
			console.log(event.target.name);
			var targetCategory = event.target.name;
			getCategoryList(targetCategory);
		});

	
	/* 	$(".list-group-item takeprogramlist").on("click", function(event){
				event.preventDefault();
				console.log(event);
		}); */

		
});
</script>

</html>
