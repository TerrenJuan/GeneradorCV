package com.iessanalberto.JTT.screens;

import com.iessanalberto.JTT.GeneradorCV;
import com.iessanalberto.JTT.models.Titulacion;
import com.iessanalberto.JTT.models.TitulacionesList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitulacionScreen {


    // Declaración de todos los componentes de la ventana
    JFrame frameTitulacion = new JFrame();

    JPanel panelTitulacion = new JPanel();

    JLabel lblFechaFinal = new JLabel("Fecha de finalización");
    JLabel lblTitulacion = new JLabel("Tipo de titulación");
    JLabel lblDescripcion = new JLabel("Descripcion");

    JTextField txtFechaFinal = new JTextField();
    JTextField txtTitulacion = new JTextField();
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


    public TitulacionScreen() {

        Titulacion titulacionAux = new Titulacion();

        lblFechaFinal.setBounds(pos_X_1, pos_Y_1, 150, 30);
        panelTitulacion.add(lblFechaFinal);

        txtFechaFinal.setBounds(pos_X_2, pos_Y_1, 150, 30);
        panelTitulacion.add(txtFechaFinal);

        lblTitulacion.setBounds(pos_X_1, pos_Y_2, 150, 30);
        panelTitulacion.add(lblTitulacion);

        txtTitulacion.setBounds(pos_X_2, pos_Y_2, 150, 30);
        panelTitulacion.add(txtTitulacion);

        lblDescripcion.setBounds(pos_X_1, pos_Y_3, 150, 30);
        panelTitulacion.add(lblDescripcion);

        txtDescripcion.setBounds(pos_X_2, pos_Y_3, 350, 150);
        panelTitulacion.add(txtDescripcion);

        btnAdd.setBounds(pos_X_3, pos_Y_4, 90, 40);
        panelTitulacion.add(btnAdd);

        btnCancel.setBounds(pos_X_4, pos_Y_4, 90, 40);
        panelTitulacion.add(btnCancel);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameTitulacion.dispose();
            }
        });

        //



        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                titulacionAux.setFechaFinal(txtFechaFinal.getText());
                titulacionAux.setTitulacion(txtTitulacion.getText());
                titulacionAux.setDescripcion(txtDescripcion.getText());

                TitulacionesList.titulacionesList.add(titulacionAux);
                String borrar = "Borrar";

                GeneradorCV.modelTitulacion.addRow(
                        new Object[]{
                                titulacionAux.getFechaFinal(),
                                titulacionAux.getTitulacion(),
                                borrar,

                        });
                frameTitulacion.dispose();
            }

        });




        panelTitulacion.setLayout(null);
        panelTitulacion.setPreferredSize(new Dimension(600, 400));
        frameTitulacion.add(panelTitulacion);

        frameTitulacion.setPreferredSize(new Dimension(600,400));

        frameTitulacion.setTitle("Añadir Experiencia");
        frameTitulacion.setResizable(false);
        frameTitulacion.setVisible(true);
        frameTitulacion.pack();

    }

}