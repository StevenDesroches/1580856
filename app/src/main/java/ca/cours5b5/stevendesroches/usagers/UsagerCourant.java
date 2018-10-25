package ca.cours5b5.stevendesroches.usagers;

import com.google.firebase.auth.FirebaseAuth;

public class UsagerCourant {

    public static boolean siUsagerConnecte(){

        boolean result = false;
        FirebaseAuth.getInstance().getCurrentUser();

        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            result = true;
        }

        return result;
    }

    public static String getId(){
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}
