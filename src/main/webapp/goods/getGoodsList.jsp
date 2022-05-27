<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
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
		<table class="table" id="lst_tb">
			<thead>
				<tr>
					<th class="item1">이미지</th>
					<th class="item2">이름</th>
					<th class="item3">가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="vo" varStatus="status">
					<tr>
						<td>${vo.gimg }</td>
						<td><a href="${path }/GetGoodsDetailCtrl?code=${vo.gcode }">${vo.gname }</a></td>
						<td>${vo.gprice }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4">
						<a href="${path }/goods/addGoodsForm.jsp">제품 등록</a>
					</td>
				</tr>	
			</tbody>
		</table>
	</div>
	<jsp:include page="//footer.jsp"></jsp:include>
</body>
</html>