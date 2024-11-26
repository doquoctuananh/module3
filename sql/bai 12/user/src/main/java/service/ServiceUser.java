package service;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ServiceUser implements IUser{
    private static String urlMysql = "jdbc:mysql://localhost:3307/users?useSSL=false";
//    jdbc:mysql://127.0.0.1:3306/?user=root
    private static String username = "root";
    private static String password ="123456";

    private static final String sqlGetAllUser = "select*from user" ;
    private static final String sqlInsertUser = "insert into user(name,email,country) values(?,?,?)";
    private static final String sqlUpdateUser= "update user set name = ?, email=?, country =? where id =?";
    private static final String sqlDeleteUser = "delete from user where id =?";
    private static final String sqlSearchName = "select * from user where user.name like ?";
    private static final String sqlSortName= "select*from user order by name desc";

    public ServiceUser() {
    }

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(urlMysql, username, password);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    @Override
    public User findUserId(int id) {

        return null;
    }

    @Override
    public List<User> showAllUser() {
        List<User> users = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllUser);
        ) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    users.add(new User(id,name,email,country));
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public boolean createUser(User user) {
        try(Connection connection = getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sqlInsertUser);
        ){
            preparedstatement.setString(1,user.getName());
            preparedstatement.setString(2,user.getEmail());
            preparedstatement.setString(3,user.getCountry());
            int row = preparedstatement.executeUpdate();
            if(row >0){
                return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try(Connection connection = getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sqlUpdateUser);
        ){
            preparedstatement.setString(1,user.getName());
            preparedstatement.setString(2,user.getEmail());
            preparedstatement.setString(3,user.getCountry());
            preparedstatement.setInt(4,user.getId());
            int row = preparedstatement.executeUpdate();
            if(row >0){
                return true;
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        try(Connection connection = getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sqlDeleteUser);
        ){
            preparedstatement.setInt(1,id);
            int row = preparedstatement.executeUpdate();
            if(row>0){
                return true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> searchUserName(String searchName) {
        List<User> users = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSearchName);
        ){
            preparedStatement.setString(1,"%" + searchName +"%");
            ResultSet resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id,name,email,country);
                users.add(user);
            }
            return users;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> sortUserName() {
        List<User> users = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSearchName);)
        {
            ResultSet resultSet = preparedStatement.executeQuery(sqlSortName);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id,name,email,country);
                users.add(user);
            }
            return users;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }
}
