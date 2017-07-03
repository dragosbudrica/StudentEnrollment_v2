<%@ taglib prefix="c" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Dragos
  Date: 29.06.2017
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <link rel="stylesheet" href="css/login.css"/>

    <script type="application/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" src="js/login.js"></script>
    <title>Login Page</title>
</head>

<body>

<div class="app-title">
    <h1>Student Enrollment</h1>
</div>
<!-- Form Module-->
<div class="module form-module">
    <div class="toggle">
    </div>
    <div class="form">
        <h2>Login to your account</h2>
        <form action="login">
            <input type="text" id="email"/> <br/>
            <input type="password" id="password"/> <br/>
            <button type="button" id="submit">Login</button>
        </form>
    </div>
    <div id="warning" style="display: none; color: red" align="center"></div>
</div>
</body>
</html>



