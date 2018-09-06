package ca.cours5b5.stevendesroches.modeles;

import java.util.List;

import ca.cours5b5.stevendesroches.serialisation.AttributSerialisable;

public class MParametres extends Modele {

    public static MParametres instance;

    @AttributSerialisable
    public Integer hauteur;

    @AttributSerialisable
    public Integer largeur;

    @AttributSerialisable
    public Integer pourGagner;

    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public MParametres()

    public List<Integer> getChoixHauteur()
    public List<Integer> getChoixLargeur()
    public List<Integer> getChoixPourGagner()

    public Integer getHauteur()
    public Integer getLargeur()
    public Integer getPourGagner()

    public void setHauteur(int hauteur)
    public void setLargeur(int largeur)
    public void setPourGagner(int pourGagner)

    private void genererListesDeChoix()

    private List<Integer> genererListeChoix(int min, int max)

    private void genererListesDeChoixHauteur()
    private void genererListesDeChoixLargeur()
    private void genererListesDeChoixPourGagner()

}
