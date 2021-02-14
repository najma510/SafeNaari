# SafeNaari

![logo](SafeNaari.png)

SafeNaari is a handy mobile application developed with two modules. It serves as both,a personal safety app and complaint lodging app.

# Features!

1. ##### SOS/Emergency-
    Send a SMS reading- "I am In Danger" to selected 5 contacts and your GPS location to track you with just a click of a button.
2. ##### Complaint-
   Instant complaining to the police via E-mail. Complaints can be of any type varying from Domestic Violence to Eve Teasing.
3. ##### Alarm-
   An alarm (Polics Siren) is set up within 5 seconds. It may help to scare the pursuer.
4. ##### Fake Call-
    How often, do we think that if we had an incoming call right now, it can save us from the situation we are in right now.

### Installation:

Clone this repository

```bash
git clone https://github.com/najma510/SafeNaari
```

### Setup:

1) This app runs off a Firebase backend. You will need to generate your firebase backend. To do this, navigate to https://firebase.google.com/ and sign up. Create a project called "SafeNaari". Navigate to "Database", select the three dots and then select "Import JSON". Select the file [Firebase JSON File](https://github.com/najma510/SafeNaari/blob/main/safenaari-firebase-adminsdk-c47wx-bfea7fdfe0.json). Allow Firebase to import the data. 
2) You will need to generate your own google-services.json file to use with the app. Navigate to the Firebase project settings dashboard. You should see an option to download the google-services.json file. This must then be placed into the app folder of this project. For example: [google-services.json](https://github.com/najma510/SafeNaari/blob/main/app/google-services.json).

#### To Run:
1) Install and setup Android App using [Install Android Studio](https://developer.android.com/studio?gclid=CjwKCAiAsaOBBhA4EiwAo0_AnAhya5oYzC18awUuBBjQdZoCRxhRUVmHzvjc4v1A228DmXQD0yvorxoCCZkQAvD_BwE&gclsrc=aw.ds).
2) Navigate to the project directory SafeNaari
4) Install the required packages and Dependencies in Android Studio.
5) Launch Emulator or run on real device
