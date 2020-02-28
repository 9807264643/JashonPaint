package com.example.jonshonpaints.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jonshonpaints.ClientInfoActivity.ClientInfoActivities;
import com.example.jonshonpaints.R;
import com.example.jonshonpaints.model.ClientDetailModels;
import com.example.jonshonpaints.showClientDetail.ShowClietDetail;

import java.util.ArrayList;
import java.util.List;

public class ClientInfoAdapter extends RecyclerView.Adapter<ClientInfoAdapter.MyViewHolder> {

    List<ClientDetailModels> clientDetailModels;
    Context context;

    public ClientInfoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_clientinfo, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {


        holder.names.setText(clientDetailModels.get(position).getNAME());
        holder.address.setText(clientDetailModels.get(position).getADDRESS());
        holder.company.setText(clientDetailModels.get(position).getEMAIL());
        holder.gst.setText(clientDetailModels.get(position).getGSTNO());

    }

    @Override
    public int getItemCount() {
        if (clientDetailModels == null) {
            return 0;
        } else {
            return clientDetailModels.size();
        }
    }

    public void setClientInfoList(List<ClientDetailModels> categoryList) {
        clientDetailModels = categoryList;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView names, address, company, gst;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            names = itemView.findViewById(R.id.txt_name);
            address = itemView.findViewById(R.id.txt_address);
            company = itemView.findViewById(R.id.txt_company);
            gst = itemView.findViewById(R.id.txt_gst);


        }
    }

}
