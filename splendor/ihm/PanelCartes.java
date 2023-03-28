package splendor.ihm;

import splendor.Controleur;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelCartes extends JPanel implements MouseListener {
	
	private Controleur controleur;

	private JPanel panelCartes;
	private JLabel[][] labelsCartes;

	public PanelCartes(Controleur controleur) {

		this.controleur = controleur;

		this.panelCartes = new JPanel();
		this.panelCartes.setLayout(new GridLayout(3,4));

		this.labelsCartes = new JLabel[3][4];

		for(int i = 0; i < this.labelsCartes.length; i++) {
			for(int j = 0; j < this.labelsCartes[i].length; j++) {

				this.labelsCartes[i][j] = new JLabel(new ImageIcon(this.controleur.CHEMIN_IMG + this.controleur.getPlateau().getCarteAge(i + 1, j).getUrl()));
				this.labelsCartes[i][j].addMouseListener(this);
				this.panelCartes.add(this.labelsCartes[i][j]);
			}
		}

		this.add(this.panelCartes);
	}

	private static boolean peutPayer(int[] cartes, int[] jetons, int[] cout) {
		
		for(int i = 0; i < jetons.length - 1; i++) 
			if(cartes[i] + jetons[i] < cout[i]) 
				return false;
			
		return true;
	}

	public void remplacerCarte(int i) {

		for(int j = 0; j < 4; j++) 
			this.labelsCartes[i][j].setIcon(new ImageIcon(this.controleur.CHEMIN_IMG + this.controleur.getPlateau().getCarteAge(i + 1, j).getUrl()));
	}

	
	public void mouseClicked(MouseEvent e) {
	
		if(this.controleur.getPlateau().getJoueurActuel().getAction() != -1) {
		
			int action = this.controleur.getPlateau().getJoueurActuel().getAction();

			if(action == 2) {
				for(int i = 0; i < this.labelsCartes.length; i++) {
					for(int j = 0; j < this.labelsCartes[i].length; j++) {
						if(this.labelsCartes[i][j] == e.getSource()) {
							if(PanelCartes.peutPayer(this.controleur.getPlateau().getJoueurActuel().getCartes(), this.controleur.getPlateau().getJoueurActuel().getJetons(), this.controleur.getPlateau().getCarteAge(i + 1, j).getCout()))	{

								//* Tableau entier donnant le coup restant a payer en jetons 
								int[] coutJetons = this.controleur.getPlateau().getJoueurActuel().coutJetons(this.controleur.getPlateau().getCarteAge(i + 1, j).getCout());
								//* Rajoute les jetons au plateau
								this.controleur.getPlateau().ajouterJetons(coutJetons);
								//* Enleve les jetons au joueur
								this.controleur.getPlateau().getJoueurActuel().enleverJetons(coutJetons);
								
								//* Ajout les points de la carte au joueur
								this.controleur.getPlateau().getJoueurActuel().setPoints(this.controleur.getPlateau().getCarteAge(i + 1, j).getPoints());
								this.controleur.getFrameJoueur(this.controleur.getPlateau().getJoueurActuel().getNumero()).getPanelPointsJoueur().updatePoints();
								//* Donne un jeton "carte" au joueur
								this.controleur.getPlateau().getJoueurActuel().ajouterCarte(this.controleur.getPlateau().getCarteAge(i + 1, j));
								
								//* Met a jour les labels du joueur
								this.controleur.getFrameJoueur(this.controleur.getPlateau().getJoueurActuel().getNumero()).getPanelJetons().updateAll('j');
								//* Met a jour les labels du plateau
								this.controleur.getFramePlateau().getPanelJetons().updateAll('p');
								

								//TODO Methodes affichages
								//this.controleur.getPlateau().getJoueurActuel().afficherCartes();
								//this.controleur.getPlateau().getJoueurActuel().afficherJetons();
								
								//* Supprimer la carte achetée de l'ArrayList
								this.controleur.getPlateau().supprimerCarte(i + 1, j);
								//* Remplace l'image de l'ImageIcon par la nouvelle
								this.remplacerCarte(i);
								
								//* Change le joueur actuel et fais toutes les verifications de fin de tour
								this.controleur.getPlateau().changementTour();
							}  
						}
					}
				}
			}

			if(action == 3) {
				this.controleur.getPlateau().changementTour();
			}
		}
	}			

	public void mousePressed  (MouseEvent e) {}
	public void mouseReleased (MouseEvent e) {}
	public void mouseExited   (MouseEvent e) {}
	public void mouseEntered  (MouseEvent e) {}
}