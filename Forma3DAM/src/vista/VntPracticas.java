package vista;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.AlumnosDAO;
import modelo.AnexosDAO;
import modelo.EmpresasDAO;
import modelo.PracticasDAO;
import pojos.Alumnos;
import pojos.Anexos;
import pojos.Practicas;
import pojos.Empresas;

public class VntPracticas extends javax.swing.JPanel {

    private byte[] bytesIS;
    private byte[] bytesIF;

    DefaultTableModel dtm = new DefaultTableModel(new Object[]{
        "ID",
        "DNI Alumno",
        "CIF Empresa",
        "Tutor Practicas",
        "ID Anexo",
        "Calendario",
        "I. S.",
        "I. F.",
        "Entrada",
        "Salida"
    }, 0);

    public VntPracticas() {
        initComponents();
        TablaPracticas.setDefaultEditor(Object.class, null);
        cargaTabla();
        cargaPracticas();
        cargarDNIAlumno();
        cargarTutorPracticasEmpresas();
        cargarCalendariosAnexos();
        TablaPracticas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int fila = TablaPracticas.rowAtPoint(e.getPoint());
                    int columna = TablaPracticas.columnAtPoint(e.getPoint());
                    if ((columna == 6 || columna == 7)
                            && "Subido".equals(TablaPracticas.getValueAt(fila, columna))) {
                        int opcion = JOptionPane.showConfirmDialog(null,
                                "¿Desea descargar el archivo?",
                                "Descargar Archivo",
                                JOptionPane.YES_NO_OPTION);
                        if (opcion == JOptionPane.YES_OPTION) {
                            descargarArchivo(fila, columna);
                        }
                    }
                }
            }
        });
    }

    public void cargaTabla() {
        dtm.setRowCount(0);
        List<Practicas> listaPracticas = new PracticasDAO().obtenListaPracticas();
        for (Practicas a : listaPracticas) {
            if (a.getIdPractica() > 0) {
                Alumnos al = new AlumnosDAO().obtenAlumnos(a.getAlumnos().getIdAlumno());
                Empresas e = new EmpresasDAO().obtenEmpresas(a.getEmpresas().getIdEmpresa());
                Anexos an = new AnexosDAO().obtenAnexos(a.getAnexos().getIdAnexo());
                if (a.getInformeSeguimiento() != null) {
                    if (a.getInformeFinal() != null) {
                        dtm.addRow(new Object[]{
                            a.getIdPractica(),
                            al.getDniAlumno(),
                            e.getCifEmpresa(),
                            e.getTutorPracticas(),
                            a.getAnexos().getIdAnexo(),
                            an.getCalendario(),
                            "Subido",
                            "Subido",
                            a.getHorarioEntrada(),
                            a.getHorarioSalida(),});
                    } else {
                        dtm.addRow(new Object[]{
                            a.getIdPractica(),
                            al.getDniAlumno(),
                            e.getCifEmpresa(),
                            e.getTutorPracticas(),
                            a.getAnexos().getIdAnexo(),
                            an.getCalendario(),
                            "Subido",
                            "No Subido",
                            a.getHorarioEntrada(),
                            a.getHorarioSalida(),});
                    }
                } else {
                    if (a.getInformeFinal() != null) {
                        dtm.addRow(new Object[]{
                            a.getIdPractica(),
                            al.getDniAlumno(),
                            e.getCifEmpresa(),
                            e.getTutorPracticas(),
                            a.getAnexos().getIdAnexo(),
                            an.getCalendario(),
                            "No Subido",
                            "Subido",
                            a.getHorarioEntrada(),
                            a.getHorarioSalida(),});
                    } else {
                        dtm.addRow(new Object[]{
                            a.getIdPractica(),
                            al.getDniAlumno(),
                            e.getCifEmpresa(),
                            e.getTutorPracticas(),
                            a.getAnexos().getIdAnexo(),
                            an.getCalendario(),
                            "No Subido",
                            "No Subido",
                            a.getHorarioEntrada(),
                            a.getHorarioSalida(),});
                    }
                }
            }
        }
    }

    public void cargaPracticas() {
        TablaPracticas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filas = TablaPracticas.getSelectedRow();
                    if (filas != -1) {
                        txtIDPractica.setText(TablaPracticas.getValueAt(filas, 0) + "");
                        Alumnos a = new AlumnosDAO().obtenAlumnosPorDNI(TablaPracticas.getValueAt(filas, 1) + "");
                        int idAlumno = a.getIdAlumno();
                        for (int i = 1; i < cbDNIAlumno.getItemCount(); i++) {
                            Alumnos alumnos = (Alumnos) cbDNIAlumno.getItemAt(i);
                            if (alumnos != null && alumnos.getIdAlumno() == idAlumno) {
                                cbDNIAlumno.setSelectedIndex(i);
                                break;
                            }
                        }
                        Empresas em = new EmpresasDAO().obtenEmpresaPorTutor(TablaPracticas.getValueAt(filas, 3) + "");
                        int idEmpresa = em.getIdEmpresa();
                        for (int j = 1; j < cbTutorPracticas.getItemCount(); j++) {
                            Empresas empresa = (Empresas) cbTutorPracticas.getItemAt(j);
                            if (empresa != null && empresa.getIdEmpresa() == idEmpresa) {
                                cbTutorPracticas.setSelectedIndex(j);
                                break;
                            }
                        }
                        Anexos ane = new AnexosDAO().obtenAnexoPorID(Integer.parseInt(TablaPracticas.getValueAt(filas, 4) + ""));
                        int idAnexo = ane.getIdAnexo();
                        for (int i = 1; i < cbCalendario.getItemCount(); i++) {
                            Anexos anexo = (Anexos) cbCalendario.getItemAt(i);
                            if (anexo != null && anexo.getIdAnexo() == idAnexo) {
                                cbCalendario.setSelectedIndex(i);
                                break;
                            }
                        }
                        txtHorarioEntrada.setText(TablaPracticas.getValueAt(filas, 8) + "");
                        txtHorarioSalida.setText(TablaPracticas.getValueAt(filas, 9) + "");
                        cbDNIAlumno.setEnabled(true);
                        cbTutorPracticas.setEnabled(true);
                        cbCalendario.setEnabled(true);
                        btnActualizar.setEnabled(true);
                        btnBorrar.setEnabled(true);
                        btnSubirCVIS.setEnabled(true);
                        btnSubirCVIF.setEnabled(true);
                    }
                }
            }
        });
    }

    private void cargarDNIAlumno() {
        List<Alumnos> listaAlumnos = new AlumnosDAO().obtenListaAlumnos();
        DefaultComboBoxModel<Alumnos> modeloDNIA = new DefaultComboBoxModel<>();
        modeloDNIA.addElement(new Alumnos(null));
        for (Alumnos a : listaAlumnos) {
            modeloDNIA.addElement(a);
        }
        cbDNIAlumno.setModel(modeloDNIA);
        cbDNIAlumno.setRenderer(new AlumnosComboBoxRenderer());
    }

    private static class AlumnosComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Alumnos) {
                Alumnos a = (Alumnos) value;
                if (a.getIdAlumno() == null) {
                    setText("Seleccione DNI de Alumno/a");
                } else {
                    if (a.getIdAlumno() > 0) {
                        setText(a.getIdAlumno() + " - " + a.getDniAlumno());
                    } else {
                        setText("");
                    }
                }
            }
            return this;
        }
    }

    private void cargarTutorPracticasEmpresas() {
        List<Empresas> listaEmpresas = new EmpresasDAO().obtenListaEmpresas();
        DefaultComboBoxModel<Empresas> model = new DefaultComboBoxModel<>();
        model.addElement(new Empresas());
        for (Empresas empresa : listaEmpresas) {
            model.addElement(empresa);
        }
        cbTutorPracticas.setModel(model);
        cbTutorPracticas.setRenderer(new EmpresasComboBoxRenderer());
    }

    private static class EmpresasComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Empresas) {
                Empresas empresa = (Empresas) value;
                if (empresa.getTutorPracticas() == null) {
                    setText("Seleccione Tutor/a");
                } else {
                    if (empresa.getIdEmpresa() > 0) {
                        setText(empresa.getIdEmpresa() + " - " + empresa.getTutorPracticas());
                    } else {
                        setText("");
                    }
                }
            }
            return this;
        }
    }

    private void cargarCalendariosAnexos() {
        List<Anexos> listaAnexos = new AnexosDAO().obtenerAnexos();
        DefaultComboBoxModel<Anexos> model = new DefaultComboBoxModel<>();
        model.addElement(new Anexos());
        for (Anexos anexos : listaAnexos) {
            model.addElement(anexos);
        }
        cbCalendario.setModel(model);
        cbCalendario.setRenderer(new AnexosComboBoxRenderer());
    }

    private static class AnexosComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Anexos) {
                Anexos anexos = (Anexos) value;
                if (anexos.getCalendario() == null) {
                    setText("Seleccione Calendario");
                } else {
                    if (anexos.getIdAnexo() > 0) {
                        setText(anexos.getCalendario() + " (" + anexos.getFechaInicio() + ")");
                    } else {
                        setText("");
                    }
                }
            }
            return this;
        }
    }

    private void descargarArchivo(int fila, int columna) {
        int idPractica = (int) TablaPracticas.getValueAt(fila, 0);
        Practicas practica = new PracticasDAO().obtenPracticas(idPractica);
        byte[] archivo = null;
        switch (columna) {
            case 5:
                archivo = practica.getInformeSeguimiento();
                break;
            case 6:
                archivo = practica.getInformeFinal();
                break;
            default:
                break;
        }
        if (archivo != null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar archivo");
            FileNameExtensionFilter docxFilter = new FileNameExtensionFilter("Archivos DOCX", "docx");
            fileChooser.addChoosableFileFilter(docxFilter);
            fileChooser.setFileFilter(docxFilter);
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String nombreArchivo = selectedFile.getName();
                FileFilter filtroSeleccionado = fileChooser.getFileFilter();
                String descripcionFiltro = filtroSeleccionado.getDescription();
                String extensionFiltro = "docx";
                if (!nombreArchivo.toLowerCase().endsWith("." + extensionFiltro)) {
                    nombreArchivo += "." + extensionFiltro;
                    selectedFile = new File(selectedFile.getParent(), nombreArchivo);
                }
                try (FileOutputStream fos = new FileOutputStream(selectedFile)) {
                    fos.write(archivo);
                    JOptionPane.showMessageDialog(null, "Archivo descargado exitosamente", "Descarga Exitosa", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo asociado", "Archivo no encontrado", JOptionPane.WARNING_MESSAGE);
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
        TablaPracticas = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        title1 = new javax.swing.JLabel();
        userLabel6 = new javax.swing.JLabel();
        txtIDPractica = new javax.swing.JTextField();
        userLabel = new javax.swing.JLabel();
        cbDNIAlumno = new javax.swing.JComboBox<>();
        userLabel1 = new javax.swing.JLabel();
        cbTutorPracticas = new javax.swing.JComboBox<>();
        userLabel2 = new javax.swing.JLabel();
        btnSubirCVIS = new javax.swing.JButton();
        nombreArchivoIS = new javax.swing.JLabel();
        userLabel7 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        btnSubirCVIF = new javax.swing.JButton();
        nombreArchivoIF = new javax.swing.JLabel();
        userLabel8 = new javax.swing.JLabel();
        txtHorarioEntrada = new javax.swing.JTextField();
        userLabel9 = new javax.swing.JLabel();
        txtHorarioSalida = new javax.swing.JTextField();
        cbCalendario = new javax.swing.JComboBox<>();

        jTableAlumnos.setModel(dtm);
        jScrollPane1.setViewportView(jTableAlumnos);

        setAlignmentX(0.0F);

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png"))); // NOI18N

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Actualizar/Borrar");

        TablaPracticas.setModel(dtm);
        jScrollPane2.setViewportView(TablaPracticas);

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
        title1.setText("PRACTICAS");

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("ID Practica");

        txtIDPractica.setEditable(false);
        txtIDPractica.setBackground(new java.awt.Color(0, 0, 0));
        txtIDPractica.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtIDPractica.setForeground(new java.awt.Color(255, 255, 255));
        txtIDPractica.setBorder(null);
        txtIDPractica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIDPracticaMousePressed(evt);
            }
        });

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("DNI Alumno");

        cbDNIAlumno.setBackground(new java.awt.Color(0, 0, 0));
        cbDNIAlumno.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbDNIAlumno.setForeground(new java.awt.Color(255, 255, 255));
        cbDNIAlumno.setEnabled(false);

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("Tutor Practicas");

        cbTutorPracticas.setBackground(new java.awt.Color(0, 0, 0));
        cbTutorPracticas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbTutorPracticas.setForeground(new java.awt.Color(255, 255, 255));
        cbTutorPracticas.setEnabled(false);

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setText("Calendario");

        btnSubirCVIS.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirCVIS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirCVIS.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirCVIS.setText("Subir I. S.");
        btnSubirCVIS.setEnabled(false);
        btnSubirCVIS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirCVISActionPerformed(evt);
            }
        });

        nombreArchivoIS.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivoIS.setText("Archivo");

        userLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel7.setText("Informe Seguimiento");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("Informe Final");

        btnSubirCVIF.setBackground(new java.awt.Color(18, 30, 49));
        btnSubirCVIF.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSubirCVIF.setForeground(new java.awt.Color(255, 255, 255));
        btnSubirCVIF.setText("Subir I. F.");
        btnSubirCVIF.setEnabled(false);
        btnSubirCVIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirCVIFActionPerformed(evt);
            }
        });

        nombreArchivoIF.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreArchivoIF.setText("Archivo");

        userLabel8.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel8.setText("Horario Entrada");

        txtHorarioEntrada.setBackground(new java.awt.Color(0, 0, 0));
        txtHorarioEntrada.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtHorarioEntrada.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioEntrada.setBorder(null);
        txtHorarioEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHorarioEntradaMousePressed(evt);
            }
        });

        userLabel9.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel9.setText("Horario Salida");

        txtHorarioSalida.setBackground(new java.awt.Color(0, 0, 0));
        txtHorarioSalida.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtHorarioSalida.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioSalida.setBorder(null);
        txtHorarioSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHorarioSalidaMousePressed(evt);
            }
        });

        cbCalendario.setBackground(new java.awt.Color(0, 0, 0));
        cbCalendario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbCalendario.setForeground(new java.awt.Color(255, 255, 255));
        cbCalendario.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(689, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(userLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(txtHorarioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreArchivoIS, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSubirCVIS))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(userLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbDNIAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtIDPractica)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbTutorPracticas, 0, 236, Short.MAX_VALUE)
                                        .addComponent(cbCalendario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreArchivoIF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSubirCVIF)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 30, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(80, 80, 80)
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 429, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDPractica, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbDNIAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTutorPracticas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSubirCVIS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreArchivoIS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSubirCVIF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreArchivoIF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorarioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(favicon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (txtIDPractica.getText() != null) {
            new PracticasDAO().eliminaPracticas(txtIDPractica.getText());
            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtIDPractica, "Seleciona un Alumno", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtIDPracticaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDPracticaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPracticaMousePressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtIDPractica.getText() != null && cbDNIAlumno.getSelectedIndex() != 0 && cbDNIAlumno.getSelectedIndex() != 0
                && cbDNIAlumno.getSelectedIndex() != 0) {
            Alumnos al = (Alumnos) cbDNIAlumno.getSelectedItem();
            Anexos an = (Anexos) cbCalendario.getSelectedItem();
            Empresas e = (Empresas) cbTutorPracticas.getSelectedItem();
            Practicas p = new Practicas(al, an, e, bytesIS, bytesIF, txtHorarioEntrada.getText(), txtHorarioSalida.getText());
            p.setIdPractica(Integer.parseInt(txtIDPractica.getText()));
            new PracticasDAO().actualizaPracticas(p);
            cargaTabla();
        } else {
            JOptionPane.showMessageDialog(txtIDPractica, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSubirCVISActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirCVISActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter docxFilter = new FileNameExtensionFilter("Archivos DOCX", "docx");
        fileChooser.addChoosableFileFilter(docxFilter);
        fileChooser.setFileFilter(docxFilter);
        fileChooser.setDialogTitle("Elige un archivo DOCX");
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String nombreArchivo = archivo.getName();
            String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toLowerCase();
            if (!extension.equals("docx")) {
                JOptionPane.showMessageDialog(this, "Solo se permiten archivos DOCX", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                byte[] bytesArchivo = convertirArchivoABytes(archivo);
                bytesIS = bytesArchivo;
                nombreArchivoIS.setText(archivo.getName());
                nombreArchivoIS.setToolTipText(archivo.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSubirCVISActionPerformed

    private void btnSubirCVIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirCVIFActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter docxFilter = new FileNameExtensionFilter("Archivos DOCX", "docx");
        fileChooser.addChoosableFileFilter(docxFilter);
        fileChooser.setFileFilter(docxFilter);
        fileChooser.setDialogTitle("Elige un archivo DOCX");
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String nombreArchivo = archivo.getName();
            String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toLowerCase();
            if (!extension.equals("docx")) {
                JOptionPane.showMessageDialog(this, "Solo se permiten archivos DOCX", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                byte[] bytesArchivo = convertirArchivoABytes(archivo);
                bytesIF = bytesArchivo;
                nombreArchivoIF.setText(archivo.getName());
                nombreArchivoIF.setToolTipText(archivo.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSubirCVIFActionPerformed

    private void txtHorarioEntradaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHorarioEntradaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorarioEntradaMousePressed

    private void txtHorarioSalidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHorarioSalidaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorarioSalidaMousePressed

    private byte[] convertirArchivoABytes(File archivo) throws IOException {
        byte[] bytesArray = new byte[(int) archivo.length()];
        FileInputStream fis = new FileInputStream(archivo);
        fis.read(bytesArray);
        fis.close();
        return bytesArray;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPracticas;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnSubirCVIF;
    private javax.swing.JButton btnSubirCVIS;
    private javax.swing.JComboBox<Anexos > cbCalendario;
    private javax.swing.JComboBox<Alumnos> cbDNIAlumno;
    private javax.swing.JComboBox<Empresas
    > cbTutorPracticas;
    private javax.swing.JLabel favicon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JLabel nombreArchivoIF;
    private javax.swing.JLabel nombreArchivoIS;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField txtHorarioEntrada;
    private javax.swing.JTextField txtHorarioSalida;
    private javax.swing.JTextField txtIDPractica;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel5;
    private javax.swing.JLabel userLabel6;
    private javax.swing.JLabel userLabel7;
    private javax.swing.JLabel userLabel8;
    private javax.swing.JLabel userLabel9;
    // End of variables declaration//GEN-END:variables
}
