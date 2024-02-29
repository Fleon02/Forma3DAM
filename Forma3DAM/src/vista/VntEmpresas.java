package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.EmpresasDAO;
import pojos.Empresas;

public class VntEmpresas extends javax.swing.JPanel {

    private byte[] bytesCV;

    DefaultTableModel dtm = new DefaultTableModel(new Object[]{
        "ID",
        "Empresa",
        "CIF",
        "Direccion",
        "Telefono",
        "Owner",
        "Tutor Practicas",
        "Responsable Contratacion"
    }, 0);

    public VntEmpresas() {
        initComponents();
        /*txtTelefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });*/
        TablaEmpresas.setDefaultEditor(Object.class, null);
        cargaTabla();
        cargaEmpresa();
    }

    public void cargaTabla() {
        dtm.setRowCount(0);
        List<Empresas> listaEmpresas = new EmpresasDAO().obtenListaEmpresas();
        for (Empresas e : listaEmpresas) {
            if (e.getIdEmpresa() != -1) {
                dtm.addRow(new Object[]{
                    e.getIdEmpresa(),
                    e.getNombreEmpresa(),
                    e.getCifEmpresa(),
                    e.getDireccion(),
                    e.getTelefono(),
                    e.getOwner(),
                    e.getTutorPracticas(),
                    e.getResponsableContratacion(),});
            }

        }
    }

    public void cargaEmpresa() {
        TablaEmpresas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filas = TablaEmpresas.getSelectedRow();
                    if (filas != -1) {
                        txtIDEmpresa.setText(TablaEmpresas.getValueAt(filas, 0) + "");
                        txtNombreEmpresa.setText(TablaEmpresas.getValueAt(filas, 1) + "");
                        txtCIFEmpresa.setText(TablaEmpresas.getValueAt(filas, 2) + "");
                        txtDireccion.setText(TablaEmpresas.getValueAt(filas, 3) + "");
                        txtTelefono.setText(TablaEmpresas.getValueAt(filas, 4) + "");
                        txtOwner.setText(TablaEmpresas.getValueAt(filas, 5) + "");
                        txtTutorPracticas.setText(TablaEmpresas.getValueAt(filas, 6) + "");
                        txtResponsableContratacion.setText(TablaEmpresas.getValueAt(filas, 7) + "");
                        txtNombreEmpresa.setEditable(true);
                        txtCIFEmpresa.setEditable(true);
                        txtDireccion.setEditable(true);
                        txtTelefono.setEditable(true);
                        txtOwner.setEditable(true);
                        txtTutorPracticas.setEditable(true);
                        txtResponsableContratacion.setEditable(true);
                        btnActualizar.setEnabled(true);
                        btnBorrar.setEnabled(true);
                    } else {
                        txtCIFEmpresa.setEditable(false);
                        txtDireccion.setEditable(false);
                        txtTelefono.setEditable(false);
                        txtOwner.setEditable(false);
                        txtTutorPracticas.setEditable(false);
                        txtResponsableContratacion.setEditable(false);
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
        txtCIFEmpresa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEmpresas = new javax.swing.JTable();
        userLabel1 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        userLabel2 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        userLabel3 = new javax.swing.JLabel();
        txtOwner = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        title1 = new javax.swing.JLabel();
        userLabel6 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        userLabel4 = new javax.swing.JLabel();
        txtTutorPracticas = new javax.swing.JTextField();
        userLabel5 = new javax.swing.JLabel();
        txtResponsableContratacion = new javax.swing.JTextField();
        userLabel7 = new javax.swing.JLabel();
        txtIDEmpresa = new javax.swing.JTextField();

        jTableAlumnos.setModel(dtm);
        jScrollPane1.setViewportView(jTableAlumnos);

        setAlignmentX(0.0F);

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png"))); // NOI18N

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Actualizar/Borrar");

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("CIF Empresa");

        txtCIFEmpresa.setEditable(false);
        txtCIFEmpresa.setBackground(new java.awt.Color(0, 0, 0));
        txtCIFEmpresa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCIFEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtCIFEmpresa.setBorder(null);
        txtCIFEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCIFEmpresaMousePressed(evt);
            }
        });

        TablaEmpresas.setModel(dtm);
        jScrollPane2.setViewportView(TablaEmpresas);

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("Direccion");

        txtDireccion.setEditable(false);
        txtDireccion.setBackground(new java.awt.Color(0, 0, 0));
        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setBorder(null);
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDireccionMousePressed(evt);
            }
        });

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setText("Telefono");

        txtTelefono.setEditable(false);
        txtTelefono.setBackground(new java.awt.Color(0, 0, 0));
        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(null);
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setText("Owner");

        txtOwner.setEditable(false);
        txtOwner.setBackground(new java.awt.Color(0, 0, 0));
        txtOwner.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtOwner.setForeground(new java.awt.Color(255, 255, 255));
        txtOwner.setBorder(null);
        txtOwner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtOwnerMousePressed(evt);
            }
        });

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
        title1.setText("EMPRESAS");

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("Nombre Empresa");

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

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setText("Tutor Practicas");

        txtTutorPracticas.setEditable(false);
        txtTutorPracticas.setBackground(new java.awt.Color(0, 0, 0));
        txtTutorPracticas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTutorPracticas.setForeground(new java.awt.Color(255, 255, 255));
        txtTutorPracticas.setBorder(null);
        txtTutorPracticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTutorPracticasMousePressed(evt);
            }
        });

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("Responsable de Contratacion");

        txtResponsableContratacion.setEditable(false);
        txtResponsableContratacion.setBackground(new java.awt.Color(0, 0, 0));
        txtResponsableContratacion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtResponsableContratacion.setForeground(new java.awt.Color(255, 255, 255));
        txtResponsableContratacion.setBorder(null);
        txtResponsableContratacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtResponsableContratacionMousePressed(evt);
            }
        });

        userLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel7.setText("ID Empresa");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(676, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtTutorPracticas, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtCIFEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtResponsableContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCIFEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTutorPracticas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsableContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
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
        if (txtCIFEmpresa.getText() != null) {
            new EmpresasDAO().eliminaEmpresas(txtCIFEmpresa.getText());
            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtCIFEmpresa, "Seleciona un Empresa", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtOwnerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtOwnerMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOwnerMousePressed

    private void txtTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoMousePressed

    private void txtDireccionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionMousePressed

    private void txtCIFEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCIFEmpresaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCIFEmpresaMousePressed

    private void txtNombreEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreEmpresaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEmpresaMousePressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtCIFEmpresa.getText() != null && txtNombreEmpresa.getText() != null && txtDireccion.getText() != null && txtTelefono.getText() != null
                && txtOwner.getText() != null && txtTutorPracticas.getText() != null && txtResponsableContratacion.getText() != null) {
            Empresas e = new Empresas(txtNombreEmpresa.getText(), txtCIFEmpresa.getText(), txtDireccion.getText(), txtTelefono.getText(),
                    txtOwner.getText(), txtTutorPracticas.getText(), txtResponsableContratacion.getText());
            e.setIdEmpresa(Integer.parseInt(txtIDEmpresa.getText()));
            new EmpresasDAO().actualizaEmpresas(e);
            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtCIFEmpresa, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTutorPracticasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTutorPracticasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTutorPracticasMousePressed

    private void txtResponsableContratacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResponsableContratacionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResponsableContratacionMousePressed

    private void txtIDEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDEmpresaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDEmpresaMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEmpresas;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JLabel favicon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField txtCIFEmpresa;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIDEmpresa;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtOwner;
    private javax.swing.JTextField txtResponsableContratacion;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTutorPracticas;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel4;
    private javax.swing.JLabel userLabel5;
    private javax.swing.JLabel userLabel6;
    private javax.swing.JLabel userLabel7;
    // End of variables declaration//GEN-END:variables
}
