import java.util.ArrayList;


/**
 * Classe Mere ou les methodes necessaires aux classes de polynomes(formules) se retrouvent.
 * <code>attributs tab, tabX, tabXPrime utilisés pour les calcules liés aux formules.</code>
 */
public class Echantillonage {
    protected ArrayList<Double> tab;
    protected ArrayList<Double> tabX = new ArrayList<>();
    protected ArrayList<Double> tabXPrime = new ArrayList<>();

    /** Construit la classe avec les param recus. Declenche la methode qui remplit les deux nouveau tableaux necessaires
     *
     * @param tab tableau avec les valeurs du fichier lu, recu en tant que Arraylist Double deja converti.
     */
    public Echantillonage(ArrayList<Double> tab) {
        this.tab = tab;
        remplirTableaux();
    }


    /**
     * Remplit tabX avec ces valeurs correspondantes a partir des informations de l'attribut tab.
     * Nb de valeurs de x et le meme que le nb de valeurs y fourni dans l'attribut tab.
     * <code>var X, contient les X modifiés et qui sont placés dans tabX</code>
     */
    public void remplirTabX () {
        double x;
        for (x = tab.get(1); tabX.size() < tab.size() -4; x += (tab.get(2))){
            tabX.add(x);
        }
    }

    /**
     * Remplit tabXPrime avec ces valeurs correspondantes a partir des informations de l'attribut tab et la var m.
     * <code>var m, indicatif du nb de X' requis dans la liste tabXPrime</code>
     */
    public void remplirTabXPrime () {
        double m = calculerM();
        double xPrime;
        for (xPrime = tab.get(1); tabXPrime.size() < m; xPrime += (tab.get(3))){
            tabXPrime.add(xPrime);
        }
    }

    /** Calcule le nb de X' requis dans la liste tabXPrime
     *
     * @return le nb de X' requis dans la liste tabXPrime
     */
    public double calculerM(){
        return Math.round(((((tabX.size()-1)*tab.get(2))/tab.get(3))+1));
    }

    //Aide visuel des tableaux remplies.
    public void print (){
        System.out.println(tab);
        System.out.println(tabX);
        System.out.println(tabXPrime+"\n");
    }


    /** Calcule la variable 'a' necessaire dans la formule de la classe PolynomeDeux.
     *
     * @param varJointe Derniere(du haut ver le bas) variable delta donnée dans le doc TP1 pour la deuxieme formule.
     * @return variable 'a' de la formule correspondante.
     */
    public double calculerVarA2(double varJointe){
        return varJointe/(2*Math.pow(tab.get(2),2));
    }


    /** Calcule la variable 'b' necessaire dans la formule de la classe PolynomeDeux.
     *
     * @param yI Premiere(du haut ver le bas) variable delta donnée dans le doc TP1 pour la 2ieme formule.
     * @param a variable a de la formule (classe PolynomeDeux)
     * @param i compteur requis pour chercher les bons elements dans les tableaux correspondants.
     * @return variable 'b' de la formule correspondante.
     */
    public double calculerVarB2(double yI, double a,int i){
        return (yI/tab.get(2)-(a*((tabX.get(i)+tabX.get(i+1)))));
    }

    /** Calcule la variable 'c' necessaire dans la formule de la classe PolynomeDeux.
     *
     * @param b variable b de la formule (classe PolynomeDeux)
     * @param a variable a de la formule (classe PolynomeDeux)
     * @param i compteur requis pour chercher les bons elements dans les tableaux correspondants.
     * @return variable 'c' de la formule correspondante.
     */
    public double calculerVarC2(double b, double a, int i){
        return ((tab.get(i+4))-(b*(tabX.get(i)))-a*((Math.pow(tabX.get(i),2))));
    }


    /** Calcule la variable 'a' necessaire dans la formule de la classe PolynomeTrois.
     *
     * @param varTroisPoints Derniere(du haut ver le bas) variable delta donnée dans le doc TP1 pour la 3ieme formule.
     * @return variable 'a' de la formule correspondante.
     */
    public double calculerVarA3(double varTroisPoints){
        return ((varTroisPoints / (6 * Math.pow(tab.get(2), 3))));
    }


    /** Calcule la variable 'b' necessaire dans la formule de la classe PolynomeTrois.
     *
     * @param varJointe Quatrieme(du haut ver le bas) variable delta donnée dans le doc TP1 pour la 3ieme formule.
     * @param a variable a de la formule (classe PolynomeTrois)
     * @param i compteur requis pour chercher les bons elements dans les tableaux correspondants.
     * @return variable 'b' de la formule correspondante.
     */
    public double calculerVarB3(double varJointe, double a,int i){
        return ((varJointe/(2*(Math.pow(tab.get(2),2))))-a*(tabX.get(i)+tabX.get(i+1)+tabX.get(i+2)));
    }

    /** Calcule la variable 'c' necessaire dans la formule de la classe PolynomeTrois.
     *
     * @param yI Premiere(du haut ver le bas) variable delta donnée dans le doc TP1 pour la 3ieme formule.
     * @param b variable b de la formule (classe PolynomeTrois)
     * @param a variable a de la formule (classe PolynomeTrois)
     * @param i compteur requis pour chercher les bons elements dans les tableaux correspondants.
     * @return variable 'c' de la formule correspondante.
     */
    public double calculerVarC3(double yI, double b, double a, int i){
        return (((yI)/tab.get(2))-(b*(tabX.get(i)+tabX.get(i+1)))-(a*(Math.pow(tabX.get(i),2)+
                (tabX.get(i)*tabX.get(i+1))+(Math.pow(tabX.get(i+1),2)))));
    }


    /** Calcule la variable 'd' necessaire dans la formule de la classe PolynomeTrois.
     *
     * @param c variable c de la formule (classe PolynomeTrois)
     * @param b variable b de la formule (classe PolynomeTrois)
     * @param a variable a de la formule (classe PolynomeTrois)
     * @param i compteur requis pour chercher les bons elements dans les tableaux correspondants.
     * @return variable 'd' de la formule correspondante.
     */
    public double calculerVarD3(double c, double b, double a, int i){
        return ((tab.get(i+4))-(c*(tabX.get(i)))-(b*(Math.pow(tabX.get(i),2)))-(a*(Math.pow(tabX.get(i),3))));
    }


    /**
     * Affiche message d'erreur si objet inattendu dans la fichier fourni, termine aussi le programme.
     */
    public static void erreur(){
        System.out.println("Erreur, Il y a un objet inattendu dans votre liste");
        System.exit( -1 );
    }

    /**
     * Appelle les deux methodes qui remplissent leurs tableaux respectifs.
     */
    public void remplirTableaux(){
        remplirTabX();
        remplirTabXPrime();
        //print();
    }

}
