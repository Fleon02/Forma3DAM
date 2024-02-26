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

public class VntInsertaConvenio extends javax.swing.JPanel {

    private byte[] bytesCV;

    public VntInsertaConvenio() {
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
        txtCantidadAnexos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                    e.consume(); // No permite la entrada de caracteres que no sean números
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
        userLabel3 = new javax.swing.JLabel();
        txtCantidadAnexos = new javax.swing.JTextField();
        userLabel4 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        btnSubirCV = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        nombreArchivo = new javax.swing.JLabel();
        cmbEmpresas = new javax.swing.JComboBox<>();
        txtResponsable = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1078, 608));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Forma3.png"))); // NOI18N

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("Num Convenio");

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
        userLabel1.setText("Responsable Firma");

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
        userLabel2.setText("CIF Empresa");

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setText("Cantidad Anexos");

        txtCantidadAnexos.setBackground(new java.awt.Color(0, 0, 0));
        txtCantidadAnexos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCantidadAnexos.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidadAnexos.setBorder(null);
        txtCantidadAnexos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCantidadAnexosMousePressed(evt);
            }
        });

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setText("Nombre Empresa");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("Anexo 1");

        btnSubirCV.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirCV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirCV.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirCV.setText("Subir CV");
        btnSubirCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirCVActionPerformed(evt);
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

        nombreArchivo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo.setText("Archivo");

        cmbEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmpresasActionPerformed(evt);
            }
        });

        txtResponsable.setBackground(new java.awt.Color(0, 0, 0));
        txtResponsable.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtResponsable.setForeground(new java.awt.Color(255, 255, 255));
        txtResponsable.setBorder(null);
        txtResponsable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtResponsableMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cmbEmpresas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(69, 69, 69)
                                    .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCantidadAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtNumConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(71, 71, 71)
                                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(favicon)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSubirCV))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(343, 343, 343)))
                .addGap(0, 126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCantidadAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSubirCV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumConvenioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumConvenioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumConvenioMousePressed

    private void txtNEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNEmpresaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNEmpresaMousePressed

    private void txtCantidadAnexosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadAnexosMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadAnexosMousePressed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed

        ConvenioDAO convenioDAO = new ConvenioDAO();
        int numConvenio = Integer.parseInt(txtNumConvenio.getText());
        Empresas selectedEmpresa = (Empresas) cmbEmpresas.getSelectedItem();
        String responsableFirma = txtResponsable.getText();
        Integer cantAnexos = Integer.parseInt(txtCantidadAnexos.getText());
        byte[] anexoUnoConvenio = getBytesCV();

        Convenio convenio = new Convenio();
        // Establecer la empresa seleccionada
        convenio.setEmpresas(selectedEmpresa);
        convenio.setNombreEmpresa(txtNEmpresa.getText());
        convenio.setNumConvenio(numConvenio);
        convenio.setResponsableFirma(responsableFirma);
        convenio.setCantAnexos(cantAnexos);
        convenio.setAnexoUnoConvenio(anexoUnoConvenio);

        convenioDAO.guardaConvenio(convenio);
        JOptionPane.showMessageDialog(null, "Convenio Insertado", "Inserccion con Exitoso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnSubirCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirCVActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                byte[] bytesArchivo = convertirArchivoABytes(archivo);
                bytesCV = bytesArchivo;
                nombreArchivo.setText(archivo.getName());
                nombreArchivo.setToolTipText(archivo.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSubirCVActionPerformed

    private void txtResponsableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResponsableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResponsableMousePressed

    private void txtNEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNEmpresaActionPerformed

    private void cmbEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEmpresasActionPerformed

    private byte[] convertirArchivoABytes(File archivo) throws IOException {
        byte[] bytesArray = new byte[(int) archivo.length()];
        FileInputStream fis = new FileInputStream(archivo);
        fis.read(bytesArray);
        fis.close();
        return bytesArray;
    }

    public byte[] getBytesCV() {
        return bytesCV;
    }

    public void setBytesCV(byte[] bytesCV) {
        this.bytesCV = bytesCV;
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
    private javax.swing.JButton btnSubirCV;
    private javax.swing.JComboBox<Empresas
    > cmbEmpresas;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel nombreArchivo;
    private javax.swing.JTextField txtCantidadAnexos;
    private javax.swing.JTextField txtNEmpresa;
    private javax.swing.JTextField txtNumConvenio;
    private javax.swing.JTextField txtResponsable;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel4;
    private javax.swing.JLabel userLabel5;
    // End of variables declaration//GEN-END:variables
}
