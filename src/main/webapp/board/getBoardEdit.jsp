<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.shop.common.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<jsp:include page="//common.jsp"></jsp:include>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<jsp:include page="//header.jsp"></jsp:include>
	
	<div id="content" class="panel-body">
		<form action="${path }/EditBordCtrl" method="post">
			<table class="table" id="lst_tb">
				<tbody>
						<tr>
							<input type="hidden" name="seq" value="${vo.seq }">
							<th class="item1">제목</th>
							<td colspan="5">
								<input type="text" name="title" value="${vo.title }">
							</td>
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
							<td colspan="5">
								<textarea name="note" cols="80" rows="40">${vo.note }</textarea>
							</td>
						</tr>
					
					<tr>
						<td colspan="4">
							<input type="submit" value="수정">
							<input type="reset" value="취소">
							<a href="${path }/GetBoardDetailCtrl?num=${vo.seq }">돌아가기</a>
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