package splendor.metier;

import splendor.Controleur;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreerNobles 
{

    private Controleur controleur;
    private ArrayList<Noble> nobles;

    public CreerNobles(Controleur controleur) throws IOException
    {
        this.nobles = new ArrayList<>();
        this.controleur = controleur;

        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(this.controleur.CHEMIN_DATA + "nobles.txt"));
            String ligne = reader.readLine();
            
            int cpt = 1;

            while(ligne != null)
            {
                this.nobles.add(new Noble(ligne, CreerNobles.donnerUrl(cpt)));

                ligne = reader.readLine();
                cpt++;
            }
            
            reader.close();
            
        } catch(Exception e) { System.out.println(e); }

    }
    
    private static String donnerUrl(int i)
    {
        return (i == 10) ? "noble_10.png" : "noble_0" + i + ".png";
    }

    public ArrayList<Noble> getNobles() 
    { 
        return this.nobles;
    }

    public static <T> void afficherNobles(ArrayList<T> array)
    {
        for(T e : array)
            System.out.println(e.toString());
    }
}