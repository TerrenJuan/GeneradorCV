package com.iessanalberto.JTT.models;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class Curriculum {


    private String destino = "target/nombredelpdf.pdf";

    public Curriculum(SobreTi sobreTi,ExperienciasList experienciasList,TitulacionesList titulacionesList) throws FileNotFoundException, MalformedURLException {


        PdfWriter escritor = new PdfWriter(destino);

        PdfDocument pdf = new PdfDocument(escritor);



        Document documento = new Document(pdf);
        documento.setMargins(50, 50, 50, 50);

        // Imagen

        String imagenFile = sobreTi.getImagen();
        ImageData data = ImageDataFactory.create(imagenFile);
        Image image = new Image(data);
        image.scaleToFit(200, 200);
        image.setFixedPosition(50,650);

        documento.add(image);


        // Información - "Sobre Ti"

        String nombre = "Nombre: " + sobreTi.getNombre();
        Paragraph parrafo1 = new Paragraph(nombre);
        parrafo1.setPaddingLeft(250);
        documento.add(parrafo1);

        String apellido = "Apellido: " + sobreTi.getApellido();
        Paragraph parrafo2 = new Paragraph(apellido);
        parrafo2.setPaddingLeft(250);
        documento.add(parrafo2);

        String fechaNacimiento = "Fecha nacimiento: " + sobreTi.getFechaNacimiento();
        Paragraph parrafo3 = new Paragraph(fechaNacimiento);
        parrafo3.setPaddingLeft(250);
        parrafo3.setMarginBottom(75);
        documento.add(parrafo3);


        // Motivación - Presentación


        String motivacion = "Motivacion";
        Paragraph parrafo4 = new Paragraph(motivacion);
        parrafo4.setFontColor(Color.BLUE);
        parrafo4.setBold();
        parrafo4.setMarginTop(30);
        parrafo4.setPaddingLeft(50);
        documento.add(parrafo4);

        // Crear una tabla con una sola celda para envolver el párrafo
        float[] dimensionCelda = {500};  // Ancho de la columna de la tabla
        Table textoBorde = new Table(dimensionCelda);

        String presentacion = sobreTi.getPresentacion();
        // Crear una celda con borde y añadir el párrafo
        Cell textoPresentacion = new Cell().add(presentacion);

                // Establecer el grosor del borde y el color

        textoPresentacion.setPadding(10);         // Espaciado dentro de la celda

        // Añadir la celda con el párrafo a la tabla
        textoBorde.addCell(textoPresentacion);
        textoBorde.setMarginBottom(40);
        // Añadir la tabla al documento (esto efectivamente añade el párrafo con borde)
        documento.add(textoBorde);





        // Experiencia - Tabla

        String experiencia = "Experiencia";
        Paragraph parrafo6 = new Paragraph(experiencia);
        parrafo6.setFontColor(Color.BLUE);
        parrafo6.setBold();
        parrafo6.setMarginTop(30);
        parrafo6.setPaddingLeft(50);
        documento.add(parrafo6);

        // Definir el número de columnas
        UnitValue[] dimensionColumns = UnitValue.createPercentArray(new float[]{20f, 20f, 60f});
        Table tableExperiencia = new Table(dimensionColumns);

        tableExperiencia.setWidthPercent(100);
        // Añadimos los encabezados
        tableExperiencia.addHeaderCell(new Cell().add("Fecha de inicio").setBackgroundColor(Color.LIGHT_GRAY));
        tableExperiencia.addHeaderCell(new Cell().add("Perfil").setBackgroundColor(Color.LIGHT_GRAY));
        tableExperiencia.addHeaderCell(new Cell().add("Descripcion").setBackgroundColor(Color.LIGHT_GRAY));

        // Llenamos la tabla con los datos del array
        for (Experiencia experienciaAux : experienciasList.getExperienciasList()) {
            tableExperiencia.addCell(experienciaAux.getFechaInicio());
            tableExperiencia.addCell(experienciaAux.getTipoTrabajo());
            tableExperiencia.addCell(experienciaAux.getDescripcion());
        }


        documento.add(tableExperiencia);

        // Titulaciones - Tabla

        String titulacion = "Estudios / Idiomas / Skills";
        Paragraph parrafo7 = new Paragraph(titulacion);
        parrafo7.setFontColor(Color.BLUE);
        parrafo7.setBold();
        parrafo7.setMarginTop(30);
        parrafo7.setPaddingLeft(50);
        documento.add(parrafo7);
        // Definir el número de columnas

        Table tableTitulacion = new Table(dimensionColumns);

        tableTitulacion.setWidthPercent(100);
        // Añadimos los encabezados
        tableTitulacion.addHeaderCell(new Cell().add("Fecha").setBackgroundColor(Color.LIGHT_GRAY));
        tableTitulacion.addHeaderCell(new Cell().add("Tipo").setBackgroundColor(Color.LIGHT_GRAY));
        tableTitulacion.addHeaderCell(new Cell().add("Descripcion").setBackgroundColor(Color.LIGHT_GRAY));

        // Llenamos la tabla con los datos del array
        for (Titulacion titulacionAux : titulacionesList.getTitulacionesList()) {
            tableTitulacion.addCell(titulacionAux.getFechaFinal());
            tableTitulacion.addCell(titulacionAux.getTitulacion());
            tableTitulacion.addCell(titulacionAux.getDescripcion());
        }

        documento.add(tableTitulacion);

        documento.close();
    }


}
