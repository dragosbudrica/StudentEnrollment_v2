<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Dialog - Default functionality</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#dialog").dialog({title: "Basic Modal"});
        });
    </script>
    <title>JSTL Demo</title>
</head>
<body>

<h1>JSTL Test</h1>

<c:forEach var="i" begin="1" end="5" step="1">
    <c:out value="${i}"/><br/>
</c:forEach>

<a href="/download?lectureId=55">Download this file</a>

<s:form action="upload" namespace="/"
        method="POST" enctype="multipart/form-data">
    <s:file name="fileUpload" label="Select a File to upload"/>
    <s:submit value="Submit"/>
</s:form>

<div id="dialog">
    <p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized
        and closed with the 'x' icon.</p>
</div>
</body>
</html>
