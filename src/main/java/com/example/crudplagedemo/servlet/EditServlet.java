package com.example.crudplagedemo.servlet;

import com.example.crudplagedemo.models.Plage;
import com.example.crudplagedemo.service.PlageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "editePlage", urlPatterns = "/edit")
public class EditServlet extends HttpServlet {

    private PlageService plageService;

    public EditServlet() {
        this.plageService = new PlageService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("idPlage"));
        Plage plage = this.plageService.getOne(id);

        if(plage == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            req.setAttribute("plageEdit", plage);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("idPlage"));
        Plage plage = this.plageService.getOne(id);

        if(plage == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            String nomPlage = request.getParameter("plage-nom");
            String numero = request.getParameter("plage-number");
            String street = request.getParameter("plage-street");
            String codePostal = request.getParameter("plage-codePostal");
            String ville = request.getParameter("plage-city");
            String gestionnaire = request.getParameter("plage-emailGest");
            String photo = request.getParameter("plage-photo");

            plage.setNom(nomPlage);
            plage.setNumber(numero);
            plage.setStreet(street);
            plage.setCodePostal(codePostal);
            plage.setCity(ville);
            plage.setEmail(gestionnaire);
            plage.setImage(photo);

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            // Réccupération des erreurs
            Set<ConstraintViolation<Plage>> errors = validator.validate(plage);

            // Il n'y a pas d'erreur, on enregistre et on redirige !
            if(errors.isEmpty()){
                this.plageService.update(plage);
                response.sendRedirect("list");
            } else {
                request.setAttribute("errors", errors);
                request.setAttribute("plageEdit", plage);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
            }
        }


    }
}
