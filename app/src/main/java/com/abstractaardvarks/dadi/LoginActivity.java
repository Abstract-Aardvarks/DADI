package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private Intent userAuthorized;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private CognitoCredentialsProvider credentialsProvider;
    private CurrentUser cUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);

        initializeGlobals();
    }

    public void initializeGlobals()
    {
        Intent incomingIntent = getIntent();
        if(incomingIntent.getExtras() != null) {
            if (incomingIntent.getExtras().getBoolean("LOGOUT_OF_APPLICATION")) {
                LoginManager.getInstance().logOut();
            }
        }
        cUser = CurrentUser.getInstance();
        userAuthorized = new Intent(this, temp_activity.class);
        callbackManager = CallbackManager.Factory.create();
        credentialsProvider = new CognitoCachingCredentialsProvider(
                this,
                (String)getText(R.string.cognito_id),
                Regions.US_EAST_1);

        loginButton = (LoginButton) findViewById(R.id.facebook_login);
        Profile profile = Profile.getCurrentProfile();
        if(profile != null)
        {
            setCurrentUser(profile.getFirstName(), profile.getLastName());
            startActivity(userAuthorized);
        }

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Map<String, String> logins = new HashMap<String, String>();
                logins.put("graph.facebook.com", AccessToken.getCurrentAccessToken().getToken());
                Profile profile = Profile.getCurrentProfile();
                credentialsProvider.setLogins(logins);
                cUser.credentials = credentialsProvider;
                cUser.token = AccessToken.getCurrentAccessToken().getToken();
                setCurrentUser();
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

    public void setCurrentUser()
    {
        cUser.credentials = credentialsProvider;
        cUser.token = AccessToken.getCurrentAccessToken().getToken();
        cUser.setfName("No Name");
        cUser.setlName("Provided");
    }

    public void setCurrentUser(String fName, String lName)
    {
        cUser.credentials = credentialsProvider;
        cUser.token = AccessToken.getCurrentAccessToken().getToken();
        cUser.setfName(fName);
        cUser.setlName(lName);
    }
}

