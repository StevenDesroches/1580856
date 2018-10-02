package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
    }

    private void initialiser(){}

    void creerGrile(int hauteur, int largeur){

        ajouterEnTetes(largeur);

        this.addView(this, getMiseEnPageEntete(largeur));
        //this.addView(this, getMiseEnPageCase(hauteur, largeur));

    }

    private void initialiserColonnes(int largeur){}

    private void ajouterEnTetes(int largeur){
        for (int i = 0; i< largeur; i++){
            entetes.add(new VEntete(this.getContext(), i));
        }
    }

    private LayoutParams getMiseEnPageEntete(int colonne){
        LayoutParams Params = new LayoutParams();
        Params.width = 0;
        Params.height = 0;
        Params.setGravity(Gravity.FILL);

        for (VEntete entete : entetes){
            entete.setLayoutParams(Params);
        }
        return Params;
    }

    private void ajouterCases(int hauteur, int largeur){}

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){ return null; }

}
