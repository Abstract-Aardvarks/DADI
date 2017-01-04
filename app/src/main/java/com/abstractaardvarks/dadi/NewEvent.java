package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NewEvent extends AppCompatActivity {

    Button InviteFriendsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        initVals();
    }

    public void initVals()
    {
        InviteFriendsButton = (Button) findViewById(R.id.InviteFriendsButton);

        InviteFriendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToInvite = new Intent(getApplicationContext(), InviteFriends.class);

                startActivity(moveToInvite);
            }
        });
    }
}
