package servlets;

import model.Todo;
import services.TodoJDBCService;
import services.TodoMockService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/create")
public class create extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String task = request.getParameter("task");


        Todo todo = new Todo(0,"");


        //TodoMockService.getInstance().create(todo);
        TodoJDBCService.getInstance().create(todo);
        response.sendRedirect("list");

    }


}
