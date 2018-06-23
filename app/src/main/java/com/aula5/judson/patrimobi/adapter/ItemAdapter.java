package com.aula5.judson.patrimobi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aula5.judson.patrimobi.R;
import com.aula5.judson.patrimobi.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Judson on 22/06/2018.
 */

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private List<Item> items = new ArrayList<>();

    public ItemAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_listitems, parent, false );
            holder = new ViewHolder();
            holder.txtNome = view.findViewById(R.id.txt_nome);
            holder.txtValor = view.findViewById(R.id.txt_valor);
            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();
        }
        Item item = items.get(position);

        holder.txtNome.setText(item.getNome() + " (" + item.getId() + ")");

        holder.txtValor.setText(item.getLocalizacao());

        return view;
    }

    public void setItems(List<Item> items){
        this.items = items;
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        public TextView txtNome;
        public TextView txtValor;
    }
}



















