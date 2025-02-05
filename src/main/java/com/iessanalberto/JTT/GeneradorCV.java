package com.iessanalberto.JTT;

import com.iessanalberto.JTT.logic.Logic;
import com.iessanalberto.JTT.models.Curriculum;
import com.iessanalberto.JTT.models.ExperienciasList;
import com.iessanalberto.JTT.models.SobreTi;
import com.iessanalberto.JTT.models.TitulacionesList;
import com.iessanalberto.JTT.screens.ExperienciaScreen;
import com.iessanalberto.JTT.screens.TitulacionScreen;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
/*
*
* @author Juan Terrén
* @since 5FEB2025
*
*/
public class GeneradorCV {

    // Instanciamos las clases que conservan y manipulan los datos introducidos por el usuario

    ExperienciasList experienciasList = new ExperienciasList();
    TitulacionesList titulacionesList = new TitulacionesList();
    SobreTi sobreTi = new SobreTi();
    Logic logic = new Logic();

    // Declaramos todos los contenedores donde vamos a poner los componentes del Layout
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
    JButton btnGenerarCV = new JButton("Generar CV");

    GridLayout estructura = new GridLayout(2,2);

    //////////////////////////////////////////////////////////////////////////////
    // Panel Principal 1

    JLabel lblSobreTi = new JLabel("Sobre ti:");
    JLabel lblNombre = new JLabel("Nombre");
    JLabel lblApellidos = new JLabel("Apellidos");
    JLabel lblFechaNac = new JLabel("Fecha Nacimiento");
    JLabel lblFotoPerfil = new JLabel("Foto Perfil");

    JTextField txtNombre = new JTextField();
    JTextField txtApellidos = new JTextField();
    JTextField txtFechaNac = new JTextField();
    JButton btnAdjFoto = new JButton("Adjuntar Foto");

    final int p1_posX1 = 25;
    final int p1_posX2 = 230;

    final int p1_posY1 = 10;
    final int p1_posY2 = 60;
    final int p1_posY3 = 110;
    final int p1_posY4 = 160;
    final int p1_posY5 = 210;

    final int p1_width = 150;
    final int p1_height = 30;

    final int p1_2_width = 200;
    final int p1_2_height = 30;

    final int p1_3_width = 150;

    //////////////////////////////////////////////////////////////////////////////
    // Panel Principal 2

    JLabel lblExperiencia = new JLabel("Experiencia");
    // Definir los nombres de las columnas (cabecera de la tabla)
    public static String[] columnNames = {"Fecha inicio", "Tipo Trabajo", "Acciones"};

    // Crear el modelo de la tabla con los datos y la cabecera
    public static DefaultTableModel modelExperiencia = new DefaultTableModel(null, columnNames);

    public static JTable tblExperiencia = new JTable(modelExperiencia);
    JScrollPane scrollExperiencia = new JScrollPane(tblExperiencia);

    JButton btnExperiencia = new JButton("Añadir Experiencia");

    final int p2_posX1 = 20;
    final int p2_posY1 = 10;
    final int p2_posY2 = 50;
    final int p2_posY3 = 230;
    final int p2_posX2 = 300;

    final int p2_width = 500;
    final int p2_height = 175;

    final int p2_width2 = 150;
    final int p2_height2 = 40;

    //////////////////////////////////////////////////////////////////////////////
    // Panel Principal 3

    JLabel lblPresentacion = new JLabel("Presentación / Motivación");
    JTextArea txtPresentacion = new JTextArea();

    final int p3_posX1 = 20;
    final int p3_posY1 = 10;
    final int p3_posY2 = 45;

    final int p3_width = 300;
    final int p3_height = 20;

    final int p3_Area_width = 490;
    final int p3_Area_height = 210;

    //////////////////////////////////////////////////////////////////////////////
    // Panel principal 4

    JLabel lblTitulacion = new JLabel("Estudios / Idiomas / Skills");

    // Definir los nombres de las columnas (cabecera de la tabla)
    public static String[] columnNamesTitulacion = {"Fecha", "Tipo", "Acciones"};

    // Crear el modelo de la tabla con los datos y la cabecera
    public static DefaultTableModel modelTitulacion = new DefaultTableModel(null, columnNamesTitulacion);

    public static JTable tblTitulacion = new JTable(modelTitulacion);
    JScrollPane scrollTitulacion = new JScrollPane(tblTitulacion);

    JButton btnTitulacion = new JButton("Añadir Titulación");

    final int p4_posX1 = 20;
    final int p4_posY1 = 10;
    final int p4_posY2 = 45;
    final int p4_posY3 = 230;
    final int p4_posX2 = 300;

    final int p4_width = 490;
    final int p4_height = 180;

    final int p4_width2 = 150;
    final int p4_height2 = 40;

    // Bordes para los paneles

    Border borderPanels =  new LineBorder(Color.BLACK,1);

    // Fuentes de los textos de la interfaz

    Font fuentePresentacion = new Font("Comic Sans Ms", Font.BOLD,17);
    Font fuenteTitulo = new Font("Comic Sans MS", Font.BOLD, 20);
    Font fuenteCabeceraTablas = new Font("Comic Sans MS", Font.CENTER_BASELINE, 15);
    Font fuenteDatosTablas = new Font("Comic Sans MS", Font.PLAIN, 15);
    Font fuenteBotones = new Font("Comic Sans MS", Font.BOLD, 20);
    Font fuenteTexto = new Font("Comic Sans MS", Font.BOLD, 15);
    Font fuenteTextField = new Font("Comic Sans MS", Font.PLAIN, 15);


    /////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////////////////

    // Constructor de la clase principal
    GeneradorCV(){

        frame.setPreferredSize(new Dimension(1200,800));
        frame.setLayout(null);

        lblTitulo.setBounds(40,10,1200,50);
        lblTitulo.setFont(fuentePresentacion);

        panelPrincipal.setBounds(20,60,1140,650);
        panelPrincipal.setBackground(Color.GRAY);


        ///////////////////////////////////////////////////////////////////////
        // Panel Principal 1

        lblSobreTi.setFont(fuenteTitulo);
        lblSobreTi.setBounds(p1_posX1, p1_posY1, p1_width, p1_height);

        lblNombre.setFont(fuenteTexto);
        lblNombre.setBounds(p1_posX1, p1_posY2, p1_width, p1_height);

        lblApellidos.setFont(fuenteTexto);
        lblApellidos.setBounds(p1_posX1, p1_posY3, p1_width, p1_height);

        lblFechaNac.setFont(fuenteTexto);
        lblFechaNac.setBounds(p1_posX1, p1_posY4, p1_width, p1_height);

        lblFotoPerfil.setFont(fuenteTexto);
        lblFotoPerfil.setBounds(p1_posX1, p1_posY5, p1_width, p1_height);

        txtNombre.setFont(fuenteTextField);
        txtNombre.setBounds(p1_posX2, p1_posY2, p1_2_width, p1_2_height);

        txtApellidos.setFont(fuenteTextField);
        txtApellidos.setBounds(p1_posX2, p1_posY3, p1_2_width, p1_2_height);

        txtFechaNac.setFont(fuenteTextField);
        txtFechaNac.setBounds(p1_posX2, p1_posY4, p1_2_width, p1_2_height);

        btnAdjFoto.setBounds(p1_posX2, p1_posY5, p1_3_width, p1_2_height);

        panelSecundario1.add(lblSobreTi);
        panelSecundario1.add(lblNombre);
        panelSecundario1.add(lblApellidos);
        panelSecundario1.add(lblFechaNac);
        panelSecundario1.add(lblFotoPerfil);
        panelSecundario1.add(txtNombre);
        panelSecundario1.add(txtApellidos);
        panelSecundario1.add(txtFechaNac);
        panelSecundario1.add(btnAdjFoto);

        // Action Listener del botón "adjuntar foto"
        btnAdjFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.seleccionarImagen(sobreTi);
            }
        });

        panelSecundario1.setBorder(borderPanels);

        ///////////////////////////////////////////////////////////////////////////
        // Panel Principal 2

        lblExperiencia.setBounds(p2_posX1, p2_posY1,150,30);
        lblExperiencia.setFont(fuenteTitulo);

        panelSecundario2.add(lblExperiencia);

        // Action Listener del botón añadir experiencia, genera una ventana nueva para introducir datos
        btnExperiencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new ExperienciaScreen();
            }
        });

        tblExperiencia.setEnabled(false);
        tblExperiencia.getTableHeader().setReorderingAllowed(false);
        tblExperiencia.getTableHeader().setBackground(Color.LIGHT_GRAY);
        tblExperiencia.getTableHeader().setPreferredSize(new Dimension(200,30));
        tblExperiencia.getTableHeader().setFont(fuenteCabeceraTablas);
        tblExperiencia.setFont(fuenteDatosTablas);

        scrollExperiencia.setBounds(p2_posX1, p2_posY2, p2_width, p2_height);
        btnExperiencia.setBounds(p2_posX2, p2_posY3, p2_width2, p2_height2);

        panelSecundario2.add(scrollExperiencia);
        panelSecundario2.add(btnExperiencia);

        panelSecundario2.setBorder(borderPanels);

        // Listener de la tabla de experiencia, para poder borrar datos de la misma
        tblExperiencia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logic.borrarFilaTabla(tblExperiencia,modelExperiencia,e);
            }
        });

        /////////////////////////////////////////////////////////////////////////////////////////
        // Panel Principal 3

        panelSecundario3.add(lblPresentacion);
        JScrollPane scrollPanePresentacion = new JScrollPane(txtPresentacion);
        panelSecundario3.add(scrollPanePresentacion);

        lblPresentacion.setFont(fuenteTitulo);

        lblPresentacion.setBounds(p3_posX1, p3_posY1, p3_width, p3_height);
        scrollPanePresentacion.setBounds(p3_posX1, p3_posY2, p3_Area_width, p3_Area_height);

        txtPresentacion.setLineWrap(true);
        txtPresentacion.setWrapStyleWord(true);
        txtPresentacion.setMargin(new Insets(10,10,10,10));
        txtPresentacion.setFont(fuenteTextField);

        panelSecundario3.setBorder(borderPanels);

        ////////////////////////////////////////////////////////////////////////////////////////////
        // Panel principal 4

        lblTitulacion.setBounds(p4_posX1, p4_posY1, 300,30);
        lblTitulacion.setFont(fuenteTitulo);

        panelSecundario4.add(lblTitulacion);

        // Botón que despliega una nueva ventana para añadir una titulación nueva, que se añadirá a la tabla.
        btnTitulacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TitulacionScreen();
            }
        });

        tblTitulacion.setEnabled(false);
        tblTitulacion.getTableHeader().setReorderingAllowed(false);
        tblTitulacion.getTableHeader().setBackground(Color.LIGHT_GRAY);
        tblTitulacion.getTableHeader().setPreferredSize(new Dimension(200,30));
        tblTitulacion.getTableHeader().setFont(fuenteCabeceraTablas);

        scrollTitulacion.setBounds(p4_posX1, p4_posY2, p4_width, p4_height);
        btnTitulacion.setBounds(p4_posX2, p4_posY3, p4_width2, p4_height2);

        panelSecundario4.add(scrollTitulacion);
        panelSecundario4.add(btnTitulacion);

        // Listener de la tabla que nos permite borrar una entrada, si clicamos en "borrar"
        tblTitulacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logic.borrarFilaTabla(tblTitulacion,modelTitulacion,e);
            }
        });

        panelSecundario4.setBorder(borderPanels);

        ////////////////////////////////////////////////////////////////////////////
        // Botón generarCV

        // Listener del boton generarCV, settea todos los datos en las clases, y finalmente genera el PDF del currículum
        btnGenerarCV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sobreTi.setNombre(txtNombre.getText());
                sobreTi.setApellido(txtApellidos.getText());
                sobreTi.setFechaNacimiento(txtFechaNac.getText());
                sobreTi.setPresentacion(txtPresentacion.getText());

                // Añado un condicional al action listener del boton generarCV, para que en caso de que el usuario
                // no seleccione una imagen, se le avise con un diálogo, ya que si este no selecciona una imagen,
                // el PDF con el currículum no se generará.
                if (sobreTi.getImagen()!=null){
                    try {
                        new Curriculum(sobreTi,experienciasList,titulacionesList);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,
                            "No has seleccionado una foto!",
                            "Error!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////
        // Añadimos el botón generarCV y todos los panels al frame principal

        btnGenerarCV.setFont(fuenteBotones);
        btnGenerarCV.setBounds(515,710,150,40);

        frame.add(panelPrincipal);
        frame.add(btnGenerarCV);
        frame.add(lblTitulo);

        panelPrincipal.setLayout(estructura);
        panelPrincipal.add(panelPrincipal1);
        panelPrincipal.add(panelPrincipal2);
        panelPrincipal.add(panelPrincipal3);
        panelPrincipal.add(panelPrincipal4);

        panelPrincipal1.setLayout(null);
        panelSecundario1.setLayout(null);
        panelSecundario1.setBounds(15,15,530,280);
        panelPrincipal1.add(panelSecundario1);

        panelPrincipal2.setLayout(null);
        panelSecundario2.setLayout(null);
        panelSecundario2.setBounds(15,15,530,280);
        panelPrincipal2.add(panelSecundario2);

        panelPrincipal3.setLayout(null);
        panelSecundario3.setLayout(null);
        panelSecundario3.setBounds(15,15,530,280);
        panelPrincipal3.add(panelSecundario3);

        panelPrincipal4.setLayout(null);
        panelSecundario4.setLayout(null);
        panelSecundario4.setBounds(15,15,530,280);
        panelPrincipal4.add(panelSecundario4);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CV Generator");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();

    } // GeneradorCV()

    public static void main(String[] args) {
        new GeneradorCV();
    }

}