package com.theprototypo.billme.ui.chat.mvp;

import com.theprototypo.billme.ui.chat.mvp.message.Message;

import java.util.List;

/**
 * Created by walesadanto on 24/6/15.
 */
public interface ChatPresenter {

    public void typing();
    public void stopTyping();
    public void typingTimeout();

    public void setMode(ChatView.sendButtonState state);

    public void sendMessage(String userId, String text, ChatView.sendButtonState state);
    public void loadChat(String userId);
    public void scrollToBottom();
    public void incomingMessage();

}