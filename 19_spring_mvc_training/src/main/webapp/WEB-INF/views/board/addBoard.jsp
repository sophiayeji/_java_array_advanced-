<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add board</title>
<script src ="${contextPath}/resources/ckeditor/ckeditor.js"></script>


</head>
<body>

		<h3>게시글 작성하기</h3>
		<form action="${contextPath}/board/addBoard" method="post">
			<table border="1" >
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" /></td>
				</tr>
				<tr >
					<td>제목</td>
					<td><input type="text" name="subject" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="passwd" /></td>
				</tr>
				<tr>
					<td>글내용</td>
					<td>
						<textarea  rows="10" cols="50" name="content" ></textarea>
						<script>CKEDITOR.replace("content");</script>
						
					</td>
				</tr>
				<tr >
					<td colspan="2">
						<input type="submit" value="글쓰기" />
						<input type="reset"  value="다시작성" />
						<input type="button" onclick="location.href='${contextPath}/board/boardList" value="목록보기">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>