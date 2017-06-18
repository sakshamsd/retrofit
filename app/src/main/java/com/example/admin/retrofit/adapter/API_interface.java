package com.example.admin.retrofit.adapter;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Admin on 5/21/2017.
 */

public interface API_interface {

    @GET("select.php")
    Call<List<datalist>> getList();

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseBody>insertInfo(@Field("name")String name,
                                 @Field("address")String address,
                                 @Field("email")String email,
                                 @Field("mobile")String mobile);


}
