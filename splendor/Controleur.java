package splendor;

import splendor.metier.*;
import splendor.ihm.*;

import java.io.IOException;

public class Controleur
{
	public final String CHEMIN_IMG  = "splendor/images/";
	public final String CHEMIN_DATA = "splendor/data/";
	public final String[] COULEURS  = new String[] {"blanc","bleu","marron","rouge","vert","jaune"};

	private Plateau plateau;
	private FramePlateau framePlateau;
	private FrameJoueur frameJoueur1;
	private FrameJoueur frameJoueur2;

	public Controleur() throws IOException {
		
		this.plateau = new Plateau(this);
		this.plateau.setJoueurs();
		this.framePlateau = new FramePlateau(this);
		this.frameJoueur1 = new FrameJoueur(this, this.plateau.getJoueur(0));
		this.frameJoueur2 = new FrameJoueur(this, this.plateau.getJoueur(1));
		this.plateau.setPartie();
	}

	public Plateau getPlateau() { return this.plateau; }
	public FramePlateau getFramePlateau() { return this.framePlateau; }

	public FrameJoueur getFrameJoueur(int i) { 
		if(i == 0) return this.frameJoueur1; 
		if(i == 1) return this.frameJoueur2;
		return null;
	}

	public static void clear() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch(Exception e){ e.printStackTrace(); }
	}

	public static void main(String[] args) throws IOException {
		new Controleur();	
	}
}