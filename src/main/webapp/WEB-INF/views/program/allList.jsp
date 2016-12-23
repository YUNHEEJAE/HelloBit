<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HERE IS PROGRAM LIST</h1>
	<div class="row">
		
	</div>
</body>

<script>
function getReplyList(page) {
	$.getJSON("/web/replies/" + bno + "/" + page, function(data) {
		console.log("DATALENGTH:"+data.list.length);
		var str = "";
		$(data.list).each(function() {
			var myDate = new Date(this.regdate);
			var strDate = myDate.toDateString().substr(3, 12);
			var strTime = myDate.toTimeString();

				str += "<div data-rno='"+this.rno+"' class='replyLi'>"
						+ "<div><h4>"+ this.rwriter+ "</h4></div>"
						+ "<div>"+ strDate + "</div>"
						+ "<div class='row'><div class='col-xs-6' data-rcontent='"+this.rcontent+"'>"
						+ this.rcontent
						+ "</div>"
						+ "<div  class='col-xs-3'><button class='btn btn-primary btn-xs' id='replyModBtn'>수정</button>"
						+ "<button class='btn btn-primary btn-xs' id='replyDelBtn'>x</button></div></div>"
						+ "<div id='modDiv' class='hide col-md-12 form-group'><div class='col-xs-6  form-inline'><input type='text' id='rcontent' name='rcontent'class='form-control  input-sm'><input type='text' id='rpw' name='rpw' class='form-control input-sm' ></div><div class=''><button type='button' id='replyModSubmit' class='btn btn-default btn-xs'>확인</button><button type='button' id='replyModCancle' class='btn btn-default btn-xs'>취소</button></div></div></div> </div>";
											//						"<li data-rno='"+this.rno+"' class='replyLi'>"
											//						+ this.rwriter + ":" + this.rcontent + "</li></div>";
										});
						$("#replies").html(str);
						printPaging(data.pageMaker);
					});
}
getReplyList(endPage);

</script>

</html>