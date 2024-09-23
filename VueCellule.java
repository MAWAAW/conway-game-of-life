import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VueCellule extends JPanel implements Observer {
    private Cellule cellule;

    public VueCellule(Cellule cellule) {
        this.cellule = cellule;
        cellule.addObserver(this);  // Ajoute cette vue comme observateur de la cellule
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();  // Redessine la cellule quand elle change
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (cellule.estVivante()) {
            g.setColor(Color.BLUE);  // Cellule vivante en bleu
        } else {
            g.setColor(Color.WHITE);  // Cellule morte en blanc
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());
    }
}
