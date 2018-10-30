package ca.cours5b5.stevendesroches.activites;

import android.os.Bundle;

import ca.cours5b5.stevendesroches.R;
import ca.cours5b5.stevendesroches.controleurs.ControleurAction;
import ca.cours5b5.stevendesroches.controleurs.ControleurModeles;
import ca.cours5b5.stevendesroches.controleurs.interfaces.Fournisseur;
import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.stevendesroches.global.GCommande;
import ca.cours5b5.stevendesroches.modeles.MParametres;
import ca.cours5b5.stevendesroches.modeles.MPartie;

public class AParametres extends Activite implements Fournisseur{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        fournirActions();

    }

    private void fournirActions() {

        fournirActionEffacerPartie();
    }

    private void fournirActionEffacerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.EFFACER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionEffacerPartie();

                    }
                });
    }

    private void transitionEffacerPartie(){

        //ControleurModeles.detruireModele(MParametres.class.getSimpleName());

        //supprimer les parametres
        //ControleurModeles.detruireSauvegarde(MParametres.class.getSimpleName());
        //supprimer la partie courante
        ControleurModeles.detruireSauvegarde(MPartie.class.getSimpleName());

    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }

}
