package com.example.sqlitepractice3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUsersActivity extends AppCompatActivity {
EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users);

        username = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);

        Button btn = findViewById(R.id.userAddButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // Values that will be inserted in to the database with string username.
                String userNameValue = username.getText().toString();
                ContentValues values = new ContentValues();
                values.put("username", userNameValue);
                // returns the application object context in order return data
                Database db = new Database(getApplicationContext());
//                Calls add user method in Database class and save data.
                db.addUser(values);
                startActivity(new Intent(AddUsersActivity.this, OutputUsersActivity.class));
            }
        });

    }

}