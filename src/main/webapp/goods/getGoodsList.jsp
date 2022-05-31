<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//MemberVO user
	String sid = (String) session.getAttribute("sid");
	String sname = (String) session.getAttribute("sname");
	if(sid!=null) sid=sid.trim().toLowerCase();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리스트</title>
<jsp:include page="//common.jsp"></jsp:include>

</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<jsp:include page="//header.jsp"></jsp:include>
	<div id="content" class="panel-body">
		<h2>제품 목록</h2>
		<form method="post" action="${path }/GetGoodsSearchCtrl">
			<table class="table" id="search_tb">
				<tr>
					<td>
						<input type="text" name="searchKeyword" required>
						<input type="submit" value="검색">
					</td>
				</tr>
			</table>
		</form>
		<ul class="table" id="lst_tb">
			<li class="ub">
				<c:forEach items="${list }" var="vo" varStatus="status">
					<ul>
						<li><img alt="제품이미지" src="${vo.gimg }"></li>
						<li><a href="${path }/GetGoodsDetailCtrl?code=${vo.gcode }">${vo.gname }</a></li>
						<li>${vo.gprice }</li>
					</ul>
				</c:forEach>
				<c:if test="${sid=='admin' }">
					<ul>
						<li colspan="4">
							<a href="${path }/goods/addGoodsForm.jsp">제품 등록</a>
						</li>
					</ul>
				</c:if>
			</li>
		</ul>
	</div>
	<jsp:include page="//footer.jsp"></jsp:include>
</body>
</html>