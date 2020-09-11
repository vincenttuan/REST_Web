package com.async_web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/syncLongJob")
public class SyncLongJobServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws IOException, ServletException {
        // 1.進入 Servlet 
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("進入Servlet的時間：" + new Date() + ".<p>");
        out.flush();
        
        // 2.在主執行緒中執行任務調用，並由其負責輸出響應
        try {
            // 等待10秒鐘，用來模擬任務所需要的時間
            Thread.sleep(10000);
            out.println("任務處理完畢的時間：" + new Date() + ".<p>");
            out.flush(); // 任務完成
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        out.println("結束Servlet的時間：" + new Date() + ".<p>");
        out.flush();
        // 3.離開 Servlet 給其他請求連線使用
    }
}
