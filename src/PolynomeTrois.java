import java.util.ArrayList;


/**
 * Classe fille pour le calcule de la Troisieme formule, herite des methodes et attributs de la classe Echantillonage.
 */
public class PolynomeTrois extends Echantillonage {

    /** Construit la classe avec le param recu (a partir de la superClasse Echantillonage et le constructeur de cette
     * derniere). Declenche aussi la methode qui calcule les Y' et les affiche.
     *
     * @param tab tableau avec les valeurs du fichier lu, recu en tant que Arraylist Double deja converti.
     */
    public PolynomeTrois(ArrayList<Double> tab) {
        super(tab);
        calculerFormule();
    }

    /** Calcule toutes les variables necessaires (delta + a,b,c,d)
     * Calcule les Y' avec la formule et les affiche. Utilise des methodes herités.
     * <code>compteur, indicateur specifique pour le tableau tabXPrime qui doit uniquement augmenter de 1</code>
     */
    public void calculerFormule() {
        int compteur = 0;
        for (int i = 0; compteur <= tabXPrime.size()-3 ;i++) {
            if(tabX.get(i) <= tabXPrime.get(i)) {
                double yI = (tab.get(i + 5) - tab.get(i + 4));
                double yIPlusUn = (tab.get(i + 6) - tab.get(i + 5));
                double yIPlusDeux = (tab.get(i + 7) - tab.get(i + 6));
                double varJointe = (yIPlusUn - (yI));
                double varJointePlusUn = (yIPlusDeux - (yIPlusUn));
                double varTroisPoints = (varJointePlusUn - (varJointe));
                double a = calculerVarA3(varTroisPoints);
                double b = calculerVarB3(varJointe, a, i);
                double c = calculerVarC3(yI, b, a, i);
                double d = calculerVarD3(c, b, a, i);
                System.out.println((Math.round((a * (Math.pow(tabXPrime.get(i), 3)) +
                        (b * (Math.pow(tabXPrime.get(i), 2)) + (c * tabXPrime.get(i)) + d))*1000000000))/1000000000.0);
                //S'il n'y plus de Y dans le tableau tab par rapport au X', on reutilise les derniers Yi et Yi+1 valides
                if(i + 2 == tab.size())
                    i--;
            }
            else {
                compteur++;
                i = xPlusGrandXPrime(i, compteur);
            }
        }

    }

    /** Calcule toutes les variables necessaires (delta + a,b,c,d)
     * Calcule les Y' si X>XPrime et les affiche. Utilise des methodes herités.
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
        double yIPlusDeux = (tab.get(i + 7) - tab.get(i + 6));
        double varJointe = (yIPlusUn - (yI)) ;
        double varJointePlusUn = (yIPlusDeux- (yIPlusUn)) ;
        double varTroisPoints = (varJointePlusUn- (varJointe));
        double a = calculerVarA3(varTroisPoints);
        double b = calculerVarB3(varJointe, a, i);
        double c = calculerVarC3(yI, b, a, i);
        double d = calculerVarD3(c, b, a, i);
        System.out.println((Math.round((a * (Math.pow(tabXPrime.get(compteur), 3)) +
                (b * (Math.pow(tabXPrime.get(compteur), 2)) + (c * tabXPrime.get(compteur)) + d))*1000000000))/1000000000.0);
        //Si il n'y plus de Y dans le tableau tab, on reutilise les derniers Yi et Yi+1 valides.
        if(i + 2 == tab.size()){
            i--;}
        return i;
    }

}
