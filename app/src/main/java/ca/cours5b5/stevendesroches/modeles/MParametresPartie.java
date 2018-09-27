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

        return null;
    }

    public MParametresPartie cloner(){

        return null;
    }

    public MParametresPartie(){

    }

    public Integer getHauteur(){
        return null;
    }

    public Integer getLargeur(){
        return null;
    }

    public Integer getPourGagner(){
        return null;
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
