package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
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
        initialiserGrille();
    }

    private void initialiser(){}

    private void observerPartie(){
        Log.d("Atelier06",metaDonnees.getSimpleName() + "::Observation observerPartie");
        ControleurObservation.observerModele(MParametres.class.getSimpleName(),
                new ListenerObservateur() {
                    @Override
                    public void reagirChangementAuModele(Modele modele) {
                        initialiserGrille();
                    }
                });
    }

    private MPartie getPartie(Modele modele) {
        MPartie partie = (MPartie) modele;
        return partie;
    }

    private void initialiserGrille(){
        Log.d("Atelier06",metaDonnees.getSimpleName() + "::LAGRILLE");
        //GridLayout grillee = findViewById(R.id.Grille);
        findViewById(R.id.Grille).setBackgroundColor(Color.RED);
        //grille = (VGrille) grillee;
        //grille = findViewById(R.id.Grille);
        grille.setBackgroundColor(Color.RED);
        //findViewById(R.id.Grille).set

        //grille.creerGrile(partie.parametres.hauteur, partie.parametres.largeur);
        //grille.creerGrille(6, 8);

    }

}
