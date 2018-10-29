package ca.cours5b5.stevendesroches.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.Auth;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.stevendesroches.R;
import ca.cours5b5.stevendesroches.controleurs.ControleurAction;
import ca.cours5b5.stevendesroches.controleurs.interfaces.Fournisseur;
import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.stevendesroches.global.GCommande;

public class AMenuPrincipal extends Activite implements Fournisseur {

    final int CODE_CONNEXION = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fournirActions();

    }

    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();

        fournirActionConnexion();
    }

    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }

    private void fournirActionConnexion() {

        ControleurAction.fournirAction(this,
                GCommande.CONNEXION,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionConnexion();

                    }
                });
    }


    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

    }

    private void transitionConnexion(){

        List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent intentionConnexion = AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(fournisseursDeConnexion)
                .build();

        this.startActivityForResult(intentionConnexion, CODE_CONNEXION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == CODE_CONNEXION){
            if (resultCode == RESULT_OK) {
                Log.d("atelier11", this.getClass().getSimpleName() + "::Connexion REUSSI");
            } else {
                Log.d("atelier11", this.getClass().getSimpleName() + "::Connexion FAIL");
            }
        }
    }

}
