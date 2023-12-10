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
<title>선물검색확인창</title>
</head>
<body>
    <h2>선물 검색 결과창</h2>

    <c:if test="${not empty giftList}">
        <table border="1">
            <thead>
                <tr>
                    <th>카테고리 1</th>
                    <th>카테고리 2</th>
                    <th>브랜드</th>
                    <th>상품명</th>
					<th>가격</th>
					<th>이미지</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="gift" items="${giftList}">
                    <tr>
                        <td>${gift.category1}</td>
                        <td>${gift.category2}</td>
                        <td>${gift.item_brand}</td>
                        <td>${gift.item_name}</td>
						<td>${gift.item_price}</td>
						<td><img src="${pageContext.request.contextPath}/resources/image/${gift.item_image}" alt="Gift Image" width="100" height="100"></td>
						
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty giftList}">
        <p>존재하지않는 상품입니다</p>
    </c:if>

    <!-- Add any additional content or styling as needed -->

</body>
</html>
</body>
</html>