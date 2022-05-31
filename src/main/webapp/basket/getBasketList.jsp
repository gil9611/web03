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
<title>장바구니</title>
<jsp:include page="//common.jsp"></jsp:include>

</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<jsp:include page="//header.jsp"></jsp:include>
	<div id="content" class="panel-body">
		<h2>장바구니 목록</h2>
		<hr>
		<table class="table" id="lst_tb">
			<thead>
				<tr>
					<th>제품 이름</th>
					<th>제품 가격</th>
					<th>제품 색갈</th>
					<th>제품 사이즈</th>
					<th>제품 재질</th>
					<th>주문 갯수</th>
				</tr>
			</thead>
			<tbody class="tb">
				<c:forEach items="${list }" var="vo" varStatus="status">
					<tr>
						<td><a href="${path }/GetGoodsDetailCtrl?code=${vo.bcode }">${vo.bname }</a></td>
						<td>${vo.bprice }원</td>
						<td>${vo.bcolor }</td>
						<td>${vo.bsize }</td>
						<td>${vo.bmaterial }</td>
						<td>${vo.border }개</td>
						<td><a class="button is-light" href="DelBasketCtrl?bno=${vo.bno }">삭제</a></td>
					</tr>
				</c:forEach>
				
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">
						<a class="button is-primary" href="">주문하기</a>
			        </td>
		        </tr>
			</tfoot>
		</table>
		<hr>
	</div>
	<jsp:include page="//footer.jsp"></jsp:include>
</body>
</html>