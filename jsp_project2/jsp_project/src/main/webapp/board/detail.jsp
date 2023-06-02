<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>
	<h1>상세페이지</h1>
	<br><hr><br>
	순번 : ${requestScope.num }<br>
	title : <input type="text" readonly="readonly" value="${requestScope.title }"/><br>
	writer : <input type="text" readonly="readonly" value="${requestScope.writer }"/><br>
	content : <textarea readonly="readonly" >${requestScope.content }</textarea><br>
	마지막 글 작성일 : ${requestScope.regdate}<br>
	<a href="/brd/list"><button>글목록 보기</button></a>
	<a href="/brd/modify?num=${requestScope.num}&title=${requestScope.title}&writer=${requestScope.writer }&content=${requestScope.content}"><button>수정하기</button></a>
	<a href="/brd/remove?num=${requestScope.num }"><button>삭제하기</button></a>
</body>
</html>