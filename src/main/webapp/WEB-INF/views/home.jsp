<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
	
		
	<p id="demo">${dateTempParse }</p>
	
</h1>

<P>  The time on the server is ${serverTime}. </P>

<script>
// 	document.getElementById("demo").innerHTML = 
// 		new Date("Wed Mar 25 2015 09:56:24 GMT+0100 (W. Europe Standard Time)");
// 		Date.parse("Wed Dec 21 09:56:24 KST 2016");
</script>
</body>
</html>
