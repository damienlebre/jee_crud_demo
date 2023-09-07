<%--
  Created by IntelliJ IDEA.
  User: roota
  Date: 07/09/2023
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edition de la plage ${plageEdit.nom} !</title>
    <%@include file="parts/script-style.jsp"%>
</head>
<body>

<%@include file="parts/header.jsp"%>
<%@include file="parts/menu.jsp"%>

  <div class="container">


      <form method="post" class="mt-5">
          <fieldset>
              <legend><h1>Edition de la plage ${plageEdit.nom} !</h1></legend>

              <div class="form-group col-md-3">
                  <label for="nomPLage" class="form-label mt-4">Nom de la plage : </label>
                  <input type="text" value="${plageEdit.nom}" name="plage-nom" placeholder="Nom de la plage" class="form-control" id="nomPLage">
              </div>

              <div class="form-group col-md-3">
                  <label for="numberPLage" class="form-label mt-4">numero de rue/voie : </label>
                  <input type="text" value="${plageEdit.number}" name="plage-number" placeholder="numero de rue/voie" class="form-control" id="numberPLage">
              </div>

              <div class="form-group col-md-3">
                  <label for="streetPLage" class="form-label mt-4">Rue/Voie : </label>
                  <input type="text" value="${plageEdit.street}" name="plage-street" placeholder="Rue/Voie" class="form-control" id="streetPLage">
              </div>

              <div class="form-group col-md-3">
                  <label for="codePostal" class="form-label mt-4">Code Postal : </label>
                  <input type="text" value="${plageEdit.codePostal}" name="plage-codePostal" placeholder="Code Postal" class="form-control" id="codePostal">
              </div>

              <div class="form-group col-md-3">
                  <label for="city" class="form-label mt-4">Ville/Commune : </label>
                  <input type="text" value="${plageEdit.city}" name="plage-city" placeholder="Ville/Commune" class="form-control" id="city">
              </div>

              <div class="form-group col-md-3">
                  <label for="emailGestionnaire" class="form-label mt-4">Email du Gestionnaire : </label>
                  <input type="text" value="${plageEdit.email}" name="plage-emailGest" placeholder="Ville/Commune" class="form-control" id="emailGestionnaire">
                  <small id="emailHelp" class="form-text text-muted">Merci de renseigner une adresse valide.</small>
              </div>

              <div class="form-group col-md-3">
                  <label for="photo" class="form-label mt-4">Photo : </label>
                  <input type="text" value="${plageEdit.image}" name="plage-photo" placeholder="URL de la photo de la plage" class="form-control" id="photo">
              </div>

              <button type="submit" class="btn btn-outline-primary my-5">Mettre à jour la plage</button>

              <div class="text-center">
                  <c:if test = "${errors.size() !=  0}">
                      <ol class="text-danger text-center">
                          <c:forEach items="${ errors }" var="error">
                              <li>${error.message}</li>
                          </c:forEach>
                      </ol>
                  </c:if>
              </div>


          </fieldset>
      </form>

      <a href="list">Revenir à la liste de toutes les plages </a>


  </div>
<%@include file="parts/footer.jsp"%>
</body>
</html>
