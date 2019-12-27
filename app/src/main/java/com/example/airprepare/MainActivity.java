package com.example.airprepare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    Button createaccountb;
    FirebaseAuth auth;
    EditText number;
    EditText password;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    String num;
    String pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createaccountb=findViewById(R.id.createaccountb);
        number=findViewById(R.id.number);
        password=findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
    }

    public void Opennunberactivity(View view) {
        Intent i = new Intent(this,numberauthentication.class);
        startActivity(i);
    }

    public void Openhomescreen(View view) {
        DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity.this, (int) dataSnapshot.getChildrenCount(), Toast.LENGTH_SHORT).show();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Userlogin userlogin = dataSnapshot1.getValue(Userlogin.class);
                    num = userlogin.getNumber();
                    pas = userlogin.getPassword();
                    String number1 = number.getText().toString();
                    String password1 = password.getText().toString();
                    if (num.equals(number1) && pas.equals(password1)) {
                        startActivity(new Intent(MainActivity.this, Homescreen.class));
                        break;
                    } /*else {
                        Toast.makeText(MainActivity.this, "not a user", Toast.LENGTH_SHORT).show();
                    }*/

                    Toast.makeText(MainActivity.this, num, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
            }
        });


    }
    }

