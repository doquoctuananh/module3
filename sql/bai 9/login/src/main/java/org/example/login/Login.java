package org.example.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="Login", urlPatterns = "/login")
public class Login  extends HttpServlet {
    public void init(){
        System.out.println("servlet start");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("email");
        String password = request.getParameter("pswd");
        String email = username + " " + password;
        request.setAttribute("email", email);
        RequestDispatcher requestdispatcher = request.getRequestDispatcher("index.jsp");
        requestdispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String username = request.getParameter("email");
        String password = request.getParameter("pswd");
        String email = username + " " + password;
        PrintWriter out = response.getWriter();
        if("admin@admin".equals(username) && "tuananh".equals(password)){

            out.println("<h1>Login Succes</h1>" );
        }
        else{
            out.println("<h1>Login Failed</h1>" );
        }
    }

    public void destroy(){
        System.out.println("servlet destroy");
    }
}
