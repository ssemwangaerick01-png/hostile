package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText verificationCode;
    private EditText newPassword;
    private EditText confirmNewPassword;

    private TextView resendCode;

    private Button resetPasswordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reset_password);

        verificationCode =
                findViewById(R.id.verification_code);

        newPassword =
                findViewById(R.id.new_password);

        confirmNewPassword =
                findViewById(R.id.confirm_new_password);

        resendCode =
                findViewById(R.id.resend_code);

        resetPasswordBtn =
                findViewById(R.id.reset_password_btn);

        resendCode.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Verification code resent",
                    Toast.LENGTH_SHORT
            ).show();

        });

        resetPasswordBtn.setOnClickListener(
                v -> resetPassword()
        );
    }

    private void resetPassword() {

        String code =
                verificationCode.getText().toString().trim();

        String password =
                newPassword.getText().toString();

        String confirm =
                confirmNewPassword.getText().toString();

        if (code.isEmpty()) {

            verificationCode.setError(
                    "Enter verification code"
            );

            verificationCode.requestFocus();
            return;
        }

        if (code.length() != 6) {

            verificationCode.setError(
                    "Enter a valid 6-digit code"
            );

            verificationCode.requestFocus();
            return;
        }

        if (password.length() < 6) {

            newPassword.setError(
                    "Password must be at least 6 characters"
            );

            newPassword.requestFocus();
            return;
        }

        if (!password.equals(confirm)) {

            confirmNewPassword.setError(
                    "Passwords do not match"
            );

            confirmNewPassword.requestFocus();
            return;
        }

        /*
         * Later:
         * Verify OTP against the backend.
         * Update the user's password.
         */

        Toast.makeText(
                this,
                "Password reset successfully",
                Toast.LENGTH_SHORT
        ).show();

        Intent intent = new Intent(
                ResetPasswordActivity.this,
                LoginActivity.class
        );

        startActivity(intent);
        finish();
    }
}