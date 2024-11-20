package org.example.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "Money", urlPatterns = "/money")
public class Money extends HttpServlet {
    public void init(){

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        Double exchangerrate = Double.parseDouble(request.getParameter("exchange_rate"));
        Double usd = Double.parseDouble(request.getParameter("usd"));
        double money = usd * exchangerrate;
        request.setAttribute("money", money);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("money.jsp");
        requestDispatcher.forward(request,response);
    }
    public void destroy(){}
}
