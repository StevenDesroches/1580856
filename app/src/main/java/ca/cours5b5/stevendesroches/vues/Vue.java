package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.stevendesroches.controleurs.ControleurObservation;
import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.stevendesroches.modeles.MParametres;
import ca.cours5b5.stevendesroches.modeles.Modele;

public abstract class Vue extends ConstraintLayout {

    protected Class metaDonnees = this.getClass();

    public Vue(Context context) {
        super(context);
    }

    public Vue(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Vue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("Atelier04",metaDonnees.getSimpleName() + "::onFinishInflate");

    }

    static {
        Log.d("Atelier04",Vue.class.getSimpleName()  + "::static");
    }

}
