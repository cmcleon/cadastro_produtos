package com.example.projeto01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projeto01.database.ProdutoDAO;
import com.example.projeto01.modelo.Produto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE_NOVO_PRODUTO = 1;
    private final int RESULT_CODE_NOVO_PRODUTO = 10;
    private final int REQUEST_CODE_EDITAR_PRODUTO = 2;
    private final int RESULT_CODE_PRODUTO_EDITADO = 11;

    private ListView listViewProdutos;
    private ArrayAdapter<Produto> adapterProdutos;
    private int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Produtos");

        listViewProdutos = findViewById(R.id.listView_produtos);
        definirOnClickListenerListView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        ProdutoDAO produtoDAO = new ProdutoDAO(getBaseContext());
        adapterProdutos = new ArrayAdapter<Produto>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                produtoDAO.listar());
        listViewProdutos.setAdapter(adapterProdutos);
    }

    private void definirOnClickListenerListView(){
        listViewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Produto produtoClicado = adapterProdutos.getItem(position);
                Intent intent = new Intent(MainActivity.this, CadastroProdutoActivity.class);
                intent.putExtra("produtoEdicao",produtoClicado);
                startActivityForResult(intent, REQUEST_CODE_EDITAR_PRODUTO);

            }
        });
    }

 //   private ArrayList<Produto> criarListaProdutos(){
  //      ArrayList<Produto> produtos = new ArrayList<Produto>();
  //      produtos.add(new Produto("Notebook", 3500f));
  //      produtos.add(new Produto("Mouse", 40f));
  //      produtos.add(new Produto("Roteador", 199.90f));
  //      return produtos;
  //  }

    public void onClickNovoProduto(View v){
        Intent intent = new Intent(MainActivity.this, CadastroProdutoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_EDITAR_PRODUTO && resultCode == RESULT_CODE_PRODUTO_EDITADO){
            Produto produtoEditado = (Produto) data.getExtras().getSerializable("produtoEditado");
            for (int i=0; i< adapterProdutos.getCount(); i++){
                Produto produto = adapterProdutos.getItem(i);
                if (produto.getId() == produtoEditado.getId()){
                    adapterProdutos.remove(produto);
                    adapterProdutos.insert(produtoEditado, i);
                    break;
                }
            }
            Toast.makeText(MainActivity.this, "Produto Editado", Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}