/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import PlantillasParaUI.EventMenu;
import PlantillasParaUI.MainForm;
import PlantillasParaUI.MenuItem;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.awt.Component;

/**
 *
 * @author soraf
 */
public class VntPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public VntPrincipal(String nombreUsuario, String rol) {
        FlatIntelliJLaf.setup();
        initComponents();
        menuP.addEventMenuSelected(new EventMenu() {
            @Override
            public void mainMenuSelected(MainForm mainForm, int index, MenuItem menuItem) {
                if (index == 5) {
                   mainForm.displayForm(new vntAnexo());
                }
            }

            @Override
            public void subMenuSelected(MainForm mainForm, int index, int subMenuIndex, Component menuItem) {
                mainForm.displayForm(new vntAnexo());
            }
        });
        mnmUsuario.setText(nombreUsuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuP = new PlantillasParaUI.Menu();
        logo = new javax.swing.JLabel();
        menuItem1 = new PlantillasParaUI.MenuItem();
        menuItem7 = new PlantillasParaUI.MenuItem();
        menuItem8 = new PlantillasParaUI.MenuItem();
        menuItem9 = new PlantillasParaUI.MenuItem();
        menuItem10 = new PlantillasParaUI.MenuItem();
        menuItem11 = new PlantillasParaUI.MenuItem();
        subMenuPanel2 = new PlantillasParaUI.SubMenuPanel();
        panelInicial = new PlantillasParaUI.MainForm();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnmUsuario = new javax.swing.JMenu();
        mnmcerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuP.setMainForm(panelInicial);
        menuP.setSubMenuPanel(subMenuPanel2);

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoF.png"))); // NOI18N
        menuP.add(logo);

        menuItem1.setText("menuItem1");
        menuItem1.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Insertar", "Mostrar", "Editar", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuP.add(menuItem1);

        menuItem7.setText("menuItem7");
        menuP.add(menuItem7);

        menuItem8.setText("menuItem8");
        menuP.add(menuItem8);

        menuItem9.setText("menuItem9");
        menuP.add(menuItem9);

        menuItem10.setText("menuItem10");
        menuP.add(menuItem10);

        menuItem11.setText("menuItem11");
        menuP.add(menuItem11);

        subMenuPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(80, 1, 1, 1));

        mnmUsuario.setText("Usuario");

        mnmcerrarSesion.setText("Cerrar Sesión");
        mnmUsuario.add(mnmcerrarSesion);

        jMenuBar1.add(mnmUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuP, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(subMenuPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuP, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
            .addComponent(subMenuPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel logo;
    private PlantillasParaUI.MenuItem menuItem1;
    private PlantillasParaUI.MenuItem menuItem10;
    private PlantillasParaUI.MenuItem menuItem11;
    private PlantillasParaUI.MenuItem menuItem7;
    private PlantillasParaUI.MenuItem menuItem8;
    private PlantillasParaUI.MenuItem menuItem9;
    private PlantillasParaUI.Menu menuP;
    private javax.swing.JMenu mnmUsuario;
    private javax.swing.JMenuItem mnmcerrarSesion;
    private PlantillasParaUI.MainForm panelInicial;
    private PlantillasParaUI.SubMenuPanel subMenuPanel2;
    // End of variables declaration//GEN-END:variables
}
