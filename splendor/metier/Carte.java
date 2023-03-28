package splendor.metier;

public final class Carte extends CarteDos {

    private int[] cout;
    private int    points;
    private String couleur;

    public Carte(int age, int[] cout, int points, String couleur, String url) {
        
        super(age, url);
        this.cout = cout;
        this.points = points;
        this.couleur = couleur;
    }

    public int[] getCout() {
        return this.cout;
    }

    public String getCoutString() {
        String s = "";
        for(int i = 0; i < this.cout.length; i++)
            s += this.cout[i];

        return s;
    }

    public int getPoints() {
        return this.points;
    }

    public String getCouleur() {
        return this.couleur;
    } 

    public String toString() {
        return " " + this.getCoutString() + " " + this.points + " " + this.couleur;
    }
}