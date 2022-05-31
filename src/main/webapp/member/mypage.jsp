<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<jsp:include page="//common.jsp"></jsp:include>
</head>
<body>
<header id="hd">
		<div class="hd_wrap">
			<%@ include file="//header.jsp" %>
		</div>
	</header>
	<div class="content">
		<h2>회원정보 보기</h2>
			<form action="${path }/MemberEditCtrl" method="post">
					<table>
						<tbody>
							<tr>
								<td>아이디: </td>
								<td><input type="text" name="uid" value='${vo.mid }' readonly></td>
							</tr>
							<tr>
								<td>이름: </td>
								<td><input type="text" name="uname" value='${vo.mname }' readoly></td>
							</tr>
							<tr>
								<td>주소: </td>
								<td><input type="text" name="uadd" value='${vo.maddress }'></td>
							</tr>
							<tr>
								<td>가입일: ${vo.sdate }</td>
								<td>포인트: ${vo.mpoint }</td>
							</tr>
							<tr>
								<td colspan="3">
						 		<input type="submit" value="정보변경"> &nbsp; &nbsp; &nbsp;&nbsp;
						 		<%if(!sid.equals("admin")){ %>
						 		<a href="secession.jsp">탈퇴</a>
						 		<%} %>
						 		<input type="reset" value="취소">
						 	</td>
							</tr>
						</tbody>
					</table>
			</form>	
	</div>
	<footer id="ft">
		<%@ include file="//footer.jsp" %>
	</footer>
</body>
</html>