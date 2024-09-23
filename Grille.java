import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grille {
    private Cellule[][] cellules;
    private int lignes, colonnes;
	
	public Cellule[][] getCellules() {
        return cellules;
    }

    public Grille(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        cellules = new Cellule[lignes][colonnes];
        initialiserGrille();
    }

    private void initialiserGrille() {
		Random random = new Random();
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                cellules[i][j] = new Cellule();  // Crée une nouvelle cellule à chaque position
				cellules[i][j].setVivante(random.nextBoolean());  // Définit si la cellule est vivante ou morte
            }
        }
    }

    public void appliquerVisiteur(Visiteur visiteur) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                visiteur.visiter(cellules[i][j]);
            }
        }
    }

    public void etapeSuivante() {
		
		System.out.println("Evolution de la grille à l'étape suivante.");
        List<Commande> commandes = new ArrayList<>();
        
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                int voisinsVivants = compterVoisinsVivants(i, j);
                if (cellules[i][j].estVivante()) {
                    if (voisinsVivants < 2 || voisinsVivants > 3) {
                        commandes.add(new CommandeInverser(cellules[i][j])); // Meurt
                    }
                } else if (voisinsVivants == 3) {
                    commandes.add(new CommandeInverser(cellules[i][j])); // Renaît
                }
            }
        }
        
        for (Commande commande : commandes) {
            commande.executer();  // Applique les modifications après analyse
        }
    }

    private int compterVoisinsVivants(int x, int y) {
        int voisinsVivants = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int nx = x + i, ny = y + j;
                if (nx >= 0 && nx < lignes && ny >= 0 && ny < colonnes && cellules[nx][ny].estVivante()) {
                    voisinsVivants++;
                }
            }
        }
        return voisinsVivants;
    }
}
