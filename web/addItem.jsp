<!doctype html>
<html lang="en">
<head>
    <title>Add Item</title>
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
    <a href="addItem.jsp" id="selected">Add To-Do Item</a>
    <a href="deleteItem.jsp">Delete To-Do Item</a>
</nav>
<section>
    <h2>Add To-Do Item</h2>
    <div id="form_container">
        <form name="addItemForm" id="itemAddForm" method="post" action="create.jsp">
            <label for="item_id">ID for Item: </label>
            <input type="text" name="item_identifier" value="" id="item_id"><br>
            <label for="item_value">Description for Item: </label>
            <input type="text" name="item_desc" id="item_value"><br>
            <div id="center_buttonsv2">
                <input type="submit" id="btnSubmit" value="Submit">
                <input type="reset" id="btnClear" value="Clear">
            </div>
        </form>
    </div>
</section>
</body>
</html>