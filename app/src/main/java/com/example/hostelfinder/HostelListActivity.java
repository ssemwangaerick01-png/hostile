package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class HostelListActivity extends AppCompatActivity {

    // Header
    ImageButton backButton;
    ImageButton filterButton;

    // Search
    EditText hostelSearch;

    // Filters
    Button filterNearby;
    Button filterAffordable;
    Button filterTopRated;

    // Hostel cards
    MaterialCardView hostelCard1;
    MaterialCardView hostelCard2;
    MaterialCardView hostelCard3;

    // Save buttons
    ImageButton saveHostel1;
    ImageButton saveHostel2;
    ImageButton saveHostel3;

    // Details buttons
    Button viewDetails1;
    Button viewDetails2;
    Button viewDetails3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hostel_list);


        // ==========================================
        // INITIALIZE VIEWS
        // ==========================================

        backButton = findViewById(R.id.back_button);

        filterButton = findViewById(R.id.filter_button);

        hostelSearch = findViewById(R.id.hostel_search);


        filterNearby =
                findViewById(R.id.filter_nearby);

        filterAffordable =
                findViewById(R.id.filter_affordable);

        filterTopRated =
                findViewById(R.id.filter_top_rated);


        hostelCard1 =
                findViewById(R.id.hostel_card_1);

        hostelCard2 =
                findViewById(R.id.hostel_card_2);

        hostelCard3 =
                findViewById(R.id.hostel_card_3);


        saveHostel1 =
                findViewById(R.id.save_hostel_1);

        saveHostel2 =
                findViewById(R.id.save_hostel_2);

        saveHostel3 =
                findViewById(R.id.save_hostel_3);


        viewDetails1 =
                findViewById(R.id.view_details_1);

        viewDetails2 =
                findViewById(R.id.view_details_2);

        viewDetails3 =
                findViewById(R.id.view_details_3);


        // ==========================================
        // BACK BUTTON
        // ==========================================

        backButton.setOnClickListener(v -> {

            finish();

        });


        // ==========================================
        // FILTER BUTTON
        // ==========================================

        filterButton.setOnClickListener(v -> {

            Toast.makeText(
                    HostelListActivity.this,
                    "Filter options coming soon",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==========================================
        // SEARCH
        // ==========================================

        hostelSearch.setOnEditorActionListener(
                (v, actionId, event) -> {

                    String searchText =
                            hostelSearch.getText()
                                    .toString()
                                    .trim();

                    if (!searchText.isEmpty()) {

                        Toast.makeText(
                                HostelListActivity.this,
                                "Searching for: " + searchText,
                                Toast.LENGTH_SHORT
                        ).show();

                    }

                    return false;
                }
        );


        // ==========================================
        // NEARBY FILTER
        // ==========================================

        filterNearby.setOnClickListener(v -> {

            Toast.makeText(
                    HostelListActivity.this,
                    "Showing nearby hostels",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==========================================
        // AFFORDABLE FILTER
        // ==========================================

        filterAffordable.setOnClickListener(v -> {

            Toast.makeText(
                    HostelListActivity.this,
                    "Showing affordable hostels",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==========================================
        // TOP RATED FILTER
        // ==========================================

        filterTopRated.setOnClickListener(v -> {

            Toast.makeText(
                    HostelListActivity.this,
                    "Showing top rated hostels",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==========================================
        // HOSTEL CARD 1
        // ==========================================

        hostelCard1.setOnClickListener(v -> {

            openHostelDetails("Sunrise Hostel");

        });


        viewDetails1.setOnClickListener(v -> {

            openHostelDetails("Sunrise Hostel");

        });


        // ==========================================
        // HOSTEL CARD 2
        // ==========================================

        hostelCard2.setOnClickListener(v -> {

            openHostelDetails("Green View Hostel");

        });


        viewDetails2.setOnClickListener(v -> {

            openHostelDetails("Green View Hostel");

        });


        // ==========================================
        // HOSTEL CARD 3
        // ==========================================

        hostelCard3.setOnClickListener(v -> {

            openHostelDetails("Campus View Hostel");

        });


        viewDetails3.setOnClickListener(v -> {

            openHostelDetails("Campus View Hostel");

        });


        // ==========================================
        // SAVE HOSTEL 1
        // ==========================================

        saveHostel1.setOnClickListener(v -> {

            Toast.makeText(
                    HostelListActivity.this,
                    "Sunrise Hostel saved",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==========================================
        // SAVE HOSTEL 2
        // ==========================================

        saveHostel2.setOnClickListener(v -> {

            Toast.makeText(
                    HostelListActivity.this,
                    "Green View Hostel saved",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==========================================
        // SAVE HOSTEL 3
        // ==========================================

        saveHostel3.setOnClickListener(v -> {

            Toast.makeText(
                    HostelListActivity.this,
                    "Campus View Hostel saved",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }


    // ==================================================
    // OPEN HOSTEL DETAILS
    // ==================================================

    private void openHostelDetails(String hostelName) {

        Intent intent = new Intent(
                HostelListActivity.this,
                HostelDetailsActivity.class
        );

        // Send hostel name to details page
        intent.putExtra(
                "hostel_name",
                hostelName
        );

        startActivity(intent);

    }

}