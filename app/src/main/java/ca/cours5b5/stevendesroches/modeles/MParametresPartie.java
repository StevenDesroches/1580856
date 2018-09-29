package ca.cours5b5.stevendesroches.modeles;

import java.util.Map;

import ca.cours5b5.stevendesroches.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele{

    @AttributSerialisable
    public Integer hauteur;
    private final String __hauteur ="hauteur";

    @AttributSerialisable
    public Integer largeur;
    private final String __largeur ="largeur";

    @AttributSerialisable
    public Integer pourGagner;
    private final String __pourGagner ="pourGagner";

    public static MParametresPartie aPartirMParametres(MParametres mParametres){

        Modele mParam = mParametres;
        MParametresPartie classe = (MParametresPartie) mParam;
        return classe.cloner();

    }

    public MParametresPartie cloner(){

        MParametresPartie clonage = new MParametresPartie();
        clonage.setHauteur(this.hauteur);
        clonage.setLargeur(this.largeur);
        clonage.setPourGagner(this.pourGagner);

        return clonage;
    }

    public MParametresPartie(){

    }

    public Integer getHauteur(){
        return hauteur;
    }

    public Integer getLargeur(){
        return largeur;
    }

    public Integer getPourGagner(){
        return pourGagner;
    }

    public void setHauteur (int hauteur){
        this.hauteur = hauteur;
    }

    public void setLargeur (int largeur){
        this.largeur = largeur;
    }

    public void setPourGagner (int pourGagner){
        this.pourGagner = pourGagner;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}
