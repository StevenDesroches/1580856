package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.Gravity;

public class VEntete extends AppCompatButton {

    public VEntete(Context context) {
        super(context);
    }

    public VEntete(Context context, AttributeSet attrs){
        super(context);
    }

    public  VEntete(Context context, AttributeSet attrs, int defStyleAttr){
        super(context);
    }

    private int colonne;

    public VEntete(Context context, int colonne){
        super(context);
        this.colonne = colonne;

        this.setText(colonne +"\n\u2193\n\u2193");
    }

}
