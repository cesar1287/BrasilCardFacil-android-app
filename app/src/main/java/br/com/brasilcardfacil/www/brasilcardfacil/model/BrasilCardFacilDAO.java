package br.com.brasilcardfacil.www.brasilcardfacil.model;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BrasilCardFacilDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "bd_brasilCard";
    private static final int VERSAO = 1;
    private static final String TABELA_USER = "user";
    private static final String TABELA_PICTURE = "picture";

    public BrasilCardFacilDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql_user = "CREATE TABLE " + TABELA_USER + "(" +
                "id TEXT PRIMARY KEY, " +
                "email TEXT," +
                "name TEXT NOT NULL, " +
                "password TEXT, " +
                "profile_pic TEXT, " +
                "telefone TEXT" +
                ");";

        String sql_pic = "CREATE TABLE " + TABELA_PICTURE + "(" +
                "id TEXT, " +
                "url_pic TEXT, " +
                "PRIMARY KEY ( id, url_pic)" +
                ");";
        try {
            db.execSQL(sql_user);
            db.execSQL(sql_pic);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql_user = "DROP TABLE IF EXISTS " + TABELA_USER;
        String sql_pic = "DROP TABLE IF EXISTS " + TABELA_PICTURE;
        db.execSQL(sql_user);
        db.execSQL(sql_pic);
        onCreate(db);
    }
}