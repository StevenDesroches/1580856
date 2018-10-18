package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;

import ca.cours5b5.stevendesroches.R;
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
        //grille = new VGrille(getContext());
        //grille.addView(findViewById(R.id.Grille));
        grille = findViewById(R.id.Grille);
        observerPartie();
    }

    private void initialiser(){}

    private void observerPartie(){
        Log.d("Atelier06",metaDonnees.getSimpleName() + "::Observation observerPartie");
        ControleurObservation.observerModele(MPartie.class.getSimpleName(),
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
        Log.d("Atelier06",metaDonnees.getSimpleName() + "::LAGRILLE");
        grille.creerGrille(partie.getParametres().getHauteur(), partie.getParametres().getLargeur());

    }

}
