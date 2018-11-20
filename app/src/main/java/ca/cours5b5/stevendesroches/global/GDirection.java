package ca.cours5b5.stevendesroches.global;

import java.util.List;

public class GDirection {

    public int incrementHorizontal;
    public int incrementVertical;

    public static List<GDirection> directions;

    static{
        directions.add(new GDirection(0, 4)); //haut
        directions.add(new GDirection(4, 0)); //droite
        directions.add(new GDirection(4, 4)); //diagonal

        //(BONUS: a-t-on besoin de toutes les créer?)
        //Cela depend de comment la vérification est faite.
        //Si elle est fait à partir de la case qui vient d'être jouer.
        //il faudra vérifier dans toutes les directions avec comme origine la case qui vient d'être jouée.
        //Dans ce cas il faut 8 directions.

        //Dans le cas où la vérification est faite sur chaque case.
        //il n<
    }

    public GDirection(int incrementHorizontal, int incrementVertical){
        this.incrementHorizontal = incrementHorizontal;
        this.incrementVertical = incrementVertical;
    }
}
