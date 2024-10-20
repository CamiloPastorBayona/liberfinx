package com.liberfinx.jdbc.demo;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "borrarServlet", value = "/borrar-usuarios")
public class BorrarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsuarioControlador controlador = new UsuarioControlador();

        String idParam = request.getParameter("id");

        if (idParam != null && !idParam.isEmpty()) {
            int idEliminar = Integer.parseInt(idParam);
            controlador.eliminarUsuario(idEliminar);
            response.sendRedirect("borrar-usuarios");
            return;
        }

        List<Usuario> usuarios = controlador.obtenerUsuarios();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Borrar Usuario</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; background-color: #f4f4f4; }");
            out.println(".container { width: 80%; text-align: center; }");
            out.println("table { width: 100%; border-collapse: collapse; margin: 0 auto; }");
            out.println("table, th, td { border: 1px solid black; }");
            out.println("th, td { padding: 12px 15px; text-align: left; }");
            out.println("th { background-color: #007bff; color: white; }");
            out.println("td { text-align: center; }");
            out.println(".delete-icon { cursor: pointer; padding: 10px; background-color: #dc3545; color: white; border-radius: 5px; transition: background-color 0.3s; display: inline-block; }");
            out.println(".delete-icon:hover { background-color: #c82333; }");
            out.println("tbody tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println(".delete-link { text-decoration: none; color: white; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Borrar Usuario</h2>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Correo</th>");
            out.println("<th>Acción</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            for (Usuario usuario : usuarios) {
                out.println("<tr>");
                out.println("<td>" + usuario.getId() + "</td>");
                out.println("<td>" + usuario.getNombre() + "</td>");
                out.println("<td>" + usuario.getCorreo() + "</td>");
                out.println("<td><a class='delete-link' href='borrar-usuarios?id=" + usuario.getId() + "' onclick='return confirm(\"¿Estás seguro de que deseas borrar este usuario?\");'>");
                out.println("<div class='delete-icon'>Borrar</div>");
                out.println("</a></td>");
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
