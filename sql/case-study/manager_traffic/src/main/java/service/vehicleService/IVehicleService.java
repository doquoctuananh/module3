package service.vehicleService;

import model.Vehicle;

import java.util.List;

public interface IVehicleService {
    Vehicle findVehicleById(int id);
    List<Vehicle> showAllVehicles();
    boolean createVehicle(Vehicle vehicle);
    boolean updateVehicle(Vehicle vehicle,int id);
    boolean deleteVehicle(int id);
    List<Vehicle> searchVehicle(String color,String typeVehicle);
    Vehicle viewDetailVehicle(int id);
}
