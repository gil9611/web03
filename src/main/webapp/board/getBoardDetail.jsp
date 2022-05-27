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
						<th class="item1">제목</th>
						<td colspan="5">${vo.title }</td>
					</tr>
					<tr>
						<th class="item2">작성자</th>
						<td>${vo.nickname }</td>
						<th class="item3">작성일</th>
						<td>${vo.indate }</td>
						<th class="item4">조회수</th>
						<td>${vo.visited }</td>
					</tr>
					<tr>
						<th class="item5">내용</th>
						<td colspan="5">${vo.note }</td>
					</tr>
				
				<tr>
					<td colspan="4">
						<a href="${path }/GetBoardEditCtrl?num=${vo.seq }">글 수정</a>
						<a href="${path }/DelBoardCtrl?num=${vo.seq }">글 삭제</a>
						<a href="${path }/GetBoardListCtrl">글 목록</a>
					</td>
				</tr>	
			</tbody>
		</table>
	</div>
	
	<jsp:include page="//footer.jsp"></jsp:include>
</body>
</html>