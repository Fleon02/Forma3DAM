package vista;

import java.awt.Color;

public class VntAlumnos extends javax.swing.JFrame {

    int xMouse, yMouse;

    public VntAlumnos() {
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        txtdniAlumnos = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtdniAlumno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        userLabel1 = new javax.swing.JLabel();
        txtdniAlumnos1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        userLabel2 = new javax.swing.JLabel();
        txtdniAlumnos2 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        userLabel3 = new javax.swing.JLabel();
        txtdniAlumnos3 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        userLabel4 = new javax.swing.JLabel();
        txtdniAlumnos4 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        userLabel5 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        btnBorrar = new javax.swing.JButton();
        btnSubirCV = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnInsertar1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

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
        title.setText("ALUMNOS");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setText("DNI Alumno");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 150, 30));

        txtdniAlumnos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtdniAlumnos.setForeground(new java.awt.Color(204, 204, 204));
        txtdniAlumnos.setBorder(null);
        txtdniAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtdniAlumnosMousePressed(evt);
            }
        });
        bg.add(txtdniAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 240, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 240, 20));

        jLabel1.setText("DNI Alumno");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtdniAlumno.setToolTipText("");
        txtdniAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniAlumnoActionPerformed(evt);
            }
        });
        bg.add(txtdniAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setText("Curriculum Alumno");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setText("DNI Alumno");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setText("Nombre Alumno");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setText("Año Alumno");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel5.setText("N. S. S. Alumno");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setText("Ciclo Alumno");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 180, 550, 350));

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setForeground(new java.awt.Color(0, 0, 0));
        userLabel1.setText("Nombre Alumno");
        bg.add(userLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 150, 30));

        txtdniAlumnos1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtdniAlumnos1.setForeground(new java.awt.Color(204, 204, 204));
        txtdniAlumnos1.setBorder(null);
        txtdniAlumnos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtdniAlumnos1MousePressed(evt);
            }
        });
        bg.add(txtdniAlumnos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 240, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 240, 20));

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setForeground(new java.awt.Color(0, 0, 0));
        userLabel2.setText("Año Alumno");
        bg.add(userLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 150, 30));

        txtdniAlumnos2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtdniAlumnos2.setForeground(new java.awt.Color(204, 204, 204));
        txtdniAlumnos2.setBorder(null);
        txtdniAlumnos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtdniAlumnos2MousePressed(evt);
            }
        });
        bg.add(txtdniAlumnos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 240, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 240, 20));

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setForeground(new java.awt.Color(0, 0, 0));
        userLabel3.setText("N. S. S. Alumno");
        bg.add(userLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 150, 30));

        txtdniAlumnos3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtdniAlumnos3.setForeground(new java.awt.Color(204, 204, 204));
        txtdniAlumnos3.setBorder(null);
        txtdniAlumnos3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtdniAlumnos3MousePressed(evt);
            }
        });
        bg.add(txtdniAlumnos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 240, 240, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, 240, 20));

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setForeground(new java.awt.Color(0, 0, 0));
        userLabel4.setText("Ciclo Alumno");
        bg.add(userLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 150, 30));

        txtdniAlumnos4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtdniAlumnos4.setForeground(new java.awt.Color(204, 204, 204));
        txtdniAlumnos4.setBorder(null);
        txtdniAlumnos4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtdniAlumnos4MousePressed(evt);
            }
        });
        bg.add(txtdniAlumnos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 240, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, 240, 20));

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setForeground(new java.awt.Color(0, 0, 0));
        userLabel5.setText("Curriculum Alumno");
        bg.add(userLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 150, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, 240, 20));

        btnBorrar.setBackground(new java.awt.Color(18, 30, 49));
        btnBorrar.setForeground(new java.awt.Color(204, 204, 204));
        btnBorrar.setText("Borrar");
        bg.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 440, 120, 30));

        btnSubirCV.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirCV.setForeground(new java.awt.Color(204, 204, 204));
        btnSubirCV.setText("Subir Curriculum");
        bg.add(btnSubirCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, 240, 30));

        btnInsertar.setBackground(new java.awt.Color(18, 30, 49));
        btnInsertar.setForeground(new java.awt.Color(204, 204, 204));
        btnInsertar.setText("Insertar");
        bg.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 120, 30));

        btnActualizar.setBackground(new java.awt.Color(18, 30, 49));
        btnActualizar.setForeground(new java.awt.Color(204, 204, 204));
        btnActualizar.setText("Actualizar");
        bg.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, 120, 30));

        btnInsertar1.setBackground(new java.awt.Color(18, 30, 49));
        btnInsertar1.setForeground(new java.awt.Color(204, 204, 204));
        btnInsertar1.setText("Insertar");
        bg.add(btnInsertar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 120, 30));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setText("Validez (Aprobado)");
        bg.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1086, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtdniAlumnosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdniAlumnosMousePressed
        if (txtdniAlumnos.getText().equals("Ingrese su nombre de usuario")) {
            txtdniAlumnos.setText("");
            txtdniAlumnos.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtdniAlumnosMousePressed

    private void txtdniAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniAlumnoActionPerformed

    private void txtdniAlumnos1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdniAlumnos1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniAlumnos1MousePressed

    private void txtdniAlumnos2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdniAlumnos2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniAlumnos2MousePressed

    private void txtdniAlumnos3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdniAlumnos3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniAlumnos3MousePressed

    private void txtdniAlumnos4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdniAlumnos4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniAlumnos4MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnInsertar1;
    private javax.swing.JButton btnSubirCV;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JLabel favicon;
    private javax.swing.JPanel header;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtdniAlumno;
    private javax.swing.JTextField txtdniAlumnos;
    private javax.swing.JTextField txtdniAlumnos1;
    private javax.swing.JTextField txtdniAlumnos2;
    private javax.swing.JTextField txtdniAlumnos3;
    private javax.swing.JTextField txtdniAlumnos4;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel4;
    private javax.swing.JLabel userLabel5;
    // End of variables declaration//GEN-END:variables
}
