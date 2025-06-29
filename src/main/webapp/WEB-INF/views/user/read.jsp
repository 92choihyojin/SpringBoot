<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>


<title>상세</title>
<main>
	<h2>
		<spring:message code="user.header.read" />
	</h2>
	<form:form modelAttribute="member">
		<table>
			<tr>
				<td><spring:message code="user.no" /></td>
				<td><form:input path="no" readonly="true" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.userId" /></td>
				<td><form:input path="userId" readonly="true" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.userPw" /></td>
				<td><form:input path="userPw" readonly="true" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.userName" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.job" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.coin" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.regdate" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.updDate" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.ENABLED" /></td>
			</tr>
		</table>
	<div>
		<button type="button" id="btnEdit">
			<spring:message code="action.edit" />
		</button>
		<button type="button" id="btnRemove">
			<spring:message code="action.remove" />
		</button>
		<button type="button" id="btnList">
			<spring:message code="action.list" />
		</button>
	</div>
	</form:form>
	<script>
		$(document).ready(function() {
			var formObj = $("#member");
			$("#btnEdit").on("click", function() {
				var groupCode = $("#groupCode");
				var groupCodeVal = groupCode.val();
				self.location = "modify?groupCode=" + groupCodeVal;
			});
			$("#btnRemove").on("click", function() {
				formObj.attr("action", "/codegroup/remove");
				formObj.submit();
			});
			$("#btnList").on("click", function() {
				self.location = "list";
			});
		});
	</script>
</main>
	