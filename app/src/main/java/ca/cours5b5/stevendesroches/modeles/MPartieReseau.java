package ca.cours5b5.stevendesroches.modeles;

import java.util.Map;

import ca.cours5b5.stevendesroches.controleurs.ControleurAction;
import ca.cours5b5.stevendesroches.controleurs.interfaces.Fournisseur;
import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.stevendesroches.exceptions.ErreurAction;
import ca.cours5b5.stevendesroches.exceptions.ErreurSerialisation;
import ca.cours5b5.stevendesroches.global.GCommande;
import ca.cours5b5.stevendesroches.serialisation.AttributSerialisable;

public class MPartieReseau extends MPartie implements Fournisseur, Identifiable{

    @AttributSerialisable
    public String idJoueurInvite;
    private String _idJoueurInvite;

    @AttributSerialisable
    public String idJoueurHote;
    private String getIdJoueurHote;

    public MPartieReseau(MParametresPartie parametres) {
        super(parametres);
    }

    @Override
    public String getId() {
        return idJoueurHote;
    }

    private void fournirActionRecevoirCoup() {

    }

    //@Override
    private void fournirActionPlacerJeton(){

        //TODO AVEC LE CONTROLEUR PARtiE reSEAU
        ControleurAction.fournirAction(this,
                GCommande.JOUER_COUP_ICI,
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

    private void recevoirCoupReseau(int colonne){

    }

    @Override
    public  void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {
        return null;
    }

}
