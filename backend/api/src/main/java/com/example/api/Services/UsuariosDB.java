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

    public List<Usuario> Login(Usuario crendentialUsuario) {
        try {
            Statement stmt = _cn.createStatement();
            String query = "exec p_user_credentials '" + crendentialUsuario.getCorreo() + "', '"
                    + crendentialUsuario.getPassword() + "'";

            List<Usuario> usuarioLogeado = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                while (result.next()) {
                    Usuario usuario = new Usuario(result.getString("correo"), result.getString("password"));

                    usuarioLogeado.add(usuario);
                }

            }
            result.close();
            stmt.close();
            return usuarioLogeado;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    public int Register(Usuario crendentialUsuario) {
        int result = 0;
        try {
            Statement stmt = _cn.createStatement();
            String query = "exec p_user_register '"
                    + crendentialUsuario.getCedula() + "', '"
                    + crendentialUsuario.getPassword() + "', '"
                    + crendentialUsuario.getCorreo() + "', '"
                    + crendentialUsuario.getNombre() + "', '"
                    + crendentialUsuario.getDireccion() + "', '"
                    + crendentialUsuario.getApellido() + "'";
            result = stmt.executeUpdate(query);
            return result;

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return result;
    }
}
