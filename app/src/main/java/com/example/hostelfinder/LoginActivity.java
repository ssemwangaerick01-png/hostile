package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class LoginActivity extends AppCompatActivity {


    EditText emailEt;
    EditText passwordEt;

    CheckBox rememberMe;

    Button loginButton;

    TextView forgotPassword;
    TextView signupText;

    ImageButton googleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        // Connect XML components
        emailEt = findViewById(R.id.email_et);
        passwordEt = findViewById(R.id.password_et);

        rememberMe = findViewById(R.id.remember_me);

        loginButton = findViewById(R.id.login_button);

        forgotPassword = findViewById(R.id.forgot_password);
        signupText = findViewById(R.id.signup_text);

        googleButton = findViewById(R.id.google_button);


        // LOGIN BUTTON
        loginButton.setOnClickListener(v -> {

            String email = emailEt.getText().toString().trim();
            String password = passwordEt.getText().toString().trim();


            // Check if fields are empty
            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                        LoginActivity.this,
                        "Please enter email and password",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }


            // STUDENT LOGIN
            if (email.equals("student@gmail.com")
                    && password.equals("1234")) {

                Toast.makeText(
                        LoginActivity.this,
                        "Student login successful",
                        Toast.LENGTH_SHORT
                ).show();

                Intent intent = new Intent(
                        LoginActivity.this,
                        StudentDashboardActivity.class
                );

                startActivity(intent);

                finish();
            }


            // OWNER LOGIN
            else if (email.equals("owner@gmail.com")
                    && password.equals("1324")) {

                Toast.makeText(
                        LoginActivity.this,
                        "Owner login successful",
                        Toast.LENGTH_SHORT
                ).show();

                Intent intent = new Intent(
                        LoginActivity.this,
                        OwnerDashboardActivity.class
                );

                startActivity(intent);

                finish();
            }


            // WRONG LOGIN
            else {

                Toast.makeText(
                        LoginActivity.this,
                        "Invalid email or password",
                        Toast.LENGTH_SHORT
                ).show();
            }

        });


        // FORGOT PASSWORD
        forgotPassword.setOnClickListener(v -> {

            Toast.makeText(
                    LoginActivity.this,
                    "Forgot password selected",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // SIGN UP
        signupText.setOnClickListener(v -> {

            Toast.makeText(
                    LoginActivity.this,
                    "Opening registration",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // GOOGLE LOGIN
        googleButton.setOnClickListener(v -> {

            Toast.makeText(
                    LoginActivity.this,
                    "Google login selected",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }
}