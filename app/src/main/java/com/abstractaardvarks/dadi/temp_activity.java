package com.abstractaardvarks.dadi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class temp_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_activity);

        InitVals();
    }

    private void InitVals() {
        TextView Fname = (TextView) findViewById(R.id.userFName);
        TextView Lname = (TextView) findViewById(R.id.userLName);

        Fname.setText(CurrentUser.getInstance().getfName());
        Lname.setText(CurrentUser.getInstance().getlName());
    }
}
