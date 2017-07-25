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

<html>
<head>
    <link rel="stylesheet" href="css/login.css"/>
    <script type="application/javascript" src="jquery/js/jquery-3.2.1.min.js"></script>
    <title>Login Page</title>
</head>

<body>

<div class="app-title">
    <h1>E-Learning App.</h1>
</div>
<!-- Form Module-->
<div class="module form-module">
    <div class="toggle">
    </div>
    <div class="form">
        <h2>Login to your account</h2>
        <form action="login" method="post">
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/> <br/>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/> <br/>
            <button type="submit">Login</button>
        </form>
    </div>
    <s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror/>
        </div>
    </s:if>
</div>
</body>
</html>



