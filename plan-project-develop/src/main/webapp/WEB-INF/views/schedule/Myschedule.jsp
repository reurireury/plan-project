<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page import="java.util.List"%>
<%@page import="com.spring.market_1.schedule.dto.ScheduleDTO"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<html>
<head>
 <meta charset='utf-8' />
 	<!-- bootstrap 4 -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 	
 	<!-- 날짜선택 -->
 	<script src='fullcalendar/dist/index.global.js'></script>
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.9/index.global.min.js'></script>
   

</head>

<body>
	<nav>
 		<jsp:include page="../include/nav.jsp"/>
	</nav>
	
	
	<script>
	 document.addEventListener('DOMContentLoaded', function() {
	        var calendarEl = document.getElementById('calendar');
	        var calendar = new FullCalendar.Calendar(calendarEl, {
	          initialView: 'dayGridMonth'
	        });
	        calendar.render();
	      });
	</script>

	<main>
    <div id="calendarBox">
        <div id="calendar"></div>
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
	<script>

document.addEventListener('DOMContentLoaded', function() {
  
  $(function () { //ajax로 json을 가지고 온다.
    var request = $.ajax({ 
      type: "get",
      url: "${pageContext.request.contextPath}/schedule/ListObjects.do", //restController mapping
      dataType: "json",
    });

    request.done(function(data) { //ajax가 성공적일 경우, data를 받는다.
      console.log(data);

      var calendarEl = document.getElementById('calendar');
      var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        selectable: true, //날짜 드래그해서 지정가능
        selectMirror: true,
        displayEventEnd: { //시작시간, 끝나는 시간 다 보이게 하기
          month: false,
          basicWeek: true,
          "default": true
        },
        dayMaxEventRows: true, //일정이 너무 많으면 more버튼으로 일정확인
        views: {
          timeGrid: {
            dayMaxEventRows: 6 // adjust to 6 only for timeGridWeek/timeGridDay
          }
        },
        events: data, // 돌려받은 json 그 자체
      });

      calendar.render();
    });
  });
});

</script>

	
	
	</main>
	
</body>



</html>