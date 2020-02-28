package com.example.jonshonpaints.api;

import com.example.jonshonpaints.model.ClientDetailModels;
import com.example.jonshonpaints.model.ColorModel;
import com.example.jonshonpaints.model.CompanyName;
import com.example.jonshonpaints.model.ProductModel;
import com.example.jonshonpaints.model.UnitModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("getCategory.php")
    Call<List<CompanyName>> getCompanyName();

    @GET("getCategoryType.php")
    Call<List<ProductModel>> getProdcuts(@Query("id") String id);

    @GET("getColorList.php")
    Call<List<ColorModel>> getColorList(@Query("CategoryTypeId") String colorTypeId);

    @FormUrlEncoded
    @POST("getColorValues.php")
    Call<List<UnitModel>> getUnitColor(@Field("CategoryId") String CategoryId,
                                       @Field("CategoryTypeId") String CategoryTypeId,
                                       @Field("Colors") String Colors);


        @GET("getUser.php")
    Call<List<ClientDetailModels>> getClientDetail(@Query("mobile") String mobile);

//    @GET("getUser.php")
//    Call<ClientDetailModels> getClientDetail(@Header("mobile") String mobile);

}
