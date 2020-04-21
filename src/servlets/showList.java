package servlets;

import model.Todo;
import model.odoT;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/showList")
public class showList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int receive = Integer.parseInt(request.getParameter("receive"));
        odoT odot = new odoT();
        Todo todo = odot.getCount(receive);

        RequestDispatcher rd = request.getRequestDispatcher("todoList.jsp");
        rd.forward(request, response);
    }


}
