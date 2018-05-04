# DEMO SURVEY SDK Documentation

## OVERVIEW

Publishers using the survey sdk demo, can show in the main application
an overlay webview which contains an external URL of the survey page.

### SET UP

To integrate the Demo Survey SDK in your application:

1) Add the provided demo survey sdk aar file in your project structure.

2) Add the internet permission
```
<uses-permission android:name="android.permission.INTERNET"/>
```
in your project's manifest file.

3) To initiate the sdk, create a new Application class, or update an existing class
and initialize Demo Survey SDK in onCreate method:
```
Survey.init(this, param1, param2, param3, param4, param5);
```
param1: Will be placed on the top of the overlay webview.
param2: Will be placed on the bottom of the overlay webview.
param3, param4 and param5 will be passed back to main application via the
listener of close button of the webview overlay.

4) Add the following line for enabling sdk logs. Filter logs with LOG_TAG = "surveySDK".
Please Remove the line for release apk.
```
Survey.getInstance().enableLogging()
```

### SHOW OVERLAY WEBVIEW

To show the overlay webview you have to add the following line in your
activity:
```
Survey.getInstance().showSurveyContent();
```

### LISTENER FOR ACTION(CLOSE/OPEN) IN WEBVIEW

SDK provides a listener to notify you if the webview opened or closed.
When webview is closed via the close button of webview or back button of device, sdk is passing back the param3, param4 and param5.
```
public class MainActivity extends AppCompatActivity implements SurveyWebViewListener {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  ...
  Survey.getInstance().registerSurveyWebViewListener(this);
  ...
 }

 @Override
 public void onOpenedSurveyWebView() {
  // webview has been loaded
 }

 @Override
 public void onClosedSurveyWebView(String param3, String param4, String param5) {
  // user has pressed back or close button of webview
 }

}
```
