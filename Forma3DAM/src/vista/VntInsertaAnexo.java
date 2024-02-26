package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.AlumnosDAO;
import modelo.ConvenioDAO;
import modelo.EmpresasDAO;
import org.hibernate.HibernateException;
import pojos.Alumnos;
import pojos.Convenio;
import pojos.Empresas;

public class VntInsertaAnexo extends javax.swing.JPanel {

    private byte[] bytes2_1;
    private byte[] bytes2_2;
    private byte[] bytes3;
    private byte[] bytes4;
    private byte[] bytes8;

    public VntInsertaAnexo() {
        initComponents();
        cargarCIFEmpresas();
        btnInsertar.setEnabled(false);
        txtNEmpresa.setEditable(false);
        cmbEmpresas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbEmpresas.getSelectedIndex() == 0) {
                    // Si se selecciona el primer elemento, desactivar el botón Insertar
                    btnInsertar.setEnabled(false);
                    txtNEmpresa.setText("");
                } else {
                    // Si se selecciona otro elemento, activar el botón Insertar
                    btnInsertar.setEnabled(true);
                    // Obtener el objeto Empresas seleccionado
                    Empresas empresa = (Empresas) cmbEmpresas.getSelectedItem();
                    if (empresa != null) {
                        txtNEmpresa.setText(empresa.getNombreEmpresa());
                    }
                }
            }
        });
    }

    private void cargarCIFEmpresas() {
        EmpresasDAO empresasDAO = new EmpresasDAO();
        List<Empresas> listaEmpresas = empresasDAO.obtenListaEmpresas();
        DefaultComboBoxModel<Empresas> model = new DefaultComboBoxModel<>();
        model.addElement(new Empresas(null)); // Opción por defecto
        for (Empresas empresa : listaEmpresas) {
            model.addElement(empresa);
        }
        cmbEmpresas.setModel(model);
        cmbEmpresas.setRenderer(new EmpresasComboBoxRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        favicon = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        txtNumConvenio = new javax.swing.JTextField();
        userLabel1 = new javax.swing.JLabel();
        txtNEmpresa = new javax.swing.JTextField();
        userLabel2 = new javax.swing.JLabel();
        userLabel4 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        btnSubirA2_1 = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        nombreArchivo2_1 = new javax.swing.JLabel();
        cmbEmpresas = new javax.swing.JComboBox<>();
        txtResponsable = new javax.swing.JTextField();
        userLabel3 = new javax.swing.JLabel();
        cmbAlumnos = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        userLabel6 = new javax.swing.JLabel();
        nombreArchivo3 = new javax.swing.JLabel();
        btnSubirA3 = new javax.swing.JButton();
        userLabel7 = new javax.swing.JLabel();
        nombreArchivo4 = new javax.swing.JLabel();
        btnSubirA4 = new javax.swing.JButton();
        userLabel8 = new javax.swing.JLabel();
        nombreArchivo8 = new javax.swing.JLabel();
        btnSubirA8 = new javax.swing.JButton();
        userLabel9 = new javax.swing.JLabel();
        nombreArchivo2_2 = new javax.swing.JLabel();
        btnSubirA2_2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1078, 608));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Forma3.png"))); // NOI18N

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("FechaInicio");

        txtNumConvenio.setBackground(new java.awt.Color(0, 0, 0));
        txtNumConvenio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNumConvenio.setForeground(new java.awt.Color(255, 255, 255));
        txtNumConvenio.setBorder(null);
        txtNumConvenio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNumConvenioMousePressed(evt);
            }
        });

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("TutorPracticas");

        txtNEmpresa.setBackground(new java.awt.Color(0, 0, 0));
        txtNEmpresa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtNEmpresa.setBorder(null);
        txtNEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNEmpresaMousePressed(evt);
            }
        });
        txtNEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNEmpresaActionPerformed(evt);
            }
        });

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setText("FechaFin");

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setText("Nombre Empresa");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("Anexo 2.1");

        btnSubirA2_1.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA2_1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA2_1.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA2_1.setText("Subir CV");
        btnSubirA2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA2_1ActionPerformed(evt);
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

        nombreArchivo2_1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo2_1.setText("Archivo");

        cmbEmpresas.setBackground(new java.awt.Color(0, 0, 0));
        cmbEmpresas.setForeground(new java.awt.Color(255, 255, 255));

        txtResponsable.setBackground(new java.awt.Color(0, 0, 0));
        txtResponsable.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtResponsable.setForeground(new java.awt.Color(255, 255, 255));
        txtResponsable.setBorder(null);
        txtResponsable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtResponsableMousePressed(evt);
            }
        });

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setText("Alumno");

        cmbAlumnos.setBackground(new java.awt.Color(0, 0, 0));
        cmbAlumnos.setForeground(new java.awt.Color(255, 255, 255));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Contratacion");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("Anexo 3");

        nombreArchivo3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo3.setText("Archivo");

        btnSubirA3.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA3.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA3.setText("Subir CV");
        btnSubirA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA3ActionPerformed(evt);
            }
        });

        userLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel7.setText("Anexo 4");

        nombreArchivo4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo4.setText("Archivo");

        btnSubirA4.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA4.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA4.setText("Subir CV");
        btnSubirA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA4ActionPerformed(evt);
            }
        });

        userLabel8.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel8.setText("Anexo 8");

        nombreArchivo8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo8.setText("Archivo");

        btnSubirA8.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA8.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA8.setText("Subir CV");
        btnSubirA8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA8ActionPerformed(evt);
            }
        });

        userLabel9.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel9.setText("Anexo 2.2");

        nombreArchivo2_2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo2_2.setText("Archivo");

        btnSubirA2_2.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA2_2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA2_2.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA2_2.setText("Subir CV");
        btnSubirA2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA2_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreArchivo4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubirA4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreArchivo3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubirA3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreArchivo8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubirA8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(favicon))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNumConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbAlumnos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(nombreArchivo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnSubirA2_1))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(userLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(nombreArchivo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnSubirA2_2))))))
                        .addGap(0, 103, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(333, 333, 333))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumConvenioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumConvenioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumConvenioMousePressed

    private void txtNEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNEmpresaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNEmpresaMousePressed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        byte[] anexoDosUnoConvenio = bytes2_1; // Obtener los bytes del anexo 2.1
        byte[] anexoDosDosConvenio = bytes2_2; // Obtener los bytes del anexo 2.2
        byte[] anexoTresConvenio = bytes3;   // Obtener los bytes del anexo 3
        byte[] anexoCuatroConvenio = bytes4; // Obtener los bytes del anexo 4
        byte[] anexoOchoConvenio = bytes8;   // Obtener los bytes del anexo 8


    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnSubirA2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA2_1ActionPerformed
        subirArchivo("anexo2_1");
    }//GEN-LAST:event_btnSubirA2_1ActionPerformed

    private void txtResponsableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResponsableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResponsableMousePressed

    private void txtNEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNEmpresaActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btnSubirA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA3ActionPerformed
        subirArchivo("anexo3");
    }//GEN-LAST:event_btnSubirA3ActionPerformed

    private void btnSubirA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA4ActionPerformed
        subirArchivo("anexo4");
    }//GEN-LAST:event_btnSubirA4ActionPerformed

    private void btnSubirA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA8ActionPerformed
        subirArchivo("anexo8");
    }//GEN-LAST:event_btnSubirA8ActionPerformed

    private void btnSubirA2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA2_2ActionPerformed
        subirArchivo("anexo2_2");
    }//GEN-LAST:event_btnSubirA2_2ActionPerformed

   private void subirArchivo(String tipoAnexo) {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                byte[] bytesArchivo = convertirArchivoABytes(archivo);
                // Asignar los bytes al campo correspondiente según el tipo de anexo
                switch (tipoAnexo) {
                    case "anexo2_1":
                        bytes2_1 = bytesArchivo;
                        break;
                    case "anexo2_2":
                        bytes2_2 = bytesArchivo;
                        break;
                    case "anexo3":
                        bytes3 = bytesArchivo;
                        break;
                    case "anexo4":
                        bytes4 = bytesArchivo;
                        break;
                    case "anexo8":
                        bytes8 = bytesArchivo;
                        break;
                    default:
                        break;
                }
                // Actualizar el nombre del archivo en la interfaz gráfica
                actualizarNombreArchivo(tipoAnexo, archivo.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void actualizarNombreArchivo(String tipoAnexo, String nombreArchivo) {
        switch (tipoAnexo) {
            case "anexo2_1":
                nombreArchivo2_1.setText(nombreArchivo);
                break;
            case "anexo2_2":
                nombreArchivo2_2.setText(nombreArchivo);
                break;
            case "anexo3":
                nombreArchivo3.setText(nombreArchivo);
                break;
            case "anexo4":
                nombreArchivo4.setText(nombreArchivo);
                break;
            case "anexo8":
                nombreArchivo8.setText(nombreArchivo);
                break;
            default:
                break;
        }
    }

    private byte[] convertirArchivoABytes(File archivo) throws IOException {
        byte[] bytesArray = new byte[(int) archivo.length()];
        FileInputStream fis = new FileInputStream(archivo);
        fis.read(bytesArray);
        fis.close();
        return bytesArray;
    }

    // Clase EmpresasComboBoxRenderer como clase interna estática
// Clase EmpresasComboBoxRenderer como clase interna estática
    private static class EmpresasComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Empresas) {
                Empresas empresa = (Empresas) value;
                if (empresa.getCifEmpresa() == null) {
                    setText("Seleccione un CIF Empresa");
                } else {
                    setText(empresa.getIdEmpresa() + " -  " + empresa.getCifEmpresa());
                }
            }
            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnSubirA2_1;
    private javax.swing.JButton btnSubirA2_2;
    private javax.swing.JButton btnSubirA3;
    private javax.swing.JButton btnSubirA4;
    private javax.swing.JButton btnSubirA8;
    private javax.swing.JComboBox<Empresas
    > cmbAlumnos;
    private javax.swing.JComboBox<Empresas
    > cmbEmpresas;
    private javax.swing.JLabel favicon;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel nombreArchivo2_1;
    private javax.swing.JLabel nombreArchivo2_2;
    private javax.swing.JLabel nombreArchivo3;
    private javax.swing.JLabel nombreArchivo4;
    private javax.swing.JLabel nombreArchivo8;
    private javax.swing.JTextField txtNEmpresa;
    private javax.swing.JTextField txtNumConvenio;
    private javax.swing.JTextField txtResponsable;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel4;
    private javax.swing.JLabel userLabel5;
    private javax.swing.JLabel userLabel6;
    private javax.swing.JLabel userLabel7;
    private javax.swing.JLabel userLabel8;
    private javax.swing.JLabel userLabel9;
    // End of variables declaration//GEN-END:variables
}
