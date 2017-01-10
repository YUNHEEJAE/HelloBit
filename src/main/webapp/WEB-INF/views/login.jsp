<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<body class="hold-transition login-page ext-webkit ext-chrome"
	id="syno-nsc-ext-gen3">
	<div class="login-box">
		<div class="login-logo">
			<a href="login.html"><b>Hello </b>Bit</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">로그인 해주세요</p>



			<form action="loginProcess" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" placeholder="ID" name="login_id">
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="Password" name="login_pw">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					 <div class="col-xs-8"> 
						<!-- <div class="checkbox icheck">
							<label class="">
								<div class="icheckbox_square-blue" aria-checked="false" aria-disabled="false" style="position: relative;">
									<input type="checkbox"
										style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;">
									<ins class="iCheck-helper"
										style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
								</div> Remember Me
							</label>
						</div> -->
					</div> 
					
					
					<!-- /.col -->
					<div class="col-xs-4 " >
						<button type="submit" class="btn btn-primary btn-block btn-flat">로그인</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

<!-- 			 <a href="register.html" -->
<!-- 				class="text-center">Register a new membership</a> -->

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->
<%@include file="footer.jsp"%>