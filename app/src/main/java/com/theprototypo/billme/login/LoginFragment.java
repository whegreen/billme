package com.theprototypo.billme.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.theprototypo.billme.R;
import com.theprototypo.billme.main.ui.MainActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment implements LoginView {

    private LoginButton loginButton;
    private View view;
    private LoginPresenter presenter;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_login, container, false);
        presenter = new LoginPresenterImpl(this);

        if (AccessToken.getCurrentAccessToken() != null){
            ((LoginPresenterImpl)presenter).loginSuccess();
            return view;
        }

        loginButton = (LoginButton) view.findViewById(R.id.login_button);

        loginButton.setReadPermissions("user_friends");
        // If using in a fragment
        loginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback(((LoginActivity) getActivity()).getCallbackManager(), new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                ((LoginPresenterImpl) presenter).loginSuccess();
            }

            @Override
            public void onCancel() {
                // App code
                ((LoginPresenterImpl) presenter).loginCancel();
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                ((LoginPresenterImpl) presenter).loginError();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ((LoginActivity)getActivity()).getCallbackManager().onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void openMainActivity() {
        final Intent mainIntent = new Intent(getActivity(), MainActivity.class);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(mainIntent);
            }
        }, 100L);
    }

    @Override
    public void showCancelDialog() {

    }

    @Override
    public void hideCancelDialog() {

    }

    @Override
    public void showErrorDialog() {

    }

    @Override
    public void hideErrorDialog() {

    }

}
