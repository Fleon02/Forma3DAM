package PlantillasUI;

import PlantillasUI.Eventos.EventoMenu;
import PlantillasUI.Eventos.EventoMenuSeleccionado;
import PlantillasUI.Eventos.EventoMostrarMenuPopup;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;

public class Menu extends javax.swing.JPanel {

    public boolean isMostrarMenu() {
        return mostrarMenu;
    }

    public void addEvent(EventoMenuSeleccionado event) {
        this.event = event;
    }

    public void setMenuActivar(boolean menuActivar) {
        this.menuActivar = menuActivar;
    }

    public void setMostrarMenu(boolean mostrarMenu) {
        this.mostrarMenu = mostrarMenu;
    }

    public void addEventoMostrarPopup(EventoMostrarMenuPopup eventoMostrarPopup) {
        this.eventoMostrarPopup = eventoMostrarPopup;
    }

    private final MigLayout layout;
    private EventoMenuSeleccionado event;
    private EventoMostrarMenuPopup eventoMostrarPopup;
    private boolean menuActivar = true;
    private boolean mostrarMenu = true;

    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);

    }

    public void iniciarMenuItem() {
        addMenu(new ModeloMenu(new ImageIcon(getClass().getResource("/imagenes/alumnos.png")), "Inicio"));
        addMenu(new ModeloMenu(new ImageIcon(getClass().getResource("/imagenes/alumnos.png")), "Alumnos", "Insertar", "Actualizar/Borrar"));
        addMenu(new ModeloMenu(new ImageIcon(getClass().getResource("/imagenes/empresa.png")), "Empresas", "Insertar", "Actualizar/Borrar"));
        addMenu(new ModeloMenu(new ImageIcon(getClass().getResource("/imagenes/convenio.png")), "Convenios", "Insertar", "Actualizar/Borrar"));
        addMenu(new ModeloMenu(new ImageIcon(getClass().getResource("/imagenes/clase.png")), "Necesidad", "Insertar", "Actualizar/Borrar"));
        addMenu(new ModeloMenu(new ImageIcon(getClass().getResource("/imagenes/pc.png")), "Practicas", "Insertar", "Actualizar/Borrar"));
        addMenu(new ModeloMenu(new ImageIcon(getClass().getResource("/imagenes/maleta.png")), "Bolsa de Trabajo", "Insertar", "Actualizar/Borrar"));
        addMenu(new ModeloMenu(new ImageIcon(getClass().getResource("/imagenes/ajustes.png")), "Ajustes", "Cambiar Tema"));
    }

    private void addMenu(ModeloMenu menu) {
        panel.add(new MenuItem(menu, getEventoMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventoMenu getEventoMenu() {
        return new EventoMenu() {
            @Override
            public boolean menuPresionado(Component com, boolean abierto) {
                if (menuActivar) {
                    if (mostrarMenu) {
                        if (abierto) {
                            new AnimacionMenu(layout, com).abrirMenu();
                        } else {
                            new AnimacionMenu(layout, com).cerrarMenu();
                        }
                        return true;
                    } else {
                        eventoMostrarPopup.MostrarPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void ocultarTodosLosMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isAbierto()) {
                new AnimacionMenu(layout, com, 500).cerrarMenu();
                item.setAbierto(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        perfil1 = new PlantillasUI.Perfil();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(255, 51, 51));
        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(perfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(perfil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(32, 105, 249), getWidth(), 0, new Color(93, 58, 196));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private PlantillasUI.Perfil perfil1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JPanel getPanel() {
        return panel;
    }

    public void setPanel(javax.swing.JPanel panel) {
        this.panel = panel;
    }

    public javax.swing.JScrollPane getSp() {
        return sp;
    }

    public void setSp(javax.swing.JScrollPane sp) {
        this.sp = sp;
    }
}
