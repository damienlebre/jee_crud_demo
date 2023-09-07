<%--
  Created by IntelliJ IDEA.
  User: aero
  Date: 05/09/2023
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>Détail de la plage de ${plage.getNom()} : </title>

    <%@include file="parts/script-style.jsp"%>

</head>
<%@include file="parts/header.jsp"%>

<%@include file="parts/menu.jsp"%>

<div class="container mx-5 min-vh-100">

    <div class="title container my-5">
        <h1>Détail de la plage de ${plage.getNom()} :</h1>
    </div>

    <div class="cardPlage-detail text-center">

        <img src="images/${plage.getImage()}" class="img-fluid">

        <div>
            ${plage.number} ${plage.street} ${plage.codePostal} ${plage.city}
        </div>

        <div>
            <label>Contacter le gérant : </label>
            <a href="mailto:${plage.getEmail()}">Contacter le gestionnaire !</a>
        </div>

        <a href="list">Revenir sur le listing</a>

    </div>

</div>

<%@include file="parts/footer.jsp"%>

</body>
</html>