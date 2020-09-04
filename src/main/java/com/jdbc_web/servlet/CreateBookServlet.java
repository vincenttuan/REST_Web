package com.jdbc_web.servlet;

import com.jdbc_web.bean.Book;
import com.jdbc_web.bean.ResultSetToBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/create/book")
public class CreateBookServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
        String sql = "SELECT * FROM Book";
        try(Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql)) {
            rs.moveToInsertRow();
            rs.updateString("title", "bbb");
            rs.updateInt("price", 299);
            rs.updateInt("amount", 29);
            rs.insertRow();
            resp.getWriter().print("insert ok !");
        } catch(Exception e) {
            e.printStackTrace(resp.getWriter());
        }
        
    }
    
}
