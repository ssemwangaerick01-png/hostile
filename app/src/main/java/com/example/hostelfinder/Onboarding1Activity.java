package com.example.hostelfinder;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding1Activity extends AppCompatActivity {

    private Button nextBtn;
    private TextView skipBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_onboarding1);

        nextBtn = findViewById(R.id.next_btn);
        skipBtn = findViewById(R.id.skip_btn);

        nextBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Onboarding1Activity.this,
                    Onboarding2Activity.class
            );

            startActivity(intent);
            finish();
        });

        skipBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Onboarding1Activity.this,
                    WelcomeActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}
