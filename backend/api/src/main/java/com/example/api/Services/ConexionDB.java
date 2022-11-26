package com.example.api.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public Connection Connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=Clinica;user=admin;password=12345;trustServerCertificate=true");
        } catch (SQLException e) {
            System.out.println("Error de conexion a la DB" + e);
        } catch (ClassNotFoundException cnf) {
            System.out.println("Clase no encontrada" + cnf);
        }
        return null;
    }
}
