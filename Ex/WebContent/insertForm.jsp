<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert.do" method="post">
		제목 : <input type = "text" name = "title"><br>
		작성자 : <input type = "text" name = "writer"><br>
		내용 : <br>
		<textarea rows="6" cols="70" name = "contents"></textarea>
		<input type = "submit" value="작성">
		
		
	
	</form>
</body>
</html>