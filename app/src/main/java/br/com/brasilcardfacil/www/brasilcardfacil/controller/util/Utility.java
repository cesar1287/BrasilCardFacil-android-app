package br.com.brasilcardfacil.www.brasilcardfacil.controller.util;

public class Utility {

    public static final String CATEGORY = "category";
    public static final String SUBCATEGORY = "subcategory";

    public static final String FOOD = "alimentacao";
    public static final String ART_DESIGN = "art_design";
    public static final String BEAUTY = "beleza";
    public static final String CONSULTING = "consultoria";
    public static final String EDUCATION = "educacao";

    public static final String KEY_CONTENT_EXTRA_PLANS = "link";
    public static final String KEY_CONTENT_EXTRA_PARTNER = "partner";
    public static final String KEY_CONTENT_EXTRA_OFFER = "offer";
    public static final String KEY_CONTENT_EXTRA_ACTIVE_HEALTH = "active_health";
    public static final String KEY_CONTENT_EXTRA_ACTIVE_PARTNERS_NEARBY = "partners";
    public static final String KEY_MAIN_FRAGMENT = "mainFrag";
    public static final String KEY_MAP_FRAGMENT = "mapFrag";

    public static final String ART_DESIGN_SUBCATEGORY_AGENCY = "agencia";
    public static final String ART_DESIGN_SUBCATEGORY_ART = "arte";
    public static final String ART_DESIGN_SUBCATEGORY_GRAPHICS = "graficas";
    public static final String ART_DESIGN_SUBCATEGORY_DESIGN = "design";
    public static final String ART_DESIGN_SUBCATEGORY_DECORATION = "decoracao";

    public static final String EDUCATION_SUBCATEGORY_SCHOOL = "colegio";
    public static final String EDUCATION_SUBCATEGORY_COURSE = "curso";
    public static final String EDUCATION_SUBCATEGORY_TECHNICIAN = "tecnico";
    public static final String EDUCATION_SUBCATEGORY_UNIVERSITY = "universidade";

    public static final String BEAUTY_SUBCATEGORY_AESTHETICS = "agencia";
    public static final String BEAUTY_SUBCATEGORY_BARBER_SHOP = "barbearia";
    public static final String BEAUTY_SUBCATEGORY_MAKE_UP = "maquiagem";
    public static final String BEAUTY_SUBCATEGORY_BEAUTY_SALON = "salao_beleza";

    public static final String CONSULTING_SUBCATEGORY_BUSINESS = "empresarial";
    public static final String CONSULTING_SUBCATEGORY_LEGAL = "legal";

    public static final String FOOD_SUBCATEGORY_PUB = "bar";
    public static final String FOOD_SUBCATEGORY_RESTAURANT = "restaurante";
    public static final String FOOD_SUBCATEGORY_BAKERY = "padaria";
    public static final String FOOD_SUBCATEGORY_WATER = "agua";
    public static final String FOOD_SUBCATEGORY_SUPERMARKET = "supermercado";
    public static final String FOOD_SUBCATEGORY_DISTRIBUTOR = "distribuidor";

    public static final String LOGIN_SHARED_PREF_NAME = "LoginActivityPreferences";
    public static final String WARNING_SHARED_PREF_NAME = "WarningActivityPreferences";

    public static final int TIME_TO_WARNING_ACTIVITY_APPEAR = 30000;

    public static final String APP_PACKAGE_NAME = "br.com.brasilcardfacil.www.brasilcardfacil";

    public static boolean verifyEmptyField(String email, String pass){

        return (email.isEmpty() || pass.isEmpty());
    }

    public static boolean verifyEmptyField(String name, String email, String pass){

        return (name.isEmpty() || email.isEmpty() || pass.isEmpty());
    }
}
