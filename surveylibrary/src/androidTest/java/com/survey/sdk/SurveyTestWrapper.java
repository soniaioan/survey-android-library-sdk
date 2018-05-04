package com.survey.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.survey.sdk.model.ParamsModel;
import com.survey.sdk.ui.view.SurveyWebViewListener;

/**
 * Created by dioannou on 19/2/2018.
 */

public class SurveyTestWrapper extends Survey {


    private static ParamsModel paramsModel;
    public static synchronized SurveyTestWrapper getInstance() {
        return survey;
    }
    private static SurveyTestWrapper survey = null;
    public static SurveyWebViewListener sSurveyWebViewListener;

    public SurveyTestWrapper() {
        super();
    }

    public static SurveyTestWrapper init(Context context, String param1, String param2, String param3, String param4, String param5) {
        survey = new SurveyTestWrapper();
        Survey.init(context, param1, param2, param3, param4, param5);
        survey.setParamsModel(param1, param2, param3, param4, param5);
        return survey;
    }

    public void registerSurveyWebViewListener(SurveyWebViewListener listener) {
        sSurveyWebViewListener = listener;
    }

    public static ParamsModel getParamsModel() {
        return paramsModel;
    }
}
