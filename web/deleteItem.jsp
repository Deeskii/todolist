<!doctype html>
<html lang="en">
<head>
    <title>Delete Item</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="design.css">
    <%@ page import="model.Todo" %>
    <%@ page import="servlets.Swiderski_ManageToDoList" %>
</head>
<body>
<%
    servlets.Swiderski_ManageToDoList MTDL = new servlets.Swiderski_ManageToDoList();
%>
<header>WEB UI TO-DO LIST APPLICATION</header>
<nav>
    <a href="showList.jsp">Show To-Do List</a>
    <a href="addItem.jsp">Add To-Do Item</a>
    <a href="deleteItem.jsp" id="selected">Delete To-Do Item</a>
</nav>
<section>
    <h2>Delete To-Do Item</h2>
    <form name="deleteItemForm" id="itemDeleteForm" method="post" action="delete.jsp">
        <label for="item_id">ID for Item: </label>
        <input type="text" name="item_identifier" id="item_id"><br>
        <div id="center_buttonsv2">
            <input type="submit" id="btnSubmit" value="Submit">
            <input type="reset" id="btnClear" value="Clear">
        </div>
    </form>
</section>
</body>
</html>