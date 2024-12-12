package repository.productRepository;

import baserepository.BaseRepository;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private static String sqlFindAll = "select p.id,p.nameProduct,p.price,p.quantity,p.color,c.name from product as p \n" +
            "join category as c on p.id_category = c.id";
    private static String sqlCreate = "INSERT INTO product (nameProduct, price, quantity, color, description, id_category)\n" +
            "VALUES(?,?,?,?,?,?)";
    private static String sqlDelte = "DELETE FROM product WHERE id = ?";

    private static String sqlfind= "SELECT * FROM product WHERE id = ?";
    private static String sqlSearch = "select p.id,p.nameProduct,p.price,p.quantity,p.color,c.name from product as p \n" +
            "join category as c on p.id_category = c.id WHERE p.nameProduct like ? and p.price > ?";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try(Connection con = baseRepository.getConnection();
            PreparedStatement ppsm = con.prepareStatement(sqlFindAll)){
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nameProduct = rs.getString("nameProduct");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("name");
                products.add(new Product(id, nameProduct, price, quantity, color, category));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try(Connection con = baseRepository.getConnection();
            PreparedStatement ppsm = con.prepareStatement(sqlCreate))
        {
            ppsm.setInt(1, id);
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                rs.getString("nameProduct");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("name");
                product = new Product(id, rs.getString("nameProduct"), price, quantity, color, category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean createProduct(Product product) {
        boolean result = false;
        try(Connection con = baseRepository.getConnection();
        PreparedStatement ppsm = con.prepareStatement(sqlCreate))
        {
            ppsm.setString(1,product.getName());
            ppsm.setDouble(2,product.getPrice());
            ppsm.setInt(3,product.getQuantity());
            ppsm.setString(4,product.getColor());
            ppsm.setString(5,product.getDescription());
            ppsm.setInt(6,product.getId_category());
            int row = ppsm.executeUpdate();
            if(row > 0){
                result = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean result = false;
        try(Connection con = baseRepository.getConnection();
            PreparedStatement ppsm = con.prepareStatement(sqlDelte)){
            ppsm.setInt(1,id);
            int row = ppsm.executeUpdate();
            if(row > 0){
                result = true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Product> searchProduct(String nameProduct, double price) {
        List<Product> products = new ArrayList<>();

        try(Connection con = baseRepository.getConnection();
            PreparedStatement ppsm = con.prepareStatement(sqlSearch))
        {
            ppsm.setString(1,"%"+nameProduct+"%");
            ppsm.setDouble(2,price);
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String namePrt = rs.getString("nameProduct");
                double price2 = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("name");
                products.add(new Product(id, namePrt, price2, quantity, color, category));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }
}
