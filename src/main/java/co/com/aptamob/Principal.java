package co.com.aptamob;

import javax.servlet.http.*;

public class Principal extends HttpServlet {
    
    /*public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new Principal()),"/*");
        server.start();
        server.join();   
    }*/
}