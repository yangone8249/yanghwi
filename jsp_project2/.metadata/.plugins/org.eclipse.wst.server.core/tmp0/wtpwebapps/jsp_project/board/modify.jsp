<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
</head>
<body>
	<h1>수정 페이지</h1><br>
	<hr>
	<form action="/brd/update" method="post">
	순번 : ${requestScope.num }<input hidden="hidden" type="text" name="num" value="${requestScope.num }"><br>
	title : <input type="text" name="title" value="${requestScope.title }"><br>
	<!-- writer(글쓴이)는 기본 value값을 id로 지정, readonly(읽기만가능) -->
	writer : <input type="text" name="writer" value="${requestScope.writer }" readonly="readonly"><br>
	content : <textarea rows="3" cols="30" name="content" >${requestScope.content }</textarea><br>
	
	<button type="submit">수정하기!</button>
	<button type="reset">다 지우기</button>
	</form>
	<script type="text/javascript">
	
	
	</script>
</body>
</html>