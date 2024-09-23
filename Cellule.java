import java.util.Observable;

public class Cellule extends Observable {
    private boolean vivante;

    public Cellule() {
        this.vivante = false;
    }

    public boolean estVivante() {
        return vivante;
    }

    public void setVivante(boolean vivante) {
        this.vivante = vivante;
        setChanged();
        notifyObservers();  // Notifie les observateurs du changement de la cellule
    }

    public void inverserEtat() {
        setVivante(!vivante);
    }
}