package com.liberfinx.jdbc;
import java.util.List;

public class UsuarioControlador {
    private UsuarioCRUD usuarioCRUD;

    public UsuarioControlador() {
        usuarioCRUD = new UsuarioCRUD();
    }

    public List<Usuario> obtenerUsuarios()
    {
        return usuarioCRUD.obtenerUsuarios();
    }

    public boolean crearUsuario(String nombre, String correo, String contraseña, String imagen_perfil) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContraseña(contraseña);
        usuario.setImagen_perfil(imagen_perfil);
        return usuarioCRUD.crearUsuario(usuario);
    }

    public boolean actualizarUsuario(int id, String nombre, String correo, String contraseña, String imagen_perfil) {
        Usuario usuario = new Usuario(id, nombre, correo, contraseña, imagen_perfil);
        return usuarioCRUD.actualizarUsuario(usuario);
    }

    public boolean eliminarUsuario(int id) {
        return usuarioCRUD.eliminarUsuario(id);
    }

    public void MostrarTodo()
    {
        List<Usuario> usuarios = usuarioCRUD.obtenerUsuarios();
        String formatoEncabezado = "%-5s %-20s %-30s %-20s %-20s%n";
        System.out.printf(formatoEncabezado, "Id", "Nombre", "Correo", "Contraseña", "Imagen");
        System.out.println("-----------------------------------------------------------------------" +
                "-------------------------------------------------");
        String formatoFila = "%-5d %-20s %-30s %-20s %-20s%n";
        usuarios.forEach(usuario -> System.out.printf(
                formatoFila,
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getContraseña(),
                usuario.getImagen_perfil()
        ));
        System.out.println("\n");
    }
}
