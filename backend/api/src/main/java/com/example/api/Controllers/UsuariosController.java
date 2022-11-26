package com.example.api.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Models.Usuario;
import com.example.api.Services.UsuariosDB;

@RestController
public class UsuariosController {
    // @GetMapping("/user")
    // public List<Usuario> obtenerUsuario(@RequestBody Usuario credentialsUsuario)
    // throws ClassNotFoundException {
    // return new UsuariosDB().Login(credentialsUsuario);
    // }

    @PostMapping("/login")
    public List<Usuario> LogearUsuario(@RequestBody Usuario credentialsUsuario) throws ClassNotFoundException {
        return new UsuariosDB().Login(credentialsUsuario);
    }

    @PostMapping("/register")
    public int RegistrarUsuario(@RequestBody Usuario credentialsUsuario) throws ClassNotFoundException {
        return new UsuariosDB().Register(credentialsUsuario);
    }

}
