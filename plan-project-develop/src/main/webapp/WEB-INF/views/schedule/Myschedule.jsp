<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page import="java.util.List"%>
<%@page import="com.spring.market_1.schedule.dto.ScheduleDTO"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<html>

<head>
    <!-- jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- bootstrap 4 -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
    <title>내 스케줄 관리페이지</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<!-- fullcalendar -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>

	<!-- 
	<script>
        document.addEventListener('DOMContentLoaded', function() {
        	$(function () { // ajax로 json을 가져온다.
                var request = $.ajax({ 
                    type: "get",
                    url: "${pageContext.request.contextPath}/schedule/ListObjects.do", // restController mapping
                    dataType: "json",
                });
                request.done(function(data) { // ajax가 성공적일 경우, data를 받는다.
                    console.log(data);

                    var calendarEl = document.getElementById('calendar');
                    var calendar = new FullCalendar.Calendar(calendarEl, {
                        initialView: 'dayGridMonth',
                        events:data,
                    
                    });
                    calendar.render();
                }); // request.done
                
                


                request.fail(function(jqXHR, textStatus) {
                    alert("Request failed: " + textStatus);
                });
            }); // function
        });
    </script>
 -->
<script>
    document.addEventListener('DOMContentLoaded', function() {
        $(function () { // ajax로 json을 가져온다.
            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth',
                events: "${pageContext.request.contextPath}/schedule/ListObjects.do", // 이벤트 초기 데이터 가져오기
                selectable: true, // 날짜 선택 가능하도록 설정
                select: function (arg) { // 캘린더에서 이벤트를 생성할 수 있다.
                    var title = prompt('일정을 입력해주세요.');
                    if (title) {
                        calendar.addEvent({
                            title: title,
                            start: arg.start,
                            end: arg.end,
                        });

                        // 여기에서 서버로 일정을 추가하는 Ajax 요청을 보낼 수 있습니다.
                        // 서버로 보낼 데이터 예시: { title: title, start: arg.start, end: arg.end, allDay: arg.allDay }
                        $.ajax({
                            type: "post",
                            url: "${pageContext.request.contextPath}/schedule/AddObject.do",
                            data: {
                                title: title,
                                start: arg.start,
                                end: arg.end,
                                allDay: arg.allDay
                            },
                            success: function(response) {
                                console.log("일정이 성공적으로 추가되었습니다.");
                            },
                            error: function(error) {
                                console.error("일정 추가 중 오류가 발생했습니다.");
                            }
                        });
                    }
                    calendar.unselect();
                }
            });

            calendar.render();
        }); // function
    });
</script>

<!-- ... (기존 코드) ... -->




</head>

<body>
    <nav>
        <jsp:include page="../include/nav.jsp" />
    </nav>

    <main>
    
    
    
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

        <div id="eventModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h2>일정 추가</h2>
                <form id="eventForm">
                    <label for="eventTitle">일정 제목:</label>
                    <input type="text" id="eventTitle" name="title" required>
                    <label for="eventDate">일정 날짜:</label>
                    <input type="text" id="eventDate" name="date" readonly>
                    <button type="submit">일정 추가</button>
                </form>
            </div>
        </div>
    </main>

   
</body>

</html>
