package ca.cours5b5.stevendesroches.global;

public final class GConstantes {

    private GConstantes(){}

    public static final int LARGEUR_MIN = 4;
    public static final int LARGEUR_MAX = 10;
    public static final int LARGEUR_PAR_DEFAUT = 7;

    public static final int HAUTEUR_MIN = 4;
    public static final int HAUTEUR_MAX = 10;
    public static final int HAUTEUR_PAR_DEFAUT = 6;

    public static final int POUR_GAGNER_MIN = 3;
    public static final int POUR_GAGNER_PAR_DEFAUT = 4;

    public static final String EXTENSION_PAR_DEFAUT=".json";

    public  static final int NOMBRE_DE_VALEURS_A_CHARGER_DU_SERVEUR_PAR_DEFAUT = 10;

    public static final String CLE_ID_JOUEUR_HOTE = "idJoueurHote";
    public static final String CLE_IF_JOUEUR_INVITE = "idJoueurInvite";

    public static final String CLE_COUPS_JOUEUR_HOTE = "coupsJoueurHote";
    public static final String CLE_COUPS_JOUEUR_INVITE = "coupsJoueurInvite";

    // TODO: remplacer les ids par ceux de vos 2 usagers de test
    public static final String FIXME_JSON_PARTIE_RESEAU = "{\"listeCoups\":[],\"parametres\":{\"largeur\":\"7\",\"pourGagner\":\"4\",\"hauteur\":\"6\"},\"idJoueurInvite\":\"SDFGHJ\",\"idJoueurHote\":\"fgh\"}";

}
