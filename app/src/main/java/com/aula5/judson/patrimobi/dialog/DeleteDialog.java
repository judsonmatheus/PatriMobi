package com.aula5.judson.patrimobi.dialog;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.aula5.judson.patrimobi.data.Item;
import com.aula5.judson.patrimobi.data.ItemDAO;

/**
 * Created by Judson on 01/07/2018.
 */

public class DeleteDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private OnDeleteListener listener;
    private Item item;
    private ItemDAO itemDAO;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (!(context instanceof OnDeleteListener)) {
            throw new RuntimeException("A activity deve implementar DialogFragment.OnDeleteListener");
        }

        this.listener = (OnDeleteListener) context;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Deseja excluir o item " + item.getId()+ "?");
        builder.setNegativeButton("NÃO", this);
        builder.setPositiveButton("SIM", this);
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE && listener != null) {
            listener.onDelete(item);
        }

    }

    public void setItem(Item item){
        this.item = item;
    }

    public interface OnDeleteListener {
        public void onDelete(Item item);
    }
}
