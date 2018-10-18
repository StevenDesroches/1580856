package ca.cours5b5.stevendesroches.controleurs;

import java.util.Map;

import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.stevendesroches.modeles.MParametres;
import ca.cours5b5.stevendesroches.modeles.MPartie;
import ca.cours5b5.stevendesroches.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    private static MPartie partie;

    static{

    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

        if (nomModele.equals(MParametres.class.getSimpleName())){

            //observations.put(MParametres.instance, listenerObservateur);
            listenerObservateur.reagirNouveauModele(MParametres.instance);

        } else if (nomModele.equals(MPartie.class.getSimpleName())){
            partie = new MPartie(MParametres.instance.getParametresPartie());

            //observations.put(ControleurObservation.partie, listenerObservateur);
            listenerObservateur.reagirNouveauModele(partie);

        }


    }
}
