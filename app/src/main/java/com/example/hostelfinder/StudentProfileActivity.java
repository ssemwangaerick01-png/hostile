package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class StudentProfileActivity extends AppCompatActivity {

    // Top bar
    private ImageButton backButton;

    // Profile header
    private TextView profileDisplayName;
    private TextView profileAccountType;
    private TextView profileVerification;

    // Personal information
    private EditText profileName;
    private EditText profileEmail;
    private EditText profilePhone;

    // Academic information
    private EditText profileUniversity;
    private EditText profileStudentId;
    private EditText profileCourse;

    // Location
    private EditText profileDistrict;
    private EditText profilePreferredArea;

    // Account buttons
    private Button savedHostelsButton;
    private Button bookingsButton;
    private Button messagesButton;
    private Button notificationsButton;
    private Button securityButton;

    // Other buttons
    private Button saveProfile;
    private Button logoutButton;
    private TextView deleteAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Connect Java to activity_student_profile.xml
        setContentView(R.layout.activity_student_profile);

        // Initialize all views
        initializeViews();

        // Set up button actions
        setupClickListeners();

        // Load sample/default profile data
        loadProfileData();
    }


    private void initializeViews() {

        // Back button
        backButton = findViewById(R.id.backbutton);

        // Profile header
        profileDisplayName = findViewById(R.id.profiledisplayname);
        profileAccountType = findViewById(R.id.profileaccounttype);
        profileVerification = findViewById(R.id.profileverification);

        // Personal information
        profileName = findViewById(R.id.profile_name);
        profileEmail = findViewById(R.id.profile_email);
        profilePhone = findViewById(R.id.profile_phone);

        // Academic information
        profileUniversity = findViewById(R.id.profile_university);
        profileStudentId = findViewById(R.id.profilestudentid);
        profileCourse = findViewById(R.id.profilecourse);

        // Location
        profileDistrict = findViewById(R.id.profiledistrict);
        profilePreferredArea = findViewById(R.id.profilepreferredarea);

        // Account buttons
        savedHostelsButton = findViewById(R.id.savedhostelsbutton);
        bookingsButton = findViewById(R.id.bookingsbutton);
        messagesButton = findViewById(R.id.messages_button);
        notificationsButton = findViewById(R.id.notificationsbutton);
        securityButton = findViewById(R.id.securitybutton);

        // Other buttons
        saveProfile = findViewById(R.id.save_profile);
        logoutButton = findViewById(R.id.logout_button);
        deleteAccount = findViewById(R.id.deleteaccount);
    }


    private void setupClickListeners() {

        // BACK BUTTON
        backButton.setOnClickListener(v -> {
            finish();
        });


        // SAVE PROFILE
        saveProfile.setOnClickListener(v -> {
            saveProfileData();
        });


        // SAVED HOSTELS
        savedHostelsButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentProfileActivity.this,
                    SavedHostelsActivity.class
            );

            startActivity(intent);
        });


        // BOOKINGS
        bookingsButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentProfileActivity.this,
                    MyBookingsActivity.class
            );

            startActivity(intent);
        });


        // MESSAGES
        messagesButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentProfileActivity.this,
                    MessagesActivity.class
            );

            startActivity(intent);
        });


        // NOTIFICATIONS
        notificationsButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentProfileActivity.this,
                    NotificationsActivity.class
            );

            startActivity(intent);
        });


        // PASSWORD & SECURITY
        securityButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    StudentProfileActivity.this,
                    ResetPasswordActivity.class
            );

            startActivity(intent);
        });


        // LOGOUT
        logoutButton.setOnClickListener(v -> {
            showLogoutConfirmation();
        });


        // DELETE ACCOUNT
        deleteAccount.setOnClickListener(v -> {
            showDeleteAccountConfirmation();
        });
    }


    private void loadProfileData() {

        /*
         * These are sample values.
         *
         * Later you can replace these with data
         * coming from Firebase, MySQL/API, SQLite,
         * SharedPreferences, etc.
         */

        profileDisplayName.setText("Erick Ssemwanga");

        profileAccountType.setText("Student Account");

        profileVerification.setText("✓ Verified Student");

        profileName.setText("Erick Ssemwanga");

        profileEmail.setText("erick@example.com");

        profilePhone.setText("+256 700 000 000");

        profileUniversity.setText("Sai Pali Institute");

        profileStudentId.setText("STU001");

        profileCourse.setText("Certificate in Software Development with AI");

        profileDistrict.setText("Kampala");

        profilePreferredArea.setText("Kisaasi");
    }


    private void saveProfileData() {

        // Get values from the fields
        String name = profileName.getText().toString().trim();
        String email = profileEmail.getText().toString().trim();
        String phone = profilePhone.getText().toString().trim();

        String university = profileUniversity.getText().toString().trim();
        String studentId = profileStudentId.getText().toString().trim();
        String course = profileCourse.getText().toString().trim();

        String district = profileDistrict.getText().toString().trim();
        String preferredArea =
                profilePreferredArea.getText().toString().trim();


        // Basic validation
        if (name.isEmpty()) {
            profileName.setError("Enter your full name");
            profileName.requestFocus();
            return;
        }


        if (email.isEmpty()) {
            profileEmail.setError("Enter your email address");
            profileEmail.requestFocus();
            return;
        }


        if (phone.isEmpty()) {
            profilePhone.setError("Enter your phone number");
            profilePhone.requestFocus();
            return;
        }


        // Update profile name at the top
        profileDisplayName.setText(name);


        // For now, display a success message
        Toast.makeText(
                this,
                "Profile updated successfully",
                Toast.LENGTH_SHORT
        ).show();


        /*
         * Later:
         *
         * Send these values to your database:
         *
         * name
         * email
         * phone
         * university
         * studentId
         * course
         * district
         * preferredArea
         */
    }


    private void showLogoutConfirmation() {

        new AlertDialog.Builder(this)
                .setTitle("Log Out")
                .setMessage("Are you sure you want to log out?")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Log Out", (dialog, which) -> {

                    // Clear login/session data here later

                    Intent intent = new Intent(
                            StudentProfileActivity.this,
                            LoginActivity.class
                    );

                    // Prevent user from returning to profile
                    intent.setFlags(
                            Intent.FLAG_ACTIVITY_NEW_TASK |
                                    Intent.FLAG_ACTIVITY_CLEAR_TASK
                    );

                    startActivity(intent);

                    finish();
                })
                .show();
    }


    private void showDeleteAccountConfirmation() {

        new AlertDialog.Builder(this)
                .setTitle("Delete Account")
                .setMessage(
                        "Are you sure you want to permanently delete your account? " +
                                "This action cannot be undone."
                )
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Delete", (dialog, which) -> {

                    // TODO:
                    // Delete account from your database here

                    Toast.makeText(
                            this,
                            "Account deletion requested",
                            Toast.LENGTH_LONG
                    ).show();
                })
                .show();
    }
}