package com.example.rhodierferreira.treetorah;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AtividadeExtrativaDAO extends SQLiteOpenHelper{

    public AtividadeExtrativaDAO (Context context) {
        super(context, "AtividadeExtrativa", null, 1);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        String sql = "CREATE TABLE AtividadeExtrativa (id INTEGER PRIMARY KEY, ano TEXT NOT NULL, estado TEXT NOT NULL, arvores_cortadas INTEGER, arvores_repostas INTEGER, diametro_maior REAL, diametro_menor REAL, altura REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS AtividadeExtrativa";
        db.execSQL(sql);
        onCreate(db);
    }
}
