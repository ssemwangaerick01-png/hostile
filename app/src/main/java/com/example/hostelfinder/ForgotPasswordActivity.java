package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText recoveryContact;
    private Button sendCodeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forgot_password);

        recoveryContact =
                findViewById(R.id.recovery_contact);

        sendCodeBtn =
                findViewById(R.id.send_code_btn);

        sendCodeBtn.setOnClickListener(
                v -> sendResetCode()
        );
    }

    private void sendResetCode() {

        String contact =
                recoveryContact.getText().toString().trim();

        if (contact.isEmpty()) {

            recoveryContact.setError(
                    "Enter your email or phone number"
            );

            recoveryContact.requestFocus();
            return;
        }

        /*
         * Later:
         * Send OTP through email/SMS.
         */

        Intent intent = new Intent(
                ForgotPasswordActivity.this,
                ResetPasswordActivity.class
        );

        intent.putExtra("contact", contact);

        startActivity(intent);
    }
}