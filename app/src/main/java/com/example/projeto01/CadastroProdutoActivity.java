package com.example.projeto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.projeto01.modelo.Produto;

public class CadastroProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
        setTitle("Cadastro de Produto");
    }

    public void onClickVoltar(View v){
        finish();
    }

    public void onClickSalvar(View v){
        EditText editTextNome = findViewById(R.id.editText_nome);
        EditText editTexValor = findViewById(R.id.editText_valor);

        String nome = editTextNome.getText().toString();
        Float valor = Float.parseFloat(editTexValor.getText().toString());

        Produto produto = new Produto (nome, valor);
        finish();
    }
}