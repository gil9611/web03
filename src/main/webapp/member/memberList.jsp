<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<jsp:include page="//common.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="//header.jsp"></jsp:include>
	<div id="content" class="panel-body">
		<h2>회원 목록</h2>
		<table class="table" id="lst_tb">
			<thead>
				<tr>
					<th class="item">번호</th>
					<th class="item">아이디</th>
					<th class="item">비밀번호</th>
					<th class="item">이름</th>
					<th class="item">주소</th>
					<th class="item">권한</th>
					<th class="item">포인트</th>
					<th class="item">가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="vo" varStatus="status">
					<a href="">
					<tr>
						<td>${status.count }</td>
						<td>${vo.mid }</td>
						<td>${vo.mpw }</td>
						<td>${vo.mname }</td>
						<td>${vo.maddress }</td>
						<td>${vo.mlank }</td>
						<td>${vo.mpoint}</td>
						<td>${vo.sdate }</td>
					</tr>
					</a>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<jsp:include page="//footer.jsp"></jsp:include>
</body>
</html>