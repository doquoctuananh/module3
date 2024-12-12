package repository.vehicleRepository;

import model.Car;
import model.Motorbike;
import model.Vehicle;
import repository.BaseRespository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImplVehicleRepository implements IVehicleRepository {
    private BaseRespository baseRepository = new BaseRespository();

    private static String sqlShowAll = "select * from vehicle";
    private static String createVehicle = "insert into vehicle (yearManafactured,manafacture,price,color,id_province,id_person,typeVehicle) \n" +
            "values(?,?,?,?,?,?,?)";
    private  static String createCar = "insert into car(id,numberSeats) values(?,?)";
    private  static String createMotorbike = "insert into motorbike(id,speed) values(?,?)";
    private static String sqlFindById = "select * from vehicle where id=?";
    private static String sqlUpdateVehicle = "update vehicle set yearManafactured =?,manafacture=?,price=?,color=?,id_province=?,id_person=?,typeVehicle=? \n" +
            "where id=?";
    private static String sqlUpdateCar = "update car set numberSeats=? where id=?";
    private static String sqlUpdateMotor = "update motorbike set speed =? where id=?";

    private static String sqlDeleteCar = "delete from car where id=?";
    private static String sqlDeleteMotor = "delete from motorbike where id=?";
    private static String sqlDeleteAll = "delete from vehicle where id =?";

    private static String sqlViewCar = "select v.*,c.numberSeats from vehicle as v join car as c on v.id = c.id where v.id = ?";
    private static String sqlViewMotor = "select v.*,m.speed from vehicle as v join motorbike as m on v.id = m.id where v.id = ?";

    private static String sqlSearchType = "select * from vehicle where typeVehicle = ?";
    private static String sqlSearchColor = "select * from vehicle where color like ?";
    private static String sqlSearch = "select* from vehicle where typeVehicle = ? and color like ?";
    @Override
    public Vehicle findById(int id) {
        Vehicle vehicle = null;
        try(Connection conn = baseRepository.getConnection();
        PreparedStatement ppsm = conn.prepareStatement(sqlFindById);
        ){
            ppsm.setInt(1, id);
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                int _id = rs.getInt("id");
                String manafacture = rs.getString("manafacture");
                LocalDate yearManafactured = LocalDate.parse(rs.getString("yearManafactured"));
                double price = rs.getDouble("price");
                String color = rs.getString("color");
                int id_province = rs.getInt("id_province");
                int id_person = rs.getInt("id_person");
                String typeVehicle = rs.getString("typeVehicle");
                vehicle = new Vehicle(id,manafacture,color,price,yearManafactured,id_province,id_person,typeVehicle);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> showAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        try(Connection conn = baseRepository.getConnection();
        PreparedStatement ppsm = conn.prepareStatement(sqlShowAll)){
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){

                int id = rs.getInt("id");
                String manafacture = rs.getString("manafacture");
                LocalDate yearManafactured = LocalDate.parse(rs.getString("yearManafactured"));
                double price = rs.getDouble("price");
                String color = rs.getString("color");
                int id_province = rs.getInt("id_province");
                int id_person = rs.getInt("id_person");
                String typeVehicle = rs.getString("typeVehicle");
                vehicleList.add(new Vehicle(id,manafacture,color,price,yearManafactured,
                        id_province,id_person,typeVehicle));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    @Override
    public boolean createVehicle(Vehicle vehicle) {
        boolean result = false;
        if(vehicle instanceof Car){
            try(Connection connection = baseRepository.getConnection();
            PreparedStatement ppsm = connection.prepareStatement(createVehicle,Statement.RETURN_GENERATED_KEYS)){
                ppsm.setString(1,vehicle.getYearManufactured().toString());
                ppsm.setString(2,vehicle.getNameVehicle());
                ppsm.setDouble(3,vehicle.getPrice());
                ppsm.setString(4,vehicle.getColor());
                ppsm.setInt(5,vehicle.getIdProvince());
                ppsm.setInt(6,vehicle.getIdPerson());
                ppsm.setString(7,vehicle.getTypeVehicle());
                int row = ppsm.executeUpdate();
                ResultSet resultSet = ppsm.getGeneratedKeys();
                if(row > 0){
                    while(resultSet.next()){
                        int id = resultSet.getInt(1);
                        PreparedStatement ppsmCar = connection.prepareStatement(createCar);
                        ppsmCar.setInt(1,id);
                        ppsmCar.setInt(2, ((Car) vehicle).getNumerSeats());
                        int rowCar = ppsmCar.executeUpdate();
                        if(rowCar > 0){
                            result = true;
                        }
                    }
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(vehicle instanceof Motorbike){
            try(Connection connection = baseRepository.getConnection();
                PreparedStatement ppsm = connection.prepareStatement(createVehicle,Statement.RETURN_GENERATED_KEYS)){
                ppsm.setString(1,vehicle.getYearManufactured().toString());
                ppsm.setString(2,vehicle.getNameVehicle());
                ppsm.setDouble(3,vehicle.getPrice());
                ppsm.setString(4,vehicle.getColor());
                ppsm.setInt(5,vehicle.getIdProvince());
                ppsm.setInt(6,vehicle.getIdPerson());
                ppsm.setString(7,vehicle.getTypeVehicle());
                int row = ppsm.executeUpdate();
                ResultSet resultSet = ppsm.getGeneratedKeys();
                if(row > 0){
                    while(resultSet.next()){
                        int id = resultSet.getInt(1);
                        PreparedStatement ppsmMotor  = connection.prepareStatement(createMotorbike);
                        ppsmMotor.setInt(1,id);
                        ppsmMotor.setDouble(2, (((Motorbike) vehicle).getSpeed()));
                        int rowCar = ppsmMotor.executeUpdate();
                        if(rowCar > 0){
                            result = true;
                        }
                    }
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle,int id) {
        boolean result = false;
        try(Connection conn = baseRepository.getConnection();
        PreparedStatement ppsm = conn.prepareStatement(sqlUpdateVehicle)){
            ppsm.setString(1,vehicle.getYearManufactured().toString());
            ppsm.setString(2,vehicle.getNameVehicle());
            ppsm.setDouble(3,vehicle.getPrice());
            ppsm.setString(4,vehicle.getColor());
            ppsm.setInt(5,vehicle.getIdProvince());
            ppsm.setInt(6,vehicle.getIdPerson());
            ppsm.setString(7,vehicle.getTypeVehicle());
            ppsm.setInt(8,id);
            int row = ppsm.executeUpdate();
            if(row > 0){
                if(vehicle.getTypeVehicle().equals("Car")){
                    PreparedStatement ppsmCar  = conn.prepareStatement(sqlUpdateCar);
                    ppsmCar.setInt(2,id);
                    ppsmCar.setDouble(1,((Car) vehicle).getNumerSeats());
                    ppsmCar.executeUpdate();
                    result = true;
                }
                else if(vehicle.getTypeVehicle().equals("Motorbike")){
                    PreparedStatement ppsmMotor  = conn.prepareStatement(sqlUpdateMotor);
                    ppsmMotor.setInt(2,id);
                    ppsmMotor.setDouble(1,((Motorbike) vehicle).getSpeed());
                    ppsmMotor.executeUpdate();
                    result = true;
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteVehicle(int id) {
        boolean result = false;
        Vehicle vehicle = findById(id);
        if(vehicle.getTypeVehicle().equals("Car")){
            try(Connection conn = baseRepository.getConnection();
                PreparedStatement ppsm = conn.prepareStatement(sqlDeleteCar)){
                ppsm.setInt(1,id);
                int row = ppsm.executeUpdate();
                if(row > 0){
                    PreparedStatement ppsmVehicle = conn.prepareStatement(sqlDeleteAll);
                    ppsmVehicle.setInt(1,id);
                    ppsmVehicle.executeUpdate();
                    result = true;
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        else if(vehicle.getTypeVehicle().equals("Motorbike")){
            try(Connection conn = baseRepository.getConnection();
                PreparedStatement ppsm = conn.prepareStatement(sqlDeleteMotor);){
                ppsm.setInt(1,id);
                int row = ppsm.executeUpdate();
                if(row > 0){
                    PreparedStatement ppsmVehicle = conn.prepareStatement(sqlDeleteAll);
                    ppsmVehicle.setInt(1,id);
                    ppsmVehicle.executeUpdate();
                    result = true;
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public List<Vehicle> searchVehicle(String color,String typeVehicle) {

        List<Vehicle> filterVehicle = new ArrayList<>();
        if(((typeVehicle.equals("Car") || typeVehicle.equals("Motorbike")) && (color == null || color.equals("")))){
            try(Connection conn = baseRepository.getConnection();
            PreparedStatement ppsm = conn.prepareStatement(sqlSearchType)
            ){
                ppsm.setString(1,typeVehicle);
                ResultSet rs =ppsm.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String manafacture = rs.getString("manafacture");
                    LocalDate yearManafactured = LocalDate.parse(rs.getString("yearManafactured"));
                    double price = rs.getDouble("price");
                    String _color = rs.getString("color");
                    int id_province = rs.getInt("id_province");
                    int id_person = rs.getInt("id_person");
                    String _typeVehicle = rs.getString("typeVehicle");
                    filterVehicle.add(new Vehicle(id,manafacture,_color,price,yearManafactured,
                            id_province,id_person,_typeVehicle));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        else if((typeVehicle.equals("") || typeVehicle == null)&& (color != null && !color.equals(""))){
            try(Connection conn = baseRepository.getConnection();
            PreparedStatement ppsm = conn.prepareStatement(sqlSearchColor)){
                ppsm.setString(1,color);
                ResultSet rs = ppsm.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String manafacture = rs.getString("manafacture");
                    LocalDate yearManafactured = LocalDate.parse(rs.getString("yearManafactured"));
                    double price = rs.getDouble("price");
                    String _color = rs.getString("color");
                    int id_province = rs.getInt("id_province");
                    int id_person = rs.getInt("id_person");
                    String _typeVehicle = rs.getString("typeVehicle");
                    filterVehicle.add(new Vehicle(id,manafacture,_color,price,yearManafactured,
                            id_province,id_person,_typeVehicle));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        else if (typeVehicle != null && !typeVehicle.equals("") && color != null && !color.equals("")){
            try(Connection conn = baseRepository.getConnection();
            PreparedStatement ppsm = conn.prepareStatement(sqlSearch)){
                ppsm.setString(1,typeVehicle);
                ppsm.setString(2,color);
                ResultSet rs = ppsm.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String manafacture = rs.getString("manafacture");
                    LocalDate yearManafactured = LocalDate.parse(rs.getString("yearManafactured"));
                    double price = rs.getDouble("price");
                    String _color = rs.getString("color");
                    int id_province = rs.getInt("id_province");
                    int id_person = rs.getInt("id_person");
                    String _typeVehicle = rs.getString("typeVehicle");
                    filterVehicle.add(new Vehicle(id,manafacture,_color,price,yearManafactured,
                            id_province,id_person,_typeVehicle));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        else{
            filterVehicle.addAll(showAllVehicles());
        }

        return filterVehicle;
    }

    @Override
    public Vehicle viewDetailVehicle(int id) {
        Vehicle viewDetail = null;
        Vehicle vehicle = findById(id);
        if(vehicle.getTypeVehicle().equals("Car")){
            try(Connection conn = baseRepository.getConnection();
            PreparedStatement ppsm = conn.prepareStatement(sqlViewCar);
            ){
                ppsm.setInt(1,id);
                ResultSet rs = ppsm.executeQuery();
                while(rs.next()){
                    int _id = rs.getInt("id");
                    LocalDate yearManafactured = LocalDate.parse(rs.getString("yearManafactured"));
                    String manafacture= rs.getString("manafacture");
                    double price = rs.getDouble("price");
                    String color = rs.getString("color");
                    int id_province = rs.getInt("id_province");
                    int id_person = rs.getInt("id_person");
                    String typeVehicle = rs.getString("typeVehicle");
                    int numberSeats = rs.getInt("numberSeats");
                    viewDetail = new Car(_id,manafacture,color,price,yearManafactured,id_province,id_person,typeVehicle,numberSeats);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        else if(vehicle.getTypeVehicle().equals("Motorbike")){
            try(Connection conn = baseRepository.getConnection();
                PreparedStatement ppsm = conn.prepareStatement(sqlViewMotor);
            ){
                ppsm.setInt(1,id);
                ResultSet rs = ppsm.executeQuery();
                while(rs.next()){
                    int _id = rs.getInt("id");
                    LocalDate yearManafactured = LocalDate.parse(rs.getString("yearManafactured"));
                    String manafacture= rs.getString("manafacture");
                    double price = rs.getDouble("price");
                    String color = rs.getString("color");
                    int id_province = rs.getInt("id_province");
                    int id_person = rs.getInt("id_person");
                    String typeVehicle = rs.getString("typeVehicle");
                    double speed = rs.getDouble("speed");
                    viewDetail = new Motorbike(_id,manafacture,color,price,yearManafactured,id_province,id_person,typeVehicle,speed);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        else{

        }
        return viewDetail;
    }
}