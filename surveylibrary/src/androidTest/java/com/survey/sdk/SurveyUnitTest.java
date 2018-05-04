package com.survey.sdk;


import android.test.AndroidTestCase;

import com.survey.sdk.logs.Logger;
import com.survey.sdk.model.ParamsModel;

public class SurveyUnitTest extends AndroidTestCase {

    protected SurveyTestWrapper survey;
    protected ParamsModel params;

    public SurveyUnitTest() {
        super();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        survey = SurveyTestWrapper.init(getContext(), "title1", "title2", "title3", "title4", "title5");
    }

}

