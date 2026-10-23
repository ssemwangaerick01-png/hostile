package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OwnerDashboardActivity extends AppCompatActivity {

    // Bottom navigation
    LinearLayout navHome;
    LinearLayout navBookings;
    LinearLayout navListings;
    LinearLayout navProfile;

    // Quick actions
    LinearLayout addHostelAction;
    LinearLayout bookingAction;
    LinearLayout occupancyAction;

    // Statistics
    LinearLayout tenantsCard;
    LinearLayout listingsCard;
    LinearLayout revenueCard;
    LinearLayout viewsCard;

    // Other buttons
    LinearLayout profileIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ownerhome);


        // ==========================
        // FIND VIEWS
        // ==========================

        navHome = findViewById(R.id.nav_home);
        navBookings = findViewById(R.id.nav_bookings);
        navListings = findViewById(R.id.nav_listings);
        navProfile = findViewById(R.id.nav_profile);

        addHostelAction = findViewById(R.id.add_hostel_action);
        bookingAction = findViewById(R.id.booking_action);
        occupancyAction = findViewById(R.id.occupancy_action);

        tenantsCard = findViewById(R.id.tenants_card);
        listingsCard = findViewById(R.id.listings_card);
        revenueCard = findViewById(R.id.revenue_card);
        viewsCard = findViewById(R.id.views_card);


        // ==========================
        // BOTTOM NAVIGATION
        // ==========================


        // HOME

        navHome.setOnClickListener(v -> {

            Toast.makeText(
                    OwnerDashboardActivity.this,
                    "Home",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // BOOKINGS

        navBookings.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerDashboardActivity.this,
                    BookingRequestsActivity.class
            );

            startActivity(intent);

        });


        // LISTINGS

        navListings.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerDashboardActivity.this,
                    ManageListingsActivity.class
            );

            startActivity(intent);

        });


        // PROFILE

        navProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerDashboardActivity.this,
                    OwnerProfileActivity.class
            );

            startActivity(intent);

        });
        // ADD HOSTEL

        addHostelAction.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerDashboardActivity.this,
                    AddHostelActivity.class
            );

            startActivity(intent);

        });


        // BOOKING REQUESTS

        bookingAction.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerDashboardActivity.this,
                    BookingRequestsActivity.class
            );

            startActivity(intent);

        });


        // OCCUPANCY

        occupancyAction.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerDashboardActivity.this,
                    ManageListingsActivity.class
            );

            startActivity(intent);

        });


        // ==========================
        // STATISTICS
        // ==========================


        // TOTAL TENANTS

        tenantsCard.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerDashboardActivity.this,
                    OwnerAnalyticsActivity.class
            );

            startActivity(intent);

        });


        // ACTIVE LISTINGS

        listingsCard.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerDashboardActivity.this,
                    ManageListingsActivity.class
            );

            startActivity(intent);

        });


        // TOTAL REVENUE

        revenueCard.setOnClickListener(v -> {

            Toast.makeText(
                    OwnerDashboardActivity.this,
                    "Revenue analytics",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // PROFILE VIEWS

        viewsCard.setOnClickListener(v -> {

            Toast.makeText(
                    OwnerDashboardActivity.this,
                    "Profile views",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }
}