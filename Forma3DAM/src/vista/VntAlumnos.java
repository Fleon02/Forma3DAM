package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.AlumnosDAO;
import modelo.AsignaturasDAO;
import pojos.Alumnos;
import pojos.Asignaturas;

public class VntAlumnos extends javax.swing.JPanel {

    private byte[] bytesCV;
    private JFrame frame;
    DefaultTableModel dtm = new DefaultTableModel(new Object[]{
        "ID",
        "DNI",
        "Nombre",
        "Año Curso",
        "N. S. S.",
        "Ciclo",
        "CV",
        "Validez"
    }, 0);

    public VntAlumnos(JFrame vntPrincipal) {
        frame = vntPrincipal;
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
        TablaAlumnos.setDefaultEditor(Object.class, null);
        cargaTabla();
        cargaAlumno();
        TablaAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int fila = TablaAlumnos.rowAtPoint(e.getPoint());
                    int columna = TablaAlumnos.columnAtPoint(e.getPoint());
                    if (columna == 6 && "Subido".equals(TablaAlumnos.getValueAt(fila, columna))) {
                        int opcion = JOptionPane.showConfirmDialog(frame, "¿Desea descargar el archivo?", "Descargar Archivo", JOptionPane.YES_NO_OPTION);
                        if (opcion == JOptionPane.YES_OPTION) {
                            descargarArchivo(fila, columna);
                        }
                    }
                }

            }
        }
        );
    }

    public void cargaTabla() {
        dtm.setRowCount(0);
        List<Alumnos> listaAlumnos = new AlumnosDAO().obtenListaAlumnos();
        for (Alumnos a : listaAlumnos) {
            if (a.getIdAlumno() > 0) {
                if (a.getCv() != null) {
                    dtm.addRow(new Object[]{
                        a.getIdAlumno(),
                        a.getDniAlumno(),
                        a.getNombreAlumno(),
                        a.getYearCurso(),
                        a.getSegSocialAlumno(),
                        a.getCicloAlumno(),
                        "Subido",
                        a.getValidez(),});
                } else {
                    dtm.addRow(new Object[]{
                        a.getIdAlumno(),
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
    }

    public void cargaAlumno() {
        TablaAlumnos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filas = TablaAlumnos.getSelectedRow();
                    if (filas != -1) {
                        txtIDAlumno.setText(TablaAlumnos.getValueAt(filas, 0) + "");
                        txtDNIAlumno.setText(TablaAlumnos.getValueAt(filas, 1) + "");
                        txtNombreAlumno.setText(TablaAlumnos.getValueAt(filas, 2) + "");
                        txtAnioAlumno.setText(TablaAlumnos.getValueAt(filas, 3) + "");
                        txtNSSAlumno.setText(TablaAlumnos.getValueAt(filas, 4) + "");
                        cbCicloAlumno.setSelectedItem(TablaAlumnos.getValueAt(filas, 5));
                        checkbValidez.setSelected(Boolean.parseBoolean(TablaAlumnos.getValueAt(filas, 7) + ""));
                        txtDNIAlumno.setEditable(true);
                        txtNombreAlumno.setEditable(true);
                        txtAnioAlumno.setEditable(true);
                        txtNSSAlumno.setEditable(true);
                        cbCicloAlumno.setEnabled(true);
                        checkbValidez.setEnabled(true);
                        btnSubirCV.setEnabled(true);
                        btnAsignaturas.setEnabled(true);
                        btnActualizar.setEnabled(true);
                        btnBorrar.setEnabled(true);
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
        title1 = new javax.swing.JLabel();
        userLabel6 = new javax.swing.JLabel();
        txtIDAlumno = new javax.swing.JTextField();
        nombreArchivo = new javax.swing.JLabel();
        cbCicloAlumno = new javax.swing.JComboBox<>();
        btnAsignaturas = new javax.swing.JButton();

        jTableAlumnos.setModel(dtm);
        jScrollPane1.setViewportView(jTableAlumnos);

        setAlignmentX(0.0F);

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png"))); // NOI18N

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Actualizar/Borrar");

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("DNI Alumno");

        txtDNIAlumno.setEditable(false);
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
        userLabel1.setText("Nombre Alumno");

        txtNombreAlumno.setEditable(false);
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
        userLabel2.setText("Año Alumno");

        txtAnioAlumno.setEditable(false);
        txtAnioAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtAnioAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtAnioAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtAnioAlumno.setBorder(null);
        txtAnioAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtAnioAlumnoMousePressed(evt);
            }
        });
        txtAnioAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioAlumnoActionPerformed(evt);
            }
        });

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setText("N. S. S. Alumno");

        txtNSSAlumno.setEditable(false);
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
        userLabel4.setText("Ciclo Alumno");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("Curriculum Alumno");

        btnBorrar.setBackground(new java.awt.Color(18, 30, 49));
        btnBorrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setText("Borrar");
        btnBorrar.setEnabled(false);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        checkbValidez.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkbValidez.setText("Validez (Aprobado)");
        checkbValidez.setEnabled(false);

        btnSubirCV.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirCV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirCV.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirCV.setText("Subir CV");
        btnSubirCV.setEnabled(false);
        btnSubirCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirCVActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(18, 30, 49));
        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        title1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("ALUMNOS");

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("ID Alumno");

        txtIDAlumno.setEditable(false);
        txtIDAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtIDAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtIDAlumno.setBorder(null);
        txtIDAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDAlumnoMousePressed(evt);
            }
        });

        nombreArchivo.setBackground(new java.awt.Color(0, 0, 0));
        nombreArchivo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo.setText("Archivo");

        cbCicloAlumno.setBackground(new java.awt.Color(0, 0, 0));
        cbCicloAlumno.setForeground(new java.awt.Color(255, 255, 255));
        cbCicloAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Ciclo", "DAM", "DAW", "ASIR", "FIN", "MARK" }));
        cbCicloAlumno.setEnabled(false);

        btnAsignaturas.setBackground(new java.awt.Color(18, 30, 49));
        btnAsignaturas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAsignaturas.setForeground(new java.awt.Color(255, 255, 255));
        btnAsignaturas.setText("Ver Asignaturas");
        btnAsignaturas.setEnabled(false);
        btnAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignaturasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(676, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtDNIAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtAnioAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtNSSAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtIDAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnAsignaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnActualizar)
                            .addGap(18, 18, 18)
                            .addComponent(btnBorrar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(checkbValidez))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSubirCV))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(cbCicloAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(80, 80, 80)
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 425, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCicloAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubirCV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkbValidez)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (txtDNIAlumno.getText() != null) {
            new AlumnosDAO().eliminaAlumnos(txtDNIAlumno.getText(), frame);
            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtDNIAlumno, "Seleciona un Alumno", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtNSSAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNSSAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNSSAlumnoMousePressed

    private void txtAnioAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAnioAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioAlumnoMousePressed

    private void txtNombreAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAlumnoMousePressed

    private void txtDNIAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDNIAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIAlumnoMousePressed

    private void txtIDAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDAlumnoMousePressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtDNIAlumno.getText() != null && txtNombreAlumno.getText() != null && txtAnioAlumno.getText() != null
                && txtNSSAlumno.getText() != null && cbCicloAlumno.getSelectedIndex() != 0) {
            if (checkbValidez.isSelected()) {
                Alumnos a = new Alumnos(txtDNIAlumno.getText(), txtNombreAlumno.getText(), Integer.parseInt(txtAnioAlumno.getText()),
                        Integer.parseInt(txtNSSAlumno.getText()), Boolean.TRUE, cbCicloAlumno.getSelectedItem().toString(), bytesCV);
                a.setIdAlumno(Integer.parseInt(txtIDAlumno.getText()));
                new AlumnosDAO().actualizaAlumnos(a, frame);
            } else {
                Alumnos a = new Alumnos(txtDNIAlumno.getText(), txtNombreAlumno.getText(), Integer.parseInt(txtAnioAlumno.getText()),
                        Integer.parseInt(txtNSSAlumno.getText()), Boolean.FALSE, cbCicloAlumno.getSelectedItem().toString(), bytesCV);
                a.setIdAlumno(Integer.parseInt(txtIDAlumno.getText()));
                new AlumnosDAO().actualizaAlumnos(a, frame);
            }
            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtDNIAlumno, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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

    private void btnAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignaturasActionPerformed
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.BOLD, 14));
        List<Asignaturas> listaAsignaturas = new AsignaturasDAO().obtenListaAsignaturas();
        for (Asignaturas a : listaAsignaturas) {
            if (cbCicloAlumno.getSelectedItem().toString().equalsIgnoreCase(a.getCicloFormativo())) {
                textArea.append("\n" + a.getNombreAsignatura() + " (" + a.getAbreviatura() + ")\n");
            }
        }
        JFrame frame = new JFrame("Asignaturas de " + cbCicloAlumno.getSelectedItem().toString());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }//GEN-LAST:event_btnAsignaturasActionPerformed

    private void txtAnioAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioAlumnoActionPerformed

    private byte[] convertirArchivoABytes(File archivo) throws IOException {
        byte[] bytesArray = new byte[(int) archivo.length()];
        FileInputStream fis = new FileInputStream(archivo);
        fis.read(bytesArray);
        fis.close();
        return bytesArray;
    }

    private void descargarArchivo(int fila, int columna) {
        AlumnosDAO ad = new AlumnosDAO();
        int idAlumno = (int) TablaAlumnos.getValueAt(fila, 0);
        Alumnos alumno = ad.obtenAlumnos(idAlumno);
        byte[] archivo = null;

        archivo = alumno.getCv();

        // Guardar el archivo en disco
        if (archivo != null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar archivo");

            // Filtro para archivos .docx
            FileNameExtensionFilter docxFilter = new FileNameExtensionFilter("Archivos PDF", "pdf");

            // Añadir el filtro de archivos .docx al file chooser
            fileChooser.addChoosableFileFilter(docxFilter);

            fileChooser.setFileFilter(docxFilter);

            int seleccion = fileChooser.showSaveDialog(frame);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String nombreArchivo = selectedFile.getName();

                // Obtener el filtro seleccionado por el usuario como un FileFilter
                FileFilter filtroSeleccionado = fileChooser.getFileFilter();

                // Obtener la descripción del filtro seleccionado
                String descripcionFiltro = filtroSeleccionado.getDescription();

                // Obtener la extensión del archivo a partir de la descripción del filtro seleccionado
                String extensionFiltro = "pdf";

                // Verificar si el nombre del archivo termina con la extensión correcta
                if (!nombreArchivo.toLowerCase().endsWith("." + extensionFiltro)) {
                    // Agregar la extensión correcta al nombre del archivo
                    nombreArchivo += "." + extensionFiltro;
                    selectedFile = new File(selectedFile.getParent(), nombreArchivo);
                }

                try (FileOutputStream fos = new FileOutputStream(selectedFile)) {
                    fos.write(archivo);
                    JOptionPane.showMessageDialog(frame, "Archivo descargado exitosamente", "Descarga Exitosa", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No se ha encontrado el archivo asociado", "Archivo no encontrado", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAlumnos;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAsignaturas;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnSubirCV;
    private javax.swing.JComboBox<String> cbCicloAlumno;
    private javax.swing.JCheckBox checkbValidez;
    private javax.swing.JLabel favicon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JLabel nombreArchivo;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField txtAnioAlumno;
    private javax.swing.JTextField txtDNIAlumno;
    private javax.swing.JTextField txtIDAlumno;
    private javax.swing.JTextField txtNSSAlumno;
    private javax.swing.JTextField txtNombreAlumno;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel4;
    private javax.swing.JLabel userLabel5;
    private javax.swing.JLabel userLabel6;
    // End of variables declaration//GEN-END:variables
}
