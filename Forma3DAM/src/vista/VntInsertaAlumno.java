package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.AlumnosDAO;
import pojos.Alumnos;

public class VntInsertaAlumno extends javax.swing.JPanel {

    private byte[] bytesCV;

    public VntInsertaAlumno() {
        initComponents();
        txtAnioAlumno.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });
        txtNSSAlumno.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        favicon = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        txtDNIAlumno = new javax.swing.JTextField();
        userLabel1 = new javax.swing.JLabel();
        txtNombreAlumno = new javax.swing.JTextField();
        userLabel2 = new javax.swing.JLabel();
        txtAnioAlumno = new javax.swing.JTextField();
        userLabel3 = new javax.swing.JLabel();
        txtNSSAlumno = new javax.swing.JTextField();
        userLabel4 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        checkbValidez = new javax.swing.JCheckBox();
        btnSubirCV = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        nombreArchivo = new javax.swing.JLabel();
        cbCicloAlumno = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1078, 608));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Forma3.png"))); // NOI18N

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setText("DNI Alumno");

        txtDNIAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtDNIAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDNIAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtDNIAlumno.setBorder(null);
        txtDNIAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDNIAlumnoMousePressed(evt);
            }
        });

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setForeground(new java.awt.Color(0, 0, 0));
        userLabel1.setText("Nombre Alumno");

        txtNombreAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtNombreAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombreAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreAlumno.setBorder(null);
        txtNombreAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreAlumnoMousePressed(evt);
            }
        });

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setForeground(new java.awt.Color(0, 0, 0));
        userLabel2.setText("Año Alumno");

        txtAnioAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtAnioAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtAnioAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtAnioAlumno.setBorder(null);
        txtAnioAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtAnioAlumnoMousePressed(evt);
            }
        });

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setForeground(new java.awt.Color(0, 0, 0));
        userLabel3.setText("N. S. S. Alumno");

        txtNSSAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtNSSAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNSSAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtNSSAlumno.setBorder(null);
        txtNSSAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNSSAlumnoMousePressed(evt);
            }
        });

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setForeground(new java.awt.Color(0, 0, 0));
        userLabel4.setText("Ciclo Alumno");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setForeground(new java.awt.Color(0, 0, 0));
        userLabel5.setText("Curriculum Alumno");

        checkbValidez.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkbValidez.setForeground(new java.awt.Color(0, 0, 0));
        checkbValidez.setText("Validez (Aprobado)");

        btnSubirCV.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirCV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirCV.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirCV.setText("Subir CV");
        btnSubirCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirCVActionPerformed(evt);
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

        nombreArchivo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo.setText("Archivo");

        cbCicloAlumno.setBackground(new java.awt.Color(0, 0, 0));
        cbCicloAlumno.setForeground(new java.awt.Color(255, 255, 255));
        cbCicloAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Ciclo", "DAM", "DAW", "ASIR", "FIN", "MARK" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtAnioAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNSSAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtDNIAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(71, 71, 71)
                                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCicloAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSubirCV))
                            .addComponent(favicon)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(checkbValidez)
                        .addGap(327, 327, 327))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(343, 343, 343)))
                .addGap(0, 121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNIAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAnioAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNSSAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSubirCV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbCicloAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(checkbValidez)
                .addGap(29, 29, 29)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDNIAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDNIAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIAlumnoMousePressed

    private void txtNombreAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAlumnoMousePressed

    private void txtAnioAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAnioAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioAlumnoMousePressed

    private void txtNSSAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNSSAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNSSAlumnoMousePressed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (txtDNIAlumno.getText() != null && txtNombreAlumno.getText() != null && txtAnioAlumno.getText() != null
                && txtNSSAlumno.getText() != null && cbCicloAlumno.getSelectedIndex() != 0) {
            if (checkbValidez.isSelected()) {
                Alumnos a = new Alumnos(txtDNIAlumno.getText(), txtNombreAlumno.getText(), Integer.parseInt(txtAnioAlumno.getText()),
                        Integer.parseInt(txtNSSAlumno.getText()), Boolean.TRUE, cbCicloAlumno.getSelectedItem().toString(), bytesCV);
                new AlumnosDAO().guardaAlumnos(a);
            } else {
                Alumnos a = new Alumnos(txtDNIAlumno.getText(), txtNombreAlumno.getText(), Integer.parseInt(txtAnioAlumno.getText()),
                        Integer.parseInt(txtNSSAlumno.getText()), Boolean.FALSE, cbCicloAlumno.getSelectedItem().toString(), bytesCV);
                new AlumnosDAO().guardaAlumnos(a);
            }
        } else {
            JOptionPane.showMessageDialog(txtDNIAlumno, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnSubirCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirCVActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        // Filtro para archivos .pdf
        FileNameExtensionFilter pdfFilter = new FileNameExtensionFilter("Archivos PDF", "pdf");

        // Añadir el filtro de archivos .pdf al file chooser
        fileChooser.addChoosableFileFilter(pdfFilter);
        fileChooser.setFileFilter(pdfFilter);

        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".pdf")) {
                JOptionPane.showMessageDialog(this, "Solo se permiten archivos PDF", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si el archivo no es .pdf
            }
            try {
                byte[] bytesArchivo = convertirArchivoABytes(archivo);
                bytesCV = bytesArchivo;
                nombreArchivo.setText(archivo.getName());
                nombreArchivo.setToolTipText(archivo.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSubirCVActionPerformed

    private byte[] convertirArchivoABytes(File archivo) throws IOException {
        byte[] bytesArray = new byte[(int) archivo.length()];
        FileInputStream fis = new FileInputStream(archivo);
        fis.read(bytesArray);
        fis.close();
        return bytesArray;
    }

    public byte[] getBytesCV() {
        return bytesCV;
    }

    public void setBytesCV(byte[] bytesCV) {
        this.bytesCV = bytesCV;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnSubirCV;
    private javax.swing.JComboBox<String> cbCicloAlumno;
    private javax.swing.JCheckBox checkbValidez;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel nombreArchivo;
    private javax.swing.JTextField txtAnioAlumno;
    private javax.swing.JTextField txtDNIAlumno;
    private javax.swing.JTextField txtNSSAlumno;
    private javax.swing.JTextField txtNombreAlumno;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel4;
    private javax.swing.JLabel userLabel5;
    // End of variables declaration//GEN-END:variables
}
