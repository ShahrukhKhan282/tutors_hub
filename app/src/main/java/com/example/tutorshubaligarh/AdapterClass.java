package com.example.tutorshubaligarh;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    private List<Model> listItems;
    private Context context;

    public AdapterClass(List<Model> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model= listItems.get(position);
        holder.name.setText(model.getName());
        holder.qualification.setText(model.getQualification());
        holder.city.setText(model.getCity());
        Intent intent=new Intent(context,TutorProfile.class);
        intent.putExtra("name",model.getName());
        intent.putExtra("qualification",model.getQualification());
        intent.putExtra("city",model.getCity());
        intent.putExtra("phone",model.getPhone());
        intent.putExtra("experience",(model.getExperience())+" Years");
        intent.putExtra("classes",model.getClasses());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name,qualification,city;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.row_name);
            qualification=itemView.findViewById(R.id.row_qualification);
            city=itemView.findViewById(R.id.row_city);
        }
    }
}
