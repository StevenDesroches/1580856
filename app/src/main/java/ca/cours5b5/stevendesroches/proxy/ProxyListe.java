package ca.cours5b5.stevendesroches.proxy;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.List;

import ca.cours5b5.stevendesroches.controleurs.Action;
import ca.cours5b5.stevendesroches.controleurs.interfaces.Fournisseur;
import ca.cours5b5.stevendesroches.global.GCommande;

public class ProxyListe extends Proxy implements Fournisseur {

    private ChildEventListener childEventListener;

    private Query requete;

    private Action actionNouvelItem;

    private List<DatabaseReference> noeudsAjoutes;

    public ProxyListe(String cheminServeur){
        super(cheminServeur);
    }

    public void setActionNouvelItem(GCommande commande){

    }

    public void ajouterValeur(Object valeur) {
        //noeudServeur.push(noeudsAjoutes);

    }

    @Override
    public void connecterAuServeur() {
        super.connecterAuServeur();

        creerListener();

        requete = noeudServeur;

        requete.addChildEventListener(childEventListener);



    }

    private void creerListener(){
        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
    }

    protected Query getRequete(){
        //on veut trier une cle et limiter a un nombre max (utiise une constante)
        return null;
    }

    @Override
    public void deconnecterDuServeur() {
        requete.removeEventListener(childEventListener);
        //noeudServeur.child(noeudsAjoutes.).removeValue();
        super.deconnecterDuServeur();
    }

    @Override
    public void detruireValeurs() {

    }


}
