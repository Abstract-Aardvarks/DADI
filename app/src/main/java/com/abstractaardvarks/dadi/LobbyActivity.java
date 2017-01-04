package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LobbyActivity extends AppCompatActivity {

    Button NewEventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        initVals();
    }

    public void initVals()
    {
        NewEventButton = (Button) findViewById(R.id.NewEventButton);

        NewEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToNewEvent = new Intent(getApplicationContext(), NewEvent.class);
                startActivity(moveToNewEvent);
            }
        });

    }
}
