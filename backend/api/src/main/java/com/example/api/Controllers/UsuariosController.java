package com.example.api.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Models.Usuario;
import com.example.api.Services.UsuariosDB;

@RestController
public class UsuariosController {

    // Trae todas las consultas
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping("/consultas")
    public List<Usuario> obtenerConsultas()
            throws ClassNotFoundException {
        return new UsuariosDB().GetConsultas();
    }

    // Trae un usuario por su cedula
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping("/user/{userID}")
    public List<Usuario> obtenerUsuario(@PathVariable("userID") String userID)
            throws ClassNotFoundException {
        return new UsuariosDB().GetUserByID(userID);
    }

    // Trae las consultas por nombre
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @PostMapping("/consultas/nombre")
    public List<Usuario> obtenerUsuarioPorNombre(@RequestBody Usuario nombre)
            throws ClassNotFoundException {
        return new UsuariosDB().GetUserByName(nombre);
    }

    // Maneja el login
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @PostMapping("/login")
    public List<Usuario> LogearUsuario(@RequestBody Usuario credentialsUsuario) throws ClassNotFoundException {
        return new UsuariosDB().Login(credentialsUsuario);
    }

    // Registra un usuario
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @PostMapping("/register")
    public int RegistrarUsuario(@RequestBody Usuario credentialsUsuario) throws ClassNotFoundException {
        return new UsuariosDB().Register(credentialsUsuario);
    }

    // Modifica un usuario
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @PutMapping("/user")
    public int obtenerUsuario(@RequestBody Usuario datosModificados)
            throws ClassNotFoundException {
        return new UsuariosDB().ModifyUser(datosModificados);
    }
}
