package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.stevendesroches.controleurs.ControleurObservation;
import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.stevendesroches.modeles.MParametres;
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

    }

    private MPartie getPartie(Modele modele){
        return null;
    }

    private void initialiserGrille(MPartie partie){}

}
