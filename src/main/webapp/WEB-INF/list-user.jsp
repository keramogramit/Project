
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp" %>
<body>
<c:forEach var="user" items="${requestScope.users}">
    <p>Edit <a href="edit-user?id=${user.id}">${user.login}</a></p>
</c:forEach>

</body>

