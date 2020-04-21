<%--
  Created by IntelliJ IDEA.
  User: Dee_R
  Date: 2/26/2020
  Time: 1:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page import="model.Todo" %>
<%@ page import="servlets.TodoCreateServlet" %>
<%@ page import="services.TodoJDBCService" %>
<%
    servlets.TodoCreateServlet MTDL = new servlets.TodoCreateServlet();

    String itemID = request.getParameter("item_identifier");
    String itemDesc = request.getParameter("item_desc");

    MTDL.addItem(itemID,itemDesc);

    String site = new String("http://localhost:8081/todolist_war_exploded/todoList.jsp");
    response.setStatus(301);
    response.setHeader("Location", site);
    response.setHeader("Connection", "close");
%>
</body>
</html>
