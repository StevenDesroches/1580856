package ca.cours5b5.stevendesroches.modeles;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.stevendesroches.controleurs.ControleurAction;
import ca.cours5b5.stevendesroches.controleurs.ControleurPartieReseau;
import ca.cours5b5.stevendesroches.controleurs.interfaces.Fournisseur;
import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.stevendesroches.exceptions.ErreurAction;
import ca.cours5b5.stevendesroches.exceptions.ErreurSerialisation;
import ca.cours5b5.stevendesroches.global.GCommande;
import ca.cours5b5.stevendesroches.global.GConstantes;
import ca.cours5b5.stevendesroches.serialisation.AttributSerialisable;

public class MPartieReseau extends MPartie implements Fournisseur, Identifiable{

    private ControleurPartieReseau partieReseau = ControleurPartieReseau.getInstance();

    @AttributSerialisable
    public String idJoueurInvite = GConstantes.CLE_ID_JOUEUR_INVITE;
    private String __idJoueurInvite = GConstantes.CLE_ID_JOUEUR_INVITE;

    @AttributSerialisable
    public String idJoueurHote = GConstantes.CLE_ID_JOUEUR_HOTE;
    private String __idJoueurHote = GConstantes.CLE_ID_JOUEUR_HOTE;

    public MPartieReseau(MParametresPartie parametres) {
        super(parametres);
        fournirActionRecevoirCoup();

    }

    @Override
    public String getId() {
        return idJoueurHote;
    }

    private void fournirActionRecevoirCoup() {
        ControleurAction.fournirAction(this,
                GCommande.RECEVOIR_COUP_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        try{

                            int colonne = (Integer) args[0];

                            jouerCoup(colonne);

                        }catch(ClassCastException e){

                            throw new ErreurAction(e);

                        }
                    }
                });




    }

    @Override
    protected void fournirActionPlacerJeton(){
        Log.d("atelier13",this.getClass().getSimpleName() + "::fournirActionPlacerJeton");
        ControleurAction.fournirAction(this,
                GCommande.JOUER_COUP_ICI,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        try{

                            int colonne = (Integer) args[0];

                            jouerCoup(colonne);
                            partieReseau.transmettreCoup(colonne);

                        }catch(ClassCastException e){

                            throw new ErreurAction(e);

                        }
                    }
                });
    }

    @Override
    public  void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {
        super.aPartirObjetJson(objetJson);
        idJoueurHote = objetJson.get(__idJoueurHote).toString();
        idJoueurInvite = objetJson.get(__idJoueurInvite).toString();
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {
        Map<String, Object> objetJson = super.enObjetJson();
        objetJson.put(__idJoueurHote, idJoueurHote);
        objetJson.put(__idJoueurInvite, idJoueurInvite);

        return objetJson;
    }

}
