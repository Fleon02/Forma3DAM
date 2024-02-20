package vista;

public class VntBienvenido extends javax.swing.JPanel {

    public VntBienvenido(String nombre, String rol) {
        initComponents();
        jLabelB.setText("BIENVENIDO/A A FORMA3");
        jLabelRol.setText(rol);
        jLabelNombre.setText(nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelB = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelRol = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();

        jLabelB.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabelB.setForeground(java.awt.Color.red);
        jLabelB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Forma3.png"))); // NOI18N
        jLabelLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelRol.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabelRol.setForeground(java.awt.Color.red);
        jLabelRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRol.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelNombre.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabelNombre.setForeground(java.awt.Color.red);
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelB, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                        .addComponent(jLabelRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelB, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRol, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelB;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelRol;
    // End of variables declaration//GEN-END:variables
}
