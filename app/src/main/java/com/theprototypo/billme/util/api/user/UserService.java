package com.theprototypo.billme.util.api.user;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by walesadanto on 15/7/15.
 */
public interface UserService {

    @GET("/users")
    void getUsers(@Header("authentification") String authentification,
                  Callback<JsonArray> callback);

    @FormUrlEncoded
    @POST("/users/login/facebook")
    void loginFacebook(@Field("facebook_id") String facebookId,
                       Callback<JsonObject> callback);

}
