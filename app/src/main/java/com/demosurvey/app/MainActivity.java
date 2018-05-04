package com.demosurvey.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.survey.sdk.Survey;
import com.survey.sdk.ui.view.SurveyWebViewListener;

public class MainActivity extends AppCompatActivity implements SurveyWebViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button surveyButton = (Button) findViewById(R.id.button);
        surveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Survey.getInstance().showSurveyContent();
            }
        });
        Survey.getInstance().registerSurveyWebViewListener(this);
    }

    @Override
    public void onOpenedSurveyWebView() {
        Toast toast = Toast.makeText(getApplicationContext(), "SurveyWebView opened", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClosedSurveyWebView(String param3, String param4, String param5) {
        String paramsString = String.format("SurveyWebView closed params:  %s , %s, %s ",param3, param4, param5);
        Toast toast = Toast.makeText(getApplicationContext(), paramsString, Toast.LENGTH_SHORT);
        toast.show();
    }
}

