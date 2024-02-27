package vista;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.AnexosDAO;
import modelo.EmpresasDAO;
import modelo.NecesidadDAO;
import pojos.Anexos;
import pojos.Empresas;
import pojos.Necesidad;

public class VntAnexos extends javax.swing.JPanel {

    private byte[] bytes2_1;
    private byte[] bytes2_2;
    private byte[] bytes3;
    private byte[] bytes4;
    private byte[] bytes8;
    private JFrame frame;

    DefaultTableModel dtm = new DefaultTableModel(new Object[]{
        "ID",
        "FechaInicio",
        "FechaFin",
        "IDNecesidad",
        "Tutor",
        "Contratacion",
        "Anexo2.1",
        "Anexo2.2",
        "Anexo3",
        "Anexo4",
        "Anexo8",}, 0);

    public VntAnexos(JFrame vntPrincipal) {
        initComponents();
        frame = vntPrincipal;

        TablaAnexos.setDefaultEditor(Object.class, null);
        cargaTabla();
        cargarCIFEmpresas();
        cargarIDNecesidad();
        cargaAnexos();

    }

    public void cargaTabla() {
        dtm.setRowCount(0);
        List<Anexos> listaAnexos = new AnexosDAO().obtenListaAnexos();
        for (Anexos a : listaAnexos) {
            if (a.getIdAnexo() > 0) {
                String estadoAnexo2_1 = (a.getAnexoDosUno() != null && a.getAnexoDosUno().length > 0) ? "Subido" : "No Subido";
                String estadoAnexo2_2 = (a.getAnexoDosDos() != null && a.getAnexoDosDos().length > 0) ? "Subido" : "No Subido";
                String estadoAnexo3 = (a.getAnexoTres() != null && a.getAnexoTres().length > 0) ? "Subido" : "No Subido";
                String estadoAnexo4 = (a.getAnexoCuatro() != null && a.getAnexoCuatro().length > 0) ? "Subido" : "No Subido";
                String estadoAnexo8 = (a.getAnexoOcho() != null && a.getAnexoOcho().length > 0) ? "Subido" : "No Subido";
                dtm.addRow(new Object[]{
                    a.getIdAnexo(),
                    a.getFechaInicio(),
                    a.getFechaFin(),
                    a.getNecesidad().getIdNecesidad(),
                    a.getEmpresas().getTutorPracticas(),
                    a.getContratacion(),
                    a.getCalendario(),
                    estadoAnexo2_1,
                    estadoAnexo2_2,
                    estadoAnexo3,
                    estadoAnexo4,
                    estadoAnexo8,});
            }

        }
    }

    public void cargaAnexos() {
        TablaAnexos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filas = TablaAnexos.getSelectedRow();
                    if (filas != -1) {
                        EmpresasDAO ed = new EmpresasDAO();
                        NecesidadDAO ned = new NecesidadDAO();
                        String fechaInicioS = TablaAnexos.getValueAt(filas, 1) + "";
                        String fechaFinS = TablaAnexos.getValueAt(filas, 2) + "";
                        String idNecesidad = TablaAnexos.getValueAt(filas, 3) + "";
                        String tutor = TablaAnexos.getValueAt(filas, 4) + "";
                        String contratacion = TablaAnexos.getValueAt(filas, 5) + "";

                        Date fechaInicioTransformada = transformarFecha(fechaInicioS);
                        Date fechaFinTransformada = transformarFecha(fechaFinS);

                        Empresas em = new Empresas();
                        Necesidad n = new Necesidad();

                        em = ed.obtenEmpresaPorTutor(tutor);

                        n = ned.obtenerNecesidadPorId(Integer.parseInt(idNecesidad));
                        System.out.println(em.toString());
                        int idEmpresa = em.getIdEmpresa();
                        int idNece = n.getIdNecesidad();

                        for (int i = 1; i < cmbEmpresa.getItemCount(); i++) {
                            Empresas empresa = (Empresas) cmbEmpresa.getItemAt(i);
                            if (empresa != null && empresa.getIdEmpresa() == idEmpresa) {
                                cmbEmpresa.setSelectedIndex(i);
                                break;
                            }
                        }

                        for (int i = 1; i < cmbNecesidad.getItemCount(); i++) {
                            Necesidad necesidad = (Necesidad) cmbNecesidad.getItemAt(i);
                            if (necesidad != null && necesidad.getIdNecesidad() == idNece) {
                                cmbNecesidad.setSelectedIndex(i);
                                break;
                            }
                        }

                        fechaInicio.setDate(fechaInicioTransformada);
                        fechaFin.setDate(fechaFinTransformada);

                        btnActualizar.setEnabled(true);
                        btnBorrar.setEnabled(true);

                    } else {
                        btnActualizar.setEnabled(false);
                        btnBorrar.setEnabled(false);
                    }
                }
            }
        });

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAnexos = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        title1 = new javax.swing.JLabel();
        userLabel6 = new javax.swing.JLabel();
        nombreArchivo3 = new javax.swing.JLabel();
        btnSubirA3 = new javax.swing.JButton();
        userLabel7 = new javax.swing.JLabel();
        nombreArchivo4 = new javax.swing.JLabel();
        btnSubirA4 = new javax.swing.JButton();
        userLabel9 = new javax.swing.JLabel();
        nombreArchivo2_2 = new javax.swing.JLabel();
        btnSubirA2_2 = new javax.swing.JButton();
        btnSubirA2_1 = new javax.swing.JButton();
        nombreArchivo2_1 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        nombreArchivo8 = new javax.swing.JLabel();
        btnSubirA8 = new javax.swing.JButton();
        userLabel8 = new javax.swing.JLabel();
        ckbContratacion = new javax.swing.JCheckBox();
        userLabel = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        userLabel2 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();
        userLabel3 = new javax.swing.JLabel();
        cmbEmpresa = new javax.swing.JComboBox<>();
        userLabel1 = new javax.swing.JLabel();
        cmbNecesidad = new javax.swing.JComboBox<>();

        jTableAlumnos.setModel(dtm);
        jScrollPane1.setViewportView(jTableAlumnos);

        setAlignmentX(0.0F);

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png"))); // NOI18N

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Actualizar/Borrar");

        TablaAnexos.setModel(dtm);
        jScrollPane2.setViewportView(TablaAnexos);

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

        title1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Anexos");

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

        btnSubirA2_1.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirA2_1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirA2_1.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirA2_1.setText("Subir CV");
        btnSubirA2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirA2_1ActionPerformed(evt);
            }
        });

        nombreArchivo2_1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivo2_1.setText("Archivo");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("Anexo 2.1");

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

        userLabel8.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel8.setText("Anexo 8");

        ckbContratacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckbContratacion.setText("Contratacion");
        ckbContratacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbContratacionActionPerformed(evt);
            }
        });

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("FechaInicio");

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setText("FechaFin");

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setText("TutorPracticas");

        cmbEmpresa.setBackground(new java.awt.Color(0, 0, 0));
        cmbEmpresa.setForeground(new java.awt.Color(255, 255, 255));

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("Necesidad");

        cmbNecesidad.setBackground(new java.awt.Color(0, 0, 0));
        cmbNecesidad.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
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
                                        .addComponent(btnSubirA3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fechaInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                                        .addGap(82, 82, 82)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(ckbContratacion)
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                        .addComponent(userLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(nombreArchivo8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnSubirA8))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(48, 48, 48)
                                                        .addComponent(cmbNecesidad, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 65, Short.MAX_VALUE)
                    .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(80, 80, 80)
                    .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 615, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                            .addComponent(btnSubirA4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreArchivo8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirA8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbNecesidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ckbContratacion)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 24, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 516, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        AnexosDAO ad = new AnexosDAO();
        int filas = TablaAnexos.getSelectedRow();
        String idAnexo = TablaAnexos.getValueAt(filas, 0) + "";

        Anexos a = new Anexos();

        a = ad.obtenAnexoPorID(Integer.parseInt(idAnexo));

        ad.eliminaAnexo(a, frame);
        
        TablaAnexos.clearSelection();
        cargaTabla();

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSubirA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA3ActionPerformed
        subirArchivo("anexo3");
    }//GEN-LAST:event_btnSubirA3ActionPerformed

    private void btnSubirA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA4ActionPerformed
        subirArchivo("anexo4");
    }//GEN-LAST:event_btnSubirA4ActionPerformed

    private void btnSubirA2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA2_2ActionPerformed
        subirArchivo("anexo2_2");
    }//GEN-LAST:event_btnSubirA2_2ActionPerformed

    private void btnSubirA2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA2_1ActionPerformed
        subirArchivo("anexo2_1");
    }//GEN-LAST:event_btnSubirA2_1ActionPerformed

    private void btnSubirA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirA8ActionPerformed
        subirArchivo("anexo8");
    }//GEN-LAST:event_btnSubirA8ActionPerformed

    private void ckbContratacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbContratacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbContratacionActionPerformed

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

    private Date transformarFecha(String fecha) {
        Date fechaTransformada = null;
        try {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES"));
            fechaTransformada = formatoEntrada.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fechaTransformada;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAnexos;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JLabel nombreArchivo2_1;
    private javax.swing.JLabel nombreArchivo2_2;
    private javax.swing.JLabel nombreArchivo3;
    private javax.swing.JLabel nombreArchivo4;
    private javax.swing.JLabel nombreArchivo8;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
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
