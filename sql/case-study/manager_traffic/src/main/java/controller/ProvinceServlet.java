package controller;

import model.Province;
import service.provinceService.ImplProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProvinceServlet", urlPatterns = "/province")
public class ProvinceServlet extends HttpServlet {
    private ImplProvinceService provinceService = new ImplProvinceService();
    @Override
    public void init()  {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action= "";
        }
        switch(action){
            case"createProvince":
                createProvince(request,response);
                break;
            case"updateProvince":
                updateProvince(request,response);
                break;
            case"deleteProvince":
                deleteProvince(request,response);
                break;
            default :
                showAllProvinces(request,response);
                break;
        }

    }

    private void showAllProvinces(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Province> provinceList = new ArrayList<>();
        provinceList= provinceService.showAllProvinces();
        request.setAttribute("provinceList", provinceList);
        request.getRequestDispatcher("province/showAll.jsp").forward(request,response);
    }

    private void createProvince(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("province/create.jsp").forward(request,response);
    }

    private void updateProvince(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Province province = provinceService.findProvinceById(id);
        request.setAttribute("province", province);
        request.setAttribute("id", id);
        request.getRequestDispatcher("province/update.jsp").forward(request,response);
    }
    private void deleteProvince(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        provinceService.deleteProvince(id);
        response.sendRedirect("province");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action){
            case"createProvinceForm":
                createProvinceForm(request,response);
                break;
            case"updateProvinceForm":
                updateProvinceForm(request,response);
                break;
        }
    }

    private void createProvinceForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = request.getParameter("name");
        Province province = new Province(name);
        boolean result = provinceService.createProvince(province);
        request.setAttribute("result",result);
        if(result){
            response.sendRedirect("province");
        }
        else{
            request.getRequestDispatcher("province/create.jsp").forward(request,response);
        }
    }

    private void updateProvinceForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Province province = new Province(id,name);
        boolean result = provinceService.updateProvince(province);
        response.sendRedirect("province");
    }
}
