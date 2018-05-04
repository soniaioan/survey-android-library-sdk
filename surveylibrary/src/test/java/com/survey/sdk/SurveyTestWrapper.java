package com.survey.sdk;


import com.survey.sdk.model.ParamsModel;


public class SurveyTestWrapper extends Survey{

    private static SurveyTestWrapper survey = null;
    private static ParamsModel paramsModel;
    public static synchronized SurveyTestWrapper getInstance() {
        return survey;
    }

    public static void init(String param1, String param2, String param3, String param4, String param5) {
        survey = new SurveyTestWrapper();
        paramsModel = new ParamsModel(param1,param2,param3,param4,param5);
    }

    public static ParamsModel getParamsModel() {
        return paramsModel;
    }

}
