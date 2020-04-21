package servlets;


import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.tomcat.util.http.parser.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class ManageToDoList
{
    private static final String m_URL = "jdbc:mysql://localhost:3306/";
    private static final String m_DBNAME = "to_do_list";
    private static final String m_DRIVER = "com.mysql.jdbc.Driver";
    private static final String m_USERNAME = "root";
    private static final String m_PASSWORD = "pword";
    private static Connection m_conn;

    private static final String m_SELECT_ALL_SQL = "SELECT * FROM to_do_list.to_dos";
    private static final String m_INSERT_SQL = "INSERT INTO to_do_list.to_dos (id, todo) VALUES ";
    private static final String m_DELETE_SQL = "DELETE FROM to_do_list.to_dos WHERE id = ";
    private static final String m_UPDATE_SQL = "UPDATE to_do_list.to_dos SET ITEM_DESC = ";


    public ManageToDoList() throws SQLException, ClassNotFoundException {
        Class.forName(m_DRIVER);
        m_conn = DriverManager.getConnection(m_URL + m_DBNAME, m_USERNAME, m_PASSWORD);
    }

    /**
     * This method lists all items in the to do list.
     *
     * @return text list of of the to-do items
     */
    public String listItems() throws SQLException, Exception {
        Statement selectStmt = null;
        String text = "\n";

        if(m_conn != null)
        {
            if(!m_conn.isClosed())
            {
                selectStmt = m_conn.createStatement();
                ResultSet rs = selectStmt.executeQuery(m_SELECT_ALL_SQL);

                while(rs.next())
                {
                    int id = rs.getInt(1);
                    String value = rs.getString(2);

                    text += "To Do Item: " + id + " - " + value + " \n";
                }
            }
        }

        return text;
    }


    /**
     * This method adds a new item in the to do list.
     *
     * @param id the unique identifier for the item
     * @param desc the item description
     */
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

    /**
     * This method deletes a specified item from the to do list.
     *
     * @param itemID the id of the item to be deleted
     */
    public void deleteItem(String itemID) throws SQLException, Exception {
        Statement deleteStmt = null;
        String sql = m_DELETE_SQL + itemID + "";

        if(m_conn != null)
        {
            if(!m_conn.isClosed())
            {
                deleteStmt = m_conn.createStatement();
                deleteStmt.execute(sql);
            }
        }
    }

    /**
     * This method updates the/an item description in the to do list.
     *
     * @param itemID the id of the item in the list
     * @param desc the new description for the item in the list
     */
    public void updateItem(String itemID, String desc) throws SQLException, Exception {
        Statement updateStmt = null;
        Statement selectStmt = null;
        String select_sql = "SELECT id FROM to_do_list.to_dos WHERE id = '" + itemID + "'";
        String update_sql_cont = "'" + desc + "' WHERE ITEM_ID = '" + itemID + "'";
        String update_sql = m_UPDATE_SQL + update_sql_cont;

        if(m_conn != null)
        {
            if(!m_conn.isClosed())
            {
                selectStmt = m_conn.createStatement();
                ResultSet rs = selectStmt.executeQuery(select_sql);

                if(rs.next()) {
                    addItem(itemID, desc);
                } else {
                    updateStmt = m_conn.createStatement();
                    updateStmt.executeUpdate(update_sql);
                }
            }
        }
    }
}
