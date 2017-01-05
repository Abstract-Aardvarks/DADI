package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class InviteFriends extends AppCompatActivity {

    Button EventButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

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
