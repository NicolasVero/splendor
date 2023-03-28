package splendor.ihm;

import splendor.Controleur;
import java.awt.*;
import javax.swing.*;

public class FramePlateau extends JFrame {

	private Controleur controleur;
	private JFrame framePrincipale;

	private PanelNobles    panelNobles;
	private PanelJetons    panelJetons;
	private PanelCartesDos panelCartesDos;
	private PanelCartes    panelCartes;

	public FramePlateau(Controleur controleur) {
		this.controleur = controleur;

		this.framePrincipale = new JFrame("Splendor");
		this.framePrincipale.setLayout(new BorderLayout());

		this.panelNobles    = new PanelNobles   (this.controleur, "Plateau");
		this.panelJetons    = new PanelJetons   ("plateau", this.controleur);
		this.panelCartesDos = new PanelCartesDos(this.controleur);
		this.panelCartes    = new PanelCartes   (this.controleur);

		this.framePrincipale.add( "North" , this.panelNobles    );
		this.framePrincipale.add( "South" , this.panelJetons    );
		this.framePrincipale.add( "West"  , this.panelCartesDos );
		this.framePrincipale.add( "Center", this.panelCartes    );

		// this.framePrincipale.add(this.panelPrincipal);

		this.framePrincipale.setVisible(true);
        this.framePrincipale.setSize(800,960);
        this.framePrincipale.setLocation(0,10);
		// this.framePrincipale.setResizable(false);
        this.framePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void updateCartes() {
		this.panelCartes = new PanelCartes(this.controleur);
		this.framePrincipale.add("Center", this.panelCartes);
	}

	public PanelJetons getPanelJetons() {
		return this.panelJetons;
	}
}