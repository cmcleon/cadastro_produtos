package com.example.projeto01.database.contract;

import com.example.projeto01.database.entity.ProdutoEntity;

public final class ProdutoContract {

    private ProdutoContract(){}

    public static final String criarTabela(){
        return "CREATE TABLE" + ProdutoEntity.TABLE_NAME + " (" +
                ProdutoEntity._ID + " INTERGER PRIMARY KEY," +
                ProdutoEntity.COLLUMN_NAME_NOME + " TEXT," +
                ProdutoEntity.COLLUMN_NAME_VALOR + " REAL)";
    }

    public static final String removerTabela(){
        return "DROP TABLE IF EXISTS" + ProdutoEntity.TABLE_NAME;
    }
}
