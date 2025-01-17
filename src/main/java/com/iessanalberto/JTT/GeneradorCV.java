package com.iessanalberto.JTT;

import javax.swing.*;
import java.awt.*;

public class GeneradorCV {


    JFrame frame = new JFrame();

    JPanel panelPrincipal = new JPanel();

    JPanel panelPrincipal1 = new JPanel();
    JPanel panelPrincipal2 = new JPanel();
    JPanel panelPrincipal3 = new JPanel();
    JPanel panelPrincipal4 = new JPanel();

    JPanel panelSecundario1 = new JPanel();
    JPanel panelSecundario2 = new JPanel();
    JPanel panelSecundario3 = new JPanel();
    JPanel panelSecundario4 = new JPanel();

    JLabel lblTitulo = new JLabel("Introduce los campos y luego dale al boton para generar tu curriculum vitae.");

    GridLayout estructura = new GridLayout(2,2);


    // Panel Principal 1

    JLabel lblSobreTi = new JLabel("Sobre ti:");
    JLabel lblNombre = new JLabel("Nombre:");
    JLabel lblApellidos = new JLabel("Apellidos:");
    JLabel lblFechaNac = new JLabel("Fecha Nacimiento:");
    JLabel lblFotoPerfil = new JLabel("Foto Perfil:");

    JTextField txtNombre = new JTextField();
    JTextField txtApellidos = new JTextField();
    JTextField txtFechaNac = new JTextField();
    JButton btnAdjFoto = new JButton("Adjuntar Foto");

    final int p1_posX1 = 10;
    final int p1_posX2 = 200;

    final int p1_posY1 = 10;
    final int p1_posY2 = 60;
    final int p1_posY3 = 110;
    final int p1_posY4 = 160;
    final int p1_posY5 = 210;

    final int p1_width = 150;
    final int p1_height = 50;

    // Panel Principal 2

    JTable tblExperiencia = new JTable(2,3);
    JScrollPane scrollExperiencia = new JScrollPane(tblExperiencia);

    // Panel Principal 3

    JLabel lblPresentacion = new JLabel("Presentación / Motivación");
    JTextArea txtPresentacion = new JTextArea();

    final int p2_posX1 = 10;
    final int p2_posY1 = 10;
    final int p2_posY2 = 60;

    final int p2_width = 150;
    final int p2_height = 50;

    final int p2_Area_width = 500;
    final int p2_Area_height = 200;
    GeneradorCV(){


        frame.setPreferredSize(new Dimension(1200,800));

        frame.setLayout(null);
        lblTitulo.setBounds(50,10,1200,50);
        panelPrincipal.setBounds(20,60,1140,680);
        panelPrincipal.setBackground(Color.GRAY);

        // Panel Principal 1

        lblSobreTi.setBounds(p1_posX1, p1_posY1, p1_width, p1_height);
        lblNombre.setBounds(p1_posX1, p1_posY2, p1_width, p1_height);
        lblApellidos.setBounds(p1_posX1, p1_posY3, p1_width, p1_height);
        lblFechaNac.setBounds(p1_posX1, p1_posY4, p1_width, p1_height);
        lblFotoPerfil.setBounds(p1_posX1, p1_posY5, p1_width, p1_height);
        txtNombre.setBounds(p1_posX2, p1_posY2, p1_width, p1_height);
        txtApellidos.setBounds(p1_posX2, p1_posY3, p1_width, p1_height);
        txtFechaNac.setBounds(p1_posX2, p1_posY4, p1_width, p1_height);
        btnAdjFoto.setBounds(p1_posX2, p1_posY5, p1_width, p1_height);


        panelSecundario1.add(lblSobreTi);
        panelSecundario1.add(lblNombre);
        panelSecundario1.add(lblApellidos);
        panelSecundario1.add(lblFechaNac);
        panelSecundario1.add(lblFotoPerfil);
        panelSecundario1.add(txtNombre);
        panelSecundario1.add(txtApellidos);
        panelSecundario1.add(txtFechaNac);
        panelSecundario1.add(btnAdjFoto);


        // Panel Principal 2


        tblExperiencia.setBounds(p2_posX1, p2_posY1, p2_width, p2_height);
        tblExperiencia.setValueAt("Fecha inicio",0,0);
        tblExperiencia.setValueAt("Tipo Trabajo",0,1);
        tblExperiencia.setValueAt("Acciones",0,2);

        panelSecundario2.add(scrollExperiencia);



        // Panel Principal 3

        panelSecundario3.add(lblPresentacion);
        panelSecundario3.add(txtPresentacion);

        lblPresentacion.setBounds(p2_posX1, p2_posY1, p2_width, p2_height);
        txtPresentacion.setBounds(p2_posX1, p2_posY2, p2_Area_width, p2_Area_height);

        txtPresentacion.setLineWrap(true);
        txtPresentacion.setWrapStyleWord(true);
        txtPresentacion.setMargin(new Insets(10,10,10,10));



        frame.add(panelPrincipal);
        frame.add(lblTitulo);

        panelPrincipal.setLayout(estructura);
        panelPrincipal.add(panelPrincipal1);
        panelPrincipal.add(panelPrincipal2);
        panelPrincipal.add(panelPrincipal3);
        panelPrincipal.add(panelPrincipal4);

        panelPrincipal1.setBackground(Color.BLUE);
        panelPrincipal2.setBackground(Color.RED);
        panelPrincipal3.setBackground(Color.GREEN);
        panelPrincipal4.setBackground(Color.CYAN);

        panelPrincipal1.setLayout(null);
        panelSecundario1.setBounds(20,20,530,300);
        panelSecundario1.setLayout(null);
        panelPrincipal1.add(panelSecundario1);

        panelPrincipal2.setLayout(null);
        panelSecundario2.setBounds(20,20,530,300);
        //panelSecundario2.setLayout(null);
        panelPrincipal2.add(panelSecundario2);

        panelPrincipal3.setLayout(null);
        panelSecundario3.setBounds(20,20,530,300);
        panelSecundario3.setLayout(null);
        panelPrincipal3.add(panelSecundario3);

        panelPrincipal4.setLayout(null);
        panelSecundario4.setBounds(20,20,530,300);
        panelPrincipal4.add(panelSecundario4);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CV Generator");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();



    }
    public static void main(String[] args) {


        GeneradorCV aplicacion = new GeneradorCV();



    }
}