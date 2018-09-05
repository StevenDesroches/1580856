package ca.cours5b5.stevendesroches.activites;

import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;

import ca.cours5b5.stevendesroches.R;

public class AParametres extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        Log.d("MonEtiquette","Bonjour!");
        Log.d("Greeting",this.getResources().getString(R.string.Greet));
        Log.d("Landscape",this.getResources().getString(R.string.Landscape));

        Spinner spinnerHauteur = this.findViewById(R.id.spinnerHauteur);
        Spinner spinnerLargeur = this.findViewById(R.id.spinnerLargeur);
        Spinner spinnerGagner = this.findViewById(R.id.spinnerGagner);
    }

    static {
        Log.d("Atelier04",AParametres.class.getSimpleName() + "::static");
    }

}
