package com.iessanalberto.JTT.screens;

import com.iessanalberto.JTT.GeneradorCV;
import com.iessanalberto.JTT.models.Experiencia;
import com.iessanalberto.JTT.models.ExperienciasList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExperienciaScreen {


    // Declaración de todos los componentes de la ventana
    JFrame frameExperiencia = new JFrame();

    JPanel panelExperiencia = new JPanel();

    JLabel lblFechaInicio = new JLabel("Fecha de inicio");
    JLabel lblTrabajo = new JLabel("Tipo de trabajo");
    JLabel lblDescripcion = new JLabel("Descripcion");

    JTextField  txtFechaInicio = new JTextField();
    JTextField  txtTrabajo = new JTextField();
    JTextArea txtDescripcion = new JTextArea();


    JButton btnAdd = new JButton("Añadir");
    JButton btnCancel = new JButton("Cancelar");

    // Posiciones X e Y de los componentes
    private final int pos_X_1 = 50;
    private final int pos_X_2 = 170;
    private final int pos_X_3 = 310;
    private final int pos_X_4 = 430;

    private final int pos_Y_1 = 20;
    private final int pos_Y_2 = 70;
    private final int pos_Y_3 = 120;
    private final int pos_Y_4 = 280;

    public int contador = 0;

    public ExperienciaScreen() {
        ExperienciasList experienciasList = new ExperienciasList();
        Experiencia experienciaAux = new Experiencia();

        lblFechaInicio.setBounds(pos_X_1, pos_Y_1, 150, 30);
        panelExperiencia.add(lblFechaInicio);

        txtFechaInicio.setBounds(pos_X_2, pos_Y_1, 150, 30);
        panelExperiencia.add(txtFechaInicio);

        lblTrabajo.setBounds(pos_X_1, pos_Y_2, 150, 30);
        panelExperiencia.add(lblTrabajo);

        txtTrabajo.setBounds(pos_X_2, pos_Y_2, 150, 30);
        panelExperiencia.add(txtTrabajo);

        lblDescripcion.setBounds(pos_X_1, pos_Y_3, 150, 30);
        panelExperiencia.add(lblDescripcion);

        txtDescripcion.setBounds(pos_X_2, pos_Y_3, 350, 150);
        panelExperiencia.add(txtDescripcion);

        btnAdd.setBounds(pos_X_3, pos_Y_4, 90, 40);
        panelExperiencia.add(btnAdd);

        btnCancel.setBounds(pos_X_4, pos_Y_4, 90, 40);
        panelExperiencia.add(btnCancel);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameExperiencia.dispose();
            }
        });

        //



        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                experienciaAux.setId(contador);
                experienciaAux.setFechaInicio(txtFechaInicio.getText());
                experienciaAux.setTipoTrabajo(txtTrabajo.getText());
                experienciaAux.setDescripcion(txtDescripcion.getText());

                ExperienciasList.experienciasList.add(experienciaAux);
                String borrar = "Borrar";

                GeneradorCV.model.addRow(
                        new Object[]{
                                experienciaAux.getFechaInicio(),
                                experienciaAux.getTipoTrabajo(),
                                borrar,
                                experienciaAux.getId()

                        });
                frameExperiencia.dispose();
                contador++;
            }

        });




        panelExperiencia.setLayout(null);
        panelExperiencia.setPreferredSize(new Dimension(600, 400));
        frameExperiencia.add(panelExperiencia);

        frameExperiencia.setPreferredSize(new Dimension(600,400));

        frameExperiencia.setTitle("Añadir Experiencia");
        frameExperiencia.setResizable(false);
        frameExperiencia.setVisible(true);
        frameExperiencia.pack();

    }

}
