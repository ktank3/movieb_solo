<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항목록</title>
<link href="css/layout.css" type="text/css" rel="stylesheet" />
<link href="css/<tiles:getAsString name="css"/>" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- header 부분 -->
	<tiles:insertAttribute name="header"/>
	<!-- --------------------------------------------<body>---------------------------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">
		<!-- aside 부분 -->
		<tiles:insertAttribute name="aside"/>
			<!-- --------------------------------------------main-------------------------------------------------------- -->
			
			<tiles:insertAttribute name="main"/>
			<!-- content 부분 -->
		</div>
	</div>
	<!-- footer 부분 -->
	<tiles:insertAttribute name="footer"/>
</body>
</html>