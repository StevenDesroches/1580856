package ca.cours5b5.stevendesroches.modeles;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ca.cours5b5.stevendesroches.global.GConstantes;

import ca.cours5b5.stevendesroches.serialisation.AttributSerialisable;

public class MParametres extends Modele {

    public static MParametres instance = new MParametres();

    @AttributSerialisable
    public MParametresPartie parametresPartie;
    private String __parametresPartie = "parametresPartie";

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres(){

    }

    @AttributSerialisable
    public Integer hauteur = GConstantes.HAUTEUR_DEFAULT;;
    private final String __hauteur ="hauteur";

    @AttributSerialisable
    public Integer largeur = GConstantes.LARGEUR_DEFAULT;;
    private final String __largeur ="largeur";

    @AttributSerialisable
    public Integer pourGagner = GConstantes.GAGNER_DEFAULT;;
    private final String __pourGagner ="pourGagner";

    public List<Integer> getChoixHauteur(){
        List<Integer> liste = new ArrayList<>();

        for (int i = GConstantes.HAUTEUR_MIN; i <= GConstantes.HAUTEUR_MAX; i++) {
            liste.add(i);
        }

        return liste;
    }
    public List<Integer> getChoixLargeur(){
        List<Integer> liste = new ArrayList<>();

        for (int i = GConstantes.LARGEUR_MIN; i <= GConstantes.LARGEUR_MAX; i++) {
            liste.add(i);
        }

        return liste;
    }

    public List<Integer> getChoixPourGagner(){
        List<Integer> liste = new ArrayList<>();

        for (int i = GConstantes.GAGNER_MIN; i <= GConstantes.GAGNER_MAX; i++) {
            liste.add(i);
        }

        return liste;
    }

    public MParametresPartie getParametresPartie(){
        return null;
    }

    private void genererListesDeChoix(){}

    private List<Integer> genererListeChoix(int min, int max){
        return null;
    }

    private List<Integer> genererListeChoixHauteur(){
        return null;
    }

    private List<Integer> genererListeChoixLargeur() {
        return null;
    }

    private List<Integer> genererListeChoixPourGagner(){
        return null;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

        for(Map.Entry<String, Object> entry : objetJson.entrySet()){
            String cle = entry.getKey();
            Object valeur = entry.getValue();
            valeur = valeur.toString().substring(0, valeur.toString().indexOf("."));

            if (cle.equals(__hauteur)){
                hauteur = Integer.valueOf(valeur.toString());
            } else if (cle.equals(__largeur)){
                largeur = Integer.valueOf(valeur.toString());
            } else if (cle.equals(__pourGagner)){
                pourGagner = Integer.valueOf(valeur.toString());
            }
        }

    }

    @Override
    public Map<String, Object> enObjetJson() {
        Map<String, Object> json = new HashMap<>();

        json.put(__hauteur, hauteur);
        json.put(__largeur, largeur);
        json.put(__pourGagner, pourGagner);

        return json;
    }

}
