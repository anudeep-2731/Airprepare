package com.example.airprepare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button createaccountb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createaccountb=findViewById(R.id.createaccountb);
    }

    public void Opennunberactivity(View view) {
        Intent i = new Intent(this,numberauthentication.class);
        startActivity(i);
    }

    public void Openhomescreen(View view) {
    }
}
