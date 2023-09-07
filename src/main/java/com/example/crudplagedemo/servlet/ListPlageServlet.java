package com.example.crudplagedemo.servlet;

import com.example.crudplagedemo.models.Plage;
import com.example.crudplagedemo.service.PlageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "plage-list", value = "/list")
public class ListPlageServlet extends HttpServlet {
    private final PlageService plageService;

    public ListPlageServlet(){
        super();
        this.plageService = new PlageService();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Plage> plages = this.plageService.getAll();

        request.setAttribute("plages", plages);

        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

}
