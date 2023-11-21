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
<form action="${pageContext.request.contextPath}/gift/search.do" method="get">
  <label for="category1">카테고리1:</label>
  <input type="text" id="category1" name="category1">
  
  <label for="category2">카테고리2:</label>
  <input type="text" id="category2" name="category2">
  
  <label for="item_brand">브랜드:</label>
  <input type="text" id="item_brand" name="item_brand">
  
  <label for="item_name">상품명:</label>
  <input type="text" id="item_name" name="item_name">
  
  <button type="submit">검색</button>
</form>

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
      <td><img src="${pageContext.request.contextPath}/resources/image/${gift.item_image}" alt="Gift Image" width="100" height="100"></td>
      

      
   </tr>
</c:forEach>
</body>
</html>