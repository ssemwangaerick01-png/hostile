package com.example.hostelfinder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookingRequestsActivity extends AppCompatActivity {

    // TextViews
    TextView studentName;
    TextView studentPhone;
    TextView hostelName;
    TextView roomType;
    TextView roomPrice;
    TextView requestDate;
    TextView requestCount;

    // Buttons
    Button acceptBtn;
    Button rejectBtn;

    // Number of pending requests
    int pendingRequests = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booking_requests);

        // Connect XML to Java
        studentName = findViewById(R.id.student_name);
        studentPhone = findViewById(R.id.student_phone);
        hostelName = findViewById(R.id.hostel_name);
        roomType = findViewById(R.id.room_type);
        roomPrice = findViewById(R.id.room_price);
        requestDate = findViewById(R.id.request_date);
        requestCount = findViewById(R.id.request_count);

        acceptBtn = findViewById(R.id.accept_btn);
        rejectBtn = findViewById(R.id.reject_btn);


        // --------------------------------
        // ACCEPT BOOKING
        // --------------------------------

        acceptBtn.setOnClickListener(view -> {

            String student =
                    studentName.getText().toString();

            // Show confirmation message
            Toast.makeText(
                    BookingRequestsActivity.this,
                    "Booking accepted for " + student,
                    Toast.LENGTH_LONG
            ).show();

            // Change button text
            acceptBtn.setText("Accepted");

            // Disable buttons
            acceptBtn.setEnabled(false);
            rejectBtn.setEnabled(false);

            // Reduce pending requests
            if (pendingRequests > 0) {
                pendingRequests--;
            }

            requestCount.setText(
                    String.valueOf(pendingRequests)
            );
        });


        // --------------------------------
        // REJECT BOOKING
        // --------------------------------

        rejectBtn.setOnClickListener(view -> {

            String student =
                    studentName.getText().toString();

            Toast.makeText(
                    BookingRequestsActivity.this,
                    "Booking rejected for " + student,
                    Toast.LENGTH_LONG
            ).show();

            // Change button text
            rejectBtn.setText("Rejected");

            // Disable buttons
            acceptBtn.setEnabled(false);
            rejectBtn.setEnabled(false);

            // Reduce pending requests
            if (pendingRequests > 0) {
                pendingRequests--;
            }

            requestCount.setText(
                    String.valueOf(pendingRequests)
            );
        });
    }
}