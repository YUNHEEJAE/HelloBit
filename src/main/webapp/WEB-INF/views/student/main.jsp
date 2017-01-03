<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<body>

	<div class="content-wrapper" style="min-height: 943px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				My Page <small>Preview sample</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="#">Charts</a></li>
				<li class="active">ChartJS</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row row-eq-height">
				<div class="col-md-3">
					<div class="box box-primary ">
						<div class="box-body box-profile" style="text-align: center;">
							<div class="profileStudent">
								<img id="profileImg" class="img-responsive"
									src="http://pds26.egloos.com/pds/201212/24/34/a0085634_50d858d263333.jpg">

								<h3 class="profile-username text-center">${studentVO.sname }</h3>
								<p class="text-muted">${studentVO.semail}<br />
								</p>
								<p>${programVO.pcourse }</p>
							</div>
						</div>
					</div>
				</div>
				<!-- 				<div class="col-md-9"> -->
				<!-- 					<div class="row"> -->
				<div class="col-md-3 checkedBoxOuter">
					<div class="box box-success checkedBox">
						<div class="box-header with-border">
							<h3 class="box-title" style=" font-size: 20px">Attend</h3>
						</div> 
						<div class="checkedBoxBody">
							<div class="box-body"
								style="color: #00A65A; font-weight: 700; font-size: 100px; text-align: center; vertical-align: middle;">2</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 checkedBoxOuter">
					<div class="box box-warning checkedBox">
						<div class="box-header with-border">
							<h3 class="box-title" style=" font-size: 20px">Late</h3>
						</div>
						<div class="checkedBoxBody">
							<div class="box-body" 
								style="color: #F39C12; font-weight: 700; font-size: 100px; text-align: center; vertical-align: middle;">
								0</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 checkedBoxOuter">
					<div class="box box-danger checkedBox ">
						<div class="box-header with-border">
							<h3 class="box-title" style=" font-size: 20px">Absent</h3>
						</div>
						<div class="checkedBoxBody">
							<div class="box-body "
								style="color: #DD4B39; font-weight: 700; font-size: 100px; text-align: center; vertical-align: middle;">
								0</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="box box-default">
						<div class="box-body no-padding"></div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="box box-default">
						<div class="box-body no-padding">
							<div id="calendar" class="fc fc-ltr fc-unthemed"></div>
						</div>
					</div>
				</div>
				<!-- 					</div> -->
				<!-- 				</div> -->
			</div>

		</section>
	</div>
</body>
<%@include file="footer.jsp"%>