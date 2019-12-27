package com.example.airprepare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    EditText ename;
    EditText eemail;
    EditText epassword;
    DatabaseReference databasemember;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        databasemember= FirebaseDatabase.getInstance().getReference("members");
        ename=findViewById(R.id.namer);
        eemail=findViewById(R.id.emailr);
        epassword=findViewById(R.id.passwordr);
        firebaseAuth=FirebaseAuth.getInstance();

    }

    public void Openloginpage(View view) {
        addmember();

    }
    private void addmember(){
        String name=ename.getText().toString().trim();
        String email=eemail.getText().toString().trim();
        String password=epassword.getText().toString().trim();
        String number=getIntent().getStringExtra("number");

        if(!TextUtils.isEmpty(name)){
            String id= databasemember.push().getKey();
            Insert insert=new Insert(id,number,name,email,password);
            databasemember.child(firebaseAuth.getUid()).setValue(insert);
            Toast.makeText(this, "REGISTRATION SUCCESS", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Enter all the details", Toast.LENGTH_SHORT).show();
        }
    }

}
