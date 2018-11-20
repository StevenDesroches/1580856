package ca.cours5b5.stevendesroches.activites;

import android.os.Bundle;

import ca.cours5b5.stevendesroches.R;
import ca.cours5b5.stevendesroches.controleurs.ControleurPartieReseau;
import ca.cours5b5.stevendesroches.controleurs.interfaces.Fournisseur;

public class APartieReseau extends Activite implements Fournisseur {

    private ControleurPartieReseau partieReseau = ControleurPartieReseau.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_reseau);
        getIntent().getExtras().getString("FIXME");

    }

    @Override
    protected void onPause() {
        super.onPause();
        partieReseau.detruireSauvegardeServeur();
        partieReseau.donnecterDuServeur();

    }

    @Override
    protected void onResume() {
        super.onResume();
        partieReseau.connecterAuServeur();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

//GestionnaireAthletesQwerty@gmail.com
//qazQWERTY987