package repository.personRepository;

import model.Person;
import repository.BaseRespository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImplPersonRepository implements IPersonRepository{
    private BaseRespository baseRepository= new BaseRespository();
    private static String sqlFindById = "select *from person where id=?";
    private static String sqlShowAll = "select * from person";
    private static String sqlCreate = "insert into person(name,address,birthday,phone,email,id_province) \n" +
            "values(?,?,?,?,?,?)";
    private static String sqlUpdate = "update person set name =?,address=?,birthday=?,phone=?,email=?,id_province=? where id=?";
    private static String sqlDeletePerson = "delete from person where id=?";

    private static String sqlDeleteVehicle = "delete from vehicle as v where v.id_person = ? ";

    private static String sqlDeleteCar = "delete from car where id in \n" +
            "(select v.id from vehicle as v where v.id_person = ?";

    private static String sqlDeleteMotor = "delete from motorbike where id in" +
            "(select v.id from vehicle as v where v.id_person = ?)";
    @Override
    public Person findPersonById(int id) {
        Person person = null;
        try(Connection conn = baseRepository.getConnection();
            PreparedStatement ppsm = conn.prepareStatement(sqlFindById)
        ){
            ppsm.setInt(1, id);
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                int _id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int id_province = rs.getInt("id_province");
                person = new Person(_id,name,birthday,address,email,phone,id_province);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public List<Person> showAllPersons() {
        List<Person> personList = new ArrayList<>();
        try(Connection conn = baseRepository.getConnection();
            PreparedStatement ppsm = conn.prepareStatement(sqlShowAll)
        ){
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int id_province = rs.getInt("id_province");
                Person person = new Person(id,name,birthday,address,email,phone,id_province);
                personList.add(person);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public boolean createPerson(Person person) {
        boolean result = false;
        try(Connection conn = baseRepository.getConnection();
            PreparedStatement ppsm = conn.prepareStatement(sqlCreate)
        ){

            ppsm.setString(1, person.getName());
            ppsm.setString(2, person.getAddress());
            ppsm.setString(3, person.getBirthday().toString());
            ppsm.setString(4, person.getPhone());
            ppsm.setString(5, person.getEmail());
            ppsm.setInt(6, person.getId_province());
            int row = ppsm.executeUpdate();
            if(row>0){
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updatePerson(Person person) {
        boolean result = false;
        try(Connection conn = baseRepository.getConnection();
            PreparedStatement ppsm = conn.prepareStatement(sqlUpdate)
        ){
            ppsm.setString(1, person.getName());
            ppsm.setString(2, person.getAddress());
            ppsm.setString(3, person.getBirthday().toString());
            ppsm.setString(4, person.getPhone());
            ppsm.setString(5, person.getEmail());
            ppsm.setInt(6, person.getId_province());
            ppsm.setInt(7, person.getId());
            int row = ppsm.executeUpdate();
            if(row>0){
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deletePerson(int id) {
        boolean result = false;
        try(Connection conn = baseRepository.getConnection();
        PreparedStatement ppsmCar = conn.prepareStatement(sqlDeleteCar);
        PreparedStatement ppsmMotor = conn.prepareStatement(sqlDeleteMotor);
        ){
            ppsmCar.setInt(1, id);
            int rowCar = ppsmCar.executeUpdate();
            ppsmMotor.setInt(1,id);
            int rowMotor =ppsmMotor.executeUpdate();
            if(rowCar>0 || rowMotor>0){
                PreparedStatement ppsmVehicle = conn.prepareStatement(sqlDeleteVehicle);
                ppsmVehicle.setInt(1, id);
                int rowVehicle = ppsmVehicle.executeUpdate();
                if(rowVehicle>0){
                    PreparedStatement ppsmPerson = conn.prepareStatement(sqlDeletePerson);
                    ppsmPerson.setInt(1,id);
                    int row = ppsmPerson.executeUpdate();
                    if(row>0){
                        result = true;
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}

