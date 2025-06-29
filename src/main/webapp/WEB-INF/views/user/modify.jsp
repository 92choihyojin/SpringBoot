<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<h2>
	<spring:message code="member.header.modify" />
</h2>
<form:form modelAttribute="member" action="modify">
	<form:hidden path="userNo" />
	<table>
		<tr>
			<td><spring:message code="user.userId" /></td>
			<td><form:input path="userId" readonly="true" /></td>
			<td><font color="red"><form:errors path="user.userId" /></font></td>
		</tr>
	</table>
</form:form>
<div>
	<button type="button" id="btnModify">
		<spring:message code="action.modify" />
	</button>
	<button type="button" id="btnList">
		<spring:message code="action.list" />
	</button>
</div>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		$("#btnModify").on("click", function() {
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			self.location = "list";
		});
	});
</script>