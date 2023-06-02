<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Board</title>
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
</style>
</head>
<body>
	<div id="Content">
	<div id="h1Title">
	<h1 id="titleDiv">게시글 만들기</h1>
	</div>
	<hr>
	<form action="/brd/create" method="post" enctype="multipart/form-data">
	제목 : <input type="text" name="title"/><br>
	글쓴이 : <input type="text" name="writer" value="${ses.id }" readonly="readonly"/><br>
	내용 : <textarea type="text" name="detail"></textarea> <br>
	imageFile : <input type="file" id="file" name="image_file" accept="image/png, image/jpg, image/jpeg, image/bmp, image/gif"/>
	<button type="submit">등록!</button> 	
	</form>
	<a href="/mem/index"><button>메인으로</button></a>
	</div>
</body>
</html>