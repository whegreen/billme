package com.theprototypo.billme.util;

import com.google.gson.JsonObject;
import com.squareup.okhttp.OkHttpClient;
import com.theprototypo.billme.main.mvp.FriendService;

import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by walesadanto on 2/7/15.
 */
public class HTTPManager {

    private static HTTPManager instance;
    private RestAdapter restAdapter;
    private String endPoint = "https://s3-ap-southeast-1.amazonaws.com/whe-bucket";

    /** Returns singleton class instance */
    public static HTTPManager getInstance() {
        if (instance == null) {
            synchronized (HTTPManager.class) {
                if (instance == null) {
                    instance = new HTTPManager();
                }
            }
        }
        return instance;
    }

    public HTTPManager() {
        OkHttpClient client = new OkHttpClient();
        client.setReadTimeout(30, TimeUnit.SECONDS);
        client.setConnectTimeout(30, TimeUnit.SECONDS);
        restAdapter = new RestAdapter.Builder().setEndpoint(endPoint)
                .setLogLevel(RestAdapter.LogLevel.FULL).setClient(new OkClient(client)).build();
    }

    public boolean getFriends(Callback<JsonObject> callback) {

        FriendService friendService = restAdapter.create(FriendService.class);
        friendService.getFriends(callback);

        return true;
    }

}
