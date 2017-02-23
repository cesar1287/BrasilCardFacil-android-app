package br.com.brasilcardfacil.www.brasilcardfacil.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.brasilcardfacil.www.brasilcardfacil.controller.domain.Partner;
import br.com.brasilcardfacil.www.brasilcardfacil.controller.firebase.FirebaseHelper;

public class BrasilCardFacilDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "bd_brasilCard";
    private static final int VERSAO = 5;
    private static final String TABELA_FAV = "fav";

    public BrasilCardFacilDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql_fav = "CREATE TABLE " + TABELA_FAV + "(" +
                "id_user TEXT, " +
                "url_logo TEXT, " +
                "name TEXT," +
                "address TEXT, " +
                "description TEXT, " +
                "site TEXT, " +
                "phone TEXT, " +
                "latitude REAL, " +
                "longitude REAL, " +
                "PRIMARY KEY (id_user, url_logo)" +
                ");";
        try {
            db.execSQL(sql_fav);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql_fav = "DROP TABLE IF EXISTS " + TABELA_FAV;
        db.execSQL(sql_fav);
        onCreate(db);
    }

    public void insertFav(String id_user, Partner partner){

        ContentValues cv = new ContentValues();
        cv.put(FirebaseHelper.FIREBASE_DATABASE_PARTNER_ID_USER, id_user);
        cv.put(FirebaseHelper.FIREBASE_DATABASE_PARTNER_URL_LOGO, partner.getUrlLogo());
        cv.put(FirebaseHelper.FIREBASE_DATABASE_PARTNER_NAME, partner.getName());
        cv.put(FirebaseHelper.FIREBASE_DATABASE_PARTNER_ADDRESS, partner.getAddress());
        cv.put(FirebaseHelper.FIREBASE_DATABASE_PARTNER_DESCRIPTION, partner.getDescription());
        cv.put(FirebaseHelper.FIREBASE_DATABASE_PARTNER_SITE, partner.getSite());
        cv.put(FirebaseHelper.FIREBASE_DATABASE_PARTNER_PHONE, partner.getPhone());
        cv.put(FirebaseHelper.FIREBASE_DATABASE_PARTNER_LATITUDE, partner.getLatitude());
        cv.put(FirebaseHelper.FIREBASE_DATABASE_PARTNER_LONGITUDE, partner.getLongitude());

        getWritableDatabase().insert(TABELA_FAV, null, cv);
    }

    public List<Partner> getFavs(String id_user) {

        String sql = "SELECT * FROM " + TABELA_FAV + " where id_user = ?";
        String args[] = new String[]{id_user};
        Cursor cursor = getReadableDatabase().rawQuery(sql, args);
        List<Partner> partners= new ArrayList<>();
        Partner partner;

        while(cursor.moveToNext()){

            partner = new Partner();

            partner.setUrlLogo(cursor.getString(cursor.getColumnIndex(FirebaseHelper.FIREBASE_DATABASE_PARTNER_URL_LOGO)));
            partner.setName(cursor.getString(cursor.getColumnIndex(FirebaseHelper.FIREBASE_DATABASE_PARTNER_NAME)));
            partner.setAddress(cursor.getString(cursor.getColumnIndex(FirebaseHelper.FIREBASE_DATABASE_PARTNER_ADDRESS)));
            partner.setDescription(cursor.getString(cursor.getColumnIndex(FirebaseHelper.FIREBASE_DATABASE_PARTNER_DESCRIPTION)));
            partner.setSite(cursor.getString(cursor.getColumnIndex(FirebaseHelper.FIREBASE_DATABASE_PARTNER_SITE)));
            partner.setPhone(cursor.getString(cursor.getColumnIndex(FirebaseHelper.FIREBASE_DATABASE_PARTNER_PHONE)));
            partner.setLatitude(cursor.getDouble(cursor.getColumnIndex(FirebaseHelper.FIREBASE_DATABASE_PARTNER_LATITUDE)));
            partner.setLongitude(cursor.getDouble(cursor.getColumnIndex(FirebaseHelper.FIREBASE_DATABASE_PARTNER_LONGITUDE)));
            partners.add(partner);
        }
        cursor.close();

        return partners;
    }

    public boolean isFav(String id_user, String url_logo) {
        String sql = "SELECT * FROM " + TABELA_FAV + " WHERE url_logo = ? and id_user = ?;";
        String[] args = {url_logo, id_user};
        final Cursor cursor = getReadableDatabase().rawQuery(sql, args);

        if(cursor.moveToFirst()){
            cursor.close();
            return true;
        }else{
            cursor.close();
            return false;
        }
    }

    public long delete(String id_user, String url_logo) {

        String args[] = {id_user, url_logo};
        return getWritableDatabase().delete(TABELA_FAV, "id_user=? and url_logo=?", args);
    }
}