<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<jsp:include page="//common.jsp"></jsp:include>

</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<jsp:include page="//header.jsp"></jsp:include>
	<div id="content" class="panel-body">
		<h2>글 목록</h2>
		<form method="post" action="${path }/GetBoardSearchCtrl">
			<table class="table" id="search_tb">
				<tr>
					<td>
						<select name="searchCondition" required>
							<option value="title">제목</option>
							<option value="content">내용</option>
						</select>
						<input type="text" name="searchKeyword" required/>
						<input type="submit" value="검색" />
					</td>
				</tr>
			</table>
		</form>
		<table class="table" id="lst_tb">
			<thead>
				<tr>
					<th class="item1">번호</th>
					<th class="item2">제목</th>
					<th class="item3">작성자</th>
					<th class="item4">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="vo" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td><a href="${path }/GetBoardDetailCtrl?num=${vo.seq }">${vo.title }</a></td>
						<td>${vo.nickname }</td>
						<td>${vo.indate }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4">
						<a href="${path }/board/addBoardForm.jsp">글 등록</a>
					</td>
				</tr>	
			</tbody>
		</table>
	</div>
	<jsp:include page="//footer.jsp"></jsp:include>
</body>
</html>