package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.AlumnosDAO;
import modelo.AsignaturasDAO;
import modelo.ConvenioDAO;
import modelo.EmpresasDAO;
import pojos.Alumnos;
import pojos.Asignaturas;
import pojos.Convenio;
import pojos.Empresas;

public class vntConvenios extends javax.swing.JPanel {

    private byte[] bytesCV;
    private JFrame frame;

    DefaultTableModel dtm = new DefaultTableModel(new Object[]{
        "ID",
        "Nº Convenio",
        "Nombre",
        "ID Empresa",
        "ResponsableFirma",
        "Cantidad Anexos",
        "AnexoUnoConvenio"
    }, 0);

    public vntConvenios(JFrame vntPrincipal) {
        initComponents();
        TablaConvenio.setDefaultEditor(Object.class, null);
        cargaTabla();
        cargaConvenios();
        frame = vntPrincipal;
    }

    public void cargaTabla() {
        dtm.setRowCount(0);
        List<Convenio> listaConvenio = new ConvenioDAO().obtenListaConvenios();
        for (Convenio c : listaConvenio) {
            if (c.getIdConvenio() != -1) {
                if (c.getAnexoUnoConvenio() != null && c.getAnexoUnoConvenio().length > 0) {
                    dtm.addRow(new Object[]{
                        c.getIdConvenio(),
                        c.getNumConvenio(),
                        c.getNombreEmpresa(),
                        c.getEmpresas().getIdEmpresa(),
                        c.getResponsableFirma(),
                        c.getCantAnexos(),
                        "Subido",});
                } else {
                    dtm.addRow(new Object[]{
                        c.getIdConvenio(),
                        c.getNumConvenio(),
                        c.getNombreEmpresa(),
                        c.getEmpresas().getIdEmpresa(),
                        c.getResponsableFirma(),
                        c.getCantAnexos(),
                        "No Subido",});
                }

            }

        }
    }

    public void cargaConvenios() {
        TablaConvenio.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filas = TablaConvenio.getSelectedRow();
                    if (filas != -1) {
                        txtIDConvenio.setText(TablaConvenio.getValueAt(filas, 0) + "");
                        txtNumConvenio.setText(TablaConvenio.getValueAt(filas, 1) + "");
                        txtNombreEmpresa.setText(TablaConvenio.getValueAt(filas, 2) + "");
                        txtIDEmpresa.setText(TablaConvenio.getValueAt(filas, 3) + "");
                        txtCantidadAnexos.setText(TablaConvenio.getValueAt(filas, 5) + "");
                        txtResponsableFirma1.setText(TablaConvenio.getValueAt(filas, 4) + "");
                        txtNumConvenio.setEditable(true);
                        txtNombreEmpresa.setEditable(true);
                        txtIDEmpresa.setEditable(true);
                        txtCantidadAnexos.setEditable(true);
                        txtResponsableFirma1.setEditable(true);
                        btnSubirAnex.setEnabled(true);
                        btnActualizar.setEnabled(true);
                        btnBorrar.setEnabled(true);
                    } else {
                        txtNumConvenio.setEditable(false);
                        txtNombreEmpresa.setEditable(false);
                        txtIDEmpresa.setEditable(false);
                        txtCantidadAnexos.setEditable(false);
                        txtResponsableFirma1.setEditable(false);
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
        txtNumConvenio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaConvenio = new javax.swing.JTable();
        userLabel1 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        userLabel2 = new javax.swing.JLabel();
        txtIDEmpresa = new javax.swing.JTextField();
        userLabel3 = new javax.swing.JLabel();
        txtCantidadAnexos = new javax.swing.JTextField();
        userLabel4 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        btnSubirAnex = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        title1 = new javax.swing.JLabel();
        userLabel6 = new javax.swing.JLabel();
        txtIDConvenio = new javax.swing.JTextField();
        nombreArchivo = new javax.swing.JLabel();
        txtResponsableFirma1 = new javax.swing.JTextField();

        jTableAlumnos.setModel(dtm);
        jScrollPane1.setViewportView(jTableAlumnos);

        setAlignmentX(0.0F);

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png"))); // NOI18N

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Actualizar/Borrar");

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("Num Convenio");

        txtNumConvenio.setEditable(false);
        txtNumConvenio.setBackground(new java.awt.Color(0, 0, 0));
        txtNumConvenio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNumConvenio.setForeground(new java.awt.Color(255, 255, 255));
        txtNumConvenio.setBorder(null);
        txtNumConvenio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNumConvenioMousePressed(evt);
            }
        });

        TablaConvenio.setModel(dtm);
        jScrollPane2.setViewportView(TablaConvenio);

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("Nombre Empresa");

        txtNombreEmpresa.setEditable(false);
        txtNombreEmpresa.setBackground(new java.awt.Color(0, 0, 0));
        txtNombreEmpresa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombreEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreEmpresa.setBorder(null);
        txtNombreEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreEmpresaMousePressed(evt);
            }
        });

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setText("ID Empresa");

        txtIDEmpresa.setEditable(false);
        txtIDEmpresa.setBackground(new java.awt.Color(0, 0, 0));
        txtIDEmpresa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtIDEmpresa.setBorder(null);
        txtIDEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDEmpresaMousePressed(evt);
            }
        });
        txtIDEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDEmpresaActionPerformed(evt);
            }
        });

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setText("R.Firma");

        txtCantidadAnexos.setEditable(false);
        txtCantidadAnexos.setBackground(new java.awt.Color(0, 0, 0));
        txtCantidadAnexos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCantidadAnexos.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidadAnexos.setBorder(null);
        txtCantidadAnexos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCantidadAnexosMousePressed(evt);
            }
        });

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setText("C.Anexos");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("AnexoUno");

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

        btnSubirAnex.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirAnex.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirAnex.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirAnex.setText("Subir");
        btnSubirAnex.setEnabled(false);
        btnSubirAnex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirAnexActionPerformed(evt);
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
        title1.setText("CONVENIOS");

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("ID Convenio");

        txtIDConvenio.setEditable(false);
        txtIDConvenio.setBackground(new java.awt.Color(0, 0, 0));
        txtIDConvenio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDConvenio.setForeground(new java.awt.Color(255, 255, 255));
        txtIDConvenio.setBorder(null);
        txtIDConvenio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDConvenioMousePressed(evt);
            }
        });

        nombreArchivo.setBackground(new java.awt.Color(0, 0, 0));
        nombreArchivo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo.setText("Archivo");

        txtResponsableFirma1.setEditable(false);
        txtResponsableFirma1.setBackground(new java.awt.Color(0, 0, 0));
        txtResponsableFirma1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtResponsableFirma1.setForeground(new java.awt.Color(255, 255, 255));
        txtResponsableFirma1.setBorder(null);
        txtResponsableFirma1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtResponsableFirma1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(670, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtIDConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSubirAnex))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userLabel4)
                                    .addComponent(userLabel3))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtResponsableFirma1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(userLabel)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(userLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 65, Short.MAX_VALUE)
                    .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(80, 80, 80)
                    .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 615, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsableFirma1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubirAnex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
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
        EmpresasDAO ed = new EmpresasDAO();
        ConvenioDAO cd = new ConvenioDAO();

        Integer idConvenio = Integer.parseInt(txtIDConvenio.getText());
        Integer numConvenio = Integer.parseInt(txtNumConvenio.getText());
        String nombreEmpresa = txtNombreEmpresa.getText();
        String cifEmpresa = txtIDEmpresa.getText();
        String responsableFirma = txtResponsableFirma1.getText();
        Integer cantAnexos = Integer.parseInt(txtCantidadAnexos.getText());

        Empresas e = new Empresas();

        e = ed.obtenerEmpresaPorNombre(nombreEmpresa);

        Convenio c = new Convenio(idConvenio, e, numConvenio, nombreEmpresa, responsableFirma, cantAnexos, bytesCV);
        cd.eliminarConvenio(c, frame);
        cargaTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtCantidadAnexosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadAnexosMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadAnexosMousePressed

    private void txtIDEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDEmpresaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDEmpresaMousePressed

    private void txtNombreEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreEmpresaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEmpresaMousePressed

    private void txtNumConvenioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumConvenioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumConvenioMousePressed

    private void txtIDConvenioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDConvenioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDConvenioMousePressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ConvenioDAO cd = new ConvenioDAO();

        // Obtener los datos del formulario
        Integer idConvenio = Integer.parseInt(txtIDConvenio.getText());
        Integer numConvenio = Integer.parseInt(txtNumConvenio.getText());
        String nombreEmpresa = txtNombreEmpresa.getText();
        String cifEmpresa = txtIDEmpresa.getText();
        String responsableFirma = txtResponsableFirma1.getText();
        Integer cantAnexos = Integer.parseInt(txtCantidadAnexos.getText());

        // Obtener la empresa asociada al convenio
        EmpresasDAO ed = new EmpresasDAO();
        Empresas e = ed.obtenerEmpresaPorNombre(nombreEmpresa);

        // Crear el objeto Convenio con los datos del formulario
        Convenio convenio = new Convenio(idConvenio, e, numConvenio, nombreEmpresa, responsableFirma, cantAnexos, bytesCV);

        // Llamar al método para actualizar el convenio
        cd.actualizarConvenio(convenio, frame);

        // Actualizar la tabla
        cargaTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSubirAnexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirAnexActionPerformed
        // Obtener el índice de la fila seleccionada en la tabla
        int filaSeleccionada = TablaConvenio.getSelectedRow();

        // Verificar si hay una fila seleccionada y si el anexo ya está subido
        if (filaSeleccionada != -1 && TablaConvenio.getValueAt(filaSeleccionada, 6).equals("Subido")) {
            // Mostrar un JOptionPane para confirmar la sobrescritura del archivo
            int opcion = JOptionPane.showConfirmDialog(this, "Ya hay un archivo subido. ¿Desea sobreescribirlo?",
                    "Confirmar Sobrescritura", JOptionPane.YES_NO_OPTION);

            // Verificar la opción seleccionada por el usuario
            if (opcion == JOptionPane.YES_OPTION) {
                // El usuario ha confirmado la sobrescritura, procede a subir el nuevo archivo
                JFileChooser fileChooser = new JFileChooser();
                int resultado = fileChooser.showOpenDialog(this);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivo = fileChooser.getSelectedFile();
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
            } else {
                // El usuario ha seleccionado no sobrescribir, salir del método
                return;
            }
        } else {
            JFileChooser fileChooser = new JFileChooser();
            int resultado = fileChooser.showOpenDialog(this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
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
        }
    }//GEN-LAST:event_btnSubirAnexActionPerformed

    private void txtIDEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDEmpresaActionPerformed

    private void txtResponsableFirma1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResponsableFirma1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResponsableFirma1MousePressed

    private byte[] convertirArchivoABytes(File archivo) throws IOException {
        byte[] bytesArray = new byte[(int) archivo.length()];
        FileInputStream fis = new FileInputStream(archivo);
        fis.read(bytesArray);
        fis.close();
        return bytesArray;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaConvenio;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnSubirAnex;
    private javax.swing.JLabel favicon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JLabel nombreArchivo;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField txtCantidadAnexos;
    private javax.swing.JTextField txtIDConvenio;
    private javax.swing.JTextField txtIDEmpresa;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtNumConvenio;
    private javax.swing.JTextField txtResponsableFirma1;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel4;
    private javax.swing.JLabel userLabel5;
    private javax.swing.JLabel userLabel6;
    // End of variables declaration//GEN-END:variables
}
