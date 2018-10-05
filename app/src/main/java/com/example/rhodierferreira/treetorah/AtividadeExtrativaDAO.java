package com.example.rhodierferreira.treetorah;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import models.AtividadeExtrativa;

public class AtividadeExtrativaDAO extends SQLiteOpenHelper{

    public AtividadeExtrativaDAO (Context context) {
        super(context, "AtividadeExtrativa", null, 5);
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

    public void insere(AtividadeExtrativa atividadeExtrativa) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("ano", atividadeExtrativa.getAno());
        dados.put("estado", atividadeExtrativa.getEstado());
        dados.put("arvores_cortadas", atividadeExtrativa.getArvoresCortadas());
        dados.put("arvores_repostas", atividadeExtrativa.getArvoresRepostas());
        dados.put("diametro_maior", atividadeExtrativa.getDiametroMaior());
        dados.put("diametro_menor", atividadeExtrativa.getDiametroMenor());
        dados.put("altura", atividadeExtrativa.getAltura());
        Log.d("Inserir", String.valueOf(atividadeExtrativa.getArvoresRepostas()));
        db.insert("AtividadeExtrativa", null, dados );
    }

    public ArrayList<AtividadeExtrativa> lista(String ordemCampo)  {
        String sql = "SELECT * FROM AtividadeExtrativa ORDER BY " + ordemCampo + ";";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        ArrayList<AtividadeExtrativa> atividades = new ArrayList<AtividadeExtrativa>();
        while (c.moveToNext()) {
            AtividadeExtrativa atividade = new AtividadeExtrativa();
            atividade.setId(Integer.parseInt(c.getString(c.getColumnIndex("ano"))));
            atividade.setAno(c.getString(c.getColumnIndex("ano")));
            atividade.setEstado(c.getString(c.getColumnIndex("estado")));
            atividade.setArvoresCortadas(Integer.parseInt(c.getString(c.getColumnIndex("arvores_cortadas"))));
            atividade.setArvoresRepostas(Integer.parseInt(c.getString(c.getColumnIndex("arvores_repostas"))));
            atividade.setDiametroMaior(Double.valueOf(c.getString(c.getColumnIndex("diametro_maior"))));
            atividade.setDiametroMenor(Double.valueOf(c.getString(c.getColumnIndex("diametro_menor"))));
            atividade.setAltura(Double.valueOf(c.getString(c.getColumnIndex("altura"))));
            Log.d("Objeto", String.valueOf(atividade.getArvoresRepostas()));
            atividades.add(atividade);

        }
        c.close();

        return atividades;

    }

}
