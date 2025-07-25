<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
		<spring:message code="board.header.list" />
	</h2>



	<!-- 검색 폼을 만든다. -->
	<form:form modelAttribute="pgrq" method="get"
		action="list${pgrq.toUriStringByPage(1)}">
		<form:select path="searchType" items="${searchTypeCodeValueList}"
			itemValue="value" itemLabel="label" />

		<form:input path="keyword" />
		<button id='searchBtn'>
			<spring:message code="action.search" />
		</button>
	</form:form>

	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')">
		<a href="register"><spring:message code="action.new" /></a>
	</sec:authorize>

	<table border="1">
		<tr>
			<th align="center" width="80"><spring:message code="board.no" /></th>
			<!-- 게시글 상세보기할 때 페이징 요청 정보를 매개변수로 전달한다. -->
			<%-- 삭제 <td align="left"><a href="/board/read${pagination.makeQuery(pagination.pageRequest.page)}&boardNo=
${board.boardNo}">${board.title}</a></td> --%>
			<th align="center" width="320"><spring:message
					code="board.title" /></th>
			<th align="center" width="100"><spring:message
					code="board.writer" /></th>
			<th align="center" width="180"><spring:message
					code="board.regdate" /></th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4"><spring:message code="common.listEmpty" /></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="board">
					<tr>
						<td align="center">${board.boardNo}</td>
						<%-- 사용안함 <td align="left"><a
							href='/board/read?boardNo=${board.boardNo}'>${board.title}</a></td> --%>
						<td align="left"><a
							href="/board/read${pagination.makeQuery(pagination.pageRequest.page)}&boardNo=
							${board.boardNo}">${board.title}</a></td>
						<td align="right">${board.writer}</td>
						<td align="center">
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regDate}" />
						</td>

					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>


	<!-- 페이징 네비게이션 -->
	<div>
		<div>
			<c:if test="${pagination.prev}">
				<a
					href="/board/list${pagination.makeQuery(pagination.startPage - 1)}">&laquo;</a>
			</c:if>
			<c:forEach begin="${pagination.startPage }"
				end="${pagination.endPage }" var="idx">
				<c:if test="${pagination.pageRequest.page eq idx}">
					<a href="/board/list${pagination.makeQuery(idx)}">[${idx}]</a>
				</c:if>
				<c:if test="${!(pagination.pageRequest.page eq idx)}">
					<a href="/board/list${pagination.makeQuery(idx)}">${idx}</a>
				</c:if>
			</c:forEach>
			<c:if test="${pagination.next && pagination.endPage > 0}">
				<a href="/board/list${pagination.makeQuery(pagination.endPage +1)}">&raquo;</a>
			</c:if>
		</div>
	</div>
	<script>
		var result = "${msg}";
		if (result === "SUCCESS") {
			alert("<spring:message code='common.processSuccess' />");
		}
	</script>
</main>
