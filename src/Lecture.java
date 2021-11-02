import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


/**
 * Classe ou la lecture et l'ecriture ainsi que les configurations necessaires/liées à ceux-ci se retrouvent.
 */
public class Lecture {

    /** Initialise les configurations pour la lecture et l'ecriture du fichier fourni.
     *
     * @param nom Nom du fichier fourni.
     * @return Arraylist simple contenant les valeurs du fichier lu.
     * <code>var sc, contiendra les valeurs lus. </code>
     */
    public static ArrayList lireFichier(String nom){
        ArrayList<Double> tabValeur = new ArrayList<>();
        try {     Path path = FileSystems.getDefault().getPath(nom);
            verifierFichierReel(path);
            Scanner sc = new Scanner(Files.newBufferedReader(path));
            sc.useLocale( Locale.CANADA );
            ecrireValeurs(sc, tabValeur);
            sc.close();
        } catch ( InvalidPathException e ) {
            // Traitement d'erreur ici.
        } catch ( IOException e ) {
            // Traitement d'erreur ici.
        }
        return tabValeur;
    }


    /** Verifie si le fichier existe, appelle une autre methode pour l'arret du programme s'il n'existe pas.
     *
     * @param path contient le chemin relatif du fichier fourni.
     * <code>file, contient le chemin relatif du fichier fourni, sert a verifier l'existance de celui-ci</code>
     */
    private static void verifierFichierReel(Path path) {
        File file = new File(String.valueOf(path));
        if (!file.exists()){
            msgErrFichier();
        }
    }


    /** Ecrit les valeurs du fichier fourni dans un seul tableau.
     *
     * @param sc objet de type scanner, sert a verifier le contenu des lignes lues du fichier.
     * @param tabValeur tableau ou les valeurs seront placées.
     */
    public static void ecrireValeurs (Scanner sc, ArrayList tabValeur){
        while (sc.hasNext()) {
            if (sc.hasNextInt())
                tabValeur.add((double)sc.nextInt());
            if (sc.hasNextDouble())
                tabValeur.add(sc.nextDouble());
            else {
                tabValeur.add(sc.next());
                errListe(tabValeur);
            }
        }
        errHNegatif(tabValeur);
    }


    /**
     * Affiche msg d'erreur si le fichier n'existe pas et informe l'usager des possibles erreurs dans la saisie.
     * Termine aussi le programme.
     */
    public static void msgErrFichier(){
        System.out.println("Erreur, le fichier ne semble pas exister, le programme terminera." +
                " S'il existe veuillez le reecrire tout de suite apres le message" +
                " d'entree, sans faire espace ou Enter.");
        System.exit( -1 );
    }

    /** Verifie si le contenu du tabValeur est valide, autrement il affiche un message d'erreur et arrete le programme.
     *
     * @param tabValeur tableau ou les valeurs du fichier sont deja placées.
     */
    public static void errListe(ArrayList tabValeur){
        for (int i =0; i <= tabValeur.size(); i++){
            if(!tabValeur.get(i).toString().matches("[0-9]+")) {
                System.out.println("Erreur, Il y a un objet inattendu dans votre liste.");
                System.exit( -1 );
            }
        }
    }

    /** Verifie si les h sont negatifs, autrement il affiche un message d'erreur et arrete le programme.
     *
     * @param tabValeur tableau ou les valeurs du chier sont deja placées.
     */
    public static void errHNegatif(ArrayList tabValeur){
        for (int i =0; i <= tabValeur.size(); i++){
            if( Double.parseDouble(tabValeur.get(2).toString()) < 0 ||
                    Double.parseDouble(tabValeur.get(3).toString()) < 0) {
                System.out.println("Erreur, Il y a un objet innattendu dans votre liste, soit h ou h'" +
                                " est negatif.");
                System.exit( -1 );
            }
        }
    }

}
