package splendor.ihm;

import splendor.Controleur;
import splendor.metier.Joueur;
import java.awt.*;
import javax.swing.*;

public class FrameJoueur extends JFrame {

    private Controleur controleur;
    private Joueur joueur;

    private JFrame framePrincipale;

    private PanelJetons panelJetons;
    private PanelNobles panelNoblesJoueur;
    private PanelActionsJoueur panelActionsJoueur;
    private PanelPointsJoueur panelPointsJoueur;

    public FrameJoueur(Controleur controleur, Joueur joueur) {
        
        this.controleur = controleur;
        this.joueur = joueur;

        this.framePrincipale = new JFrame("Joueur n°" + (this.joueur.getNumero() + 1));
        this.framePrincipale.setLayout(new BorderLayout());

        this.panelJetons = new PanelJetons("joueur", this.controleur);
        this.panelNoblesJoueur = new PanelNobles(this.controleur, "Joueur");
        this.panelActionsJoueur = new PanelActionsJoueur(this.controleur);
        this.panelPointsJoueur  = new PanelPointsJoueur(this.controleur);

        this.framePrincipale.add("East", this.panelActionsJoueur);
        this.framePrincipale.add("South", this.panelJetons);
        this.framePrincipale.add("North", this.panelNoblesJoueur);
        this.framePrincipale.add("Center", this.panelPointsJoueur);

        if(this.joueur.getNumero() == 0)
            this.framePrincipale.setLocation(810,10);
        else 
            this.framePrincipale.setLocation(810,470);
        
        this.framePrincipale.setEnabled(false);
        this.framePrincipale.setVisible(true);
        this.framePrincipale.setSize(800,450);
		this.framePrincipale.setResizable(false);
        this.framePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    public PanelJetons getPanelJetons() {
        return this.panelJetons;
    }

    public void setBlockedWindow() {
        if(this.framePrincipale.isEnabled()) 
            this.framePrincipale.setEnabled(false);
        else 
            this.framePrincipale.setEnabled(true);
    }
    

    /**
     * @return Controleur return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @param controleur the controleur to set
     */
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    /**
     * @return Joueur return the joueur
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * @param joueur the joueur to set
     */
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    /**
     * @return JFrame return the framePrincipale
     */
    public JFrame getFramePrincipale() {
        return framePrincipale;
    }

    /**
     * @param framePrincipale the framePrincipale to set
     */
    public void setFramePrincipale(JFrame framePrincipale) {
        this.framePrincipale = framePrincipale;
    }

    /**
     * @param panelJetons the panelJetons to set
     */
    public void setPanelJetons(PanelJetons panelJetons) {
        this.panelJetons = panelJetons;
    }

    /**
     * @return PanelNobles return the panelNoblesJoueur
     */
    public PanelNobles getPanelNoblesJoueur() {
        return panelNoblesJoueur;
    }

    /**
     * @param panelNoblesJoueur the panelNoblesJoueur to set
     */
    public void setPanelNoblesJoueur(PanelNobles panelNoblesJoueur) {
        this.panelNoblesJoueur = panelNoblesJoueur;
    }

    /**
     * @return PanelActionsJoueur return the panelActionsJoueur
     */
    public PanelActionsJoueur getPanelActionsJoueur() {
        return panelActionsJoueur;
    }

    /**
     * @param panelActionsJoueur the panelActionsJoueur to set
     */
    public void setPanelActionsJoueur(PanelActionsJoueur panelActionsJoueur) {
        this.panelActionsJoueur = panelActionsJoueur;
    }

    /**
     * @return PanelPointsJoueur return the panelPointsJoueur
     */
    public PanelPointsJoueur getPanelPointsJoueur() {
        return panelPointsJoueur;
    }

    /**
     * @param panelPointsJoueur the panelPointsJoueur to set
     */
    public void setPanelPointsJoueur(PanelPointsJoueur panelPointsJoueur) {
        this.panelPointsJoueur = panelPointsJoueur;
    }

}
