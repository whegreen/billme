package com.theprototypo.billme.login;

/**
 * Created by walesadanto on 25/6/15.
 */
public interface LoginView {

    public void openMainActivity();

    public void showCancelDialog();
    public void hideCancelDialog();

    public void showErrorDialog();
    public void hideErrorDialog();
}
