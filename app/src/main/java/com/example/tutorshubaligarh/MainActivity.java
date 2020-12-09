package com.example.tutorshubaligarh;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    CardView cardView1;
    AlertDialog dialogBuilder;
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = this.getLayoutInflater();
        cardView = findViewById(R.id.cardView);
        cardView1 = findViewById(R.id.cardView1);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNetworkConnected()){
                    //Intent intent= new Intent(MainActivity.this, SearchActivity.class);
                    //startActivity(intent);

                    dialogBuilder = new AlertDialog.Builder(MainActivity.this).create();
                    View dialogView = inflater.inflate(R.layout.dialogbox, null);

                    EditText editText1 =dialogView.findViewById(R.id.search_class);
                    EditText editText2 =dialogView.findViewById(R.id.seacrh_city);
                    //EditText editText3 =dialogView.findViewById(R.id.dialog_title);
                    Button searchButton =dialogView.findViewById(R.id.search_button);
                    searchButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "Submit", Toast.LENGTH_SHORT).show();
                            dialogBuilder.dismiss();
                        }
                    });
                    dialogBuilder.setView(dialogView);
                    dialogBuilder.show();


                }
                else{
                    Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNetworkConnected()){
                    Intent intent= new Intent(MainActivity.this, AddProfileActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}