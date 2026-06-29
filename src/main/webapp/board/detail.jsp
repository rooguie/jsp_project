<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${board.title}</h1>
	<h3>작성자: ${board.writer }</h3>
	<h3>내용</h3>
	<p>${board.contents }</p>
	
	<a href="/brd/modify?bno=${board.bno }"><button>수정</button></a>
	<a href="/brd/delete?bno=${board.bno }"><button>삭제</button></a>
	
</body>
</html>