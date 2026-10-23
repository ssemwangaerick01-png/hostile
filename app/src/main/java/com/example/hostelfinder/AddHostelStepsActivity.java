package com.example.hostelfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddHostelStepsActivity extends AppCompatActivity {

    // Room information
    Spinner roomType;
    EditText roomCapacity;
    EditText price;
    EditText rooms;

    // Amenities
    CheckBox wifi;
    CheckBox water;
    CheckBox electricity;
    CheckBox security;
    CheckBox parking;

    // Contact
    EditText contactPhone;

    // Buttons
    Button backBtn;
    Button addImageBtn;
    Button publishBtn;
    Button backStepBtn;

    // Selected images
    ArrayList<Uri> selectedImages = new ArrayList<>();

    private static final int IMAGE_PICK_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_hostel_steps);

        // Connect XML views to Java
        roomType = findViewById(R.id.room_type);
        roomCapacity = findViewById(R.id.room_capacity);
        price = findViewById(R.id.price);
        rooms = findViewById(R.id.rooms);

        wifi = findViewById(R.id.wifi);
        water = findViewById(R.id.water);
        electricity = findViewById(R.id.electricity);
        security = findViewById(R.id.security);
        parking = findViewById(R.id.parking);

        contactPhone = findViewById(R.id.contact_phone);

        backBtn = findViewById(R.id.back_btn);
        addImageBtn = findViewById(R.id.add_image_btn);
        publishBtn = findViewById(R.id.publish_btn);
        backStepBtn = findViewById(R.id.back_step_btn);


        // -----------------------------
        // ROOM TYPE SPINNER
        // -----------------------------

        String[] roomTypes = {
                "Select Room Type",
                "Single Room",
                "Double Room",
                "Triple Room",
                "Shared Room",
                "Self Contained",
                "Non Self Contained"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                roomTypes
        );

        roomType.setAdapter(adapter);


        // -----------------------------
        // BACK BUTTON
        // -----------------------------

        backBtn.setOnClickListener(view -> {
            finish();
        });


        // -----------------------------
        // BACK TO STEP 1
        // -----------------------------

        backStepBtn.setOnClickListener(view -> {

            // Change this to your actual Step 1 Activity
            Intent intent = new Intent(
                    AddHostelStepsActivity.this,
                    AddHostelActivity.class
            );

            startActivity(intent);
            finish();
        });


        // -----------------------------
        // ADD HOSTEL IMAGES
        // -----------------------------

        addImageBtn.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

            intent.setType("image/*");

            intent.putExtra(
                    Intent.EXTRA_ALLOW_MULTIPLE,
                    true
            );

            intent.addCategory(Intent.CATEGORY_OPENABLE);

            startActivityForResult(
                    intent,
                    IMAGE_PICK_CODE
            );
        });


        // -----------------------------
        // PUBLISH HOSTEL
        // -----------------------------

        publishBtn.setOnClickListener(view -> {

            publishHostel();
        });
    }


    // =====================================================
    // IMAGE SELECTION
    // =====================================================

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {

        super.onActivityResult(
                requestCode,
                resultCode,
                data
        );

        if (requestCode == IMAGE_PICK_CODE &&
                resultCode == RESULT_OK &&
                data != null) {

            selectedImages.clear();

            // Multiple images selected
            if (data.getClipData() != null) {

                int count = data.getClipData().getItemCount();

                for (int i = 0; i < count; i++) {

                    Uri imageUri =
                            data.getClipData()
                                    .getItemAt(i)
                                    .getUri();

                    selectedImages.add(imageUri);
                }

            }

            // Only one image selected
            else if (data.getData() != null) {

                Uri imageUri = data.getData();

                selectedImages.add(imageUri);
            }

            Toast.makeText(
                    this,
                    selectedImages.size()
                            + " image(s) selected",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }


    // =====================================================
    // PUBLISH HOSTEL
    // =====================================================

    private void publishHostel() {

        // Get values from fields
        String selectedRoomType =
                roomType.getSelectedItem().toString();

        String capacity =
                roomCapacity.getText()
                        .toString()
                        .trim();

        String monthlyPrice =
                price.getText()
                        .toString()
                        .trim();

        String availableRooms =
                rooms.getText()
                        .toString()
                        .trim();

        String phone =
                contactPhone.getText()
                        .toString()
                        .trim();


        // -----------------------------
        // VALIDATION
        // -----------------------------

        if (selectedRoomType.equals("Select Room Type")) {

            Toast.makeText(
                    this,
                    "Please select a room type",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        if (capacity.isEmpty()) {

            roomCapacity.setError(
                    "Enter room capacity"
            );

            roomCapacity.requestFocus();

            return;
        }


        if (monthlyPrice.isEmpty()) {

            price.setError(
                    "Enter monthly price"
            );

            price.requestFocus();

            return;
        }


        if (availableRooms.isEmpty()) {

            rooms.setError(
                    "Enter available rooms"
            );

            rooms.requestFocus();

            return;
        }


        if (phone.isEmpty()) {

            contactPhone.setError(
                    "Enter contact phone number"
            );

            contactPhone.requestFocus();

            return;
        }


        if (selectedImages.size() == 0) {

            Toast.makeText(
                    this,
                    "Please add at least one hostel image",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        // -----------------------------
        // GET AMENITIES
        // -----------------------------

        StringBuilder amenities =
                new StringBuilder();

        if (wifi.isChecked()) {
            amenities.append("Wi-Fi, ");
        }

        if (water.isChecked()) {
            amenities.append("Reliable Water, ");
        }

        if (electricity.isChecked()) {
            amenities.append("Electricity, ");
        }

        if (security.isChecked()) {
            amenities.append("Security, ");
        }

        if (parking.isChecked()) {
            amenities.append("Parking, ");
        }


        // Remove last comma
        String finalAmenities =
                amenities.toString();

        if (finalAmenities.endsWith(", ")) {

            finalAmenities =
                    finalAmenities.substring(
                            0,
                            finalAmenities.length() - 2
                    );
        }


        // -----------------------------
        // SUCCESS MESSAGE
        // -----------------------------

        String message =
                "Hostel Published!\n\n" +
                        "Room Type: " + selectedRoomType +
                        "\nCapacity: " + capacity +
                        "\nPrice: UGX " + monthlyPrice +
                        "\nAvailable Rooms: " + availableRooms +
                        "\nAmenities: " + finalAmenities +
                        "\nPhone: " + phone +
                        "\nImages: " + selectedImages.size();


        Toast.makeText(
                this,
                message,
                Toast.LENGTH_LONG
        ).show();


        // Later you can save the information
        // to Firebase, MySQL, SQLite, etc.
    }
}