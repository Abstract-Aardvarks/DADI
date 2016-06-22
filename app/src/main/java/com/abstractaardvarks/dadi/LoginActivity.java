package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private Intent userAuthorized;

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private ProfileTracker profileTracker;

    private CognitoCredentialsProvider credentialsProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);

        initializeGlobals();
    }

    public void initializeGlobals()
    {
        userAuthorized = new Intent(this, temp_activity.class);
        callbackManager = CallbackManager.Factory.create();
        credentialsProvider = new CognitoCachingCredentialsProvider(
                this,
                "us-east-1:9c0a69be-0516-49a1-9cf0-d4ec2f326e71",
                Regions.US_EAST_1);
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(
                    Profile oldProfile,
                    Profile currentProfile) {
                // App code
            }
        };
        loginButton = (LoginButton) findViewById(R.id.facebook_login);
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Map<String, String> logins = new HashMap<String, String>();
                logins.put("graph.facebook.com", AccessToken.getCurrentAccessToken().getToken());
                credentialsProvider.setLogins(logins);

                startActivity(userAuthorized);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
