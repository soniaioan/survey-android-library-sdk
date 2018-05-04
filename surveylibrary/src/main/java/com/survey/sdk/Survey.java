package com.survey.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;


import com.survey.sdk.logs.Logger;
import com.survey.sdk.model.ParamsModel;
import com.survey.sdk.ui.view.MainActivity;
import com.survey.sdk.ui.view.SurveyWebViewListener;


public class Survey {
    //private constructor.
    private static volatile Survey sInstance = null;
    // The context passed into the constructor
    protected  Context mContext;
    protected static ParamsModel sParamsModel;
    public static SurveyWebViewListener sSurveyWebViewListener;

    public Boolean getRegisteredInWebviewStatus() {
        return isRegisteredInWebviewStatus;
    }

    public void setRegisteredInWebviewStatus(Boolean registeredInWebviewStatus) {
        isRegisteredInWebviewStatus = registeredInWebviewStatus;
    }

    protected Boolean isRegisteredInWebviewStatus = false;
    protected Survey() {

    }

    public static Survey getInstance() {
        return sInstance;
    }

    public static synchronized Survey init(Context context, String param1, String param2, String param3, String param4, String param5) {
        if (sInstance == null) {
            initAll(new Survey(), context, param1, param2, param3, param4, param5);
        }

        return sInstance;
    }

    protected static synchronized Survey initAll(Survey survey, Context context, String param1, String param2, String param3, String param4, String param5) {
        if (sInstance == null) {
            Logger.i("Initializing demo survey sdk...");
            sInstance = survey;
            sInstance.mContext = context;
            sParamsModel = new ParamsModel(param1, param2, param3, param4, param5);
        }else  {
            Logger.i("Demo Survey sdk already initialized");
        }
        return sInstance;
    }
    public void showSurveyContent() {
        Logger.i("Launch WebView Activity");
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    public static ParamsModel getParamsModel() {
        return sParamsModel;
    }


    public void setParamsModel(String param1, String param2, String param3, String param4, String param5) {
        sParamsModel = new ParamsModel(param1, param2, param3, param4, param5);
    }

    public void enableLogging() {
        Logger.setLog(true);
    }
    public void registerSurveyWebViewListener(SurveyWebViewListener listener) {
        isRegisteredInWebviewStatus = true;
        sSurveyWebViewListener = listener;
    }

    private boolean getMetaDataBoolean(String key) {
        boolean value = false;
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
            value = applicationInfo.metaData.getBoolean(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }

}
