package com.example.api.Services;

import com.example.api.Models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class UsuariosDB {
    Connection _cn;

    public UsuariosDB() throws ClassNotFoundException {
        _cn = new ConexionDB().Connect();
    }

    public List<Usuario> ObtenerUsuario() {
        try {
            Statement stmt = _cn.createStatement();
            String query = "Select * from Cliente";

            List<Usuario> usuarios = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Usuario usuario = new Usuario(result.getString("correo"), result.getString("password"));

                usuarios.add(usuario);
            }
            result.close();
            stmt.close();
            return usuarios;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }
}
