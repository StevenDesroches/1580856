package ca.cours5b5.stevendesroches.controleurs;

import ca.cours5b5.stevendesroches.global.GConstantes;
import ca.cours5b5.stevendesroches.proxy.ProxyListe;

public class ControleurPartieReseau {

    private static final ControleurPartieReseau instance = new ControleurPartieReseau();

    public static ControleurPartieReseau getInstance() {return instance;}

    private ProxyListe proxyEmettreCoups;
    private ProxyListe proxyRecevoirCoups;

    public void connecterAuServeur(){

    }

    private void connecterAuServeur(String idJoueurHote) {

    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite) {

    }

    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite) {

    }

    public void donnecterDuServeur(){

    }

    public void transmettreCoup(Integer idColonne){

    }

    public String getCheminCoupsJoueurInvite(String idJoueurHote){
        return GConstantes.CLE_COUPS_JOUEUR_INVITE; //chemin non complet
    }

    public String getCheminCoupsJoueurHote(String idJoueurHote){
        return GConstantes.CLE_COUPS_JOUEUR_HOTE; //chemin non complet
    }

    private String getCheminPartie(String idJoueurHote){
        return null;
    }

    public void detruireSauvegardeServeur(){
        detruireSauvegardeServeur(); //il faut le bon chemin
    }



}
