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
					<div class='pno'>pno</div> <a href="#" class='pcourse' title='pcourse'> pcourse </a>
					<div class='opendate'>opendate</div>
					<div class='closedate'>closedate</div>
					<div class='maximum'>maximum</div>
				</li>
			</ul>
		</div>
		</section>
	</div>

</body>

<%@include file="footer.jsp"%>



<script>

		function getProgramList() {
			$.getJSON("/program/allList", function(data) {
				console.log(data);
				console.log(data.length);   
				var str = "";
				$(data).each(function() {	// foreach 개념으로 길이만큼 돈다.
					str += "<li id='pno'>" 
					+	"<div class='pno'> pno :" + this.pno + "</div>" 
					+ "<a href=" + "#" + "lass='pcourse' title='pcourse'> pcourse :" + this.pcourse + "</a> "
					+ "<div class='opendate'> opendate :" + this.opendate + "</div>"
					+ "<div class='closedate'> closedate :" + this.closedate + "</div>"
					+ "<div class='maximum'> maximum :" + this.maximum + "</div>"
				+ "</li>" 
// 				this.pno + this.pcourse + this.roomname + this.torder;
					console.log("str : " + str);
// 					$("#programList").html(str);
					$(".threadTable").append(str);
				});
			});
		}
		
		getProgramList();
		
		
		
	

	
	
	
</script>

</html>