package com.example.jonshonpaints.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jonshonpaints.MainActivity;
import com.example.jonshonpaints.R;
import com.example.jonshonpaints.model.ColorModel;
import com.example.jonshonpaints.model.ModelColors;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterColor extends RecyclerView.Adapter<MyAdapterColor.MyViewHolder> {

    ArrayList<String> colors = new ArrayList<String>();
    ArrayList<String> colorId = new ArrayList<String>();
    String id_color;

    List<ModelColors> colorModels;

    Context context;

    public MyAdapterColor(List<ModelColors> colorModels, Context context) {
        this.colorModels = colorModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_color, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (colorModels.size() != 0){

            colors.add(colorModels.get(position).getTitle());
            colorId.add(colorModels.get(position).getId());

            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(holder.sp_color.getContext(), android.R.layout.simple_spinner_item, colors);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            holder.sp_color.setAdapter(dataAdapter);

            holder.sp_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    id_color = colorId.get(i);
                    Log.d("colorid","clr="+id_color);

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }




    }

    @Override
    public int getItemCount() {
        if (colorModels == null){

            return 0;
        }else {
            return colorModels.size();
        }
    }

//    public void setColor(List<ModelColors> colorModelList){
//        this.colorModels = colorModelList;
//        notifyDataSetChanged();
//
//    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_color, sp_unit;
        EditText ed_qty;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sp_color = itemView.findViewById(R.id.spinner_color);

        }
    }
}
