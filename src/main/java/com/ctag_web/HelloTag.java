package com.ctag_web;

import java.io.PrintWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;


public class HelloTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag t) {
        parentTag = t;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            PrintWriter out = pageContext.getResponse().getWriter();
            out.print("Hello Tag");
        } catch (Exception e) {
        }
        
        
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    
    }
    
}
