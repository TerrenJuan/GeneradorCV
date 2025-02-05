package com.iessanalberto.JTT.models;

import java.util.ArrayList;
/*
 *
 * @author Juan Terrén
 * @since 5FEB2025
 *
 */
public class TitulacionesList {

    public static ArrayList<Titulacion> titulacionesList = new ArrayList<>();

    // Constructor vacío de la clase
    public TitulacionesList() {}

    // Getters & Setters
    public static ArrayList<Titulacion> getTitulacionesList() {
        return titulacionesList;
    }

    public static void setTitulacionesList(ArrayList<Titulacion> titulacionesList) {
        TitulacionesList.titulacionesList = titulacionesList;
    }

}
