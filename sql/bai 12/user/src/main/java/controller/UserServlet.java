package controller;

import model.User;
import service.ServiceUser;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name="UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private ServiceUser serviceUserServlet ;

    public void init()  {
        serviceUserServlet = new ServiceUser();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch(action){
            case "showAllUser" :{
                showAllUser(request,response);
                break;
            }
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
            case "searchName":{
                searchNameUser(request,response);
                break;
            }
            case "sortName":{
                sortNameUser(request,response);
                break;
            }
        }
    }

    private void showAllUser(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        List<User> users=serviceUserServlet.showAllUser();
        if(users.size()>0){
            request.setAttribute("users", users);
        }
        request.getRequestDispatcher("user/showAllUser.jsp").forward(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("user/create.jsp").forward(request,response);
    }

    private void updateUser(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        int updateId = Integer.parseInt(request.getParameter("updateId"));
        String name = request.getParameter("userName");
        String email = request.getParameter("userEmail");
        String country = request.getParameter("userCountry");
        request.setAttribute("updateId", updateId);
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("country", country);
        request.getRequestDispatcher("user/update.jsp").forward(request,response);
    }

    private void deleteUser(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        int deleteId = Integer.parseInt(request.getParameter("deleteId"));
        serviceUserServlet.deleteUser(deleteId);
        response.sendRedirect("user?action=showAllUser");
    }

    private void searchNameUser(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        String search = request.getParameter("searchName");
        List<User> users = new ArrayList<>();
        users.addAll(serviceUserServlet.searchUserName(search));
        request.setAttribute("users", users);
        request.getRequestDispatcher("user/searchName.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case"createForm":{
                handleCreateForm(request,response);
                break;
            }
            case"updateForm":{
                handleUpdateForm(request,response);
                break;
            }
        }
    }

    private void sortNameUser(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        users.addAll(serviceUserServlet.sortUserName());
        request.setAttribute("users", users);
        request.getRequestDispatcher("user/showAllUser.jsp").forward(request, response);
//        response.sendRedirect("/user?action=showAllUser");
    }

    private void handleCreateForm(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        boolean result = serviceUserServlet.createUser(user);
        response.sendRedirect("user?action=showAllUser");
    }

    private void handleUpdateForm(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        int id = Integer.parseInt(request.getParameter("updateId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        serviceUserServlet.updateUser(user);
        response.sendRedirect("user?action=showAllUser");
    }

}
