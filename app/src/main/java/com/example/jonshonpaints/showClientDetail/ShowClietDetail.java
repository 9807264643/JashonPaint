package com.example.jonshonpaints.showClientDetail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jonshonpaints.ClientInfoActivity.ClientInfoActivities;
import com.example.jonshonpaints.MainActivity;
import com.example.jonshonpaints.R;
import com.example.jonshonpaints.adapter.ClientInfoAdapter;
import com.example.jonshonpaints.api.ApiClient;
import com.example.jonshonpaints.api.ApiInterface;
import com.example.jonshonpaints.model.ClientDetailModels;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowClietDetail extends AppCompatActivity {
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    ClientInfoAdapter clientInfoAdapter;

    List<ClientDetailModels> clientDetailModel;

    Button btn_backpress, btn_continue, btn_previous;
    String mobile, id;
    RelativeLayout rel_notRgstno, rel_regiter;
    private String phoness;
    ArrayList<String> res_mobile = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cliet_detail);
        init();
        setLayoutManager();
        mobile = getIntent().getStringExtra("mobile");
        Log.d("phone", "pp=" + mobile);
        networkCall();

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowClietDetail.this, MainActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        btn_backpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowClietDetail.this, ClientInfoActivities.class);
                startActivity(intent);

            }
        });

        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowClietDetail.this, ClientInfoActivities.class);
                startActivity(intent);

            }
        });

    }

    private void init() {
        recyclerView = findViewById(R.id.recycler_clientInfo);
        btn_continue = findViewById(R.id.btn_continue);
        btn_backpress = findViewById(R.id.btn_backpress);
        btn_previous = findViewById(R.id.btn_previous);
        rel_notRgstno = findViewById(R.id.rel_notRgstNo);
        rel_regiter = findViewById(R.id.rel_clientInfo);

    }

    private void networkCall() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<ClientDetailModels>> call = apiInterface.getClientDetail(mobile);
        call.enqueue(new Callback<List<ClientDetailModels>>() {
            @Override
            public void onResponse(Call<List<ClientDetailModels>> call, Response<List<ClientDetailModels>> response) {
                if (response.isSuccessful()) {
                    Log.d("response", "user" + response.body());
                    clientDetailModel = response.body();
                    for (int i = 0; i < clientDetailModel.size(); i++) {
                        res_mobile.add(clientDetailModel.get(i).getMOBILE());
                    }
                    for (int j = 0; j < res_mobile.size(); j++) {
                        phoness = res_mobile.get(j);
                        Log.d("phones", "p=" + phoness);

                    }
                    if (mobile.equals(phoness)) {
                        clientInfoAdapter.setClientInfoList(clientDetailModel);
                    } else {
                        rel_notRgstno.setVisibility(View.VISIBLE);
                        btn_continue.setVisibility(View.GONE);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<ClientDetailModels>> call, Throwable t) {
                Log.d("errors", "user=" + t.getMessage());

            }
        });


    }


    private void setLayoutManager() {

        layoutManager = new LinearLayoutManager(getApplicationContext());
        clientInfoAdapter = new ClientInfoAdapter(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(clientInfoAdapter);


    }


}
