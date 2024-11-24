package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface Iproduct {
    Product findById(int id);
    List<Product> showAllProduct();
    void createProduct(Product product);
    Product updateProduct(int id);
    void deleteProduct(int id);
    Product showDetailProduct(int id);
    ArrayList<Product> searchProduct(String search);
}
