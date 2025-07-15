<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<h2>
		<spring:message code="auth.header.login" />
	</h2>
	<h2>
		<c:out value="${error}" />
	</h2>
	<h2>
		<c:out value="${logout}" />
	</h2>
	<form method="post" action="/login">
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="username" id="username">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="password" id="password">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="checkbox" id="loginSaver" name="remember-me">
						<spring:message code="auth.rememberMe" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">
						<spring:message code="action.login" />
					</button>
				</td>
			</tr>
		</table>
	</form>
	<script>
		if(localStorage.getItem("loginSaver")) {
			let username = localStorage.getItem("username");
			document.getElementById("username").value = username;
			let password = localStorage.getItem("password"); 
			document.getElementById("password").value = password;
			console.log(localStorage.getItem("loginSaver"));
			document.getElementById("loginSaver").checked = localStorage.getItem("loginSaver");
		} else {
			document.getElementById("loginSaver").checked = false;
		}
		document.getElementById("loginSaver").addEventListener('change', function(e) {
			if(this.checked) {
				let username = document.getElementById("username").value
				let password = document.getElementById("password").value
				localStorage.setItem("username",username);
				localStorage.setItem("password",password);
				localStorage.setItem("loginSaver",this.checked);
			} else {
				localStorage.setItem("username", "");
				localStorage.setItem("password", "");
				localStorage.setItem("loginSaver", false);
			}
		});
	</script>
</body>
</html>