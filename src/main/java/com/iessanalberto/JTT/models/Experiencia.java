package com.iessanalberto.JTT.models;
/*
 *
 * @author Juan Terrén
 * @since 5FEB2025
 *
 */
public class Experiencia {

    private String fechaInicio;
    private String tipoTrabajo;
    private String descripcion;
    private int id;

    // Constructor vacío de la clase
    public Experiencia() {
    }

    // Getters & Setters
    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
