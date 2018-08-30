package ca.cours5b5.stevendesroches.activites;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;

import ca.cours5b5.stevendesroches.R;
import ca.cours5b5.stevendesroches.vues.VParametres;

public class AParametres extends AppCompatActivity {

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

}
