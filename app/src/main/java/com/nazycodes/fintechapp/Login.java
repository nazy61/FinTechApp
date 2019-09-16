package com.nazycodes.fintechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button btnLogin;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");
        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(editTextUsername.getText().toString()) && !TextUtils.isEmpty(editTextPassword.getText().toString())){
                    login();
                } else {
                    Toast.makeText(Login.this, "Enter Your Login Details", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void login() {
        if(username.equalsIgnoreCase(editTextUsername.getText().toString()) && password.equalsIgnoreCase(editTextPassword.getText().toString())){
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(Login.this, "Incorrect Login Details", Toast.LENGTH_LONG).show();
        }
    }
}
