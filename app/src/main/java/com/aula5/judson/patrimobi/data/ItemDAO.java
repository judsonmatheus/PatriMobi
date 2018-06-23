package com.aula5.judson.patrimobi.data;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Judson on 21/06/2018.
 */

public class ItemDAO {
    Map<Integer, Item> db = new HashMap<Integer, Item>();
    public List<Item> items;

    public ItemDAO(){
        items = new ArrayList<>();
        db.put(111111 ,new Item(111111, "Televisao", "Secretaria"));
        db.put(222222, new Item(222222, "Monitor", "RH"));
        db.put(333333, new Item(333333, "Computador", "TI"));
        db.put(444444, new Item(444444, "Mouse", "Diretoria"));
        db.put(555555, new Item(555555, "Teclado", "TI"));
    }

    public List<Item> list() {
        return items;
    }

    public void buscar(int id) throws Exception {
        if (db.get(id) != null){
            items.add(db.get(id));
            list();
        }else{
            throw new Exception("CÓDIGO NÃO CADASTRADO");
        }
    }
}
