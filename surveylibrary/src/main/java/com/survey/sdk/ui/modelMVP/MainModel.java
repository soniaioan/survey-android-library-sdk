package com.survey.sdk.ui.modelMVP;

import com.survey.sdk.Constants;
import com.survey.sdk.model.ParamsModel;


public class MainModel {
    private ParamsModel data;
    private String surveyWebLink;

    public MainModel(ParamsModel paramsModel) {
        data = paramsModel;
        surveyWebLink = Constants.LINK;
    }

    public ParamsModel retrieveParamsdata() {
        return data;
    }

    public String retrieveSurveyLink() {
        return surveyWebLink;
    }
}
