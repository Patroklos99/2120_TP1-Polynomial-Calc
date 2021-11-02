import java.util.ArrayList;


/**
 * Classe fille pour le calcule de la premiere formule, herite des methodes et attributs de la classe Echantillonage.
 *
 * A noter que exclusivement et délibérément cette methode a été calculée  a partir de sa formule generale en raison
 *  * d'une pratique personelle de l'etudiant et createur de projet.
 *
 */
public class PolynomeUn extends Echantillonage {

    /** Construit la classe avec le param recu (a partir de la superClasse Echantillonage et le constructeur de cette
     * derniere). Declenche aussi la methode qui calcule les Y' et les affiche.
     *
     * @param tab tableau avec les valeurs du fichier lu, recu en tant que Arraylist Double deja converti.
     */
    public PolynomeUn(ArrayList<Double> tab) {
        super(tab);
        System.out.println(tab);
        System.out.println(tabX);
        System.out.println(tabXPrime + "\n");
        calculerFormule();

    }

    /**
     * Calcule et affiche les Y' avec la formule directement.
     */
    public void calculerFormule(){
        int compteur = 0;
        for (int i = 0; compteur+1 <= tabXPrime.size() ;i++) {
            if(tabX.get(i) <= tabXPrime.get(compteur)) {
                System.out.println((((tab.get(i + 5) - tab.get(i + 4)) / tab.get(2)) * tabXPrime.get(compteur) +
                        tab.get(i + 4) - ((tab.get(i + 5) - tab.get(i + 4)) / tab.get(2)) * tabX.get(i)));
                //Si il n'y plus de Y dans le tableau tab, on reutilise les derniers Yi et Yi+1 valides.
                if(i + 6 == tab.size()){
                    i--;}
            }
            else {
                i = XplusGrandXPrime(i, compteur);
            }
            compteur++;
        }

    }

    /** Calcule et affiche les Y' si X>XPrime avec la formule directement.
     *
     * @param i compteur pour les elements des tableaux tab et tabX
     * @param compteur compteur pour les elements du tableau tabXPrime
     * @return i modifié pour permettre la recherche exacte des elements dans les tableaux concernés.
     */
    public int XplusGrandXPrime(int i, int compteur) {
        i--;
        System.out.println((((tab.get(i + 5) - tab.get(i + 4)) / tab.get(2)) * tabXPrime.get(compteur) +
                tab.get(i + 4) - ((tab.get(i + 5) - tab.get(i + 4)) / tab.get(2)) * tabX.get(i)));
        //Si il n'y plus de Y dans le tableau tab, on reutilise les derniers Yi et Yi+1 valides.
        if(i + 6 == tab.size()){
            i--;}
        return i;
    }

}
