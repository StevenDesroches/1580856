package ca.cours5b5.stevendesroches.proxy;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class Proxy {
    private String cheminServeur;

    protected DatabaseReference noeudServeur;

    public Proxy(String cheminServeur){

    }

    public void connecterAuServeur(){
        noeudServeur = FirebaseDatabase.getInstance().getReference(cheminServeur);

    }

    public void deconnecterDuServeur(){
        noeudServeur = null;
    }

    public abstract void detruireValeurs();
}
