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

        this.setBackgroundColor(Color.RED);
        Spec rowSpan = GridLayout.spec(5, 1);
        Spec colspan = GridLayout.spec(5, 1);
        LayoutParams qwerty = new GridLayout.LayoutParams(rowSpan,colspan);

        qwerty.width = 0;
        qwerty.height = 0;
        qwerty.setGravity(Gravity.FILL);

        this.setLayoutParams(qwerty);

        this.setBackgroundColor(Color.RED);

        Log.d("Atelier06","::Hey Creer Grille");

        VCase cased = new VCase(this.getContext());
        this.addView(cased, qwerty);
        //this.addView(newButton, qwerty);
        Log.d("Atelier06","::Hey Creer Grille");
        //this.addView(newButton);
        //this.setRowCount(5);
        //this.setColumnCount(9);
        //ajouterEnTetes(largeur);

       // LayoutParams params = getMiseEnPageEntete(7);
        //this.addView(newButton,params);



        //this.addView(this, getMiseEnPageEntete(largeur));
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
