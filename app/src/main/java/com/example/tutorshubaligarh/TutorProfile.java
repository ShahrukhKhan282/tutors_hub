package com.example.tutorshubaligarh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TutorProfile extends AppCompatActivity {
    Intent intent;
    TextView name,qualifi,exp,city,phone,classes;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);
        name=findViewById(R.id.tutor_name);
        qualifi=findViewById(R.id.profile_qualification);
        city=findViewById(R.id.profile_city);
        classes=findViewById(R.id.profile_class);
        phone=findViewById(R.id.profile_phone);
        exp=findViewById(R.id.profile_exp);

        intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        qualifi.setText(intent.getStringExtra("qualification"));
        city.setText(intent.getStringExtra("city"));
        phone.setText(intent.getStringExtra("phone"));
        exp.setText(intent.getStringExtra("experience"));
        classes.setText(intent.getStringExtra("classes"));
    }
}