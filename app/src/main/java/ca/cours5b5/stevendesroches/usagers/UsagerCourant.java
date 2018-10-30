package ca.cours5b5.stevendesroches.usagers;

import com.google.firebase.auth.FirebaseAuth;

public class UsagerCourant {

    public static boolean siUsagerConnecte(){

        boolean result = false;

        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            result = true;
        }

        return result;
    }

    public static String getId(){
        String uid = "0";

        if (siUsagerConnecte()){
            uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        }

        return uid;
    }
}
