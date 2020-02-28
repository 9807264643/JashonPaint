package com.example.jonshonpaints;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jonshonpaints.api.ApiClient;
import com.example.jonshonpaints.api.ApiInterface;
import com.example.jonshonpaints.model.ColorModel;
import com.example.jonshonpaints.model.CompanyName;
import com.example.jonshonpaints.model.ModelColors;
import com.example.jonshonpaints.model.ProductModel;
import com.example.jonshonpaints.model.UnitModel;
import com.example.jonshonpaints.model.UnitModels;
import com.example.jonshonpaints.submitActivities.SubmitActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner spinner_company, spinner_product, spinner_color;
//    AutoCompleteTextView spinner_company;
    Button btn_submit;


    List<CompanyName> companyNameList;

    List<String> companyList = new ArrayList<String>();
    List<String> companyId = new ArrayList<String>();

    List<String> productList = new ArrayList<String>();
    List<String> productId = new ArrayList<String>();

    List<String> colorList = new ArrayList<String>();
    List<String> colorId = new ArrayList<String>();


    String urlColoList = "http://philiaskincare.com/other/matching/jonshon/getColors.php?CategoryTypeId=";
    StringRequest stringRequest;

    String urlUnitList = "http://philiaskincare.com/other/matching/jonshon/getColorValues.php?CategoryId=";
    String CategoryTypeId = "CategoryTypeId=";
    String Colors = "Colors=";
    StringRequest stringRequestUnit;

    List<ProductModel> productModelList;

    RelativeLayout relCompany, relProduct;
    private String cpnyId;
    private String proId;
    private String clrId;


    // for volley
    ArrayList<ModelColors> colorModel = new ArrayList<>();
    List<ColorModel> colorModels;


    ArrayList<UnitModels> unitModels = new ArrayList<UnitModels>();

    JSONArray jsonArray;

    String cnames, pnames, colornames, units, qtys, prices, mobiles;
    //    private ArrayAdapter<String> productAdapter;
    private ArrayAdapter<String> companyAdapter;
    private ArrayAdapter<String> productAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCompanyList();
        init();

    }

    private void init() {
        spinner_company = findViewById(R.id.sp_company);
        spinner_company.setOnItemSelectedListener(this);
        spinner_product = findViewById(R.id.sp_product);
        spinner_product.setOnItemSelectedListener(this);

        btn_submit = findViewById(R.id.btn_addProduct);
        relCompany = findViewById(R.id.rel_company);
        relProduct = findViewById(R.id.rel_product);
        spinner_color = findViewById(R.id.sp_color);

        spinner_company.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cnames = adapterView.getItemAtPosition(i).toString();
                Log.d("cnames", "c=" + cnames);
                cpnyId = companyId.get(i);
                Log.v("Id", cpnyId);
                getProductData();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        spinner_product.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                try {
                    proId = productId.get(i);
                    Log.d("proId", "p=" + proId);

//                    getColorData();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Log.d("clrId", " clrUnit==" + clrId);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SubmitActivity.class));
            }
        });


    }

    private void getCompanyList() {

//        companyList.add("Select Company");
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<CompanyName>> call = apiInterface.getCompanyName();
        call.enqueue(new Callback<List<CompanyName>>() {
            @Override
            public void onResponse(Call<List<CompanyName>> call, retrofit2.Response<List<CompanyName>> response) {
                Log.d("response", "res=" + response.body());
                if (response.isSuccessful()) {
                    companyNameList = response.body();
                    for (int i = 0; i < companyNameList.size(); i++) {
                        companyList.add(companyNameList.get(i).getCategoryName());
                        companyId.add(companyNameList.get(i).getId());
                        Log.d("cid", "id=" + companyId);

                    }

                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, companyList);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_company.setAdapter(dataAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<CompanyName>> call, Throwable t) {
                Log.d("error", "er=" + t.getMessage());

            }
        });


    }

    private void getProductData() {
        productList.clear();
        productId.clear();
//        productList.add("Select Product");
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<ProductModel>> listCall = apiInterface.getProdcuts(cpnyId);
        listCall.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, retrofit2.Response<List<ProductModel>> response) {
                Log.d("response", "pro=" + response.body());
                if (response.isSuccessful()) {
                    productModelList = response.body();
                    try {

                        for (int i = 0; i < productModelList.size(); i++) {

                            productList.add(productModelList.get(i).getCategoryType());
                            productId.add(productModelList.get(i).getId());
                        }

                        Log.d("product", "prodId=" + productId);

                        productAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, productList);
                        productAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_product.setAdapter(productAdapter);

                    } catch (Exception e) {
                        e.printStackTrace();

                    }


                }

            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Log.d("error", "er=" + t.getMessage());


            }
        });

    }

//    private void getColorData() {
//
//
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<List<ColorModel>> call = apiInterface.getColorList(proId);
//        call.enqueue(new Callback<List<ColorModel>>() {
//            @Override
//            public void onResponse(Call<List<ColorModel>> call, retrofit2.Response<List<ColorModel>> response) {
//                if (response.isSuccessful()){
//                    Log.d("response","color="+response.body());
//
//                    colorModels = response.body();
//                    for (int i = 0; i < colorModels.size(); i++){
//                        colorList.add(colorModels.get(i).getName());
//                        colorId.add(colorModels.get(i).getId());
//
//                    }
//
//                    ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, colorList);
//                    colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spinner_product.setAdapter(colorAdapter);
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<ColorModel>> call, Throwable t) {
//                Log.d("color_error","err="+t.getMessage());
//
//            }
//        });
//
//
//    }

    private void getColorData() {
        colorList.clear();

        String url = urlColoList + proId;

        stringRequest = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            private String subColorId;
            private String subColorTitle;

            @Override
            public void onResponse(String response) {

                try {
//                    JSONObject obj = new JSONObject(response);
                    jsonArray = new JSONArray(response);
                    Log.v(" Response_color", response.toString());

                    for (int i = 0; i < jsonArray.length(); i++) {

                        ModelColors modelColors = new ModelColors();
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        subColorId = jsonObject.getString("Id");
                        subColorTitle = jsonObject.getString("Name");

                        modelColors.setId(subColorId);
                        modelColors.setTitle(subColorTitle);
                        colorModel.add(modelColors);

                        for (int j = 0; j < colorModel.size(); j++) {

                            colorList.add(colorModel.get(j).getTitle());
                            colorId.add(colorModel.get(j).getId());

                            Log.d("colorList", "c=" + colorList);
                            Log.d("colorId", "c=" + colorId);

                        }

                    }

                    ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, colorList);
                    colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_product.setAdapter(colorAdapter);
//                    colorAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    Log.d("Exception :", "error=" + e.getMessage());

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("verror", "v=" + error.getMessage());

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

//    private void setLayoutManagerColor() {
//
//        layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
//        myAdapterColor = new MyAdapterColor(this, colorModels);
//        recyclerView_color.setLayoutManager(layoutManager);
//        recyclerView_color.setAdapter(myAdapterColor);
//
//    }


//    private void setLayoutManagerUnit() {
//
//        linearLayoutManagerUnit = new LinearLayoutManager(getApplicationContext());
//        unitAdapter = new UnitAdapter(getApplicationContext());
//        recyclerView_unit.setLayoutManager(linearLayoutManagerUnit);
//        recyclerView_unit.setAdapter(unitAdapter);
//
//    }


    private void getUnitByProductColor() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<UnitModel>> call = apiInterface.getUnitColor(cpnyId, proId, clrId);
        call.enqueue(new Callback<List<UnitModel>>() {
            @Override
            public void onResponse(Call<List<UnitModel>> call, retrofit2.Response<List<UnitModel>> response) {
                Log.d("response", "unit=" + response.body());
                if (response.isSuccessful()) {
                }

            }

            @Override
            public void onFailure(Call<List<UnitModel>> call, Throwable t) {
                Log.d("error", "er=" + t.getMessage());

            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.sp_company:

                companyAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, companyList);
                companyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_company.setAdapter(companyAdapter);

                break;
//
//            case R.id.sp_product:
//
//                productAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, productList);
//                productAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                spinner_product.setAdapter(productAdapter);
//
//                break;
            default:
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        switch (view.getId()) {

            case R.id.sp_company:

                companyAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, companyList);
                companyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_company.setAdapter(companyAdapter);

                break;

            case R.id.sp_product:

                productAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, productList);
                productAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_product.setAdapter(productAdapter);

            case R.id.sp_color:

                ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, colorList);
                colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_product.setAdapter(colorAdapter);

                break;
            default:
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


//    public void getUnitByProductColor() {
//
//        String cpny = urlUnitList + cpnyId;
//        String pro = CategoryTypeId + proId;
//        String clor = Colors + clrId;
//        String urls = cpny+pro+clor;
//
//        stringRequestUnit = new StringRequest(Request.Method.GET, urls, new com.android.volley.Response.Listener<String>() {
//            private String subUnitTitle;
//            private String subUnitId;
//
//            private String CategoryTypeId;
//            private String color;
//            private String price;
//            private String CategoryId;
//
//
//            @Override
//            public void onResponse(String response) {
//
//                try {
////                    JSONObject obj = new JSONObject(response);
//                    JSONArray jsonArray = new JSONArray(response);
//                    Log.v(" Response", response.toString());
//
//                    for (int i = 0; i <jsonArray.length(); i++) {
//
//                        UnitModels modelColors = new UnitModels();
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        subUnitTitle = jsonObject.getString("Units");
//                        subUnitId = jsonObject.getString("Id");
//
////                        CategoryTypeId = jsonObject.getString("CategoryTypeId");
////                        CategoryId = jsonObject.getString("CategoryId");
////                        color = jsonObject.getString("Colors");
////                        price = jsonObject.getString("Price");
//
//                        modelColors.setId(subUnitId);
//                        modelColors.setUnits(subUnitTitle);
//
//                        unitModels.add(modelColors);
//
//                    }
//                    myAdapterColor.notifyDataSetChanged();
//
//                } catch (JSONException e) {
//                    Log.d("Exception is :" ,"error="+ e.getMessage());
//
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequestUnit);
//
//
//    }


}
