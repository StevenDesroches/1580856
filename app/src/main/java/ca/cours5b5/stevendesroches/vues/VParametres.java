package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import ca.cours5b5.stevendesroches.global.GConstantes;

import ca.cours5b5.stevendesroches.R;
import ca.cours5b5.stevendesroches.modeles.MParametres;

public class VParametres extends Vue {

    public VParametres(Context context){
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Spinner spinnerHauteur = this.findViewById(R.id.spinnerHauteur);
        Spinner spinnerLargeur = this.findViewById(R.id.spinnerLargeur);
        Spinner spinnerGagner = this.findViewById(R.id.spinnerGagner);

        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, MParametres.instance.getChoixHauteur());
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, MParametres.instance.getChoixLargeur());
        ArrayAdapter<Integer> adapterGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, MParametres.instance.getChoixPourGagner());

        spinnerHauteur.setAdapter(adapterHauteur);
        spinnerLargeur.setAdapter(adapterLargeur);
        spinnerGagner.setAdapter(adapterGagner);

        spinnerHauteur.setSelection(adapterHauteur.getPosition(MParametres.instance.hauteur));
        spinnerLargeur.setSelection(adapterLargeur.getPosition(MParametres.instance.largeur));
        spinnerGagner.setSelection(adapterGagner.getPosition(MParametres.instance.pourGagner));


        setListener(spinnerHauteur, spinnerLargeur, spinnerGagner);

    }

    private void setListener(Spinner spinnerHauteur, Spinner spinnerLargeur, Spinner spinnerGagner) {
        spinnerHauteur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                MParametres.instance.hauteur = (int) adapterView.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerLargeur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                MParametres.instance.largeur = (int) adapterView.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerGagner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                MParametres.instance.pourGagner = (int) adapterView.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    static {
        Log.d("Atelier04",VMenuPrincipal.class.getSimpleName()  + "::static");
    }

}
