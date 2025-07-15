<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div align="center">
	<table>
		<tr>
			<td width="80">
				<a href="/"> <spring:message code="header.home" /></a>
			</td>
			<td width="80">
				<a href="/user/register"><spring:message code="header.joinMember"/></a>
			</td>
			<td width="80">
			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER', 'ROLE_GUEST')">
				<a href="/auth/logout"><spring:message code="header.logout"/></a>
			</sec:authorize>
			<sec:authorize access="!hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER', 'ROLE_GUEST')">
				<a href="/auth/login"><spring:message code="header.login"/></a>
			</sec:authorize>
			</td>
			<td width="80">
				<a href="/board/list"><spring:message code="header.board"/></a>
			</td>
		</tr>
	</table>
</div>
<hr>