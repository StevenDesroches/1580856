package ca.cours5b5.stevendesroches.activites;

import android.os.Bundle;

import ca.cours5b5.stevendesroches.R;
import ca.cours5b5.stevendesroches.controleurs.ControleurModeles;
import ca.cours5b5.stevendesroches.controleurs.interfaces.Fournisseur;
import ca.cours5b5.stevendesroches.modeles.MParametres;

public class AParametres extends Activite implements Fournisseur{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }

}
