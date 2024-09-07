<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Página de Bienvenida</title>
</head>
<body>
    <h1><%= request.getAttribute("saludo") %> <%= request.getAttribute("nombre") %>!</h1>
</body>
</html>