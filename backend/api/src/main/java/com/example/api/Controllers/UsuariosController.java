package com.example.api.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Models.Usuario;
import com.example.api.Services.UsuariosDB;

@RestController
public class UsuariosController {
    @GetMapping("/usuario")
    public List<Usuario> ObtenerUsuario() throws ClassNotFoundException {
        return new UsuariosDB().ObtenerUsuario();
    }
}
