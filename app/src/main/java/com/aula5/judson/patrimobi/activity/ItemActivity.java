package com.aula5.judson.patrimobi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

        Toast.makeText(this, "Item: " +item.getNome(), Toast.LENGTH_LONG).show();
    }
}
