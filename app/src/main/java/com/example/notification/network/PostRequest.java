package com.example.notification.network;

import com.example.notification.Model.Model;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PostRequest {


    @POST("send")
    @Headers({"Accept: application/json"})
    Call<JsonObject> send(@Body Model model,@Header("Authorization")String key);

}
