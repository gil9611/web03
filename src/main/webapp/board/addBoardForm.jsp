<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.shop.common.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<jsp:include page="//common.jsp"></jsp:include>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<jsp:include page="//header.jsp"></jsp:include>
	
	<div id="content" class="panel-body">
		<form action="${path }/AddBoardCtrl" method="post">
			<table class="table" id="lst_tb">
				<tbody>
						<tr>
							<th class="item1">제목</th>
							<td colspan="5">
								<input type="text" name="title">
							</td>
						</tr>
						<tr>
							<th class="item2">작성자</th>
							<td>관리자</td>
						</tr>
						<tr>
							<th class="item5">내용</th>
							<td colspan="5">
								<textarea name="note" cols="80" rows="40"></textarea>
							</td>
						</tr>
					
					<tr>
						<td colspan="4">
							<input type="submit" value="작성">
							<input type="reset" value="취소">
							<a href="${path }/GetBoardListCtrl">글 목록</a>
						</td>
					</tr>	
				</tbody>
			</table>
		</form>
	</div>
	
	<jsp:include page="//footer.jsp"></jsp:include>
</body>
</html>