package com.liberfinx.jdbc;
public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;
    private String imagen_perfil;

    public Usuario()
    {

    }

    public Usuario(int id, String nombre, String correo, String password , String imagen_perfil)
    {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = password;
        this.imagen_perfil = imagen_perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getImagen_perfil() {
        return imagen_perfil;
    }

    public void setImagen_perfil(String imagen_perfil) {
        this.imagen_perfil = imagen_perfil;
    }
}

