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

@WebServlet(name = "ajoutPlage", urlPatterns = "/ajout")
public class AjoutPlageServlet extends HttpServlet {
    private PlageService plageService;

    public AjoutPlageServlet() {
        super();
        this.plageService = new PlageService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("ajout.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer tous les éléments dans votre requête
        String nomPlage = request.getParameter("plage-nom");
        String numero = request.getParameter("plage-number");
        String street = request.getParameter("plage-street");
        String codePostal = request.getParameter("plage-codePostal");
        String ville = request.getParameter("plage-city");
        String gestionnaire = request.getParameter("plage-emailGest");
        String photo = request.getParameter("plage-photo");

        // Créer un nouvel objet à partir de ces éléments
        Plage plage = new Plage(nomPlage, street, numero, codePostal, ville, gestionnaire, photo);

        // Utiliser la validation pour valider cet objet
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Réccupération des erreurs
        Set<ConstraintViolation<Plage>> errors = validator.validate(plage);

        // Il n'y a pas d'erreur, on enregistre et on redirige !
        if(errors.isEmpty()){
            this.plageService.add(plage);
            response.sendRedirect("list");
        } else {
            // Il y a des erreurs, on ajoute dans notre requête les erreurs
            request.setAttribute("errors", errors);
            // On enregistre dans notre requête les saisie utilisateurs pour préremplir nos champs
            request.setAttribute("saisie", plage);
            request.getRequestDispatcher("ajout.jsp").forward(request, response);

        }

    }

}
