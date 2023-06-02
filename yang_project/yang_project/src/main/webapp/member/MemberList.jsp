<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<style type="text/css">
	#content{
		width : 1000px;
		height : 700px;
		background-color: #E2E2E2;
		margin:auto;
		 justify-content : center;
		display: flex;
		align-items : center;
		padding-bottom: 400px;
	}
</style>
</head>
<body>
		<h1>회원목록 페이지</h1>
		<hr><br>
		<div id="content">
		<table border="1">
			<tr>
				<td>순번</td>
				<td>ID</td>
				<td>PW</td>
				<td>이름</td>
				<td>나이</td>
				<td>email</td>
				<td>계정생성일</td>
				<td>마지막접속일</td>
			</tr>
			<c:forEach items="${list }" var="list" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${list.id }</td>
					<td>${list.password }</td>
					<td>${list.name }</td>
					<td>${list.age }</td>
					<td>${list.email }</td>
					<td>${list.regdate }</td>
					<td>${list.lastlogin }</td>
				</tr>
			</c:forEach>	
		</table>
		<a href="/"><button type="button" class="btn btn-primary">메인으로</button></a>
		</div>
</body>
</html>