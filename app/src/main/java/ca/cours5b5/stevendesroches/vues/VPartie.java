package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.stevendesroches.controleurs.ControleurObservation;
import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.stevendesroches.modeles.MParametres;
import ca.cours5b5.stevendesroches.modeles.MParametresPartie;
import ca.cours5b5.stevendesroches.modeles.MPartie;
import ca.cours5b5.stevendesroches.modeles.Modele;

public class VPartie extends Vue {

    private VGrille grille;

    public VPartie(Context context) {
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs){
        super(context);
    }

    public  VPartie(Context context, AttributeSet attrs, int defStyleAttr){
        super(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private void initialiser(){}

    private void observerPartie(){
        ControleurObservation.observerModele(MParametres.class.getSimpleName(),
                new ListenerObservateur() {
                    @Override
                    public void reagirChangementAuModele(Modele modele) {
                        initialiserGrille(getPartie(modele));
                    }
                });
    }

    private MPartie getPartie(Modele modele) {
        MPartie partie = (MPartie) modele;
        return partie;
    }

    private void initialiserGrille(MPartie partie){
        grille = new VGrille(this.getContext());
        grille.creerGrile(partie.parametres.hauteur, partie.parametres.largeur);

    }

}
