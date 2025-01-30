package com.iessanalberto.JTT.models;

import javax.swing.*;
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


    /*public ArrayList<Experiencia> comprobarExperiencia (JTable tablaExperiencia){
        ArrayList<Experiencia> experienciasAUX = new ArrayList<>();
        for (Experiencia experienciaAux:this.getExperienciasList()) {
            if (tablaExperiencia.get(experienciaAux.getFechaInicio())){

            }
        }


        return experienciasAUX;
    }*/
}
