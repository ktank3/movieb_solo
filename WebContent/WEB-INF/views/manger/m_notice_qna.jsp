<%@page import="java.util.Scanner"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	/* List<NoticeModel> list = new MybatisNoticeDao().getList();
	pageContext.setAttribute("list", list);
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 관리페이지</title>
<!-- <link href="./css/style.css" type="text/css" rel="stylesheet" /> -->
<link href="../css/manager_.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<div class = "container">

	<div class="head">
		<header>
		<a href="manager"><img class="setting" src="../images/setting.png" /></a>
		<a href="m_notice"><img class="notice" src="../images/notice.png" /></a> 
		<a href="m_plus"><img class="plus" src="../images/plus.png" /></a>
	
		</header>
	</div>

	<div class="body"></div>
		<h1></h1>

		<div class="body-aside">
			<aside>
			<h1></h1>
			<nav>
			<ul>
				<li><a href="m_notice">공지사항 관리</a></li>
				<li><a href="m_notice_review">리뷰 게시판 관리</a></li>
				<li><a href="m_notice_qna">1:1문의 게시판 관리</a></li>
			</ul>
			</nav> 	
			</aside>
		</div>

		<div class="body-main">
			<main>
			<h1>
				<a href="">문의 게시판</a>
			</h1>

			<form action="notice" method="get">
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

			<table border="1">
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="n" items="${list}">
						<tr>
							<td>${n.code}</td>
							<td><a href="notice-detail?code=${n.code}">${n.title}</a></td>
							<td>${n.writer}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${n.regDate}" /></td>
							<td>${n.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:set var="start" value="${page-(page-1)%5}" /> <c:set var="end"
				value="${fn:substringBefore((count%10==0?count/10:count/10+1),'.')}" />

			<!-- 먼저 param.p의 값을 page라는 값에 담아 제어구조문으로 기본값을 정의후  밑에서 page라는 값을 쓴다 -->
			<c:if test="${empty param.p}">
				<c:set var="page" value="1" />
			</c:if> <c:if test="${!empty param.p}">
				<c:set var="page" value="${param.p}" />
			</c:if>
			<div>${page}/${end}pages</div>
			<div>
				<a href="notice-reg">글쓰기</a>
			</div>
			<div>



				<div>
					<a href="notice?p=${(page==1)?1:start-1}">이전</a>
				</div>
				<ul>
					<c:forEach var="i" begin="0" end="4">
						<c:if test="${start+i <= end}">
							<c:if test="${page==start+i}">
								<li><a href="notice?p=${start+i}&t=${param.t}&q=${param.q}"
									class="strong">${start+i}</a></li>
							</c:if>
							<c:if test="${page!=start+i}">
								<li><a href="notice?p=${start+i}&t=${param.t}&q=${param.q}">${start+i}</a></li>
							</c:if>
						</c:if>
					</c:forEach>
				</ul>
				<div>
					<a href="notice?p=${start+5}&t=${param.t}&q=${param.q}">다음</a>
				</div>
			</div>
			</main>

		</div>	
	

	<!-- <div id="footer">
		<footer>
		<h1></h1>
		</footer>

	</div> -->
	</div>
</body>
</html>