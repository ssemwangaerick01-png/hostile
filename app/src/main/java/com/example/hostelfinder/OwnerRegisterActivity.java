package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OwnerRegisterActivity extends AppCompatActivity {

    private EditText ownerName;
    private EditText hostelName;
    private EditText ownerEmail;
    private EditText ownerPhone;
    private EditText ownerPassword;
    private EditText ownerConfirmPassword;

    private CheckBox ownerTerms;

    private LinearLayout uploadId;
    private TextView idDocumentName;

    private Button createOwnerAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_owner_register);

        ownerName = findViewById(R.id.owner_name);
        hostelName = findViewById(R.id.hostel_name);
        ownerEmail = findViewById(R.id.owner_email);
        ownerPhone = findViewById(R.id.owner_phone);

        ownerPassword = findViewById(R.id.owner_password);
        ownerConfirmPassword =
                findViewById(R.id.owner_confirm_password);

        ownerTerms = findViewById(R.id.owner_terms);

        uploadId = findViewById(R.id.upload_id);
        idDocumentName = findViewById(R.id.id_document_name);

        createOwnerAccount =
                findViewById(R.id.create_owner_account);

        uploadId.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "National ID upload will be added",
                    Toast.LENGTH_SHORT
            ).show();

        });

        createOwnerAccount.setOnClickListener(
                v -> registerOwner()
        );
    }

    private void registerOwner() {

        String name =
                ownerName.getText().toString().trim();

        String hostel =
                hostelName.getText().toString().trim();

        String email =
                ownerEmail.getText().toString().trim();

        String phone =
                ownerPhone.getText().toString().trim();

        String password =
                ownerPassword.getText().toString();

        String confirm =
                ownerConfirmPassword.getText().toString();

        if (name.isEmpty()) {

            ownerName.setError("Enter owner name");
            ownerName.requestFocus();
            return;
        }

        if (hostel.isEmpty()) {

            hostelName.setError("Enter hostel name");
            hostelName.requestFocus();
            return;
        }

        if (email.isEmpty()) {

            ownerEmail.setError("Enter email");
            ownerEmail.requestFocus();
            return;
        }

        if (phone.isEmpty()) {

            ownerPhone.setError("Enter phone number");
            ownerPhone.requestFocus();
            return;
        }

        if (password.length() < 6) {

            ownerPassword.setError(
                    "Password must be at least 6 characters"
            );

            ownerPassword.requestFocus();
            return;
        }

        if (!password.equals(confirm)) {

            ownerConfirmPassword.setError(
                    "Passwords do not match"
            );

            ownerConfirmPassword.requestFocus();
            return;
        }

        if (!ownerTerms.isChecked()) {

            Toast.makeText(
                    this,
                    "Please accept the Terms & Conditions",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        /*
         * Owner database registration
         * and National ID verification
         * will be connected later.
         */

        Toast.makeText(
                this,
                "Owner account created successfully",
                Toast.LENGTH_SHORT
        ).show();

        Intent intent = new Intent(
                OwnerRegisterActivity.this,
                LoginActivity.class
        );

        startActivity(intent);
        finish();
    }
}