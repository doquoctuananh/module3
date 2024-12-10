package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRespository {

    // cau hinh thong tin mysql
    private String url = "jdbc:mysql://localhost:3307/manager_traffic?useSSL=false";
    private String name = "root";
    private String password = "123456";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, name, password);
            System.out.println("Connected to database succesfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}