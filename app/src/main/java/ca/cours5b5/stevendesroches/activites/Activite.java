package ca.cours5b5.stevendesroches.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public abstract class Activite extends AppCompatActivity {

    protected Class metaDonnees = this.getClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Atelier04",metaDonnees.getSimpleName() + "::onCreate");

        //code au début, la vue n'existe pas

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Atelier04",metaDonnees.getSimpleName() + "::onResume");
        //code juste avant l'affichage

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
        //code pour sauvegarder

        outState.putInt("Key", 0);

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
