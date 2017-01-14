package br.com.brasilcardfacil.www.brasilcardfacil.controller.util;

public class Utility {

    public static final String CATEGORY = "category";
    public static final String CLINIC = "clinic";
    public static final String DENTISTRY = "dentistry";
    public static final String VETERINARY = "veterinary";
    public static final String LABORATORY = "laboratory";
    public static final String TRADE = "trade";
    public static final String ADVOCACY = "advocacy";
    public static final String FUNERAL = "funeral";

    public static final String KEY_CONTENT_EXTRA_PLANS = "link";

    public static final String LOGIN_SHARED_PREF_NAME = "LoginActivityPreferences";
    public static final String WARNING_SHARED_PREF_NAME = "WarningActivityPreferences";

    public static final int TIME_TO_WARNING_ACTIVITY_APPEAR = 3000;

    public static boolean verifyEmptyField(String email, String pass){

        return (email.isEmpty() || pass.isEmpty());
    }

    public static boolean verifyEmptyField(String name, String email, String pass){

        return (name.isEmpty() || email.isEmpty() || pass.isEmpty());
    }
}
