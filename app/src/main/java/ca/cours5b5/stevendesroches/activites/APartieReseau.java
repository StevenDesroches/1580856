package ca.cours5b5.stevendesroches.activites;

import android.os.Bundle;

import ca.cours5b5.stevendesroches.R;
import ca.cours5b5.stevendesroches.controleurs.interfaces.Fournisseur;

public class APartieReseau extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_reseau);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Détruire la partie sur le serveur avec controleurpartiereseau et deco controleur partiereseau du serv

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
