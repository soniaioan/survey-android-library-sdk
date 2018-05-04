package com.survey.sdk.ui.view;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.survey.sdk.R;
import com.survey.sdk.Survey;
import com.survey.sdk.logs.Logger;
import com.survey.sdk.model.ParamsModel;
import com.survey.sdk.ui.presenter.MainPresenter;



public class MainActivity extends BaseActivity implements View.OnClickListener, MainPresenter.MainPresenterView {
    ParamsModel paramsModel= Survey.getInstance().getParamsModel();
    MainPresenter presenter = new MainPresenter(this, paramsModel);
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_right);
        presenter.loadSurveyWebLink();
        presenter.loadSurveyParamsData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_webview;
    }


    @Override
    public void onClick(View v) {
        // Button click events, forwarding all actions to Presenter
        int viewId = v.getId();
        if (viewId== R.id.imageButton){
            Logger.d("User clicked close button of webview.");
            presenter.onCloseButtonClicked();
        }
    }

    public void onBackPressed() {
        Logger.d("User clicked back button.");
        presenter.onCloseButtonClicked();
    }

    @Override
    public void showLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            hideLoading();

        mProgressDialog = ProgressDialog.show(this, "Survey", "Please wait to load the survey page");
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) {
                mProgressDialog.dismiss();
                mProgressDialog = null;
        }
    }

    @Override
    public void loadSurveyWebView(String url) {
        WebView webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        webView.loadUrl(url);
        if (Survey.getInstance().getRegisteredInWebviewStatus()) {
            Logger.d("WebView opened");
            Survey.sSurveyWebViewListener.onOpenedSurveyWebView();
        }
    }

    @Override
    public void loadSurveyTextViewTitles(String param1, String param2) {
        TextView topTitle = (TextView) findViewById(R.id.textViewTop);
        TextView bottomTitle = (TextView) findViewById(R.id.textViewBottom);
        topTitle.setText(param1);
        bottomTitle.setText(param2);
    }

    @Override
    public void loadAdditionalParams(String param3, String param4, String param5) {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_right);
        if (Survey.getInstance().getRegisteredInWebviewStatus()) {
            Survey.sSurveyWebViewListener.onClosedSurveyWebView(param3, param4, param5);
        }
    }

}
