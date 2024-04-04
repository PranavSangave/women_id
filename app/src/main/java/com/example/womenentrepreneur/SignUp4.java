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

public class SignUp4 extends AppCompatActivity {

    private EditText collegeNameInput, startYearInput, endYearInput;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);

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

                // Check if any field is empty
                if (collegeName.isEmpty() || startYear.isEmpty() || endYear.isEmpty()) {
                    Toast.makeText(SignUp4.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create an intent to start SignUp4 activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);



//                startActivity(intent);

                sendDataToServer(username, email, password, "DUMMY", phone, firstName, lastName, country, "DUMMY", jobTitle, collegeName, startYear, endYear, age, bio, "DUMMY", "DUMMY", profession, interestSectors);
            }
        });
    }

    private void sendDataToServer(String userName, String email, String password, String profileImg, String phone, String firstName, String lastName, String country, String region, String jobTitle, String schoolCollegeUniversity, String startYear, String endYear, String age, String bio, String registrationDate, String meetupRegistered, String userType, String interest) {
        // URL of the API endpoint
        Log.d("UserData", "User Name: " + userName);
        Log.d("UserData", "Email: " + email);
        Log.d("UserData", "Password: " + password);
        Log.d("UserData", "Profile Image: " + profileImg);
        Log.d("UserData", "Phone: " + phone);
        Log.d("UserData", "First Name: " + firstName);
        Log.d("UserData", "Last Name: " + lastName);
        Log.d("UserData", "Country: " + country);
        Log.d("UserData", "Region: " + region);
        Log.d("UserData", "Job Title: " + jobTitle);
        Log.d("UserData", "School/College/University: " + schoolCollegeUniversity);
        Log.d("UserData", "Start Year: " + startYear);
        Log.d("UserData", "End Year: " + endYear);
        Log.d("UserData", "Age: " + age);
        Log.d("UserData", "Bio: " + bio);
        Log.d("UserData", "Registration Date: " + registrationDate);
        Log.d("UserData", "Meetup Registered: " + meetupRegistered);
        Log.d("UserData", "User Type: " + userType);
        Log.d("UserData", "Interest: " + interest);

        String url = "https://brickzoneprop.com/WomenEM/APIS/setUser.php";

        // Create JSONObject to hold POST data
        JSONObject postData = new JSONObject();
        try {
            postData.put("user_name", userName);
            postData.put("email", email);
            postData.put("password", password);
            postData.put("profile_img", profileImg);
            postData.put("phone", phone);
            postData.put("first_name", firstName);
            postData.put("last_name", lastName);
            postData.put("country", country);
            postData.put("region", region);
            postData.put("job_title", jobTitle);
            postData.put("school_college_university", schoolCollegeUniversity);
            postData.put("start_year", Integer.parseInt(startYear)); // Assuming startYear is an integer
            postData.put("end_year", Integer.parseInt(endYear)); // Assuming endYear is an integer
            postData.put("age", Integer.parseInt(age)); // Assuming age is an integer
            postData.put("bio", bio);
            postData.put("registration_date", registrationDate);
            postData.put("meetup_registered", meetupRegistered);
            postData.put("user_type", "student");
            postData.put("interest", interest);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Request a JSON response from the provided URL
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle response from the server
                        try {
                            String message = response.getString("message");
                            Toast.makeText(SignUp4.this, "", Toast.LENGTH_SHORT).show();
                            if (message.equals("success")) {
                                // Data stored successfully
                                Toast.makeText(SignUp4.this, "Data stored successfully", Toast.LENGTH_SHORT).show();

                                // Proceed to next activity
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                // Data storage failed
                                Toast.makeText(SignUp4.this, "Failed to store data " + response, Toast.LENGTH_SHORT).show();
                                Log.e("Volley Error", "Error: " + response);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors
                        Toast.makeText(SignUp4.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Add the request to the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}

