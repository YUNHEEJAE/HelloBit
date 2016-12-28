<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../program/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/resources/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/resources/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Version 2.0</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>

<div class="register-box">
   <div class="register-logo">
     <a href="../../index2.html"><b>회원가입</b>하기</a>
   </div>

   <div class="register-box-body">
     <p class="login-box-msg">Register a new Student</p>

     <form  method="post" id="regForm" action="register">
       <div class="form-group has-feedback">
         <input type="text" class="form-control" placeholder="USER ID" name="sid" id="userid" value="uid">
         <span class="glyphicon glyphicon-info-sign form-control-feedback"></span>
       </div>
       <div class="form-group has-feedback">
         <input type="password" class="form-control" placeholder="USER Password" name="spw" value="uipw">
         <span class="glyphicon glyphicon-lock form-control-feedback"></span>
       </div>
       <div class="form-group has-feedback">
         <input type="text" class="form-control" placeholder="Full name" name ="sname" value="uiname">
         <span class="glyphicon glyphicon-user form-control-feedback"></span>
       </div>
       <div class="form-group has-feedback">
         <input type="email" class="form-control" placeholder="Email" name ="semail" value="uid@name.com">
         <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
       </div>
       <input type="hidden" name ="filename" id="hiddenFile">
     </form>
   
     <div class="form-group has-feedback">
       <input type="file" class="form-control" id="file" >
       <span class="glyphicon glyphicon-send form-control-feedback"></span>
        <input type="hidden" class="form-control" name="sid" id="hiddenid">
     </div>
     
     <div class="row">

         <!-- /.col -->
         <div >
           <button class="btn btn-primary btn-block btn-flat" id="regBtn">Register</button>
         </div>
         <!-- /.col -->
       </div>



   </div>
   <!-- /.form-box -->
 </div>

    </section>
  </div>
<%@include file="../program/footer.jsp"%>
<!-- jQuery 2.2.3 -->
<script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/resources/dist/js/app.min.js"></script>
<!-- Sparkline -->
<script src="/resources/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS 1.0.1 -->
<script src="/resources/plugins/chartjs/Chart.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/resources/dist/js/pages/dashboard2.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/resources/dist/js/demo.js"></script>
<script>


	
	$('#regBtn').on("click" , function(event){

			event.preventDefault();
		
			console.log(event);
		
			var userid = $('#userid').val();
			console.log(userid);
			
			var image = $('#file')[0].files[0];

			console.log(image);
			
			$('#hiddenid').attr("value" , userid);
		
			var formdata = new FormData();
			
			
			formdata.append("sid" , userid);
			formdata.append("file" , image); 
			
			console.log(formdata);
			
			
				$.ajax({
					url : "http://localhost:8081/web/image/registerImage",
					data :formdata,
					type:"post",
					contentType:false,
					processData : false,
					success: function(result){
						console.log(result);
						
						$('#hiddenFile').attr("value" , result);
						
						 $('#regForm').submit();   
						
					}
					
						
				}); 
				
				
			
	});
	


</script>






</body>
</html>
         