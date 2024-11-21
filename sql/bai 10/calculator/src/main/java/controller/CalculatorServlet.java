package controller;

import model.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    public void init(){

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    double first = Double.parseDouble(request.getParameter("num_first"));
    double second = Double.parseDouble(request.getParameter("num_second"));
    String selectOption = request.getParameter("valueselect");
    double result = Calculator.caculator(selectOption, first, second);
    request.setAttribute("first", first);
    request.setAttribute("second", second);
    request.setAttribute("result", result);
    request.setAttribute("selectOption", selectOption);
    RequestDispatcher reqDispatcher = request.getRequestDispatcher("calculator.jsp");
    reqDispatcher.forward(request, response);
    }

    public void destroy(){}
}
