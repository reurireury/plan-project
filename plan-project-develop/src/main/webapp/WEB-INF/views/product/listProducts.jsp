<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>상품번호</b></td>
      <td><b>상품이름</b></td>
      <td><b>가격</b></td>
      <td><b>수량</b></td>
      <td><b>조회수</b></td>
      <td><b>상태</b></td>
      <td><b>카테고리</b></td>
      <td><b>분류</b></td>
      <td><b>좋아요</b></td>
      <td><b>거래방법</b></td>
      <td><b>거래장소</b></td>
   </tr>
   
 <c:forEach var="product" items="${productsList}" >     
   <tr align="center">
      <td>${product.p_no}</td>
      <td>${product.p_name}</td>
      <td>${product.p_price}</td>
      <td>${product.p_amount}</td>
      <td>${product.p_hits}</td>
      <td>${product.p_stat}</td>
      <td>${product.p_cate1}</td>
      <td>${product.p_cate2}</td>
      <td>${product.p_like}</td>
      <td>${product.p_how}</td>
      <td>${product.p_addr}</td>
      <td><a href="${contextPath}/member/removeMember.do?id=${member.id }">삭제하기</a></td>
    </tr>
  </c:forEach>   
</table>
<a  href="${contextPath}/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>
