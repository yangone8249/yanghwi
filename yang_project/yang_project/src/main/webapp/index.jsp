<%@page import="org.slf4j.Logger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
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
	<h1>메인페이지</h1>
	<hr><br>
	<div id="content">
	
		<c:if test="${ses.id eq null}">	
		<a href="/member/MemberCreate.jsp"><button type="button" class="btn btn-primary">회원가입</button></a>
		<a href="/member/MemberLogin.jsp"><button type="button" class="btn btn-primary">로그인</button></a>
		</c:if>
		<c:if test="${ses.id ne null}">
		<a href="/board/BoardCreate.jsp"><button type="button" class="btn btn-primary">게시글작성</button></a>
		<a href="/brd/page"><button type="button"  class="btn btn-primary">게시글목록</button></a>
		<a href="/mem/logout"><button type="button" class="btn btn-primary">로그아웃</button></a>
		<a href="/mem/remove?id=${ses.id }"><button type="button" class="btn btn-primary">회원탈퇴</button></a>
		<c:if test="${ses.id eq 'yang' }">
			<a href="/mem/list"><button type="button" class="btn btn-primary">회원목록</button></a>
		</c:if>
		</c:if>
	</div>
	<script type="text/javascript">
	
	if(${loginCancle} == '0'){
		alert("로그인 실패");
	}
	
	
	</script>
</body>
</html>