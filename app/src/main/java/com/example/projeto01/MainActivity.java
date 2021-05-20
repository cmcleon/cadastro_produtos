package com.example.projeto01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projeto01.modelo.Produto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProdutos;
    private ArrayAdapter<Produto> adapterProdutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Produtos");

        listViewProdutos = findViewById(R.id.listView_produtos);
        ArrayList<Produto> produtos = this.criarListaProdutos();

        adapterProdutos = new ArrayAdapter<Produto>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                produtos);
        listViewProdutos.setAdapter(adapterProdutos);

    }



    private ArrayList<Produto> criarListaProdutos(){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto("Notebook", 3500f));
        produtos.add(new Produto("Mouse", 40f));
        produtos.add(new Produto("Roteador", 199.90f));
        return produtos;
    }

    public void onClickNovoProduto(View v){
        Intent intent = new Intent(MainActivity.this, CadastroProdutoActivity.class);
        startActivity(intent);
    }
}