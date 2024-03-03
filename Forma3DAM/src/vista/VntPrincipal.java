package vista;

import PlantillasUI.Eventos.EventoMenuSeleccionado;
import PlantillasUI.Eventos.EventoMostrarMenuPopup;
import PlantillasUI.Header;
import PlantillasUI.Menu;
import PlantillasUI.MenuItem;
import PlantillasUI.Popups.PopupMenu;
import controlador.ControlaForm;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class VntPrincipal extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private ControlaForm main;
    private Animator animator;
    final VntPrincipal vntPrincipal = this;

    public VntPrincipal() {

    }

    public VntPrincipal(String nombre, String rol) {
        initComponents();
        setTitle("FORMA 3");
        init(nombre, rol);
    }

    private void init(String nombre, String rol) {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new ControlaForm();
        menu.addEvent(new EventoMenuSeleccionado() {
            @Override
            public void menuSeleccionado(int indexMenu, int indexSubMenu) {
                //System.out.println("Index Menu : " + indexMenu + " SubMenu Index " + indexSubMenu);
                if (indexMenu == 0) {
                    if (indexSubMenu == -1) {
                        main.showForm(new VntBienvenido(nombre, rol));
                    }
                } else if (indexMenu == 1) {
                    if (indexSubMenu == 0) {
                        main.showForm(new VntInsertaAlumno());
                    } else if (indexSubMenu == 1) {
                        main.showForm(new VntAlumnos(vntPrincipal));
                    }
                } else if (indexMenu == 2) {
                    if (indexSubMenu == 0) {
                        main.showForm(new VntInsertaEmpresa());
                    } else if (indexSubMenu == 1) {
                        main.showForm(new VntEmpresas(vntPrincipal));
                    }
                } else if (indexMenu == 3) {
                    if (indexSubMenu == 0) {
                        main.showForm(new VntInsertaConvenio());
                    } else if (indexSubMenu == 1) {
                        main.showForm(new vntConvenios(vntPrincipal));
                    }
                } else if (indexMenu == 4) {
                    if (indexSubMenu == 0) {
                        main.showForm(new VntInsertaNecesidad());
                    } else if (indexSubMenu == 1) {
                        main.showForm(new VntNecesidad(vntPrincipal));
                    }
                } else if (indexMenu == 5) {
                    if (indexSubMenu == 0) {
                        main.showForm(new VntInsertaPractica());
                    } else if (indexSubMenu == 1) {
                        main.showForm(new VntPracticas(vntPrincipal));
                    }
                } else if (indexMenu == 6) {
                    if (indexSubMenu == 0) {
                        main.showForm(new VntInsertaBolsa());
                    } else if (indexSubMenu == 1) {
                        main.showForm(new VntBolsa(vntPrincipal));
                    }
                } else if (indexMenu == 7) {
                    if (indexSubMenu == 1) {
                        main.showForm(new VntAnexos(vntPrincipal));
                    } else if (indexSubMenu == 0) {
                        main.showForm(new VntInsertaAnexo());
                    }
                } else if (indexMenu == 8) {
                    if (indexSubMenu == 0) {
                        main.showForm(new VntConfiguracion(vntPrincipal));
                    }
                }
            }
        });
        menu.addEventoMostrarPopup(new EventoMostrarMenuPopup() {
            @Override
            public void MostrarPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(VntPrincipal.this, item.getIndex(), item.getEventoSeleccionado(), item.getMenu().getSubMenu());
                int x = VntPrincipal.this.getX() + 52;
                int Y = VntPrincipal.this.getY() + com.getY() + 86;
                popup.setLocation(x, Y);
                popup.setVisible(true);
            }
        });
        header.setDatosUsuario(nombre, rol);
        menu.iniciarMenuItem(rol);
        bg.add(menu, "w 230!, spany 2");
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isMostrarMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            public void end() {
                menu.setMostrarMenu(!menu.isMostrarMenu());
                menu.setMenuActivar(true);
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addEventoMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setMenuActivar(false);
                if (menu.isMostrarMenu()) {
                    menu.ocultarTodosLosMenu();
                }
            }
        });
        main.showForm(new VntBienvenido(nombre, rol));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 783));
        setResizable(false);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1406, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables

}
