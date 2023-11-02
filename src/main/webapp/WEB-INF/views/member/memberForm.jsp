<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="${contextPath }/member/addMember.do" method="post">
			id : <input type="text" name="id" required><br>
			pwd : <input type="password" name="pwd"> <br>
			name : <input type="text" name="name"><br>
			addr : <input type="text" name="addr"><br>
			phone : <input type="text" name="phone" placeholder="- exception"><br>
			<input type="submit" value="submit">
		</form>
		${contextPath }
	</body>
</html>