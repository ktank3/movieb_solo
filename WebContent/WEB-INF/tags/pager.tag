<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:if test="${empty param.page}">
	<c:set var="_page" value="1" />
</c:if>

<c:if test="${not empty param.page}">
	<c:set var="_page" value="${param.page}" />
</c:if>

<c:set var="start" value="${_page-(_page-1)%5}" />
<c:set var="end" value="${fn:substringBefore((count%5==0?count/5:count/5+1),'.')}" />

<div><c:if test="${start+i <= end}">${_page}/${end} pages</c:if></div>

<div>
	<div>
		<a href="search?page=${(_page==1)?1:start-1}&type=${param.type}&query=${param.query}"><img src="../images/btn-prev.png" alt="이전" /></a>
	</div>
	<ul>
		<c:forEach var="i" begin="0" end="4">
			<c:if test="${start+i <= end}">
			
				<c:if test="${_page==i+start}">
					<li><a href="search?page=${i+start}&type=${param.type}&query=${param.query}" class=strong>${i+start}</a></li>
				</c:if>
				
				<c:if test="${_page!=i+start}">
					<li><a href="search?page=${i+start}&type=${param.type}&query=${param.query}">${i+start}</a></li>
				</c:if>
			</c:if>
		</c:forEach>
	</ul>
	<div>
		<a href="search?page=${start+5}&type=${param.type}&query=${param.query}"><img src="../images/btn-next.png" alt="다음" /></a>
	</div>
</div>