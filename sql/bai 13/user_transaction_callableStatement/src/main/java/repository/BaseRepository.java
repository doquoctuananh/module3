package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String urlMysql = "jdbc:mysql://localhost:3307/users?useSSL=false";
    private String userName = "root";
    private String password = "123456";



    //ket noi den co so du lieu
    public Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(urlMysql, userName, password);
            System.out.println("Connect database successfully");
        }
        catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    };
}
