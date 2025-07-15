<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Shop</title>
<!-- <script type="text/javascript" src="/js/test.js"></script> -->
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<jsp:include page="/WEB-INF/views/common/menu.jsp" />
	</sec:authorize>
	<div align="center">
		<h1>
			<spring:message code="header.home" />
		</h1>
		<p>${serverTime}</p>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>