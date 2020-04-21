<%@ page import="model.Todo" %>
<%@ page import="servlets.ManageToDoList" %>
<%
    ManageToDoList MTDL = new ManageToDoList();

    String itemID = request.getParameter("item_identifier");

    MTDL.deleteItem(itemID);

    String site = new String("http://localhost:8081/todolist_war_exploded/todoList.jsp");
    response.setStatus(301);
    response.setHeader("Location", site);
    response.setHeader("Connection", "close");
%>