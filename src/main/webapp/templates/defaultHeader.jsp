<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="firstName" value="${sessionScope.user.firstName}" />
<div>
    <form action="logout" method="post">
        <h2 style="display: inline; margin-left: 2%"><c:out value="Welcome, ${firstName}!" /> </h2>
        <button style="display: inline; margin-left: 85%" id="logout"><img src="/resources/images/rsz_56805.png" /></button>
    </form>
</div>
