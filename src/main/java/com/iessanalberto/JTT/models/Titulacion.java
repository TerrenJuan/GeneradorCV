package com.iessanalberto.JTT.models;
/*
 *
 * @author Juan Terrén
 * @since 5FEB2025
 *
 */
public class Titulacion {

    private String fechaFinal;
    private String titulacion;
    private String descripcion;

    // Constructor vacío de la clase
    public Titulacion(){
    }

    // Getters & Setters
    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

