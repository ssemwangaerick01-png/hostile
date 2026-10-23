package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding2Activity extends AppCompatActivity {

    private Button nextBtn;
    private TextView skipBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_onboarding2);

        nextBtn = findViewById(R.id.next_btn);
        skipBtn = findViewById(R.id.skip_btn);

        nextBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Onboarding2Activity.this,
                    Onboarding3Activity.class
            );

            startActivity(intent);
            finish();
        });

        skipBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Onboarding2Activity.this,
                    WelcomeActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}