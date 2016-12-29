<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>​​
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>



<body>
	<div class="content-wrapper" style="min-height: 976px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Program Register <small>Blank example to the boxed layout</small>
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
			<div class="col-md-12">
				<form method="post" id="inputForm">
					<!-- Text input-->



					<div class="form-group" style="width:420px;">
						<label class=" control-label">학생 아이디</label> <input id="pcourse"
							name="sid" type="text" placeholder="학생아이디"
							value="${studentVO.sid}" class="form-control" readonly="readonly">
					</div>

					<div class="form-group" style="width:420px;">
						<label class=" control-label">학생 이름</label> <input id="pcourse"
							name="sname" type="text" placeholder="학생이름"
							value="${studentVO.sname}" class="form-control" readonly="">
					</div>

					<div class="form-group" style="width:420px;">
						<label class=" control-label">학생 비밀번호</label> <input id="pcontent"
							name="spw" type="text" placeholder="학생비밀번호"
							value="${studentVO.spw}" class="form-control" readonly="">
					</div>

					<div class="form-group" style="width:420px;">
						<label class=" control-label">학생 이메일</label> <input id="pcontent"
							name="semail" type="text" placeholder="학생이메일"
							value="${studentVO.semail}" class="form-control" readonly="">
					</div>

					<div class="form-group" style="width:420px;">
						<label class=" control-label">과정</label> <input id="pcontent"
							name="category" type="text" placeholder="과정"
							value="${programVO.category}" class="form-control" readonly="">
					</div>

					<div class="form-group" style="width:420px;">
						<label class=" control-label">과정명</label> <input id="pcontent"
							name="pcourse" type="text" placeholder="과정명"
							value="${programVO.pcourse}" " ""${programVO.torder}
							기" class="form-control" readonly="">
					</div>

					<div class="form-group" style="width:420px;">
						<label class=" control-label">과정날짜</label> <input id="opdendate"
							name="date" type="text" placeholder="과정날짜"
							value="<fmt:formatDate value="${programVO.opendate}" pattern="yyyy-mm-dd HH:mm:ss ~"/>
							<fmt:formatDate value="${programVO.closedate}" pattern="yyyy-mm-dd HH:mm:ss"/>
							"
							 class="form-control" readonly="">
					</div>
					
					
		  <div class="col-md-6">
          <!-- LINE CHART -->
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Line Chart</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body chart-responsive">
              <div class="chart" id="line-chart" style="height: 300px;"></div>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

          <!-- BAR CHART -->
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">Bar Chart</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body chart-responsive">
              <div class="chart" id="bar-chart" style="height: 300px;"></div>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

        </div>
				


					<button type="button" class="btn btn-success" id="btnSuccess">success</button>
					<button type="button" class="btn btn-success" id="btnModify">Modify</button>
					<button type="button" class="btn btn-danger" id="btnRemove">Remove</button>
					<button type="button" class="btn btn-warning" id="btnCancel">Cancel</button>
				</form>

			</div>
		</div>
		</section>
	</div>



</body>

<%@include file="footer.jsp"%>

<!-- Bootstrap 3.3.6 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="../../plugins/morris/morris.min.js"></script>
<!-- FastClick -->
<script src="../../plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<script>
	$(document).ready(function() {
		$("#btnSuccess").hide();

		$("#btnModify").on("click", function() {
			console.log("변경잼");
			$("#btnSuccess").show();
			$("#btnModify").hide();
			$("#btnRemove").hide();
			$("#inputForm div input").attr("readonly", false).submit();
			$("#pcourse").attr("readonly", true).submit();
		});

		$("#btnSuccess").on("click", function() {
			$("#inputForm").attr("action", "studentmodify").submit();
		});

		$("#btnRemove").on("click", function() {
			if (confirm("정말삭제하시겠습니까?") == true) {

				$("#inputForm").attr("action", "studentRemove").submit();
			} else {
				return;
			}
		});

		$("#btnCancel").on("click", function() {
			event.preventDefault();
			history.back(1);
		});

	    //BAR CHART
	    var bar = new Morris.Bar({
	      element: 'bar-chart',
	      resize: true,
	      data: [
	        {y: '2006', a: 100, b: 90},
	        {y: '2007', a: 100, b: 100},
	        {y: '2008', a: 60, b: 40},
	        {y: '2009', a: 75, b: 65},
	        {y: '2010', a: 50, b: 40},
	        {y: '2011', a: 75, b: 65},
	        {y: '2012', a: 100, b: 90}
	      ],
	      barColors: ['#00a65a', '#f56954'],
	      xkey: 'y',
	      ykeys: ['a', 'b'],
	      labels: ['CPU', 'DISK'],
	      hideHover: 'auto'
	    });
		
	});
</script>

</html>
