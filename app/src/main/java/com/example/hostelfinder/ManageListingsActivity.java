package com.example.hostelfinder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ManageListingsActivity extends AppCompatActivity {

    Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_listings);

        editBtn = findViewById(R.id.edit_btn);

        editBtn.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Edit hostel",
                    Toast.LENGTH_SHORT
            ).show();

        });
    }
}