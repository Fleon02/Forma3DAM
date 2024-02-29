package vista;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.AlumnosDAO;
import modelo.AnexosDAO;
import modelo.EmpresasDAO;
import modelo.PracticasDAO;
import pojos.Alumnos;
import pojos.Anexos;
import pojos.Empresas;
import pojos.Practicas;

public class VntInsertaPractica extends javax.swing.JPanel {

    private byte[] bytesIS;
    private byte[] bytesIF;

    public VntInsertaPractica() {
        initComponents();
        try {
            DateFormat formatoOrigen = new SimpleDateFormat("HHmm");
            DateFormat formatoDestino = new SimpleDateFormat("HH:mm");
            Date fecha = formatoOrigen.parse("0700");
            String fechaFormato = formatoDestino.format(fecha);
            txtHorarioEntrada.setText(fechaFormato);
            txtHorarioSalida.setText(fechaFormato);
        } catch (ParseException ex) {
            Logger.getLogger(VntInsertaPractica.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarDNIAlumno();
        cargarTutorPracticasEmpresas();
        cargarCalendariosAnexos();
    }

    private void cargarDNIAlumno() {
        List<Alumnos> listaAlumnos = new AlumnosDAO().obtenListaAlumnos();
        DefaultComboBoxModel<Alumnos> modeloDNIA = new DefaultComboBoxModel<>();
        modeloDNIA.addElement(new Alumnos(null));
        for (Alumnos a : listaAlumnos) {
            modeloDNIA.addElement(a);
        }
        cbDNIAlumno.setModel(modeloDNIA);
        cbDNIAlumno.setRenderer(new AlumnosComboBoxRenderer());
    }

    private static class AlumnosComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Alumnos) {
                Alumnos a = (Alumnos) value;
                if (a.getIdAlumno() == null) {
                    setText("Seleccione DNI de Alumno/a");
                } else {
                    if (a.getIdAlumno() > 0) {
                        setText(a.getIdAlumno() + " - " + a.getDniAlumno());
                    } else {
                        setText("");
                    }
                }
            }
            return this;
        }
    }

    private void cargarTutorPracticasEmpresas() {
        List<Empresas> listaEmpresas = new EmpresasDAO().obtenListaEmpresas();
        DefaultComboBoxModel<Empresas> model = new DefaultComboBoxModel<>();
        model.addElement(new Empresas());
        for (Empresas empresa : listaEmpresas) {
            model.addElement(empresa);
        }
        cbTutorPracticas.setModel(model);
        cbTutorPracticas.setRenderer(new EmpresasComboBoxRenderer());
    }

    private static class EmpresasComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Empresas) {
                Empresas empresa = (Empresas) value;
                if (empresa.getTutorPracticas() == null) {
                    setText("Seleccione Tutor/a");
                } else {
                    if (empresa.getIdEmpresa() > 0) {
                        setText(empresa.getIdEmpresa() + " - " + empresa.getTutorPracticas());
                    } else {
                        setText("");
                    }
                }
            }
            return this;
        }
    }

    private void cargarCalendariosAnexos() {
        List<Anexos> listaAnexos = new AnexosDAO().obtenerAnexos();
        DefaultComboBoxModel<Anexos> model = new DefaultComboBoxModel<>();
        model.addElement(new Anexos());
        for (Anexos anexos : listaAnexos) {
            model.addElement(anexos);
        }
        cbCalendario.setModel(model);
        cbCalendario.setRenderer(new AnexosComboBoxRenderer());
    }

    private static class AnexosComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Anexos) {
                Anexos anexos = (Anexos) value;
                if (anexos.getCalendario() == null) {
                    setText("Seleccione Calendario");
                } else {
                    if (anexos.getIdAnexo() > 0) {
                        setText(anexos.getIdAnexo() + " - " + anexos.getCalendario());
                    } else {
                        setText("");
                    }
                }
            }
            return this;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        favicon = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userLabel1 = new javax.swing.JLabel();
        userLabel2 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        btnSubirCVIF = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        nombreArchivoIF = new javax.swing.JLabel();
        cbCalendario = new javax.swing.JComboBox<>();
        cbTutorPracticas = new javax.swing.JComboBox<>();
        btnSubirCVIS = new javax.swing.JButton();
        nombreArchivoIS = new javax.swing.JLabel();
        userLabel6 = new javax.swing.JLabel();
        cbDNIAlumno = new javax.swing.JComboBox<>();
        userLabel7 = new javax.swing.JLabel();
        txtHorarioEntrada = new javax.swing.JTextField();
        txtHorarioSalida = new javax.swing.JTextField();
        userLabel8 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1078, 608));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Forma3.png"))); // NOI18N

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("DNI Alumno");

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("Tutor Practicas");

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setText("Calendario");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("Informe Final");

        btnSubirCVIF.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirCVIF.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirCVIF.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirCVIF.setText("Subir I. F.");
        btnSubirCVIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirCVIFActionPerformed(evt);
            }
        });

        btnInsertar.setBackground(new java.awt.Color(18, 30, 49));
        btnInsertar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        nombreArchivoIF.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivoIF.setText("Archivo");

        cbCalendario.setBackground(new java.awt.Color(0, 0, 0));
        cbCalendario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbCalendario.setForeground(new java.awt.Color(255, 255, 255));

        cbTutorPracticas.setBackground(new java.awt.Color(0, 0, 0));
        cbTutorPracticas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbTutorPracticas.setForeground(new java.awt.Color(255, 255, 255));

        btnSubirCVIS.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirCVIS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirCVIS.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirCVIS.setText("Subir I. S.");
        btnSubirCVIS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirCVISActionPerformed(evt);
            }
        });

        nombreArchivoIS.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivoIS.setText("Archivo");

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("Informe Seguimiento");

        cbDNIAlumno.setBackground(new java.awt.Color(0, 0, 0));
        cbDNIAlumno.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbDNIAlumno.setForeground(new java.awt.Color(255, 255, 255));

        userLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel7.setText("Horario Entrada");

        txtHorarioEntrada.setBackground(new java.awt.Color(0, 0, 0));
        txtHorarioEntrada.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtHorarioEntrada.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioEntrada.setBorder(null);
        txtHorarioEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHorarioEntradaMousePressed(evt);
            }
        });

        txtHorarioSalida.setBackground(new java.awt.Color(0, 0, 0));
        txtHorarioSalida.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtHorarioSalida.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioSalida.setBorder(null);
        txtHorarioSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHorarioSalidaMousePressed(evt);
            }
        });

        userLabel8.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel8.setText("Horario Salida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombreArchivoIF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubirCVIF)
                        .addGap(296, 296, 296))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(userLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtHorarioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(favicon)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbDNIAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbCalendario, 0, 224, Short.MAX_VALUE))
                                        .addGap(70, 70, 70)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(nombreArchivoIS, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSubirCVIS))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbTutorPracticas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(346, 346, 346)))
                        .addGap(118, 118, 118))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTutorPracticas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDNIAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSubirCVIS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreArchivoIS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorarioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSubirCVIF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreArchivoIF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (cbDNIAlumno.getSelectedIndex() != 0 && cbTutorPracticas.getSelectedIndex() != 0 && cbCalendario.getSelectedIndex() != 0) {
            Alumnos al = (Alumnos) cbDNIAlumno.getSelectedItem();
            Anexos an = (Anexos) cbCalendario.getSelectedItem();
            Empresas e = (Empresas) cbTutorPracticas.getSelectedItem();
            Practicas p = new Practicas(al, an, e, bytesIS, bytesIF, txtHorarioEntrada.getText(), txtHorarioSalida.getText());
            new PracticasDAO().guardaPracticas(p);
            new VntPracticas().cargaTabla();
        } else {
            JOptionPane.showMessageDialog(cbDNIAlumno, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnSubirCVIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirCVIFActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                byte[] bytesArchivo = convertirArchivoABytes(archivo);
                bytesIF = bytesArchivo;
                nombreArchivoIF.setText(archivo.getName());
                nombreArchivoIF.setToolTipText(archivo.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSubirCVIFActionPerformed

    private void btnSubirCVISActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirCVISActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter docxFilter = new FileNameExtensionFilter("Archivos DOCX", "docx");
        fileChooser.addChoosableFileFilter(docxFilter);
        fileChooser.setFileFilter(docxFilter);
        fileChooser.setDialogTitle("Elige un archivo DOCX");
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String nombreArchivo = archivo.getName();
            String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toLowerCase();
            if (!extension.equals("docx")) {
                JOptionPane.showMessageDialog(this, "Solo se permiten archivos DOCX", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                byte[] bytesArchivo = convertirArchivoABytes(archivo);
                bytesIS = bytesArchivo;
                nombreArchivoIS.setText(archivo.getName());
                nombreArchivoIS.setToolTipText(archivo.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSubirCVISActionPerformed

    private void txtHorarioEntradaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHorarioEntradaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorarioEntradaMousePressed

    private void txtHorarioSalidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHorarioSalidaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorarioSalidaMousePressed

    private byte[] convertirArchivoABytes(File archivo) throws IOException {
        byte[] bytesArray = new byte[(int) archivo.length()];
        FileInputStream fis = new FileInputStream(archivo);
        fis.read(bytesArray);
        fis.close();
        return bytesArray;
    }

    public byte[] getBytesCV() {
        return bytesIF;
    }

    public void setBytesCV(byte[] bytesIF) {
        this.bytesIF = bytesIF;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnSubirCVIF;
    private javax.swing.JButton btnSubirCVIS;
    private javax.swing.JComboBox<Anexos> cbCalendario;
    private javax.swing.JComboBox<Alumnos> cbDNIAlumno;
    private javax.swing.JComboBox<Empresas
    > cbTutorPracticas;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel nombreArchivoIF;
    private javax.swing.JLabel nombreArchivoIS;
    private javax.swing.JTextField txtHorarioEntrada;
    private javax.swing.JTextField txtHorarioSalida;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel5;
    private javax.swing.JLabel userLabel6;
    private javax.swing.JLabel userLabel7;
    private javax.swing.JLabel userLabel8;
    // End of variables declaration//GEN-END:variables
}
