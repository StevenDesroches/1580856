package ca.cours5b5.stevendesroches.controleurs;

import ca.cours5b5.stevendesroches.global.GCommande;
import ca.cours5b5.stevendesroches.global.GCouleur;

public class ControleurPartie {

    private ControleurPartie(){}

    private Action actionGagnerPartie;

    private static final ControleurPartie instance = new ControleurPartie();
    public static ControleurPartie getInstance(){return instance;}

    public void gagnerPartie(GCouleur couleurGagnante){
        actionGagnerPartie = ControleurAction.demanderAction(GCommande.MESSAGE_GAGNANT);
        actionGagnerPartie.executerDesQuePossible();
    }
}
