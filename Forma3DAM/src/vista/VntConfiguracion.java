/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.AlumnosDAO;
import modelo.LoginDAO;
import pojos.Alumnos;
import pojos.Login;

/**
 *
 * @author soraf
 */
public class VntConfiguracion extends javax.swing.JPanel {

    /**
     * Creates new form VntConfiguracion
     */
    DefaultTableModel dtm = new DefaultTableModel(new Object[]{
        "ID",
        "Nombre",
        "Correo",
        "Rol"
    }, 0);

    public VntConfiguracion() {
        initComponents();
        TablaUsuarios.setDefaultEditor(Object.class, null);
        cargaTabla();
        cargaUsuario();
    }

    public void cargaTabla() {
        dtm.setRowCount(0);
        List<Login> listaUsuarios = new LoginDAO().obtenListaUsuarios();
        for (Login l : listaUsuarios) {
            dtm.addRow(new Object[]{
                l.getIdUsuario(),
                l.getNombreUsuario(),
                l.getCorreoUsuario(),
                l.getRol(),});
        }
    }

    public void cargaUsuario() {
        TablaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filas = TablaUsuarios.getSelectedRow();
                    if (filas != -1) {
                        txtIDUsuario.setText(TablaUsuarios.getValueAt(filas, 0) + "");
                        txtNombreUsuario.setText(TablaUsuarios.getValueAt(filas, 1) + "");
                        txtCorreoUsuario.setText(TablaUsuarios.getValueAt(filas, 2) + "");
                        txtRolUsuario.setText(TablaUsuarios.getValueAt(filas, 3) + "");
                        // Verificar si el valor en la columna 3 es "Admin"
                        if ("Admin".equals(TablaUsuarios.getValueAt(filas, 3))) {
                            cmbRol.setSelectedIndex(1);
                        } else {
                            cmbRol.setSelectedIndex(2);
                        }

                        txtIDUsuario.setEditable(true);
                        txtNombreUsuario.setEditable(true);
                        txtCorreoUsuario.setEditable(true);

                        btnActualizar.setEnabled(true);
                        btnBorrar.setEnabled(true);
                    } else {
                        txtIDUsuario.setEditable(false);
                        txtNombreUsuario.setEditable(false);
                        txtCorreoUsuario.setEditable(false);
                        cmbRol.setSelectedIndex(0);
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        userLabel6 = new javax.swing.JLabel();
        txtIDUsuario = new javax.swing.JTextField();
        userLabel = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        userLabel1 = new javax.swing.JLabel();
        txtCorreoUsuario = new javax.swing.JTextField();
        userLabel2 = new javax.swing.JLabel();
        txtRolUsuario = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        cmbRol = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1090, 609));

        title1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("CONFIGURACION USUARIOS");

        TablaUsuarios.setModel(dtm);
        jScrollPane2.setViewportView(TablaUsuarios);

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Actualizar/Borrar");

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("ID Usuario");

        txtIDUsuario.setEditable(false);
        txtIDUsuario.setBackground(new java.awt.Color(0, 0, 0));
        txtIDUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtIDUsuario.setBorder(null);
        txtIDUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDUsuarioMousePressed(evt);
            }
        });

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("Nombre Usuario");

        txtNombreUsuario.setEditable(false);
        txtNombreUsuario.setBackground(new java.awt.Color(0, 0, 0));
        txtNombreUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreUsuario.setBorder(null);
        txtNombreUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreUsuarioMousePressed(evt);
            }
        });

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("Correo Electronico");

        txtCorreoUsuario.setEditable(false);
        txtCorreoUsuario.setBackground(new java.awt.Color(0, 0, 0));
        txtCorreoUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCorreoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreoUsuario.setBorder(null);
        txtCorreoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCorreoUsuarioMousePressed(evt);
            }
        });

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setText("Rol de Usuario");

        txtRolUsuario.setEditable(false);
        txtRolUsuario.setBackground(new java.awt.Color(0, 0, 0));
        txtRolUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRolUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtRolUsuario.setBorder(null);
        txtRolUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtRolUsuarioMousePressed(evt);
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

        cmbRol.setBackground(new java.awt.Color(0, 0, 0));
        cmbRol.setForeground(new java.awt.Color(255, 255, 255));
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Un Rol", "Admin", "Trabajador" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(title1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(34, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(title1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDUsuarioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDUsuarioMousePressed

    private void txtNombreUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreUsuarioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioMousePressed

    private void txtCorreoUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoUsuarioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoUsuarioMousePressed

    private void txtRolUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRolUsuarioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRolUsuarioMousePressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtIDUsuario.getText() != "" && txtNombreUsuario.getText() != "" && txtCorreoUsuario.getText() != ""
                && cmbRol.getSelectedIndex() != 0) {
            Login l = new Login(Integer.parseInt(txtIDUsuario.getText()), txtNombreUsuario.getText(), txtCorreoUsuario.getText(), cmbRol.getSelectedItem().toString());
            LoginDAO ld = new LoginDAO();
            System.out.println(l.getRol());
            ld.actualizaUsuario(l);

            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtIDUsuario, "Escoge un usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField txtCorreoUsuario;
    private javax.swing.JTextField txtIDUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtRolUsuario;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel6;
    // End of variables declaration//GEN-END:variables
}
