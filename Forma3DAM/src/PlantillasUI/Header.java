package PlantillasUI;

import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import vista.VntLogin;
import vista.VntPrincipal;

public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
    }

    public void addEventoMenu(ActionListener evento) {
        cmdMenu.addActionListener(evento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new PlantillasUI.Button();
        lbNombre = new javax.swing.JLabel();
        lbRol = new javax.swing.JLabel();
        btnCerrarSesion = new PlantillasUI.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); // NOI18N

        lbNombre.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(127, 127, 127));
        lbNombre.setText("Usuario");

        lbRol.setForeground(new java.awt.Color(127, 127, 127));
        lbRol.setText("Rol");

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/loginn.png"))); // NOI18N
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 490, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNombre)
                    .addComponent(lbRol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbRol)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        VntLogin l = new VntLogin();
        l.setVisible(true);
        SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    public void setDatosUsuario(String nombre, String rol) {
        lbNombre.setText(nombre);
        lbRol.setText(rol);
    }

    public String[] getDatosUsuario() {
        String nombre = lbNombre.getText();
        String rol = lbRol.getText();
        String[] datos = {nombre, rol};

        return datos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PlantillasUI.Button btnCerrarSesion;
    private PlantillasUI.Button cmdMenu;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbRol;
    // End of variables declaration//GEN-END:variables
}
