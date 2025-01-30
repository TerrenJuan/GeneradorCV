package com.iessanalberto.JTT.models;

import java.util.ArrayList;

public class TitulacionesList {

    public static ArrayList<Titulacion> titulacionesList = new ArrayList<>();

    public TitulacionesList() {}

    public static ArrayList<Titulacion> getTitulacionesList() {
        return titulacionesList;
    }

    public static void setTitulacionesList(ArrayList<Titulacion> titulacionesList) {
        TitulacionesList.titulacionesList = titulacionesList;
    }

}
