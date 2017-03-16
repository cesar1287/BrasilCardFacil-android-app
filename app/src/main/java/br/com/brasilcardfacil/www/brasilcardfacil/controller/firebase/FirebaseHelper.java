package br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase;

import com.google.firebase.database.DatabaseReference;

import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.User;

public class FirebaseHelper {

    public static final String FIREBASE_DATABASE_ORDERBY = "name";
    public static final String FIREBASE_DATABASE_ORDERBY_TITLE = "title";
    public static final String FIREBASE_DATABASE_OFFER = "offer";
    public static final String FIREBASE_DATABASE_CLINIC = "clinica";
    public static final String FIREBASE_DATABASE_DENTISTRY = "odontologia";
    public static final String FIREBASE_DATABASE_VETERINARY = "veterinaria";
    public static final String FIREBASE_DATABASE_LAB = "lab";
    public static final String FIREBASE_DATABASE_ADVOCACY = "advocacia";
    public static final String FIREBASE_DATABASE_TRADE = "comercio";
    public static final String FIREBASE_DATABASE_FUNERAL = "funeraria";
    public static final String FIREBASE_DATABASE_USERS = "users";
    public static final String FIREBASE_DATABASE_PARTNERS_LOCALIZATION = "parceiros_localizacao";
    public static final String FIREBASE_DATABASE_ACTIVE_HEALTH = "saude_ativa";
    public static final String FIREBASE_DATABASE_FOOD = "alimentacao";

    public static final String FIREBASE_DATABASE_PARTNER_SUBCATEGORY = "subcategory";
    public static final String FIREBASE_DATABASE_PARTNER_NAME = "name";
    public static final String FIREBASE_DATABASE_PARTNER_URL_LOGO = "url_logo";
    public static final String FIREBASE_DATABASE_PARTNER_DESCRIPTION = "description";
    public static final String FIREBASE_DATABASE_PARTNER_ADDRESS = "address";
    public static final String FIREBASE_DATABASE_PARTNER_PHONE = "phone";
    public static final String FIREBASE_DATABASE_PARTNER_SITE = "site";
    public static final String FIREBASE_DATABASE_PARTNER_LATITUDE = "latitude";
    public static final String FIREBASE_DATABASE_PARTNER_LONGITUDE = "longitude";
    public static final String FIREBASE_DATABASE_PARTNER_ID_USER = "id_user";

    public static final String FIREBASE_DATABASE_OFFER_NAME = "name";
    public static final String FIREBASE_DATABASE_OFFER_URL_BANNER = "url_banner";
    public static final String FIREBASE_DATABASE_OFFER_DESCRIPTION = "description";
    public static final String FIREBASE_DATABASE_OFFER_ADDRESS = "address";
    public static final String FIREBASE_DATABASE_OFFER_PHONE = "phone";
    public static final String FIREBASE_DATABASE_OFFER_ABOUT = "about";
    public static final String FIREBASE_DATABASE_OFFER_LATITUDE = "latitude";
    public static final String FIREBASE_DATABASE_OFFER_LONGITUDE = "longitude";

    public static final String FIREBASE_DATABASE_ACTIVE_HEALTH_TITLE = "title";
    public static final String FIREBASE_DATABASE_ACTIVE_HEALTH_URL_BANNER = "url_banner";
    public static final String FIREBASE_DATABASE_ACTIVE_HEALTH_DESCRIPTION = "description";

    public static final String FIREBASE_NOTIFICATION_TYPE = "type_notification";
    public static final String FIREBASE_NOTIFICATION_TYPE_PARTNER = "partner";
    public static final String FIREBASE_NOTIFICATION_TYPE_OFFER = "offer";
    public static final String FIREBASE_NOTIFICATION_TYPE_ACTIVE_HEALTH = "active health";
    public static final String FIREBASE_NOTIFICATION_TYPE_UPDATE = "update";
    public static final String FIREBASE_NOTIFICATION_DATABASE = "db";
    public static final String FIREBASE_NOTIFICATION_CHILD = "child";

    public static void writeNewUser(DatabaseReference mDatabase, String userId, String name, String email, String birth, String sex, String phone, String plan, String profile_pic) {

        User user = new User(name, email, birth, phone, sex, plan, profile_pic);

        mDatabase.child(FIREBASE_DATABASE_USERS).child(userId).setValue(user);
    }
}
