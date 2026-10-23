package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddHostelActivity extends AppCompatActivity {

    private EditText hostelName;
    private EditText hostelLocation;
    private EditText hostelDescription;
    private EditText hostelPrice;
    private EditText availableRooms;

    private Spinner hostelType;

    private Button nextButton;
    private Button cancelButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_hostel);

        initializeViews();
        setupButtons();
    }

    private void initializeViews() {

        hostelName =
                findViewById(R.id.hostel_name);

        hostelLocation =
                findViewById(R.id.hostel_location);

        hostelDescription =
                findViewById(R.id.hostel_description);

        hostelPrice =
                findViewById(R.id.hostel_price);

        availableRooms =
                findViewById(R.id.available_rooms);

        hostelType =
                findViewById(R.id.hostel_type);

        nextButton =
                findViewById(R.id.next_btn);

        cancelButton =
                findViewById(R.id.cancel_btn);

        backButton =
                findViewById(R.id.back_button);
    }

    private void setupButtons() {

        backButton.setOnClickListener(v -> {
            finish();
        });

        cancelButton.setOnClickListener(v -> {
            finish();
        });

        nextButton.setOnClickListener(v -> {

            if (validateForm()) {

                openNextStep();
            }
        });
    }

    private boolean validateForm() {

        String name =
                hostelName.getText().toString().trim();

        String location =
                hostelLocation.getText().toString().trim();

        String description =
                hostelDescription.getText().toString().trim();

        String price =
                hostelPrice.getText().toString().trim();

        String rooms =
                availableRooms.getText().toString().trim();

        if (name.isEmpty()) {

            hostelName.setError(
                    "Enter the hostel name"
            );

            hostelName.requestFocus();

            return false;
        }

        if (location.isEmpty()) {

            hostelLocation.setError(
                    "Enter the hostel location"
            );

            hostelLocation.requestFocus();

            return false;
        }

        if (description.isEmpty()) {

            hostelDescription.setError(
                    "Enter a description"
            );

            hostelDescription.requestFocus();

            return false;
        }

        if (price.isEmpty()) {

            hostelPrice.setError(
                    "Enter the price"
            );

            hostelPrice.requestFocus();

            return false;
        }

        if (rooms.isEmpty()) {

            availableRooms.setError(
                    "Enter the number of available rooms"
            );

            availableRooms.requestFocus();

            return false;
        }

        return true;
    }

    private void openNextStep() {

        String name =
                hostelName.getText().toString().trim();

        String location =
                hostelLocation.getText().toString().trim();

        String description =
                hostelDescription.getText().toString().trim();

        String price =
                hostelPrice.getText().toString().trim();

        String rooms =
                availableRooms.getText().toString().trim();

        String type =
                hostelType.getSelectedItem().toString();

        /*
         * Pass the information to Step 2.
         */

        Intent intent = new Intent(
                AddHostelActivity.this,
                AddHostelStepsActivity.class
        );

        intent.putExtra("hostel_name", name);
        intent.putExtra("hostel_location", location);
        intent.putExtra("hostel_description", description);
        intent.putExtra("hostel_price", price);
        intent.putExtra("available_rooms", rooms);
        intent.putExtra("hostel_type", type);

        startActivity(intent);
    }
}