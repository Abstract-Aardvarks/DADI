package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InviteFriends extends AppCompatActivity {

    Button EventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);

        initVals();
    }

    public void initVals()
    {
        EventButton = (Button) findViewById(R.id.GoToEventButton);
        EventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToEvent = new Intent(getApplicationContext(), EventActivity.class);
                startActivity(moveToEvent);
            }
        });
    }
}
