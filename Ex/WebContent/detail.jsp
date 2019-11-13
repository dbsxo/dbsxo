<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>내용</td>
			<td>작성일자</td>
			<td>조회수</td>
		
		
		</tr>
		
		<tr>
		<td>${board.seq }</td>
		<td>${board.title }</td>
		<td>${board.writer }</td>
		<td>${board.contents }</td>
		<td>${board.regdate }</td>
		<td>${board.hitcount }</td>
		</tr>
	
	</table>
	<br>
	<br>
	
	<table border="1">
		<tr>
			<td>댓글 번호</td>
			<td>댓글 제목</td>
			<td>댓글 작성자</td>
			<td>댓글 내용</td>
			<td>댓글 작성일</td>
		</tr>
		
		<c:forEach var="reply" items="${reply }">
			<tr>
				<td>${reply.r_no }</td>
				<td>${reply.r_title }</td>
				<td>${reply.r_writer }</td>
				<td>${reply.r_contents }</td>
				<td>${reply.r_regdate }</td>
			</tr>
		
		</c:forEach>
	</table>
	
	
	<form action="replyInsertAction.do" method="post">
		<input type = "hidden" name="seq" value="${board.seq }">
		댓글 제목 : <input type = "text" name = "r_title"><br>
		댓글 작성자 : <input type = "text" name = "r_writer"><br>
		댓글 내용 : <input type = "text" name = "r_contents"><br>
		<input type = "submit" value="작성">
	</form>
	

	<a href="updateForm.do?seq=${board.seq }">수정</a>
	<a href="delete.do?seq=${board.seq }">삭제</a>

</body>
</html>