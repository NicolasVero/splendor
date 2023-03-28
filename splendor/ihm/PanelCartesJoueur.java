package splendor.ihm;

import splendor.Controleur;
import java.awt.*;
import javax.swing.*;

public class PanelCartesJoueur extends JPanel {

    private Controleur controleur;

    private JPanel panelPrincipal;
    private JPanel panelNombreCartesJoueur;
    private JPanel panelCartesJoueur;

    private JLabel[] labelsCartesJoueur;
    private JLabel[] labelsNombreCartesJoueur;

    public PanelCartesJoueur(Controleur controleur) {

        this.controleur = controleur;

        this.panelPrincipal = new JPanel();
        this.panelPrincipal.setLayout(new BorderLayout());

        this.panelNombreCartesJoueur = new JPanel();
        this.panelNombreCartesJoueur.setLayout(new GridLayout(1,5));

        this.panelCartesJoueur = new JPanel();
        this.panelCartesJoueur.setLayout(new GridLayout(1,5));

        this.labelsCartesJoueur = new JLabel[5];
        this.labelsNombreCartesJoueur = new JLabel[5];

        for(int i = 0; i < this.labelsCartesJoueur.length; i++) {
            
            this.labelsCartesJoueur[i] = new JLabel(new ImageIcon(this.controleur.CHEMIN_IMG + "dev_I_01.png"));
            this.panelCartesJoueur.add(this.labelsCartesJoueur[i]);
        
            this.labelsNombreCartesJoueur[i] = new JLabel("0");
            this.panelNombreCartesJoueur.add(this.labelsNombreCartesJoueur[i]);
        }

        this.panelPrincipal.add("North", this.panelCartesJoueur);
        this.panelPrincipal.add("South", this.panelNombreCartesJoueur);

        this.add(this.panelPrincipal);
    }
}
