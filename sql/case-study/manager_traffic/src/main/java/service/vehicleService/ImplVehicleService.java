package service.vehicleService;

import model.Vehicle;
import repository.vehicleRepository.ImplVehicleRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImplVehicleService implements IVehicleService{
    private ImplVehicleRepository vehicleRepository = new ImplVehicleRepository();

    @Override
    public Vehicle findVehicleById(int id) {
        Vehicle vehicle = null;
        vehicle = vehicleRepository.findById(id);
        return vehicle;
    }

    @Override
    public List<Vehicle> showAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(vehicleRepository.showAllVehicles());
        return vehicles;
    }

    @Override
    public boolean createVehicle(Vehicle vehicle) {
        boolean result = vehicleRepository.createVehicle(vehicle);
        return result;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle,int id) {
        boolean result = vehicleRepository.updateVehicle(vehicle,id);
        return result;
    }

    @Override
    public boolean deleteVehicle(int id) {
        boolean result = vehicleRepository.deleteVehicle(id);
        return false;
    }

    @Override
    public List<Vehicle> searchVehicle(String color, String typeVehicle)
    {
        List<Vehicle> filterVehicle = vehicleRepository.searchVehicle(color,typeVehicle);
        return filterVehicle;
    }

    public Vehicle viewDetailVehicle(int id) {
        Vehicle vehicle = vehicleRepository.viewDetailVehicle(id);
        return vehicle;
    }
}
