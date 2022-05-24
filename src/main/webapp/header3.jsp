<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="header" class="panel-heading">
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<a href="${path }/index.jsp">로고</a>
	<nav id="gnb">
		<ul>
			<li><a href="">메뉴</a></li>
			<li><a href="${path }/GetBoardListCtrl">게시판목록</a></li>
			<li><a href="${path }/GetMemberListCtrl">회원관리</a></li>
			<li><a href="${path }/GetProducListCtrl">제품관리</a></li>
		</ul>
	</nav>
	<nav id="top">
		<ul>
			<li><a href="${path }/login.jsp">로그인</a></li>
			<li><a href="${path }/join.jsp">회원가입</a></li>
		</ul>
	</nav>
</header>