package com.example.womenentrepreneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SignUp2 extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText phoneEditText;
    private Spinner countrySpinner;
    private Spinner regionSpinner;
    private EditText jobTitleEditText;
    private EditText ageEditText;
    private EditText bioEditText;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        Button login_button = findViewById(R.id.login_button);

        // Initialize views
        firstNameEditText = findViewById(R.id.first_name);
        lastNameEditText = findViewById(R.id.last_name);
        phoneEditText = findViewById(R.id.phone);
        countrySpinner = findViewById(R.id.country_spinner);
//        regionSpinner = findViewById(R.id.region_spinner);
        jobTitleEditText = findViewById(R.id.job_title);
        ageEditText = findViewById(R.id.age);
        bioEditText = findViewById(R.id.bio);
        continueButton = findViewById(R.id.login_button);

        // Populate Country Spinner
        String[] countries = getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(SignUp2.this, android.R.layout.simple_spinner_item, countries);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countryAdapter);

        // Populate Region Spinner
//        String[] regions = getResources().getStringArray(R.array.regions_array);
//        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(SignUp2.this, android.R.layout.simple_spinner_item, regions);
//        regionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        regionSpinner.setAdapter(regionAdapter);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get data from input fields
                String firstName = firstNameEditText.getText().toString().trim();
                String lastName = lastNameEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String country = countrySpinner.getSelectedItem().toString();
//                String region = regionSpinner.getSelectedItem().toString();
                String jobTitle = jobTitleEditText.getText().toString().trim();
                String age = ageEditText.getText().toString().trim();
                String bio = bioEditText.getText().toString().trim();

                // Create an intent to start SignUp3 activity
                Intent intent = new Intent(getApplicationContext(), SignUp3.class);

                // Pass previous and current data to the next activity using intent extras
                intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
                intent.putExtra("PASSWORD", getIntent().getStringExtra("PASSWORD"));
                intent.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
                intent.putExtra("FIRST_NAME", firstName);
                intent.putExtra("LAST_NAME", lastName);
                intent.putExtra("PHONE", phone);
                intent.putExtra("COUNTRY", country);
                intent.putExtra("JOB_TITLE", jobTitle);
                intent.putExtra("AGE", age);
                intent.putExtra("BIO", bio);

                // Start the activity
                startActivity(intent);
            }
        });
    }
}