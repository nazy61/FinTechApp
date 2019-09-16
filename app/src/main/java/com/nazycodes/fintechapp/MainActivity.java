package com.nazycodes.fintechapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeMessage;
    private HashMap<String, String> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeMessage = findViewById(R.id.welcome);
        user =  (HashMap<String, String>) getIntent().getSerializableExtra("user");
        welcomeMessage.setText("Welcome, " + user.get("firstname") );
    }
}
