<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록페이지</title>
</head>
<body>
	<h1>상품등록 페이지</h1>
			<button type="button"><a href="/index.jsp">메인으로 돌아가기</a></button>
	<br><hr>
	<form action="insert.pd" method="post">
		상품명 : <input type="text" name="pname" value="">
		가격 : <input type="text" name="price" value="">
		상세정보 : <input type="text" name="madeby" value="">
		<button type="submit">register</button>
	</form>
	
</body>
</html>