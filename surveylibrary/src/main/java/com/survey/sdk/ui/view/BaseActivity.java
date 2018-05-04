package com.survey.sdk.ui.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.survey.sdk.ui.presenter.Presenter;


public abstract class BaseActivity extends AppCompatActivity implements Presenter.View {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    public abstract int getLayoutId();

}
