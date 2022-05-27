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
			<%@ include file="header.jsp" %>
		</div>
	</header>
	<div class="content">
		<h2>회원가입</h2>
		<form action="${path }/JoinCtrl" method="post" name="joinform" id="joinform" onsubmit="return joinCheck(this)">
			<fieldset style="width: 500">
				<legend>회원정보</legend>
					<table>
						<tbord>
							<tr>
								<th><label for ="jid"></label>아이디</th>
								<td><input type ="text" class="indata" id="jid" name="jid" placeholder="아이디 중복확인을 눌러주세요." required></td>
								<td><input type ="button" onclick="opchack()" value ="중복확인"></td>
								<td><input type ="hidden" id="idck" name="idck"></td>
							</tr>
							<tr>
								<th><label for ="j_pw"></label>비밀번호</th>
								<td><input type ="password" class="indata" id="jpw" name="jpw" placeholder="비밀번호" required></td>
							</tr>
							<tr>
								<th><label for ="j_pw2"></label>비밀번호 확인</th>
								<td><input type ="password" class="indata" id="jpw2" name="jpw2" placeholder="비밀번호" required></td>
							</tr>
							<tr>
								<th><label for ="j_name"></label>이름</th>
								<td><input type ="text" class="indata" id="jname" name="jname" placeholder="이름" required></td>
							</tr>
							<tr>
								<th><label for ="j_add"></label>주소</th>
								<td><input type ="text" class="indata" id="jadd" name="jadd" placeholder="주소"></td>
							</tr>
						</tbord>
					</table>
			</fieldset>
					<table>
					    <tbody>
					        <td><input type="submit" value="회원가입"></td>
					       	<td><input type="reset" value="취소"></td>
					    </tbody>
					</table>
					<script type="text/javascript">
						function opchack() {
							//window.open("idCheck.jsp", "idwin", "width=400 height=300");
						}
						function joinCheck(th){
							//아이디 중복검사
							/*
							if(th.idck.value != "ok"){
								alert("아이디 중복검사를 해주세요.")
								return false;
							}
							*/
							if(th.jpw.value != th.jpw2.value){
								alert("비밀번호가 서로 다릅니다.");
								return false;
							}
								
						}
					</script>
		</form>
	</div>
	<footer id="ft">
		<%@ include file="footer.jsp" %>
	</footer>
</body>
</html>