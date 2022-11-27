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

    // Trae informacion segun credenciales
    public List<Usuario> Login(Usuario crendentialUsuario) {
        try {
            Statement stmt = _cn.createStatement();
            String query = "exec p_user_credentials '" + crendentialUsuario.getCorreo() + "', '"
                    + crendentialUsuario.getPassword() + "'";

            List<Usuario> usuarioLogeado = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                Usuario usuario = new Usuario(result.getString("correo"), result.getString("Primer_nombre"),
                        result.getString("direccion"), result.getString("Cedula_cliente"), result.getString("apellido"),
                        result.getString("password"));

                usuarioLogeado.add(usuario);
            }

            result.close();
            stmt.close();
            return usuarioLogeado;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    // Registra un nuevo usuario
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

    // Encontrar usuario por cedula
    public List<Usuario> GetUserByID(String id) {
        try {
            Statement stmt = _cn.createStatement();
            String query = "select * from cliente where Cedula_cliente = '" + id + "'";

            List<Usuario> usuarioEncontrado = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                Usuario usuario = new Usuario(result.getString("correo"), result.getString("Primer_nombre"),
                        result.getString("direccion"), result.getString("Cedula_cliente"), result.getString("apellido"),
                        result.getString("password"));

                usuarioEncontrado.add(usuario);
            }
            result.close();
            stmt.close();
            return usuarioEncontrado;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    public List<Usuario> GetUserByName(Usuario name) {
        try {
            Statement stmt = _cn.createStatement();
            String query = "exec p_get_consultas_name '" + name.getNombre() + "'";
            List<Usuario> consultas = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                Usuario consulta = new Usuario(result.getString("nombre"), result.getString("fecha_consulta"),
                        result.getString("Nombre"), result.getString("Primer_nombre"));

                consultas.add(consulta);
            }
            result.close();
            stmt.close();
            return consultas;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    public List<Usuario> GetConsultas() {
        try {
            Statement stmt = _cn.createStatement();
            String query = "exec p_get_consultas";

            List<Usuario> consultas = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                Usuario consulta = new Usuario(result.getString("nombre"), result.getString("fecha_consulta"),
                        result.getString("Nombre"), result.getString("Primer_nombre"));

                consultas.add(consulta);
            }
            result.close();
            stmt.close();
            return consultas;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

}
