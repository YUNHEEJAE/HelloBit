
<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="content-wrapper" style="min-height: 976px;">
		<section class="content-header">
			<h1>HERE IS STUDENT LIST</h1>
		</section>
		<section class="content">
			<div class="row">
				<div class="col-sm-9 col-md-12">
					<c:forEach items="${list}" var="StudentVO">
						<p>${StudentVO.sname}${StudentVO.sid}${StudentVO.spw}</p>
					</c:forEach>
				</div>
			</div>
		</section>
	</div>

	<script>
		var result = '${result}';

		if (result == "success") {
			alert("가입완료!");

		}
	</script>
</body>
<%@include file="footer.jsp"%>
</html>