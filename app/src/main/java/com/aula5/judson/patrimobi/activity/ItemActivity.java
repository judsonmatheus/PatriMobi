package com.aula5.judson.patrimobi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aula5.judson.patrimobi.R;
import com.aula5.judson.patrimobi.data.Item;

public class ItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent intent = getIntent();
        Item item = (Item) intent.getSerializableExtra("Item");

        TextView id = findViewById(R.id.item_tv_id);
        TextView nome = findViewById(R.id.item_tv_nome);
        TextView localizacao = findViewById(R.id.item_tv_localizacao);
        TextView valor = findViewById(R.id.item_tv_valor);
        TextView situacao = findViewById(R.id.item_tv_situacao);
        TextView dataAquisicao = findViewById(R.id.item_tv_dataAquisicao);
        TextView descricao = findViewById(R.id.item_tv_descricao);

        id.setText( String.valueOf(item.getId()));
        nome.setText("Nome: " +item.getNome());
        localizacao.setText("Localização: " +item.getLocalizacao());
        valor.setText("Valor: R$ " + String.valueOf(item.getValor()));
        situacao.setText("Situação: " + item.getSituacao());
        dataAquisicao.setText("Data Aquisição: " +item.getDataAquisicao());
        descricao.setText("Descricao: " +item.getDescricao());

    }
}
