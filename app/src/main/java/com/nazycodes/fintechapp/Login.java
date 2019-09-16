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

import java.util.HashMap;

public class Login extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button btnLogin;
    //private Button btnRegister;
    private HashMap<String, String> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (HashMap<String, String>) getIntent().getSerializableExtra("user");
        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_login);
        //btnRegister = findViewById(R.id.btn_register);

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

        /*

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
                finish();
            }
        });

         */
    }

    private void login() {
        if(user.get("username").equalsIgnoreCase(editTextUsername.getText().toString()) && user.get("password").equalsIgnoreCase(editTextPassword.getText().toString())){
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("user", user);
            startActivity(intent);
        } else {
            Toast.makeText(Login.this, "Incorrect Login Details", Toast.LENGTH_LONG).show();
        }
    }
}
