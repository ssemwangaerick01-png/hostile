package com.example.hostelfinder;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OwnerMessageActivity extends AppCompatActivity {

    private LinearLayout chatContainer;
    private EditText messageInput;
    private ImageButton sendButton;
    private ScrollView chatScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_owner_messages);

        // Connect XML views
        chatContainer = findViewById(R.id.chat_container);
        messageInput = findViewById(R.id.message_input);
        sendButton = findViewById(R.id.send_message);
        chatScroll = findViewById(R.id.chat_scroll);

        ImageButton backButton = findViewById(R.id.back_button);
        ImageButton moreButton = findViewById(R.id.more_button);
        ImageButton attachButton = findViewById(R.id.attach_button);

        // Back button
        backButton.setOnClickListener(v -> finish());

        // Send message
        sendButton.setOnClickListener(v -> sendMessage());

        // More button
        moreButton.setOnClickListener(v ->
                Toast.makeText(
                        OwnerMessageActivity.this,
                        "More options",
                        Toast.LENGTH_SHORT
                ).show()
        );

        // Attach button
        attachButton.setOnClickListener(v ->
                Toast.makeText(
                        OwnerMessageActivity.this,
                        "Attachment feature coming soon",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }

    private void sendMessage() {

        String message = messageInput.getText()
                .toString()
                .trim();

        // Prevent empty messages
        if (message.isEmpty()) {
            Toast.makeText(
                    this,
                    "Please write a message",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        // Current time
        String currentTime = new SimpleDateFormat(
                "hh:mm a",
                Locale.getDefault()
        ).format(new Date());

        // Main message wrapper
        LinearLayout messageWrapper =
                new LinearLayout(this);

        messageWrapper.setOrientation(
                LinearLayout.VERTICAL
        );

        messageWrapper.setGravity(Gravity.END);

        LinearLayout.LayoutParams wrapperParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        wrapperParams.setMargins(
                0,
                0,
                0,
                dpToPx(14)
        );

        messageWrapper.setLayoutParams(wrapperParams);

        // Username
        TextView username =
                new TextView(this);

        username.setText("You");
        username.setTextSize(12);
        username.setTextColor(
                Color.parseColor("#64748B")
        );
        username.setGravity(Gravity.END);
        username.setTypeface(
                null,
                android.graphics.Typeface.BOLD
        );

        LinearLayout.LayoutParams usernameParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        usernameParams.setMargins(
                0,
                0,
                dpToPx(4),
                dpToPx(4)
        );

        username.setLayoutParams(usernameParams);

        // Message bubble
        LinearLayout bubble =
                new LinearLayout(this);

        bubble.setOrientation(
                LinearLayout.VERTICAL
        );

        bubble.setPadding(
                dpToPx(12),
                dpToPx(10),
                dpToPx(10),
                dpToPx(8)
        );

        bubble.setBackgroundResource(
                R.drawable.message_sent
        );

        LinearLayout.LayoutParams bubbleParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        bubbleParams.setMargins(
                dpToPx(50),
                0,
                0,
                0
        );

        bubble.setLayoutParams(bubbleParams);

        // Message text
        TextView messageText =
                new TextView(this);

        messageText.setText(message);
        messageText.setTextSize(15);
        messageText.setTextColor(Color.WHITE);
        messageText.setLineSpacing(
                2f,
                1.0f
        );

        bubble.addView(messageText);

        // Bottom information row
        LinearLayout infoRow =
                new LinearLayout(this);

        infoRow.setOrientation(
                LinearLayout.HORIZONTAL
        );

        infoRow.setGravity(
                Gravity.CENTER_VERTICAL
        );

        infoRow.setGravity(Gravity.END);

        LinearLayout.LayoutParams infoParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        infoParams.setMargins(
                0,
                dpToPx(5),
                0,
                0
        );

        infoRow.setLayoutParams(infoParams);

        // Time
        TextView time =
                new TextView(this);

        time.setText(currentTime);
        time.setTextSize(10);
        time.setTextColor(
                Color.parseColor("#DCE8FF")
        );

        infoRow.addView(time);

        // Read status
        TextView readStatus =
                new TextView(this);

        readStatus.setText("✓✓");
        readStatus.setTextSize(12);
        readStatus.setTypeface(
                null,
                android.graphics.Typeface.BOLD
        );
        readStatus.setTextColor(
                Color.parseColor("#93C5FD")
        );

        LinearLayout.LayoutParams readParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        readParams.setMargins(
                dpToPx(5),
                0,
                0,
                0
        );

        readStatus.setLayoutParams(readParams);

        infoRow.addView(readStatus);

        // Add information to bubble
        bubble.addView(infoRow);

        // Add everything to wrapper
        messageWrapper.addView(username);
        messageWrapper.addView(bubble);

        // Add message to chat
        chatContainer.addView(messageWrapper);

        // Clear input
        messageInput.setText("");

        // Scroll to bottom
        chatScroll.post(() ->
                chatScroll.fullScroll(
                        ScrollView.FOCUS_DOWN
                )
        );
    }

    private int dpToPx(int dp) {
        float density =
                getResources()
                        .getDisplayMetrics()
                        .density;

        return Math.round(dp * density);
    }
}