package com.iessanalberto.JTT.screens;

import com.iessanalberto.JTT.GeneradorCV;
import com.iessanalberto.JTT.models.Titulacion;
import com.iessanalberto.JTT.models.TitulacionesList;

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
public class TitulacionScreen {

    // Declaración de todos los componentes de la ventana
    JFrame frameTitulacion = new JFrame();

    JPanel panelTitulacion = new JPanel();

    JLabel lblFechaFinal = new JLabel("Fecha de finalización");
    JLabel lblTitulacion = new JLabel("Tipo de titulación");
    JLabel lblDescripcion = new JLabel("Descripción");

    JTextField txtFechaFinal = new JTextField();
    JTextField txtTitulacion = new JTextField();
    JTextArea txtDescripcion = new JTextArea();

    JButton btnAdd = new JButton("Añadir");
    JButton btnCancel = new JButton("Cancelar");

    // Posiciones X e Y de los componentes
    private final int pos_X_1 = 50;
    private final int pos_X_2 = 225;
    private final int pos_X_3 = 345;
    private final int pos_X_4 = 485;

    private final int pos_Y_1 = 20;
    private final int pos_Y_2 = 70;
    private final int pos_Y_3 = 120;
    private final int pos_Y_4 = 280;

    // Fuentes de los textos
    Font fuenteTexto = new Font("Comic Sans MS", Font.BOLD, 15);
    Font fuenteTextField = new Font("Comic Sans MS", Font.PLAIN, 15);


    // Constructor de la clase
    public TitulacionScreen() {

        // Añadimos la posición y tamaño de los componentes, y los añadimos al panel
        lblFechaFinal.setBounds(pos_X_1, pos_Y_1, 200, 30);
        lblFechaFinal.setFont(fuenteTexto);
        panelTitulacion.add(lblFechaFinal);

        txtFechaFinal.setBounds(pos_X_2, pos_Y_1, 150, 30);
        txtFechaFinal.setFont(fuenteTextField);
        panelTitulacion.add(txtFechaFinal);

        lblTitulacion.setBounds(pos_X_1, pos_Y_2, 150, 30);
        lblTitulacion.setFont(fuenteTexto);
        panelTitulacion.add(lblTitulacion);

        txtTitulacion.setBounds(pos_X_2, pos_Y_2, 150, 30);
        txtTitulacion.setFont(fuenteTextField);
        panelTitulacion.add(txtTitulacion);

        lblDescripcion.setBounds(pos_X_1, pos_Y_3, 150, 30);
        lblDescripcion.setFont(fuenteTexto);
        panelTitulacion.add(lblDescripcion);

        txtDescripcion.setFont(fuenteTextField);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setMargin(new Insets(10,10,10,10));

        JScrollPane scrollPaneDescripcion = new JScrollPane(txtDescripcion);
        scrollPaneDescripcion.setBounds(pos_X_2, pos_Y_3, 350, 150);
        panelTitulacion.add(scrollPaneDescripcion);

        btnAdd.setBounds(pos_X_3, pos_Y_4, 90, 40);
        panelTitulacion.add(btnAdd);

        btnCancel.setBounds(pos_X_4, pos_Y_4, 90, 40);
        panelTitulacion.add(btnCancel);

        // Action Listener del boton cancelar, que cierra solo la ventana
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameTitulacion.dispose();
            }
        });

        // Action Listener del boton añadir, que settea los datos en la clase "Titulacion", y a su vez añade el objeto
        // que hemos instanciado, en la clase "TitulacionesList", que recoge todos los objetos de tipo "Titulacion", para
        // que podamos generar el PDF.
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Instanciamos el objeto en el que se añadirán todos los datos de la ventana
                Titulacion titulacionAux = new Titulacion();

                // Settea los datos de los campos en la clase "Titulacion"
                titulacionAux.setFechaFinal(txtFechaFinal.getText());
                titulacionAux.setTitulacion(txtTitulacion.getText());
                titulacionAux.setDescripcion(txtDescripcion.getText());

                // Añade el objeto instanciado a la clase "TitulacionesList"
                TitulacionesList.titulacionesList.add(titulacionAux);

                String borrar = "Borrar";

                // Añade una fila nueva a la tabla de la página principal
                GeneradorCV.modelTitulacion.addRow(
                        new Object[]{
                                titulacionAux.getFechaFinal(),
                                titulacionAux.getTitulacion(),
                                borrar,

                        });
                // Cierra la ventana, una vez ya hemos setteado todos los datos
                frameTitulacion.dispose();
            }
        });

        panelTitulacion.setLayout(null);
        panelTitulacion.setPreferredSize(new Dimension(650, 400));

        frameTitulacion.add(panelTitulacion);

        frameTitulacion.setPreferredSize(new Dimension(650,400));

        frameTitulacion.setTitle("Añadir Titulación");
        frameTitulacion.setResizable(false);
        frameTitulacion.setVisible(true);
        frameTitulacion.pack();

    } // TitulacionScreen()

}