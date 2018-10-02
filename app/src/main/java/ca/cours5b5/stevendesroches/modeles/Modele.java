package ca.cours5b5.stevendesroches.modeles;

import java.util.Map;

public abstract class Modele {

    public abstract void aPartirObjetJson(Map<String, Object> objetJson);

    public abstract Map<String, Object> enObjetJson();
}