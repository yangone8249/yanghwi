<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
	<h1>회원가입</h1>
		<hr><br>
		<div id="content">
	<form action="/mem/insert" method="post">
	ID : <input type="text" name="id"/><br>
	PW : <input type="password" name="password"/><br>
	이름 : <input type="text" name="name"/><br>
	나이 : <input type="text" name="age"/><br>
	email : <input type="email" name="email"/><br>
	<button type="submit" class="btn btn-primary">가입</button>
	</form>
	<a href="/"><button type="button" class="btn btn-primary">뒤로가기</button></a></div>
</body>
</html>