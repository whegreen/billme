package com.theprototypo.billme.util.api;

import com.google.gson.JsonArray;
import com.theprototypo.billme.util.api.balance.BalanceService;
import com.theprototypo.billme.util.api.chat.GetChatResponseModel;
import com.theprototypo.billme.util.api.chat.GetRecentChatResponseModel;
import com.theprototypo.billme.util.api.chat.PostChatResponseModel;
import com.theprototypo.billme.util.api.chat.ChatService;
import com.theprototypo.billme.util.api.chat.PutChatResponseModel;
import com.theprototypo.billme.util.api.user.GetUserResponseModel;
import com.theprototypo.billme.util.api.user.LoginResponseModel;
import com.theprototypo.billme.util.api.user.UserService;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by walesadanto on 2/7/15.
 */
public class APICallManager {

    private static APICallManager instance;
    private RestAdapter restAdapter;
    private String endPoint = "http://billme.elasticbeanstalk.com";
//    public static Boolean usingMock = true;

    private String authentification;

    /**
     * Returns singleton class instance
     */
    public static APICallManager getInstance() {
        if (instance == null) {
            synchronized (APICallManager.class) {
                if (instance == null) {
                    instance = new APICallManager();
                }
            }
        }
        return instance;
    }

    public APICallManager() {
//        OkHttpClient client = new OkHttpClient();
//        client.setReadTimeout(30, TimeUnit.SECONDS);
//        client.setConnectTimeout(30, TimeUnit.SECONDS);
//        restAdapter = new RestAdapter.Builder().setEndpoint(endPoint)
//                .setLogLevel(RestAdapter.LogLevel.FULL).setClient(new OkClient(client)).build();

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(endPoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    public String getAuthentification() {
        return authentification;
    }

    public void setAuthentification(String authentification) {
        this.authentification = authentification;
    }

    // USERS API

    public boolean getUsers(Callback<GetUserResponseModel> callback) {
        UserService userService = restAdapter.create(UserService.class);
        userService.getUsers(getAuthentification(), callback);
        return true;
    }

    public boolean loginFacebook(String facebookId, String firstName, String lastName,
                                 String email, Callback<LoginResponseModel> callback) {
        UserService userService = restAdapter.create(UserService.class);
        userService.loginFacebook(facebookId, firstName, lastName, email, callback);
        return true;
    }

    // CHATS API

    public boolean getRecentChatList(Callback<GetRecentChatResponseModel> callback) {
        ChatService chatService = restAdapter.create(ChatService.class);
        chatService.getRecentChatList(getAuthentification(), callback);
        return true;
    }

    public boolean getChat(String friendUserId, Callback<GetChatResponseModel> callback) {
        ChatService chatService = restAdapter.create(ChatService.class);
        chatService.getChat(getAuthentification(), friendUserId, callback);
        return true;
    }

    public boolean postChat(String friendUserId, String text, Callback<PostChatResponseModel> callback) {
        ChatService chatService = restAdapter.create(ChatService.class);
        chatService.postChat(getAuthentification(), friendUserId, text, callback);
        return true;
    }

    public boolean updateTransaction(String friendUserId, String chatId, String actionStatus, Callback<PutChatResponseModel> callback) {
        ChatService chatService = restAdapter.create(ChatService.class);
        chatService.updateTransaction(getAuthentification(), friendUserId, chatId, actionStatus, callback);
        return true;
    }


    // BALANCES API

    public boolean getBalanceResume(String friendUserId, Callback<JsonArray> callback) {
        BalanceService balanceService = restAdapter.create(BalanceService.class);
        balanceService.getBalanceResume(getAuthentification(), friendUserId, callback);
        return true;
    }

    public boolean getBalanceShortURL(Callback<JsonArray> callback) {
        BalanceService balanceService = restAdapter.create(BalanceService.class);
        balanceService.getBalanceShortURL(getAuthentification(), callback);
        return true;
    }

}
