<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Saludos Almacenados</title>
</head>
<body>
    <h1>Lista de Saludos</h1>

    <!-- Mostrar la lista de saludos almacenados -->
    <ul>
        <c:forEach var="saludo" items="${listaSaludos}">
            <li>${saludo}</li>
        </c:forEach>
    </ul>

    <!-- Botón para volver al formulario -->
    <form action="myServlet" method="GET">
        <button type="submit">Volver al formulario</button>
    </form>
</body>
</html>
