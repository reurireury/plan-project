<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<a href="${pageContext.request.contextPath}/member/JoinForm.do" class="join">회원가입</a>
<a href="${pageContext.request.contextPath}/member/LoginForm.do" class="login">로그인</a>
<a href="${pageContext.request.contextPath}/schedule/Myschedule.do" class="schedule">스케줄</a>