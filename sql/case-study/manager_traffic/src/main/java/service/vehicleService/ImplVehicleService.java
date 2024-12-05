package service.vehicleService;

import model.Vehicle;
import repository.vehicleRepository.ImplVehicleRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImplVehicleService implements IVehicleService{
    private ImplVehicleRepository vehicleRepository = new ImplVehicleRepository();
    @Override
    public List<Vehicle> showAllVehicles(String typeVehicle) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(vehicleRepository.showAllVehicles(typeVehicle));
        return vehicles;
    }

    @Override
    public boolean createVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean deleteVehicle(int id) {
        return false;
    }

    @Override
    public boolean searchVehicle(double price, String color) {
        return false;
    }
}
