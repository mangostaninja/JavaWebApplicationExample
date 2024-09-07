<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Página de Bienvenida</title>
</head>
<body>
    <!-- Mostrar el saludo y el nombre por separado -->
    <h1><%= request.getAttribute("saludo") %></h1>

    <!-- Botón para volver al formulario -->
    <form action="myServlet" method="GET">
        <button type="submit">Modificar datos</button>
    </form>

    <!-- Botón para mostrar un mensaje más divertido -->
    <form action="myServlet2" method="POST">
        <input type="hidden" name="nombre" value="<%= request.getAttribute("nombre") %>">
        <input type="hidden" name="sexo" value="<%= request.getAttribute("sexo") %>">
        <button type="submit" name="accion" value="divertido">Mensaje divertido</button>
    </form>

    <!-- Botón para ver los saludos almacenados -->
    <form action="verSaludos" method="GET">
        <button type="submit">Ver todos los saludos</button>
    </form>
</body>
</html>
