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
</body>
</html>