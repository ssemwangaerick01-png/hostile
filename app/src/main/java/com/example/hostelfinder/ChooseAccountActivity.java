package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseAccountActivity extends AppCompatActivity {

    private LinearLayout studentAccount;
    private LinearLayout ownerAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose_account);

        studentAccount = findViewById(R.id.student_account);
        ownerAccount = findViewById(R.id.owner_account);

        studentAccount.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ChooseAccountActivity.this,
                    StudentRegisterActivity.class
            );

            startActivity(intent);
        });

        ownerAccount.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ChooseAccountActivity.this,
                    OwnerRegisterActivity.class
            );

            startActivity(intent);
        });
    }
}