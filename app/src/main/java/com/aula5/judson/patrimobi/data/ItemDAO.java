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
        db.put(111111 ,new Item(111111, "Televisao", "Secretaria", 1299.99, "ATIVO", "10/01/2017", "Televisão de 22'. Marca Semp. Com 2 anos de garantia " ));
        db.put(222222, new Item(222222, "Monitor", "RH", 400.00, "ATIVO", "10/05/2018", "Monitor ACER de 19'. Entrada de video VGA. Resolução 1366x768."));
        db.put(333333, new Item(333333, "Computador", "TI", 819.65, "INATIVO", "21/02/2015", "Descktop N3 com 4Gb de RAM e processador I3."));
        db.put(444444, new Item(444444, "Mouse", "Diretoria", 5.90, "ATIVO", "21/02/2015", "Mouse USB N3"));
        db.put(555555, new Item(555555, "Teclado", "TI", 8.89, "ATIVO", "21/02/2015", "Teclado USB N3"));
    }

    public List<Item> list() {
        return items;
    }

    public void buscar(int id) throws Exception {
        if (db.get(id) != null){
            items.add(0,db.get(id));
            list();
        }else{
            throw new Exception("CÓDIGO NÃO CADASTRADO");
        }
    }
}
