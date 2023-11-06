<%@ page language="java" 
    pageEncoding="UTF-8"%>
<!-- js 스크립트 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!--주소검색 --> 
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!DOCTYPE html>
<html>
<head>
	
<script src="/resources/js/member.js"></script>
</head>
<body>	
	<nav>
 		<jsp:include page="../include/nav.jsp"/>
	</nav>
	<main>
		<form id="Join" class="Join" action="${pageContext.request.contextPath}/member/AddObject.do" method="post" onsubmit="return submit()">
			<div class="form-group">
				<label>아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="id" required>
				<!-- 아이디 유효성 검사 스크립트 -->
				<button type="button" id="check-id" onclick="check_id()">아이디 확인</button>
				<span id="idcheck"></span> 	
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" class="form-control" id="pwd1"  placeholder="8~20자이내로 입력하세요" required>
			</div>
			<div class="form-group">
				<label>비밀번호 확인</label>
				<input type="password" class="form-control" id="pwd2" name="pwd">
				<!-- 비밀번호 검증 결과창 -->				
				<span id="result"></span> 	
			</div>
			<div class="form-group">
	            <label for="name">이름</label>
	       	    <input type="text"  id="name" name="name" placeholder="이름" required>
	        </div>
	        <div class="form-group">
	            <label for="email">생년월일</label>
	            <input type="text"  id="birth" name="birth" placeholder="8자로 입력해주세요" required>
	        </div>
	      	<div class="form-group">
	            <label for="email">이메일</label>
	            <input type="text"  id="email" name="email" placeholder="이메일" required>
	        </div>
	        <div class="form-group">
	            <label for="addr">주소</label>
	            <div class="form-group">
		            <input type="text" class="form-control" id="postcode"  name="postcode"placeholder="우편번호">
		            <input type="button"  class="btn" onclick="execDaumPostcode()" value="우편번호 찾기">
	            </div>
            <div class="form-group"></div>
	            <input type="text" class="form-control " id="addr" name="addr" placeholder="주소">
	            <input type="text" class="form-control" id="detailAddress" name="detailAddress" placeholder="상세주소">
	            <input type="text" class="form-control " id="extraAddress" name="extraAddress" placeholder="참고항목" >
       		</div>
       		<div class="form-group">
	            <label for="phone">연락처</label>
	            <input type="text" class="form-control " id="phone" name="phone" placeholder="연락처" required>
       		</div>
	        <div class="form-group">
     	       <button type="submit" class="btn btn-success">가입하기</button>
	        </div>
	        <!-- js에서 controller로 이전 경로 보내기 위한 값 -->
      	    <input type="hidden" id="path" name="path" value="">
		</form>
		
		<script src="/resources/js/member.js"></script>
	</main>
	<script>
	
		
		
		</script>
	
	
	<footer>
	</footer>

</body>
</html>

