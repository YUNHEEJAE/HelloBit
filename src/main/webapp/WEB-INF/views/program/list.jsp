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
		<div class="ThreadListCont">
			<ul class='threadTable'>
				<li id='pno'>
					<div class='pno'>pno</div> <a href="#" class='pcourse'
					title='pcourse'> pcourse </a>
					<div class='opendate'>opendate</div>
					<div class='closedate'>closedate</div>
					<div class='maximum'>maximum</div>
				</li>
			</ul>
		</div>
		</section>
		
		
		
		<!-- 내가  -->
		<section class="content">
	    <hr />
	    <div class="row">
	        <div class="col-sm-9 col-md-12">
	            <!-- Nav tabs -->
	            <ul class="nav nav-tabs">
	                <li class="active">
	                	<a href="#home" data-toggle="tab">
	                		<span class="glyphicon glyphicon-inbox"></span>Primary
	                	</a>
	                </li>
	                <li><a href="#profile" data-toggle="tab"><span class="glyphicon glyphicon-user"></span>
	                    Social</a></li>
	                <li><a href="#messages" data-toggle="tab"><span class="glyphicon glyphicon-tags"></span>
	                    Promotions</a></li>
	                <li><a href="#settings" data-toggle="tab"><span class="glyphicon glyphicon-plus no-margin">
	                </span></a></li>
	            </ul>
	            <!-- Tab panes -->
	            <div class="tab-content">
	                
	                
	                <div class="tab-pane fade in active" id="home">
	                    <div class="list-group">
	                        <a href="#" class="list-group-item">
	                            <span class="glyphicon glyphicon-star-empty"></span>
	                            <span class="name" style="min-width: 120px; display: inline-block;">JAVA 88</span>
	                          	<span class="">JAVA 88기 고급 Web Developer</span>
	                            <span class="text-muted" style="font-size: 11px;">- 잘 배우는 방법</span>
	                            <span class="badge">12:10 AM</span>
	                            <span class="pull-right">
	                            	<span class="glyphicon glyphicon-paperclip"></span>
	                            </span>
                            </a>
                            <a href="#" class="list-group-item">
	                            <span class="glyphicon glyphicon-star-empty"></span>
	                            <span class="name" style="min-width: 120px; display: inline-block;">JAVA 88</span>
	                          	<span class="">JAVA 88기 중급 Web Developer</span>
	                            <span class="text-muted" style="font-size: 11px;">- 잘 못 배우는 방법</span>
	                            <span class="badge">12:10 AM</span>
	                            <span class="pull-right">
	                            	<span class="glyphicon glyphicon-paperclip"></span>
	                            </span>
                            </a>
	                    </div>
	                </div>
	                
	                
	                <div class="tab-pane fade in" id="profile">
	                    <div class="list-group">
	                        <div class="list-group-item">
	                            <span class="text-center">This tab is empty.</span>
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane fade in" id="messages">
	                    ...</div>
	                <div class="tab-pane fade in" id="settings">
	                    This tab is empty.</div>
	            </div>
	           
	        </div>
	    </div>
		
		
		<!-- 내가  -->
			
		
			
			
			</section>
	</div>
	
	
	

</body>
<%@include file="footer.jsp"%>
<script>
	function getProgramList() {
		$.getJSON("/web/program/allList", function(data) {
			console.log(data);
			console.log(data.length);
			var str = "";
			$(data).each(function() {
				str += this.pno + this.pcourse + this.roomname + this.torder
				$("#programList").html(str);
			});
		});
	}
	getProgramList();
</script>

</html>