package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import ca.cours5b5.stevendesroches.global.GConstantes;

import ca.cours5b5.stevendesroches.R;

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

        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<Integer> adapterGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);

        spinnerHauteur.setAdapter(adapterHauteur);
        spinnerLargeur.setAdapter(adapterLargeur);
        spinnerGagner.setAdapter(adapterGagner);

        generation(GConstantes.HAUTEUR_MAX, GConstantes.HAUTEUR_MIN, GConstantes.HAUTEUR_DEFAULT, adapterHauteur, spinnerHauteur);
        generation(GConstantes.LARGEUR_MAX, GConstantes.LARGEUR_MIN, GConstantes.LARGEUR_DEFAULT, adapterLargeur, spinnerLargeur);
        generation(GConstantes.GAGNER_MAX, GConstantes.GAGNER_MIN, GConstantes.GAGNER_DEFAULT, adapterGagner, spinnerGagner);

    }

    static {
        Log.d("Atelier04",VMenuPrincipal.class.getSimpleName()  + "::static");
    }

    private void generation(Integer max, Integer min, Integer defaut, ArrayAdapter<Integer> adapter, Spinner spinner) {
        int compt = 0;
        boolean set = true;

        for (int i = min; i <= max; i++) {
            adapter.add(i);

            if (i == defaut && set) {
                spinner.setSelection(compt);
                set = false;
            } else if (i == max && set) {
                spinner.setSelection(i);
            }

            compt++;
        }
    }
}
