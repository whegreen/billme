package com.theprototypo.billme.ui.chat.mvp;

import com.theprototypo.billme.util.api.APICallManager;
import com.theprototypo.billme.util.api.chat.GetChatResponseModel;
import com.theprototypo.billme.util.api.chat.PostChatResponseModel;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by walesadanto on 24/6/15.
 */
public class ChatInteractorImpl implements ChatInteractor{
    @Override
    public void login() {

    }

    @Override
    public void typingMessage() {

    }

    @Override
    public void clickSend(String userId, String text, final ChatInteractorListener listener) {
        APICallManager.getInstance().postChat(userId, text, new Callback<PostChatResponseModel>() {
            @Override
            public void success(PostChatResponseModel postChatResponseModel, Response response) {
                listener.onAPIPostChatSuccess(postChatResponseModel);
            }
            @Override
            public void failure(RetrofitError error) {
                listener.onAPIPostChatError(error);
            }
        });
    }

    @Override
    public void updateBalance() {

    }

    @Override
    public void refreshChat(String friendUserId, final ChatInteractorListener listener) {
        APICallManager.getInstance().getChat(friendUserId, new Callback<GetChatResponseModel>() {
            @Override
            public void success(GetChatResponseModel getChatResponseModel, Response response) {
                listener.onAPIGetChatsSuccess(getChatResponseModel);
            }
            @Override
            public void failure(RetrofitError error) {
                listener.onAPIGetChatsError(error);
            }
        });
    }
}
