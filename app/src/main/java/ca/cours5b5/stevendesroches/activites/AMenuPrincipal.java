package ca.cours5b5.stevendesroches.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.stevendesroches.R;

public class AMenuPrincipal extends Activite{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);

        Button boutonParam = this.findViewById(R.id.buttonParam);
        boutonParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accessParam();
            }
        });

        Button boutonJouer = this.findViewById(R.id.buttonJouer);
        boutonJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accessJouer();
            }
        });
    }

    static {
        Log.d("Atelier04",AMenuPrincipal.class.getSimpleName() + "::static");
    }

    private void accessParam () {
        Intent monIntention = new Intent(this, AParametres.class);
        this.startActivity(monIntention);
    }

    private void accessJouer () {
        Intent monIntention = new Intent(this, APartie.class);
        this.startActivity(monIntention);
    }
}
