<%@ page import="model.Todo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head><style> .center {
            max-width: 500px;
            margin: auto;
        }</style>
    <title>todo list</title>
    <meta http-equiv="Content-Type" content="text/html" , charset="UTF-8">
    <title>Show To-Do List</title>
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
    <a href="showList.jsp" id="selected">Show To-Do List</a>
    <a href="addItem.jsp">Add To-Do Item</a>
    <a href="deleteItem.jsp">Delete To-Do Item</a>
</nav>
<section>
    <h2>Show To-Do List</h2>
    <div id="center_buttonsv1">
        <button type="button" onclick="btnShowList()">Show To-Do List</button>
        <button type="button" onclick="btnHideList()">Hide To-Do List</button>
    </div>
    <textarea id="taList" rows="5" cols="50">
				<%=
                MTDL.listItems()
                %>
			</textarea>
</section>
<script>
    function btnShowList() {
        document.getElementById("taList").style.display = "block";
    }

    function btnHideList() {
        document.getElementById("taList").style.display = "none";
    }
</script>
</body>
</html>
