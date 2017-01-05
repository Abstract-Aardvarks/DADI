package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class EventActivity extends AppCompatActivity {

    Button LobbyButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        initVals();
    }

    public void initVals()
    {
        LobbyButton = (Button) findViewById(R.id.GoToLobbyButton);
        LobbyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToLobby = new Intent(getApplicationContext(), LobbyActivity.class);
                startActivity(moveToLobby);
            }
        });
    }
}
