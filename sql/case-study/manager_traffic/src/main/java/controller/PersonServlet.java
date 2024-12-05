package controller;

import model.Person;
import model.Province;
import service.personService.ImplPersonService;
import service.provinceService.ImplProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name ="PersonServlet", value = "/person")
public class PersonServlet extends HttpServlet {
    ImplPersonService personService = new ImplPersonService();
    ImplProvinceService provinceService = new ImplProvinceService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch(action){
            case "createPerson":
                createPerson(request,response);
                break;
            case "updatePerson":
                updatePerson(request,response);
                break;
            case "deletePerson":
                deletePerson(request,response);
                break;
            default:
                showAllPerson(request,response);
        }
    }

    private void showAllPerson(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Person> personList = personService.showAllPersons();
        request.setAttribute("personList", personList);
        request.getRequestDispatcher("person/showAll.jsp").forward(request, response);
    }
    private void createPerson(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        List<Province> provinceList = provinceService.showAllProvinces();
        request.setAttribute("provinceList", provinceList);
        request.getRequestDispatcher("person/create.jsp").forward(request, response);
    }

    private void updatePerson(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Province> provinceList = provinceService.showAllProvinces();
        Person person = personService.findPersonById(id);
        request.setAttribute("person", person);
        request.setAttribute("provinceList", provinceList);
        request.getRequestDispatcher("person/update.jsp").forward(request, response);
    }

    private void deletePerson(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        personService.deletePerson(id);
        response.sendRedirect("person");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case"createPersonForm":
                createPersonForm(request,response);
                break;
            case"updatePersonForm":
                updatePersonForm(request,response);
                break;
        }
    }

    private void createPersonForm(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        String name = request.getParameter("name");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int id_province = Integer.parseInt(request.getParameter("id_province"));
        Person person = new Person(name,birthday,address,email,phone,id_province);
        personService.createPerson(person);
        response.sendRedirect("person");
    }

    private void updatePersonForm(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int id_province = Integer.parseInt(request.getParameter("id_province"));
        Person person = new Person(id,name,birthday,address,email,phone,id_province);
        personService.updatePerson(person);
        response.sendRedirect("/person");
    }
}
