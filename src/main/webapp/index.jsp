<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 프로젝트</h1>

	<div>

		<c:if test="${loginUser.id eq null }">
			<a href="/user/loginPage">로그인</a>
			<a href="/user/joinPage">회원가입</a>

		</c:if>


		<c:if test="${loginUser.id ne null }">
		${loginUser.id }님 환영
			<a href="/brd/register">글쓰기</a>
			<a href="/brd/list">리스트 보기</a>
			<a href="/brd/myList">내가 쓴 글 보기</a>
			<a href="/user/logOut">로그아웃</a>
			<a href="/user/modifyPage">회원정보 수정</a>
			<a href="/user/delete">탈퇴</a>
		</c:if>

	</div>

	<script type="text/javascript">
		const msg = `<c:out value="${param.msg}"></c:out>`;
		console.log(msg);
		if (msg == "notUser") {
			alert("로그인 정보가 없습니다");
			location.herf="/";
		}
		
		else if(msg == "joinSuccess"){
			alert("회원가입 성공 로그인 해주세요!");
			location.herf="/";
		}
		
		else if(msg=="logOut"){
			alert("로그아웃 성공");
			location.herf="/";
		}
		
		else if(msg=="updateSuccess"){
			alert("회원정보 수정 성공! 재로그인 해주세요");
			location.herf="/";
		}
		
		else if(msg=="deleteSuccess"){
			alert("회원탈퇴 성공");
			location.herf="/";
		}
	</script>
</body>
</html>