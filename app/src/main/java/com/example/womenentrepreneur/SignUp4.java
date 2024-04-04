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
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class SignUp4 extends AppCompatActivity {

    private Button continueButton;

    private ChipGroup chipGroup;
    private List<String> selectedAreas;

    private static final String[][] subdomains = {
            // Technology
            {"Programming Languages", "Software Development", "Cloud Computing", "Cybersecurity", "Artificial Intelligence & Machine Learning", "Data Science & Analytics", "User Interface (UI) & User Experience (UX) Design", "Product Management", "Project Management", "Agile Methodology", "DevOps"},

            // Retail & E-commerce
            {"Supply Chain Management", "Inventory Management", "E-commerce Marketing", "Customer Relationship Management (CRM)", "Digital Marketing Analytics", "E-commerce Platform Management", "Online Advertising & Paid Search", "Content Marketing & Copywriting", "E-commerce Fraud Prevention", "Pricing Strategy", "Omnichannel Marketing", "Merchandising & Product Assortment"},

            // Healthcare & Wellness
            {"Medical Knowledge (tailored to specific area like Nursing, Pharmacy)", "Healthcare Administration", "Public Health & Epidemiology", "Medical Research & Development", "Health IT & Telehealth", "Healthcare Marketing & Patient Acquisition", "Regulatory Compliance (HIPAA)", "Clinical Trials Management", "Medical Billing & Coding", "Fitness & Wellness Management", "Health Coaching & Nutrition", "Healthcare Data Analysis"},

            // Professional Services
            {"Project Management", "Business Development & Sales", "Client Relationship Management", "Legal Expertise (specific to practice area)", "Accounting & Finance", "Human Resources Management", "Marketing & Communications", "Business Strategy & Consulting", "Operations Management", "Business Process Improvement", "Negotiation & Conflict Resolution", "Data Analysis & Reporting"},

            // Education & E-learning
            {"Instructional Design & Curriculum Development", "Educational Technology (EdTech)", "Online Learning Platforms (LMS)", "Learning Management Systems (LMS)", "Educational Assessment & Evaluation", "Teaching & Facilitation Skills", "Educational Content Creation", "Educational Psychology & Learning Theories", "Special Education", "Educational Leadership & Administration", "E-learning Marketing & User Acquisition"},

            // Hospitality & Tourism
            {"Hospitality Management & Operations", "Revenue Management", "Marketing & Sales for Travel & Tourism", "Customer Service & Guest Relations", "Event Planning & Management", "Hotel & Resort Operations", "Destination Marketing & Attraction Management", "Travel Technology & Digital Marketing", "Sustainable Tourism Practices", "Hospitality Law & Regulations", "Cultural Awareness & Sensitivity Training", "Budget & Financial Management"},

            // Finance & Fintech
            {"Financial Modeling & Analysis", "Investment Banking & Securities", "Venture Capital & Private Equity", "Financial Planning & Wealth Management", "Risk Management & Compliance", "Accounting & Auditing", "Fintech Solutions & Blockchain Technology", "Financial Markets & Trading", "Regulatory Compliance (FINRA, SEC)", "Data Analysis & Financial Reporting", "Mergers & Acquisitions (M&A)", "Business Valuation"},

            // Manufacturing & Production
            {"Supply Chain Management & Logistics", "Operations Management & Lean Manufacturing", "Quality Control & Quality Assurance", "Product Design & Development", "Engineering & Manufacturing Processes", "Inventory Management & Forecasting", "Production Planning & Scheduling", "Project Management & Six Sigma", "Robotics & Automation", "Data Analytics & Industrial IoT", "Maintenance & Repair"},

            // Real Estate & Construction
            {"Real Estate Development & Investment", "Property Management & Leasing", "Real Estate Law & Regulations", "Construction Project Management", "Architectural Design & Engineering", "Construction Estimating & Bidding", "Construction Safety & Regulations", "Real Estate Marketing & Sales", "Property Valuation & Appraisal", "Building Codes & Permits", "Facility Management"},

            // Social Impact & Nonprofits
            {"Fundraising & Grant Writing", "Nonprofit Management & Governance", "Program Development & Evaluation", "Social Impact Strategy & Advocacy", "Community Engagement & Outreach", "Public Policy & Advocacy", "Marketing & Communications for Nonprofits", "Volunteer Management & Recruitment", "Data Analysis & Impact Measurement", "Storytelling & Communication for Social Good", "Grant Management & Compliance"},

            // Art & Creative Industries
            {"Graphic Design & Illustration", "Animation & Motion Graphics", "Web Design & User Experience (UX) Design", "Photography & Videography", "Music Production & Audio Engineering", "Writing & Editing", "Marketing & Communications for Creative Industries", "Intellectual Property Law & Copyright", "Arts Management & Administration", "Creative Direction & Branding", "Social Media Marketing & Content Creation"},

            // Food & Beverage
            {"Food Science & Technology", "Culinary Arts & Recipe Development", "Food & Beverage Operations Management", "Restaurant Management & Franchising", "Food Safety & Sanitation"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);

        continueButton = findViewById(R.id.login_button);
        chipGroup = findViewById(R.id.chip_group_subdomains); // Move this line here

        // Retrieve selected areas from previous activity
        String csvString = getIntent().getStringExtra("INTEREST_SECTORS");
        selectedAreas = Arrays.asList(csvString.split(","));


        // Dynamically generate chips for selected areas
        for (String area : selectedAreas) {
            int index = getAreaIndex(area.trim());
            Log.d("myArr", "Ekdach Aalo bhava. Area:" + area + " Index: " + index);
            if (index != -1) {
                Log.d("myArr", "Aaat");
                for (String subdomain : subdomains[index]) {
                    Chip chip = new Chip(SignUp4.this);
                    chip.setText(subdomain);
                    chip.setCheckable(true);
                    chipGroup.addView(chip);
                }
            }
        }

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Collect selected chip data
                StringBuilder chipSelections = new StringBuilder();
                for (int i = 0; i < chipGroup.getChildCount(); i++) {
                    Chip chip = (Chip) chipGroup.getChildAt(i);
                    if (chip.isChecked()) {
                        chipSelections.append(chip.getText()).append(", ");
                    }
                }

                Log.d("subDomains", chipSelections.toString());

                // Create an intent to start SignUp4 activity
                Intent intent = new Intent(getApplicationContext(), SignUp5.class);

                // Data from Intent
                intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
                intent.putExtra("PASSWORD",  getIntent().getStringExtra("PASSWORD"));
                intent.putExtra("USERNAME",  getIntent().getStringExtra("USERNAME"));
                intent.putExtra("FIRST_NAME",  getIntent().getStringExtra("FIRST_NAME"));
                intent.putExtra("LAST_NAME",  getIntent().getStringExtra("LAST_NAME"));
                intent.putExtra("PHONE",  getIntent().getStringExtra("PHONE"));
                intent.putExtra("COUNTRY",  getIntent().getStringExtra("COUNTRY"));
                intent.putExtra("JOB_TITLE",  getIntent().getStringExtra("JOB_TITLE"));
                intent.putExtra("AGE",  getIntent().getStringExtra("AGE"));
                intent.putExtra("BIO",  getIntent().getStringExtra("BIO"));
                intent.putExtra("PROFESSION",  getIntent().getStringExtra("PROFESSION"));
                intent.putExtra("INTEREST_SECTORS",  getIntent().getStringExtra("INTEREST_SECTORS"));
                intent.putExtra("SUBDOMAINS", chipSelections.toString());

                startActivity(intent);
            }
        });
    }


    // Helper method to get the index of the selected area
    private int getAreaIndex(String area) {
        String[] areas = getResources().getStringArray(R.array.areas);
        for (int i = 0; i < areas.length; i++) {
            if (areas[i].equalsIgnoreCase(area)) {
                return i;
            }
        }
        return -1;
    }

}

