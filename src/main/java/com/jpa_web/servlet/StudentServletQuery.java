package com.jpa_web.servlet;

import com.jpa_web.bean.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet("/jpa/student/query")
public class StudentServletQuery extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        
        EntityManager em = emf.createEntityManager();
        
        List<Student> students = em.createNamedQuery("Student.findAll").getResultList();
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        
        out.print(students);
    }

}
