package splendor.metier;

import splendor.Controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Plateau
{
	private Controleur controleur;

	private Joueur[] joueurs;
	private Joueur joueurActuel;

	private ArrayList<Noble> nobles;

	private ArrayList<Carte> cartes;
	private ArrayList<Carte> cartesAge1;
	private ArrayList<Carte> cartesAge2;
	private ArrayList<Carte> cartesAge3;

	// private CarteDos cartesDos;

	private int[] jetons;

	public Plateau(Controleur controleur) throws IOException {

		this.controleur = controleur;
		this.joueurs = new Joueur[2];
		this.joueurActuel = null;
		this.nobles = new CreerNobles(this.controleur).getNobles();
		this.cartes = new CreerCartes(this.controleur).getCartes();
		
		this.cartesAge1 = setPaquet(0 , 40);
		this.cartesAge2 = setPaquet(41, 70);
		this.cartesAge3 = setPaquet(71, 90);
		
		Collections.shuffle(this.nobles);
		Collections.shuffle(this.cartesAge1);
		Collections.shuffle(this.cartesAge2);
		Collections.shuffle(this.cartesAge3);

		// 0 : blanc | 1 : bleu | 2 : marron | 3 : rouge | 4 : vert | 5 : jaune --> alphabétique
		this.jetons = new int[]{7,7,7,7,7,5};
	}

	public void changementTour() {
		this.joueurActuel.finirTour();
		this.changerJoueurActuel();
		this.joueurActuel.commencerTour(); 
	}

	/** Demarre une nouvelle partie */
	public void setJoueurs()
	{
		this.joueurs[0] = new Joueur(this.controleur, 0); 
		this.joueurs[1] = new Joueur(this.controleur, 1); 

		this.joueurActuel = this.joueurs[0];
	}

	public void setPartie()
	{
		this.controleur.getFrameJoueur(0).setBlockedWindow();
	}

	/** Change le joueur actif */
	public void changerJoueurActuel()
	{
		if(this.joueurActuel.getNumero() == 1) 
			this.joueurActuel = this.joueurs[0];
		else 
			this.joueurActuel = this.joueurs[1];
		
	}

	public Joueur getJoueurActuel()
	{
		return this.joueurActuel;
	}

	/**
	 * Donne le joueur actif
	 * @param i
	 * @return 
	 */
	public Joueur getJoueur(int i) { return this.joueurs[i]; }

	public int getJeton(int i){
		return this.jetons[i];
	}

	public String getCouleurJeton(int i){
		return this.controleur.COULEURS[i];
	}

	public int getNombreJeton(int i)
	{
		return this.jetons[i];
	}

	public void ajouterJetons(int[] array) {
		for(int i = 0; i < array.length; i++) 
			this.jetons[i] += array[i];
	}

	public void ajouterJetons(int i, int q) {
		this.jetons[i] += q;
	}

	public void enleverJetons(int i, int q) {
		this.jetons[i] -= q;
	}

	public ArrayList<Noble> getNobles() {
		return this.nobles;
	}

	public Noble getNoble(int i) {
		return this.nobles.get(i);
	}

	public ArrayList<Carte> getCartesAge(int i) {
		if(i == 1) return this.cartesAge1;
		if(i == 2) return this.cartesAge2;
		if(i == 3) return this.cartesAge3;
		
		return null;
	}

	public Carte getCarteAge(int i, int pos) {
		if(i == 1) return this.cartesAge1.get(pos);
		if(i == 2) return this.cartesAge2.get(pos);
		if(i == 3) return this.cartesAge3.get(pos);

		return null;
	}

	public void supprimerCarte(int i, int pos) {
		if(i == 1) this.cartesAge1.remove(pos);
		if(i == 2) this.cartesAge2.remove(pos);
		if(i == 3) this.cartesAge3.remove(pos);

		// System.out.println("suppr : " + i);
	}

	public static void afficherCartes(ArrayList<Carte> cartes) {
        for(Carte c : cartes)
            System.out.println(c.toString());
    }

	private ArrayList<Carte> setPaquet(int init, int end)
	{
		ArrayList<Carte> array = new ArrayList<>();

		for(int i = init; i < end; i++) 
			array.add(this.cartes.get(i));

		return array;
	}
}