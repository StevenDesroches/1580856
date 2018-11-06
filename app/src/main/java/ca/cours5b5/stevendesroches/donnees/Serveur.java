package ca.cours5b5.stevendesroches.donnees;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import ca.cours5b5.stevendesroches.modeles.MParametres;
import ca.cours5b5.stevendesroches.modeles.MPartie;

public final class Serveur extends SourceDeDonnees {

    private Serveur() {

    }

    private static final Serveur instance = new Serveur();

    public static Serveur getInstance(){
        return instance;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {

        if (checkNomModele(cheminSauvegarde)){ //vérifier le cheminSauvegarde, il doit etre de forme nomModele/IdUsager
            Log.d("atelier11", "Sauvegarde Serveur");

            DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
            noeud.setValue(objetJson);
        }
    }

    @Override
    public void chargerModele(String cheminSauvegarde, final ListenerChargement listenerChargement) {

        if (checkNomModele(cheminSauvegarde)){ //vérifier le cheminSauvegarde, il doit etre de forme nomModele/IdUsager
            DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

            noeud.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Map<String, Object> objetJson = (Map<String, Object>) dataSnapshot.getValue();
                        Log.d("atelier12", Serveur.class.getSimpleName() + "::chargement de la sauvegarde serveur");
                        listenerChargement.reagirSucces(objetJson);
                        //donnees
                    } else {
                        //pas de donnees
                        Log.d("atelier12", Serveur.class.getSimpleName() + "::non-chargement de la sauvegarde serveur");
                        listenerChargement.reagirErreur(null);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //erreur de lecture
                    Log.d("atelier12", Serveur.class.getSimpleName() + "::non-chargement de la sauvegarde serveur");
                    listenerChargement.reagirErreur(null);
                }
            });
        }
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
        Log.d("atelier60", "Destruction de la sauvegarde serveur");
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.removeValue();

    }

    private Boolean checkNomModele(String cheminSauvegarde){
        boolean retour = true;

        Log.d("atelier12", this.getClass().getSimpleName() + "::checkNomModele = "+ cheminSauvegarde);
        if(!cheminSauvegarde.contains("/")){
            retour = false;
        } else {

            String[] cheminSplit = cheminSauvegarde.split("/");
            String nomModele = cheminSplit[0];
            String extension = cheminSplit[1];

            if (nomModele.equals(MPartie.class.getSimpleName()) || nomModele.equals(MParametres.class.getSimpleName())){
            } else {
                retour = false;
            }

        }
        Log.d("atelier12", this.getClass().getSimpleName() + "::checkNomModele = "+ retour);
        return retour;
    }
}
