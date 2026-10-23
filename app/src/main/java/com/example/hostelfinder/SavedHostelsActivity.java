package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SavedHostelsActivity extends AppCompatActivity {

    // Header
    ImageButton backButton;

    // Search
    EditText savedSearch;

    // Hostel cards
    LinearLayout savedHostelCard1;
    LinearLayout savedHostelCard2;

    // Remove buttons
    ImageButton removeSaved1;
    ImageButton removeSaved2;

    // Hostel buttons
    Button viewSaved1;
    Button viewSaved2;

    Button bookSaved1;
    Button bookSaved2;

    // Empty state
    LinearLayout noSavedContainer;
    Button findHostelButton;

    // Bottom navigation
    Button navHome;
    Button navSaved;
    Button navBookings;
    Button navProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_saved_hostels);


        // ==========================================
        // HEADER
        // ==========================================

        backButton = findViewById(R.id.back_button);


        // ==========================================
        // SEARCH
        // ==========================================

        savedSearch = findViewById(R.id.saved_search);


        // ==========================================
        // HOSTEL CARDS
        // ==========================================

        savedHostelCard1 =
                findViewById(R.id.saved_hostel_card_1);

        savedHostelCard2 =
                findViewById(R.id.saved_hostel_card_2);


        // ==========================================
        // REMOVE BUTTONS
        // ==========================================

        removeSaved1 =
                findViewById(R.id.remove_saved_1);

        removeSaved2 =
                findViewById(R.id.remove_saved_2);


        // ==========================================
        // VIEW DETAILS
        // ==========================================

        viewSaved1 =
                findViewById(R.id.view_saved_1);

        viewSaved2 =
                findViewById(R.id.view_saved_2);


        // ==========================================
        // BOOK NOW
        // ==========================================

        bookSaved1 =
                findViewById(R.id.book_saved_1);

        bookSaved2 =
                findViewById(R.id.book_saved_2);


        // ==========================================
        // EMPTY STATE
        // ==========================================

        noSavedContainer =
                findViewById(R.id.no_saved_container);

        findHostelButton =
                findViewById(R.id.find_hostel_button);


        // ==========================================
        // BOTTOM NAVIGATION
        // ==========================================

        navHome =
                findViewById(R.id.nav_home);

        navSaved =
                findViewById(R.id.nav_saved);

        navBookings =
                findViewById(R.id.nav_bookings);

        navProfile =
                findViewById(R.id.nav_profile);


        // ==========================================
        // BACK BUTTON
        // ==========================================

        backButton.setOnClickListener(v -> {

            finish();

        });


        // ==========================================
        // REMOVE HOSTEL 1
        // ==========================================

        removeSaved1.setOnClickListener(v -> {

            savedHostelCard1.setVisibility(View.GONE);

            Toast.makeText(
                    SavedHostelsActivity.this,
                    "Sunrise Hostel removed from saved",
                    Toast.LENGTH_SHORT
            ).show();

            checkEmptyState();

        });


        // ==========================================
        // REMOVE HOSTEL 2
        // ==========================================

        removeSaved2.setOnClickListener(v -> {

            savedHostelCard2.setVisibility(View.GONE);

            Toast.makeText(
                    SavedHostelsActivity.this,
                    "Green View Hostel removed from saved",
                    Toast.LENGTH_SHORT
            ).show();

            checkEmptyState();

        });


        // ==========================================
        // VIEW HOSTEL 1
        // ==========================================

        viewSaved1.setOnClickListener(v -> {

            openHostelDetails("Sunrise Hostel");

        });


        // ==========================================
        // VIEW HOSTEL 2
        // ==========================================

        viewSaved2.setOnClickListener(v -> {

            openHostelDetails("Green View Hostel");

        });


        // ==========================================
        // BOOK HOSTEL 1
        // ==========================================

        bookSaved1.setOnClickListener(v -> {

            openBooking("Sunrise Hostel");

        });


        // ==========================================
        // BOOK HOSTEL 2
        // ==========================================

        bookSaved2.setOnClickListener(v -> {

            openBooking("Green View Hostel");

        });


        // ==========================================
        // FIND HOSTEL
        // ==========================================

        findHostelButton.setOnClickListener(v -> {

            openHostelList();

        });


        // ==========================================
        // SEARCH
        // ==========================================

        savedSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s,
                    int start,
                    int count,
                    int after) {
            }


            @Override
            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count) {

                searchHostels(s.toString());

            }


            @Override
            public void afterTextChanged(
                    Editable s) {
            }

        });


        // ==========================================
        // BOTTOM NAVIGATION
        // ==========================================

        navHome.setOnClickListener(v -> {

            openHome();

        });


        navSaved.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "You are already on Saved Hostels",
                    Toast.LENGTH_SHORT
            ).show();

        });


        navBookings.setOnClickListener(v -> {

            openBookings();

        });


        navProfile.setOnClickListener(v -> {

            openProfile();

        });

    }


    // ==================================================
    // SEARCH SAVED HOSTELS
    // ==================================================

    private void searchHostels(String searchText) {

        String search = searchText.toLowerCase().trim();


        boolean sunriseMatches =
                "Sunrise Hostel"
                        .toLowerCase()
                        .contains(search);


        boolean greenViewMatches =
                "Green View Hostel"
                        .toLowerCase()
                        .contains(search);


        if (sunriseMatches) {

            savedHostelCard1.setVisibility(View.VISIBLE);

        } else {

            savedHostelCard1.setVisibility(View.GONE);

        }


        if (greenViewMatches) {

            savedHostelCard2.setVisibility(View.VISIBLE);

        } else {

            savedHostelCard2.setVisibility(View.GONE);

        }


        checkEmptyState();

    }


    // ==================================================
    // CHECK EMPTY STATE
    // ==================================================

    private void checkEmptyState() {

        boolean card1Visible =
                savedHostelCard1.getVisibility() == View.VISIBLE;

        boolean card2Visible =
                savedHostelCard2.getVisibility() == View.VISIBLE;


        if (!card1Visible && !card2Visible) {

            noSavedContainer.setVisibility(
                    View.VISIBLE
            );

        } else {

            noSavedContainer.setVisibility(
                    View.GONE
            );

        }

    }


    // ==================================================
    // OPEN HOSTEL DETAILS
    // ==================================================

    private void openHostelDetails(String hostelName) {

        Toast.makeText(
                this,
                "Opening " + hostelName + " details...",
                Toast.LENGTH_SHORT
        ).show();


        /*
         * Replace this Toast with your actual
         * HostelDetailsActivity Intent when
         * that Activity is ready.
         */

    }


    // ==================================================
    // OPEN BOOKING
    // ==================================================

    private void openBooking(String hostelName) {

        Intent intent = new Intent(
                SavedHostelsActivity.this,
                BookingActivity.class
        );

        intent.putExtra(
                "hostel_name",
                hostelName
        );

        startActivity(intent);

    }


    // ==================================================
    // OPEN HOSTEL LIST
    // ==================================================

    private void openHostelList() {

        Intent intent = new Intent(
                SavedHostelsActivity.this,
                HostelListActivity.class
        );

        startActivity(intent);

    }


    // ==================================================
    // OPEN HOME
    // ==================================================

    private void openHome() {

        Intent intent = new Intent(
                SavedHostelsActivity.this,
                StudentDashboardActivity.class
        );

        startActivity(intent);

        finish();

    }


    // ==================================================
    // OPEN BOOKINGS
    // ==================================================

    private void openBookings() {

        Intent intent = new Intent(
                SavedHostelsActivity.this,
                MyBookingsActivity.class
        );

        startActivity(intent);

        finish();

    }


    // ==================================================
    // OPEN PROFILE
    // ==================================================

    private void openProfile() {

        Intent intent = new Intent(
                SavedHostelsActivity.this,
                StudentProfileActivity.class
        );

        startActivity(intent);

        finish();

    }

}