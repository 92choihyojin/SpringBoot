<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- 화면영역 -->
<style>
/* 테이블 기본 스타일 */
.form-table {
	width: 100%;
	max-width: 600px;
	border-collapse: collapse;
	margin: 20px auto;
	background-color: #fdfdfd;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.08);
	border-radius: 8px;
	overflow: hidden;
	align-items: center;
}

/* 테이블 행 */
.form-table tr {
	border-bottom: 1px solid #e0e0e0;
}

/* 왼쪽 td (라벨) */
.form-table td:first-child {
	background-color: #f7f7f7;
	font-weight: bold;
	padding: 10px 15px;
	text-align: right;
	width: 10px;
}

/* 오른쪽 td (입력칸) */
.form-table td:nth-child(2) {
	padding: 10px 15px;
	width: 150px;
}

/* 왼쪽 td (라벨) */
.form-table td:last-child {
	background-color: #f7f7f7;
	font-weight: bold;
	text-align: right;
	width: 0px;
}

.form-table td.shrink {
	width: 80px !important;
	transition: width 0.4s ease;
}

/* 고정 메시지 영역 (기본 상태: 숨김) */
.msg-fixed {
	display: inline-block;
	margin: 4;
	font-size: 10px;
	color: red;
	white-space: nowrap;
	/* 숨긴 상태 */
	width: 0;
	opacity: 0;
	overflow: hidden;
	transition: width 0.4s ease, opacity 0.2s ease;
	vertical-align: middle;
}

/* 보여줄 때만 추가하는 클래스 */
.show {
	width: 250px; /* 필요시 조절 가능 */
	opacity: 1;
}

.btn {
	background-color: #fff;
	color: black;
	padding: 10px 20px;
	font-size: 18px;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	transition: background-color 0.3s ease;
	display: inline-block;
}

.btn-error {
	background-color: #b00020;
	color: #fff;
}

.btn-warn {
	background-color: #f9a825;
	color: black;
}

.btn-primary {
	background-color: #6200ee;
	color: #fff;
}

.btn-error:hover {
	background-color: #7f0015;
}

.btn-warn:hover {
	background-color: #f57f17;
}

.btn-primary:hover {
	background-color: #3700b3;
}
</style>

<title>목록</title>
<main>
	<h2>
		<spring:message code="codedetail.header.read" />
	</h2>
	<form:form modelAttribute="codeDetail">
		<table>
			<tr>
				<td><spring:message code="codedetail.groupCode" /></td>
				<td><form:select path="groupCode" items="${groupCodeList}"
						itemValue="value" itemLabel="label" readonly="true" /></td>
				<td><font color="red"><form:errors path="groupCode" /></font></td>
			</tr>
			<tr>
				<td><spring:message code="codedetail.codeValue" /></td>
				<td><form:input path="codeValue" readonly="true" /></td>
				<td><font color="red"><form:errors path="codeValue" /></font></td>
			</tr>
			<tr>
				<td><spring:message code="codedetail.codeName" /></td>
				<td><form:input path="codeName" readonly="true" /></td>
				<td><font color="red"><form:errors path="codeName" /></font></td>
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
		$(document).ready(
				function() {
					var formObj = $("#codeDetail");
					$("#btnEdit").on(
							"click",
							function() {
								formObj.attr("action", "/codedetail/modify");
								formObj.attr("method", "get");
								formObj.submit();
								var groupCode = $("#groupCode");
								var groupCodeVal = groupCode.val();
								var codeValue = $("#codeValue");
								var codeValueVal = codeValue.val();
								self.location = "modify?groupCode="
										+ groupCodeVal + "&" + "codeValue="
										+ codeValueVal;
							});
					$("#btnRemove").on("click", function() {
						formObj.attr("action", "remove");
						formObj.submit();
					});
					$("#btnList").on("click", function() {
						self.location = "list";
					});
				});
	</script>
	}
</main>
