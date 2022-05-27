<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
<jsp:include page="//common.jsp"></jsp:include>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<jsp:include page="//header.jsp"></jsp:include>
	
	<div id="content" class="panel-body">
		<table class="table" id="lst_tb">
			<thead>
				
			</thead>
			<tbody>
				<tr>
					<th colspan="6">${vo.gname }</th>
				</tr>
				<tr>
					<td colspan="4" rowspan="4">${vo.gimg }</td>
					<th class="item">가격</th>
					<td>${vo.gprice }원</td>
				</tr>
				<tr>
					<th class="item">색갈</th>
					<td>${vo.gcolor }</td>
				</tr>
				<tr>
					<th class="item">사이즈</th>
					<td>${vo.gsize }</td>
				</tr>
				<tr>
					<th class="item">재질</th>
					<td>${vo.gmeterial }</td>
				</tr>
				<tr>
					<td colspan="6">${vo.gcomment }</td>
				</tr>
				<tr>
					<td colspan="4">
						<a href="${path }/GetBoardEditCtrl?num=">상품 주문</a>
						<a href="${path }/GetBoardEditCtrl?num=">장바구니 담기</a>
						<a href="${path }/GetBoardListCtrl">카테고리 목록</a>
					</td>
					<th>남은 재고</th>
					<td>${vo.gamount }</td>
				</tr>	
			</tbody>
		</table>
	</div>
	
	<jsp:include page="//footer.jsp"></jsp:include>
</body>
</html>