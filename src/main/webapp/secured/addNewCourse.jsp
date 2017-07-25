<%--
  Created by IntelliJ IDEA.
  User: Dragos
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
%>
<%@ page session="true" %>
<html>
<head>
    <link rel="stylesheet" href="/css/addNewCourse.css"/>
    <script type="text/javascript" src="/jquery/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/js/addNewCourse.js"></script>
</head>
<body>
<div class="module form-module">
    <div class="toggle">
    </div>
    <div class="form">
        <h2>Create a new course</h2>
        <form id="newCourse">
            <!--Course Name-->
            <div class="input_with_error">
                <label for="newCourse_courseName">Course Name</label>
                <input type="text" id="newCourse_courseName" name="courseName"/>
                <span class="error">This field is required</span>
            </div>

            <!--Category-->
            <label for="category">Category</label>
            <select id="category" name="category">
                <option value="Software">Software</option>
                <option value="Hardware">Hardware</option>
            </select>

            <!--Number of lectures-->
            <label for="numberOfLectures">Number of lectures</label>
            <input type="number" value="3" min="3" max="12" id="numberOfLectures" name="numberOfLectures"/>
            <span class="error">This field is required</span>

            <!--Description-->
            <div class="input_with_error">
                <label for="newCourse_description">Description</label>
                <textarea id="newCourse_description" rows="5" cols="57" name="description"></textarea>
                <span class="error">This field is required</span>
            </div>

            <button type="button" id="submit">Add Course</button>
        </form>
    </div>
    <div id="message" style="display: none" align="center"></div>
</div>
</body>
</html>
