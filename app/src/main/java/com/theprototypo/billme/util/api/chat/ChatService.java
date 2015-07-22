package com.theprototypo.billme.util.api.chat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;


/**
 * Created by walesadanto on 15/7/15.
 */
public interface ChatService {

    @GET("/chats/recent")
    void getRecentChatList(@Header("authentification") String authentification,
                           Callback<JsonArray> callback);

    @FormUrlEncoded
    @POST("/chats/{friend_user_id}")
    void postChat(@Header("authentification") String authentification,
                  @Path("friend_user_id") String friendUserId,
                  @Field("text") String text,
                  Callback<JsonObject> callback);

    @FormUrlEncoded
    @PUT("/chats/{friend_user_id}/{chat_id}")
    void updateTransaction(@Header("authentification") String authentification,
                           @Path("friend_user_id") String friendUserId,
                           @Path("chat_id") String idChat,
                           @Field("action_Status") String action_status,
                           Callback<JsonObject> callback);

    @GET("/chats/{friend_user_id}")
    void getChat(@Header("authentification") String authentification,
                 @Path("friend_user_id") String friendUserId,
                 Callback<JsonObject> callback);

}
