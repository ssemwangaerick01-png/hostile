package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OwnerNotificationsActivity extends AppCompatActivity {

    // Header
    TextView backButton;
    TextView markAllRead;
    TextView unreadCount;

    // Notifications
    LinearLayout notificationBooking;
    LinearLayout notificationPayment;
    LinearLayout notificationReview;
    LinearLayout notificationRoom;
    LinearLayout notificationListing;
    LinearLayout notificationSystem;

    // Bottom navigation
    LinearLayout navHome;
    LinearLayout navBookings;
    LinearLayout navListings;
    LinearLayout navProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_owner_notification);


        // ==============================
        // FIND XML COMPONENTS
        // ==============================

        backButton = findViewById(R.id.back_button);
        markAllRead = findViewById(R.id.mark_all_read);
        unreadCount = findViewById(R.id.unread_count);

        notificationBooking =
                findViewById(R.id.notification_booking);

        notificationPayment =
                findViewById(R.id.notification_payment);

        notificationReview =
                findViewById(R.id.notification_review);

        notificationRoom =
                findViewById(R.id.notification_room);

        notificationListing =
                findViewById(R.id.notification_listing);

        notificationSystem =
                findViewById(R.id.notification_system);


        navHome = findViewById(R.id.nav_home);
        navBookings = findViewById(R.id.nav_bookings);
        navListings = findViewById(R.id.nav_listings);
        navProfile = findViewById(R.id.nav_profile);


        // ==============================
        // BACK BUTTON
        // ==============================

        backButton.setOnClickListener(v -> {

            finish();

        });


        // ==============================
        // MARK ALL AS READ
        // ==============================

        markAllRead.setOnClickListener(v -> {

            unreadCount.setText("0");

            Toast.makeText(
                    OwnerNotificationsActivity.this,
                    "All notifications marked as read",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==============================
        // BOOKING NOTIFICATION
        // ==============================

        notificationBooking.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerNotificationsActivity.this,
                    BookingRequestsActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // PAYMENT NOTIFICATION
        // ==============================

        notificationPayment.setOnClickListener(v -> {

            Toast.makeText(
                    OwnerNotificationsActivity.this,
                    "Payment details selected",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==============================
        // REVIEW NOTIFICATION
        // ==============================

        notificationReview.setOnClickListener(v -> {

            Toast.makeText(
                    OwnerNotificationsActivity.this,
                    "Review selected",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==============================
        // ROOM NOTIFICATION
        // ==============================

        notificationRoom.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerNotificationsActivity.this,
                    ManageListingsActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // LISTING NOTIFICATION
        // ==============================

        notificationListing.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerNotificationsActivity.this,
                    ManageListingsActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // SYSTEM NOTIFICATION
        // ==============================

        notificationSystem.setOnClickListener(v -> {

            Toast.makeText(
                    OwnerNotificationsActivity.this,
                    "Hostel Finder information",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==============================
        // BOTTOM NAVIGATION
        // ==============================


        // HOME

        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerNotificationsActivity.this,
                    OwnerDashboardActivity.class
            );

            startActivity(intent);

            finish();

        });


        // BOOKINGS

        navBookings.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerNotificationsActivity.this,
                    BookingRequestsActivity.class
            );

            startActivity(intent);

        });


        // LISTINGS

        navListings.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerNotificationsActivity.this,
                    ManageListingsActivity.class
            );

            startActivity(intent);

        });


        // PROFILE

        navProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerNotificationsActivity.this,
                    OwnerProfileActivity.class
            );

            startActivity(intent);

        });

    }
}