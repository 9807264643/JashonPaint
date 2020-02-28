package com.example.jonshonpaints.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jonshonpaints.R;
import com.example.jonshonpaints.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> implements AdapterView.OnItemSelectedListener {
    List<String> productList = new ArrayList<String>();
    List<ProductModel> productModelList;
    Context context;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_product, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        productList.add(productModelList.get(position).getCategoryType());

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(holder.sp_product.getContext(), android.R.layout.simple_spinner_item, productList);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        holder.sp_product.setAdapter(dataAdapter);

    }

    @Override
    public int getItemCount() {
        if (productModelList == null){
            return 0;
        }else {
            return productModelList.size();

        }
    }

    public void setProductList(List<ProductModel> productList){
        this.productModelList = productList;
        notifyDataSetChanged();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Spinner sp_product;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sp_product = itemView.findViewById(R.id.sp_product);

        }
    }

}
