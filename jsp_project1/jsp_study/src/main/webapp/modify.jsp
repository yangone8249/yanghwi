<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>수정페이지</h1>
		<br><hr>
		
		<form action="/update.pd?pno=${pvo.pno }" method="post">
		번호 : <input type="text" name="pno" value="${pvo.pno }" disabled="disabled" ><br>
		제품명 : <input type="text" name="pname"value="${pvo.pname }"><br>
		가격 : <input type="text" name="price"value="${pvo.price}" ><br>
		등록일 : <input type="text" name="pname" value="${pvo.regdate }" disabled="disabled" ><br>
		상세정보 : <input type="text" name="madeby"value="${pvo.madeby }" ><br>
		
		
			<button type="submit">확인</button>
		</form>
		<button type="button"><a href="index.jsp">취소</a></button>
</body>
</html>