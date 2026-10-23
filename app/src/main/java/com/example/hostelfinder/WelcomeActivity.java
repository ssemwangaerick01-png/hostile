package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private Button loginBtn;
    private Button createAccountBtn;
    private TextView continueGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        loginBtn = findViewById(R.id.login_btn);
        createAccountBtn = findViewById(R.id.create_account_btn);
        continueGuest = findViewById(R.id.continue_guest);

        loginBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    WelcomeActivity.this,
                    LoginActivity.class
            );

            startActivity(intent);
        });

        createAccountBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    WelcomeActivity.this,
                    ChooseAccountActivity.class
            );

            startActivity(intent);
        });

        continueGuest.setOnClickListener(v -> {

            // Replace this with your HomeActivity later
            Intent intent = new Intent(
                    WelcomeActivity.this,
                    StudentDashboardActivity.class
            );

            startActivity(intent);
        });
    }
}