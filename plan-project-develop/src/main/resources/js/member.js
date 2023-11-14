/**
 * 
 */

var idChk = 0;
var idcheck = false;
var pwcheck = false;


/*아이디 유효성 검사*/

function check_id(){
    var id = $('#id').val();
    $.ajax({
        url: "${pageContext.request.contextPath}/member/IdCheck.do", //Controller에서 요청 받을 주소
        type: "post", //POST 방식으로 전달
            data: {
                "id": id
            },
            success:function(data){
                if(data==1){
                    $("#idcheck").text("사용가능한 아이디입니다."); 
                    idcheck=true;
                }else{
                    $("#idcheck").text("이미 사용중인 아이디입니다.");
                    $("#id").val(''); 
                }
            },
            error:function(error){
                $("#idcheck").text("서버와 연결 오류");
            }
        
        });//ajax
};

/*비밀번호 일치 검사*/
$(document).ready(function() {
    $("#pwd2").keyup(function() {
    
        
        
        
        
        var password1 = $("#pwd1").val(); // 첫 번째 입력 비밀번호
        var password2 = $("#pwd2").val(); // 두 번째 입력 비밀번호

        if (password1 !== password2) {
            $("#result").text("비밀번호가 일치하지 않습니다."); // 알림창 띄우기
            $("#pwd1").val(''); // 비밀번호 필드 비우기
            $("#pwd2").val(''); 
        } else {
            $("#result").text("비밀번호 일치"); // 알림창 띄우기
            pwcheck=true;
        }
    });
});

/* 주소 검색 */
  function execDaumPostcode() {
        new daum.Postcode({
            
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if (data.userSelectedType === 'R') {
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if (extraAddr !== '') {
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;

                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("addr").value = addr;
            }
        }).open();

    }
/* 유효성검사후 submit*/
function submit(){
     if (idcheck && pwcheck) { // 아이디 체크와 비밀번호 일치 여부 확인
            return true; // 폼 제출 허용
        } else {
            alert("아이디와 비밀번호를 확인해주세요."); // 사용자에게 경고 표시
            return false; // 폼 제출 차단
        }
    
}



/* 이전 페이지로 이동*/
document.addEventListener("DOMContentLoaded", function() {
    // 폼 요소에 대한 submit 이벤트 리스너 등록
    document.getElementById("Join").addEventListener("submit", function(event) {
        event.preventDefault(); // 기본 제출 동작 방지
        var previousPageURL = document.referrer;
        // URL 객체 생성
         var url = new URL(previousPageURL); // URL 객체 생성 추가
        // 컨텍스트 부분 추출
        var contextPath = "/market_1"; // 고정 부분
        var pathAfterContext = url.pathname.slice(contextPath.length); // 컨텍스트 이후 부분
        
        // 컨텍스트 이후의 경로를 알림창에 표시
        //7 var pathAfterContext = "/list.do";
        // 경로 홈페이지 홈으로 고정시킴
        alert("컨텍스트 이후의 경로: " + pathAfterContext);
        // js에서 값 도출 후 컨트롤러로 보내기 위한
        document.getElementById("path").value = pathAfterContext;
        alert('가입되었습니다.');
        this.submit();
    });
});

