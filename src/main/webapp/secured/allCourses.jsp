<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dragos
  Date: 30.06.2017
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script type="text/ecmascript" src="/jquery/js/jquery-3.2.1.min.js"></script>
    <script type="text/ecmascript" src="/jquery/js/jquery.jqGrid.min.js"></script>
    <script type="text/ecmascript" src="/jquery/js/grid.locale-en.js"></script>
    <link rel="stylesheet" href="/jquery-ui-1.11.2/jquery-ui.css"/>
    <link rel="stylesheet" href="/jquery/css/ui.jqgrid.css"/>
    <link rel="stylesheet" href="/css/allCourses.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.2.3/jquery-confirm.min.css">
    <script type="text/ecmascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.2.3/jquery-confirm.min.js"></script>
    <script type="text/javascript" src="/js/allCourses.js"></script>
</head>
<body>
<div id="allCourses">
    <table id="grid"></table>
    <div id="jqGridPager"></div>
    <div id="message2" style="display: none" align="center"></div>
</div>
</body>
</html>
