package com.theprototypo.billme.ui.login;

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
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.JsonObject;
import com.theprototypo.billme.R;
import com.theprototypo.billme.ui.login.mvp.LoginPresenter;
import com.theprototypo.billme.ui.login.mvp.LoginPresenterImpl;
import com.theprototypo.billme.ui.login.mvp.LoginView;
import com.theprototypo.billme.ui.main.MainActivity;
import com.theprototypo.billme.util.api.APICallManager;
import com.theprototypo.billme.util.api.chat.PostChatResponseModel;
import com.theprototypo.billme.util.api.user.LoginResponseModel;
import com.theprototypo.billme.util.common.PreferencesManager;

import org.json.JSONException;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

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

                final String userId = loginResult.getAccessToken().getUserId();

                /* make the API call */
                new GraphRequest(
                        AccessToken.getCurrentAccessToken(),
                        userId,
                        null,
                        HttpMethod.GET,
                        new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse response) {
                                /* handle the result */

                                String id = "", firstName = "", lastName = "", email = "";
                                try {
                                    id = response.getJSONObject().getString("id");
                                    firstName = response.getJSONObject().getString("first_name");
                                    lastName = response.getJSONObject().getString("last_name");
                                    email = response.getJSONObject().getString("email");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                new GraphRequest(
                                        AccessToken.getCurrentAccessToken(),
                                        "/"+userId+"/picture",
                                        null,
                                        HttpMethod.GET,
                                        new GraphRequest.Callback() {
                                            public void onCompleted(GraphResponse response) {
                                                        /* handle the result */
                                                response.getJSONObject();
                                            }
                                        }
                                ).executeAsync();


                                APICallManager.getInstance().loginFacebook(id,
                                    firstName, lastName, email,
                                    new Callback<LoginResponseModel>() {
                                        @Override
                                        public void success(LoginResponseModel loginResponseModel, Response response) {

                                            List list = loginResponseModel.getData();
                                            String auth = "";
                                            for (Object temp : list) {
                                                auth = ((LoginResponseModel.LoginResponseData) temp).getAuth();
                                            }
                                            APICallManager.getInstance().setAuthentification(auth);
                                            PreferencesManager.saveAuthToken(getActivity().getBaseContext(), auth);
                                            ((LoginPresenterImpl) presenter).loginSuccess();
                                        }

                                        @Override
                                        public void failure(RetrofitError error) {
                                            ((LoginPresenterImpl) presenter).loginCancel();
                                        }
                                    });

                            }

                        }
                ).executeAsync();

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
        }, 300L);

    }

    @Override
    public void showLoginLoading() {

    }

    @Override
    public void hideLoginLoading() {

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

    @Override
    public void showEmailLoginForm() {

    }

    @Override
    public void showEmailLoginWrongPassword() {

    }

    @Override
    public void showEmailLoginWrongEmail() {

    }

}
