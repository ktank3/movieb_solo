<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<main id="main">
<section>
	<h1>
		<a href="">리뷰수정</a>
	</h1>
	<ul>
		<li><a href="../index.jsp">home</a>
		<li>
		<li><a href="review">리뷰</a>
		<li>
	</ul>
	<form action="review-edit" method="post">
		<fieldset>
			<legend>
				<table border=1>
					<tbody>
						<tr>
							<td>제목</td>
							<td colspan="3"><input type="text" name="title" value="${n.title}" /></td>
						</tr>
						<tr>
							<td>작성일</td>
							<td colspan="3">${n.regDate}</td>

						</tr>
						<tr>
							<td>영화제목</td>
							<td colspan="3"><input type="text" name="movie_title" value="${n.movie_title}" /></td>

						</tr>
						<tr>
							<td>작성자</td>
							<td>${n.writer}</td>
							<td>조회수</td>
							<td>${n.hit}</td>
						</tr>
						
						<tr>
							<td colspan="4"><textarea name="content" rows="20" cols="60">${n.content}</textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<input type="hidden" name="code" value="${n.code}">	
					<input type ="submit" value="저장">
					<a href="review-detail?code=${n.code}">취소</a>
				</div>
			</legend>
		</fieldset>
	</form>
	</section>
</main>
