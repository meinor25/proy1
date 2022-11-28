package com.example.api.Models;

public class Usuario {
    private String correo;
    private String nombre;
    private String direccion;
    private String cedula;
    private String apellido;
    private String password;
    private String nombre_mascota;
    private String fecha_consulta;
    private String motivo_consulta;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    // public Usuario(String nombre, String apellido, String correo, String
    // direccion) {
    // this.nombre = nombre;
    // this.apellido = apellido;
    // this.correo = correo;
    // this.direccion = direccion;
    // }

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

    public Usuario(String nombre_mascota, String fecha_consulta, String motivo_consulta, String nombre) {
        this.nombre = nombre;
        this.nombre_mascota = nombre_mascota;
        this.fecha_consulta = fecha_consulta;
        this.motivo_consulta = motivo_consulta;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getFecha_consulta() {
        return fecha_consulta;
    }

    public void setFecha_consulta(String fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
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
