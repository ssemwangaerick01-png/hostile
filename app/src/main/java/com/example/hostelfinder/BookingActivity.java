package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    // Header
    ImageButton backButton;

    // Hostel information
    TextView bookingHostelName;
    TextView bookingHostelLocation;
    TextView bookingHostelRating;
    TextView bookingHostelPrice;

    // Booking details
    Spinner roomSpinner;
    Spinner durationSpinner;

    // Student information
    EditText studentName;
    EditText studentPhone;
    EditText studentUniversity;
    EditText studentId;

    // Payment
    RadioGroup paymentGroup;
    RadioButton mtnPayment;
    RadioButton airtelPayment;
    EditText paymentPhone;

    // Notes
    EditText bookingNotes;

    // Summary
    TextView summaryRoom;
    TextView summaryDuration;
    TextView summaryPrice;
    TextView summaryServiceFee;
    TextView summaryTotal;

    // Terms and confirmation
    CheckBox termsCheckbox;
    Button confirmBooking;


    // Hostel price
    double hostelPrice = 800000;

    // Service fee
    double serviceFee = 10000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booking);


        // ==========================================
        // INITIALIZE VIEWS
        // ==========================================

        backButton = findViewById(R.id.back_button);


        bookingHostelName =
                findViewById(R.id.booking_hostel_name);

        bookingHostelLocation =
                findViewById(R.id.booking_hostel_location);

        bookingHostelRating =
                findViewById(R.id.booking_hostel_rating);

        bookingHostelPrice =
                findViewById(R.id.booking_hostel_price);


        roomSpinner =
                findViewById(R.id.room_spinner);

        durationSpinner =
                findViewById(R.id.duration_spinner);


        studentName =
                findViewById(R.id.student_name);

        studentPhone =
                findViewById(R.id.student_phone);

        studentUniversity =
                findViewById(R.id.student_university);

        studentId =
                findViewById(R.id.student_id);


        paymentGroup =
                findViewById(R.id.payment_group);

        mtnPayment =
                findViewById(R.id.mtn_payment);

        airtelPayment =
                findViewById(R.id.airtel_payment);

        paymentPhone =
                findViewById(R.id.payment_phone);


        bookingNotes =
                findViewById(R.id.booking_notes);


        summaryRoom =
                findViewById(R.id.summary_room);

        summaryDuration =
                findViewById(R.id.summary_duration);

        summaryPrice =
                findViewById(R.id.summary_price);

        summaryServiceFee =
                findViewById(R.id.summary_service_fee);

        summaryTotal =
                findViewById(R.id.summary_total);


        termsCheckbox =
                findViewById(R.id.terms_checkbox);

        confirmBooking =
                findViewById(R.id.confirm_booking);


        // ==========================================
        // LOAD HOSTEL INFORMATION
        // ==========================================

        loadHostelInformation();


        // ==========================================
        // SETUP ROOM SPINNER
        // ==========================================

        setupRoomSpinner();


        // ==========================================
        // SETUP DURATION SPINNER
        // ==========================================

        setupDurationSpinner();


        // ==========================================
        // BACK BUTTON
        // ==========================================

        backButton.setOnClickListener(v -> {

            finish();

        });


        // ==========================================
        // ROOM SELECTION
        // ==========================================

        roomSpinner.setOnItemSelectedListener(
                new android.widget.AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            android.widget.AdapterView<?> parent,
                            android.view.View view,
                            int position,
                            long id) {

                        String room =
                                parent.getItemAtPosition(position)
                                        .toString();

                        summaryRoom.setText(
                                "Room: " + room
                        );
                    }

                    @Override
                    public void onNothingSelected(
                            android.widget.AdapterView<?> parent) {

                    }
                }
        );


        // ==========================================
        // DURATION SELECTION
        // ==========================================

        durationSpinner.setOnItemSelectedListener(
                new android.widget.AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            android.widget.AdapterView<?> parent,
                            android.view.View view,
                            int position,
                            long id) {

                        String duration =
                                parent.getItemAtPosition(position)
                                        .toString();

                        summaryDuration.setText(
                                "Duration: " + duration
                        );
                    }

                    @Override
                    public void onNothingSelected(
                            android.widget.AdapterView<?> parent) {

                    }
                }
        );


        // ==========================================
        // CONFIRM BOOKING
        // ==========================================

        confirmBooking.setOnClickListener(v -> {

            confirmBooking();

        });

    }


    // ==================================================
    // LOAD HOSTEL INFORMATION
    // ==================================================

    private void loadHostelInformation() {

        /*
         * Information can later come from
         * HostelDetailsActivity.
         */

        Intent intent = getIntent();

        String hostelName =
                intent.getStringExtra("hostel_name");

        String hostelLocation =
                intent.getStringExtra("hostel_location");

        double price =
                intent.getDoubleExtra(
                        "hostel_price",
                        800000
                );


        if (hostelName == null ||
                hostelName.isEmpty()) {

            hostelName = "Sunrise Hostel";
        }


        if (hostelLocation == null ||
                hostelLocation.isEmpty()) {

            hostelLocation = "Kisaasi, Kampala";
        }


        hostelPrice = price;


        bookingHostelName.setText(hostelName);

        bookingHostelLocation.setText(
                "📍 " + hostelLocation
        );

        bookingHostelRating.setText(
                "⭐ 4.7 • 0.8 km away"
        );

        bookingHostelPrice.setText(
                formatMoney(hostelPrice)
                        + " / semester"
        );


        summaryPrice.setText(
                "Accommodation: "
                        + formatMoney(hostelPrice)
        );


        summaryServiceFee.setText(
                "Service Fee: "
                        + formatMoney(serviceFee)
        );


        summaryTotal.setText(
                "Total: "
                        + formatMoney(
                        hostelPrice + serviceFee
                )
        );

    }


    // ==================================================
    // ROOM SPINNER
    // ==================================================

    private void setupRoomSpinner() {

        String[] rooms = {

                "Select Room",

                "Room A01",

                "Room A02",

                "Room A03",

                "Room B01",

                "Room B02",

                "Room B03"

        };


        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        rooms
                );


        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );


        roomSpinner.setAdapter(adapter);

    }


    // ==================================================
    // DURATION SPINNER
    // ==================================================

    private void setupDurationSpinner() {

        String[] durations = {

                "Select Duration",

                "1 Semester",

                "2 Semesters",

                "1 Academic Year"

        };


        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        durations
                );


        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );


        durationSpinner.setAdapter(adapter);

    }


    // ==================================================
    // CONFIRM BOOKING
    // ==================================================

    private void confirmBooking() {

        // ------------------------------------------
        // GET VALUES
        // ------------------------------------------

        String name =
                studentName.getText()
                        .toString()
                        .trim();

        String phone =
                studentPhone.getText()
                        .toString()
                        .trim();

        String university =
                studentUniversity.getText()
                        .toString()
                        .trim();

        String studentNumber =
                studentId.getText()
                        .toString()
                        .trim();

        String paymentNumber =
                paymentPhone.getText()
                        .toString()
                        .trim();


        String room =
                roomSpinner.getSelectedItem()
                        .toString();

        String duration =
                durationSpinner.getSelectedItem()
                        .toString();


        // ==========================================
        // VALIDATE NAME
        // ==========================================

        if (name.isEmpty()) {

            studentName.setError(
                    "Enter your full name"
            );

            studentName.requestFocus();

            return;
        }


        // ==========================================
        // VALIDATE PHONE
        // ==========================================

        if (phone.isEmpty()) {

            studentPhone.setError(
                    "Enter your phone number"
            );

            studentPhone.requestFocus();

            return;
        }


        // ==========================================
        // VALIDATE UNIVERSITY
        // ==========================================

        if (university.isEmpty()) {

            studentUniversity.setError(
                    "Enter your university"
            );

            studentUniversity.requestFocus();

            return;
        }


        // ==========================================
        // VALIDATE STUDENT ID
        // ==========================================

        if (studentNumber.isEmpty()) {

            studentId.setError(
                    "Enter your student ID"
            );

            studentId.requestFocus();

            return;
        }


        // ==========================================
        // VALIDATE ROOM
        // ==========================================

        if (room.equals("Select Room")) {

            Toast.makeText(
                    this,
                    "Please select a room",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        // ==========================================
        // VALIDATE DURATION
        // ==========================================

        if (duration.equals("Select Duration")) {

            Toast.makeText(
                    this,
                    "Please select booking duration",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        // ==========================================
        // VALIDATE PAYMENT
        // ==========================================

        int selectedPayment =
                paymentGroup.getCheckedRadioButtonId();


        if (selectedPayment == -1) {

            Toast.makeText(
                    this,
                    "Please select a payment method",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        // ==========================================
        // VALIDATE PAYMENT NUMBER
        // ==========================================

        if (paymentNumber.isEmpty()) {

            paymentPhone.setError(
                    "Enter Mobile Money number"
            );

            paymentPhone.requestFocus();

            return;
        }


        // ==========================================
        // VALIDATE TERMS
        // ==========================================

        if (!termsCheckbox.isChecked()) {

            Toast.makeText(
                    this,
                    "Please accept the booking terms",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        // ==========================================
        // GET PAYMENT METHOD
        // ==========================================

        String paymentMethod;

        if (selectedPayment == R.id.mtn_payment) {

            paymentMethod = "MTN Mobile Money";

        } else {

            paymentMethod = "Airtel Money";

        }


        // ==========================================
        // TEMPORARY BOOKING SUCCESS
        // ==========================================

        Toast.makeText(
                this,
                "Booking submitted successfully!",
                Toast.LENGTH_LONG
        ).show();


        /*
         * Later this section will send:
         *
         * student name
         * phone
         * university
         * student ID
         * hostel
         * room
         * duration
         * payment method
         * payment number
         * notes
         *
         * to your database.
         */


        // ==========================================
        // OPEN MY BOOKINGS
        // ==========================================

        Intent intent = new Intent(
                BookingActivity.this,
                MyBookingsActivity.class
        );

        startActivity(intent);

        finish();

    }


    // ==================================================
    // FORMAT MONEY
    // ==================================================

    private String formatMoney(double amount) {

        return String.format(
                "UGX %,.0f",
                amount
        );

    }

}