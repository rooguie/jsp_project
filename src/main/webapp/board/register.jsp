<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 등록 페이지</h1>
	
	<!-- action=> 가는 위치 / method => 가능 방법 -->
	<form action="/brd/insert" method="post">
	제목: <input type="text" name="title" placeholder="title...">
	작성자: <input type="text" name="writer" value="${loginUser.id }"> <br>
	내용: <textarea rows="10" cols="30" name="contents" placeholder="contents..."></textarea>
	
	<button type="submit">등록</button>
	</form>
	<a href="/"><button>취소</button></a>
</body>
</html>