package ca.cours5b5.stevendesroches.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.stevendesroches.exceptions.ErreurSerialisation;
import ca.cours5b5.stevendesroches.global.GCouleur;
import ca.cours5b5.stevendesroches.global.GDirection;


public class MGrille extends Modele  {

    private List<MColonne> colonnes;

    public MGrille(int largeur){

        colonnes = new ArrayList<>();

        initialiserColonnes(largeur);

    }

    private void initialiserColonnes(int largeur) {

        for(int i=0; i<largeur; i++){

            colonnes.add(new MColonne());

        }
    }


    public List<MColonne> getColonnes() {
        return colonnes;
    }


    public void placerJeton(int colonne, GCouleur couleur) {

        colonnes.get(colonne).placerJeton(couleur);

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

    //public boolean siCouleurGagne(GCouleur couleur, int pourGagner){return false;}

    private boolean siCouleurGagneCetteColonne(GCouleur couleur, int idColonne, int pourGagner){
        Boolean retour = false;
        MColonne col = colonnes.get(idColonne);
        int nombreJetons = col.nombreDeJetons();

        if (nombreJetons >= pourGagner){
            List<GCouleur> liste = col.getJetons();
            int compteur = 0;
            for (GCouleur couleurCase : liste) {

                if (couleurCase.equals(couleur)){
                    compteur++;
                } else {
                    compteur = 0;
                }
                if (compteur == pourGagner){
                    retour = true;
                    break;
                }
            }
        }

        return retour;
    }

    private boolean siCouleurGagneCetteRangee(GCouleur couleur, int idRangee, int pourGagner){
        Boolean retour = false;
        int grandeur = colonnes.size();
        int compteur = 0;

        for(int i=0; i<grandeur; i++){

            MColonne col = colonnes.get(i);
            GCouleur couleurCase = col.getJetons().get(idRangee);
            if(couleurCase.equals(couleur)){
                compteur++;
            } else {
                compteur = 0;
            }
            if (compteur == pourGagner){
                retour = true;
                break;
            }
        }
        return retour;
    }

    private boolean siCouleurGagneDiagonal(GCouleur couleur, int pourGagner){
        Boolean retour = false;
        int grandeur = colonnes.size();
        int compteur = 0;


        return retour;
    }

    //private boolean siCouleurGagneCetteCase(GCouleur couleur, int idColonne, int idRangee, int pourGagner){ return false; }
    //private boolean siCouleurGagneDansCetteDirection(GCouleur couleur, int idColonne, int idRangee, GDirection direction, int pourGagner){ return false;}


    private boolean siMemeCouleurCetteCase(GCouleur couleur, int idColonne, int idRangee){

        Boolean retour = false;
        MColonne col = colonnes.get(idColonne);
        GCouleur couleurTest = col.getJetons().get(idRangee);
        if (couleurTest.equals(couleur)) {
            retour = true;
        }
        return retour;}



}
