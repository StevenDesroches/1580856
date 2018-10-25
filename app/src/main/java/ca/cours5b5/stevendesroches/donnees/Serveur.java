package ca.cours5b5.stevendesroches.donnees;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public final class Serveur extends SourceDeDonnees {

    private Serveur() {

    }

    private static final Serveur instance = new Serveur();

    private static Serveur getInstance(){
        return null;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {

        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.setValue(objetJson);

    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {
        /*
        BONUS
         */
        return null;
    }

    //@Override
    public void detruireSauvegarde(String cheminSauvegarde){
        /*
        BONUS
         */
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.removeValue();

    }
}
