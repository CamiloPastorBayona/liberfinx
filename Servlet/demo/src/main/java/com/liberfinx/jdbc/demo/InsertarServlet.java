package com.liberfinx.jdbc.demo;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "insertarServlet", value = "/insertar-usuarios")
@MultipartConfig
public class InsertarServlet extends HttpServlet {
    UsuarioControlador controlador = new UsuarioControlador();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String correo = req.getParameter("correo");
        String imagen = req.getParameter("imagen");
        String contraseña = req.getParameter("contraseña");

        if (nombre != null && correo != null && imagen != null && contraseña != null &&
                !nombre.isEmpty() && !correo.isEmpty() && !imagen.isEmpty() && !contraseña.isEmpty()) {

            controlador.crearUsuario(nombre, correo, contraseña, imagen);

            resp.sendRedirect("./mostrar-usuarios");
        } else {

            resp.getWriter().println("Error: Todos los campos son obligatorios.");
        }
    }


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Insertar Usuario</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; background-color: #f4f4f4; }");
            out.println(".container { width: 300px; padding: 20px; text-align: center; background-color: white; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("h2 { margin-bottom: 20px; }");
            out.println("form { display: flex; flex-direction: column; }");
            out.println("label { margin-bottom: 5px; text-align: left; }");
            out.println("input[type='text'], input[type='email'], input[type='password'], input[type='file'] { padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; width: 100%; box-sizing: border-box; }");
            out.println("input[type='submit'] { padding: 10px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer; font-size: 16px; }");
            out.println("input[type='submit']:hover { background-color: #0056b3; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Insertar Usuario</h2>");
            out.println("<form action='insertar-usuarios' method='POST' enctype='multipart/form-data'>");
            out.println("<label for='nombre'>Nombre</label>");
            out.println("<input type='text' id='nombre' name='nombre' required>");
            out.println("<label for='correo'>Correo</label>");
            out.println("<input type='email' id='correo' name='correo' required>");
            out.println("<label for='imagen'>Imagen de Perfil</label>");
            out.println("<input type='text' id='imagen' name='imagen' required>");
            out.println("<label for='contraseña'>Contraseña</label>");
            out.println("<input type='password' id='contraseña' name='contraseña' required>");
            out.println("<input type='submit' value='Insertar Usuario'>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}