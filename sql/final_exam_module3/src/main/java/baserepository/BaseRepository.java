package baserepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    Connection connection =null;
    private static String url = "jdbc:mysql://localhost:3307/finalmodule3?useSSL=false";
    private static String userName = "root";
    private static String password = "123456";


    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Connect database successfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
