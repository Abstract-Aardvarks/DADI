package com.abstractaardvarks.dadi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class LobbyActivity extends AppCompatActivity {

    Button NewEventButton;
    String[] mobileArray = {"one", "two", "Tie my shoe"};
    ArrayList<Event> recentEvents = new ArrayList<Event>();
    EventAdapter evAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.action_home);
        item.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                Intent logoutIntent = new Intent(getApplicationContext(), LoginActivity.class);

                logoutIntent.putExtra("LOGOUT_OF_APPLICATION", true);

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
                startActivity(new Intent(getApplicationContext(), LobbyActivity.class));
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
        setContentView(R.layout.activity_lobby);


        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        //ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_events, mobileArray);
        Event testEvent = new Event();
        testEvent.setDateCreated("01022015");
        testEvent.setTopic("Party at TGI Fridays!");
        testEvent.setCategory("Food");
        testEvent.setLatitude(10);
        testEvent.setLongitude(10);
        recentEvents.add(testEvent);
        recentEvents.add(testEvent);
        recentEvents.add(testEvent);
        recentEvents.add(testEvent);
        recentEvents.add(testEvent);
        recentEvents.add(testEvent);
        recentEvents.add(testEvent);

        evAdapter = new EventAdapter(getApplicationContext(),R.layout.list_events, recentEvents);

        ListView listView = (ListView) findViewById(R.id.RecentEventList);
        listView.setAdapter(evAdapter);

        initVals();
    }

    public void initVals() {
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
