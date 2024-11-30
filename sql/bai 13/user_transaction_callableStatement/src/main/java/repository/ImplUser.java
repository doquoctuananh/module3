package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImplUser implements IUser{

    private BaseRepository baseRepository= new BaseRepository();

    //cau truy van
    private static final String sqlSelectAll = "select * from user";
    private static final String sqlStoreInsert = "{CALL insertProcedure(?,?,?)}";
    private static final String sqlUpdate = "update user set name=?,email=?,country=? where id=?";
    private static final String selDelete = "delete from user where id = ?";
    private static final String sqlStoreFindUserId = "{call findUserId(?)}";
    private static final String sqlInsertUser = "insert into user(name,email,country) values(?,?,?)";
    private static final String sqlTransactionCreate = "insert into user_permision(user_id,permision_id) values(?,?)";
    @Override
    public List<User> showAllUser() {
        List<User> users = null;
        try(Connection connection = baseRepository.getConnection();
            PreparedStatement ppsm = connection.prepareStatement(sqlSelectAll);
        ){
            ResultSet result = ppsm.executeQuery();
            users = new ArrayList<>();
            while (result.next()) {
                int id= result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String country = result.getString("country");
                users.add((new User(id,name,email,country)));
            }
            return users;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findUserId(int id) {
        User user = null;
        try(Connection connection = baseRepository.getConnection();
            PreparedStatement ppsm = connection.prepareStatement(sqlStoreFindUserId)
        ){
            ppsm.setInt(1,id);
            ResultSet result = ppsm.executeQuery();
            while(result.next()){
                int _id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String country = result.getString("country");
                user = new User(_id,name,email,country);
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void createUser(User user) {
        boolean result = false;
        try(Connection connection = baseRepository.getConnection();
            CallableStatement clsm = connection.prepareCall(sqlStoreInsert)
        ){
            clsm.setString(1, user.getName());
            clsm.setString(2, user.getEmail());
            clsm.setString(3, user.getCountry());
             clsm.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean updateUser(User user) {
        boolean result = false;
        try(Connection connection = baseRepository.getConnection();
            PreparedStatement ppsm = connection.prepareStatement(sqlUpdate)
        ){
            ppsm.setString(1, user.getName());
            ppsm.setString(2, user.getEmail());
            ppsm.setString(3, user.getCountry());
            ppsm.setInt(4,user.getId());
            int row =ppsm.executeUpdate();
            if(row>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean result = false;
        try(Connection connection = baseRepository.getConnection();
            PreparedStatement ppsm = connection.prepareStatement(selDelete)
        ){
            ppsm.setInt(1,id);
            int row =ppsm.executeUpdate();
            if(row>0){
                result = true;
            }
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void createTransaction(User user, List<Integer> permision) {
        try(Connection connection = baseRepository.getConnection();
            PreparedStatement ppsm = connection.prepareStatement(sqlInsertUser,Statement.RETURN_GENERATED_KEYS);

        ){
            ppsm.setString(1,user.getName());
            ppsm.setString(2,user.getEmail());
            ppsm.setString(3,user.getCountry());
            int row = ppsm.executeUpdate();
            ResultSet resultSet = ppsm.getGeneratedKeys();
            int user_id=-1;
            while(resultSet.next()){
                user_id = resultSet.getInt(1);
            }
            if(row==1){
                PreparedStatement ppsmtran= connection.prepareStatement(sqlTransactionCreate);
                for (int i = 0; i < permision.size(); i++) {
                    ppsmtran.setInt(1,user_id);
                    ppsmtran.setInt(2,permision.get(i));
                    ppsmtran.executeUpdate();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
