package com.aula5.judson.patrimobi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.aula5.judson.patrimobi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends Activity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }


    }


    public void login(View view) {

        AutoCompleteTextView tv_email = findViewById(R.id.email);
        EditText edt_password = findViewById(R.id.password);

        if( tv_email.length() != 0 && edt_password.length() != 0) {
            String email = tv_email.getText().toString();
            String password = edt_password.getText().toString();


            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser currentUser = mAuth.getCurrentUser();

                                if (currentUser != null) {
                                    Toast.makeText(getApplication(), "Logado", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(getApplication(), "Falha na Autenticação", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplication(), "Falha na Autenticação", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else{
            Toast.makeText(this, "Email ou Password não informado!", Toast.LENGTH_SHORT).show();
        }
    }

    public void logout(View view){
        mAuth.signOut();
        Toast.makeText(getApplication(), "Deslogou", Toast.LENGTH_SHORT).show();
    }

    public void register(View view) {
        AutoCompleteTextView tv_email = findViewById(R.id.email);
        String email = tv_email.getText().toString();
        EditText edt_password = findViewById(R.id.password);
        String password = edt_password.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        FirebaseUser currentUser =mAuth.getCurrentUser();
                        if(currentUser != null){
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplication(), "Falha na Criação do Usuário", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
