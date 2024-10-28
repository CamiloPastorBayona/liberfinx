package com.example.CRUDspring.controller;

import com.example.CRUDspring.entity.Usuarios;
import com.example.CRUDspring.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> getAll() {
        return usuariosService.getUsuarios();
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Usuarios usuario) {
        usuariosService.saveOrUpdate(usuario);
    }

    @DeleteMapping("/{usuarioID}")
    public void deleteById(@PathVariable("usuarioID") Long usuarioID) {
        usuariosService.delete(usuarioID);
    }

    @GetMapping("/{usuarioID}")
    public Optional<Usuarios> getById(@PathVariable("usuarioID") Long usuarioID) {
        return usuariosService.getUsuario(usuarioID);
    }

}
