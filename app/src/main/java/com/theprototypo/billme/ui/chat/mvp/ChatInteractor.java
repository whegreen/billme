package com.theprototypo.billme.ui.chat.mvp;

/**
 * Created by walesadanto on 24/6/15.
 */
public interface ChatInteractor {

    public void login();
    public void typingMessage();
    public void clickSend(String userId, String text, final ChatInteractorListener listener);
    public void updateBalance();
    public void refreshChat(String friendUserId, ChatInteractorListener listener);

}
