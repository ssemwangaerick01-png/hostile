package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class HostelDetailsActivity extends AppCompatActivity {

    // ==========================================
    // UI COMPONENTS
    // ==========================================

    private ImageView detailImage;

    private MaterialCardView backButtonCard;

    private TextView detailName;
    private TextView detailLocation;
    private TextView detailDescription;
    private TextView detailPrice;

    private Button bookButton;


    // ==========================================
    // DEFAULT HOSTEL INFORMATION
    // ==========================================

    private String hostelName = "Green View Hostel";
    private String hostelLocation =
            "Kikoni, Kampala • 5 mins walk to Campus";

    private String hostelDescription =
            "Stay in a premium environment designed for students. " +
                    "This room includes modern furnishings, a dedicated study " +
                    "area, and optimized lighting.";

    private String hostelPrice = "UGX 1,500,000";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Connect Activity to XML
        setContentView(R.layout.activity_hostel_details);

        // Initialize views
        initializeViews();

        // Load hostel information
        loadHostelDetails();

        // Setup click actions
        setupClickListeners();
    }


    // ==========================================
    // INITIALIZE VIEWS
    // ==========================================

    private void initializeViews() {

        detailImage = findViewById(R.id.detailImage);

        backButtonCard = findViewById(R.id.backButtonCard);

        detailName = findViewById(R.id.detailName);

        detailLocation = findViewById(R.id.detailLocation);

        detailDescription =
                findViewById(R.id.detailDescription);

        detailPrice =
                findViewById(R.id.detailPrice);

        bookButton =
                findViewById(R.id.bookButton);
    }


    // ==========================================
    // LOAD HOSTEL DETAILS
    // ==========================================

    private void loadHostelDetails() {

        /*
         * Check whether hostel information was
         * passed from another Activity.
         */

        Intent intent = getIntent();

        if (intent != null) {

            String receivedName =
                    intent.getStringExtra("hostel_name");

            String receivedLocation =
                    intent.getStringExtra("hostel_location");

            String receivedDescription =
                    intent.getStringExtra("hostel_description");

            String receivedPrice =
                    intent.getStringExtra("hostel_price");


            // Use received data if available

            if (receivedName != null &&
                    !receivedName.isEmpty()) {

                hostelName = receivedName;
            }


            if (receivedLocation != null &&
                    !receivedLocation.isEmpty()) {

                hostelLocation = receivedLocation;
            }


            if (receivedDescription != null &&
                    !receivedDescription.isEmpty()) {

                hostelDescription = receivedDescription;
            }


            if (receivedPrice != null &&
                    !receivedPrice.isEmpty()) {

                hostelPrice = receivedPrice;
            }
        }


        // Display information

        detailName.setText(hostelName);

        detailLocation.setText(hostelLocation);

        detailDescription.setText(hostelDescription);

        detailPrice.setText(hostelPrice);


        // Default image

        detailImage.setImageResource(
                R.drawable.room1
        );
    }


    // ==========================================
    // CLICK LISTENERS
    // ==========================================

    private void setupClickListeners() {

        // ======================================
        // BACK BUTTON
        // ======================================

        backButtonCard.setOnClickListener(v -> {

            finish();
        });


        // ======================================
        // BOOK NOW
        // ======================================

        bookButton.setOnClickListener(v -> {

            openBookingPage();
        });
    }


    // ==========================================
    // OPEN BOOKING PAGE
    // ==========================================

    private void openBookingPage() {

        /*
         * Make sure BookingActivity exists before
         * using this code.
         */

        Intent intent = new Intent(
                HostelDetailsActivity.this,
                BookingActivity.class
        );


        // Send hostel information to booking page

        intent.putExtra(
                "hostel_name",
                hostelName
        );

        intent.putExtra(
                "hostel_location",
                hostelLocation
        );

        intent.putExtra(
                "hostel_price",
                hostelPrice
        );


        startActivity(intent);
    }
}

