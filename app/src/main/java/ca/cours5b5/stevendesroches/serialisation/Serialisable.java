package ca.cours5b5.stevendesroches.serialisation;

import java.lang.reflect.Field;
import java.util.Map;

import ca.cours5b5.stevendesroches.exceptions.ErreurDeSerialisation;

public interface Serialisable {

    public static Map<String, Object> serialiser(Serialisable obj) throws ErreurDeSerialisation

    public static void deserialiser(Serialisable obj, Map<String, Object> objetJson) throws ErreurDeSerialisation

    private static void serialiserAttributs(Map<String, Object> objetJson, Serialisable obj);

    private static boolean siAttributSerialisable(Field attribut);

    private static void serialiserAttribut(Map<String, Object> objetJson, Serialisable obj, Field attribut);

    private static Object serialiserValeur(Class type, Object valeur);

    private static void deserialiserAttributs(Serialisable, Map<String, Object> objetJson);

    private static void deserialiserAttribut(Serialisable, String nomAttribut, Object valeurAttribut);

    private static void deserialiserAttribut(Serialisable, Field attribut, Object valeurAttribut);
}
