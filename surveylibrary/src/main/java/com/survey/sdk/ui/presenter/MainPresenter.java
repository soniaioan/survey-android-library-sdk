package com.survey.sdk.ui.presenter;

import com.survey.sdk.model.ParamsModel;
import com.survey.sdk.ui.modelMVP.MainModel;



public class MainPresenter {
    MainPresenterView view;
    MainModel model;

    public MainPresenter(MainPresenterView view, ParamsModel paramsModel) {
       this.view = view;
       this.model = new MainModel(paramsModel);
    }

    public void loadSurveyWebLink() {
        view.loadSurveyWebView( model.retrieveSurveyLink());
    }

    public void loadSurveyParamsData() {
        String title1 = model.retrieveParamsdata().getParam1();
        String title2 =  model.retrieveParamsdata().getParam2();
        view.loadSurveyTextViewTitles(title1, title2);
    }

    public void onCloseButtonClicked() {
        String param3 = model.retrieveParamsdata().getParam3();
        String param4 =  model.retrieveParamsdata().getParam4();
        String param5 = model.retrieveParamsdata().getParam5();
        view.loadAdditionalParams(param3, param4, param5);
    }


    public interface MainPresenterView {

        void loadSurveyWebView(String link);

        void loadSurveyTextViewTitles(String param1, String Param2);

        void loadAdditionalParams(String param3, String param4, String param5);
    }

}
