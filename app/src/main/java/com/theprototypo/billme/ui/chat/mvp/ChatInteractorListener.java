package com.theprototypo.billme.ui.chat.mvp;

import com.theprototypo.billme.util.api.chat.GetChatResponseModel;
import com.theprototypo.billme.util.api.chat.PostChatResponseModel;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by walesadanto on 24/6/15.
 */
public interface ChatInteractorListener {
    public void onAPIGetChatsSuccess(GetChatResponseModel getChatResponseModel);
    public void onAPIGetChatsError(RetrofitError error);

    public void onAPIPostChatSuccess(PostChatResponseModel postChatResponseModel);
    public void onAPIPostChatError(RetrofitError error);

}
