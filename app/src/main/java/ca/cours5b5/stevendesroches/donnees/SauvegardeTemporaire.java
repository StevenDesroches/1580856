package ca.cours5b5.stevendesroches.donnees;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;


import ca.cours5b5.stevendesroches.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {

        if(bundle != null && bundle.containsKey(getCle(cheminSauvegarde))){

            String json = bundle.getString(getCle(cheminSauvegarde));

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            return objetJson;

        }else{

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

        //TODO verifier que la clé est sous forme nomModele
        
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

    private String getCle(String cheminSauvegarde){ return getNomModele(cheminSauvegarde); }

}