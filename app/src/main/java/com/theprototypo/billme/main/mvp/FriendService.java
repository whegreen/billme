package com.theprototypo.billme.main.mvp;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;

/**
 * Created by walesadanto on 2/7/15.
 */
public interface FriendService {

    @GET("/friendlist.json")
    void getFriends(Callback<JsonObject> callback);

}
