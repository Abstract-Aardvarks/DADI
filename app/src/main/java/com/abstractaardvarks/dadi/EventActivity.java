package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EventActivity extends AppCompatActivity {

    Button LobbyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

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
