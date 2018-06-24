package com.aula5.judson.patrimobi.activity;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.aula5.judson.patrimobi.R;
import com.aula5.judson.patrimobi.adapter.ItemAdapter;
import com.aula5.judson.patrimobi.data.Item;
import com.aula5.judson.patrimobi.data.ItemDAO;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends ListActivity implements OnItemLongClickListener{
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    private ItemDAO itemDAO;
    private ItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ItemAdapter(this);
        setListAdapter(adapter);

        getListView().setOnItemLongClickListener(this);

        itemDAO = new ItemDAO();

        updateList();

    }

    private void updateList() {
        List<Item> items = itemDAO.list();
//        List<Item> items = adapter.getItems();
        adapter.setItems(items);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Item item = (Item) adapter.getItem((int) position);
//        Toast.makeText(this, item.getNome().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ItemActivity.class);
        intent.putExtra("Item", item);
        startActivity(intent);
    }

    public void buscar(View view) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        try {
            EditText mEdit = findViewById(R.id.main_editText);
            int id = Integer.parseInt(mEdit.getText().toString());
            mEdit.setText("");
            itemDAO.buscar(id);
            updateList();
        }catch (Exception e){
            Toast.makeText(this, "CÓDIGO NÃO CADASTRADO!", Toast.LENGTH_SHORT).show();
        }

    }
    //--------------------------------------------------------------------------------------------------------
    //Menu começa aqui

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_logout:
                Toast.makeText(this, "Clicou em logout", Toast.LENGTH_SHORT).show();
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //--------------------------------------------------------------------------------------------------------

//Leitura de código de barra começa aqui
    public void readeCodebar(View view) {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            //on catch, show the download dialog
            showDialog(MainActivity.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
        }
    }

    private static AlertDialog showDialog(final MainActivity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                EditText editText = findViewById(R.id.main_editText);
                editText.setText(contents);
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            }
        }
    }



}
