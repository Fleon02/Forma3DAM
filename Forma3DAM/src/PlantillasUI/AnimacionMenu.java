package PlantillasUI;

import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class AnimacionMenu {

    private final MigLayout layout;
    private final MenuItem menuItem;
    private Animator animator;
    private boolean open;

    public AnimacionMenu(MigLayout layout, Component componente) {
        this.layout = layout;
        this.menuItem = (MenuItem) componente;
        initAnimator(componente, 200);
    }

    public AnimacionMenu(MigLayout layout, Component componente, int duraccion) {
        this.layout = layout;
        this.menuItem = (MenuItem) componente;
        initAnimator(componente, duraccion);

    }

    private void initAnimator(Component componente, int duraccion) {
        int altura = componente.getPreferredSize().height;
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float h;
                if (open) {
                    h = 40 + ((altura - 40) * fraction);
                    menuItem.setAlpha(fraction);
                } else {
                    h = 40 + ((altura - 40) * (1f - fraction));
                }
                layout.setComponentConstraints(menuItem, "h " + h + "!");
                componente.revalidate();
                componente.repaint();
            }
        };
        animator = new Animator(duraccion, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
    }

    public void abrirMenu() {
        open = true;
        animator.start();
    }

    public void cerrarMenu() {
        open = false;
        animator.start();
    }

}
