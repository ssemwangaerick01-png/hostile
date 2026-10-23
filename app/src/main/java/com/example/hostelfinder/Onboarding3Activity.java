package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding3Activity extends AppCompatActivity {

    private Button getStartedBtn;
    private TextView skipBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_onboarding3);

        getStartedBtn = findViewById(R.id.get_started_btn);
        skipBtn = findViewById(R.id.skip_btn);

        getStartedBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Onboarding3Activity.this,
                    WelcomeActivity.class
            );

            startActivity(intent);
            finish();
        });

        skipBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Onboarding3Activity.this,
                    WelcomeActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}