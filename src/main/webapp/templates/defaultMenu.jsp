<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="role" value="${sessionScope.user.getRole()}" />
<nav>
    <img class="logo" src="/resources/images/elearning.png"/>
    <ul id="menu">
        <c:if test="${role eq 'Admin'}">
            <li><a href="/secured/newAccount.jsp">New Account</a></li>
            <li><a href="/secured/courseScheduling.jsp">Scheduling</a></li>
        </c:if>

        <c:if test="${role eq 'Professor'}">
            <li><a href="/secured/professorCourses.jsp">My Courses</a></li>
            <li><a href="/secured/addNewCourse.jsp">Add Course</a></li>
            <li><a href="/secured/timetable.jsp">Timetable</a></li>
        </c:if>

        <c:if test="${role eq 'Student'}">
            <li><a href="/secured/allCourses.jsp">All Courses</a></li>
            <li><a href="/secured/studentCourses.jsp">My Courses</a></li>
            <li><a href="/secured/timetable.jsp">Timetable</a></li>
        </c:if>
    </ul>
</nav>