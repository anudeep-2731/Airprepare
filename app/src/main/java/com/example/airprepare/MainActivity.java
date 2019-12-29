package com.example.airprepare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    Button createaccountb, login;
    FirebaseAuth mAuth;
    EditText number, password;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    String num;
    String pas;
    ProgressDialog progressDialog;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createaccountb = (Button) findViewById(R.id.createaccountb);
        number = (EditText) findViewById(R.id.number);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.signinb);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);

        if(firebaseAuth.getCurrentUser()!= null){
            finish();
            startActivity( new Intent(this,Homescreen.class));
        }

    }
    public void Opennunberactivity(View view) {
        Intent i = new Intent(this,numberauthentication.class);
        startActivity(i);
    }

    public void openHomescreen(View view) {
        login.setClickable(false);
        if (number.getText().toString() == null || number.getText().toString().equals("") && password.getText().toString() == null || password.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Inavlid Inputs", Toast.LENGTH_SHORT).show();
        } else {
            progressDialog.show();
            final String num, pass;
            num = number.getText().toString();
            pass = password.getText().toString();
            mAuth = FirebaseAuth.getInstance();
            String email = num + "@gmail.com";

            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d("User Login", "signInWithEmail::success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        progressDialog.dismiss();

                        Intent i = new Intent(MainActivity.this, Homescreen.class);
                        i.putExtra("number1", num);
                        startActivity(i);
                    } else {
                        Log.w("Student Login", "signInWithEmail::failuer", task.getException());
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }

}


