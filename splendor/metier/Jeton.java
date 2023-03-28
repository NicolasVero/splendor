package splendor.metier;

public class Jeton {
	
	private String couleur;

	public Jeton(String couleur) {
		this.couleur = couleur;
	}

	public String getCouleur() { return this.couleur; }
	public String toString() { return this.couleur; }
}