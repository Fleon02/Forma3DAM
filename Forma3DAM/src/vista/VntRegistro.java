package vista;

import java.awt.Color;
import java.util.Map;
import modelo.LoginDAO;
import modelo.PasswordEncoder;
import pojos.Login;

public class VntRegistro extends javax.swing.JFrame {

    int xMouse, yMouse;

    public VntRegistro() {
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png")).getImage());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        registroBtn = new javax.swing.JPanel();
        registroBtnTxt = new javax.swing.JLabel();
        cancelarBtn = new javax.swing.JPanel();
        cancelarBtnTxt = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        userTxt1 = new javax.swing.JTextField();
        userLabel1 = new javax.swing.JLabel();

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

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 40));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png"))); // NOI18N
        bg.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 60, 70));

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setText("REGISTRO");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        emailLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        emailLabel.setText("EMAIL");
        bg.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        emailTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(204, 204, 204));
        emailTxt.setText("Ingrese su correo electrónico");
        emailTxt.setBorder(null);
        emailTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                emailTxtMousePressed(evt);
            }
        });
        bg.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 410, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 410, 20));

        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        bg.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 410, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 410, 20));

        registroBtn.setBackground(new java.awt.Color(255, 51, 51));

        registroBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        registroBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registroBtnTxt.setText("REGISTRARSE");
        registroBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registroBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registroBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registroBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registroBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout registroBtnLayout = new javax.swing.GroupLayout(registroBtn);
        registroBtn.setLayout(registroBtnLayout);
        registroBtnLayout.setHorizontalGroup(
            registroBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registroBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        registroBtnLayout.setVerticalGroup(
            registroBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registroBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(registroBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 130, 40));

        cancelarBtn.setBackground(new java.awt.Color(255, 51, 51));

        cancelarBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        cancelarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelarBtnTxt.setText("CANCELAR");
        cancelarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelarBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelarBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelarBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout cancelarBtnLayout = new javax.swing.GroupLayout(cancelarBtn);
        cancelarBtn.setLayout(cancelarBtnLayout);
        cancelarBtnLayout.setHorizontalGroup(
            cancelarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        cancelarBtnLayout.setVerticalGroup(
            cancelarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(cancelarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 130, 40));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 410, 20));

        userTxt1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt1.setForeground(new java.awt.Color(204, 204, 204));
        userTxt1.setText("Ingrese su nombre de usuario");
        userTxt1.setBorder(null);
        userTxt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxt1MousePressed(evt);
            }
        });
        bg.add(userTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 410, 30));

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("NOMBRE");
        bg.add(userLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void registroBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroBtnTxtMouseEntered
        registroBtn.setBackground(Color.BLACK);
        registroBtnTxt.setForeground(Color.WHITE);
    }//GEN-LAST:event_registroBtnTxtMouseEntered

    private void registroBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroBtnTxtMouseExited
        registroBtn.setBackground(new Color(255, 51, 51)); // Restaurar el color original del botón
        registroBtnTxt.setForeground(Color.BLACK); // Restaurar el color original del texto
    }//GEN-LAST:event_registroBtnTxtMouseExited

    private void emailTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailTxtMousePressed
        if (emailTxt.getText().equals("Ingrese su correo electrónico")) {
            emailTxt.setText("");
            emailTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_emailTxtMousePressed

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if (emailTxt.getText().isEmpty()) {
            emailTxt.setText("Ingrese su correo electrónico");
            emailTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passTxtMousePressed

    private void registroBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroBtnTxtMouseClicked
        String nombre = userTxt1.getText();
        String email = emailTxt.getText();
        String pass = String.valueOf(passTxt.getPassword());
        String salt = PasswordEncoder.generateSalt();
        System.out.println(salt);
        
        String hashContrasena = PasswordEncoder.encodePassword(pass, salt);
        
        

        // Crear una instancia de la clase LoginDAO
        LoginDAO loginDAO = new LoginDAO();

        // Crear un nuevo objeto Login con los datos proporcionados por el usuario
        Login nuevoUsuario = new Login(nombre, email, "Trabajador", null); // El beep se asociará dentro del método

//         Llamar al método registrarUsuario con el usuario y la contraseña
        boolean registro = loginDAO.registrarUsuario(nuevoUsuario, hashContrasena, salt);
        if (registro) {
            VntLogin l  = new VntLogin();
            l.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_registroBtnTxtMouseClicked

    private void cancelarBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarBtnTxtMouseClicked
        VntLogin l = new VntLogin();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelarBtnTxtMouseClicked

    private void cancelarBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarBtnTxtMouseEntered
        cancelarBtn.setBackground(Color.BLACK);
        cancelarBtnTxt.setForeground(Color.WHITE);
    }//GEN-LAST:event_cancelarBtnTxtMouseEntered

    private void cancelarBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarBtnTxtMouseExited
        cancelarBtn.setBackground(new Color(255, 51, 51)); // Restaurar el color original del botón
        cancelarBtnTxt.setForeground(Color.BLACK); // Restaurar el color original del texto
    }//GEN-LAST:event_cancelarBtnTxtMouseExited

    private void userTxt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt1MousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel cancelarBtn;
    private javax.swing.JLabel cancelarBtnTxt;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel favicon;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JPanel registroBtn;
    private javax.swing.JLabel registroBtnTxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JTextField userTxt1;
    // End of variables declaration//GEN-END:variables
}
