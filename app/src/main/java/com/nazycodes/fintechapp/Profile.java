package com.nazycodes.fintechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class Profile extends AppCompatActivity {

    private HashMap<String, String> user;
    private TextView welcome;
    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private TextView gender;
    private TextView age;
    private TextView phone;
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = (HashMap<String, String>) getIntent().getSerializableExtra("user");

        welcome = findViewById(R.id.welcome);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);
        phone = findViewById(R.id.phone);
        username = findViewById(R.id.username);

        welcome.setText("Welcome, " + user.get("firstname"));
        firstName.setText("First Name: " + user.get("firstname"));
        lastName.setText("Last Name: " + user.get("lastname"));
        email.setText("Email: " + user.get("email"));
        gender.setText("Gender: " + user.get("gender"));
        age.setText("Age: " + user.get("age"));
        phone.setText("Phone Number: " + user.get("phone"));
        username.setText("Username: " + user.get("username"));
    }
}
