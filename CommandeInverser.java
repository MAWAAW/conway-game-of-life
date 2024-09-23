public class CommandeInverser extends Commande {

    public CommandeInverser(Cellule cellule) {
        super(cellule);
    }

    @Override
    public void executer() {
        cellule.inverserEtat();
    }
}
