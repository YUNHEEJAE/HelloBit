<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div class="row">
				<div class="col-md-4">
					<div class="box box-primary">
						<div class="box-body no-padding">
							<div id="studentMypage" class="fc fc-ltr fc-unthemed">
								<p>${studentVO.sname }</p>
								<p></p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="box box-primary">
						<div class="box-body no-padding">

							<div id="calendar" class="fc fc-ltr fc-unthemed"></div>
						</div>
					</div>
				</div>
			</div>

		</section>
	</div>
</body>
<%@include file="footer.jsp"%>