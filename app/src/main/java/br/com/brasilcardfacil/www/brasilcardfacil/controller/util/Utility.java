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

    public static final String FIREBASE_DATABASE_ORDERBY = "name";

    public static final String FIREBASE_DATABASE_CLINIC = "clinica";
    public static final String FIREBASE_DATABASE_TRADE = "comercio";

    public static boolean verifyEmptyField(String email, String pass){

        return (email.isEmpty() || pass.isEmpty());
    }

    public static boolean verifyEmptyField(String name, String email, String pass){

        return (name.isEmpty() || email.isEmpty() || pass.isEmpty());
    }
}
