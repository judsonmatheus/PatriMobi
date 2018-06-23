package com.aula5.judson.patrimobi.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Judson on 21/06/2018.
 */

public class ItemDAO {

    public List<Item> items;

    public ItemDAO(){
        items = new ArrayList<>();

    }

    public List<Item> list() {

        items.add(new Item(111111, "Televisao", "Secretaria"));
        items.add(new Item(222222, "Monitor", "RH"));
        items.add(new Item(333333, "Computador", "TI"));
        items.add(new Item(444444, "Mouse", "Diretoria"));
        items.add(new Item(555555, "Teclado", "TI"));
        return items;
    }
}
