package com.example.api.Models;

public class Usuario {
    private String correo;
    private String nombre;
    private String direccion;
    private String cedula;
    private String apellido;
    private String password;

    public Usuario(String correo, String nombre, String direccion, String cedula, String apellido, String password) {
        this.correo = correo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.apellido = apellido;
        this.password = password;
    }

    public Usuario(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public Usuario() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
