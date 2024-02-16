package vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.AlumnosDAO;
import pojos.Alumnos;

public class VntAlumnos extends javax.swing.JPanel {

    private byte[] bytesCV;

    DefaultTableModel dtm = new DefaultTableModel(new Object[]{
        "DNI",
        "Nombre",
        "Año Curso",
        "N. S. S.",
        "Ciclo",
        "CV",
        "Validez"
    }, 0);

    public VntAlumnos() {
        initComponents();
        cargaTabla();
        cargaAlumno();
    }

    public void cargaTabla() {
        dtm.setRowCount(0);
        List<Alumnos> listaAlumnos = new AlumnosDAO().obtenListaAlumnos();
        for (Alumnos a : listaAlumnos) {
            if (a.getCv() != "") {
                dtm.addRow(new Object[]{
                    a.getDniAlumno(),
                    a.getNombreAlumno(),
                    a.getYearCurso(),
                    a.getSegSocialAlumno(),
                    a.getCicloAlumno(),
                    "Subido",
                    a.getValidez(),});
            } else {
                dtm.addRow(new Object[]{
                    a.getDniAlumno(),
                    a.getNombreAlumno(),
                    a.getYearCurso(),
                    a.getSegSocialAlumno(),
                    a.getCicloAlumno(),
                    "No Subido",
                    a.getValidez(),});
            }
        }
    }

    public void cargaAlumno() {
        TablaAlumnos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filas = TablaAlumnos.getSelectedRow();
                    if (filas != -1) {
                        txtDNIAlumno.setText(TablaAlumnos.getValueAt(filas, 0) + "");
                        txtNombreAlumno.setText(TablaAlumnos.getValueAt(filas, 1) + "");
                        txtAnioAlumno.setText(TablaAlumnos.getValueAt(filas, 2) + "");
                        txtNSSAlumno.setText(TablaAlumnos.getValueAt(filas, 3) + "");
                        txtCicloAlumno.setText(TablaAlumnos.getValueAt(filas, 4) + "");
                        if (TablaAlumnos.getValueAt(filas, 6).equals(true)) {
                            checkbValidez.setSelected(true);
                        } else {
                            checkbValidez.setSelected(false);
                        }
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        txtDNIAlumno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAlumnos = new javax.swing.JTable();
        userLabel1 = new javax.swing.JLabel();
        txtNombreAlumno = new javax.swing.JTextField();
        userLabel2 = new javax.swing.JLabel();
        txtAnioAlumno = new javax.swing.JTextField();
        userLabel3 = new javax.swing.JLabel();
        txtNSSAlumno = new javax.swing.JTextField();
        userLabel4 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        checkbValidez = new javax.swing.JCheckBox();
        btnSubirCV = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtCicloAlumno = new javax.swing.JTextField();
        title1 = new javax.swing.JLabel();

        jTableAlumnos.setModel(dtm);
        jScrollPane1.setViewportView(jTableAlumnos);

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png"))); // NOI18N

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Actualizar/Borrar");

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

        TablaAlumnos.setModel(dtm);
        jScrollPane2.setViewportView(TablaAlumnos);

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

        btnBorrar.setBackground(new java.awt.Color(18, 30, 49));
        btnBorrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

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

        btnActualizar.setBackground(new java.awt.Color(18, 30, 49));
        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        txtCicloAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtCicloAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCicloAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtCicloAlumno.setBorder(null);
        txtCicloAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCicloAlumnoMousePressed(evt);
            }
        });

        title1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(0, 0, 0));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("ALUMNOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(80, 80, 80)
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(220, 220, 220)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(txtDNIAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(txtAnioAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(txtNSSAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(txtCicloAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSubirCV, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(checkbValidez))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(0, 25, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDNIAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAnioAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNSSAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCicloAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSubirCV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addComponent(checkbValidez)
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 0, Short.MAX_VALUE)))
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

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (txtDNIAlumno.getText() != "") {
            new AlumnosDAO().eliminaAlumnos(txtDNIAlumno.getText());
            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtDNIAlumno, "Seleciona un Alumno", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtDNIAlumno.getText() != "" && txtNombreAlumno.getText() != "" && txtAnioAlumno.getText() != ""
                && txtNSSAlumno.getText() != "" && txtCicloAlumno.getText() != "") {
            if (checkbValidez.isSelected()) {
                new AlumnosDAO().actualizaAlumnos(txtDNIAlumno.getText(), txtNombreAlumno.getText(), txtAnioAlumno.getText(),
                        txtNSSAlumno.getText(), 1, txtCicloAlumno.getText(), bytesCV);
            } else {
                new AlumnosDAO().actualizaAlumnos(txtDNIAlumno.getText(), txtNombreAlumno.getText(), txtAnioAlumno.getText(),
                        txtNSSAlumno.getText(), 0, txtCicloAlumno.getText(), bytesCV);
            }
            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtDNIAlumno, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtCicloAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCicloAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCicloAlumnoMousePressed

    private void btnSubirCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirCVActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                byte[] bytesArchivo = convertirArchivoABytes(archivo);
                bytesCV = bytesArchivo;
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAlumnos;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnSubirCV;
    private javax.swing.JCheckBox checkbValidez;
    private javax.swing.JLabel favicon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField txtAnioAlumno;
    private javax.swing.JTextField txtCicloAlumno;
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
