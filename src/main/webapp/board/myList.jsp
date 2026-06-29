<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<h1>내가 쓴 글 목록</h1>
	<c:if test="${not empty list }">
	<table>
		<thead>
			<tr>
				<th>no.</th>
				<th>title.</th>
				<th>writer</th>
				<th>regdate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="board">

				<tr>

					<td>${board.bno }</td>
					<td><a href="/brd/detail?bno=${board.bno }">${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.regdate }</td>

				</tr>

			</c:forEach>
		</tbody>
	</table>
	</c:if>
	
	<!-- 리스트 없을때 글 없음 표시하기 -->
	
		<c:if test="${empty list }">
		<h1>작성한 글 없음</h1>
		<a href="/brd/register">글쓰기</a>
		</c:if>
	
	
	<a href="/">home</a>
</body>
</html>