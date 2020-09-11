package com.async_web;

import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;

class LongJob implements Runnable {
    private AsyncContext ctx = null;
    public LongJob(AsyncContext ctx){
        this.ctx = ctx;
    }
    public void run(){
        try {
            // 等待10秒鐘，用來模擬任務所需要的時間
            Thread.sleep(10000);
            PrintWriter out = ctx.getResponse().getWriter();
            out.println("任務處理完畢的時間：" + new Date() + ".<p>");
            out.flush();
            ctx.complete(); // 任務完成
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
