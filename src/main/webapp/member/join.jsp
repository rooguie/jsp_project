<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="/user/join" method="post">
	아이디: <input type="text" name="id" placeholder="id..."> <a href="">중복확인</a><br>
	비밀번호: <input type="password" name="password" placeholder="password..."> <br>
	이메일: <input type="email" name="email" placeholder="emaill..."><br>
	전화번호: <input type=text name="phone" placeholder="phone...">
	
	<button type="submit">회원가입</button>
	</form>
	<a href=""><button>취소</button></a>
</body>
</html>