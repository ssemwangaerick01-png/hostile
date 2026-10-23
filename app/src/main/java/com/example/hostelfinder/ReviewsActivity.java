package com.example.hostelfinder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewsActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private EditText reviewInput;
    private Button submitReview;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reviews);

        // Connect XML elements
        ratingBar = findViewById(R.id.rating_bar);
        reviewInput = findViewById(R.id.review_input);
        submitReview = findViewById(R.id.submit_review);
        backButton = findViewById(R.id.back_button);

        // Back button
        backButton.setOnClickListener(v -> finish());

        // Submit review
        submitReview.setOnClickListener(v -> submitReview());
    }

    private void submitReview() {

        float rating = ratingBar.getRating();

        String review = reviewInput.getText()
                .toString()
                .trim();

        // Check rating
        if (rating == 0) {
            Toast.makeText(
                    this,
                    "Please select a rating",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        // Check review
        if (review.isEmpty()) {
            Toast.makeText(
                    this,
                    "Please write a review",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        // Temporary action
        Toast.makeText(
                this,
                "Review submitted successfully!",
                Toast.LENGTH_SHORT
        ).show();

        // Clear form
        reviewInput.setText("");
        ratingBar.setRating(0);
    }
}