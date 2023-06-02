<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 전체 목록</title>
</head>
<body>
	<h1>전체 목록 리스트</h1>
	<table border="1">
		<tr>
			<td>순번</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>작성일</td>
			<td>내용</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list }" var="list" varStatus="i">
			
			<tr>
				<td>${list.num }</td> 
				<td><a href="/brd/detail?
				num=${list.num}&title=${list.title}&writer=${list.writer}&regdate=${list.regdate}&content=${list.content}&counter=${list.counter}"
				>${list.title }</a></form></td>
				<td>${list.writer }</td>
				<td>${list.regdate }</td> <!-- boardVO에 선언한 변수명으로 사용해야한다. -->
				<td>${list.content }</td>
				<td>${list.counter }</td>
			</tr>
			
		</c:forEach>
	</table>
	<a href="/brd/index"><button>메인메뉴로 돌아가기</button></a>
</body>
</html>