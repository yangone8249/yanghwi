<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail Page</title>
<style type="text/css">
#Content{width: 1000px; height: 540px;
    margin:auto;
    text-align: center;
    margin-bottom:50px;
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
#detailDiv{
	margin-top: 30px;
}

button:hover{
	opacity:1;
	color: white;
}
#backBtn{
margin-top: 10px;
	font-size: 16px;
	width: 110px;
	height: 40px;
	background-color: #919191;
	border: none;
	opacity:0.7;
	cursor: pointer;
	width: 150px;
}
#commentDiv{
	
	margin:auto;
	width: 600px;
}
#cmtAddBtn{	
	width: 50px;
		border: none;
		background-color: #919191;
	
}
img{
	width: 150px;
	height: auto;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
	<div id="Content">
	<div id="titleDiv">
	<h1 id="h1Title">게시글 정보</h1>
	</div>
	<div id="detailDiv">
	<form action="/brd/modify?num=${num }&title=${title }&writer=${writer}&detail=${detail}
				&regdate=${regdate }&counter=${counter }&image=${image }" method="post" enctype="multipart/form-data">
	<input type="text" name="num" value="${num }" hidden="hidden"/>
	제목 : <input type="text" name="title" value="${title }" readonly="readonly"/><br>
	글쓴이 : <input type="text" name="writer" value="${writer}" readonly="readonly"/><br><hr>
	내용 : <textarea type="text" name="detail" readonly="readonly">${detail }</textarea> <br>
	<c:if test="${image ne null && image ne '' }">
				이미지 : <img alt="없음" src="/_fileUpload/${image}">
				<input type="text" name="image" value="/_fileUpload/${image }">
				<br><hr>
				</c:if>
	작성일 : <input type="text" name="regdate" value="${regdate}" readonly="readonly"/><br>
	조회수 : ${counter }<br>


	<c:if test="${ses.id eq writer || ses.id eq 'yang' }"><br>
	<button type="submit">수정하기</button>
	</c:if>
	</form>
	</div>
	
	
	<c:if test="${ses.id eq writer || ses.id eq 'yang' }">
	<a href="/brd/remove?num=${num }"><button>삭제하기</button></a>
	</c:if>	<br>
	<a href="/brd/page"><button id="backBtn">게시글목록 가기</button></a>
	</div>
	
	
	<div id="commentDiv">
	comment line<br>
	<!-- 댓글 작성 라인 -->
	작성자 : <input type="text" id="cmtWriter" value="${ses.id }" readonly="readonly"/>
	<!-- 댓글 표시 라인 -->
	<input type="text" id="cmtText" placeholder="Add Comment"/>
	<button type="button" id="cmtAddBtn">댓글등록</button>
	
	<div class="accordion" id="accordionExample"> 
	 	<div class="accordion-item">
	    <h2 class="accordion-header" id="headingOne">
	      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
	        cno, writer
	      </button>
	    </h2>
	    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
	        content, reg_date
	      </div>
	    </div>
	  </div>
   </div>

<script type="text/javascript">
	const bnoVal = `<c:out value="${num}" />`;
</script>
<script  type="text/javascript" src="/resources/board_detail.js"></script>
<script type="text/javascript">
printCommentList(bnoVal);
</script>
 
</body>
</html>