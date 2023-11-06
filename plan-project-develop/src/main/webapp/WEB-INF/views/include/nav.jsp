<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<div>
	<c:if test="${member==null}">
		<a href="${pageContext.request.contextPath}/member/JoinForm.do" class="join">회원가입</a>
		<a href="${pageContext.request.contextPath}/member/LoginForm.do" class="login">로그인</a>
	</c:if>
	<c:if test="${member!=null}">
		<a href="${pageContext.request.contextPath}/member/Mypage.do" class="join">마이페이지</a>
		<a href="${pageContext.request.contextPath}/member/LoginOut.do" class="logout">로그아웃</a>
	</c:if>
</div>
<a href="${pageContext.request.contextPath}/schedule/Myschedule.do" class="schedule">스케줄</a>