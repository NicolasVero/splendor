package splendor.ihm;

import splendor.Controleur;
import javax.swing.*;
import java.awt.Font;

public class PanelPointsJoueur extends JPanel {
    
    private Controleur controleur;
    private JLabel labelPoints;

    public PanelPointsJoueur(Controleur controleur) {
        
        this.controleur = controleur;
        this.labelPoints = new JLabel("0 points");
        this.labelPoints.setFont(new Font("Serif", Font.BOLD, 35));

        this.add(this.labelPoints);
    }

    public void updatePoints() {
        this.labelPoints.setText("" + this.controleur.getPlateau().getJoueurActuel().getPoints() + " points");
    }

}
