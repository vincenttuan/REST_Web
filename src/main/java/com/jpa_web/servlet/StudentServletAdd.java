package com.jpa_web.servlet;

import com.jpa_web.bean.Student;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/jpa/student/add")
public class StudentServletAdd extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        
        EntityManager em = emf.createEntityManager();
        
        Student student = new Student();
        student.setName("Vincent");
        student.setAge(18);
        
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            ex.printStackTrace(out);
        } finally {
            em.close();
        }
        
        out.print("OK");
    }

}
