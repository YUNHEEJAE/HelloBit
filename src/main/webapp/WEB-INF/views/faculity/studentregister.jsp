<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://www.gstatic.com/firebasejs/3.6.2/firebase.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
</head>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
		</h1>
	</section>
	<section class="content">
		<div class="register-box">
			<div class="register-logo">
				<a href="../../index2.html"><b>회원가입</b>하기</a>
			</div>
	
			<div class="register-box-body">
				<p class="login-box-msg">Register a new Student</p>
	
				<form method="post" id="regForm" action="studentregister">
					<div class="form-group has-feedback">
						<input type="text" class="form-control not-null" placeholder="USER ID"
							name="sid" id="userid" > <span
							class="glyphicon glyphicon-info-sign form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control not-null"
							placeholder="USER Password" name="spw"> <span
							class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="text" class="form-control not-null" placeholder="Full name"
							name="sname" > <span
							class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="email" class="form-control not-null" placeholder="Email"
							name="semail"> <span
							class="glyphicon glyphicon-envelope form-control-feedback"></span>
					</div>
					<input type="hidden" name="filename" id="hiddenFile">
				</form>
	
				<div class="form-group has-feedback">
					<input type="file" class="form-control" id="file"> <span
						class="glyphicon glyphicon-send form-control-feedback"></span> <input
						type="hidden" class="form-control" name="sid" id="hiddenid">
				</div>
	
				<div class="row">
	
					<!-- /.col -->
					<div>
						<button class="btn btn-danger btn-block btn-flat" id="regBtn">가 입</button>
					</div>
					<!-- /.col -->
				</div>
			</div>
			<!-- /.form-box -->
		</div>
	</section>
</div>
<%@include file="footer.jsp"%>
<!-- ChartJS 1.0.1 -->
<!-- <script src="/resources/plugins/chartjs/Chart.min.js"></script> -->
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<!-- <script src="/resources/dist/js/pages/dashboard2.js"></script> -->
<!-- AdminLTE for demo purposes -->
<!-- <script src="/resources/dist/js/demo.js"></script> -->
<script>
$(document).ready(function(){

	var config = {
            apiKey: "AIzaSyD8Qs39vkxQw8pdWiXlkcMug3PL1YJeS0Q",
            authDomain: "hhkbex.firebaseapp.com",
            databaseURL: "https://hhkbex.firebaseio.com",
            storageBucket: "hhkbex.appspot.com",
            messagingSenderId: "1050382686499"
        };
        firebase.initializeApp(config);

        // Get a reference to the storage service, which is used to create references in your storage bucket
        var storage = firebase.storage();
// Create a storage reference from our storage service
        var storageRef = storage.ref();
        var uid = "jk3a0123@gmail.com";
        var upw = "wjdwndud08";
     
        firebase.auth().signInWithEmailAndPassword(uid , upw).catch(function (error) {
           
            console.log('error sign');
            var errorCode = error.code;
            var errorMessage = error.message;
        }); // end login  

	$('#regBtn').on("click" , function(event){

			event.preventDefault();
			
			var isnull = false;
			
			
			$(".not-null").each(function () {
				if($(this).val() == "") {
					isnull = true;
				}
				console.log($(this).val());
			});
			
			if(isnull == true) {
				alert("모든 입력란을 채워주세요.");
			} else {
				
				var userid = $('#userid').val();
				var image = $('#file')[0].files[0];
				$('#hiddenid').attr("value" , userid);
				console.log(userid);
				console.log(image);
				// upload firebase img
	            var upload = storageRef.child("member/" +userid+"_0.jpg");
	            var uploadTask = upload.put(image);
	            uploadTask.on('state_changed', function(snapshot){
	                // Observe state change events such as progress, pause, and resume
	                // See below for more detail
	            }, function(error) {
	                // Handle unsuccessful uploads
	            }, function() {
	                // Handle successful uploads on complete
	                // For instance, get the download URL: https://firebasestorage.googleapis.com/...
				 $('#regForm').submit();  
	                var downloadURL = uploadTask.snapshot.downloadURL;
	            });

				
				/* $.ajax({
					url : "http://localhost:8081/web/image/registerImage?${_csrf.parameterName}=${_csrf.token}",
					data :formdata,
					type:"post",
					contentType:false,
					processData : false,
					success: function(result){
						console.log(result);
						
						$('#hiddenFile').attr("value" , result); */
						
						
						
		/* 
					}

				}); 
	 */
				
			}
			
	});

});

</script>






</body>
</html>
