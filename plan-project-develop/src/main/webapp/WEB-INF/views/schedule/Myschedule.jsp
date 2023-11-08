<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<%@page import="java.util.List"%>
<%@page import="com.spring.market_1.schedule.dto.ScheduleDTO"%>   

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
 <!-- Bootstrap 5.2.3 Version -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>




<head>




<meta charset="UTF-8">
	<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>
	<script>
        
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
	  <!-- Edit Modal -->
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
    <script>
	
	
	document.addEventListener('DOMContentLoaded', function () {
	    var calendarEl = document.getElementById('calendar');
	    
	    var scheduleList = []; // 일정 데이터를 저장할 배열

	    // 서버에서 받은 scheduleList를 JavaScript 배열로 변환
	    /*스케줄 가져오기*/
	    <%
	    List<ScheduleDTO> scheduleList = (List<ScheduleDTO>) request.getAttribute("scheduleList");
	    if (scheduleList != null) {
	    %>
	    <% for (ScheduleDTO schedule : scheduleList) { %>
	        scheduleList.push({
	          	id:id,
	        	title: '<%= schedule.getTitle() %>',
	            start: '<%= schedule.getStart1() %>',
	            end: '<%= schedule.getEnd1() %>',
	            // 필요한 경우 추가 속성을 여기에 추가
	            $("#calendarModal").modal("show");
	        });
	    <% } %>
	    <% } %>

	    
	    
	    var calendar = new FullCalendar.Calendar(calendarEl, {
	        initialView: 'dayGridMonth',
	        contentHeight: 600,
	        locale: 'ko',
	        headerToolbar: {
	            left: 'prev,next today',
	            center: 'title',
	            right: 'dayGridMonth'
           	   /*right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'*/
	        },
	        dateClick: function(info) {
                alert('Clicked on: ' + info.dateStr); // 날짜 띄우는 것까지 성공 ㅅㅂ
                $("#calendarModal").modal("show");
            }
	        
	        
	        
	        
	        events: scheduleList, // scheduleList를 사용하여 이벤트 설정
	    });

	    // 캘린더 렌더링
	    calendar.render();
	});

	/*
	
	
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            dateClick: function(info) {
                alert('Clicked on: ' + info.dateStr); 
                $("#calendarModal").modal("show");
            }
        });
        calendar.render();
    });
	
	*/
	
	</script>


	
</body>
</html>