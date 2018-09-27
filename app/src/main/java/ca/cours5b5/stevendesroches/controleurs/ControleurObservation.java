package ca.cours5b5.stevendesroches.controleurs;

import java.util.Map;

import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.stevendesroches.modeles.MPartie;
import ca.cours5b5.stevendesroches.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    private static MPartie partie;

    static{

    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

    }
}
