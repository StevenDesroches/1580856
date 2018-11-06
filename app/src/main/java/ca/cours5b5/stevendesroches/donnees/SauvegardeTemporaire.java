package ca.cours5b5.stevendesroches.donnees;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;


import ca.cours5b5.stevendesroches.global.GConstantes;
import ca.cours5b5.stevendesroches.modeles.MParametres;
import ca.cours5b5.stevendesroches.modeles.MPartie;
import ca.cours5b5.stevendesroches.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {

        if (checkNomModele(getCle(cheminSauvegarde))){ //verifier que la clé est sous forme nomModele
            if(bundle != null && bundle.containsKey(getCle(cheminSauvegarde))){

                String json = bundle.getString(getCle(cheminSauvegarde));

                Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

                return objetJson;

            } else {

                return null;

            }
        } else {

            return null;

        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        if(bundle != null){

            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(getCle(cheminSauvegarde), json);

        }
    }

    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement) {

        if (checkNomModele(getCle(cheminSauvegarde))) { //verifier que la clé est sous forme nomModele
            if(bundle != null && bundle.containsKey(getCle(cheminSauvegarde))){
                Log.d("atelier12", "chargement de la sauvegardeTemporaire");
                String json = bundle.getString(getCle(cheminSauvegarde));

                Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

                listenerChargement.reagirSucces(objetJson);

            }else{
                Log.d("atelier12", "non-chargement de la sauvegardeTemporaire");
                listenerChargement.reagirErreur(null);

            }
        }

    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde) {
        if(bundle != null && bundle.containsKey(getCle(cheminSauvegarde))){
            bundle.clear();
            Log.d("atelier60", "Destruction de la sauvegarde temporaire");
        }else{
            Log.d("atelier60", "non-Destruction de la sauvegarde temporaire");
        }
    }

    private String getCle(String cheminSauvegarde){ return getNomModele(cheminSauvegarde); }

    private Boolean checkNomModele(String cheminSauvegarde){
        boolean retour = true;

        Log.d("atelier12", this.getClass().getSimpleName() + "::checkNomModele = "+ cheminSauvegarde);
        if(cheminSauvegarde.contains("/")){
            retour = false;
        } else if (cheminSauvegarde.contains(".")) {
            retour = false;
        }

        Log.d("atelier12", this.getClass().getSimpleName() + "::checkNomModele = "+ retour);
        return retour;
    }

}