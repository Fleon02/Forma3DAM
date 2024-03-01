package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DialogoInsertarAnexo extends JDialog {

    private JTextField txtTutorPracticas;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;
    private JTextField txtIdNecesidad;
    private JTextField txtDniAlumno;
    private JCheckBox chkContratacion;
    private JButton btnSubirAnexoDosUno;
    private JButton btnSubirAnexoTres;
    private JButton btnSubirAnexoCuatro;
    private JButton btnSubirAnexoDosDos;
    private JButton btnSubirAnexoOcho;
    private byte[] bytesAnexoDosUno;
    private byte[] bytesAnexoTres;
    private byte[] bytesAnexoCuatro;
    private byte[] bytesAnexoDosDos;
    private byte[] bytesAnexoOcho;

    public DialogoInsertarAnexo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {
        setTitle("Insertar Nuevo Anexo");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2));

        // Campos de texto
        txtTutorPracticas = new JTextField();
        txtFechaInicio = new JTextField();
        txtFechaFin = new JTextField();
        txtIdNecesidad = new JTextField();
        txtDniAlumno = new JTextField();

        // CheckBox para indicar contratación
        chkContratacion = new JCheckBox("Contratación");

        // Botones para subir archivos
        btnSubirAnexoDosUno = new JButton("Subir Anexo Dos Uno");
        btnSubirAnexoTres = new JButton("Subir Anexo Tres");
        btnSubirAnexoCuatro = new JButton("Subir Anexo Cuatro");
        btnSubirAnexoDosDos = new JButton("Subir Anexo Dos Dos");
        btnSubirAnexoOcho = new JButton("Subir Anexo Ocho");

        // Asignar acciones a los botones para subir archivos
        asignarAccionSubirArchivo(btnSubirAnexoDosUno, "bytesAnexoDosUno");
        asignarAccionSubirArchivo(btnSubirAnexoTres, "bytesAnexoTres");
        asignarAccionSubirArchivo(btnSubirAnexoCuatro, "bytesAnexoCuatro");
        asignarAccionSubirArchivo(btnSubirAnexoDosDos, "bytesAnexoDosDos");
        asignarAccionSubirArchivo(btnSubirAnexoOcho, "bytesAnexoOcho");

        // Añadir componentes al diálogo
        add(new JLabel("Tutor Prácticas:"));
        add(txtTutorPracticas);
        add(new JLabel("Fecha Inicio:"));
        add(txtFechaInicio);
        add(new JLabel("Fecha Fin:"));
        add(txtFechaFin);
        add(new JLabel("ID Necesidad:"));
        add(txtIdNecesidad);
        add(new JLabel("DNI Alumno:"));
        add(txtDniAlumno);
        add(chkContratacion);
        add(new JLabel()); // Espacio en blanco para mantener el diseño
        add(btnSubirAnexoDosUno);
        add(btnSubirAnexoTres);
        add(btnSubirAnexoCuatro);
        add(btnSubirAnexoDosDos);
        add(btnSubirAnexoOcho);
    }

    // Método para asignar acciones a los botones de subir archivos
    private void asignarAccionSubirArchivo(JButton button, String field) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarArchivo(field);
            }
        });
    }

    // Método para seleccionar un archivo y asignarlo al campo correspondiente
    private void seleccionarArchivo(String field) {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                byte[] bytesArchivo = convertirArchivoABytes(archivo);
                switch (field) {
                    case "bytesAnexoDosUno":
                        bytesAnexoDosUno = bytesArchivo;
                        break;
                    case "bytesAnexoTres":
                        bytesAnexoTres = bytesArchivo;
                        break;
                    case "bytesAnexoCuatro":
                        bytesAnexoCuatro = bytesArchivo;
                        break;
                    case "bytesAnexoDosDos":
                        bytesAnexoDosDos = bytesArchivo;
                        break;
                    case "bytesAnexoOcho":
                        bytesAnexoOcho = bytesArchivo;
                        break;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para convertir un archivo a bytes
    private byte[] convertirArchivoABytes(File archivo) throws IOException {
        byte[] bytesArray = new byte[(int) archivo.length()];
        FileInputStream fis = new FileInputStream(archivo);
        fis.read(bytesArray);
        fis.close();
        return bytesArray;
    }

    // Métodos para obtener los datos ingresados por el usuario y los archivos seleccionados
    public String getTutorPracticas() {
        return txtTutorPracticas.getText();
    }

    public String getFechaInicio() {
        return txtFechaInicio.getText();
    }

    public String getFechaFin() {
        return txtFechaFin.getText();
    }

    public String getIdNecesidad() {
        return txtIdNecesidad.getText();
    }

    public String getDniAlumno() {
        return txtDniAlumno.getText();
    }

    public boolean getContratacion() {
        return chkContratacion.isSelected();
    }

    public byte[] getBytesAnexoDosUno() {
        return bytesAnexoDosUno;
    }

    public byte[] getBytesAnexoTres() {
        return bytesAnexoTres;
    }

    public byte[] getBytesAnexoCuatro() {
        return bytesAnexoCuatro;
    }

    public byte[] getBytesAnexoDosDos() {
        return bytesAnexoDosDos;
    }

    public byte[] getBytesAnexoOcho() {
        return bytesAnexoOcho;
    }
}
