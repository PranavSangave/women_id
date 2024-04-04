package com.example.womenentrepreneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUp5 extends AppCompatActivity {

    private EditText collegeNameInput, startYearInput, endYearInput;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up5);

        collegeNameInput = findViewById(R.id.collegeName);
        startYearInput = findViewById(R.id.startYear);
        endYearInput = findViewById(R.id.endYear);
        continueButton = findViewById(R.id.login_button);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect data from inputs
                String collegeName = collegeNameInput.getText().toString().trim();
                String startYear = startYearInput.getText().toString().trim();
                String endYear = endYearInput.getText().toString().trim();

                // Data from INtent
                String email = getIntent().getStringExtra("EMAIL");
                String password = getIntent().getStringExtra("PASSWORD");
                String username = getIntent().getStringExtra("USERNAME");
                String firstName = getIntent().getStringExtra("FIRST_NAME");
                String lastName = getIntent().getStringExtra("LAST_NAME");
                String phone = getIntent().getStringExtra("PHONE");
                String country = getIntent().getStringExtra("COUNTRY");
                String jobTitle = getIntent().getStringExtra("JOB_TITLE");
                String age = getIntent().getStringExtra("AGE");
                String bio = getIntent().getStringExtra("BIO");
                String profession = getIntent().getStringExtra("PROFESSION");
                String interestSectors = getIntent().getStringExtra("INTEREST_SECTORS");
                String subdomains = getIntent().getStringExtra("SUBDOMAINS");

            }
        });
    }
}

