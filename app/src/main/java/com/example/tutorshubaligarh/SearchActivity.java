package com.example.tutorshubaligarh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {
    String name,qualification,classes,intent_classes,city,intent_city,phone,experience,url="https://csquiz123.000webhostapp.com/api_search.php";
    RecyclerView recyclerView;
    AdapterClass adapter;
    List<Model> list=new ArrayList<>();
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Searching Tutors....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        Intent intent = getIntent();
        intent_classes = intent.getStringExtra("class");
        intent_city = intent.getStringExtra("city");
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        loadProducts(intent_classes,intent_city);
        adapter =new AdapterClass(list, SearchActivity.this);
        recyclerView.setAdapter(adapter);
    }
    private void loadProducts(String inclasses, String incity) {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        name=jsonObject.getString("name");
                        qualification=jsonObject.getString("qualification");
                        city=jsonObject.getString("city");
                        experience=jsonObject.getString("experience");
                        phone=jsonObject.getString("phone");
                        classes=jsonObject.getString("classes");
                        Model model=new Model(name,qualification,city,experience,classes,phone);
                        list.add(model);
                    }
                    adapter.notifyDataSetChanged();
                    progressDialog.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SearchActivity.this, "Server Busy! Please Try Again Later.", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(SearchActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }){
            protected Map<String,String>  getParams() throws AuthFailureError{
                Map<String, String> map=new HashMap<>();
                map.put("class",inclasses);
                map.put("city",incity);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }
}