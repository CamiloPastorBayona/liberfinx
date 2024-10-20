package com.liberfinx.jdbc.demo;
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

    public List<Usuario> MostrarTodo()
    {
        List<Usuario> usuarios = usuarioCRUD.obtenerUsuarios();
        return usuarios;


    }
}
