package repository.vehicleRepository;

import model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    Vehicle findById(int id);
    List<Vehicle> showAllVehicles();
    boolean createVehicle(Vehicle vehicle);
    boolean updateVehicle(Vehicle vehicle,int id);
    boolean deleteVehicle(int id);
    List<Vehicle> searchVehicle(String typeVehicle,String color);
    Vehicle viewDetailVehicle(int id);
}
