<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer class="main-footer">
	<div class="pull-right hidden-xs">
		<b>Version </b>0.9
	</div>
	<strong>Copyright &copy; 2016-2017 <a
		href="https://github.com/YUNHEEJAE/HelloBit" target="_blank">Team KB141</a>.
	</strong> All rights reserved.
</footer>

<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
<div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="../resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
	$.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>

<!-- <script src="../resources/plugins/morris/morris.min.js"></script> -->
<!-- Sparkline -->
<script src="../resources/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script
	src="../resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
	src="../resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="../resources/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="../resources/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="../resources/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script
	src="../resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="../resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../resources/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<!-- <script src="../resources/dist/js/pages/dashboard.js"></script> -->
<!-- AdminLTE for demo purposes -->
<script src="../resources/dist/js/demo.js"></script>
<script src="../resources/plugins/fullcalendar/fullcalendar.min.js"></script>
<script src="../resources/plugins/chartjs/Chart.min.js"></script>
<script src="../resources/plugins/util/utils.js"></script>
<script>
	$(document).ready(function() {
		
		var red = "rgb(255,0,0)";
		var blue = "rgb(58,135,173)";
		
		$('#calendar').fullCalendar({
			header : {
				left :'prev,next',
				center : 'title',
				right : 'today'
// 				right : 'month,agendaWeek'
			},
		});

		$('#my-prev-button').click(function() {
			$('#calendar').fullCalendar('prev');
		});
		$('#my-next-button').click(function() {
			$('#calendar').fullCalendar('next');
		});
 
		$('#calendar').fullCalendar('addEventSource', [ 
			<c:forEach items="${checkTimeVO}" var="checkTimeVO">
			 { start : '<fmt:formatDate pattern="yyyy-MM-dd" value="${checkTimeVO.firsttime}"/>',
				 color : ${checkTimeVO.states},
				 title : '${checkTimeVO.states=='red'?'지각':'정상'}'
			 }, 
			</c:forEach> 
			]);
		
		
		
		function getFormatDate(date){
			var stringDate = new Date(date);
			var year = stringDate.getFullYear();
			var month= (1+stringDate.getMonth());
			month = month >=10?month:'0' + month;
			var day = stringDate.getDate();
			day=day>=10?day:'0'+day;
			return year+"-"+month+"-"+day;
		}
		 
		
		
		
	});
</script>
</body>
</html>
