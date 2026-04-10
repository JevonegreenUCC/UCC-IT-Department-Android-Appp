UCC IT Department App
An Android mobile application for the Department of Information Technology at the University of the Commonwealth Caribbean (UCC). Built as part of the ITT420 Mobile Application Development course.

Authors: Jevone Green, Annakay Harper

Student ID: 20244389, 20234779
Course: ITT420 - Mobile Application Development
Institution: University of the Commonwealth Caribbean (UCC)


Features

Home Screen — Welcome banner with UCC campus photo, department info, career opportunities, and quick access cards for all sections
Faculty/Staff Directory — Lists all IT department staff with photo, title, phone number, and email. Users can tap to dial or email directly from the app
Courses — Browse available IT department courses
Admissions — Direct link to UCC's official undergraduate application page
Social Media — In-app viewer for UCC's Facebook, Twitter, and Instagram pages
Email FAB — Floating action button to email the Head of Department directly


Technologies Used

Language: Kotlin
IDE: Android Studio
UI: Material Design 3 Components
Libraries:

RecyclerView — Staff and course listings
CardView — UI cards
WebView — Social media in-app viewing
CircleImageView (de.hdodenhof:circleimageview:3.1.0) — Circular staff photos
AndroidX Browser (androidx.browser:browser:1.8.0) — Chrome Custom Tabs
View Binding — Layout binding




Requirements

Minimum SDK: 24 (Android 7.0 Nougat)
Target SDK: 35 (Android 15)
Compile SDK: 35
Android Studio: Hedgehog or later recommended


Setup Instructions

Clone or download this repository
Open the project in Android Studio
Wait for Gradle to sync automatically
Connect a physical device or launch an emulator
Click the Run ▶ button to build and install the app


Note: The app requires an active internet connection for the Social Media and Admissions sections to load properly.


Project Structure
app/
├── src/main/
│   ├── java/com/ucc/itdept/
│   │   ├── MainActivity.kt
│   │   ├── HomeFragment.kt
│   │   ├── StaffFragment.kt
│   │   ├── StaffAdapter.kt
│   │   ├── Staff.kt
│   │   ├── CoursesFragment.kt
│   │   ├── AdmissionsFragment.kt
│   │   └── SocialMediaFragment.kt
│   └── res/
│       ├── layout/
│       ├── drawable/
│       ├── menu/
│       └── values/
