# DEMO SURVEY SDK IMPLEMENTATION

# Overview

Demo Survey sdk was developed in Android Studio 3.0.1
The deliverable includes:

1. the source code

2. the aar file for the sdk library

3. the application apk which demonstrates the functionality.

4. the demo survey sdk integration guidelines doc.

## Technical Details

* Singleton Pattern has been used for the Survey class.
* MVP Pattern was used for the Main View which loads the webview with the external url.
* Find unit tests for the library in surveylibrary/src/test.
* Find android espresso test for the main activity in surveylibrary/src/androidTest.


## Build Instructions

From command line navigate in project folder.

* To build the project run: $ ./gradlew clean assembleDebug
* Find the demonstrator apk in project_name/app/build/outputs/apk/debug folder.
* Find the aar library file in project_name/surveylibrary/build/outputs/aar
* For android tests run:  ./gradlew surveylibrary:connectedAndroidTest
* For unit tests run:  ./gradlew surveylibrary:test



