package com.liberfinx.jdbc.demo;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "editarServlet", value = "/editar-usuarios")
public class EditarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        String nombre = req.getParameter("nombre");
        String correo = req.getParameter("correo");
        String imagen = req.getParameter("imagen");
        String contraseña = req.getParameter("contraseña");

        if (idParam != null && !idParam.isEmpty() && nombre != null && correo != null && imagen != null && contraseña != null) {
            int idModificar = Integer.parseInt(idParam);

            UsuarioControlador controlador = new UsuarioControlador();
            controlador.actualizarUsuario(idModificar, nombre, correo, contraseña, imagen);

            resp.sendRedirect("editar-usuarios?status=success");
        } else {
            resp.getWriter().println("Error: Todos los campos son obligatorios.");
        }
    }

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsuarioControlador controlador = new UsuarioControlador();


        List<Usuario> usuarios = controlador.obtenerUsuarios();

        String status = request.getParameter("status");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Editar Usuario</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; background-color: #f4f4f4; }");
            out.println(".container { width: 80%; text-align: center; }");
            out.println("table { width: 100%; border-collapse: collapse; margin: 0 auto; }");
            out.println("table, th, td { border: 1px solid black; }");
            out.println("th, td { padding: 12px 15px; text-align: left; }");
            out.println("th { background-color: #007bff; color: white; }");
            out.println("td { text-align: center; }");
            out.println("tbody tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("form { display: inline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");

            if ("success".equals(status)) {
                out.println("<div class='success-message'>¡El usuario se ha actualizado correctamente!</div>");
            }

            out.println("<h2>Editar Usuario</h2>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Correo</th>");
            out.println("<th>Contraseña</th>");
            out.println("<th>Imagen de Perfil</th>");
            out.println("<th>Acción</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            for (Usuario usuario : usuarios) {
                out.println("<tr>");
                out.println("<form action='editar-usuarios' method='POST'>");
                out.println("<td><input type='hidden' name='id' value='" + usuario.getId() + "' />" + usuario.getId() + "</td>");
                out.println("<td><input type='text' name='nombre' value='" + usuario.getNombre() + "' required></td>");
                out.println("<td><input type='email' name='correo' value='" + usuario.getCorreo() + "' required></td>");
                out.println("<td><input type='password' name='contraseña' placeholder='Nueva contraseña'></td>");
                out.println("<td><input type='text' name='imagen' value='" + usuario.getImagen_perfil() + "' required></td>");
                out.println("<td><input type='submit' value='Guardar'></td>");
                out.println("</form>");
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

