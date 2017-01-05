<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title> HelloBit | 교사페이지 </title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="../resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../resources/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="../resources/dist/css/lsy.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="../resources/dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="../resources/plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet" href="../resources/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="../resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet"
	href="../resources/plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="../resources/plugins/daterangepicker/daterangepicker.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="../resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-purple sidebar-mini">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="#" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>Me</b>nu</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Hello</b>bit</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel" style ="height:65px">
					<div class="pull-left image">
						<img src="http://pds26.egloos.com/pds/201212/24/34/a0085634_50d858d263333.jpg"
							class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						<p>${cookie.LOGIN_ID.value }</p>
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>
				
				
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="header">강사 ${cookie.LOGIN_ID.value }님 환영합니다.</li>
					
					
					<li class="active treeview" id="treeTeacher"><a href="#"> 
					<i class="fa fa-align-justify text-red"></i> <span> 강의 정보</span>
					
					<span class="pull-right-container"> 
					<i class="fa fa-angle-left pull-right"></i>
					</span></a>
						
						<ul class="treeview-menu">
						</ul>
					</li>
					<li><a href="/web/myLogout"><i class="fa fa-sign-out text-red"></i> <span>LOG-OUT</span></a></li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>
		
