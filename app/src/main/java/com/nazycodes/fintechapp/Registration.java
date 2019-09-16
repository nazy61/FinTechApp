package com.nazycodes.fintechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner gender;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText age;
    private EditText phoneNumber;
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private Button btnRegister;
    private String genderSelected;
    private SharedPreferences preferences;
    private HashMap<String, String> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        gender = findViewById(R.id.gender);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        phoneNumber = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        username = findViewById(R.id.username);
        btnRegister = findViewById(R.id.btn_register);

        preferences = PreferenceManager.getDefaultSharedPreferences(Registration.this);

        if(preferences.contains("username")){
            Intent intent = new Intent(Registration.this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            String firstName = preferences.getString("firstName", "");
            String lastName = preferences.getString("lastName", "");
            String email = preferences.getString("email", "");
            String age = preferences.getString("age", "");
            String username = preferences.getString("username", "");
            String password = preferences.getString("password", "");
            String gender = preferences.getString("gender", "");
            String phone = preferences.getString("phone", "");

            user = new HashMap<>();
            user.put("firstname", firstName);
            user.put("lastname", lastName);
            user.put("email", email);
            user.put("age", age);
            user.put("username", username);
            user.put("password", password);
            user.put("gender", gender);
            user.put("phone", phone);
            intent.putExtra("user", user);
            startActivity(intent);
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(firstName.getText().toString()) && !TextUtils.isEmpty(lastName.getText().toString())
                    && !TextUtils.isEmpty(email.getText().toString()) && !TextUtils.isEmpty(age.getText().toString())
                    && !TextUtils.isEmpty(phoneNumber.getText().toString()) && !TextUtils.isEmpty(password.getText().toString())
                    && !TextUtils.isEmpty(username.getText().toString()))
                {
                    if(!password.getText().toString().equalsIgnoreCase(confirmPassword.getText().toString())){
                        Toast.makeText(Registration.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                    } else {
                        registerUser();

                        Intent intent = new Intent(Registration.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra("user", user);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(Registration.this, "Please Fill the Form Completely", Toast.LENGTH_LONG).show();
                }
            }
        });

        List<String> genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");

        //Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genderList);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gender.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        genderSelected = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void registerUser() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("firstName", firstName.getText().toString());
        editor.putString("lastName", lastName.getText().toString());
        editor.putString("email", email.getText().toString());
        editor.putString("gender", genderSelected);
        editor.putString("age", age.getText().toString());
        editor.putString("phone", phoneNumber.getText().toString());
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();
    }
}
