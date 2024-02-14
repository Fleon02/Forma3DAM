package vista;

import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.AlumnosDAO;

public class VntAlumnos extends javax.swing.JFrame {

    int xMouse, yMouse;

    public VntAlumnos() {
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        txtDNIAlumno = new javax.swing.JTextField();
        userLabel1 = new javax.swing.JLabel();
        txtNombreAlumno = new javax.swing.JTextField();
        userLabel2 = new javax.swing.JLabel();
        txtAnioAlumno = new javax.swing.JTextField();
        userLabel3 = new javax.swing.JLabel();
        txtNSSAlumno = new javax.swing.JTextField();
        userLabel4 = new javax.swing.JLabel();
        txtCVAlumno = new javax.swing.JTextField();
        userLabel5 = new javax.swing.JLabel();
        checkbValidez = new javax.swing.JCheckBox();
        btnSubirCV = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        txtCicloAlumno = new javax.swing.JTextField();

        jButton2.setBackground(new java.awt.Color(18, 30, 49));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setText("Subir Curriculum");

        jButton4.setBackground(new java.awt.Color(18, 30, 49));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton4.setText("Subir Curriculum");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Forma3");
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 800, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 40));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png"))); // NOI18N
        bg.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 160, 70));

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("INSERTAR ALUMNO");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 250, 40));

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setText("DNI Alumno");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 150, 30));

        txtDNIAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtDNIAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDNIAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtDNIAlumno.setBorder(null);
        txtDNIAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDNIAlumnoMousePressed(evt);
            }
        });
        bg.add(txtDNIAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 230, 30));

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setForeground(new java.awt.Color(0, 0, 0));
        userLabel1.setText("Nombre Alumno");
        bg.add(userLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 150, 30));

        txtNombreAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtNombreAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombreAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreAlumno.setBorder(null);
        txtNombreAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreAlumnoMousePressed(evt);
            }
        });
        bg.add(txtNombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 230, 30));

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setForeground(new java.awt.Color(0, 0, 0));
        userLabel2.setText("Año Alumno");
        bg.add(userLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 150, 30));

        txtAnioAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtAnioAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtAnioAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtAnioAlumno.setBorder(null);
        txtAnioAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtAnioAlumnoMousePressed(evt);
            }
        });
        bg.add(txtAnioAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 230, 30));

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setForeground(new java.awt.Color(0, 0, 0));
        userLabel3.setText("N. S. S. Alumno");
        bg.add(userLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 150, 30));

        txtNSSAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtNSSAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNSSAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtNSSAlumno.setBorder(null);
        txtNSSAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNSSAlumnoMousePressed(evt);
            }
        });
        bg.add(txtNSSAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 230, 30));

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setForeground(new java.awt.Color(0, 0, 0));
        userLabel4.setText("Ciclo Alumno");
        bg.add(userLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 150, 30));

        txtCVAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtCVAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCVAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtCVAlumno.setBorder(null);
        txtCVAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCVAlumnoMousePressed(evt);
            }
        });
        bg.add(txtCVAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 140, 30));

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setForeground(new java.awt.Color(0, 0, 0));
        userLabel5.setText("Curriculum Alumno");
        bg.add(userLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 150, 30));

        checkbValidez.setBackground(new java.awt.Color(255, 255, 255));
        checkbValidez.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkbValidez.setForeground(new java.awt.Color(0, 0, 0));
        checkbValidez.setText("Validez (Aprobado)");
        bg.add(checkbValidez, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, -1, -1));

        btnSubirCV.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirCV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirCV.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirCV.setText("Subir");
        bg.add(btnSubirCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 90, 30));

        btnInsertar.setBackground(new java.awt.Color(18, 30, 49));
        btnInsertar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        bg.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 120, 40));

        txtCicloAlumno.setBackground(new java.awt.Color(0, 0, 0));
        txtCicloAlumno.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCicloAlumno.setForeground(new java.awt.Color(255, 255, 255));
        txtCicloAlumno.setBorder(null);
        txtCicloAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCicloAlumnoMousePressed(evt);
            }
        });
        bg.add(txtCicloAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 230, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

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

    private void txtCVAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCVAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCVAlumnoMousePressed

    private void txtCicloAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCicloAlumnoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCicloAlumnoMousePressed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (txtDNIAlumno.getText() != "" && txtNombreAlumno.getText() != "" && txtAnioAlumno.getText() != ""
                && txtNSSAlumno.getText() != "" && txtCicloAlumno.getText() != "" && txtCVAlumno.getText() != "") {
            if (checkbValidez.isSelected()) {
                new AlumnosDAO().guardaAlumnos(txtDNIAlumno.getText(), txtNombreAlumno.getText(), txtAnioAlumno.getText(),
                        txtNSSAlumno.getText(), 1, txtCicloAlumno.getText(), txtCVAlumno.getText());
                JOptionPane.showMessageDialog(txtDNIAlumno, "Selecionado", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new AlumnosDAO().guardaAlumnos(txtDNIAlumno.getText(), txtNombreAlumno.getText(), txtAnioAlumno.getText(),
                        txtNSSAlumno.getText(), 0, txtCicloAlumno.getText(), txtCVAlumno.getText());
                JOptionPane.showMessageDialog(txtDNIAlumno, "No Selecionado", "Error", JOptionPane.ERROR_MESSAGE);
            }
            new VntAlumno().cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtDNIAlumno, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnSubirCV;
    private javax.swing.JCheckBox checkbValidez;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JLabel favicon;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtAnioAlumno;
    private javax.swing.JTextField txtCVAlumno;
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
