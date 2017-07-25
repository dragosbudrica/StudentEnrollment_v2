<%--
  Created by IntelliJ IDEA.
  User: Dragos
  Date: 12.07.2017
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="role" value="${sessionScope.user.role}" />
<c:set var="courseName" value="${courseName}" />
<script>
    var role = '${role}';
    var courseName = '${courseName}';
</script>
<html>

<head>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="/css/font-awesome-4.7.0/css/font-awesome.min.css">
    <script type="text/ecmascript" src="/jquery/js/jquery-3.2.1.min.js"></script>
    <script type="text/ecmascript" src="/jquery/js/jquery.jqGrid.min.js"></script>
    <script type="text/ecmascript" src="/jquery/js/grid.locale-en.js"></script>
    <link rel="stylesheet" href="/jquery-ui-1.11.2/jquery-ui.css"/>
    <link rel="stylesheet" href="/jquery/css/ui.jqgrid.css"/>
    <link rel="stylesheet" href="/css/courseDetails.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.2.3/jquery-confirm.min.css">
    <script type="text/ecmascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.2.3/jquery-confirm.min.js"></script>
    <script type="text/javascript" src="/js/courseDetails.js"></script>
</head>


<body>
<div id="courseDetails">
    <table id="grid"></table>
    <div id="jqGridPager"></div>
</div>

</body>
</html>
