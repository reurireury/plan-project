<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- js 스크립트 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<div>
	<c:if test="${member==null}">
		<a href="${pageContext.request.contextPath}/member/JoinForm.do" class="join">회원가입</a>
		<a href="${pageContext.request.contextPath}/member/LoginForm.do" class="login">로그인</a>
	</c:if>
	<c:if test="${member!=null}">
		<a href="${pageContext.request.contextPath}/member/MypageForm.do?id=${member.id}" class="join">마이페이지</a>
		<a href="${pageContext.request.contextPath}/member/LogOut.do" class="logout">로그아웃</a>
		<a href="${pageContext.request.contextPath}/schedule/Myschedule.do" class="schedule">스케줄</a>
		<a href="${pageContext.request.contextPath}/gift/GiftList.do" class="gift">선물하기</a>
	</c:if>
	<%-- 로그아웃 알림--%>
	<% if (request.getAttribute("logoutMessage") != null) { %>
	    <script type="text/javascript">
	        alert("<%= request.getAttribute("logoutMessage") %>");
	    </script>
	<% } %>
</div>
