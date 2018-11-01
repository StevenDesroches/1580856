package ca.cours5b5.stevendesroches.controleurs;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.stevendesroches.modeles.Modele;

public final class ControleurObservation {

    private ControleurObservation(){}

    private static Map<Modele, ListenerObservateur> observations;

    static {

        observations = new HashMap<>();

    }

    /*public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur) {

        Modele modele = ControleurModeles.getModele(nomModele);

        observations.put(modele, listenerObservateur);

        listenerObservateur.reagirNouveauModele(modele);

    }*/

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur) {
        Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::observerModele");
        ControleurModeles.getModele(nomModele, new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {
                Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::ReagirAuModele");
                observations.put(modele, listenerObservateur);
                listenerObservateur.reagirNouveauModele(modele);
            }
        });

    }

    public static void lancerObservation(Modele modele) {

        final ListenerObservateur listenerObservateur = observations.get(modele);

        if (listenerObservateur != null) {

            listenerObservateur.reagirChangementAuModele(modele);

        }
    }

    public static void detruireObservation(Modele modele) {

        observations.remove(modele);

    }

}
