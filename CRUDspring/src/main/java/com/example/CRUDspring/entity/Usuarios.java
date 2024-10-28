package com.example.CRUDspring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_usuario")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long usuarioID;

    private String nombre;

    @Column(name = "direccion_email", unique = true, nullable = false)
    private String correo_electronico;

    private String contraseña;

    private String imagen_perfil;
}

