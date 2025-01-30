package com.iessanalberto.JTT.logic;

import com.iessanalberto.JTT.models.SobreTi;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Logic extends Component {

    SobreTi sobreTi = new SobreTi();
    public void seleccionarImagen(SobreTi sobreTi ) {
        // Crear un JFileChooser para seleccionar archivos
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona una imagen");

        // Filtrar solo archivos de imagen (opcional)
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File archivoSeleccionado = fileChooser.getSelectedFile();
            sobreTi.setImagen(archivoSeleccionado.getAbsolutePath());

        }
    }


}
