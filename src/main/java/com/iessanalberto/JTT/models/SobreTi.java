package com.iessanalberto.JTT.models;
/*
 *
 * @author Juan Terrén
 * @since 5FEB2025
 *
 */
public class SobreTi {

    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String imagen;
    private String presentacion;

    // Constructor vacío de la clase
    public SobreTi() {
    }

    // Getters & Setters
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
}
