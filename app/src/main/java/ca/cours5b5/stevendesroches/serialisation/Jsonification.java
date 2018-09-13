package ca.cours5b5.stevendesroches.serialisation;

import com.google.gson.Gson;

import java.util.Map;


public class Jsonification {

    private static Gson gson = new Gson();

    public static Map<String, Object> enObjetJson(String json){


        Map<String, Object> objetJson = gson.fromJson(json, Map.class);
        return objetJson;
    }

    public static String enChaine(Map<String, Object> objetJson){

        String chainJson = gson.toJson(objetJson);
        return chainJson;
    }

}
