<%--
  Created by IntelliJ IDEA.
  User: Dee_R
  Date: 2/25/2020
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>To-Do List</title>
    <style>
        .center {
            max-width: 500px;
            margin: auto;
        }
    </style>
</head>
<body div class="center">

<jsp:include page="todoForm.jsp" />
<%


%>

<hr div class="center">
<table div class="center">
    <tr><th>Task</th></tr>

    <c: items="${todos}" var="todo">
        <tr><td>${todo.todo}</td><td><a href="delete?id=${todo.count}">delete</a></tr>
    </c:>

</table>
</body>
</html>
