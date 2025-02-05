package com.iessanalberto.JTT.screens;

import com.iessanalberto.JTT.GeneradorCV;
import com.iessanalberto.JTT.models.Experiencia;
import com.iessanalberto.JTT.models.ExperienciasList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 *
 * @author Juan Terrén
 * @since 5FEB2025
 *
 */
public class ExperienciaScreen {

    // Declaración de todos los componentes de la ventana
    JFrame frameExperiencia = new JFrame();

    JPanel panelExperiencia = new JPanel();

    JLabel lblFechaInicio = new JLabel("Fecha de inicio");
    JLabel lblTrabajo = new JLabel("Tipo de trabajo");
    JLabel lblDescripcion = new JLabel("Descripción");

    JTextField  txtFechaInicio = new JTextField();
    JTextField  txtTrabajo = new JTextField();
    JTextArea txtDescripcion = new JTextArea();

    JButton btnAdd = new JButton("Añadir");
    JButton btnCancel = new JButton("Cancelar");

    // Posiciones X e Y de los componentes
    private final int pos_X_1 = 50;
    private final int pos_X_2 = 180;
    private final int pos_X_3 = 315;
    private final int pos_X_4 = 440;

    private final int pos_Y_1 = 20;
    private final int pos_Y_2 = 70;
    private final int pos_Y_3 = 120;
    private final int pos_Y_4 = 280;

    // Fuentes de los textos
    Font fuenteTexto = new Font("Comic Sans MS", Font.BOLD, 15);
    Font fuenteTextField = new Font("Comic Sans MS", Font.PLAIN, 15);

    // Constructor de la clase
    public ExperienciaScreen() {

        lblFechaInicio.setBounds(pos_X_1, pos_Y_1, 150, 30);
        lblFechaInicio.setFont(fuenteTexto);
        panelExperiencia.add(lblFechaInicio);

        txtFechaInicio.setBounds(pos_X_2, pos_Y_1, 150, 30);
        txtFechaInicio.setFont(fuenteTextField);
        panelExperiencia.add(txtFechaInicio);

        lblTrabajo.setBounds(pos_X_1, pos_Y_2, 150, 30);
        lblTrabajo.setFont(fuenteTexto);
        panelExperiencia.add(lblTrabajo);

        txtTrabajo.setBounds(pos_X_2, pos_Y_2, 150, 30);
        txtTrabajo.setFont(fuenteTextField);
        panelExperiencia.add(txtTrabajo);

        lblDescripcion.setBounds(pos_X_1, pos_Y_3, 150, 30);
        lblDescripcion.setFont(fuenteTexto);
        panelExperiencia.add(lblDescripcion);

        txtDescripcion.setFont(fuenteTextField);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setMargin(new Insets(10,10,10,10));

        JScrollPane scrollPaneDescripcion = new JScrollPane(txtDescripcion);
        scrollPaneDescripcion.setBounds(pos_X_2, pos_Y_3, 350, 150);
        panelExperiencia.add(scrollPaneDescripcion);

        btnAdd.setBounds(pos_X_3, pos_Y_4, 90, 40);
        panelExperiencia.add(btnAdd);

        btnCancel.setBounds(pos_X_4, pos_Y_4, 90, 40);
        panelExperiencia.add(btnCancel);

        // Listener del botón cancelar, que cierra la ventana
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameExperiencia.dispose();
            }
        });

        // Action Listener del boton añadir, que settea los datos en la clase "Experiencia", y a su vez añade el objeto
        // que hemos instanciado, en la clase "ExperienciasList", que recoge todos los objetos de tipo "Experiencia", para
        // que podamos generar el PDF.
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Instanciamos el objeto en el que setteamos los datos que recogemos de la ventana.
                Experiencia experienciaAux = new Experiencia();

                experienciaAux.setFechaInicio(txtFechaInicio.getText());
                experienciaAux.setTipoTrabajo(txtTrabajo.getText());
                experienciaAux.setDescripcion(txtDescripcion.getText());

                // Añadimos el objeto instanciado a la lista que los almacena "ExperienciasList"
                ExperienciasList.experienciasList.add(experienciaAux);
                String borrar = "Borrar";

                // Añade una fila nueva a la tabla de la página principal
                GeneradorCV.modelExperiencia.addRow(
                        new Object[]{
                                experienciaAux.getFechaInicio(),
                                experienciaAux.getTipoTrabajo(),
                                borrar,

                        });

                // Cierra la ventana, una vez ya hemos setteado todos los datos
                frameExperiencia.dispose();

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

    }// ExperienciaScreen()

}
