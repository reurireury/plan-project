<%@ page language="java" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- ajax -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<html>
<head>
	
</head>
<body>	


	<nav>
 		<jsp:include page="../include/nav.jsp"/>
	</nav>
	<main>
			<form name="login"  method="POST" autocomplete="off" action="${pageContext.request.contextPath}/member/login.do">
				<!-- 원래 호출한 곳으로 돌아가기 위한  -->
   				<input type="hidden" id="path1" name="path1" value="">
   				
				<div>
					<label for="아이디"></label>
					<input type="text" name="id" id="id" class="form-control" placeholder="아이디" required="" autofocus="">
					<label for="비밀번호">비밀번호</label>
					<input type="password" name="pwd" id="pwd" class="form-control" placeholder="비밀번호" required="">
				</div>
					<div id="loginResult" style="color:red;">
				</div>
				<div>
					<button type="button"  id="loginbutton"  >로그인</button>
				</div>
				<div>
					<a href="${pageContext.request.contextPath}/member/JoinForm.do">회원 가입</a> 
					<!--a href="https://xn--ok0b236bp0a.com/bbs/password_lost.php" id="login_password_lost">암호를 분실하셨나요?</a-->
				</div>
			</form>
	</main>
	<script>
	   $(document).ready(function() {
	        $("#loginbutton").click(function() {
	        	 event.preventDefault(); // 폼 제출 방지
	            alert('로그인버튼 실행');
	            var id = $("#id").val();
	            var pwd = $("#pwd").val();
	            
	            console.log(id);
	            console.log(pwd);
	            $.ajax({
	                type: "POST",
	                url: "${pageContext.request.contextPath}/member/Login.do",
	                data: {
	                    id: id,
	                    pwd: pwd
	                },
	                
	                dataType: "text",
	                success: function(data, status) {
	                        $("#loginResult").text("로그인 성공: " + id); // 성공 시 표시
	                        var previousPageURL = document.referrer;
	     	            	console.log(previousPageURL);
	     	                var url = new URL(previousPageURL); // URL 객체 생성 추가
	     	                var contextPath = "/market_1"; // 고정 부분
	     	                var pathAfterContext = url.pathname.slice(contextPath.length); // 컨텍스트 이후 부분
	                        
	                        var prepath = "${pageContext.request.contextPath}";
	                        alert("컨텍스트 이후의 경로: " + pathAfterContext);
	     	             	  // js에서 값 도출 후 컨트롤러로 보내기 위한
	     	             	document.getElementById("path1").value = pathAfterContext;
	                        window.location.href= prepath + pathAfterContext;
	                },
	                error: function() {
	                    $("#loginResult").text("아이디와 비밀번호를 확인하세요"); // 오류 시 표시
	                    $("#id").val('');
	                    $("#pwd").val('');
	                }
	            }) //ajax
	            
	        }) //form1
	    });
	   
	  
	   
	</script>
	
	<footer>
	</footer>

</body>
</html>