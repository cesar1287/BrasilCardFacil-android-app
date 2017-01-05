package br.com.brasilcardfacil.www.brasilcardfacil.controller.util;

import com.google.firebase.database.DatabaseReference;

import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.User;

public class FirebaseHelper {

    public static final String FIREBASE_DATABASE_ORDERBY = "name";

    public static final String FIREBASE_DATABASE_CLINIC = "clinica";
    public static final String FIREBASE_DATABASE_TRADE = "comercio";
    public static final String FIREBASE_DATABASE_USERS = "users";
    public static final String FIREBASE_DATABASE_PARTNERS_LOCALIZATION = "parceiros_localizacao";

    public static void writeNewUser(DatabaseReference mDatabase, String userId, String name, String email, String birth, String sex, String phone, String plan, String profile_pic) {

        User user = new User(name, email, birth, phone, sex, plan, profile_pic);

        mDatabase.child(FIREBASE_DATABASE_USERS).child(userId).setValue(user);
    }
}
