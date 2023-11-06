<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />



<head>
<meta charset="UTF-8">
	<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>
	<script>
	  document.addEventListener('DOMContentLoaded', function() {
	    // 캘린더 요소 가져오기
	    var calendarEl = document.getElementById('calendar');
	
	    // FullCalendar 인스턴스 생성
	    var calendar = new FullCalendar.Calendar(calendarEl, {
	      initialView: 'dayGridMonth', // 캘린더 초기 뷰 설정
	      contentHeight: 600, // 캘린더 높이 설정
	      events: [
	        // 일정 데이터 추가, DB의 이벤트를 가져오려면 JSON 형식으로 변환하여 이곳에 추가
	        {
	          title: '일정',
	          start: '2023-11-06 00:00:00',
	          end: '2023-11-08 24:00:00',
	          // 색상을 변경하려면 'color' 속성을 추가할 수 있음
	        }
	      ],
	      headerToolbar: {
	        center: 'addEventButton' // 헤더에 버튼 추가
	      },
	      customButtons: {
	        addEventButton: {
	          text: "내 스케줄 추가", // 버튼 내용
	          click: function() { // 버튼 클릭 시 이벤트 추가
	            $("#calendarModal").modal("show"); // 모달 표시
	
	            $("#addCalendar").on("click", function() { // 모달의 추가 버튼 클릭 시
	              var content = $("#calendar_content").val();
	              var start_date = $("#calendar_start_date").val();
	              var end_date = $("#calendar_end_date").val();
	
	              // 내용 입력 여부 확인
	              if (content == null || content == "") {
	                alert("내용을 입력하세요.");
	              } else if (start_date == "" || end_date == "") {
	                alert("날짜를 입력하세요.");
	              } else if (new Date(end_date) - new Date(start_date) < 0) { // 날짜 비교
	                alert("종료일이 시작일보다 먼저입니다.");
	              } else { // 정상적인 입력일 때
	                var obj = {
	                  "title": content,
	                  "start": start_date,
	                  "end": end_date
	                }; // 전송할 객체 생성
	
	                console.log(obj); // 서버로 해당 객체를 전달하여 DB 연동 가능
	              }
	            });
	          }
	        }
	      },
	    });
	
	    // 캘린더 렌더링
	    calendar.render();
	  });
	</script>

<title>내 스케줄 관리페이지</title>
</head>
<body>
	<nav>
 		<jsp:include page="../include/nav.jsp"/>
	</nav>
	<div id="calendarBox">
        <div id="calendar"></div>
    </div>

	<!-- modal 추가 -->
    <div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">일정을 입력하세요.</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskId" class="col-form-label">일정 내용</label>
                        <input type="text" class="form-control" id="calendar_content" name="calendar_content">
                        <label for="taskId" class="col-form-label">시작 날짜</label>
                        <input type="date" class="form-control" id="calendar_start_date" name="calendar_start_date">
                        <label for="taskId" class="col-form-label">종료 날짜</label>
                        <input type="date" class="form-control" id="calendar_end_date" name="calendar_end_date">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-warning" id="addCalendar">추가</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        id="sprintSettingModalClose">취소</button>
                </div>
    
            </div>
        </div>
    </div>


	
</body>
</html>