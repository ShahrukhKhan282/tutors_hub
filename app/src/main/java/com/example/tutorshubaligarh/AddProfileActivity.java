package com.example.tutorshubaligarh;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddProfileActivity extends AppCompatActivity {
    TextView Name,Qualification,City,Experience,Classes,Phone;
    Button submit;
    String server_url="https://csquiz123.000webhostapp.com/api.php";
    AlertDialog.Builder builder;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);
        Name=findViewById(R.id.name);
        Qualification=findViewById(R.id.qualification);
        City=findViewById(R.id.city);
        Experience=findViewById(R.id.experience);
        Classes=findViewById(R.id.classes);
        Phone=findViewById(R.id.phone);
        submit=findViewById(R.id.button);
        requestQueue= Volley.newRequestQueue(this);
        submit.setOnClickListener(view -> {
            final String name,qualification,city,experience,classes,phone;
            name = Name.getText().toString();
            qualification = Qualification.getText().toString();
            city = City.getText().toString();
            experience = Experience.getText().toString();
            classes = Classes.getText().toString();
            phone = Phone.getText().toString();
            StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(AddProfileActivity.this, response, Toast.LENGTH_LONG).show();
                    Name.setText("");
                    Qualification.setText("");
                    City.setText("");
                    Experience.setText("");
                    Classes.setText("");
                    Phone.setText("");
                    }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(AddProfileActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> map=new HashMap<>();
                    map.put("name",name);
                    map.put("qualification",qualification);
                    map.put("city",city);
                    map.put("experience",experience);
                    map.put("classes",classes);
                    map.put("phone",phone);
                    return map;
                }
            };
            requestQueue.add(stringRequest);
        });

    }
}