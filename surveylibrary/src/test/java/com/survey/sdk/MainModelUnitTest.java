package com.survey.sdk;

import android.content.Context;

import com.survey.sdk.model.ParamsModel;
import com.survey.sdk.ui.modelMVP.MainModel;
import com.survey.sdk.ui.presenter.MainPresenter;
import com.survey.sdk.ui.presenter.Presenter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MainModelUnitTest {
    final boolean[] result = {false};
    protected SurveyTestWrapper survey = new SurveyTestWrapper();
    protected Context context;

    @Test
    public void onRetrieveParamDataSurveySingletonParamsModelShouldBeReturned(){
        survey.init("title1", "title2", "title3", "title4", "title5");
        MainModel model = new MainModel(survey.getInstance().getParamsModel());
        ParamsModel params = model.retrieveParamsdata();
        Assert.assertEquals(params.getParam1(), "title1");
        Assert.assertEquals(params.getParam2(), "title2");
        Assert.assertEquals(params.getParam3(), "title3");
        Assert.assertEquals(params.getParam4(), "title4");
        Assert.assertEquals(params.getParam5(), "title5");
    }
    @Test
    public void onRetrieveSurveyWebLinkSingletonWebLinkShouldBeReturned(){
        survey.init("title1", "title2", "title3", "title4", "title5");
        MainModel model = new MainModel(survey.getInstance().getParamsModel());
        String link = Constants.LINK;
        Assert.assertEquals(model.retrieveSurveyLink(),link);
    }
}
