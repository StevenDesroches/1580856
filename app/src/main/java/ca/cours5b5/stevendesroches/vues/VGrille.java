package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.stevendesroches.R;

public class VGrille extends GridLayout {

    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs){
        super(context);
    }

    public  VGrille(Context context, AttributeSet attrs, int defStyleAttr){
        super(context);
    }

    private int nombreRangees;

    private class Colonne extends ArrayList<VCase> {}

    private List<Colonne> colonnesDeCases;

    private List<VEntete> entetes;

    private VCase[][] lesCases;

    @Override
    protected void onFinishInflate(){
        Log.d("Atelier06","::avant finishinflate");
        super.onFinishInflate();
        Log.d("Atelier06","::apres finishinflate");
    }

    private void initialiser(){
        creerGrille(5,5);
    }

    void creerGrille(int hauteur, int largeur){

        Log.d("Atelier06","::Hey Creer Grille");
        nombreRangees = hauteur - 1;
        lesCases = new VCase[nombreRangees][largeur];
        initialiserTableauDeCases(hauteur, largeur);

    }

    private void initialiserTableauDeCases(int hauteur, int largeur){
        initialiserColonnes(largeur);
        ajouterEnTetes(largeur);
        ajouterCases(hauteur, largeur);
    }

    private void initialiserColonnes(int largeur){
        colonnesDeCases = new ArrayList<>();

        for (int i = 0; i < largeur; i++){
            colonnesDeCases.add(new Colonne());
        }

    }

    private void ajouterEnTetes(int largeur){

        for (int i = 0; i < largeur; i++){
            VEntete v = new VEntete(this.getContext(), i);
            this.addView(v, getMiseEnPageEntete(i));
        }
    }


    private void ajouterCases(int hauteur, int largeur){
        for (int i = 1; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                int h = hauteur - 1 - i;

                VCase v = new VCase(this.getContext(), hauteur - 1 - i, j);
                colonnesDeCases.get(j).add(0, v);
                lesCases[i - 1][j] = v;
                this.addView(v, getMiseEnPageCases(i, j));
            }
        }
    }

    private LayoutParams getMiseEnPageCases(int rangee, int colonne){
            float poidsRangee = 1.0f;
            float poidsCol = 1.0f;

            Spec specRangee = GridLayout.spec(rangee, poidsRangee);
            Spec specColonne = GridLayout.spec(colonne, poidsCol);

            LayoutParams params = new LayoutParams(specRangee, specColonne);


            params.width = 0;
            params.height = 0;
            params.setGravity(Gravity.FILL);
            
            params.rightMargin = 5;
            params.leftMargin = 5;

            return params;
        }

    private LayoutParams getMiseEnPageEntete(int colonne){
            float poidsRangee = 2.0f;
            float poidsCol = 1.0f;

            Spec specRangee = GridLayout.spec(0, poidsRangee);
            Spec specColonne = GridLayout.spec(colonne, poidsCol);

            LayoutParams params = new LayoutParams(specRangee, specColonne);

            params.width = 0;
            params.height = 0;
            params.setGravity(Gravity.FILL);

            params.rightMargin = 5;
            params.leftMargin = 5;

            return params;
        }

}
