package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceImplProduct implements Iproduct{
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1,new Product("acer",15,"color","8gb"));
        products.put(2,new Product("dell",15,"color","16gb"));
        products.put(3,new Product("asus",15,"color","32gb"));
        products.put(4,new Product("mac",15,"color","8gb"));
        products.put(5,new Product("Hp",15,"color","4gb"));

    }

    public static Map<Integer, Product> getProducts() {
        return products;
    }

    public static void setProducts(Map<Integer, Product> products) {
        ServiceImplProduct.products = products;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        if(products.containsKey(id)){
            product= products.get(id);
        }
        return product;
    }

    @Override
    public List<Product> showAllProduct() {
        List<Product> productsArrayList = new ArrayList<>();
        productsArrayList.addAll(products.values());
        return productsArrayList;
    }

    @Override
    public void createProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product updateProduct(int id) {
        return products.get(id);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }

    @Override
    public Product showDetailProduct(int id) {
        Product product = null;
        if(products.containsKey(id)){
            return products.get(id);
        }
        return product;
    }

    @Override
    public ArrayList<Product> searchProduct(String search) {
        ArrayList<Product> productsArrayList = new ArrayList<>();
        for (int i : products.keySet()) {
            if(products.get(i).getName().toLowerCase().contains(search.toLowerCase())){
                productsArrayList.add(products.get(i));
            }
        }
        return productsArrayList;
    }
}
