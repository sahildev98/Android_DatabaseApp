package com.example.sqlitepractice3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OutputUsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_users);

        Database db = new Database(getApplicationContext());
        Cursor outputUsers = db.outputUsersData();
        outputUsers.moveToFirst();
        LinearLayout container = findViewById(R.id.layout_Contain);


        do {
            String name = outputUsers.getString(0);
            TextView resultText = new TextView(this);
            resultText.setText("Welcome " + name);
            container.addView(resultText);
        }   while (outputUsers.moveToNext());

    }


}