package com.example.crudplagedemo.servlet;

import com.example.crudplagedemo.models.Plage;
import com.example.crudplagedemo.service.PlageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "plage-detail", value = "/detail")
public class DetailPlageServlet extends HttpServlet {
    private PlageService plageService;
    public DetailPlageServlet(){
        super();
        this.plageService = new PlageService();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Plage plage = plageService.getOne(id);

        if (plage == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }else{
            request.setAttribute("plage", plage);
            request.getRequestDispatcher("detail.jsp").forward(request, response);
        }

    }
}
