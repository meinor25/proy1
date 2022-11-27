package com.example.api.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Models.Usuario;
import com.example.api.Services.UsuariosDB;

@RestController
public class UsuariosController {

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping("/consultas")
    public List<Usuario> obtenerConsultas()
            throws ClassNotFoundException {
        return new UsuariosDB().GetConsultas();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping("/user/{userID}")
    public List<Usuario> obtenerUsuario(@PathVariable("userID") String userID)
            throws ClassNotFoundException {
        return new UsuariosDB().GetUserByID(userID);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @PostMapping("/consultas/nombre")
    public List<Usuario> obtenerUsuarioPorNombre(@RequestBody Usuario nombre)
            throws ClassNotFoundException {
        return new UsuariosDB().GetUserByName(nombre);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @PostMapping("/login")
    public List<Usuario> LogearUsuario(@RequestBody Usuario credentialsUsuario) throws ClassNotFoundException {
        return new UsuariosDB().Login(credentialsUsuario);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @PostMapping("/register")
    public int RegistrarUsuario(@RequestBody Usuario credentialsUsuario) throws ClassNotFoundException {
        return new UsuariosDB().Register(credentialsUsuario);
    }

}
