<%@ page import="model.Todo" %>
<%@ page import="servlets.Swiderski_ManageToDoList" %>
<%
    servlets.Swiderski_ManageToDoList MTDL = new servlets.Swiderski_ManageToDoList();

    String itemID = request.getParameter("item_identifier");
    String itemDesc = request.getParameter("item_desc");

    MTDL.addItem(itemID, itemDesc);

    String site = new String("http://localhost:8081/todolist_war_exploded/todoList.jsp");
    response.setStatus(301);
    response.setHeader("Location", site);
    response.setHeader("Connection", "close");
%>