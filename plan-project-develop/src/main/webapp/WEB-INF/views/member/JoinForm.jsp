<%@ page language="java" 
    pageEncoding="UTF-8"%>
<!-- js 스크립트 -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	

</head>
<body>	
	<nav>
 		<jsp:include page="../include/nav.jsp"/>
	</nav>
	<main>
		<form class="Join" action="${contextPath}/member/AddObject.do" method="post">
			<div class="form-group">
				<label>아이디</label><input type="text" class="form-control" id="id" name="id" placeholder="이름" required>
				<!-- 아이디 유효성 검사 스크립트 -->
				<button type="button" id="check-id" onclick="check_id()">아이디 확인</button>
			</div>
			<div class="form-group">
				<label>비밀번호</label><input type="password" class="form-control" id="pwd1"  placeholder="8~20자이내로 입력하세요" required>
			</div>
			<div class="form-group">
				<label>비밀번호 확인</label><input type="pass word" class="form-control" id="pwd2" name="pwd">
				<!-- 비밀번호 검증 결과창 -->				
				<span id="result"></span> 	
			</div>
			<div class="form-group">
	            <label for="name">이름</label>
	       	    <input type="text"  id="name" name="name" placeholder="이름" required>
	        </div>
	      	<div class="form-group">
	            <label for="email">이메일</label>
	            <input type="text"  id="email" name="email" placeholder="이메일" required>
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
	             <input type="text" class="form-control " id="phone" name="phone" placeholder="연락처" required>
       		</div>
	        <div class="form-group">
     	       <button type="submit" class="btn btn-success">가입하기</button>
	        </div>
		</form>
	</main>
	<script>
		/*아이디 유효성 검사*/
	
		/*비밀번호 일치 검사*/
		$(document).ready(function() {
		    alert('js실행확인');
		
		    $("#pwd2").blur(function() {
		        var password1 = $("#pwd1").val(); // 첫 번째 입력 비밀번호
		        var password2 = $("#pwd2").val(); // 두 번째 입력 비밀번호
		
		        if (password1 !== password2) {
		            $("#result").text("비밀번호가 일치하지 않습니다."); // 알림창 띄우기
		            $("#pwd1").val(''); // 비밀번호 필드 비우기
		            $("#pwd2").val(''); 
		        } else {
		            $("#result").text("비밀번호 일치"); // 알림창 띄우기
		        }
		    });
		});
	</script>
	
	
	<footer>
	</footer>

</body>
</html>