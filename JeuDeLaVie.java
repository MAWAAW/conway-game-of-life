import javax.swing.*;
import java.awt.*;

public class JeuDeLaVie {
    public static void main(String[] args) {
        Grille grille = new Grille(20, 20);  // Grille de 20x20
        JFrame frame = new JFrame("Jeu de la Vie");

        JPanel panneauGrille = new JPanel();
        panneauGrille.setLayout(new GridLayout(20, 20));

        for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				VueCellule vueCellule = new VueCellule(grille.getCellules()[i][j]);
				panneauGrille.add(vueCellule);
			}
		}

        frame.add(panneauGrille);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Boucle pour mettre à jour la grille toutes les secondes
        Timer timer = new Timer(1000, e -> {
            grille.etapeSuivante();  // Fais évoluer la grille à chaque tick du timer
            panneauGrille.repaint();  // Redessine le panneau avec les nouvelles cellules
        });
        timer.start();  // Démarre l'animation
    }
}