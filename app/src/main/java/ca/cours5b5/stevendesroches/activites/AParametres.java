package ca.cours5b5.stevendesroches.activites;

import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;

import java.util.Map;

import ca.cours5b5.stevendesroches.R;
import ca.cours5b5.stevendesroches.serialisation.Jsonification;

public class AParametres extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        Log.d("MonEtiquette","Bonjour!");
        Log.d("Greeting",this.getResources().getString(R.string.Greet));
        Log.d("Landscape",this.getResources().getString(R.string.Landscape));

        restaurerParametres(savedInstanceState);

    }

    private void restaurerParametres(Bundle savedInstanceState){
        if (savedInstanceState != null) {
            String json = savedInstanceState.getString(monModele.getClass().getSimpleName());
            Map<String, Object> objectJson = Jsonification.enObjetJson(json);
            monModele.aPartirObjetJson(objectJson);
            Log.d("Atelier05", metaDonnees.getSimpleName() + "::restaurerParametres, clé: " + monModele.getClass().getSimpleName());
            Log.d("Atelier05", metaDonnees.getSimpleName() + "::restaurerParametres, json: " + json);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        sauvegarderParametres(outState);

    }

    private void sauvegarderParametres(Bundle outState){
        if (outState != null) {
            Map<String, Object> objectJson = monModele.enObjetJson();
            String json = Jsonification.enChaine(objectJson);
            outState.putString(monModele.getClass().getSimpleName(), json);
            Log.d("Atelier05", metaDonnees.getSimpleName() + "::sauvegarderParametres, clé: " + monModele.getClass().getSimpleName());
            Log.d("Atelier05", metaDonnees.getSimpleName() + "::sauvegarderParametres, json: " + json);
        }

    }

    static {
        Log.d("Atelier04",AParametres.class.getSimpleName() + "::static");
    }

}
