<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"
    import="java.util.*,com.spring.market_1.schedule.dto.ScheduleDTO"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
	List<ScheduleDTO> list = (ArrayList<ScheduleDTO>)request.getAttribute("showSchedule");
%>


<head>
<meta charset="UTF-8">
	<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>
	<script>
  document.addEventListener('DOMContentLoaded', function() {
	 
    var calendarEl = document.getElementById('calendar');
	
    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list' ],
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
      },
      locale : "ko",
      navLinks: true, // can click day/week names to navigate views
      businessHours: true, // display business hours
      editable: true,
      events: [
<% 
  	  for (int i = 0; i < list.size(); i++) {
  	  	ScheduleDTO dto = (ScheduleDTO)list.get(i);
%>	
  	  {
  	   title : '<%= dto.getSubject() %>',
  	   start : '<%= dto.getStartDate() %>',
  	   end : '<%= dto.getEndDate() %>'
  	   },
<%
	}
%>
		{
		   title : 'default',
		   start : "2019-01-01",
		   end : "2019-01-01"
		  }
      ]
    });

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
</body>

</html>