package com.example.womenentrepreneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class SignUp3 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ChipGroup chipGroup;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);

        radioGroup = findViewById(R.id.radio_group);
        chipGroup = findViewById(R.id.chip_group);
        continueButton = findViewById(R.id.login_button);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect selected radio button data
                int radioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(radioButtonId);
                String radioButtonText = selectedRadioButton.getText().toString();

                // Collect selected chip data
                StringBuilder chipSelections = new StringBuilder();
                for (int i = 0; i < chipGroup.getChildCount(); i++) {
                    Chip chip = (Chip) chipGroup.getChildAt(i);
                    if (chip.isChecked()) {
                        chipSelections.append(chip.getText()).append(", ");
                    }
                }

                // Create an intent to start SignUp4 activity
                Intent intent = new Intent(getApplicationContext(), SignUp4.class);

                // Pass previous and current data to the next activity using intent extras
                intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
                intent.putExtra("PASSWORD", getIntent().getStringExtra("PASSWORD"));
                intent.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
                intent.putExtra("FIRST_NAME", getIntent().getStringExtra("FIRST_NAME"));
                intent.putExtra("LAST_NAME", getIntent().getStringExtra("LAST_NAME"));
                intent.putExtra("PHONE", getIntent().getStringExtra("PHONE"));
                intent.putExtra("COUNTRY", getIntent().getStringExtra("COUNTRY"));
                intent.putExtra("JOB_TITLE", getIntent().getStringExtra("JOB_TITLE"));
                intent.putExtra("AGE", getIntent().getStringExtra("AGE"));
                intent.putExtra("BIO", getIntent().getStringExtra("BIO"));
                intent.putExtra("PROFESSION", radioButtonText);
                intent.putExtra("INTEREST_SECTORS", chipSelections.toString());


                // Start the activity
                startActivity(intent);
            }
        });
    }
    }
