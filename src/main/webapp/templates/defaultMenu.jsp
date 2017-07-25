<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="role" value="${sessionScope.user.role}" />

<nav>
    <img class="logo" src="/resources/images/elearning.png"/>
    <ul id="menu">
        <c:if test="${role eq 'Admin'}">
            <li><a href="/secured/newAccount.action">New Account</a></li>
            <li><a href="/secured/courseScheduling.action">Scheduling</a></li>
        </c:if>

        <c:if test="${role eq 'Professor'}">
            <li><a href="/secured/professorCourses.action">My Courses</a></li>
            <li><a href="/secured/newCourse.action">Add Course</a></li>
            <li><a href="/secured/timetable.action">Timetable</a></li>
        </c:if>

        <c:if test="${role eq 'Student'}">
            <li><a href="/secured/allCourses.action">All Courses</a></li>
            <li><a href="/secured/studentCourses.action">My Courses</a></li>
            <li><a href="/secured/timetable.action">Timetable</a></li>
        </c:if>
    </ul>
</nav>