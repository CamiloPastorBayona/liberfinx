package com.liberfinx.jdbc.demo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioCRUD {
    private Connection conexion;

    public UsuarioCRUD() {
        conexion = Conexiondb.GetConexion();
    }

    public boolean crearUsuario(Usuario usuario) {
        String consulta = "INSERT INTO usuarios (nombre, correo, contraseña, imagen_perfil) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContraseña());
            stmt.setString(4, usuario.getImagen_perfil());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarUsuario(Usuario usuario) {
        String consulta = "UPDATE usuarios SET nombre = ?, correo = ?, contraseña = ?, imagen_perfil = ? WHERE id_usuario = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContraseña());
            stmt.setString(4, usuario.getImagen_perfil());
            stmt.setInt(5, usuario.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try(
            PreparedStatement consulta = conexion.prepareStatement("select id_usuario, nombre, correo, contraseña, imagen_perfil from usuarios");
            ResultSet resultado = consulta.executeQuery())
        {
            while(resultado.next())
            {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id_usuario"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setCorreo(resultado.getString("correo"));
                usuario.setContraseña(resultado.getString("contraseña"));
                usuario.setImagen_perfil(resultado.getString("imagen_perfil"));
                usuarios.add(usuario);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return usuarios;
    }

    public boolean eliminarUsuario(int id) {
        String consulta = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
