<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 작성</title>
<jsp:include page="//common.jsp"></jsp:include>
<style>
#lst_tb {width: 1000px;}
</style>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<jsp:include page="//header.jsp"></jsp:include>
	
	<div id="content" class="panel-body">
		<form action="${path }/InsertGoodsCtrl" method="post" enctype="multipart/form-data">
			<table class="table" id="lst_tb">
				<tbody>
					<tr>
						<th class="item">이름</th>
						<td>
							<input type="text" name="gname" required>
						</td>
						<th class="item">가격</th>
						<td colspan="3">
							<input type="number" name="gprice" required>
						</td>
					</tr>
					<tr>
						<th class="item">카테고리</th>
						<td colspan="5">
							<select name="gcategory" id="gcategory" required>
                                <option value="">선택안함</option>
                                <option value="귀걸이">귀걸이</option>
                                <option value="반지">반지</option>
                                <option value="목걸이">목걸이</option>
                                <option value="팔찌">팔찌</option>
                                <option value="시계">시계</option>
                                <option value="브로치">브로치</option><br>
                                <option value="머리핀">머리핀</option>
                                <option value="머리띠">머리띠</option>
                                <option value="머리끈">머리끈</option>
                            </select>
						</td>
					</tr>
					<tr>
						<th class="item">색갈</th>
						<td>
							<input type="text" name="gcolor" required>
						</td>
						<th class="item">사이즈</th>
						<td>
							<input type="text" name="gsize" required>
						</td>
						<th class="item">재질</th>
						<td>
							<input type="text" name="gmeterial" required>
						</td>
					</tr>
					<tr>
						<th class="item">설명</th>
						<td colspan="5">
							<textarea name="gcomment" cols="80" rows="40"></textarea>
						</td>
					</tr>
					<tr>
						<th>이미지</th>
						<td colspan="5"><input type="file" name="gimg"></td>
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