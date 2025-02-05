package com.iessanalberto.JTT.models;

import java.util.ArrayList;
/*
 *
 * @author Juan Terrén
 * @since 5FEB2025
 *
 */
public class ExperienciasList {

    public static ArrayList<Experiencia> experienciasList = new ArrayList<>();

    // Constructor vacío de la clase
    public ExperienciasList() {}

    // Getters & Setters
    public ArrayList<Experiencia> getExperienciasList() {
        return experienciasList;
    }

    public void setExperienciasList(ArrayList<Experiencia> experienciasList) {
        ExperienciasList.experienciasList = experienciasList;
    }

}
