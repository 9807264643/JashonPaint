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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jonshonpaints.R;
import com.example.jonshonpaints.model.UnitModel;

import java.util.ArrayList;
import java.util.List;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.MyViewHolder> {
    List<String> units = new ArrayList<String>();
    List<String> unitId = new ArrayList<String>();
    String id_unit;

    //    List<UnitModels> unitModelList;
    List<UnitModel> unitModelList;

    Context context;

    String qty;

    public UnitAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_unit, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        units.add(unitModelList.get(position).getUnits());
        unitId.add(unitModelList.get(position).getId());

//        holder.prices.setText(unitModelList.get(position).getPrice());
//        qty = String.valueOf(holder.ed_qty.getText());


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(holder.sp_color.getContext(), android.R.layout.simple_spinner_item, units);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.sp_color.setAdapter(dataAdapter);

        holder.sp_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                id_unit = unitId.get(i);
                Log.d("id_unit", "unit=" + id_unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public int getItemCount() {

        if (unitModelList == null) {
            return 0;
        } else {
            return unitModelList.size();
        }
    }

    public void setUnit(List<UnitModel> colorModelList) {
        this.unitModelList = colorModelList;
        notifyDataSetChanged();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_color, sp_unit;
        EditText ed_qty;
        TextView prices;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sp_unit = itemView.findViewById(R.id.spinner_unit);
            ed_qty = itemView.findViewById(R.id.ed_qty);
//            prices = itemView.findViewById(R.id.txt_unitPrice);

        }
    }

}
