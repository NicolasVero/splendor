package splendor.ihm;

import splendor.Controleur;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelNobles extends JPanel implements MouseListener {
	
	private Controleur controleur;

	private JPanel panelNobles;
	private JLabel[] labelsNobles;

	public PanelNobles(Controleur controleur, String appel) {

		this.controleur = controleur;

		this.panelNobles = new JPanel();
		this.panelNobles.setLayout(new GridLayout(0,5));

		this.labelsNobles = new JLabel[5];

		for(int i = 0; i < this.labelsNobles.length; i++) {
			if(i == 0 || i == 4)
				this.labelsNobles[i] = new JLabel();
			else {
				if(appel.equals("Plateau")) {
					this.labelsNobles[i] = new JLabel(new ImageIcon(this.controleur.CHEMIN_IMG + this.controleur.getPlateau().getNoble(i).getUrl()));
					this.labelsNobles[i].addMouseListener(this);
				}
				
				if(appel.equals("Joueur")) {
					this.labelsNobles[i] = new JLabel();
					this.labelsNobles[i].addMouseListener(this);
				}
			}
		
			this.panelNobles.add(this.labelsNobles[i]);
		}

		this.add(this.panelNobles);
	}

	public void mouseClicked(MouseEvent e) {

		for(int i = 0; i < this.labelsNobles.length; i++) 
			if(e.getSource() == this.labelsNobles[i])
				System.out.println(this.controleur.getPlateau().getNoble(i).toString());

	}	

	public void mousePressed  (MouseEvent e) {}
	public void mouseReleased (MouseEvent e) {}
	public void mouseExited   (MouseEvent e) {}
	public void mouseEntered  (MouseEvent e) {}
}