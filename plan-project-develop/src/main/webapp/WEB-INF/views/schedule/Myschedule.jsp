<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.spring.market_1.schedule.dto.ScheduleDTO"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>

<head>
    <!-- jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- popper.js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <!-- bootstrap 4 -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!-- fullcalendar -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>
    <!-- luxon lib -->
    <script src='https://cdn.jsdelivr.net/npm/luxon@1.24.1/build/global/luxon.min.js'></script>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            $(function () {
                var calendarEl = document.getElementById('calendar');
                var calendar = new FullCalendar.Calendar(calendarEl, {
                    initialView: 'dayGridMonth',
                    events: "${pageContext.request.contextPath}/schedule/ListObjects.do", // 이벤트 초기 데이터 가져오기
                    selectable: true, // 날짜 선택 가능하도록 설정
                    select: function (arg) { // 캘린더에서 이벤트를 생성할 수 있다.
                        $('#calendarModal').modal('show');
                        $('#calendar_start_date').val(arg.startStr);
                        $('#calendar_end_date').val(arg.endStr);
                    }
                });

                // 추가 버튼 클릭 시
                $('#addCalendar').on('click', function () {
                    var title = $('#calendar_title').val();
                    var content = $('#calendar_content').val();
                    var start = $('#calendar_start_date').val();
                    var end = $('#calendar_end_date').val();

                    if (title && start && end) {
                        var formattedStart = luxon.DateTime.fromISO(start).toFormat('yyyy-MM-dd');
                        var formattedEnd = luxon.DateTime.fromISO(end).toFormat('yyyy-MM-dd');

                        calendar.addEvent({
                            title: title,
                            start: formattedStart,
                            end: formattedEnd,
                        });

                        $.ajax({
                            type: "post",
                            url: "${pageContext.request.contextPath}/schedule/AddObject.do",
                            data: {
                                title: title,
                                content:content,
                                start1: formattedStart,
                                end1: formattedEnd
                            },
                            success: function (response) {
                                console.log("일정이 성공적으로 추가되었습니다.");
                            },
                            error: function (error) {
                                console.error("일정 추가 중 오류가 발생했습니다.");
                            }
                        });

                        $('#calendarModal').modal('hide');
                    }
                });

                calendar.render();
            }); // function
        });
    </script>

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
                       		<label for="calendar_title" class="col-form-label">일정 제목1</label>
                            <input type="text" class="form-control" id="calendar_title" name="calendar_title">
                            <label for="calendar_content" class="col-form-label">일정 내용</label>
                            <input type="text" class="form-control" id="calendar_content" name="calendar_content">
                            <label for="calendar_start_date" class="col-form-label">시작 날짜</label>
                            <input type="date" class="form-control" id="calendar_start_date" name="calendar_start_date">
                            <label for="calendar_end_date" class="col-form-label">종료 날짜</label>
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
    </main>
</body>
</html>
                       
