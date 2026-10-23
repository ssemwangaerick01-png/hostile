package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyBookingsActivity extends AppCompatActivity {

    // Header
    ImageButton backButton;

    // Filter buttons
    Button upcomingButton;
    Button completedButton;
    Button cancelledButton;

    // Booking content
    LinearLayout bookingCard;
    LinearLayout noBookingsContainer;
    ScrollView bookingsScroll;

    TextView sectionTitle;

    // Booking information
    ImageView bookingImage;
    TextView bookingHostelName;
    TextView bookingLocation;
    TextView bookingId;
    TextView bookingRoom;
    TextView bookingDuration;
    TextView bookingPrice;
    TextView bookingPayment;
    TextView bookingStatus;

    // Booking buttons
    Button viewBookingButton;
    Button cancelBookingButton;

    // Empty state
    Button findHostelButton;

    // Bottom navigation
    Button navHome;
    Button navSaved;
    Button navBookings;
    Button navProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_bookings);


        // ==========================================
        // INITIALIZE HEADER
        // ==========================================

        backButton = findViewById(R.id.back_button);


        // ==========================================
        // INITIALIZE FILTER BUTTONS
        // ==========================================

        upcomingButton =
                findViewById(R.id.upcoming_button);

        completedButton =
                findViewById(R.id.completed_button);

        cancelledButton =
                findViewById(R.id.cancelled_button);


        // ==========================================
        // INITIALIZE CONTENT
        // ==========================================

        bookingCard =
                findViewById(R.id.booking_card);

        noBookingsContainer =
                findViewById(R.id.no_bookings_container);

        bookingsScroll =
                findViewById(R.id.bookings_scroll);

        sectionTitle =
                findViewById(R.id.section_title);


        // ==========================================
        // BOOKING INFORMATION
        // ==========================================

        bookingImage =
                findViewById(R.id.booking_image);

        bookingHostelName =
                findViewById(R.id.booking_hostel_name);

        bookingLocation =
                findViewById(R.id.booking_location);

        bookingId =
                findViewById(R.id.booking_id);

        bookingRoom =
                findViewById(R.id.booking_room);

        bookingDuration =
                findViewById(R.id.booking_duration);

        bookingPrice =
                findViewById(R.id.booking_price);

        bookingPayment =
                findViewById(R.id.booking_payment);

        bookingStatus =
                findViewById(R.id.booking_status);


        // ==========================================
        // BOOKING ACTION BUTTONS
        // ==========================================

        viewBookingButton =
                findViewById(R.id.view_booking_button);

        cancelBookingButton =
                findViewById(R.id.cancel_booking_button);


        // ==========================================
        // EMPTY STATE
        // ==========================================

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
        // LOAD SAMPLE BOOKING
        // ==========================================

        loadSampleBooking();


        // ==========================================
        // BACK BUTTON
        // ==========================================

        backButton.setOnClickListener(v -> {

            finish();

        });


        // ==========================================
        // UPCOMING
        // ==========================================

        upcomingButton.setOnClickListener(v -> {

            showUpcomingBookings();

        });


        // ==========================================
        // COMPLETED
        // ==========================================

        completedButton.setOnClickListener(v -> {

            showCompletedBookings();

        });


        // ==========================================
        // CANCELLED
        // ==========================================

        cancelledButton.setOnClickListener(v -> {

            showCancelledBookings();

        });


        // ==========================================
        // VIEW DETAILS
        // ==========================================

        viewBookingButton.setOnClickListener(v -> {

            Toast.makeText(
                    MyBookingsActivity.this,
                    "Opening booking details...",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==========================================
        // CANCEL BOOKING
        // ==========================================

        cancelBookingButton.setOnClickListener(v -> {

            cancelBooking();

        });


        // ==========================================
        // FIND HOSTEL
        // ==========================================

        findHostelButton.setOnClickListener(v -> {

            openHostelList();

        });


        // ==========================================
        // BOTTOM NAVIGATION
        // ==========================================

        navHome.setOnClickListener(v -> {

            openHome();

        });


        navSaved.setOnClickListener(v -> {

            openSaved();

        });


        navBookings.setOnClickListener(v -> {

            // Already on this page

            Toast.makeText(
                    this,
                    "You are already on My Bookings",
                    Toast.LENGTH_SHORT
            ).show();

        });


        navProfile.setOnClickListener(v -> {

            openProfile();

        });

    }


    // ==================================================
    // LOAD SAMPLE BOOKING
    // ==================================================

    private void loadSampleBooking() {

        bookingCard.setVisibility(View.VISIBLE);

        noBookingsContainer.setVisibility(View.GONE);


        bookingHostelName.setText(
                "Sunrise Hostel"
        );


        bookingLocation.setText(
                "📍 Kisaasi, Kampala"
        );


        bookingId.setText(
                "Booking ID: HF-2026-0012"
        );


        bookingRoom.setText(
                "Room: A12"
        );


        bookingDuration.setText(
                "Duration: 1 Semester"
        );


        bookingPrice.setText(
                "UGX 800,000"
        );


        bookingPayment.setText(
                "Paid via MTN Mobile Money"
        );


        bookingStatus.setText(
                "● Confirmed"
        );

    }


    // ==================================================
    // SHOW UPCOMING BOOKINGS
    // ==================================================

    private void showUpcomingBookings() {

        sectionTitle.setText(
                "Upcoming Bookings"
        );


        bookingCard.setVisibility(
                View.VISIBLE
        );

        noBookingsContainer.setVisibility(
                View.GONE
        );


        Toast.makeText(
                this,
                "Showing upcoming bookings",
                Toast.LENGTH_SHORT
        ).show();

    }


    // ==================================================
    // SHOW COMPLETED BOOKINGS
    // ==================================================

    private void showCompletedBookings() {

        sectionTitle.setText(
                "Completed Bookings"
        );


        /*
         * For now there are no completed
         * bookings in the sample data.
         */

        bookingCard.setVisibility(
                View.GONE
        );

        noBookingsContainer.setVisibility(
                View.VISIBLE
        );


        Toast.makeText(
                this,
                "No completed bookings",
                Toast.LENGTH_SHORT
        ).show();

    }


    // ==================================================
    // SHOW CANCELLED BOOKINGS
    // ==================================================

    private void showCancelledBookings() {

        sectionTitle.setText(
                "Cancelled Bookings"
        );


        /*
         * For now there are no cancelled
         * bookings in the sample data.
         */

        bookingCard.setVisibility(
                View.GONE
        );

        noBookingsContainer.setVisibility(
                View.VISIBLE
        );


        Toast.makeText(
                this,
                "No cancelled bookings",
                Toast.LENGTH_SHORT
        ).show();

    }


    // ==================================================
    // CANCEL BOOKING
    // ==================================================

    private void cancelBooking() {

        bookingCard.setVisibility(
                View.GONE
        );

        noBookingsContainer.setVisibility(
                View.VISIBLE
        );

        sectionTitle.setText(
                "Upcoming Bookings"
        );


        Toast.makeText(
                this,
                "Booking cancelled",
                Toast.LENGTH_LONG
        ).show();

    }


    // ==================================================
    // OPEN HOSTEL LIST
    // ==================================================

    private void openHostelList() {

        Intent intent = new Intent(
                MyBookingsActivity.this,
                HostelListActivity.class
        );

        startActivity(intent);

    }


    // ==================================================
    // OPEN HOME
    // ==================================================

    private void openHome() {

        Intent intent = new Intent(
                MyBookingsActivity.this,
                StudentDashboardActivity.class
        );

        startActivity(intent);

        finish();

    }


    // ==================================================
    // OPEN SAVED
    // ==================================================

    private void openSaved() {

        Intent intent = new Intent(
                MyBookingsActivity.this,
                SavedHostelsActivity.class
        );

        startActivity(intent);

    }


    // ==================================================
    // OPEN PROFILE
    // ==================================================

    private void openProfile() {

        Intent intent = new Intent(
                MyBookingsActivity.this,
                StudentProfileActivity.class
        );

        startActivity(intent);

    }

}