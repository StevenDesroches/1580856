package ca.cours5b5.stevendesroches.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract Map<String, Object> chargerModele(final String cheminSauvegarde);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    public abstract void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);

    public abstract void detruireSauvegarde(final String cheminSauvegarde);

    protected static String getNomModele(String cheminSauvegarde){
        String[] cheminSplit = cheminSauvegarde.split("/");
        String nomModele = cheminSplit[0];

        return nomModele;
    }

}
