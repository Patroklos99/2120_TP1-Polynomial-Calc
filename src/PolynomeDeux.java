import java.util.ArrayList;


/**
 * Classe fille pour le calcule de la deuxieme formule, herite des methodes et attributs de la classe Echantillonage.
 */
public class PolynomeDeux extends Echantillonage {

    /** Construit la classe avec le param recu (a partir de la superClasse Echantillonage et le constructeur de cette
     * derniere). Declenche aussi la methode qui calcule les Y' et les affiche.
     *
     * @param tab tableau avec les valeurs du fichier lu, recu en tant que Arraylist Double deja converti.
     */
    public PolynomeDeux(ArrayList<Double> tab){
        super(tab);
        calculerFormule();
    }

    /** Calcule toutes les variables necessaires (delta + a,b,c)
     * Calcule et affiche les Y' avec la formule. Utilise des methodes herités.
     * <code>compteur, indicateur specifique pour le tableau tabXPrime qui doit uniquement augmenter de 1</code>
     */
    public void calculerFormule(){
        int compteur = 0;
        for (int i = 0; compteur <= tabXPrime.size()-1 ;i++) {
            if (tabX.get(i) <= tabXPrime.get(compteur)) {
                double yI = (tab.get(i + 5) - tab.get(i + 4));
                double yIPlusUn = (tab.get(i + 6) - tab.get(i + 5));
                double varJointe = (yIPlusUn - (yI));
                double a = calculerVarA2(varJointe);
                double b = calculerVarB2(yI, a, i);
                double c = calculerVarC2(b, a, i);
                System.out.println(a * (Math.pow(tabXPrime.get(compteur), 2)) + (b * tabXPrime.get(compteur)) + c);
                //S'il n'y plus de Y dans le tableau tab par rapport au X', on reutilise les derniers Yi et Yi+1 valides
                if(i + 7 == tab.size()){
                    i--;}
                compteur++;
            }
            else {
                i = xPlusGrandXPrime(i, compteur);
                compteur++;
            }
        }

    }

    /** Calcule toutes les variables necessaires (delta + a,b,c)
     * Calcule et affiche les Y' si X > X' avec la formule. Utilise des methodes herités.
     *
     * @param i compteur pour les elements des tableaux tab et tabX
     * @param compteur compteur pour les elements du tableau tabXPrime
     * @return i modifié pour permettre la recherche exacte des elements dans les tableaux concernés.
     * <code>compteur, indicateur specifique pour le tableau tabXPrime qui doit uniquement augmenter de 1</code>
     */
    public int xPlusGrandXPrime(int i, int compteur) {
        i--;
        double yI = (tab.get(i + 5) - tab.get(i + 4));
        double yIPlusUn = (tab.get(i + 6) - tab.get(i + 5));
        double varJointe = (yIPlusUn - (yI));
        double a = calculerVarA2(varJointe);
        double b = calculerVarB2(yI, a, i);
        double c = calculerVarC2(b, a, i);
        System.out.println(a * (Math.pow(tabXPrime.get(compteur), 2)) + (b * tabXPrime.get(compteur)) + c);
        //S'il n'y plus de Y dans le tableau tab par rapport au X', on reutilise les derniers Yi et Yi+1 valides.
        if(i + 7 == tab.size()){
            i--;}
        return i;
    }

}
