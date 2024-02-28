/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.AlumnosDAO;
import modelo.BolsaDAO;
import modelo.EmpresasDAO;
import pojos.Alumnos;
import pojos.Empresas;

/**
 *
 * @author Usuario
 */
public class VntBolsa extends javax.swing.JPanel {
    
    DefaultTableModel dte = new DefaultTableModel(new Object[]{        
        "Empresa",
        "CIF",
        "Direccion",
        "Telefono",
        "Owner"
    }, 0);
    
    DefaultTableModel dta = new DefaultTableModel(new Object[]{        
        "DNI",
        "Nombre",
        "Año Curso",
        "N. S. S.",
        "Ciclo"
    }, 0);
    
    /**
     * Creates new form VntBolsa
     */
    public VntBolsa() {
        initComponents();
        cargaTablaAlumnos();
        cargaTablaEmpresa();
    }
    
    
    public void cargaTablaAlumnos() {
        dta.setRowCount(0);
        List<Alumnos> listaAlumnos = new BolsaDAO().obtenListaAlumnosConInformeFinal();
        for (Alumnos a : listaAlumnos) {
            if (a.getIdAlumno() > 0) {                
                    dta.addRow(new Object[]{
                        
                        a.getDniAlumno(),
                        a.getNombreAlumno(),
                        a.getYearCurso(),
                        a.getSegSocialAlumno(),
                        a.getCicloAlumno(),});
                
            }

        }
    }
    
    public void cargaTablaEmpresa() {
        dte.setRowCount(0);
        List<Empresas> listaEmpresas = new EmpresasDAO().obtenListaEmpresasEnNecesidad();
        for (Empresas e : listaEmpresas) {
            if (e.getIdEmpresa() != -1) {
                dte.addRow(new Object[]{
                    e.getNombreEmpresa(),
                    e.getCifEmpresa(),
                    e.getDireccion(),
                    e.getTelefono(),
                    e.getOwner()
                    ,});
            }

        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAlumnos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaEmpresas = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        title1 = new javax.swing.JLabel();

        TablaAlumnos.setModel(dta);
        TablaAlumnos.setToolTipText("");
        jScrollPane2.setViewportView(TablaAlumnos);

        TablaEmpresas.setModel(dte);
        jScrollPane3.setViewportView(TablaEmpresas);

        btnBorrar.setBackground(new java.awt.Color(18, 30, 49));
        btnBorrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setText("LINK");
        btnBorrar.setEnabled(false);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        title1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("BOLSA DE TRABAJO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(492, 492, 492))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(150, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(261, 261, 261))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
    
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAlumnos;
    private javax.swing.JTable TablaEmpresas;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel title1;
    // End of variables declaration//GEN-END:variables
}
