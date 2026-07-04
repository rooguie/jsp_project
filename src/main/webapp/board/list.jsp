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

	<div>
		<form action="" method="get">
			<select name="type">
				<option value="">Choose...</option>
				<option value="t">title</option>
				<option value="w">writer</option>
				<option value="c">contents</option>
				<option value="twc">all</option>
			</select> <input type="text" name="keyword" placeholder="keyword...">
			<button type="submit">검색</button>
		</form>

	</div>



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

	<!-- 페이징 -->

	<div>
		<c:if test="${ph.prev }">
			<a href="/brd/list?pageNo=${ph.startPage-1 }"> < </a>
			<!-- 이전 버튼 -->
		</c:if>

		<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
			<a href="/brd/list?pageNo=${i }"> ${i} </a>
			<!-- 1 2 4 5 ... 10  -->
		</c:forEach>

		<c:if test="${ph.next }">
			<a href="/brd/list?pageNo=${ph.endPage+1 }"> > </a>
			<!-- 다음 버튼 -->
		</c:if>
	</div>


















</body>
</html>