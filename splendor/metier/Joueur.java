package splendor.metier;

import splendor.Controleur;

public class Joueur
{
	private Controleur controleur;
	private int action;
	private int numero;
	private int points;
	private int[] cartes;
	private int[] jetons;
	private Carte carteReserve;

	public Joueur(Controleur controleur, int numero)
	{
		this.controleur   = controleur;
		this.action       = -1;
		this.numero 	  = numero;
		this.points 	  = 0;
		this.cartes 	  = new int[5];
		this.jetons  	  = new int[6];
		this.carteReserve = null;
	}

	public void commencerTour() {
		this.action = -1;
		this.controleur.getFrameJoueur(this.numero).setBlockedWindow();
	}

	public void finirTour() {

		this.action = -1;
		this.controleur.getFrameJoueur(this.numero).setBlockedWindow();
	
		for(int i = 0; i < 3; i++) {
			if(canGetNoble(i, 0)) {
				System.out.println("tu as le noble " + i);
			}
		}

		if(aGagner()) System.out.println("gg");
	}

	public boolean canGetNoble(int i, int pos) {
		if(pos < 4)
			return this.cartes[pos] >= this.controleur.getPlateau().getNoble(i).getCout(pos) && canGetNoble(i, pos + 1);
	
		return this.cartes[pos] >= this.controleur.getPlateau().getNoble(i).getCout(pos);
	}

	public void jouerTour(int action) {
		// System.out.println("Joueur n°" + this.numero + " " + action);

		this.action = action;
	}

	public void setCarteReserve(Carte carte) { this.carteReserve = carte; }
	public void supprimerCarteReserve()      { this.carteReserve = null;  }
	
	public int getAction() {
		return this.action;
	}

	public int[] coutJetons(int[] cout) {
		int[] array = new int[5];
		for(int i = 0; i < array.length; i++) 
			array[i] = (cout[i] - this.cartes[i] >= 0) ? cout[i] - this.cartes[i] : 0; 
		
		return array;
	}

	public void ajouterJetons(int i, int q) {
		this.jetons[i] += q;
	}

	public void enleverJetons(int i, int q) {
		this.jetons[i] -= q;
	}

	public void enleverJetons(int[] array) {
		for(int i = 0; i < array.length; i++)
			this.jetons[i] -= array[i];
	}

	public void ajouterCarte(Carte carte) {
		for(int i = 0; i < this.controleur.COULEURS.length - 1; i++) 
			if(carte.getCouleur().equals(this.controleur.COULEURS[i])) 
				this.cartes[i] += 1;
	}

	public void setPoints(int points) { 
		this.points += points; 
		if(aGagner()) System.out.println("bravo");
	}

	private boolean aGagner() { return this.points >= 15; }

	public int   getNumero()       { return this.numero; }
	public int   getPoints()       { return this.points; }
	public int[] getCartes()       { return this.cartes; }
	public int   getCarte(int i)   { return this.cartes[i]; }
	public int[] getJetons()       { return this.jetons; }
	public int   getJeton(int i)   { return this.jetons[i]; }
	public Carte getCarteReserve() { return this.carteReserve; }

	public void afficherJetons() {
		for(int i : this.jetons)
			System.out.print(i);

		System.out.println();
	}

	public void afficherCartes() {
		for(int i : this.cartes)
			System.out.print(i);

		System.out.println();
	}


	public String toString() { 
		return ""; 
	}
}
 