<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 추가 실습</title>
</head>
<body>
<form action="/web03/ImgUploadCtrl" method="post" enctype="multipart/form-data"">
<table border=1>
	<tr>
		<td colspan=2 align="center"><h3>이미지 업로드 폼</h3></td>
	</tr>
	<tr>
		<td>올린 사람 :</td><td><input type="text" name="name"></td><br>
	</tr>
	<tr>
		<td>제목 :</td><td><input type="text" name="subject"></td><br>
	</tr>
	<tr>
		<td>파일명1 :</td><td><input type="file" name="fileName1"></td><br>
	</tr>
	<tr>
		<td colspan=2 align="center"><input type="submit" value="전송"></td>
	</tr>
</table>
</form>
</body>
</html>