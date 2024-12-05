package controller;

import model.Vehicle;
import service.vehicleService.ImplVehicleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Vehicle" , urlPatterns="/vehicle")
public class VehicleServlet extends HttpServlet {
    private ImplVehicleService vehicleService = new ImplVehicleService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action== null){
            action = "";
        }
        switch(action){
            case "createVehicle":{
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
        String typeVehicle = request.getParameter("typeVehicle");
        if(typeVehicle == null){
            typeVehicle = "";
        }
        switch (typeVehicle){
            case "Car":{
                vehicleList.addAll( vehicleService.showAllVehicles(typeVehicle));
                break;
            }
            case "Motorbike":{
                vehicleList.addAll( vehicleService.showAllVehicles(typeVehicle));
                break;
            }
            default:{
                vehicleList.addAll( vehicleService.showAllVehicles(typeVehicle));
            }
        }
        request.setAttribute("vehicleList", vehicleList);
        request.getRequestDispatcher("vehicle/showAll.jsp").forward(request, response);
    }
}

