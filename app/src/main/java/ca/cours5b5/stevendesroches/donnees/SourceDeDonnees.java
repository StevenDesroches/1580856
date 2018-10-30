package ca.cours5b5.stevendesroches.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract Map<String, Object> chargerModele(final String cheminSauvegarde);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    protected static String getNomModele(String cheminSauvegarde){
        String[] cheminSplit = cheminSauvegarde.split("/");
        String nomModele = cheminSplit[0];

        return nomModele;
    }

}
