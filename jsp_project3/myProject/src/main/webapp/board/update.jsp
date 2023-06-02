<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update Page</title>
<style type="text/css">
#Content{width: 1000px; height: 700px;
    margin:auto;
    text-align: center;
}
#h1Title{
	font-weight: 500;

}
#titleDiv{
	width: 500px;
	height: 250px;
	margin:auto;
	background-image: url("https://kpoplat.com/wp-content/uploads/2020/06/KAKAO-FRIENDS.jpg");
}
button{
	margin-top: 10px;
	font-size: 16px;
	width: 110px;
	height: 40px;
	background-color: #919191;
	border: none;
	opacity:0.7;
	cursor: pointer;
}
button:hover{
	opacity:1;
	color: white;
}
#backBtn{
	width: 150px;
}
</style>
</head>
<body>
	<div id="Content">
	<div id="h1Title">
	<h1 id="titleDiv">수정 페이지</h1>
	</div>
	<hr>
	<form action="/brd/update" method="post" enctype="multipart/form-data">
	<input type="text" name="num" value="${num }" hidden="hidden"/>
	제목 : <input type="text" name="title" value="${title }" /><br>
	글쓴이 : <input type="text" name="writer" value="${writer}" readonly="readonly"/><br>
	내용 : <textarea type="text" name="detail">${detail }</textarea> <br>
	이미지 : <img alt="없음" src="/_fileUpload/th_${image}"><br>
	<input type="hidden" name="image" value="${image }"><br>
	<input type="file" name="new_file">
	<button type="submit">수정!!</button></a>
	</form>
	<a href="/brd/removeFile"><button type="button">이미지 삭제</button></a>
	<a href="/brd/detail?num=${num }&title=${title }&writer=${writer}&detail=${detail}
				&regdate=${regdate }&counter=${counter }&image=${image}"><button id="backBtn">취소</button></a>
	</div>
</body>
</html>