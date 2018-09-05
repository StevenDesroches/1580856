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

        Button bouton = this.findViewById(R.id.buttonParam);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accessParam();
            }
        });
    }

    static {
        Log.d("Atelier04",AMenuPrincipal.class.getSimpleName() + "::static");
    }

    public void accessParam () {
        Intent monIntention = new Intent(this, AParametres.class);
        this.startActivity(monIntention);
    }
}
