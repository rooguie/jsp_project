<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보 수정 페이지</h1>
	<form action="/user/update" method="post">
	
	아이디: <input type="text" name="id" value="${user.id }" readonly="readonly"> <br>
	비밀번호: <input type="text" name="password" value="${user.pw }" > <br>
	이메일: <input type="email" name="email" value="${user.email }" ><br>
	전화번호: <input type=text name="phone" value="${user.phone }" >
	
	<button type="submit">수정완료</button>
	</form>
	<a href="/"><button>취소</button></a>
</body>
</html>