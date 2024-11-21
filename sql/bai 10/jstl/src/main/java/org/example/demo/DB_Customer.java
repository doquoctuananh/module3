package org.example.demo;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet (name = "DB_Customer" , value = "/customer")
public class DB_Customer extends HttpServlet {
    public static ArrayList<Customer> dataCustomer = new ArrayList();

    public  void init() {
        addData();
    }

    public static void addData(){
        dataCustomer.add(new Customer("tuan", LocalDate.parse("2001-12-04"), "123 Elm Street","https://allimages.sgp1.digitaloceanspaces.com/reviewtipeduvn/2022/04/1650682495_156_Hatake-Kakashi-Tong-hop-thong-tin-ve-Hokage-De-Luc.jpg"));
        dataCustomer.add(new Customer("a", LocalDate.parse("2001-12-04"), "123 Elm Street","https://allimages.sgp1.digitaloceanspaces.com/reviewtipeduvn/2022/04/1650682495_156_Hatake-Kakashi-Tong-hop-thong-tin-ve-Hokage-De-Luc.jpg"));
        dataCustomer.add(new Customer("b", LocalDate.parse("2001-12-04"), "123 Elm Street","https://allimages.sgp1.digitaloceanspaces.com/reviewtipeduvn/2022/04/1650682495_156_Hatake-Kakashi-Tong-hop-thong-tin-ve-Hokage-De-Luc.jpg"));
        dataCustomer.add(new Customer("Alice", LocalDate.parse("2001-12-04"), "123 Elm Street","https://allimages.sgp1.digitaloceanspaces.com/reviewtipeduvn/2022/04/1650682495_156_Hatake-Kakashi-Tong-hop-thong-tin-ve-Hokage-De-Luc.jpg"));
        dataCustomer.add(new Customer("Alice123", LocalDate.parse("2001-12-04"), "123 Elm Street","https://allimages.sgp1.digitaloceanspaces.com/reviewtipeduvn/2022/04/1650682495_156_Hatake-Kakashi-Tong-hop-thong-tin-ve-Hokage-De-Luc.jpg"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("dataCustomer", dataCustomer);
        request.getRequestDispatcher("customer_list.jsp").forward(request, response);

    }

    public void destroy() {

    }
}
