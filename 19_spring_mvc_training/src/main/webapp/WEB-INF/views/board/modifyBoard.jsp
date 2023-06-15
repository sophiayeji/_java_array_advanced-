<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify board</title>
<script src ="${contextPath }/resources/ckeditor/ckeditor.js" ></script>

</head>
<body>

	<form action="${contextPath}/board/modifyBoard" method="post">
		<h3>게시글 수정하기</h3>
		<table border="1">
			<tr>
				<td>작성일</td>
				<td><fmt:formatDate value="${boardDTO.modifyDt }" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${boardDTO.writer }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="${boardDTO.subject }"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>
					<textarea rows="10" cols="30" name="content"> ${boardDTO.content}</textarea>
					<script>CKEDITOR.replace("content");</script>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name="boardId" value = "${boardDTO.boardId}" >
					<input type="submit" value="수정하기" />
					<input type="button" onclick="location.href='${contextPath}/board/boardList'" value="목록보기" />
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>