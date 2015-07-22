package com.theprototypo.billme.ui.login.mvp;

/**
 * Created by walesadanto on 25/6/15.
 */
public interface LoginView {

    public void openMainActivity();

    public void showLoginLoading();
    public void hideLoginLoading();

    public void showCancelDialog();
    public void hideCancelDialog();

    public void showErrorDialog();
    public void hideErrorDialog();

    public void showEmailLoginForm();
    public void showEmailLoginWrongPassword();
    public void showEmailLoginWrongEmail();

}
