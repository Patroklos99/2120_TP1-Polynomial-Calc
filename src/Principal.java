import java.util.ArrayList;
import java.util.Scanner;


public class Principal {

    /** Lance le programme principal et tous le code source du deroulement.
     *
     * @param args
     * <code>var nom, string du nom du fichier ecrit par l'usager</code>
     */
    public static void main(String[] args) {
        msgEntree();
        Scanner clavier = new Scanner( System.in );
        String nom = clavier.nextLine();
        clavier.close();
        ArrayList<Double> tab = Lecture.lireFichier(nom);
        reechantillonage(tab);
    }


    /** Trie le tableau des valeurs du fichier lu vers la classe correspondate.
     *
     * @param tab tableau (arraylist) contenant les valeurs du fichier lu.
     */
    public static void reechantillonage(ArrayList<Double> tab){
        if(tab.get(0) == 1)
            creerClasseDegreUn(tab);
        else if(tab.get(0) == 2)
            creerClasseDegreDeux(tab);
        else if(tab.get(0) == 3)
            creerClasseDegreTrois(tab);
        else
            Echantillonage.erreur();
    }

    /** Crée la classe PolynomeUn ou le calcule avec la premiere formule sera fait.
     *
     * @param tab tableau (arraylist) contenant les valeurs du fichier lu.
     */
    public static void creerClasseDegreUn(ArrayList<Double> tab) {
        PolynomeUn un = new PolynomeUn(tab);
    }

    /** Crée la classe PolynomeDeux ou le calcule avec la deuxieme formule sera fait.
     *
     * @param tab tableau (arraylist) contenant les valeurs du fichier lu.
     */
    public static void creerClasseDegreDeux(ArrayList<Double> tab) {
        PolynomeDeux deux = new PolynomeDeux(tab);
    }

    /** Crée la classe PolynomeTrois ou le calcule avec la troisieme formule sera fait.
     *
     * @param tab tableau (arraylist) contenant les valeurs du fichier lu.
     */
    public static void creerClasseDegreTrois(ArrayList<Double> tab) {
        PolynomeTrois trois = new PolynomeTrois(tab);
    }

    /**
     * Affiche le message initial informatif pour l'usager.
     */
    public static void msgEntree(){
        System.out.println("\nVeuillez entrer le nom de votre fichier dans le terminal (suivi de son suffixe s'il " +
                " possede un):");
    }

}
