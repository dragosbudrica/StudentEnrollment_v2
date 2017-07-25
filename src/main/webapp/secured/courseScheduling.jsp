<%--
  Created by IntelliJ IDEA.
  User: Dragos
  Date: 21.07.2017
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
%>
<%@ page session="true" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href='/fullcalendar-3.4.0/fullcalendar.css' rel='stylesheet'/>
    <link href='/fullcalendar-3.4.0/fullcalendar.print.min.css' rel='stylesheet' media='print'/>
    <link href='/jquery-ui-1.11.2/jquery-ui.min.css' rel='stylesheet'/>
    <link rel="stylesheet" href="/css/courseScheduling.css"/>

    <script type="text/javascript" src="/fullcalendar-3.4.0/lib/moment.min.js"></script>
    <script type="text/javascript" src="/fullcalendar-3.4.0/lib/jquery.min.js"></script>
    <script type="text/javascript" src="/fullcalendar-3.4.0/lib/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/fullcalendar-3.4.0/fullcalendar.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.2.3/jquery-confirm.min.css">
    <script type="text/ecmascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.2.3/jquery-confirm.min.js"></script>
    <script type="text/javascript" src="/js/courseScheduling.js"></script>
</head>
<body>
<div id="eventContent" title="Course Details" style="display:none;">
    <label for="courseName">Course Name:</label>
    <select id="courseName"></select> <br/><br/>
    <label for="startTime">From:</label>
    <input type="datetime-local" id="startTime"/> <br/><br/>
    <button type="button" id="submit">Save</button>
</div>
<div id="content">
    <div id='calendar'></div>
    <div id="message" style="display: none" align="center"></div>
</div>
</body>
</html>
