package com.example.projeto01.modelo;

import androidx.annotation.NonNull;

public class Produto {
    private String nome;
    private Float valor;

    public Produto(String nome, Float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @NonNull
    @Override
    public String toString(){
        return nome + " - " + " R$"+ valor;
    }
}
