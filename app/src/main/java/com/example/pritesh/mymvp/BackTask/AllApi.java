package com.example.pritesh.mymvp.BackTask;



import com.example.pritesh.mymvp.Model.AquLoginPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by pritesh on 3/27/2017.
 */

public interface AllApi {


    @FormUrlEncoded
    @POST("/php/Aquanomics_Login.php")
    Call<AquLoginPojo> getLogin(@Field("Email") String email, @Field("password") String pass);



}
