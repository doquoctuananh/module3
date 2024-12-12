package controller;

import model.Category;
import model.Product;
import service.categoryService.CategoryService;
import service.categoryService.ICategoryService;
import service.productService.IProductService;
import service.productService.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "ProductServlet", value="/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch(action) {
            case "createProduct":
                createProduct(req,resp);
                break;
            case "deleteProduct":
                deleteProduct(req,resp);
                break;
            case "searchProduct":
                searchProduct(req,resp);
                break;
            default:
                showAllProduct(req,resp);

        }
    }

    private void showAllProduct(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("product/showAll.jsp").forward(req, resp);
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("product/create.jsp").forward(req, resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        resp.sendRedirect("/product");
    }

    private void searchProduct(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String name = req.getParameter("name");
        if(name == null) {
            name = "";
        }
        double price = Double.parseDouble(req.getParameter("price"));
        if(price < 0  ) {
            price = 0;
        }
        List<Product> products=productService.searchProduct(name, price);
        req.setAttribute("products", products);
        req.getRequestDispatcher("product/showAll.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        switch(action) {
            case "createForm":
                createForm(req,resp);
                break;
        }
    }

    private void createForm(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String nameProduct = req.getParameter("nameProduct");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        int id_catetory = Integer.parseInt(req.getParameter("id_catetory"));
        productService.createProduct(new Product(nameProduct, price, quantity, color, description, id_catetory));
        resp.sendRedirect("/product");
    }
}
