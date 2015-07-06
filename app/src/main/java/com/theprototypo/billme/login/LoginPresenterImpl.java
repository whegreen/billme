package com.theprototypo.billme.login;

/**
 * Created by walesadanto on 23/6/15.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginListener{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl (LoginView loginView){
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();

    }

    @Override
    public void loginSuccess() {
        loginView.openMainActivity();
    }

    @Override
    public void loginCancel() {

    }

    @Override
    public void loginError() {

    }
}
