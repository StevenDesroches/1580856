package ca.cours5b5.stevendesroches.modeles;

import android.util.Log;

import java.util.Map;

import ca.cours5b5.stevendesroches.global.GConstantes;
import ca.cours5b5.stevendesroches.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele {

    @AttributSerialisable
    public Integer hauteur = GConstantes.HAUTEUR_DEFAULT;
    private final String __hauteur ="hauteur";

    @AttributSerialisable
    public Integer largeur = GConstantes.LARGEUR_DEFAULT;
    private final String __largeur ="largeur";

    @AttributSerialisable
    public Integer pourGagner = GConstantes.GAGNER_DEFAULT;
    private final String __pourGagner ="pourGagner";

    public static MParametresPartie aPartirMParametres(MParametres mParametres){
        MParametresPartie partie = new MParametresPartie();
        partie.setHauteur(mParametres.parametresPartie.hauteur);
        partie.setLargeur(mParametres.parametresPartie.largeur);
        partie.setPourGagner(mParametres.parametresPartie.pourGagner);

        //Modele mParam = mParametres;
        //MParametresPartie classe = (MParametresPartie) mParam;
        Log.d("Atelier06", "::avant partie.cloner");
        return partie.cloner();

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
