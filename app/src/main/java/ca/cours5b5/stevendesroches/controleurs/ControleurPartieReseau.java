package ca.cours5b5.stevendesroches.controleurs;

import android.util.Log;

import ca.cours5b5.stevendesroches.donnees.Serveur;
import ca.cours5b5.stevendesroches.global.GCommande;
import ca.cours5b5.stevendesroches.global.GConstantes;
import ca.cours5b5.stevendesroches.modeles.MPartieReseau;
import ca.cours5b5.stevendesroches.proxy.ProxyListe;
import ca.cours5b5.stevendesroches.usagers.UsagerCourant;

public class ControleurPartieReseau {

    private static final ControleurPartieReseau instance = new ControleurPartieReseau();

    public static ControleurPartieReseau getInstance() {return instance;}

    private ProxyListe proxyEmettreCoups;
    private ProxyListe proxyRecevoirCoups;

    public void connecterAuServeur(){

        //modele MPartieReseau
        //Id de l<hote a partir du modele
        connecterAuServeur(GConstantes.CLE_ID_JOUEUR_HOTE);
    }

    private void connecterAuServeur(String idJoueurHote) {

        if (idJoueurHote.equals(UsagerCourant.getId())){
            connecterEnTantQueJoueurHote(getCheminCoupsJoueurHote(idJoueurHote), getCheminCoupsJoueurInvite(idJoueurHote));
        } else {
            connecterEnTantQueJoueurInvite(getCheminCoupsJoueurHote(idJoueurHote), getCheminCoupsJoueurInvite(idJoueurHote));
        }

        proxyRecevoirCoups.connecterAuServeur();
        proxyEmettreCoups.connecterAuServeur();

        proxyRecevoirCoups.setActionNouvelItem(GCommande.RECEVOIR_COUP_RESEAU);

    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite) {
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurHote);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurInvite);
    }

    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite) {
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurInvite);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurHote);
    }

    public void donnecterDuServeur(){
        proxyEmettreCoups.detruireValeurs();
        proxyEmettreCoups.deconnecterDuServeur();
        proxyRecevoirCoups.deconnecterDuServeur();
    }

    public void transmettreCoup(Integer idColonne){
        proxyEmettreCoups.ajouterValeur(idColonne);
    }

    public String getCheminCoupsJoueurInvite(String idJoueurHote){
        Log.d("atelier13", this.getClass().getSimpleName() + "::getCheminCoupsJoueurInvite::" + MPartieReseau.class.getSimpleName() + "/" + idJoueurHote + "/" + GConstantes.CLE_COUPS_JOUEUR_HOTE);
        return MPartieReseau.class.getSimpleName() + "/" + idJoueurHote + "/" + GConstantes.CLE_COUPS_JOUEUR_INVITE;
    }

    public String getCheminCoupsJoueurHote(String idJoueurHote){
        Log.d("atelier13", this.getClass().getSimpleName() + "::getCheminCoupsJoueurHote::" + MPartieReseau.class.getSimpleName() + "/" + idJoueurHote + "/" + GConstantes.CLE_COUPS_JOUEUR_HOTE);
        return MPartieReseau.class.getSimpleName() + "/" + idJoueurHote + "/" + GConstantes.CLE_COUPS_JOUEUR_HOTE;
    }

    private String getCheminPartie(String idJoueurHote){
        return MPartieReseau.class.getSimpleName() + "/" + idJoueurHote;
    }

    public void detruireSauvegardeServeur(){
        Serveur.getInstance().detruireSauvegarde(getCheminPartie(GConstantes.CLE_ID_JOUEUR_HOTE));
    }



}
