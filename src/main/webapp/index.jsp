<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSTL Demo</title>
</head>
<body>

<h1>JSTL Test</h1>

<c:forEach var="i" begin="1" end="5" step="1">
   <c:out value="${i}" /><br/>
</c:forEach>
</body>
</html>
