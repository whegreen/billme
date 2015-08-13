package com.theprototypo.billme.util.api.user;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by walesadanto on 15/7/15.
 */
public interface UserService {

    @GET("/users")
    void getUsers(@Header("authentification") String authentification,
                  Callback<GetUserResponseModel> callback);

    @FormUrlEncoded
    @POST("/login/facebook")
    void loginFacebook(@Field("facebook_id") String facebookId,
                       @Field("first_name") String firstName,
                       @Field("last_name") String lastName,
                       @Field("email") String email,
                       Callback<LoginResponseModel> callback);

}
