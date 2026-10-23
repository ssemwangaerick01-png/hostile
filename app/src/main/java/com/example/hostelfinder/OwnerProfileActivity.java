package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OwnerProfileActivity extends AppCompatActivity {

    // Header
    TextView backButton;

    // Profile information
    TextView businessName;
    TextView ownerFullName;
    TextView ownerPhone;
    TextView ownerEmail;
    TextView ownerLocation;

    // Account
    LinearLayout editProfile;
    LinearLayout changePassword;
    LinearLayout notifications;

    // Support
    LinearLayout helpSupport;

    // Logout
    LinearLayout logout;

    // Bottom navigation
    LinearLayout navHome;
    LinearLayout navBookings;
    LinearLayout navListings;
    LinearLayout navProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_owner_profile);


        // ==============================
        // FIND XML COMPONENTS
        // ==============================

        backButton = findViewById(R.id.back_button);

        businessName = findViewById(R.id.business_name);
        ownerFullName = findViewById(R.id.owner_full_name);
        ownerPhone = findViewById(R.id.owner_phone);
        ownerEmail = findViewById(R.id.owner_email);
        ownerLocation = findViewById(R.id.owner_location);

        editProfile = findViewById(R.id.edit_profile);
        changePassword = findViewById(R.id.change_password);
        notifications = findViewById(R.id.notifications);

        helpSupport = findViewById(R.id.help_support);

        logout = findViewById(R.id.logout);

        navHome = findViewById(R.id.nav_profile_home);
        navBookings = findViewById(R.id.nav_profile_bookings);
        navListings = findViewById(R.id.nav_profile_listings);
        navProfile = findViewById(R.id.nav_profile);


        // ==============================
        // BACK BUTTON
        // ==============================

        backButton.setOnClickListener(v -> {

            finish();

        });


        // ==============================
        // EDIT PROFILE
        // ==============================

        editProfile.setOnClickListener(v -> {

            Toast.makeText(
                    OwnerProfileActivity.this,
                    "Edit Profile selected",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==============================
        // CHANGE PASSWORD
        // ==============================

     //   changePassword.setOnClickListener(v -> {

     //       Intent intent = new Intent(
    //                OwnerProfileActivity.this,
    //                ChangePasswordActivity.class
    //        );

     //       startActivity(intent);

     //   });


        // ==============================
        // NOTIFICATIONS
        // ==============================

      //  notifications.setOnClickListener(v -> {

      //      Intent intent = new Intent(
       //             OwnerProfileActivity.this,
      //              NotificationActivity.class
//);

         //   startActivity(intent);

      //  });


        // ==============================
        // HELP & SUPPORT
        // ==============================

        helpSupport.setOnClickListener(v -> {

            Toast.makeText(
                    OwnerProfileActivity.this,
                    "Help and Support",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ==============================
        // LOGOUT
        // ==============================

        logout.setOnClickListener(v -> {

            Toast.makeText(
                    OwnerProfileActivity.this,
                    "Logged out successfully",
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent = new Intent(
                    OwnerProfileActivity.this,
                    LoginActivity.class
            );

            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
            );

            startActivity(intent);

            finish();

        });


        // ==============================
        // BOTTOM NAVIGATION
        // ==============================


        // HOME

        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerProfileActivity.this,
                    OwnerDashboardActivity.class
            );

            startActivity(intent);

            finish();

        });


        // BOOKINGS

        navBookings.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerProfileActivity.this,
                    BookingRequestsActivity.class
            );

            startActivity(intent);

        });


        // LISTINGS

        navListings.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OwnerProfileActivity.this,
                    ManageListingsActivity.class
            );

            startActivity(intent);

        });


        // PROFILE

        navProfile.setOnClickListener(v -> {

            // Already on profile page

        });

    }
}