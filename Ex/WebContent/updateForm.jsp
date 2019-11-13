<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	수정시작
	<form action="update.do" method = "post">
		<input type="hidden" name = "seq" value="${seq }">
		제목 : <input type="text" name = "title"><br>
		작성자 : <input type = "text" name = "writer"><br>
		내용 : <br>
		<textarea rows="6" cols="70" name = "contents"></textarea>
		<br>
		<input type="submit" value = "수정">
		
	</form>


</body>
</html>