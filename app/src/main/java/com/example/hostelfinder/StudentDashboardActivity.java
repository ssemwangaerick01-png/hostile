package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDashboardActivity extends AppCompatActivity {

    // Header
    ImageView profileIcon;
    ImageButton notificationButton;

    // Search
    EditText dashboardSearch;
    ImageButton searchButton;

    // Categories
    Button nearbyButton;
    Button cheapButton;
    Button topRatedButton;

    // Recommended hostel
    LinearLayout hostelCard1;
    ImageButton saveHostel1;
    Button viewDetailsButton1;

    // Nearby hostels
    LinearLayout nearbyCard1;
    LinearLayout nearbyCard2;

    // See All
    TextView seeAllRecommended;
    TextView seeAllNearby;

    // Quick actions
    Button messagesButton;
    Button reviewsButton;

    // Bottom navigation
    Button navHome;
    Button navSaved;
    Button navBookings;
    Button navProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Connect Java to XML
        setContentView(R.layout.activity_student_dashboard);


        // ==========================================
        // FIND VIEWS
        // ==========================================

        profileIcon = findViewById(R.id.profile_icon);

        notificationButton =
                findViewById(R.id.notification_button);


        dashboardSearch =
                findViewById(R.id.dashboard_search);

        searchButton =
                findViewById(R.id.search_button);


        nearbyButton =
                findViewById(R.id.nearby_button);

        cheapButton =
                findViewById(R.id.cheap_button);

        topRatedButton =
                findViewById(R.id.top_rated_button);


        hostelCard1 =
                findViewById(R.id.hostel_card_1);

        saveHostel1 =
                findViewById(R.id.save_hostel_1);

        viewDetailsButton1 =
                findViewById(R.id.view_details_button_1);


        nearbyCard1 =
                findViewById(R.id.nearby_card_1);

        nearbyCard2 =
                findViewById(R.id.nearby_card_2);


        seeAllRecommended =
                findViewById(R.id.see_all_recommended);

        seeAllNearby =
                findViewById(R.id.see_all_nearby);


        messagesButton =
                findViewById(R.id.messages_button);

        reviewsButton =
                findViewById(R.id.reviews_button);


        navHome =
                findViewById(R.id.nav_home);

        navSaved =
                findViewById(R.id.nav_saved);

        navBookings =
                findViewById(R.id.nav_bookings);

        navProfile =
                findViewById(R.id.nav_profile);


        // ==========================================
        // PROFILE
        // ==========================================

        profileIcon.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    StudentProfileActivity.class
            );

            startActivity(intent);
        });


        // ==========================================
        // NOTIFICATIONS
        // ==========================================

        notificationButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    NotificationsActivity.class
            );

            startActivity(intent);
        });


        // ==========================================
        // SEARCH BOX
        // ==========================================

        dashboardSearch.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    SearchActivity.class
            );

            startActivity(intent);
        });


        // ==========================================
        // SEARCH BUTTON
        // ==========================================

        searchButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    SearchActivity.class
            );

            startActivity(intent);
        });


        // ==========================================
        // NEARBY
        // ==========================================

        nearbyButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    HostelListActivity.class
            );

            intent.putExtra("filter", "nearby");

            startActivity(intent);
        });


        // ==========================================
        // AFFORDABLE
        // ==========================================

        cheapButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    HostelListActivity.class
            );

            intent.putExtra("filter", "affordable");

            startActivity(intent);
        });


        // ==========================================
        // TOP RATED
        // ==========================================

        topRatedButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    HostelListActivity.class
            );

            intent.putExtra("filter", "top_rated");

            startActivity(intent);
        });


        // ==========================================
        // HOSTEL CARD
        // ==========================================

        hostelCard1.setOnClickListener(v -> {

            openHostelDetails();
        });


        // ==========================================
        // VIEW DETAILS
        // ==========================================

        viewDetailsButton1.setOnClickListener(v -> {

            openHostelDetails();
        });


        // ==========================================
        // SAVE HOSTEL
        // ==========================================

        saveHostel1.setOnClickListener(v -> {

            // Temporary functionality.
            // Database saving will be added later.

            saveHostel1.setSelected(
                    !saveHostel1.isSelected()
            );
        });


        // ==========================================
        // NEARBY HOSTEL 1
        // ==========================================

        nearbyCard1.setOnClickListener(v -> {

            openHostelDetails();
        });


        // ==========================================
        // NEARBY HOSTEL 2
        // ==========================================

        nearbyCard2.setOnClickListener(v -> {

            openHostelDetails();
        });


        // ==========================================
        // SEE ALL RECOMMENDED
        // ==========================================

        seeAllRecommended.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    HostelListActivity.class
            );

            startActivity(intent);
        });


        // ==========================================
        // SEE ALL NEARBY
        // ==========================================

        seeAllNearby.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    HostelListActivity.class
            );

            intent.putExtra("filter", "nearby");

            startActivity(intent);
        });


        // ==========================================
        // MESSAGES
        // ==========================================

        messagesButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    MessagesActivity.class
            );

            startActivity(intent);
        });


        // ==========================================
        // REVIEWS
        // ==========================================

        reviewsButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    ReviewsActivity.class
            );

            startActivity(intent);
        });


        // ==========================================
        // BOTTOM NAVIGATION
        // ==========================================

        navHome.setOnClickListener(v -> {

            // Already on dashboard.
        });


        navSaved.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    SavedHostelsActivity.class
            );

            startActivity(intent);
        });


        navBookings.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    MyBookingsActivity.class
            );

            startActivity(intent);
        });


        navProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentDashboardActivity.this,
                    StudentProfileActivity.class
            );

            startActivity(intent);
        });

    }


    // ==========================================
    // OPEN HOSTEL DETAILS
    // ==========================================

    private void openHostelDetails() {

        Intent intent = new Intent(
                StudentDashboardActivity.this,
                HostelDetailsActivity.class
        );

        startActivity(intent);
    }

}