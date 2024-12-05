package repository.vehicleRepository;

import model.Car;
import model.Motorbike;
import model.Vehicle;
import repository.BaseRespository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImplVehicleRepository implements IVehicleRepository{
    private BaseRespository baseRepository = new BaseRespository();

    private static String sqlShowAllCar = "select v.*,m.speed from vehicle as v join motorbike as m on v.id = m.id";
    private static String sqlShowAllMotor = "select v.*,c.numberSeats from vehicle as  v\n" +
            "join car as c on v.id = c.id";
    private static String showAll = "select * from vehicle";
    @Override
    public List<Vehicle> showAllVehicles(String typeVehicle) {
        List<Vehicle> vehicleList = new ArrayList<>();
        if(typeVehicle.equals("Motorbike")){
            try(Connection conn = baseRepository.getConnection();
                PreparedStatement ppsm = conn.prepareStatement(sqlShowAllCar);
            ){
                ResultSet rs = ppsm.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nameVehicle = rs.getString("manafacture");
                    LocalDate yearManafactured = LocalDate.parse(rs.getString("yearManafactured"));
                    double price = rs.getDouble("price");
                    String color = rs.getString("color");
                    int id_province = rs.getInt("id_province");
                    int id_person = rs.getInt("id_person");
                    double speed = rs.getDouble("speed");
                    vehicleList.add(new Motorbike(id,nameVehicle,color,price,yearManafactured,id_province,id_person,speed));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        else if(typeVehicle.equals("Car")){
            try(Connection conn = baseRepository.getConnection();
                PreparedStatement ppsm = conn.prepareStatement(sqlShowAllMotor);
            ){
                ResultSet rs = ppsm.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nameVehicle = rs.getString("manafacture");
                    LocalDate yearManafactured = LocalDate.parse(rs.getString("yearManafactured"));
                    double price = rs.getDouble("price");
                    String color = rs.getString("color");
                    int id_province = rs.getInt("id_province");
                    int id_person = rs.getInt("id_person");
                    int numberSeats = rs.getInt("numberSeats");
                    vehicleList.add(new Car(id,nameVehicle,color,price,yearManafactured,
                            id_province,id_person,numberSeats));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        else{
            try(Connection conn = baseRepository.getConnection();
                PreparedStatement ppsm = conn.prepareStatement(showAll);
            ){
                ResultSet rs = ppsm.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nameVehicle = rs.getString("manafacture");
                    LocalDate yearManafactured = LocalDate.parse(rs.getString("yearManafactured"));
                    double price = rs.getDouble("price");
                    String color = rs.getString("color");
                    int id_province = rs.getInt("id_province");
                    int id_person = rs.getInt("id_person");
                    vehicleList.add(new Vehicle(id,nameVehicle,color,price,yearManafactured,
                            id_province,id_person));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return vehicleList;
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
