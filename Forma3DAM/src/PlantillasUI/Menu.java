package PlantillasUI;

import PlantillasUI.Eventos.EventoMenu;
import PlantillasUI.Eventos.EventoMenuSeleccionado;
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

/**
 *
 * @author francisco.leon
 */
public class Menu extends javax.swing.JPanel {

    public void addEvent(EventoMenuSeleccionado event) {
        this.event = event;
    }

    public void setMenuActivar(boolean menuActivar) {
        this.menuActivar = menuActivar;
    }

    public void setMostrarMenu(boolean mostrarMenu) {
        this.mostrarMenu = mostrarMenu;
    }

    private final MigLayout layout;
    private EventoMenuSeleccionado event;
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
        addMenu(new ModeloMenu(new ImageIcon(getClass().getResource("/imagenes/profile.png")), "Alumnos", "Insertar"));
    }

    private void addMenu(ModeloMenu menu) {
        panel.add(new MenuItem(menu, getEventoMenu(), event, panel.getComponentCount()));
    }

    private EventoMenu getEventoMenu() {
        return new EventoMenu() {
            @Override
            public boolean menuPresionado(Component com, boolean abierto) {
                System.out.println("Menu Presionado");
                return true;
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
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
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
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
