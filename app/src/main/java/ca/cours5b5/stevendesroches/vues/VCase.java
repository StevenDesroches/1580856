package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;


import ca.cours5b5.stevendesroches.R;
import ca.cours5b5.stevendesroches.controleurs.Action;
import ca.cours5b5.stevendesroches.controleurs.ControleurAction;
import ca.cours5b5.stevendesroches.global.GCommande;
import ca.cours5b5.stevendesroches.global.GCouleur;
import ca.cours5b5.stevendesroches.modeles.MJeton;


public class VCase extends AppCompatButton {

    private boolean contientCouleur = false;
    private boolean alreadyBouge = true;

    public VCase(Context context) {
        super(context);
        initialiser();
    }

    public VCase(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialiser();
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialiser();
    }


    public VCase(Context context, int rangee, int colonne) {
        super(context);

        // Atelier08: afficher les indices
        setText(""+rangee+","+colonne);

        initialiser();
    }

    private void initialiser() {
        
        setEnabled(false);

        setBackgroundColor(getResources().getColor(R.color.VIDE, null));

    }

    public void afficherJeton(MJeton jeton) {
        afficherCouleurJeton(jeton);
    }

    private void afficherCouleurJeton(MJeton jeton) {
        this.contientCouleur = true;

        switch (jeton.getCouleur()){

            case ROUGE:

                setBackgroundColor(getResources().getColor(R.color.ROUGE, null));

                break;

            case JAUNE:

                setBackgroundColor(getResources().getColor(R.color.JAUNE, null));

                break;

        }
    }

    public void animationVictoire() {
        TranslateAnimation anim = new TranslateAnimation(-500,0,0,0);
        anim.setRepeatCount(10);
        anim.setDuration(300);
        anim.setFillAfter(true);

        anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });

        startAnimation(anim);

    }

    void bouger(){
        if (alreadyBouge){
            TranslateAnimation anim = new TranslateAnimation(0,0,-500,0);
            anim.setDuration(300);
            anim.setFillAfter(true);

            anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                }
            });

            startAnimation(anim);
            alreadyBouge = false;
        }
    }

    public boolean contientCouleur(){ return this.contientCouleur; }

}
