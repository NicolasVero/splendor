package splendor.ihm;

import splendor.Controleur;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelJetons extends JPanel implements MouseListener {

	private Controleur controleur;
	private String     nomClasse;
	private String[]   jetonsPris;

	private JPanel     panelPrincipal;

	private JPanel     panelJetons;
	private JLabel[]   labelsJetons;

	private JPanel 	   panelNombreJetons;
	private JLabel[]   labelsNombreJetons;


	public PanelJetons(String nomClasse, Controleur controleur) {

		this.controleur = controleur;
		this.nomClasse  = nomClasse;
		this.jetonsPris = new String[3];

		this.panelPrincipal    = new JPanel();
		this.panelJetons       = new JPanel();
		this.panelNombreJetons = new JPanel();


		this.panelPrincipal.setLayout(new BorderLayout());
		this.panelJetons.setLayout(new GridLayout(0,6));
		this.panelNombreJetons.setLayout(new GridLayout(0,6));


		this.labelsJetons       = new JLabel[6];
		this.labelsNombreJetons = new JLabel[6];

		for(int i = 0; i < this.labelsJetons.length; i++) {
			this.labelsJetons[i] = new JLabel(new ImageIcon(this.controleur.CHEMIN_IMG + "jeton_" + this.controleur.COULEURS[i] + ".png"));

			if(this.nomClasse.equals("plateau")) {
				if(i != this.labelsJetons.length - 1)
					this.labelsJetons[i].addMouseListener(this);
					
				this.panelJetons.add(this.labelsJetons[i]);
				this.labelsNombreJetons[i] = new JLabel("" + this.controleur.getPlateau().getJeton(i));
			}
			else {
				this.panelJetons.add(this.labelsJetons[i]);

				if(i != this.labelsJetons.length - 1)
					this.labelsNombreJetons[i] = new JLabel("J: 0 | C : 0");
				else 
					this.labelsNombreJetons[i] = new JLabel("J : 0");
			}

			this.labelsNombreJetons[i].setHorizontalAlignment(SwingConstants.CENTER);
			this.panelNombreJetons.add(this.labelsNombreJetons[i]);
		}

		this.panelPrincipal.add("North", this.panelJetons);
		this.panelPrincipal.add("South", this.panelNombreJetons);

		this.add(this.panelPrincipal);
	}

	public void update(char appel, int i, int jetons) {
		if(appel == 'j')		
			this.labelsNombreJetons[i].setText("J : " + jetons + " | C : " + this.controleur.getPlateau().getJoueurActuel().getCarte(i));

		if(appel == 'p')
			this.labelsNombreJetons[i].setText("" + jetons);
	}

	public void updateAll(char appel) {
		if(appel == 'j')	
			for(int i = 0; i < this.labelsNombreJetons.length; i++)	
				this.labelsNombreJetons[i].setText((i != this.labelsNombreJetons.length - 1) ? "J : " + this.controleur.getPlateau().getJoueurActuel().getJeton(i) + " | C : " + this.controleur.getPlateau().getJoueurActuel().getCarte(i) : "J : " + this.controleur.getPlateau().getJoueurActuel().getJeton(i));
			

		if(appel == 'p')
			for(int i = 0; i < this.labelsNombreJetons.length; i++)	
				this.labelsNombreJetons[i].setText("" + this.controleur.getPlateau().getJeton(i));
	}

	private static int cardinal(String[] s) {
		int i = 0;

		for(String string : s)
			if(string != null)
				i++;
	
		return i;
	}

	private void resetTableauJetonsPris() {
		this.jetonsPris = new String[3];
	}

	private static boolean existe(String[] t, String s) {  
        for(String str : t)
            if(str == s)
                return true;

        return false;
    }

	private String getCouleurJeton(int i) {
		return this.controleur.COULEURS[i];
	}

	private int getIndiceJeton(String s) {
		return indexOf(this.controleur.COULEURS, s);
	}

	private static int indexOf(String[] t, String s) {
		int i = 0;
		for(String str : t) {
			if(s.equals(str))
				return i;
			else 
				i++;
		}

		return -1;
	}

	private static void aff(String[] s) {
		for(String str : s)
			System.out.println("--> " + str);

		System.out.println("--------------------");
	}


	public void mouseClicked(MouseEvent e) {
		
		if(this.controleur.getPlateau().getJoueurActuel().getAction() != -1) {
		
			int action = this.controleur.getPlateau().getJoueurActuel().getAction();

			if(action == 0) {
				for(int i = 0; i < this.labelsJetons.length; i++) {
					if(this.labelsJetons[i] == e.getSource()) {
						if(!PanelJetons.existe(this.jetonsPris, this.getCouleurJeton(i))) {
							this.jetonsPris[PanelJetons.cardinal(this.jetonsPris)] = this.getCouleurJeton(i);
						}
					}
				}

				if(PanelJetons.cardinal(this.jetonsPris) >= 3) {
					
					for(int i = 0; i < this.jetonsPris.length; i++) {
						this.controleur.getPlateau().getJoueurActuel().ajouterJetons(this.getIndiceJeton(this.jetonsPris[i]), 1);
						this.controleur.getPlateau().enleverJetons(this.getIndiceJeton(this.jetonsPris[i]), 1);					
					}

					this.controleur.getFrameJoueur(this.controleur.getPlateau().getJoueurActuel().getNumero()).getPanelJetons().updateAll('j');
					this.updateAll('p');

					this.resetTableauJetonsPris();
					aff(this.jetonsPris);
					this.controleur.getPlateau().changementTour();
				}
			}

			
			if(action == 1) 
				for(int i = 0; i < this.labelsJetons.length; i++) 
					if(this.labelsJetons[i] == e.getSource()) 
						if(this.controleur.getPlateau().getNombreJeton(i) >= 4) {
							this.controleur.getPlateau().enleverJetons(i, 2);
							this.controleur.getPlateau().getJoueurActuel().ajouterJetons(i, 2);

							this.controleur.getFrameJoueur(this.controleur.getPlateau().getJoueurActuel().getNumero()).getPanelJetons().update('j', i, this.controleur.getPlateau().getJoueurActuel().getJeton(i));
							this.update('p', i, this.controleur.getPlateau().getJeton(i));
							this.controleur.getPlateau().changementTour();
						}
					
		}
	}	

	public void mousePressed  (MouseEvent e) {}
	public void mouseReleased (MouseEvent e) {}
	public void mouseExited   (MouseEvent e) {}
	public void mouseEntered  (MouseEvent e) {}

}