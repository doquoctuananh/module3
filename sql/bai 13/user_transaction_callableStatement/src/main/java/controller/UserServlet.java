package controller;

import model.User;
import service.ServiceUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    // tao doi tuong lay du lieu
    private ServiceUser serviceUser;
    public void init(){
        serviceUser = new ServiceUser();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action){
            case "create":{
                createUser(request,response);
                break;
            }
            case "update":{
                updateUser(request,response);
                break;
            }
            case "delete":{
                deleteUser(request,response);
                break;
            }
            case "findUserId":{
                findUserId(request,response);
                break;
            }
            case "create-use-transaction":{
                createUserTransaction(request,response);
                break;
            }
            default:{
                showAllUser(request,response);
                break;
            }
        }
    }

    private void showAllUser(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<User> users = serviceUser.showAllUser();
        request.setAttribute("users",users);
        request.getRequestDispatcher("/user/showAll.jsp").forward(request,response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("/user/create.jsp").forward(request,response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = serviceUser.findUserId(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/user/update.jsp").forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceUser.deleteUser(id);
        response.sendRedirect("/user");
    }

    private void findUserId(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = serviceUser.findUserId(id);
        request.setAttribute("user",user);
        request.setAttribute("id",id);
        request.getRequestDispatcher("/user/findUserId.jsp").forward(request,response);
    }

    private void createUserTransaction(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        request.getRequestDispatcher("/user/createTransaction.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String form = request.getParameter("form");
        switch (form){
            case "createForm":{
                handleCreateForm(request,response);
                break;
            }
            case "updateForm":{
                handleUpdateForm(request,response);
                break;
            }
            case "createTransactionForm":{
                handleCreateTransactionForm(request,response);
                break;
            }
        }
    }

    private void handleCreateForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        User user = new User(name, email, country);
        serviceUser.createUser(user);
        response.sendRedirect("/user");
    }

    private void handleUpdateForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        serviceUser.updateUser(user);
        response.sendRedirect("/user");
    }

    private void handleCreateTransactionForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        List<Integer> permision = new ArrayList<Integer>();
        String add = request.getParameter("add");
        String delete = request.getParameter("delete");
        String update = request.getParameter("update");
        String view = request.getParameter("view");
        if(add != null){
            permision.add(1);
        }
        if(delete != null){
            permision.add(2);
        }
        if(update != null){
            permision.add(3);
        }
        if(view != null){
            permision.add(4);
        }
        User user = new User(name, email, country);
        serviceUser.createTransaction(user, permision);
        response.sendRedirect("/user");
    }
}
