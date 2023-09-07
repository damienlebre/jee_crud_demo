<%--
  Created by IntelliJ IDEA.
  User: aero
  Date: 05/09/2023
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
  <title>Les plages de la côte !</title>

  <%@include file="parts/script-style.jsp"%>

</head>
<body class="bg-secondary">
<%@include file="parts/header.jsp"%>

<%@include file="parts/menu.jsp"%>

<div class="container mx-5 min-vh-100">

  <div class="title container my-5 mx-5">
    <h1>Les plus belles plages privées :</h1>
  </div>

  <c:if test="${plages.size() == 0}">
    <div class="text-center text-danger">
      <h1>Aucune plage à afficher !</h1>
    </div>
  </c:if>
  <c:if test="${plages.size() != 0}">
    <table class="table">
      <thead>
      <tr class="table-active">
        <th scope="col">Nom</th>
        <th scope="col">Adresse</th>
        <th scope="col">Ville</th>
        <th scope="col">Image</th>
        <th scope="col">Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${plages}" var="plage">
        <tr>
          <td>${plage.getNom()}</td>
          <td>${plage.getNumber()} ${plage.getStreet()} ${plage.getCodePostal()}</td>
          <td>${plage.getCity()}</td>
          <td><img style="max-height:100px" class="img-thumbnail" src="images/${plage.getImage()}"></td>
          <td>
            <a href="detail?id=${plage.getId()}">
              <button type="button" class="btn btn-outline-info">Voir la plage <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 576 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><style>svg{fill:#f7f7f8}</style><path d="M288 32c-80.8 0-145.5 36.8-192.6 80.6C48.6 156 17.3 208 2.5 243.7c-3.3 7.9-3.3 16.7 0 24.6C17.3 304 48.6 356 95.4 399.4C142.5 443.2 207.2 480 288 480s145.5-36.8 192.6-80.6c46.8-43.5 78.1-95.4 93-131.1c3.3-7.9 3.3-16.7 0-24.6c-14.9-35.7-46.2-87.7-93-131.1C433.5 68.8 368.8 32 288 32zM144 256a144 144 0 1 1 288 0 144 144 0 1 1 -288 0zm144-64c0 35.3-28.7 64-64 64c-7.1 0-13.9-1.2-20.3-3.3c-5.5-1.8-11.9 1.6-11.7 7.4c.3 6.9 1.3 13.8 3.2 20.7c13.7 51.2 66.4 81.6 117.6 67.9s81.6-66.4 67.9-117.6c-11.1-41.5-47.8-69.4-88.6-71.1c-5.8-.2-9.2 6.1-7.4 11.7c2.1 6.4 3.3 13.2 3.3 20.3z"/></svg>
              </button>
            </a>
            <a class="mx-3" href="delete?idPlage=${plage.getId()}">
              <button type="button" class="btn btn-outline-danger">Supprimer la plage <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><style>svg{fill:#ffffff}</style><path d="M135.2 17.7C140.6 6.8 151.7 0 163.8 0H284.2c12.1 0 23.2 6.8 28.6 17.7L320 32h96c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 96 0 81.7 0 64S14.3 32 32 32h96l7.2-14.3zM32 128H416V448c0 35.3-28.7 64-64 64H96c-35.3 0-64-28.7-64-64V128zm96 64c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16zm96 0c-8.8 0-16 7.2-16 16V432c0 8.8 7.2 16 16 16s16-7.2 16-16V208c0-8.8-7.2-16-16-16z"/></svg>
              </button>
            </a>
            <a href="edit?idPlage=${plage.getId()}">
              <button type="button" class="btn btn-outline-success">Editer <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 576 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M0 64C0 28.7 28.7 0 64 0H224V128c0 17.7 14.3 32 32 32H384V285.7l-86.8 86.8c-10.3 10.3-17.5 23.1-21 37.2l-18.7 74.9c-2.3 9.2-1.8 18.8 1.3 27.5H64c-35.3 0-64-28.7-64-64V64zm384 64H256V0L384 128zM549.8 235.7l14.4 14.4c15.6 15.6 15.6 40.9 0 56.6l-29.4 29.4-71-71 29.4-29.4c15.6-15.6 40.9-15.6 56.6 0zM311.9 417L441.1 287.8l71 71L382.9 487.9c-4.1 4.1-9.2 7-14.9 8.4l-60.1 15c-5.5 1.4-11.2-.2-15.2-4.2s-5.6-9.7-4.2-15.2l15-60.1c1.4-5.6 4.3-10.8 8.4-14.9z"/></svg>
              </button>
            </a>

          </td>

        </tr>
      </c:forEach>

      </tbody>
    </table>
  </c:if>


</div>

<%@include file="parts/footer.jsp"%>

</body>
</html>