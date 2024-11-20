package org.example.login;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "DisountCalculator", urlPatterns = "/display-discount")
public class DisountCalculator extends HttpServlet {
    public void init(){

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        double discount_amount = discount * price*0.01;
        double discount_price = price - discount_amount;
        String description = request.getParameter("description");

        request.setAttribute("description", description);
        request.setAttribute("discount_price", discount_price);
        request.setAttribute("price", price);
        request.setAttribute("discount", discount);

        RequestDispatcher dispatcher = request.getRequestDispatcher("discount_calculator.jsp");
        dispatcher.forward(request, response);
    }
    public void destroy(){

    }
}
