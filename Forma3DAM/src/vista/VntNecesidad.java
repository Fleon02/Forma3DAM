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
import modelo.NecesidadDAO;
import pojos.Empresas;
import pojos.Necesidad;

/**
 *
 * @author Usuario
 */
public class VntNecesidad extends javax.swing.JPanel {
    
    DefaultTableModel dtm = new DefaultTableModel(new Object[]{
        "IDNECESIDAD",
        "CIF",
        "Ciclo",
        "DAM",
        "DAW",
        "ASIR",
        "MARKETING",
        "FINANZAS"
    }, 0);

    /**
     * Creates new form VntNecesidad
     */
    public VntNecesidad() {
        initComponents();
        
        
        TablaNecesidad.setDefaultEditor(Object.class, null);
        cargaTabla();
        cargaNecesidad();
    }
    
    public void cargaTabla() {
    dtm.setRowCount(0);
    List<Necesidad> listaNecesidades = new NecesidadDAO().obtenListaNecesidad();
    
    for (Necesidad necesidad : listaNecesidades) {
        if (necesidad.getIdNecesidad() != null) {
            dtm.addRow(new Object[]{  
                necesidad.getIdNecesidad(),
                necesidad.getEmpresas(),
                necesidad.getCicloNecesidad(),
                necesidad.getDam(),
                necesidad.getDaw(),
                necesidad.getAsir(),
                necesidad.getMark(),
                necesidad.getFin()
                });  
            }
        }
    }
    
    public void cargaNecesidad(){
        TablaNecesidad.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filas = TablaNecesidad.getSelectedRow();
                    if (filas != -1) {
                        txtIDNecesidad.setText(TablaNecesidad.getValueAt(filas, 0) + "");
                        txtCIFEmpresa.setText(TablaNecesidad.getValueAt(filas, 1) + "");
                        txtCicloNecesidad.setText(TablaNecesidad.getValueAt(filas, 2) + "");
                        txtDAM.setText(TablaNecesidad.getValueAt(filas, 3) + "");
                        txtDAW.setText(TablaNecesidad.getValueAt(filas, 4) + "");
                        txtASIR.setText(TablaNecesidad.getValueAt(filas, 5) + "");
                        txtMARK.setText(TablaNecesidad.getValueAt(filas, 6) + "");
                        txtFIN.setText(TablaNecesidad.getValueAt(filas, 7) + "");
                        
                        txtCIFEmpresa.setEditable(true);
                        txtCicloNecesidad.setEditable(true);
                        txtDAM.setEditable(true);
                        txtDAW.setEditable(true);
                        txtASIR.setEditable(true);
                        txtMARK.setEnabled(true);
                        txtFIN.setEnabled(true);
                        btnActualizar.setEnabled(true);
                        btnBorrar.setEnabled(true);
                    } else {
                        txtCIFEmpresa.setEditable(false);
                        txtCicloNecesidad.setEditable(false);
                        txtDAM.setEditable(false);
                        txtDAW.setEditable(false);
                        txtASIR.setEditable(false);
                        txtMARK.setEditable(false);
                        txtFIN.setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        txtCIFEmpresa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaNecesidad = new javax.swing.JTable();
        userLabel1 = new javax.swing.JLabel();
        txtCicloNecesidad = new javax.swing.JTextField();
        userLabel2 = new javax.swing.JLabel();
        txtDAM = new javax.swing.JTextField();
        userLabel3 = new javax.swing.JLabel();
        txtDAW = new javax.swing.JTextField();
        userLabel4 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        userLabel6 = new javax.swing.JLabel();
        txtIDNecesidad = new javax.swing.JTextField();
        txtASIR = new javax.swing.JTextField();
        txtMARK = new javax.swing.JTextField();
        userLabel7 = new javax.swing.JLabel();
        txtFIN = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        btnAsignaturas = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        jPanel1.setAlignmentX(0.0F);

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

        TablaNecesidad.setModel(dtm);
        jScrollPane2.setViewportView(TablaNecesidad);

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("Ciclo Necesidad");

        txtCicloNecesidad.setEditable(false);
        txtCicloNecesidad.setBackground(new java.awt.Color(0, 0, 0));
        txtCicloNecesidad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCicloNecesidad.setForeground(new java.awt.Color(255, 255, 255));
        txtCicloNecesidad.setBorder(null);
        txtCicloNecesidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCicloNecesidadMousePressed(evt);
            }
        });

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setText("DAM");

        txtDAM.setEditable(false);
        txtDAM.setBackground(new java.awt.Color(0, 0, 0));
        txtDAM.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDAM.setForeground(new java.awt.Color(255, 255, 255));
        txtDAM.setBorder(null);
        txtDAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDAMMousePressed(evt);
            }
        });
        txtDAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDAMActionPerformed(evt);
            }
        });

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setText("DAW");

        txtDAW.setEditable(false);
        txtDAW.setBackground(new java.awt.Color(0, 0, 0));
        txtDAW.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDAW.setForeground(new java.awt.Color(255, 255, 255));
        txtDAW.setBorder(null);
        txtDAW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDAWMousePressed(evt);
            }
        });

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setText("ASIR");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("MARKETING");

        title1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("NECESIDAD");

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("ID Necesidad");

        txtIDNecesidad.setEditable(false);
        txtIDNecesidad.setBackground(new java.awt.Color(0, 0, 0));
        txtIDNecesidad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDNecesidad.setForeground(new java.awt.Color(255, 255, 255));
        txtIDNecesidad.setBorder(null);
        txtIDNecesidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDNecesidadMousePressed(evt);
            }
        });

        txtASIR.setEditable(false);
        txtASIR.setBackground(new java.awt.Color(0, 0, 0));
        txtASIR.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtASIR.setForeground(new java.awt.Color(255, 255, 255));
        txtASIR.setBorder(null);
        txtASIR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtASIRMousePressed(evt);
            }
        });

        txtMARK.setEditable(false);
        txtMARK.setBackground(new java.awt.Color(0, 0, 0));
        txtMARK.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtMARK.setForeground(new java.awt.Color(255, 255, 255));
        txtMARK.setBorder(null);
        txtMARK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMARKMousePressed(evt);
            }
        });

        userLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel7.setText("FINANZAS");

        txtFIN.setEditable(false);
        txtFIN.setBackground(new java.awt.Color(0, 0, 0));
        txtFIN.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFIN.setForeground(new java.awt.Color(255, 255, 255));
        txtFIN.setBorder(null);
        txtFIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFINMousePressed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(745, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCIFEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCicloNecesidad, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtDAM, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtIDNecesidad, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAsignaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnActualizar)
                            .addGap(18, 18, 18)
                            .addComponent(btnBorrar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(txtFIN))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(txtMARK))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDAW)
                                .addComponent(txtASIR, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(40, 65, Short.MAX_VALUE)
                    .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(80, 80, 80)
                    .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 615, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 538, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDNecesidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCIFEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCicloNecesidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDAM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDAW, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtASIR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMARK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFIN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCIFEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCIFEmpresaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCIFEmpresaMousePressed

    private void txtCicloNecesidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCicloNecesidadMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCicloNecesidadMousePressed

    private void txtDAMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDAMMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDAMMousePressed

    private void txtDAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDAMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDAMActionPerformed

    private void txtDAWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDAWMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDAWMousePressed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        Empresas cifempresa = new Empresas(txtCIFEmpresa.getText());
        if (txtCIFEmpresa.getText() != null) {
            new NecesidadDAO().eliminaNecesidad(txtCIFEmpresa.getText());
            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Seleciona una empresa", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(txtCIFEmpresa.getText() != null && txtCicloNecesidad.getText() != null && 
                txtDAM.getText() != null && txtDAW.getText() != null && 
                txtASIR.getText() != null && txtMARK.getText() != null && 
                txtFIN.getText() != null){
            Empresas empresas = new Empresas(txtCIFEmpresa.getText());
            Necesidad n = new Necesidad(empresas, txtCicloNecesidad.getText(),
                    Integer.parseInt(txtDAM.getText()), Integer.parseInt(txtDAW.getText()), Integer.parseInt(txtASIR.getText()), Integer.parseInt(txtMARK.getText()),
                    Integer.parseInt(txtFIN.getText()));
            new NecesidadDAO().actualizarNecesidad(n);            
         cargaTabla();   
        }else{
            JOptionPane.showMessageDialog(this, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtIDNecesidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDNecesidadMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDNecesidadMousePressed

    private void btnAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignaturasActionPerformed
       
    }//GEN-LAST:event_btnAsignaturasActionPerformed

    private void txtASIRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtASIRMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtASIRMousePressed

    private void txtMARKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMARKMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMARKMousePressed

    private void txtFINMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFINMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFINMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaNecesidad;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAsignaturas;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JLabel favicon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField txtASIR;
    private javax.swing.JTextField txtCIFEmpresa;
    private javax.swing.JTextField txtCicloNecesidad;
    private javax.swing.JTextField txtDAM;
    private javax.swing.JTextField txtDAW;
    private javax.swing.JTextField txtFIN;
    private javax.swing.JTextField txtIDNecesidad;
    private javax.swing.JTextField txtMARK;
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
