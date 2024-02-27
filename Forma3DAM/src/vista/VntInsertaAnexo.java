package vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.AlumnosDAO;
import modelo.AnexosDAO;
import modelo.ConvenioDAO;
import modelo.EmpresasDAO;
import org.hibernate.HibernateException;
import pojos.Alumnos;
import pojos.Anexos;
import pojos.Convenio;
import pojos.Empresas;
import pojos.Necesidad;

public class VntInsertaAnexo extends javax.swing.JPanel {

    private byte[] bytes2_1;
    private byte[] bytes2_2;
    private byte[] bytes3;
    private byte[] bytes4;
    private byte[] bytes8;

    public VntInsertaAnexo() {
        initComponents();
        cargarCIFEmpresas();
        cargarIDNecesidad();
        btnInsertar.setEnabled(false);
        cmbEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbEmpresa.getSelectedIndex() == 0) {
                    // Si se selecciona el primer elemento, desactivar el botón Insertar
                    btnInsertar.setEnabled(false);
                } else {
                    // Si se selecciona otro elemento, activar el botón Insertar
                    btnInsertar.setEnabled(true);
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
        cmbEmpresa.setModel(model);
        cmbEmpresa.setRenderer(new EmpresasComboBoxRenderer());
    }

    private void cargarIDNecesidad() {
        AnexosDAO ad = new AnexosDAO();
        List<Necesidad> listaNecesidad = ad.obtenListaNecesidad();
        DefaultComboBoxModel<Necesidad> model = new DefaultComboBoxModel<>();
        model.addElement(new Necesidad(null)); // Opción por defecto
        for (Necesidad n : listaNecesidad) {
            model.addElement(n);
        }
        cmbNecesidad.setModel(model);
        cmbNecesidad.setRenderer(new NecesidadComboBoxRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        favicon = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userLabel1 = new javax.swing.JLabel();
        userLabel2 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        btnSubirA2_1 = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        nombreArchivo2_1 = new javax.swing.JLabel();
        cmbEmpresa = new javax.swing.JComboBox<>();
        ckbContratacion = new javax.swing.JCheckBox();
        userLabel6 = new javax.swing.JLabel();
        nombreArchivo3 = new javax.swing.JLabel();
        btnSubirA3 = new javax.swing.JButton();
        userLabel7 = new javax.swing.JLabel();
        nombreArchivo4 = new javax.swing.JLabel();
        btnSubirA4 = new javax.swing.JButton();
        userLabel8 = new javax.swing.JLabel();
        nombreArchivo8 = new javax.swing.JLabel();
        btnSubirA8 = new javax.swing.JButton();
        userLabel9 = new javax.swing.JLabel();
        nombreArchivo2_2 = new javax.swing.JLabel();
        btnSubirA2_2 = new javax.swing.JButton();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        fechaFin = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        cmbNecesidad = new javax.swing.JComboBox<>();
        userLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1078, 608));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Forma3.png"))); // NOI18N

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("FechaInicio");

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("Necesidad");

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setText("FechaFin");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("Anexo 2.1");

        btnSubirA2_1.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA2_1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA2_1.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA2_1.setText("Subir CV");
        btnSubirA2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA2_1ActionPerformed(evt);
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

        nombreArchivo2_1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo2_1.setText("Archivo");

        cmbEmpresa.setBackground(new java.awt.Color(0, 0, 0));
        cmbEmpresa.setForeground(new java.awt.Color(255, 255, 255));

        ckbContratacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckbContratacion.setText("Contratacion");
        ckbContratacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbContratacionActionPerformed(evt);
            }
        });

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("Anexo 3");

        nombreArchivo3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo3.setText("Archivo");

        btnSubirA3.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA3.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA3.setText("Subir CV");
        btnSubirA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA3ActionPerformed(evt);
            }
        });

        userLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel7.setText("Anexo 4");

        nombreArchivo4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo4.setText("Archivo");

        btnSubirA4.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA4.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA4.setText("Subir CV");
        btnSubirA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA4ActionPerformed(evt);
            }
        });

        userLabel8.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel8.setText("Anexo 8");

        nombreArchivo8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo8.setText("Archivo");

        btnSubirA8.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA8.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA8.setText("Subir CV");
        btnSubirA8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA8ActionPerformed(evt);
            }
        });

        userLabel9.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel9.setText("Anexo 2.2");

        nombreArchivo2_2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo2_2.setText("Archivo");

        btnSubirA2_2.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA2_2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA2_2.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA2_2.setText("Subir CV");
        btnSubirA2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA2_2ActionPerformed(evt);
            }
        });

        cmbNecesidad.setBackground(new java.awt.Color(0, 0, 0));
        cmbNecesidad.setForeground(new java.awt.Color(255, 255, 255));

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setText("TutorPracticas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(favicon))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(58, 58, 58)
                                        .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nombreArchivo8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSubirA8))
                                    .addComponent(cmbEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ckbContratacion)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nombreArchivo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSubirA2_1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nombreArchivo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSubirA2_2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbNecesidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreArchivo4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubirA4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreArchivo3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubirA3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(333, 333, 333))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNecesidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ckbContratacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        AnexosDAO ad = new AnexosDAO();
        EmpresasDAO ed = new EmpresasDAO();
        byte[] anexoDosUnoConvenio = bytes2_1; // Obtener los bytes del anexo 2.1
        byte[] anexoDosDosConvenio = bytes2_2; // Obtener los bytes del anexo 2.2
        byte[] anexoTresConvenio = bytes3;   // Obtener los bytes del anexo 3
        byte[] anexoCuatroConvenio = bytes4; // Obtener los bytes del anexo 4
        byte[] anexoOchoConvenio = bytes8;   // Obtener los bytes del anexo 8

        Date fechaDate = fechaInicio.getDate();
        Date fechaFinDate = fechaFin.getDate();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");

        String fechaFormateada = formatoFecha.format(fechaDate);
        String fechaFinFormateada = formatoFecha.format(fechaFinDate);

        SimpleDateFormat formatoMes = new SimpleDateFormat("MMMM", new Locale("es", "ES"));

        String calendario = formatoMes.format(fechaDate); // Obtener el nombre del mes

        boolean contratacion = ckbContratacion.isSelected();
        
        Empresas e = new Empresas();
        
        e = (Empresas)cmbEmpresa.getSelectedItem();
        
        Necesidad n = new Necesidad();
        
        n = (Necesidad) cmbNecesidad.getSelectedItem();
        
        Anexos a = new Anexos();
        
        a.setEmpresas(e);
        a.setNecesidad(n);
        a.setFechaInicio(fechaFormateada);
        a.setFechaFin(fechaFinFormateada);
        a.setContratacion(contratacion);
        a.setCalendario(calendario);
        a.setAnexoDosUno(anexoDosUnoConvenio);
        a.setAnexoDosDos(anexoDosDosConvenio);
        a.setAnexoTres(anexoTresConvenio);
        a.setAnexoCuatro(anexoCuatroConvenio);
        a.setAnexoOcho(anexoOchoConvenio);

        System.out.println("Objeto Anexos creado: " + a.toString());
        
        ad.guardaAnexo(a);

    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnSubirA2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA2_1ActionPerformed
        subirArchivo("anexo2_1");
    }//GEN-LAST:event_btnSubirA2_1ActionPerformed

    private void ckbContratacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbContratacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbContratacionActionPerformed

    private void btnSubirA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA3ActionPerformed
        subirArchivo("anexo3");
    }//GEN-LAST:event_btnSubirA3ActionPerformed

    private void btnSubirA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA4ActionPerformed
        subirArchivo("anexo4");
    }//GEN-LAST:event_btnSubirA4ActionPerformed

    private void btnSubirA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA8ActionPerformed
        subirArchivo("anexo8");
    }//GEN-LAST:event_btnSubirA8ActionPerformed

    private void btnSubirA2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA2_2ActionPerformed
        subirArchivo("anexo2_2");
    }//GEN-LAST:event_btnSubirA2_2ActionPerformed

    private void subirArchivo(String tipoAnexo) {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                byte[] bytesArchivo = convertirArchivoABytes(archivo);
                // Asignar los bytes al campo correspondiente según el tipo de anexo
                switch (tipoAnexo) {
                    case "anexo2_1":
                        bytes2_1 = bytesArchivo;
                        break;
                    case "anexo2_2":
                        bytes2_2 = bytesArchivo;
                        break;
                    case "anexo3":
                        bytes3 = bytesArchivo;
                        break;
                    case "anexo4":
                        bytes4 = bytesArchivo;
                        break;
                    case "anexo8":
                        bytes8 = bytesArchivo;
                        break;
                    default:
                        break;
                }
                // Actualizar el nombre del archivo en la interfaz gráfica
                actualizarNombreArchivo(tipoAnexo, archivo.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void actualizarNombreArchivo(String tipoAnexo, String nombreArchivo) {
        switch (tipoAnexo) {
            case "anexo2_1":
                nombreArchivo2_1.setText(nombreArchivo);
                break;
            case "anexo2_2":
                nombreArchivo2_2.setText(nombreArchivo);
                break;
            case "anexo3":
                nombreArchivo3.setText(nombreArchivo);
                break;
            case "anexo4":
                nombreArchivo4.setText(nombreArchivo);
                break;
            case "anexo8":
                nombreArchivo8.setText(nombreArchivo);
                break;
            default:
                break;
        }
    }

    private byte[] convertirArchivoABytes(File archivo) throws IOException {
        byte[] bytesArray = new byte[(int) archivo.length()];
        FileInputStream fis = new FileInputStream(archivo);
        fis.read(bytesArray);
        fis.close();
        return bytesArray;
    }

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
                    setText(empresa.getNombreEmpresa() + " -  " + empresa.getTutorPracticas());
                }
            }
            return this;
        }
    }

    // Clase EmpresasComboBoxRenderer como clase interna estática
    private static class NecesidadComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Necesidad) {
                Necesidad Necesidad = (Necesidad) value;
                if (Necesidad.getIdNecesidad() == null) {
                    setText("Seleccione un ID Necesidad");
                } else {
                    setText(Necesidad.getIdNecesidad() + "");
                }
            }
            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnSubirA2_1;
    private javax.swing.JButton btnSubirA2_2;
    private javax.swing.JButton btnSubirA3;
    private javax.swing.JButton btnSubirA4;
    private javax.swing.JButton btnSubirA8;
    private javax.swing.JCheckBox ckbContratacion;
    private javax.swing.JComboBox<Empresas
    > cmbEmpresa;
    private javax.swing.JComboBox<Necesidad> cmbNecesidad;
    private javax.swing.JLabel favicon;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel nombreArchivo2_1;
    private javax.swing.JLabel nombreArchivo2_2;
    private javax.swing.JLabel nombreArchivo3;
    private javax.swing.JLabel nombreArchivo4;
    private javax.swing.JLabel nombreArchivo8;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel5;
    private javax.swing.JLabel userLabel6;
    private javax.swing.JLabel userLabel7;
    private javax.swing.JLabel userLabel8;
    private javax.swing.JLabel userLabel9;
    // End of variables declaration//GEN-END:variables
}
