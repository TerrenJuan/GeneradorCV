package com.iessanalberto.JTT.logic;

import com.iessanalberto.JTT.models.SobreTi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
/*
 *
 * @author Juan Terrén
 * @since 5FEB2025
 *
 */
public class Logic extends Component {

    // Función que nos permite obtener el path de la imagen seleccionada por el usuario, esta ruta, la setteamos en la clase
    // "sobreTi", que nos permitirá recuperar la imagen más tarde para poderla insertar en el PDF final.
    public void seleccionarImagen(SobreTi sobreTi) {

        // Crear un JFileChooser para seleccionar archivos
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona una imagen");

        // Filtramos solo por archivos "imagen"
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado, y settearlo en la clase
            File archivoSeleccionado = fileChooser.getSelectedFile();
            sobreTi.setImagen(archivoSeleccionado.getAbsolutePath());
        }
    }

    // Función que nos permite borrar una fila en la tabla, si clickamos en la columna 'borrar'. Al hacer click, nos salta
    // un dialog de confirmación para aceptar borrar la fila o no.
    public void borrarFilaTabla(JTable table, DefaultTableModel modelTable, MouseEvent e) {

        // Obtener la fila y columna donde se hizo el clic
        int filaSeleccionada = table.rowAtPoint(e.getPoint());
        int columnaSeleccionada = table.columnAtPoint(e.getPoint());

        // Comprueba que el click sea en la columna de acciones, en nuestro caso donde pone 'borrar'
        if (filaSeleccionada >= 0 && columnaSeleccionada == 2) {

            int confirmar = JOptionPane.showConfirmDialog(null,
                    "¿Estás seguro de que deseas eliminar esta fila?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            // Si el usuario selecciona "Sí" (JOptionPane.YES_OPTION)
            if (confirmar == JOptionPane.YES_OPTION) {
                // Eliminar la fila
                modelTable.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Fila eliminada.");

            }
        }
    }

}
