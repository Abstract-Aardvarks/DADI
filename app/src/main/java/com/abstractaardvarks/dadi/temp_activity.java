package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class temp_activity extends AppCompatActivity {

    Button lobbyButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                Intent logoutIntent = new Intent(getApplicationContext(), LoginActivity.class);

                logoutIntent.putExtra("LOGOUT_OF_APPLICATION",true);

                startActivity(logoutIntent);
                return true;

            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;
            case R.id.action_home:
                startActivity(new Intent(getApplicationContext(),LobbyActivity.class));
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_activity);
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

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
