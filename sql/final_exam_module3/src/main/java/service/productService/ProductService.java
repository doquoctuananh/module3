package service.productService;

import model.Product;
import repository.productRepository.IProductRepository;
import repository.productRepository.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean createProduct(Product product) {
        boolean result = productRepository.createProduct(product);

         return result;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean result = productRepository.deleteProduct(id);
        return result;
    }

    @Override
    public List<Product> searchProduct(String nameProduct, double price) {
        List<Product> products = productRepository.searchProduct(nameProduct, price);
        return products;
    }
}
