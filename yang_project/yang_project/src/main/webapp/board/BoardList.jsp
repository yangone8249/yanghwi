<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<style type="text/css">
	#content{
		width : 1000px;
		height : 700px;
		background-color: #E2E2E2;
		margin:auto;
		text-align: center;
	}
	#table{
		margin:auto;
	}
</style>
</head>
<body>
	<h1>게시글 리스트</h1>
	<hr><br>
	<div id="content">
		<h1 id="listTitle">게시글 목록</h1>
		<form action="/brd/page" method="post" >
			<div>
				<c:set value="${pgh.pgvo.type }" var="typed"></c:set>
				<select name="type">
					<option ${typed == null ? 'selected' : '' }>선택</option>
					<option ${typed eq 't' ? 'selected' : '' } value="t">제목</option>
					<option ${typed eq 'c' ? 'selected' : '' } value="c">내용</option>
					<option ${typed eq 'w' ? 'selected' : '' } value="w">작성자</option>
					<option ${typed eq 'tc' ? 'selected' : '' } value="tc">제목 + 내용</option>
					<option ${typed eq 'tw' ? 'selected' : '' } value="tw">제목 + 작성자</option>
					<option ${typed eq 'cw' ? 'selected' : '' } value="cw">내용 + 작성자</option>
				</select>
				<input type="text" name="keyword" placeholder="Search">
				<input type="hidden" name="pageNo" value="${pgh.pgvo.pageNo }">
				<input type="hidden" name="qty" value="${pgh.pgvo.qty }">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</form>
			<table border="1" id="table">
			<tr>
				<td>순번</td>
				<td>제목</td>
				<td>작성자</td>
				<td>내용</td>
				<td>글작성일</td>
				<td>조회수</td>
			</tr>
			<c:forEach items="${list }" var="list" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>
					<c:if test="${list.image_file ne null && list.image_file ne '' }">
					<img alt="없음" src="/_fileUpload/th_${list.image_file}">
					</c:if>
					<a href="/brd/detail?bno=${list.bno }">${ list.title}</a></td>
					<td>${list.writer }</td>
					<td>${list.content }</td>
					<td>${list.regdate }</td>
					<td>${list.count }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/"><button type="button" class="btn btn-primary">메인으로</button></a>
			<a href="/brd/page?type='w'&keyword=${ses.id }" ><button class="btn btn-primary">내가쓴 글 보기</button></a>
		<c:if test="${pgh.prev }">
			<a href="/brd/page?pageNo=${pgh.startPage-1 }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">이전</a>
		</c:if>
		<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
			<a href="/brd/page?pageNo=${i }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">${i } | </a>
		</c:forEach>
		<c:if test="${pgh.next }">
			<a href="/brd/page?pageNo=${pgh.endPage+1 }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">다음</a>
		</c:if></div>
</body>
</html>