<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>HERE IS CHATTING PAGE....</h1>
	<input type="text" id="message" />
	<input type="button" id="sendMessage" value="SEND" />
	<div id="chatMessage" style="overflow: auto; max-height: 500px;"></div>

</body>
<script src="../resources/js/jquery-3.1.1.min.js"></script>
<script src="../resources/js/sockjs-1.1.1.min.js"></script>
<script>
	var sock = null;

	$(document).ready(function() {
		// 			alert("안녕");

		sock = new SockJS("/web/logWebsocket");
		sock.onopen = function(event) {
				console.log(event);
				
				sock.onmessage = function(event) {
					console.log(event);
				}
				
				
		}
		
		sock.onmessage = function(event) {
			console.log(11111);
			console.log(event.data);
			$("#chatMessage").append(event.data + "<br/>");
		}
		sock.onclose = function() {
			sock.send("퇴장");
		}

		$("#sendMessage").click(function() {
			// 			sock.send("반갑습니다.");
			// 			$("#chatMessage").append("Hello~<br/>");
				if($("#message").val()!=""){
					sock.send($("#message").val());
					$("#chatMessage").append("나 : " + $("#message").val() + "<br/>");
					$("#message").val("");
			}
		})
	});
</script>
</html>