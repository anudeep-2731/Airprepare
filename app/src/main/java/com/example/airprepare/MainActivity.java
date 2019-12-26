package com.example.airprepare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;


public class MainActivity extends AppCompatActivity {
    Button createaccountb;
    FirebaseAuth auth;
    EditText number;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createaccountb=findViewById(R.id.createaccountb);
        number=findViewById(R.id.number);
        password=findViewById(R.id.password);
    }

    public void Opennunberactivity(View view) {
        Intent i = new Intent(this,numberauthentication.class);
        startActivity(i);
    }

    public void Openhomescreen(View view) {
    }
    }

