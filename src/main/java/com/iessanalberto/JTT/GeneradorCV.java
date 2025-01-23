package com.iessanalberto.JTT;

import com.iessanalberto.JTT.models.Experiencia;
import com.iessanalberto.JTT.models.ExperienciasList;
import com.iessanalberto.JTT.screens.ExperienciaScreen;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;

public class GeneradorCV {
    ExperienciasList experienciasList = new ExperienciasList();

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


    // Definir los nombres de las columnas (cabecera de la tabla)
    public static String[] columnNames = {"Fecha inicio", "Tipo Trabajo", "Acciones"};

    // Crear el modelo de la tabla con los datos y la cabecera
    public static DefaultTableModel model = new DefaultTableModel(null, columnNames);

    public static JTable tblExperiencia = new JTable(model);
    JScrollPane scrollExperiencia = new JScrollPane(tblExperiencia);

    JButton btnExperiencia = new JButton("Añadir Experiencia");



    // Panel Principal 3

    JLabel lblPresentacion = new JLabel("Presentación / Motivación");
    JTextArea txtPresentacion = new JTextArea();

    final int p2_posX1 = 10;
    final int p2_posY1 = 10;
    final int p2_posY2 = 250;

    final int p2_posX2 = 300;


    final int p2_width = 500;
    final int p2_height = 220;

    final int p2_width2 = 150;
    final int p2_height2 = 30;

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


        JScrollPane scrollPane = new JScrollPane(txtPresentacion);
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


        btnExperiencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new ExperienciaScreen();
            }
        });

        tblExperiencia.setEnabled(false);

        scrollExperiencia.setBounds(p2_posX1, p2_posY1, p2_width, p2_height);
        btnExperiencia.setBounds(p2_posX2, p2_posY2, p2_width2, p2_height2);
        panelSecundario2.setLayout(null);
        panelSecundario2.add(scrollExperiencia);
        panelSecundario2.add(btnExperiencia);


        tblExperiencia.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                // Obtener la fila y columna donde se hizo el clic
                int filaSeleccionada = tblExperiencia.rowAtPoint(e.getPoint());
                int columnaSeleccionada = tblExperiencia.columnAtPoint(e.getPoint());

                // Comprueba que el click sea en la columna de acciones, en nuestro caso borrar
                if (filaSeleccionada >= 0 && columnaSeleccionada == 2) {

                    int confirm = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro de que deseas eliminar esta fila?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    // Si el usuario selecciona "Sí" (JOptionPane.YES_OPTION)
                    if (confirm == JOptionPane.YES_OPTION) {
                        // Eliminar la fila
                        model.removeRow(filaSeleccionada);
                        JOptionPane.showMessageDialog(null, "Fila eliminada.");

                    } else {
                        // Si el usuario selecciona "No" o "Cancelar", no hacer nada
                        // JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
                    }

                }

            }
        });


        // Panel Principal 3

        panelSecundario3.add(lblPresentacion);
        panelSecundario3.add(scrollPane);

        lblPresentacion.setBounds(p2_posX1, p2_posY1, p2_width, p2_height);
        scrollPane.setBounds(20, 20, p2_Area_width, p2_Area_height);

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