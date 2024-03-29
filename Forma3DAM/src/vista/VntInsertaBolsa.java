package vista;

import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import modelo.AlumnosDAO;
import modelo.BolsaDAO;
import pojos.Alumnos;
import pojos.Bolsa;

public class VntInsertaBolsa extends javax.swing.JPanel {

    public VntInsertaBolsa() {
        initComponents();
        cargarDNIAlumnos();
        cargarMetodos();
    }

    private void cargarMetodos() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Seleccione un método");
        model.addElement("Beca");
        model.addElement("Trabajador");
        cbMetodo.setModel(model);
        cbMetodo.setSelectedIndex(0);
    }

    private void cargarDNIAlumnos() {
        AlumnosDAO aDAO = new AlumnosDAO();
        List<Alumnos> listaAlumnos = aDAO.obtenListaAlumnos();
        DefaultComboBoxModel<Alumnos> model = new DefaultComboBoxModel<>();
        model.addElement(new Alumnos(null)); // Opción por defecto
        for (Alumnos alumno : listaAlumnos) {
            model.addElement(alumno);
        }
        cbAlumnos.setModel(model);
        cbAlumnos.setRenderer(new VntInsertaBolsa.AlumnosComboBoxRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInsertar = new javax.swing.JButton();
        favicon = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userLabel1 = new javax.swing.JLabel();
        cbMetodo = new javax.swing.JComboBox<>();
        cbAlumnos = new javax.swing.JComboBox<>();

        btnInsertar.setBackground(new java.awt.Color(18, 30, 49));
        btnInsertar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Forma3.png"))); // NOI18N

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setText("Alumno");

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setForeground(new java.awt.Color(0, 0, 0));
        userLabel1.setText("Modalidad");

        cbMetodo.setBackground(new java.awt.Color(0, 0, 0));
        cbMetodo.setForeground(new java.awt.Color(255, 255, 255));
        cbMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione metodo" }));

        cbAlumnos.setBackground(new java.awt.Color(0, 0, 0));
        cbAlumnos.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(favicon)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 74, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        Alumnos alumnoSeleccionado = (Alumnos) cbAlumnos.getSelectedItem();
        String modalidadSeleccionada = (String) cbMetodo.getSelectedItem();

        if (alumnoSeleccionado != null && !"beca".equals(modalidadSeleccionada.toLowerCase())) {
            Bolsa b = new Bolsa(alumnoSeleccionado, false, true);
            BolsaDAO bDAO = new BolsaDAO();
            bDAO.guardaEnBolsa(b);
        } else if (alumnoSeleccionado != null && !"trabajador".equals(modalidadSeleccionada.toLowerCase())) {
            Bolsa b = new Bolsa(alumnoSeleccionado, true, false);
            BolsaDAO bDAO = new BolsaDAO();
            bDAO.guardaEnBolsa(b);
        } else if (alumnoSeleccionado != null && !"seleccione un método".equals(modalidadSeleccionada.toLowerCase())) {
            //notificacion de que seleccione
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private static class AlumnosComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Alumnos) {
                Alumnos alumno = (Alumnos) value;
                if (alumno.getDniAlumno() == null) {
                    setText("Seleccione un Alumno");
                } else {
                    setText(alumno.getNombreAlumno() + " -  " + alumno.getDniAlumno());
                }
            }
            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private javax.swing.JComboBox<Alumnos> cbAlumnos;
    private javax.swing.JComboBox<String> cbMetodo;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    // End of variables declaration//GEN-END:variables
}
