package service.vehicleService;

import model.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<Vehicle> showAllVehicles(String typeVehicle);
    boolean createVehicle(Vehicle vehicle);
    boolean updateVehicle(Vehicle vehicle);
    boolean deleteVehicle(int id);
    boolean searchVehicle(double price,String color);
}
