package com.example.projeto01.database.entity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.projeto01.database.contract.ProdutoContract;

import androidx.annotation.Nullable;

public class DatabaseDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db.produto";
    private static final int DATABASE_VERSION = 1;

    public DatabaseDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ProdutoContract.criarTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ProdutoContract.removerTabela());
        db.execSQL(ProdutoContract.criarTabela());

    }
}
