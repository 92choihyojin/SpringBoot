<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<table border="1">
		<tr>
			<th align="center" width="160">
				<spring:message code="auth.authNo" />
			</th>
			<th align="center" width="160">
				<spring:message code="auth.authName" />
			</th>
			<th align="center" width="180">
				<spring:message code="auth.regDate" />
			</th>
			<th align="center" width="180">
				<spring:message code="auth.updDate" />
			</th>
			<th align="center" width="180">
				<spring:message code="auth.isDeleted" />
			</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="3"><spring:message code="common.listEmpty" /></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="auth">
					<tr>
						<td align="center">${auth.authNo}</td>
						<td align="left">${auth.authName}</td>
						<td align="center">
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${auth.regDate}" />
						</td>
						<td align="center">
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${auth.updDate}" />
						</td>
						<td align="left">${auth.isDelete}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>