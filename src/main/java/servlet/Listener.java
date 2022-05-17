package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebListener
public class Listener implements ServletContextListener {

    public Listener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
/*
        String url = ctx.getInitParameter("DBURL");
        String u = ctx.getInitParameter("DBUSER");
        String p = ctx.getInitParameter("DBPWD");

        //create database connection from init parameters and set it to context
        DBConnectionManager dbManager = new DBConnectionManager(url, u, p);
        ctx.setAttribute("DBManager", dbManager);
        System.out.println("Database connection initialized for Application.");*/

        System.out.println("Listener works");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }



}
