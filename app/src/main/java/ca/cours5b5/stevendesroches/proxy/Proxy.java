package ca.cours5b5.stevendesroches.proxy;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public abstract class Proxy {
    private String cheminServeur;

    protected DatabaseReference noeudServeur;

    public Proxy(String cheminServeur){
        this.cheminServeur = cheminServeur;
    }

    public void connecterAuServeur(){
        Log.d("atelier13", this.getClass().getSimpleName() + "::" + cheminServeur);
        noeudServeur = FirebaseDatabase.getInstance().getReference(cheminServeur);

    }

    public void deconnecterDuServeur(){
        noeudServeur = null;
    }

    public abstract void detruireValeurs();
}
