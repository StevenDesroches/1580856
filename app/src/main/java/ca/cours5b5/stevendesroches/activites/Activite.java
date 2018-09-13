package ca.cours5b5.stevendesroches.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.stevendesroches.modeles.MParametres;
import ca.cours5b5.stevendesroches.modeles.Modele;
import ca.cours5b5.stevendesroches.serialisation.Jsonification;

public abstract class Activite extends AppCompatActivity {

    protected Class metaDonnees = this.getClass();
    protected Modele monModele = MParametres.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Atelier04",metaDonnees.getSimpleName() + "::onCreate");

        if (savedInstanceState != null) {
            String json = savedInstanceState.getString(metaDonnees.getSimpleName());
            Map<String, Object> objectJson = Jsonification.enObjetJson(json);
            monModele.aPartirObjetJson(objectJson);
        }

        //code au début, la vue n'existe pas

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Atelier04",metaDonnees.getSimpleName() + "::onResume");
        //code juste avant l'affichagegfgh

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Atelier04",metaDonnees.getSimpleName() + "::onPause");
        //code en pause

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Atelier04",metaDonnees.getSimpleName() + "::onSaveInstanceState");

        if (outState != null) {
            Map<String, Object> objectJson = monModele.enObjetJson();
            String json = Jsonification.enChaine(objectJson);
            outState.putString(metaDonnees.getSimpleName(), json);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Atelier04",metaDonnees.getSimpleName() + "::onDestroy");

        //code avant la destruction

    }

    static {
        Log.d("Atelier04",Activite.class.getSimpleName() + "::static");
    }
}
