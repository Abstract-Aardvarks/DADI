package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class temp_activity extends AppCompatActivity {

    Button lobbyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_activity);

        InitVals();
    }

    private void InitVals() {
        TextView Fname = (TextView) findViewById(R.id.userFName);
        TextView Lname = (TextView) findViewById(R.id.userLName);
        lobbyButton = (Button) findViewById(R.id.LobbyButton);

        Fname.setText(CurrentUser.getInstance().getfName());
        Lname.setText(CurrentUser.getInstance().getlName());
        lobbyButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent moveToLobby = new Intent(getApplicationContext(), LobbyActivity.class);
                startActivity(moveToLobby);
            }
        });
    }
}
