package splendor.metier;

import splendor.Controleur;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreerCartes {

    private Controleur controleur;
    private int age;
    private int[] cout;
    private int points;
    private String couleur;
    private String url;
    private ArrayList<Carte> cartes;

    public CreerCartes(Controleur controleur) throws IOException {

        this.cartes = new ArrayList<>();
        this.controleur = controleur;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.controleur.CHEMIN_DATA + "cartes.txt"));
            String ligne = reader.readLine();
            
            int cpt = 1;

            while(ligne != null) {
                
                this.age     = CreerCartes.donnerAge(cpt);
                this.cout    = CreerCartes.donnerTableauCout(ligne.substring(0,5));
                this.points  = Integer.parseInt(ligne.substring(6, 7));
                this.couleur = CreerCartes.donnerCouleur(cpt);
                this.url     = CreerCartes.donnerUrl(cpt);

                this.cartes.add(new Carte(this.age, this.cout, this.points, this.couleur, this.url));

                ligne = reader.readLine();
                cpt++;
            }
            
            reader.close();
            
        } catch(Exception e) { System.out.println(e); }
    }

    public ArrayList<Carte> getCartes() { 
        return this.cartes;
    }

    public static <T> void afficherCartes(ArrayList<T> array) {
        for(T e : array)
            System.out.println(e.toString());
    }

    public static int[] donnerTableauCout(String s) {
        int[] array = new int[5];
        for(int i = 0; i < s.length(); i++)
            array[i] = s.charAt(i) - 48;

        return array;
    }

    private static int donnerAge(int i) {
        if(i <= 40           ) return 1;
        if(i >  40 && i <= 70) return 2;

        return 3;
    }

    private static String donnerUrl(int i) {
        if(i <= 40)            return (i < 10)      ? "dev_I_0"   +  i       + ".png" : "dev_I_"   +  i       + ".png";
        if(i >= 41 && i <= 70) return (i - 40 < 10) ? "dev_II_0"  + (i - 40) + ".png" : "dev_II_"  + (i - 40) + ".png";
                               return (i - 70 < 10) ? "dev_III_0" + (i - 70) + ".png" : "dev_III_" + (i - 70) + ".png";
    }


    private static String donnerCouleur(int i) {

        int intervalle = 8;
        if(CreerCartes.donnerAge(i) == 2) { intervalle = 6; i -= 40; }
        if(CreerCartes.donnerAge(i) == 3) { intervalle = 4; i -= 70; }
        
        if(                           i <=     intervalle) return "blanc";
        if(i >=     intervalle + 1 && i <= 2 * intervalle) return "bleu";
        if(i >= 2 * intervalle + 1 && i <= 3 * intervalle) return "vert";
        if(i >= 3 * intervalle + 1 && i <= 4 * intervalle) return "rouge";
        return "marron";
    }
}
    