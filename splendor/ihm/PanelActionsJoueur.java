package splendor.ihm;

import splendor.Controleur;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelActionsJoueur extends JPanel implements ActionListener {
    
    private Controleur controleur;
    private JPanel panelBoutons;
    private JButton[] boutons;
    private String[] actionsJoueur;

    public PanelActionsJoueur(Controleur controleur) {
        this.controleur = controleur;
        this.panelBoutons = new JPanel(new GridLayout(4,1));
        
        this.boutons = new JButton[4];
        this.actionsJoueur = new String[]{"Prendre 3 jetons", "Prendre 2 jetons", "Acheter carte", "Reserver carte"};

        for(int i = 0; i < this.boutons.length; i++) {
            this.boutons[i] = new JButton(this.actionsJoueur[i]);
            this.boutons[i].addActionListener(this);
        
            this.panelBoutons.add(this.boutons[i]);
        }    

        this.add(this.panelBoutons);
    }

    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < this.boutons.length; i++) {
            if(this.boutons[i] == e.getSource()) {
                this.controleur.getPlateau().getJoueurActuel().jouerTour(i);
                if(i == 3) {
                    this.controleur.getPlateau().changementTour();
                }
            }
        }
    }
}
