package controller;

import model.Customer;
import service.CustomerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@WebServlet (name = "showAllServlet",value = "/customer")

public class showAllServlet extends HttpServlet {
    private CustomerImpl customerServlet = new CustomerImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "showAll":{
                showAllCustomerServlet(request,response);
                break;
            }
            case "create":{
                createCustomerServlet(request,response);
                break;
            }
            case "update" :{
                updateCustomerServlet(request,response);
                break;
            }
            case "delete" :{
                deleteCustomerServlet(request,response);
                break;
            }
        }
    }

    public void showAllCustomerServlet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Customer> customerList = this.customerServlet.showAllCustomers();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/showAll.jsp");
        requestDispatcher.forward(request, response);
    }

    public void createCustomerServlet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        requestDispatcher.forward(request, response);
    }

    public void updateCustomerServlet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerServlet.showCustomer(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customer/update.jsp").forward(request, response);
    }

    private void deleteCustomerServlet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.customerServlet.deleteCustomer(id);
//        response.setHeader("Referer","customer?action=showAll");
        response.sendRedirect("customer?action=showAll");
    }

    // method handle Form

    public void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":{
                handleCreateCustomer(request,response);
                break;
            }
            case "update":{
                handleUpdateCustomer(request,response);
            }
        }
    }

    // handle form create.jsp with method Post
    private void handleCreateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int)(Math.floor(Math.random()*100));
        while(this.customerServlet.getCustomers().containsKey(id)){
            id = (int)(Math.floor(Math.random()*100));
        };

        Customer customer = new Customer(id,name, email, address);
        this.customerServlet.add(customer);
//        request.getRequestDispatcher("customer/showAll.jsp").forward(request, response);
        response.sendRedirect( "customer?action=showAll");
    }

    private void handleUpdateCustomer(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id,name, email, address);
        this.customerServlet.updateCustomer(id, customer);
        response.sendRedirect( "customer?action=showAll");
    }
}
