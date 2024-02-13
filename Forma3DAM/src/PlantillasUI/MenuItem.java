/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantillasUI;

import PlantillasUI.Eventos.EventoMenu;
import PlantillasUI.Eventos.EventoMenuSeleccionado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author francisco.leon
 */
public class MenuItem extends javax.swing.JPanel {

    private float alpha;
    private ModeloMenu menu;
    private boolean abierto;
    private EventoMenuSeleccionado eventoSeleccionado;
    private int index;

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    public EventoMenuSeleccionado getEventoSeleccionado() {
        return eventoSeleccionado;
    }

    public void setEventoSeleccionado(EventoMenuSeleccionado eventoSeleccionado) {
        this.eventoSeleccionado = eventoSeleccionado;
    }

    public int getIndex() {
        return index;
    }

    public MenuItem(ModeloMenu menu, EventoMenu evento, EventoMenuSeleccionado eventoSeleccionado, int index) {
        initComponents();
        this.menu = menu;
        this.eventoSeleccionado = eventoSeleccionado;
        this.index = index;
        setAbierto(false);
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[fill, 40!]0[fill, 35!]"));
        MenuButton primerItem = new MenuButton(menu.getIcon(), menu.getMenuName());
        primerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menu.getSubMenu().length>0) {
                    System.out.println("Primer Item");
                    
                }
            }
        });
        add(primerItem);
        int indexSubMenu = -1;
        for (String st : menu.getSubMenu()) {
            MenuButton item = new MenuButton(st);
            item.setIndex(++indexSubMenu);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eventoSeleccionado.menuSeleccionado(index, item.getIndex());
                }
            });
            add(item);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
