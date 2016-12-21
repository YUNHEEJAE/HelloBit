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
	<h1>HERE IS STUDENT LIST</h1>
	<div class="row">
		<c:forEach items="${list}" var="StudentVO">
			<p>${StudentVO.sname}  ${StudentVO.sid}  ${StudentVO.spw}</p>
		</c:forEach>
	</div>
</body>
</html>