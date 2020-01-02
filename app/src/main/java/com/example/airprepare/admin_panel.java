package com.example.airprepare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class admin_panel extends AppCompatActivity {
    EditText city,taxi1,taxi2,food1,food2,hotel1,hotel2,place1,place2;
    Button push;
    DatabaseReference databasemember;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        city=findViewById(R.id.city);
        databasemember= FirebaseDatabase.getInstance().getReference("cities");
        taxi1=findViewById(R.id.taxi1);
        taxi2=findViewById(R.id.taxi2);
        food1=findViewById(R.id.restaurant1);
        food2=findViewById(R.id.restaurant2);
        hotel1=findViewById(R.id.hotels1);
        hotel2=findViewById(R.id.hotels2);
        place1=findViewById(R.id.tourists);
        place2=findViewById(R.id.touist2);
    }


    public void pushdata(View view) {
        adddata();
    }

    private void adddata() {
        String cities=city.getText().toString();
        String taxies1=taxi1.getText().toString();
        String taxies2=taxi2.getText().toString();
        String hotels1=hotel1.getText().toString();
        String hotels2=hotel2.getText().toString();
        String restu1=food1.getText().toString();
        String restu2=food2.getText().toString();
        String places1=place1.getText().toString();
        String places2=place2.getText().toString();
        String taxi="TAXIS";
        String restu="RESTUARANT";
        String hotel="HOTELS";
        String place="TOURIST PLACES";
        if(!TextUtils.isEmpty(cities)){
            pushdata pushingdata=new pushdata(cities,
                    taxies1,
                     taxies2);
            pushdata2 pushdata2=new pushdata2(cities,restu1,restu2);
            pushdata2 pushdata21=new pushdata2(places1,places2);
            pushdata pushdata=new pushdata(hotels1,hotels2);
            databasemember.child(cities).child(taxi).setValue(pushingdata);
            databasemember.child(cities).child(hotel).setValue(pushdata);
            databasemember.child(cities).child(restu).setValue(pushdata2);
            databasemember.child(cities).child(place).setValue(pushdata21);
            Toast.makeText(this, "push successfull", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "push unsucessfull", Toast.LENGTH_SHORT).show();
        }

    }
}
