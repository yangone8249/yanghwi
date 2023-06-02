<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<h1>메인화면</h1>

<c:if test="${ses.id ne null}">
	${ses.id }님이 login 하였습니다. <br>
	계정생성일 : ${ses.regdate }<br>
	마지막 접속 : ${ses.lastLogin }<br>
	<hr>
	사용자 : ${ses.name }<br>
	나이 : ${ses.age }<br>
	연락처 : ${ses.phone }<br>
	주소 : ${ses.address }<br>
		 <hr>
	<a href="/mem/modify"><button>회원정보수정</button></a> <!-- java의 MemberController 페이지로 이동 -->
	<a href="/mem/logout"><button>로그아웃</button></a> <!-- java의 MemberController 페이지로 이동 -->
	<a href="/mem/remove?id=${ses.id }"><button>회원탈퇴</button></a> <!-- java의 MemberController 페이지로 이동 -->
	<br>
	<a href="/brd/register"><button>게시글 작성</button></a>
	<a href="/brd/list"><button>게시글 목록 보기</button></a>
</c:if>
	<c:if test="${ses.id eq null }">
	<a href="/mem/join"><button>회원가입</button></a> <!-- java의 MemberController 페이지로 이동 -->
	<a href="/mem/login"><button>로그인</button></a> <!-- java의 MemberController 페이지로 이동 -->
	</c:if>
<c:if test="${ses.id eq 'yang' }">
	<a href="/mem/admin"><button>관리자페이지</button></a> <!-- java의 MemberController 페이지로 이동 -->
</c:if>

<script type="text/javascript">
const msg_login = `<c:out value="${msg_login}"/>`; //java_MemberController의 값을 가져오는법 1.
const removeAlert = "${removeAlert}"; //java_MemberController의 값을 가져오는법 2.
const registerAlert = "${registerAlert}";
const updateAlert = "${updateAlert}";
if(msg_login == '0'){
	alert("로그인 실패");
}
if(removeAlert == '0'){
	alert("회원탈퇴 성공!");
}
if(registerAlert == "성공"){
	alert("회원가입 성공!");
}
if(updateAlert == "0"){
	alert("게시글 수정 성공!");
}
</script>
</body>
</html>