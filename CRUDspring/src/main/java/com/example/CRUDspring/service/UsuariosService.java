package com.example.CRUDspring.service;

import com.example.CRUDspring.entity.Usuarios;
import com.example.CRUDspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuarios> getUsuario(Long id){
        return usuarioRepository.findById(id); // Cambiado a findById
    }

    public void saveOrUpdate(Usuarios usuario){
        usuarioRepository.save(usuario);
    }

    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }
}

