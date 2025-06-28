<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<h2>
	<spring:message code="codegroup.header.register" />
</h2>
<form:form modelAttribute="codeGroup" action="register">
	<table>
		<tr>
			<td><spring:message code="codegroup.groupCode" /></td>
			<td><form:input path="groupCode"  /></td>
			<td><font color="red"><form:errors path="groupCode" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="codegroup.groupName" /></td>
			<td><form:input path="groupName" /></td>
			<td><font color="red"><form:errors path="groupName" /></font></td>
		</tr>
	</table>

</form:form>
<div>
	<button type="button" id="btnRegister">
		<spring:message code="action.register" />
	</button>
	<button type="button" id="btnList">
		<spring:message code="action.list" />
	</button>
</div>
<script>
	$(document).ready(function() {
		var formObj = $("#codeGroup");
		$("#btnRegister").on("click", function() {
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			self.location = "list";
		});
	});
</script>