package com.example.jonshonpaints.ClientInfoActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jonshonpaints.MainActivity;
import com.example.jonshonpaints.R;
import com.example.jonshonpaints.adapter.ClientInfoAdapter;
import com.example.jonshonpaints.api.ApiClient;
import com.example.jonshonpaints.api.ApiInterface;
import com.example.jonshonpaints.model.ClientDetailModels;
import com.example.jonshonpaints.showClientDetail.ShowClietDetail;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientInfoActivities extends AppCompatActivity {
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    ClientInfoAdapter clientInfoAdapter;

    List<ClientDetailModels> clientDetailModel;


    EditText ed_mobile;
    Button btn_arrow;
    String mobile;
    String phoness;
    private Button btn_continue;
    private LinearLayout linear_mobile;
    ArrayList<String> res_mobile = new ArrayList<String>();
    TextView txt_notRgstno;
    private int phone_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_info_activities);
        init();

        btn_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validations();

            }
        });

//        btn_continue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ClientInfoActivities.this, MainActivity.class);
//                startActivity(intent);
//
//
//            }
//        });



//        Log.d("pohnesss", "==" + phoness);


    }


    private void init() {
        ed_mobile = findViewById(R.id.ed_mobile);
        btn_arrow = findViewById(R.id.btn_arrow);
        recyclerView = findViewById(R.id.recycler_clientInfo);
        btn_continue = findViewById(R.id.btn_continue);
        linear_mobile = findViewById(R.id.lin_mobile);
        txt_notRgstno = findViewById(R.id.txt_notRgistNo);
//        btn_backpress = findViewById(R.id.btn_backpress);

    }


    private void validations() {

        mobile = ed_mobile.getText().toString();
        Log.d("pohne", "==" + mobile);


        boolean validation = true;
        mobile = ed_mobile.getText().toString();

//        if (mobile.length() != 10) {/


            if (mobile.length() < 6 || mobile.length() > 10) {
            ed_mobile.setError("The number required 10 digits !");
            ed_mobile.requestFocus();
            validation = false;
        }

        if (validation) {

            Intent intent = new Intent(ClientInfoActivities.this, ShowClietDetail.class);
            intent.putExtra("mobile",mobile);
            startActivity(intent);;

        }

    }

    private void setLayoutManager() {

        layoutManager = new LinearLayoutManager(getApplicationContext());
        clientInfoAdapter = new ClientInfoAdapter(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(clientInfoAdapter);


    }


    private void networkCall() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<ClientDetailModels>> call = apiInterface.getClientDetail(String.valueOf(phone_number));
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
//                    clientInfoAdapter.setClientInfoList(clientDetailModel);

                    if (mobile.equals(phoness)) {
                        clientInfoAdapter.setClientInfoList(clientDetailModel);
                    } else {
                        txt_notRgstno.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<ClientDetailModels>> call, Throwable t) {
                Log.d("errors", "user=" + t.getMessage());

            }
        });


    }



}
