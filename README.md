# Hostel Finder 🏨

**"Find Your Perfect Hostel Near Campus"**

A complete native Android application developed for **Android Studio** using **Java**, **XML layouts**, **Material Design**, and **Firebase**.

---

## 📱 Tech Stack & Configuration

- **IDE:** Android Studio (Koala / Ladybug / Iguana / Hedgehog)
- **Language:** Java (JDK 21 compatible, Java 17 bytecode)
- **UI:** XML Layouts with Material Design Components
- **Architecture:** Activities, RecyclerView Adapters, Data Models
- **Backend:** Firebase Authentication & Cloud Services
- **Build System:**
  - **Gradle:** 8.7
  - **Android Gradle Plugin (AGP):** 8.4.1
  - **Compile SDK:** 34
  - **Target SDK:** 34
  - **Min SDK:** 24 (Android 7.0+)

---

## 🚀 How to Run in Android Studio

1. **Clone or Download the ZIP**:
   ```bash
   git clone https://github.com/ssemwangaerick01-png/hostile.git
   ```
   Or click **Code → Download ZIP** and extract it.

2. **Open in Android Studio**:
   - Launch Android Studio.
   - Choose **File → Open** (or **Open** from the welcome screen).
   - Select the root folder of this project.

3. **Firebase Setup (`google-services.json`)**:
   - A placeholder `app/google-services.json` is included so Gradle sync succeeds immediately.
   - To connect your live Firebase project (`hotil01`), download your `google-services.json` from the [Firebase Console](https://console.firebase.google.com/project/hotil01/settings/general) and place it in the `app/` directory (replacing the placeholder).
   - Ensure **Email/Password** sign-in provider is enabled under **Authentication → Sign-in method**.

4. **Sync & Run**:
   - Click **Sync Project with Gradle Files** (elephant icon).
   - Select an Android Virtual Device (Emulator with API 30+ recommended).
   - Click **Run app** (green play button ▶️).

---

## 👥 Features

### 🎓 Student Flow:
- **Splash & Onboarding:** Welcoming intro screens
- **Authentication:** Email & Password login, registration, password reset
- **Dashboard:** Browse hostels, view featured listings, campus filtering
- **Search & Filter:** Search by location, amenities, price, university
- **Hostel Details:** View hostel photos, pricing, amenities, room details, and owner contact
- **Bookings:** Book a room, view active and previous bookings
- **Saved Hostels:** Bookmark favorite listings
- **Messages & Notifications:** In-app messaging and alerts
- **Reviews:** Submit and read reviews
- **Profile:** Manage student profile details

### 🏢 Hostel Owner Flow:
- **Owner Dashboard:** Overview of listed properties and pending bookings
- **Add Hostel:** Step-by-step listing wizard with details, amenities, and room pricing
- **Manage Listings:** Edit, update, and manage hostel listings
- **Booking Requests:** Accept or reject incoming student booking requests
- **Owner Messages & Notifications:** Communicate with prospective students
- **Analytics & Profile:** View occupancy, analytics, and business profile
