package com.theprototypo.billme.ui.chat.mvp;

import com.theprototypo.billme.ui.chat.mvp.message.Message;

import java.util.List;

/**
 * Created by walesadanto on 30/7/15.
 */
public interface ChatView {

    public enum sendButtonState{
        MESSAGE, BILL
    }

    public void loadChat(List<Message> list);
    public void reloadChat();
    public void closeDetailScreen();
    public void showSnackBar();
    public void showToast(String alert);
    public void showBlankTextWarning();

    public void showSendBillButton();
    public void showSendMessageButton();

    public void toggleSendButton();

    public void resetInputField();
    public void disableInputField();
    public void enableInputField();

}
