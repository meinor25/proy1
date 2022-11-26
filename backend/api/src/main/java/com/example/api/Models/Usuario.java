package com.example.api.Models;

public class Usuario {
    private String correo;
    private String password;

    public Usuario(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public Usuario() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
