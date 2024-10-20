package com.liberfinx.jdbc.demo;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "mostrarServlet", value = "/mostrar-usuarios")
public class MostrarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsuarioControlador controlador = new UsuarioControlador();

        List<Usuario> usuarios = controlador.obtenerUsuarios();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Lista de Usuarios</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; background-color: #f4f4f4; }");
            out.println(".container { width: 80%; text-align: center; }");
            out.println("h2 { margin-bottom: 20px; }");
            out.println("table { width: 100%; border-collapse: collapse; margin: 0 auto; }");
            out.println("table, th, td { border: 1px solid black; }");
            out.println("th, td { padding: 12px 15px; text-align: left; }");
            out.println("th { background-color: #007bff; color: white; }");
            out.println("tbody tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Lista de Usuarios</h2>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Correo</th>");
            out.println("<th>Contraseña</th>");
            out.println("<th>Imagen de Perfil</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            for (Usuario usuario : usuarios) {
                out.println("<tr>");
                out.println("<td>" + usuario.getId() + "</td>");
                out.println("<td>" + usuario.getNombre() + "</td>");
                out.println("<td>" + usuario.getCorreo() + "</td>");
                out.println("<td>" + usuario.getContraseña() + "</td>");
                out.println("<td><img src='" + usuario.getImagen_perfil() + "' alt='Imagen de Perfil' width='50' height='50'></td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}