package ca.cours5b5.stevendesroches.vues;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import java.util.ArrayList;
import java.util.List;


import ca.cours5b5.stevendesroches.controleurs.Action;
import ca.cours5b5.stevendesroches.controleurs.ControleurAction;
import ca.cours5b5.stevendesroches.controleurs.interfaces.Fournisseur;
import ca.cours5b5.stevendesroches.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.stevendesroches.exceptions.ErreurAction;
import ca.cours5b5.stevendesroches.global.GCommande;
import ca.cours5b5.stevendesroches.global.GCouleur;
import ca.cours5b5.stevendesroches.modeles.MColonne;
import ca.cours5b5.stevendesroches.modeles.MGrille;
import ca.cours5b5.stevendesroches.modeles.MJeton;


public class VGrille extends GridLayout implements Fournisseur {

    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int nombreRangees;

    private class Colonne extends ArrayList<VCase> {}

    private List<Colonne> colonnesDeCases;

    private Action actionEntete;

    private List<VEntete> entetes;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initialiser();

        demanderActionEntete();

        fournirActionDesactiverEntetes();

        fournirVerifierEntetes();

        fournirDesactiverEnteteSpecifique();

        fournirActionAnimationVictoire();

    }

    private void fournirActionAnimationVictoire() {
        ControleurAction.fournirAction(this, GCommande.ANIMATION_VICTOIRE, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                try {

                    int idCol = (Integer) args[0];
                    int idRange = (Integer) args[1];

                    int col = (Integer) args[2];
                    int range = (Integer) args[3];

                    if (colonnesDeCases.get(idCol).get(idRange).contientCouleur()){
                        colonnesDeCases.get(idCol).get(idRange).animationVictoire();
                    }

                    if (colonnesDeCases.get(col).get(range).contientCouleur()){
                        colonnesDeCases.get(col).get(range).animationVictoire();
                    }

                } catch (ClassCastException e) {

                    throw new ErreurAction(e);

                }
            }
        });
    }

    private void fournirDesactiverEnteteSpecifique() {
        ControleurAction.fournirAction(this, GCommande.DESACTIVER_ENTETE_SPECIFIQUE, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                try {

                    int colonne = (Integer) args[0];

                    if (entetes.get(colonne).isEnabled()){
                        entetes.get(colonne).setEnabled(false);
                    }

                } catch (ClassCastException e) {

                    throw new ErreurAction(e);

                }
            }
        });
    }

    private void fournirVerifierEntetes() {
        ControleurAction.fournirAction(this,
                GCommande.VERIFIER_ENTETES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        for (Colonne col : colonnesDeCases) {

                            if (col.get((col.size()-1)).contientCouleur()){
                                Log.d("ALLO3", "la couleur : " + (col.size()-1) + " ICI : " + colonnesDeCases.indexOf(col));
                                entetes.get(colonnesDeCases.indexOf(col)).setEnabled(false);
                            }
                        }
                    }
                });
    }

    private void fournirActionDesactiverEntetes() {
        ControleurAction.fournirAction(this,
                GCommande.DESACTIVER_ENTETE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        for (VEntete entete: entetes) {
                            entete.setEnabled(false);
                        }
                    }
                });
    }

    private void demanderActionEntete() {

        actionEntete = ControleurAction.demanderAction(GCommande.PLACER_JETON_ICI);

    }

    private void initialiser() {

        colonnesDeCases = new ArrayList<>();

        entetes = new ArrayList<>();

    }


    void creerGrille(int hauteur, int largeur) {

        // +1 pour la rangee des en-têtes
        this.nombreRangees = hauteur + 1;

        this.setRowCount(nombreRangees);

        this.setColumnCount(largeur);
        initialiserColonnes(largeur);

        ajouterEnTetes(largeur);
        ajouterCases(hauteur, largeur);


    }

    private void initialiserColonnes(int largeur){

        for(int i=0; i<largeur; i++){

            colonnesDeCases.add(new Colonne());

        }
    }

    private void ajouterEnTetes(int largeur){

        for(int colonne=0; colonne<largeur; colonne++){

            VEntete entete = new VEntete(getContext(), colonne);

            LayoutParams miseEnPageEntete = getMiseEnPageEntete(colonne);

            this.addView(entete, miseEnPageEntete);

            entetes.add(entete);

            installerListenerEntete(entete, colonne);

        }
    }


    private LayoutParams getMiseEnPageEntete(int colonne){

        Spec specRangee = GridLayout.spec(0, 3f);
        Spec specColonne = GridLayout.spec(colonne, 1f);

        LayoutParams paramsEntete = new LayoutParams(specRangee, specColonne);

        paramsEntete.width = 0;
        paramsEntete.height = 0;
        paramsEntete.setGravity(Gravity.FILL);
        paramsEntete.rightMargin = 5;
        paramsEntete.leftMargin = 5;


        return paramsEntete;
    }

    private void installerListenerEntete(VEntete entete, final int colonne) {
        entete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                actionEntete.setArguments(colonne);
                actionEntete.executerDesQuePossible();

            }
        });
    }


    private void ajouterCases(int hauteur, int largeur) {
        for (int colonne = 0; colonne < largeur; colonne++) {
            for (int rangee = 0; rangee < hauteur; rangee++) {


                VCase vCase = new VCase(getContext(), rangee, colonne);
                LayoutParams miseEnPageCase = getMiseEnPageCase(rangee, colonne);

                this.addView(vCase, miseEnPageCase);

                colonnesDeCases.get(colonne).add(vCase);

            }
        }
    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        // Pour nous, la rangée 0 est en bas
        int dernierIndiceRangee = nombreRangees -1;
        int indiceRangeeCetteCase = dernierIndiceRangee -rangee;

        Spec specRangee = GridLayout.spec(indiceRangeeCetteCase, 1f);
        Spec specColonne = GridLayout.spec(colonne, 1f);

        LayoutParams paramsCase = new LayoutParams(specRangee, specColonne);

        paramsCase.width = 0;
        paramsCase.height = 0;
        paramsCase.setGravity(Gravity.FILL);
        paramsCase.leftMargin = 5;
        paramsCase.rightMargin = 5;
        paramsCase.topMargin = 5;
        paramsCase.bottomMargin = 5;

        return paramsCase;
    }

    void afficherJetons(MGrille grille){

        List<MColonne> colonnes = grille.getColonnes();

        for(int numeroColonne=0; numeroColonne < colonnes.size(); numeroColonne++){

            List<MJeton> jetons = colonnes.get(numeroColonne).getJetons();

            for(int numeroRangee=0; numeroRangee < jetons.size(); numeroRangee++){

                MJeton jeton = jetons.get(numeroRangee);

                afficherJeton(numeroColonne, numeroRangee, jeton);

            }
        }
    }

    private void afficherJeton(int colonne, int rangee, MJeton jeton){
        colonnesDeCases.get(colonne).get(rangee).afficherJeton(jeton);
        colonnesDeCases.get(colonne).get(rangee).bouger();
    }

}
