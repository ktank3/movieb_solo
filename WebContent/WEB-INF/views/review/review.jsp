<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="pager" tagdir="/WEB-INF/tags" %>

<main id ="main">
<section>
<h1>
	<a href="">리뷰</a>
</h1>
<ul>
	<li><a href="../index.jsp">home</a>
	<li>
	<li><a href="/customer/review">리뷰</a>
	<li>
		<form action="review" method="get">
			<fieldset>
				<select name="t">
					<option value="NONE">분류선택</option>


					<option value="TITLE"
						<c:if test="${param.t=='TITLE'}"> selected="selected"</c:if>>제목</option>



					<option value="CONTENT"
						<c:if test="${param.t=='CONTENT'}"> selected="selected"</c:if>>내용</option>


					<option value="WRITER"
						<c:if test="${param.t=='WRITER'}">selected="selected"</c:if>>작성자</option>
				</select> <label>검색어</label> <input name="q" value="${param.q}" /> <input
					type="submit" value="검색" />
			</fieldset>
		</form>
</ul>
<table border="1">
	<thead>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>영화명</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="n" items="${list}">
			<tr>
				<td>${n.code}</td>
				<td><a href="review-detail?code=${n.code}">${n.title}</a></td>
				<td>${n.writer}</td>
				<td>${n.movie_title}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${n.regDate}" />
				</td>
				<td>${n.hit}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
	<a href="review-reg">글쓰기</a>
</div>

<c:if test="${empty param.p}">
	<c:set var="page" value="1" />
</c:if> <c:if test="${!empty param.p}">
	<c:set var="page" value="${param.p}" />
</c:if> <!-- page는 1~5 6~10 11~15 간격으로 나와야됨 --> <c:set var="start"
	value="${page-(page-1)%5}" /> <c:set var="end"
	value="${fn:substringBefore((count%10 == 0 ? count/10 : count/10 + 1),'.')}" />

<!-- 현재 상태-->
<div>
	<h3 class="hidden">현재 페이지</h3>
	${page} / ${end} pages
</div>


<div>
	<div>
		<a href="review?p=${(start==1)?1:start-1}&q=${param.q}&t=${param.t}"></a>
	</div>
	<div>
		<a href="review?p=${(page==1)?1:page-1}&q=${param.q}&t=${param.t}"></a>
	</div>
	<ul>
		<c:forEach var="i" begin="0" end="4">
			<c:if test="${start+i <= end}">
				<li><a href="review?p=${start+i}&q=${param.q}&t=${param.t}"
					<c:if test="${page == start+i}">class="strong"</c:if>>${start+i}</a></li>
			</c:if>
		</c:forEach>
	</ul>
	<div>
		<a href="review?p=${(page==end)?end:page+1}&q=${param.q}&t=${param.t}">></a>
	</div>
	<div>
		<a
			href="review?p=${(start+5>end)?end:start+5}&q=${param.q}&t=${param.t}">>></a>
	</div>
</div>

</section>
</main>