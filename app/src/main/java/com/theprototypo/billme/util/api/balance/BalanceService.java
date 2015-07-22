package com.theprototypo.billme.util.api.balance;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
public interface BalanceService {

    @GET("/balances/{friend_user_id}")
    void getBalanceResume(@Header("authentification") String authentification,
                          @Path("friend_user_id") String friendUserId,
                          Callback<JsonArray> callback);

    @GET("/balances/share")
    void getBalanceShortURL(@Header("authentification") String authentification,
                          Callback<JsonArray> callback);

}
