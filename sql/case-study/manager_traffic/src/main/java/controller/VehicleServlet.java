package controller;

import model.Car;
import model.Motorbike;
import model.Province;
import model.Vehicle;
import service.provinceService.ImplProvinceService;
import service.vehicleService.ImplVehicleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Vehicle" , urlPatterns="/vehicle")
public class VehicleServlet extends HttpServlet {
    private ImplVehicleService vehicleService = new ImplVehicleService();
    private ImplProvinceService provinceService = new ImplProvinceService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action== null){
            action = "";
        }
        switch(action){
            case "createVehicle":{
                createVehicle(request,response);
                break;
            }
            case "updateVehicle":{
                updateVehicle(request,response);
                break;
            }
            case "deleteVehicle":{
                deleteVehicle(request,response);
                break;
            }
            case "filterVehicle":{
                filterVehicle(request,response);
                break;
            }
            case "viewDetailVehicle":{
                viewDetailVehicle(request,response);
                break;
            }
            default:{
                showAllVehicle(request,response);
            }

        }
    }
    private void showAllVehicle(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.addAll( vehicleService.showAllVehicles());
        request.setAttribute("vehicleList", vehicleList);
        request.getRequestDispatcher("vehicle/showAll.jsp").forward(request, response);
    }

    private void createVehicle(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Province> provinceList = provinceService.showAllProvinces();
        request.setAttribute("provinceList", provinceList);
        request.getRequestDispatcher("vehicle/create.jsp").forward(request, response);

    }

    private void updateVehicle(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Vehicle vehicle = vehicleService.findVehicleById(id);
        List<Province> provinceList = provinceService.showAllProvinces();
        request.setAttribute("provinceList", provinceList);
        request.setAttribute("vehicle", vehicle);
        request.getRequestDispatcher("vehicle/update.jsp").forward(request, response);
    }

    private void deleteVehicle (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        vehicleService.deleteVehicle(id);
        response.sendRedirect("/vehicle");
    }
    private void filterVehicle(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String typeVehicle = request.getParameter("typeVehicle");
        String color = request.getParameter("color");
        List<Vehicle> vehicleList = vehicleService.searchVehicle(color, typeVehicle);
        request.setAttribute("vehicleList", vehicleList);
        request.getRequestDispatcher("vehicle/showAll.jsp").forward(request, response);
    }

    private void viewDetailVehicle(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Vehicle vehicle = vehicleService.viewDetailVehicle(id);
        request.setAttribute("vehicle",vehicle);
        request.getRequestDispatcher("vehicle/viewDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case"createVehicleForm":{
                createVehicelForm(req,resp);
                break;
            }
            case "updateVehicleForm":{
                updateVehicelForm(req,resp);
                break;
            }
    }
}

    private void createVehicelForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Vehicle vehicle = null;
        String name = req.getParameter("name");
        LocalDate yearManufactured = LocalDate.parse(req.getParameter("year"));
        String color = req.getParameter("color").toLowerCase();
        double price = Double.parseDouble(req.getParameter("price"));
        int id_province = Integer.parseInt(req.getParameter("idProvince"));
        int id_person = Integer.parseInt(req.getParameter("idPerson"));
        String typeVehicle = req.getParameter("typeVehicle");

        if(typeVehicle.equals("Car")){
            int numberSeat = Integer.parseInt(req.getParameter("numberSeat"));
            vehicle = new Car(name,color,price,yearManufactured,id_province,id_person,typeVehicle,numberSeat);
            vehicleService.createVehicle(vehicle);
            resp.sendRedirect("/vehicle");
        }
        else if (typeVehicle.equals("Motorbike")){
            double speed = Double.parseDouble(req.getParameter("speed"));
            vehicle = new Motorbike(name,color,price,yearManufactured,id_province,id_person,typeVehicle,speed);
            vehicleService.createVehicle(vehicle);
            resp.sendRedirect("/vehicle");
        }

    }

    private void updateVehicelForm(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        LocalDate yearManufactured = LocalDate.parse(req.getParameter("year"));
        String color = req.getParameter("color");
        double price = Double.parseDouble(req.getParameter("price"));
        int id_province = Integer.parseInt(req.getParameter("idProvince"));
        int id_person = Integer.parseInt(req.getParameter("idPerson"));
        String typeVehicle = req.getParameter("typeVehicle");
        if(typeVehicle.equals("Car")){
            int numberSeat = Integer.parseInt(req.getParameter("numberSeat"));
            Vehicle vehicle = new Car(name,color,price,yearManufactured,id_province,id_person,typeVehicle,numberSeat);
            vehicleService.updateVehicle(vehicle,id);
        }
        else if (typeVehicle.equals("Motorbike")){
            double speed = Double.parseDouble(req.getParameter("speed"));
            Vehicle vehicle = new Motorbike(name,color,price,yearManufactured,id_province,id_person,typeVehicle,speed);
            vehicleService.updateVehicle(vehicle,id);
        }
        resp.sendRedirect("/vehicle");
    }
}

