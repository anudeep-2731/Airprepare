package com.example.airprepare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String mobile = null;
        editor.apply();
        Intent i2=getIntent();
        String mobno1=i2.getStringExtra("number1");
        editor.putString("numb",mobno1);
        if (sharedPreferences.getString("numb", null).length() == 0) {

            Intent i1 = new Intent(this,MainActivity.class);
            startActivity(i1);
        }
    }


}
