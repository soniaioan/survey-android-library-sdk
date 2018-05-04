package com.survey.sdk;

import android.content.Context;

import com.survey.sdk.ui.modelMVP.MainModel;
import com.survey.sdk.ui.presenter.MainPresenter;
import com.survey.sdk.ui.presenter.Presenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MainPresenterUnitTest {
    String[] passedParams;
    String passedUrl = null;
    protected SurveyTestWrapper survey = new SurveyTestWrapper();
    protected Context context;
    MainPresenter presenter;
    @Before
    public void beforeTest() {
        passedParams = new String[]{null, null, null};
        passedUrl = null;
        survey.init("title1", "title2", "title3", "title4", "title5");
        presenter = new MainPresenter(new MainPresenter.MainPresenterView() {
            @Override
            public void loadSurveyWebView(String url) {
                passedUrl = url;
            }

            @Override
            public void loadSurveyTextViewTitles(String param1, String param2) {
                passedParams[0] = param1;
                passedParams[1] = param2;
            }

            @Override
            public void loadAdditionalParams(String param3, String param4, String param5) {
                passedParams[0] = param3;
                passedParams[1] = param4;
                passedParams[2] = param5;
            }
        }, survey.getParamsModel());
    }
    @Test
    public void onCloseButtonClickInvokeLoadAdditionalParams(){
        presenter.onCloseButtonClicked();
        Assert.assertEquals(passedParams[0], "title3");
        Assert.assertEquals(passedParams[1], "title4");
        Assert.assertEquals(passedParams[2], "title5");
    }
    @Test
    public void onLoadSurveyWebLinkInvokeLoadWebViewUrl(){
        presenter.loadSurveyWebLink();
        Assert.assertEquals(passedUrl, Constants.LINK);
    }
    @Test
    public void onLoadSurveyParamsDataInvokeLoadTitles(){
        presenter.loadSurveyParamsData();
        Assert.assertEquals(passedParams[0], "title1");
        Assert.assertEquals(passedParams[1], "title2");
    }
}
