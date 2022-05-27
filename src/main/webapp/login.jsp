<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<jsp:include page="//common.jsp"></jsp:include>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="content" class="panel-body">
	<h2>로그인 페이지</h2>
		<form name="login" action="LoginCtrl" method="post">
			<ul>
				<li><input type="text" class="indata" id="mid" name="mid" placeholder="아이디 입력" required autofocus></li>
				<li><input type="password" class="indata" id="mpw" name="mpw" placeholder="비밀번호 입력" required></li>
				<li class="btn">
					<input type="submit" value="로그인" id="btn_submit"> &nbsp;
					<input type="reset" value="취소" id="btn_reset">
				</li>
			</ul>
		</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>