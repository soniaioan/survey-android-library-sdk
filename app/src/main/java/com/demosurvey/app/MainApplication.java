package com.demosurvey.app;

import android.app.Application;
import android.graphics.drawable.GradientDrawable;

import com.survey.sdk.Survey;


public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String param1 = "Complete the survey to join the draw!";
        String param2 = "Don't miss the chance!";
        String param3 = "param3";
        String param4 = "param4";
        String param5 = "parama5";
        Survey.init(this, param1, param2, param3, param4, param5);
        Survey.getInstance().enableLogging();
    }

}
