<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선물선택</title>
</head>
<body>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>카테고리1</b></td>
      <td><b>카테고리2</b></td>
      <td><b>브랜드</b></td>
      <td><b>상품명</b></td>
      <td><b>상품가격</b></td>
      <td><b>이미지</b></td>
   </tr>
   
    <c:forEach var="gift" items="${giftList}" >     
   <tr align="center">
      <td>${gift.category1}</td>
      <td>${gift.category2}</td>
      <td>${gift.item_brand}</td>
      <td>${gift.item_name}</td>
      <td>${gift.item_price}</td>
      <td>${gift.item_image}</td>
   </tr>
</c:forEach>
</body>
</html>