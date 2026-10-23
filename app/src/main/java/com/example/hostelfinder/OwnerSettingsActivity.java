package com.example.hostelfinder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OwnerSettingsActivity extends AppCompatActivity {

    Button profileBtn;
    Button passwordBtn;
    Button notificationsBtn;
    Button languageBtn;
    Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_settings);

        profileBtn = findViewById(R.id.profile_btn);
        passwordBtn = findViewById(R.id.password_btn);
        notificationsBtn = findViewById(R.id.notifications_btn);
        languageBtn = findViewById(R.id.language_btn);
        logoutBtn = findViewById(R.id.logout_btn);

        profileBtn.setOnClickListener(v ->
                Toast.makeText(this,
                        "Profile Information",
                        Toast.LENGTH_SHORT).show());

        passwordBtn.setOnClickListener(v ->
                Toast.makeText(this,
                        "Change Password",
                        Toast.LENGTH_SHORT).show());

        notificationsBtn.setOnClickListener(v ->
                Toast.makeText(this,
                        "Notifications Settings",
                        Toast.LENGTH_SHORT).show());

        languageBtn.setOnClickListener(v ->
                Toast.makeText(this,
                        "Language Settings",
                        Toast.LENGTH_SHORT).show());

        logoutBtn.setOnClickListener(v -> {
            Toast.makeText(this,
                    "Logged out",
                    Toast.LENGTH_SHORT).show();

            finish();
        });
    }
}