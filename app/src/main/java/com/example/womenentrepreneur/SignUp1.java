package com.example.womenentrepreneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp1 extends AppCompatActivity {

    EditText email, password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);

        Button login_button = findViewById(R.id.login_button);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve data from fields
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                String userName = username.getText().toString();

                // Create an intent to start SignUp2 activity
                Intent intent = new Intent(getApplicationContext(), SignUp2.class);

                // Pass data to the next activity using intent extras
                intent.putExtra("EMAIL", userEmail);
                intent.putExtra("PASSWORD", userPassword);
                intent.putExtra("USERNAME", userName);

                // Start the activity
                startActivity(intent);
            }
        });
    }
}