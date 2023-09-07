package com.example.crudplagedemo.servlet;

import com.example.crudplagedemo.models.Plage;
import com.example.crudplagedemo.service.PlageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    private PlageService plageService;


    public DeleteServlet(){
        super();
        this.plageService = new PlageService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        long id = Long.parseLong(request.getParameter("idPlage"));

        Plage plage = this.plageService.getOne(id);

        if(plage == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.plageService.removePLage(plage);
            response.sendRedirect("list");

        }
    }
}
