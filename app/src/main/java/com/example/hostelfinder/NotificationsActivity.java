package com.example.hostelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationsActivity extends AppCompatActivity {

    private Button markAllRead;

    private Button navHome;
    private Button navSaved;
    private Button navBookings;
    private Button navProfile;

    private LinearLayout notification1;
    private LinearLayout notification2;
    private LinearLayout notification3;

    private LinearLayout emptyNotifications;

    private TextView notificationCount;

    private int unreadCount = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notifications);

        // Header
        markAllRead = findViewById(R.id.mark_all_read);
        notificationCount = findViewById(R.id.notification_count);

        // Notifications
        notification1 = findViewById(R.id.notification_1);
        notification2 = findViewById(R.id.notification_2);
        notification3 = findViewById(R.id.notification_3);

        // Empty state
        emptyNotifications = findViewById(R.id.empty_notifications);

        // Bottom navigation
        navHome = findViewById(R.id.nav_home);
        navSaved = findViewById(R.id.nav_saved);
        navBookings = findViewById(R.id.nav_bookings);
        navProfile = findViewById(R.id.nav_profile);

        // Update notification count
        updateNotificationCount();

        // Mark all notifications as read
        markAllRead.setOnClickListener(v -> markAllNotificationsAsRead());

        // Individual notification clicks
        notification1.setOnClickListener(v -> markNotificationAsRead(notification1));
        notification2.setOnClickListener(v -> markNotificationAsRead(notification2));
        notification3.setOnClickListener(v -> markNotificationAsRead(notification3));

        // Bottom navigation
        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    NotificationsActivity.this,
                    StudentDashboardActivity.class
            );

            startActivity(intent);
            finish();
        });

        navSaved.setOnClickListener(v -> {

            Intent intent = new Intent(
                    NotificationsActivity.this,
                    SavedHostelsActivity.class
            );

            startActivity(intent);
            finish();
        });

        navBookings.setOnClickListener(v -> {

            Intent intent = new Intent(
                    NotificationsActivity.this,
                    MyBookingsActivity.class
            );

            startActivity(intent);
            finish();
        });

        navProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    NotificationsActivity.this,
                    StudentProfileActivity.class
            );

            startActivity(intent);
            finish();
        });
    }

    private void updateNotificationCount() {

        if (unreadCount == 0) {

            notificationCount.setText("No unread notifications");

        } else if (unreadCount == 1) {

            notificationCount.setText("1 unread notification");

        } else {

            notificationCount.setText(
                    unreadCount + " unread notifications"
            );
        }
    }

    private void markNotificationAsRead(LinearLayout notification) {

        if (notification.getVisibility() == View.VISIBLE) {

            unreadCount--;

            if (unreadCount < 0) {
                unreadCount = 0;
            }

            notification.setAlpha(0.65f);

            updateNotificationCount();

            checkEmptyState();
        }
    }

    private void markAllNotificationsAsRead() {

        unreadCount = 0;

        notification1.setAlpha(0.65f);
        notification2.setAlpha(0.65f);
        notification3.setAlpha(0.65f);

        updateNotificationCount();

        markAllRead.setText("All read");

        checkEmptyState();
    }

    private void checkEmptyState() {

        if (unreadCount == 0) {

            emptyNotifications.setVisibility(View.VISIBLE);

        }
    }
}