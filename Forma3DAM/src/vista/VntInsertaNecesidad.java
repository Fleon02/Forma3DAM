/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import modelo.EmpresasDAO;
import modelo.NecesidadDAO;
import pojos.Anexos;
import pojos.Empresas;
import pojos.Necesidad;

/**
 *
 * @author Usuario
 */
public class VntInsertaNecesidad extends javax.swing.JPanel {

    /**
     * Creates new form VntInsertaNecesidad
     */
    public VntInsertaNecesidad() {
        initComponents();
        txtDAM.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });
        txtDAW.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });
        txtASIR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });
        txtMARK.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });
        txtFIN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });        
        cargaCiclo();
        
    }
    
    private void cargaCiclo(){
        String[] opciones = {"Marzo", "Septiembre"};
        cbCiclo.addItem(opciones[0]);
        cbCiclo.addItem(opciones[1]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userLabel2 = new javax.swing.JLabel();
        txtIDEmpresa = new javax.swing.JTextField();
        userLabel3 = new javax.swing.JLabel();
        txtASIR = new javax.swing.JTextField();
        userLabel4 = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        userLabel1 = new javax.swing.JLabel();
        txtDAW = new javax.swing.JTextField();
        cbCiclo = new javax.swing.JComboBox<>();
        userLabel5 = new javax.swing.JLabel();
        txtMARK = new javax.swing.JTextField();
        userLabel6 = new javax.swing.JLabel();
        txtDAM = new javax.swing.JTextField();
        userLabel7 = new javax.swing.JLabel();
        txtFIN = new javax.swing.JTextField();

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setForeground(new java.awt.Color(0, 0, 0));
        userLabel2.setText("ID Empresa");

        txtIDEmpresa.setBackground(new java.awt.Color(0, 0, 0));
        txtIDEmpresa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtIDEmpresa.setBorder(null);
        txtIDEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDEmpresaMousePressed(evt);
            }
        });

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setForeground(new java.awt.Color(0, 0, 0));
        userLabel3.setText("ASIR");

        txtASIR.setBackground(new java.awt.Color(0, 0, 0));
        txtASIR.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtASIR.setForeground(new java.awt.Color(255, 255, 255));
        txtASIR.setBorder(null);
        txtASIR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtASIRMousePressed(evt);
            }
        });

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setForeground(new java.awt.Color(0, 0, 0));
        userLabel4.setText("Ciclo ");

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Forma3.png"))); // NOI18N

        btnInsertar.setBackground(new java.awt.Color(18, 30, 49));
        btnInsertar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setForeground(new java.awt.Color(0, 0, 0));
        userLabel1.setText("DAW");

        txtDAW.setBackground(new java.awt.Color(0, 0, 0));
        txtDAW.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDAW.setForeground(new java.awt.Color(255, 255, 255));
        txtDAW.setBorder(null);
        txtDAW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDAWMousePressed(evt);
            }
        });

        cbCiclo.setBackground(new java.awt.Color(0, 0, 0));
        cbCiclo.setForeground(new java.awt.Color(255, 255, 255));
        cbCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Ciclo" }));

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setForeground(new java.awt.Color(0, 0, 0));
        userLabel5.setText("MARKETING");

        txtMARK.setBackground(new java.awt.Color(0, 0, 0));
        txtMARK.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtMARK.setForeground(new java.awt.Color(255, 255, 255));
        txtMARK.setBorder(null);
        txtMARK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMARKMousePressed(evt);
            }
        });

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setForeground(new java.awt.Color(0, 0, 0));
        userLabel6.setText("DAM");

        txtDAM.setBackground(new java.awt.Color(0, 0, 0));
        txtDAM.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDAM.setForeground(new java.awt.Color(255, 255, 255));
        txtDAM.setBorder(null);
        txtDAM.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDAMMousePressed(evt);
            }
        });

        userLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel7.setForeground(new java.awt.Color(0, 0, 0));
        userLabel7.setText("FINANZAS");

        txtFIN.setBackground(new java.awt.Color(0, 0, 0));
        txtFIN.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFIN.setForeground(new java.awt.Color(255, 255, 255));
        txtFIN.setBorder(null);
        txtFIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFINMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(favicon)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDAW, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDAM, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtASIR, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMARK, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFIN, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(1, 12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(371, 371, 371))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDAM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtASIR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMARK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFIN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDAW, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDEmpresaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDEmpresaMousePressed

    private void txtASIRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtASIRMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtASIRMousePressed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (txtIDEmpresa.getText() != null && txtDAM.getText() != null
            && txtDAW.getText() != null  && txtASIR.getText() != null && txtMARK.getText() != null && 
                txtFIN.getText() != null && cbCiclo.getSelectedIndex() != 0) {            
            Empresas empresa = new EmpresasDAO().obtenEmpresaPorID(txtIDEmpresa.getText());
            Necesidad n = new Necesidad(empresa, String.valueOf(cbCiclo.getSelectedItem()), Integer.parseInt(txtDAM.getText()), 
                    Integer.parseInt(txtDAW.getText()), Integer.parseInt(txtASIR.getText()),
                    Integer.parseInt(txtMARK.getText()), Integer.parseInt(txtFIN.getText()));
                new NecesidadDAO().guardaNecesidad(n);
        
            //cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtIDEmpresa, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void txtDAWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDAWMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDAWMousePressed

    private void txtMARKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMARKMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMARKMousePressed

    private void txtDAMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDAMMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDAMMousePressed

    private void txtFINMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFINMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFINMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private javax.swing.JComboBox<String> cbCiclo;
    private javax.swing.JLabel favicon;
    private javax.swing.JTextField txtASIR;
    private javax.swing.JTextField txtDAM;
    private javax.swing.JTextField txtDAW;
    private javax.swing.JTextField txtFIN;
    private javax.swing.JTextField txtIDEmpresa;
    private javax.swing.JTextField txtMARK;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel4;
    private javax.swing.JLabel userLabel5;
    private javax.swing.JLabel userLabel6;
    private javax.swing.JLabel userLabel7;
    // End of variables declaration//GEN-END:variables
}
