package com.theprototypo.billme.ui.chat.mvp;

import com.theprototypo.billme.ui.chat.mvp.message.Message;
import com.theprototypo.billme.util.api.chat.GetChatResponseModel;
import com.theprototypo.billme.util.api.chat.PostChatResponseModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit.RetrofitError;

/**
 * Created by walesadanto on 24/6/15.
 */
public class ChatPresenterImpl implements ChatPresenter, ChatInteractorListener {

    public ChatInteractorImpl interactor;
    public ChatView view;

    public ChatPresenterImpl(ChatView view){
        this.view = view;
        interactor = new ChatInteractorImpl();
    }

    @Override
    public void typing() {
        view.toggleSendButton();
    }

    @Override
    public void stopTyping() {

    }

    @Override
    public void typingTimeout() {
        view.toggleSendButton();
    }

    @Override
    public void setMode(ChatView.sendButtonState state) {
        if (state == ChatView.sendButtonState.BILL){
//            view.showNumericKeyboard();
        }else{
//            view.sendBill();
        }
    }

    @Override
    public void sendMessage(String userId, String text, ChatView.sendButtonState state) {
        if (text == null || text == ""){
            view.showBlankTextWarning();
        }else{
            if(state == ChatView.sendButtonState.MESSAGE){

            }
            else if (state == ChatView.sendButtonState.BILL){
                text = "{"+text+"}";
            }
            else{

            }
            view.disableInputField();
            interactor.clickSend(userId, text, this);
        }
    }

    @Override
    public void loadChat(String userId) {
        interactor.refreshChat(userId, this);
    }

    @Override
    public void scrollToBottom() {

    }

    @Override
    public void incomingMessage() {

    }

    @Override
    public void onAPIGetChatsSuccess(GetChatResponseModel getChatResponseModel) {
        view.showToast("loaded");

        List<Message> list = new ArrayList<>();

        Collections.sort(getChatResponseModel.getData(), new Comparator<GetChatResponseModel.GetResponseData>() {

            @Override
            public int compare(GetChatResponseModel.GetResponseData lhs, GetChatResponseModel.GetResponseData rhs) {
                return lhs.getContentId().compareTo(rhs.getContentId());
            }

        });

        for (GetChatResponseModel.GetResponseData data : getChatResponseModel.getData()){
//            data.getChatUser1();
//            data.getChatUser2();
//
//            String userName = "Me";
//            if()

            list.add(new Message.Builder(Message.TYPE_MESSAGE)
                .username("me "+data.getContentId()).message(data.getChatLastContent()).build());
        }

        view.loadChat(list);
    }

    @Override
    public void onAPIGetChatsError(RetrofitError error) {
        view.showToast("failed");
    }

    @Override
    public void onAPIPostChatSuccess(PostChatResponseModel postChatResponseModel) {
        view.enableInputField();
        view.resetInputField();
        view.showToast("post loaded");
        view.reloadChat();
    }

    @Override
    public void onAPIPostChatError(RetrofitError error) {
        view.showToast("post failed");
    }
}
