package com.abstractaardvarks.dadi;

import com.amazonaws.auth.CognitoCredentialsProvider;

/**
 * Created by Russell on 12/22/2016.
 */

public class CurrentUser extends DADIUser {

    private static CurrentUser cUser = null;

    public String token;
    public CognitoCredentialsProvider credentials;

    protected CurrentUser(){}

    public static synchronized CurrentUser getInstance(){
        if(null == cUser){
            cUser = new CurrentUser();
        }
        return cUser;
    }
}
