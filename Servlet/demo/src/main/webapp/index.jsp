<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liberfinx</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
        }

        .container {
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
        }

        a {
            display: block;
            text-decoration: none;
            background-color: #007bff;
            color: white;
            padding: 15px 20px;
            margin: 10px 0;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1><%= "Administración de usuarios" %></h1>
    <a href="mostrar-usuarios">Mostrar Usuarios</a>
    <a href="insertar-usuarios">Insertar usuario nuevo</a>
    <a href="editar-usuarios">Editar usuario</a>
    <a href="borrar-usuarios">Borrar usuario</a>
</div>
</body>
</html>
