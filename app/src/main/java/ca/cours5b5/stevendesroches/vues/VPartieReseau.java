package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.stevendesroches.modeles.MPartieReseau;

public class VPartieReseau extends VPartie{

    public VPartieReseau(Context context){
        super(context);
    }

    public VPartieReseau(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartieReseau(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected String getNomModele(){
        Log.d("TEST13", this.getClass().getSimpleName() + "::getNomModele()" +MPartieReseau.class.getSimpleName());
        return MPartieReseau.class.getSimpleName();}
}
