package com.iessanalberto.JTT.models;

import java.util.ArrayList;

public class ExperienciasList {

    public static ArrayList<Experiencia> experienciasList = new ArrayList<>();

    public ExperienciasList() {}

    public ArrayList<Experiencia> getExperienciasList() {
        return experienciasList;
    }

    public void setExperienciasList(ArrayList<Experiencia> experienciasList) {
        ExperienciasList.experienciasList = experienciasList;
    }
}
