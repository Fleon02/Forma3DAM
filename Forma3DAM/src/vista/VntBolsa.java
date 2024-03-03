package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.AlumnosDAO;
import modelo.BolsaDAO;
import pojos.Alumnos;
import pojos.Bolsa;

public class VntBolsa extends javax.swing.JPanel {

    DefaultTableModel dtm = new DefaultTableModel(new Object[]{
        "ID_BOLSA",
        "ID_ALUMNO",
        "NOMBRE",
        "DNI",
        "SEG_SOCIAL",
        "METODO"
    }, 0);
    private JFrame frame;

    public VntBolsa(JFrame vntPrincipal) {
        initComponents();
        cargaTabla();
        cargaBolsa();
        cargarMetodos();
        frame = vntPrincipal;
        txtDNIAlumno.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });
        txtIDBolsa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });
        txtIDAl.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });
        txtNombreAlumno.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
                }
            }
        });

    }

    private void cargarMetodos() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Seleccione un método");
        model.addElement("Beca");
        model.addElement("Trabajador");
        cbMetodo.setModel(model);
        cbMetodo.setSelectedIndex(0);
    }

    public void cargaTabla() {
        dtm.setRowCount(0);
        List<Bolsa> listaBolsa = new BolsaDAO().obtenListaBolsa();
        for (Bolsa bolsa : listaBolsa) {
            if (bolsa.getIdBolsa() != null && bolsa.getIdBolsa() > 0) {

                Alumnos alumno = new AlumnosDAO().obtenAlumnosPorID(bolsa.getAlumnos().getIdAlumno());

                if (alumno != null && alumno.getIdAlumno() > 0) {
                    int iD_bolsa = bolsa.getIdBolsa();
                    int idAl = alumno.getIdAlumno();
                    String nombre = alumno.getNombreAlumno();
                    String dni = alumno.getDniAlumno();
                    int ss = alumno.getSegSocialAlumno();
                    String metodo = evaluaMetodo(bolsa.getBeca(), bolsa.getBolsa());

                    dtm.addRow(new Object[]{
                        iD_bolsa,
                        idAl,
                        nombre,
                        dni,
                        ss,
                        metodo
                    });
                }
            }
        }
    }

    public void cargaBolsa() {
        TablaBolsa.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filas = TablaBolsa.getSelectedRow();
                    if (filas != -1) {
                        txtIDBolsa.setText(TablaBolsa.getValueAt(filas, 0) + "");
                        txtIDAl.setText(TablaBolsa.getValueAt(filas, 1) + "");
                        txtNombreAlumno.setText(TablaBolsa.getValueAt(filas, 2) + "");
                        txtDNIAlumno.setText(TablaBolsa.getValueAt(filas, 3) + "");
                        txtSegSocial.setText(TablaBolsa.getValueAt(filas, 4) + "");
                        cbMetodo.setSelectedItem(TablaBolsa.getValueAt(filas, 5));

                        txtNombreAlumno.setEditable(true);
                        txtDNIAlumno.setEditable(true);
                        txtIDAl.setEditable(true);
                        txtSegSocial.setEditable(true);
                        cbMetodo.setEditable(true);
                        btnActualizar.setEnabled(true);
                        btnBorrar.setEnabled(true);
                    } else {
                        txtNombreAlumno.setEditable(false);
                        txtDNIAlumno.setEditable(false);
                        txtIDAl.setEditable(false);
                        txtSegSocial.setEditable(false);
                        cbMetodo.setEditable(false);

                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TablaBolsa = new javax.swing.JTable();
        title1 = new javax.swing.JLabel();
        userLabel1 = new javax.swing.JLabel();
        txtNombreAlumno = new javax.swing.JTextField();
        userLabel2 = new javax.swing.JLabel();
        txtDNIAlumno = new javax.swing.JTextField();
        userLabel3 = new javax.swing.JLabel();
        txtIDAl = new javax.swing.JTextField();
        userLabel4 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        txtSegSocial = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        userLabel6 = new javax.swing.JLabel();
        txtIDBolsa = new javax.swing.JTextField();
        cbMetodo = new javax.swing.JComboBox<>();

        TablaBolsa.setModel(dtm);
        TablaBolsa.setToolTipText("");
        jScrollPane2.setViewportView(TablaBolsa);

        title1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("BOLSA DE TRABAJO");

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
        userLabel2.setText("DNI");

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

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setText("ID Alumno");

        txtIDAl.setEditable(false);
        txtIDAl.setBackground(new java.awt.Color(0, 0, 0));
        txtIDAl.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDAl.setForeground(new java.awt.Color(255, 255, 255));
        txtIDAl.setBorder(null);
        txtIDAl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDAlMousePressed(evt);
            }
        });

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setText("Metodo");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("Seg. Social");

        txtSegSocial.setEditable(false);
        txtSegSocial.setBackground(new java.awt.Color(0, 0, 0));
        txtSegSocial.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtSegSocial.setForeground(new java.awt.Color(255, 255, 255));
        txtSegSocial.setBorder(null);
        txtSegSocial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtSegSocialMousePressed(evt);
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

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("ID Bolsa");

        txtIDBolsa.setEditable(false);
        txtIDBolsa.setBackground(new java.awt.Color(0, 0, 0));
        txtIDBolsa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDBolsa.setForeground(new java.awt.Color(255, 255, 255));
        txtIDBolsa.setBorder(null);
        txtIDBolsa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDBolsaMousePressed(evt);
            }
        });

        cbMetodo.setBackground(new java.awt.Color(0, 0, 0));
        cbMetodo.setForeground(new java.awt.Color(255, 255, 255));
        cbMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione metodo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(492, 492, 492))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDBolsa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(userLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDNIAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtIDAl, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBorrar))
                                .addComponent(txtSegSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDBolsa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDAl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDNIAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSegSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAlumnoMousePressed

    private void txtDNIAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDNIAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIAlumnoMousePressed

    private void txtIDAlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDAlMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDAlMousePressed

    private void txtSegSocialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSegSocialMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegSocialMousePressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtIDBolsa.getText() != null && !txtIDBolsa.getText().isEmpty()) {
            int idBolsa = Integer.parseInt(txtIDBolsa.getText());
            Bolsa bolsa = new BolsaDAO().obtenBolsaPorID(idBolsa);
            if (bolsa != null) {
                String selectedMetodo = (String) cbMetodo.getSelectedItem();
                boolean isBeca = selectedMetodo.equals("Beca");
                boolean isTrabajador = selectedMetodo.equals("Trabajador");
                bolsa.setBeca(isBeca);
                bolsa.setBolsa(isTrabajador);
                new BolsaDAO().actualizaBolsa(bolsa, frame);
                cargaTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la Bolsa con ID: " + idBolsa, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una Bolsa para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (txtIDBolsa.getText() != null) {
            new BolsaDAO().eliminaBolsa(txtIDBolsa.getText(), frame);
            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtDNIAlumno, "Seleciona un Alumno de la Bolsa", "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargaTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtIDBolsaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDBolsaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDBolsaMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaBolsa;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JComboBox<String> cbMetodo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField txtDNIAlumno;
    private javax.swing.JTextField txtIDAl;
    private javax.swing.JTextField txtIDBolsa;
    private javax.swing.JTextField txtNombreAlumno;
    private javax.swing.JTextField txtSegSocial;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel4;
    private javax.swing.JLabel userLabel5;
    private javax.swing.JLabel userLabel6;
    // End of variables declaration//GEN-END:variables

    private String evaluaMetodo(Boolean beca, Boolean bolsa) {
        if (beca != null && beca) {
            return "Beca";
        } else if (bolsa != null && bolsa) {
            return "Trabajador";
        } else {
            return "Sin método";
        }
    }
}
