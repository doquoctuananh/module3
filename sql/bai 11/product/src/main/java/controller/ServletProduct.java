package controller;

import model.Product;
import service.Iproduct;
import service.ServiceImplProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="ServletProduct" , urlPatterns = "/product")
public class ServletProduct extends HttpServlet {
    private Iproduct productsServlet = new ServiceImplProduct();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String action = request.getParameter("action");
    if(action == null){
        action="";
    }

    switch(action){
        case "showallproduct":{
            showAllProduct(request,response);
            break;
        }
        case "create":{
            createProduct(request,response);
            break;
        }
        case "update":{
            updateProduct(request,response);
            break;
        }
        case "delete":{
            deleteProduct(request,response);
            break;
        }
        case "showDetailProduct":{
            showDetailProduct(request,response);
            break;
        }
        case "searchProduct":{
            searchProduct(request,response);
            break;
        }
    }

    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = this.productsServlet.showAllProduct();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product/showAllProduct.jsp").forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }

    public void updateProduct(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productsServlet.findById(id);
//        request.setAttribute("id",id);
        request.setAttribute("product",product);

        request.getRequestDispatcher("product/update.jsp").forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.productsServlet.deleteProduct(id);
//        response.sendRedirect("http://localhost:8080");
        response.sendRedirect("product?action=showallproduct");
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{
        String search = request.getParameter("search");
        ArrayList<Product> products = this.productsServlet.searchProduct(search);
        request.setAttribute("products",products);
        request.setAttribute("search",search);
        request.getRequestDispatcher("product/searchProduct.jsp").forward(request, response);
    }

    private void showDetailProduct(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("product/showDetailProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action){
            case "createForm":{
                handleCreateForm(req,resp);
                break;
            }
            case "updateForm":{
                handleUpdateForm(req,resp);
                break;
            }
            case "showDetailProductForm":{
                handleShowDetailProductForm(req,resp);
                break;
            }

        }
    }

    private void handleCreateForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String color = req.getParameter("color");
        Product product = new Product(name,price,color,description);
        this.productsServlet.createProduct(product);
        req.setAttribute("product", product);
        resp.sendRedirect("/product?action=showallproduct");
    }

    private void handleUpdateForm(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price= Double.parseDouble(req.getParameter("price"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        Product product = this.productsServlet.updateProduct(id);
        product.setName(name);
        product.setPrice(price);
        product.setColor(color);
        product.setDescription(description);
//        req.setAttribute("product", product);
        resp.sendRedirect("product?action=showallproduct");
    }

    private void handleShowDetailProductForm(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Product product = this.productsServlet.showDetailProduct(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("product/showDetailProduct.jsp").forward(req, resp);

    }
}
