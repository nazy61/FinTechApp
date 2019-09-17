package com.nazycodes.fintechapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeMessage;
    private HashMap<String, String> user;
    private CardView myProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeMessage = findViewById(R.id.welcome_main);
        user =  (HashMap<String, String>) getIntent().getSerializableExtra("user");
        welcomeMessage.setText("Welcome, " + user.get("firstname"));

        myProfile = findViewById(R.id.my_profile);
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }
}
