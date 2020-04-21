package servlets;

import model.Todo;
import services.TodoJDBCService;
import services.TodoMockService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/TodoCreateServlet")
public class TodoCreateServlet extends HttpServlet {
    private static final String m_URL = "jdbc:mysql://localhost:3306/";
    private static final String m_DBNAME = "to_do_list";
    private static final String m_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String m_USERNAME = "root";
    private static final String m_PASSWORD = "pword";
    private static Connection m_conn;

    private static final String m_SELECT_ALL_SQL = "SELECT * FROM swiderski_item";
    private static final String m_INSERT_SQL = "INSERT INTO to_do_list.to_dos (id, todo) VALUES ";
    private static final String m_DELETE_SQL = "DELETE FROM swiderski_item WHERE ITEM_ID = '";
    private static final String m_UPDATE_SQL = "UPDATE swiderski_item SET ITEM_DESC = ";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String task = request.getParameter("task");


        Todo todo = new Todo(0, task);

        //TodoMockService.getInstance().create(todo);
        TodoJDBCService.getInstance().create(todo);
        response.sendRedirect("list");
    }
    public void addItem(String id, String desc) throws SQLException, Exception {
        Statement insertStmt = null;
        String sql = m_INSERT_SQL + "('" + id + "', '" + desc + "')";

        if(m_conn != null)
        {
            if(!m_conn.isClosed())
            {
                insertStmt = m_conn.createStatement();
                insertStmt.execute(sql);
            }
        }
    }
}