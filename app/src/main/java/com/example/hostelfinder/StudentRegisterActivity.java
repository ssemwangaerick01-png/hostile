package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentRegisterActivity extends AppCompatActivity {

    private EditText fullName;
    private EditText email;
    private EditText phone;
    private EditText university;
    private EditText password;
    private EditText confirmPassword;

    private CheckBox terms;

    private Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student_register);

        fullName = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        university = findViewById(R.id.university);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);

        terms = findViewById(R.id.terms);

        createAccount = findViewById(
                R.id.create_student_account
        );

        createAccount.setOnClickListener(v -> registerStudent());
    }

    private void registerStudent() {

        String name = fullName.getText().toString().trim();
        String studentEmail = email.getText().toString().trim();
        String studentPhone = phone.getText().toString().trim();
        String studentUniversity =
                university.getText().toString().trim();

        String studentPassword =
                password.getText().toString();

        String confirm =
                confirmPassword.getText().toString();

        if (name.isEmpty()) {
            fullName.setError("Enter your full name");
            fullName.requestFocus();
            return;
        }

        if (studentEmail.isEmpty()) {
            email.setError("Enter your email");
            email.requestFocus();
            return;
        }

        if (studentPhone.isEmpty()) {
            phone.setError("Enter your phone number");
            phone.requestFocus();
            return;
        }

        if (studentUniversity.isEmpty()) {
            university.setError("Enter your university");
            university.requestFocus();
            return;
        }

        if (studentPassword.length() < 6) {
            password.setError(
                    "Password must be at least 6 characters"
            );
            password.requestFocus();
            return;
        }

        if (!studentPassword.equals(confirm)) {
            confirmPassword.setError(
                    "Passwords do not match"
            );
            confirmPassword.requestFocus();
            return;
        }

        if (!terms.isChecked()) {

            Toast.makeText(
                    this,
                    "Please accept the Terms & Conditions",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        /*
         * Database registration will be added here.
         */

        Toast.makeText(
                this,
                "Student account created successfully",
                Toast.LENGTH_SHORT
        ).show();

        Intent intent = new Intent(
                StudentRegisterActivity.this,
                LoginActivity.class
        );

        startActivity(intent);
        finish();
    }
}