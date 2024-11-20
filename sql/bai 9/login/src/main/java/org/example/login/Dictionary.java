package org.example.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet (name = "Dictionary", urlPatterns = "/dictionary")
public class Dictionary extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String,String> hash = new HashMap<>();
        hash.put("name","ten");
        hash.put("dictionary","tu dien");
        hash.put("age","tuoi");
        String word = request.getParameter("dictionary");
        String result = hash.get(word);
        if(result == null){
            request.setAttribute("result",word+ " No dictionary found");
        }
        else{
            request.setAttribute("result",word + " " +result);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("dictionary.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
