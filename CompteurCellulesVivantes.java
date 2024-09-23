public class CompteurCellulesVivantes implements Visiteur {
    private int nombreVivantes = 0;

    @Override
    public void visiter(Cellule cellule) {
        if (cellule.estVivante()) {
            nombreVivantes++;
        }
    }

    public int getNombreVivantes() {
        return nombreVivantes;
    }
}
